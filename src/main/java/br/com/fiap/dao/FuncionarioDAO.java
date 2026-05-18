package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.entities.Funcionario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    public void inserir(Funcionario f) throws Exception {
        String sql = "INSERT INTO T_TDB_FUNCIONARIO (ID_FUNCIONARIO, NM_FUNCIONARIO, CARGO) VALUES (?, ?, ?)";
        try (Connection conn = new ConexaoFactory().conexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            String id = (f.getId() == null || f.getId().isEmpty()) ? java.util.UUID.randomUUID().toString() : f.getId();
            ps.setString(1, id);
            ps.setString(2, f.getNome());
            ps.setString(3, f.getCargo());
            ps.executeUpdate();
            conn.commit();
        }
    }

    public List<Funcionario> listarTodos() throws Exception {
        List<Funcionario> lista = new ArrayList<>();
        String sql = "SELECT * FROM T_TDB_FUNCIONARIO";
        try (Connection conn = new ConexaoFactory().conexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Funcionario(
                        rs.getString("ID_FUNCIONARIO"),
                        rs.getString("NM_FUNCIONARIO"),
                        rs.getString("CARGO")
                ));
            }
        }
        return lista;
    }

    public void atualizar(Funcionario f) throws Exception {
        String sql = "UPDATE T_TDB_FUNCIONARIO SET NM_FUNCIONARIO = ?, CARGO = ? WHERE ID_FUNCIONARIO = ?";
        try (Connection conn = new ConexaoFactory().conexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, f.getNome());
            ps.setString(2, f.getCargo());
            ps.setString(3, f.getId());
            ps.executeUpdate();
            conn.commit();
        }
    }

    public void deletar(String id) throws Exception {
        String sql = "DELETE FROM T_TDB_FUNCIONARIO WHERE ID_FUNCIONARIO = ?";
        try (Connection conn = new ConexaoFactory().conexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            ps.executeUpdate();
            conn.commit();
        }
    }
}