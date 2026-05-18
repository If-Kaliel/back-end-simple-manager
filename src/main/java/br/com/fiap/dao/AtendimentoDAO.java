package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.entities.Atendimento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AtendimentoDAO {
    private Connection conn;

    public AtendimentoDAO() throws Exception {
        this.conn = new ConexaoFactory().conexao();
    }

    public void inserir(Atendimento a) throws Exception {
        String sql = "INSERT INTO T_TDB_ATENDIMENTO (ID_ATENDIMENTO, ID_DENTISTA, ID_BENEFICIARIO, ID_TRIAGEM, DT_ATENDIMENTO, DIAGNOSTICO) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, a.getId());
            ps.setString(2, a.getIdDentista());
            ps.setString(3, a.getIdBeneficiario());
            ps.setString(4, a.getIdTriagem());
            ps.setDate(5, Date.valueOf(a.getDtAtendimento()));
            ps.setString(6, a.getDiagnostico());
            ps.execute();
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        }
    }

    public List<Atendimento> listarTodos() throws Exception {
        List<Atendimento> lista = new ArrayList<>();
        String sql = "SELECT * FROM T_TDB_ATENDIMENTO";
        try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Atendimento(
                        rs.getString("ID_ATENDIMENTO"),
                        rs.getString("ID_DENTISTA"),
                        rs.getString("ID_BENEFICIARIO"),
                        rs.getString("ID_TRIAGEM"),
                        rs.getDate("DT_ATENDIMENTO").toLocalDate(),
                        rs.getString("DIAGNOSTICO")
                ));
            }
        }
        return lista;
    }

    public void atualizar(Atendimento a) throws Exception {
        String sql = "UPDATE T_TDB_ATENDIMENTO SET DIAGNOSTICO = ? WHERE ID_ATENDIMENTO = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, a.getDiagnostico());
            ps.setString(2, a.getId());
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        }
    }

    public void deletar(String id) throws Exception {
        String sql = "DELETE FROM T_TDB_ATENDIMENTO WHERE ID_ATENDIMENTO = ?";
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