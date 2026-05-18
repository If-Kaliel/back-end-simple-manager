package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.entities.Contato;
import java.sql.*;

public class ContatoDAO {
    private Connection conn;

    public ContatoDAO() throws Exception {
        this.conn = new ConexaoFactory().conexao();
    }

    public void inserir(Contato c) throws Exception {
        String sql = "INSERT INTO T_TDB_CONTATO (ID_CONTATO, NM_CONTATO, DS_EMAIL, DS_MENSAGEM, DT_ENVIO) VALUES (?, ?, ?, ?, ?)";


        ConexaoFactory factory = new ConexaoFactory();

        try (Connection conn = factory.conexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, c.getId());
            ps.setString(2, c.getNome());
            ps.setString(3, c.getEmail());
            ps.setString(4, c.getMensagem());
            ps.setTimestamp(5, java.sql.Timestamp.valueOf(c.getDtEnvio()));

            ps.executeUpdate();

            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Erro ao salvar no banco: " + e.getMessage());
        }
    }
    public void atualizar(Contato c) throws Exception {
        String sql = "UPDATE T_TDB_CONTATO SET NM_CONTATO=?, DS_EMAIL=?, DS_MENSAGEM=? WHERE ID_CONTATO=?";
        try (Connection conn = new ConexaoFactory().conexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getNome());
            ps.setString(2, c.getEmail());
            ps.setString(3, c.getMensagem());
            ps.setString(4, c.getId());
            ps.executeUpdate();
            conn.commit();
        }
    }

    public void deletar(String id) throws Exception {
        String sql = "DELETE FROM T_TDB_CONTATO WHERE ID_CONTATO=?";
        try (Connection conn = new ConexaoFactory().conexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            ps.executeUpdate();
            conn.commit();
        }
    }

    public java.util.List<Contato> listarTodos() throws Exception {
        String sql = "SELECT * FROM T_TDB_CONTATO";
        java.util.List<Contato> lista = new java.util.ArrayList<>();
        try (Connection conn = new ConexaoFactory().conexao(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Contato(rs.getString("ID_CONTATO"), rs.getString("NM_CONTATO"), rs.getString("DS_EMAIL"), rs.getString("DS_MENSAGEM"), rs.getTimestamp("DT_ENVIO").toLocalDateTime()));
            }
        }
        return lista;
    }
}