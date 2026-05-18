package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.entities.Triagem;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TriagemDAO {
    private Connection conn;

    public TriagemDAO() throws Exception {
        this.conn = new ConexaoFactory().conexao();
    }

    public void inserir(Triagem t) throws Exception {
        String sql = "INSERT INTO T_TDB_TRIAGEM (ID_TRIAGEM, ID_BENEFICIARIO, DT_TRIAGEM, NECESSIDADE, PRIORIDADE) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, t.getId());
            ps.setString(2, t.getIdBeneficiario());
            ps.setDate(3, Date.valueOf(t.getDtTriagem()));
            ps.setString(4, t.getNecessidade());
            ps.setString(5, t.getPrioridade());
            ps.execute();
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        }
    }

    public List<Triagem> listarTodos() throws Exception {
        List<Triagem> lista = new ArrayList<>();
        String sql = "SELECT * FROM T_TDB_TRIAGEM";
        try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Triagem(
                        rs.getString("ID_TRIAGEM"),
                        rs.getString("ID_BENEFICIARIO"),
                        rs.getDate("DT_TRIAGEM").toLocalDate(),
                        rs.getString("NECESSIDADE"),
                        rs.getString("PRIORIDADE")
                ));
            }
        }
        return lista;
    }

    public void atualizar(Triagem t) throws Exception {
        String sql = "UPDATE T_TDB_TRIAGEM SET NECESSIDADE = ?, PRIORIDADE = ? WHERE ID_TRIAGEM = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, t.getNecessidade());
            ps.setString(2, t.getPrioridade());
            ps.setString(3, t.getId());
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        }
    }

    public void deletar(String id) throws Exception {
        String sql = "DELETE FROM T_TDB_TRIAGEM WHERE ID_TRIAGEM = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        }
    }
}