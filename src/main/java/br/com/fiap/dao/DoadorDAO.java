package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.entities.Doador;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoadorDAO {
    private Connection conn;

    public DoadorDAO() throws Exception {
        this.conn = new ConexaoFactory().conexao();
    }

    public void inserir(Doador d) throws Exception {
        String sql = "INSERT INTO T_TDB_DOADOR (ID_DOADOR, NM_DOADOR, VL_DOACAO, CONTATO) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, d.getId());
            ps.setString(2, d.getNome());
            ps.setDouble(3, d.getVlDoacao());
            ps.setString(4, d.getContato());
            ps.execute();
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        }
    }

    public List<Doador> listarTodos() throws Exception {
        List<Doador> lista = new ArrayList<>();
        String sql = "SELECT * FROM T_TDB_DOADOR";
        try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Doador(
                        rs.getString("ID_DOADOR"),
                        rs.getString("NM_DOADOR"),
                        rs.getDouble("VL_DOACAO"),
                        rs.getString("CONTATO")
                ));
            }
        }
        return lista;
    }

    public void atualizar(Doador d) throws Exception {
        String sql = "UPDATE T_TDB_DOADOR SET NM_DOADOR = ?, VL_DOACAO = ?, CONTATO = ? WHERE ID_DOADOR = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, d.getNome());
            ps.setDouble(2, d.getVlDoacao());
            ps.setString(3, d.getContato());
            ps.setString(4, d.getId());
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        }
    }

    public void deletar(String id) throws Exception {
        String sql = "DELETE FROM T_TDB_DOADOR WHERE ID_DOADOR = ?";
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