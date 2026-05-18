package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.entities.Doacao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoacaoDAO {
    private Connection conn;

    public DoacaoDAO() throws Exception {
        this.conn = new ConexaoFactory().conexao();
    }

    public void inserir(Doacao d) throws Exception {
        String sql = "INSERT INTO T_TDB_DOACAO (ID_DOACAO, ID_DOADOR, VL_DOACAO, DT_DOACAO) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, d.getId());
            ps.setString(2, d.getIdDoador());
            ps.setDouble(3, d.getValor());
            ps.setDate(4, Date.valueOf(d.getDtDoacao()));
            ps.execute();
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        }
    }

    public List<Doacao> listarTodos() throws Exception {
        List<Doacao> lista = new ArrayList<>();
        String sql = "SELECT * FROM T_TDB_DOACAO";
        try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Doacao(
                        rs.getString("ID_DOACAO"),
                        rs.getString("ID_DOADOR"),
                        rs.getDouble("VL_DOACAO"),
                        rs.getDate("DT_DOACAO").toLocalDate()
                ));
            }
        }
        return lista;
    }

    public void atualizar(Doacao d) throws Exception {
        String sql = "UPDATE T_TDB_DOACAO SET VL_DOACAO = ?, DT_DOACAO = ? WHERE ID_DOACAO = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, d.getValor());
            ps.setDate(2, Date.valueOf(d.getDtDoacao()));
            ps.setString(3, d.getId());
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        }
    }

    public void deletar(String id) throws Exception {
        String sql = "DELETE FROM T_TDB_DOACAO WHERE ID_DOACAO = ?";
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