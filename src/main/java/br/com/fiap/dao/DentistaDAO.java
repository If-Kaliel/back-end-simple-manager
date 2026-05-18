package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.entities.Dentista;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DentistaDAO {
    private Connection conn;

    public DentistaDAO() throws Exception {
        this.conn = new ConexaoFactory().conexao();
    }

    public void inserir(Dentista d) throws Exception {
        String sql = "INSERT INTO T_TDB_DENTISTA (ID_DENTISTA, NM_DENTISTA, CRO, ESPECIALIDADE) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, d.getId());
            ps.setString(2, d.getNome());
            ps.setString(3, d.getCro());
            ps.setString(4, d.getEspecialidade());
            ps.execute();
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        }
    }

    public List<Dentista> listarTodos() throws Exception {
        List<Dentista> lista = new ArrayList<>();
        String sql = "SELECT * FROM T_TDB_DENTISTA";
        try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Dentista(
                        rs.getString("ID_DENTISTA"),
                        rs.getString("NM_DENTISTA"),
                        rs.getString("CRO"),
                        rs.getString("ESPECIALIDADE")
                ));
            }
        }
        return lista;
    }

    public void atualizar(Dentista d) throws Exception {
        String sql = "UPDATE T_TDB_DENTISTA SET NM_DENTISTA = ?, CRO = ?, ESPECIALIDADE = ? WHERE ID_DENTISTA = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, d.getNome());
            ps.setString(2, d.getCro());
            ps.setString(3, d.getEspecialidade());
            ps.setString(4, d.getId());
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        }
    }

    public void deletar(String id) throws Exception {
        String sql = "DELETE FROM T_TDB_DENTISTA WHERE ID_DENTISTA = ?";
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