package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.entities.Beneficiario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BeneficiarioDAO {

    public void inserir(Beneficiario b) throws Exception {
        String sql = "INSERT INTO T_TDB_BENEFICIARIO (ID_BENEFICIARIO, ID_PROGRAMA, NM_BENEFICIARIO, DT_NASCIMENTO, ENDERECO) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = new ConexaoFactory().conexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            String id = (b.getId() == null || b.getId().isEmpty()) ? java.util.UUID.randomUUID().toString() : b.getId();
            ps.setString(1, id);
            ps.setString(2, b.getIdPrograma());
            ps.setString(3, b.getNome());
            ps.setDate(4, Date.valueOf(b.getDtNascimento()));
            ps.setString(5, b.getEndereco());
            ps.executeUpdate();
            conn.commit();
        }
    }

    public List<Beneficiario> listarTodos() throws Exception {
        List<Beneficiario> lista = new ArrayList<>();
        String sql = "SELECT * FROM T_TDB_BENEFICIARIO";
        try (Connection conn = new ConexaoFactory().conexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Beneficiario(
                        rs.getString("ID_BENEFICIARIO"),
                        rs.getString("ID_PROGRAMA"),
                        rs.getString("NM_BENEFICIARIO"),
                        rs.getDate("DT_NASCIMENTO").toLocalDate(),
                        rs.getString("ENDERECO")
                ));
            }
        }
        return lista;
    }

    public void atualizar(Beneficiario b) throws Exception {
        String sql = "UPDATE T_TDB_BENEFICIARIO SET NM_BENEFICIARIO = ?, DT_NASCIMENTO = ?, ENDERECO = ? WHERE ID_BENEFICIARIO = ?";
        try (Connection conn = new ConexaoFactory().conexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, b.getNome());
            ps.setDate(2, Date.valueOf(b.getDtNascimento()));
            ps.setString(3, b.getEndereco());
            ps.setString(4, b.getId());
            ps.executeUpdate();
            conn.commit();
        }
    }

    public void deletar(String id) throws Exception {
        String sql = "DELETE FROM T_TDB_BENEFICIARIO WHERE ID_BENEFICIARIO = ?";
        try (Connection conn = new ConexaoFactory().conexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            ps.executeUpdate();
            conn.commit();
        }
    }

    public Beneficiario buscarPorId(String id) throws Exception {
        String sql = "SELECT * FROM T_TDB_BENEFICIARIO WHERE ID_BENEFICIARIO = ?";
        try (Connection conn = new ConexaoFactory().conexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Beneficiario(
                            rs.getString("ID_BENEFICIARIO"),
                            rs.getString("ID_PROGRAMA"),
                            rs.getString("NM_BENEFICIARIO"),
                            rs.getDate("DT_NASCIMENTO").toLocalDate(),
                            rs.getString("ENDERECO")
                    );
                }
            }
        }
        return null;
    }
}