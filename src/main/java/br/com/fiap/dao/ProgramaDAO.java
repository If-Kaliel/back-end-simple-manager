package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.entities.Programa;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProgramaDAO {
    private final String TABELA = "T_TDB_PROGRAMA_SOCIAL";

    public List<Programa> listar() throws Exception {
        List<Programa> lista = new ArrayList<>();
        String sql = "SELECT * FROM " + TABELA;
        try (Connection conn = new ConexaoFactory().conexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Programa(rs.getString("ID_PROGRAMA"), rs.getString("NM_PROGRAMA")));
            }
        }
        return lista;
    }

    public void inserir(Programa p) throws Exception {
        String sql = "INSERT INTO " + TABELA + " (ID_PROGRAMA, NM_PROGRAMA) VALUES (?, ?)";
        try (Connection conn = new ConexaoFactory().conexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getId());
            ps.setString(2, p.getNome());
            ps.executeUpdate();
            conn.commit();
        }
    }

    public void atualizar(Programa p) throws Exception {
        String sql = "UPDATE " + TABELA + " SET NM_PROGRAMA = ? WHERE ID_PROGRAMA = ?";
        try (Connection conn = new ConexaoFactory().conexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getNome());
            ps.setString(2, p.getId());
            ps.executeUpdate();
            conn.commit();
        }
    }

    public void deletar(String id) throws Exception {
        String sql = "DELETE FROM " + TABELA + " WHERE ID_PROGRAMA = ?";
        try (Connection conn = new ConexaoFactory().conexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            ps.executeUpdate();
            conn.commit();
        }
    }
}