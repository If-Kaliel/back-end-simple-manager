package br.com.fiap.dao;
import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.entities.Doador;
import java.sql.*;
import java.util.*;

public class DoadorDAO {
    public void inserir(Doador d) throws Exception {
        String sql = "INSERT INTO T_TDB_DOADOR (ID_DOADOR, NM_DOADOR, EMAIL) VALUES (?, ?, ?)";
        try (Connection conn = new ConexaoFactory().conexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, d.getId());
            ps.setString(2, d.getNmDoador());
            ps.setString(3, d.getEmail());
            ps.executeUpdate();
            conn.commit();
        }
    }
    public List<Doador> listar() throws Exception {
        List<Doador> lista = new ArrayList<>();
        try (Connection conn = new ConexaoFactory().conexao(); PreparedStatement ps = conn.prepareStatement("SELECT * FROM T_TDB_DOADOR"); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) lista.add(new Doador(rs.getString("ID_DOADOR"), rs.getString("NM_DOADOR"), rs.getString("EMAIL")));
        }
        return lista;
    }
    public void atualizar(Doador d) throws Exception {
        try (Connection conn = new ConexaoFactory().conexao(); PreparedStatement ps = conn.prepareStatement("UPDATE T_TDB_DOADOR SET NM_DOADOR=?, EMAIL=? WHERE ID_DOADOR=?")) {
            ps.setString(1, d.getNmDoador());
            ps.setString(2, d.getEmail());
            ps.setString(3, d.getId());
            ps.executeUpdate();
            conn.commit();
        }
    }
    public void remover(String id) throws Exception {
        try (Connection conn = new ConexaoFactory().conexao(); PreparedStatement ps = conn.prepareStatement("DELETE FROM T_TDB_DOADOR WHERE ID_DOADOR = ?")) {
            ps.setString(1, id);
            ps.executeUpdate();
            conn.commit();
        }
    }
}