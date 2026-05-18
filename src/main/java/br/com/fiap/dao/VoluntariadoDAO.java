package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.entities.Voluntariado;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VoluntariadoDAO {
    private Connection conn;

    public VoluntariadoDAO() throws Exception {
        this.conn = new ConexaoFactory().conexao();
    }

    public void inserir(Voluntariado v) throws Exception {
        String sql = "INSERT INTO T_TDB_VOLUNTARIADO (ID_VOLUNTARIADO, ID_PROGRAMA, NM_VOLUNTARIO, TP_SERVICO) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, v.getId());
            ps.setString(2, v.getIdPrograma());
            ps.setString(3, v.getNome());
            ps.setString(4, v.getTipoServico());
            ps.execute();
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        }
    }

    public List<Voluntariado> listarTodos() throws Exception {
        List<Voluntariado> lista = new ArrayList<>();
        String sql = "SELECT * FROM T_TDB_VOLUNTARIADO";
        try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Voluntariado(
                        rs.getString("ID_VOLUNTARIADO"),
                        rs.getString("ID_PROGRAMA"),
                        rs.getString("NM_VOLUNTARIO"),
                        rs.getString("TP_SERVICO")
                ));
            }
        }
        return lista;
    }

    public void atualizar(Voluntariado v) throws Exception {
        String sql = "UPDATE T_TDB_VOLUNTARIADO SET NM_VOLUNTARIO = ?, TP_SERVICO = ? WHERE ID_VOLUNTARIADO = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, v.getNome());
            ps.setString(2, v.getTipoServico());
            ps.setString(3, v.getId());
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        }
    }

    public void deletar(String id) throws Exception {
        String sql = "DELETE FROM T_TDB_VOLUNTARIADO WHERE ID_VOLUNTARIADO = ?";
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