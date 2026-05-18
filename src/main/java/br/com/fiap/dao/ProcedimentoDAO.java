package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.entities.Procedimento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProcedimentoDAO {
    private Connection conn;

    public ProcedimentoDAO() throws Exception {
        this.conn = new ConexaoFactory().conexao();
    }

    public void inserir(Procedimento p) throws Exception {
        String sql = "INSERT INTO T_TDB_PROCEDIMENTO (ID_PROCEDIMENTO, ID_ATENDIMENTO, DS_PROCEDIMENTO, VL_PROCEDIMENTO) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getId());
            ps.setString(2, p.getIdAtendimento());
            ps.setString(3, p.getDescricao());
            ps.setDouble(4, p.getValor());
            ps.execute();
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        }
    }

    public List<Procedimento> listarTodos() throws Exception {
        List<Procedimento> lista = new ArrayList<>();
        String sql = "SELECT * FROM T_TDB_PROCEDIMENTO";
        try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Procedimento(
                        rs.getString("ID_PROCEDIMENTO"),
                        rs.getString("ID_ATENDIMENTO"),
                        rs.getString("DS_PROCEDIMENTO"),
                        rs.getDouble("VL_PROCEDIMENTO")
                ));
            }
        }
        return lista;
    }

    public void atualizar(Procedimento p) throws Exception {
        String sql = "UPDATE T_TDB_PROCEDIMENTO SET DS_PROCEDIMENTO = ?, VL_PROCEDIMENTO = ? WHERE ID_PROCEDIMENTO = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getDescricao());
            ps.setDouble(2, p.getValor());
            ps.setString(3, p.getId());
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        }
    }

    public void deletar(String id) throws Exception {
        String sql = "DELETE FROM T_TDB_PROCEDIMENTO WHERE ID_PROCEDIMENTO = ?";
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