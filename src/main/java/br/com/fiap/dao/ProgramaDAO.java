package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.entities.Programa;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProgramaDAO {
    private Connection conn;

    public ProgramaDAO() throws Exception {
        this.conn = new ConexaoFactory().conexao();
    }

    public void inserir(Programa p) throws Exception {
        String sql = "INSERT INTO T_TDB_PROGRAMA (ID_PROGRAMA, NM_PROGRAMA, OBJETIVO) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getId());
            ps.setString(2, p.getNome());
            ps.setString(3, p.getObjetivo());
            ps.execute();
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        }
    }

    public List<Programa> listarTodos() throws Exception {
        List<Programa> lista = new ArrayList<>();
        String sql = "SELECT * FROM T_TDB_PROGRAMA";
        try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Programa(
                        rs.getString("ID_PROGRAMA"),
                        rs.getString("NM_PROGRAMA"),
                        rs.getString("OBJETIVO")
                ));
            }
        }
        return lista;
    }

    public void atualizar(Programa p) throws Exception {
        String sql = "UPDATE T_TDB_PROGRAMA SET NM_PROGRAMA = ?, OBJETIVO = ? WHERE ID_PROGRAMA = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getNome());
            ps.setString(2, p.getObjetivo());
            ps.setString(3, p.getId());
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        }
    }

    public void deletar(String id) throws Exception {
        String sql = "DELETE FROM T_TDB_PROGRAMA WHERE ID_PROGRAMA = ?";
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