package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.entities.Beneficiario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BeneficiarioDAO {

    public BeneficiarioDAO() throws Exception {}

    // 1. CREATE
    public void inserir(Beneficiario b) throws Exception {
        String sql = "INSERT INTO T_TDB_BENEFICIARIO (ID_BENEFICIARIO, ID_PROGRAMA, NM_BENEFICIARIO, DT_NASCIMENTO, ENDERECO) VALUES (?, ?, ?, ?, ?)";

        try (Connection conexao = new ConexaoFactory().conexao()) {
            conexao.setAutoCommit(false);

            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                // Previne erro de ID Nulo no Oracle gerando um UUID se necessário
                String id = (b.getId() == null || b.getId().isEmpty()) ? java.util.UUID.randomUUID().toString() : b.getId();

                ps.setString(1, id);
                ps.setString(2, b.getIdPrograma());
                ps.setString(3, b.getNome());
                ps.setDate(4, Date.valueOf(b.getDtNascimento()));
                ps.setString(5, b.getEndereco());

                ps.executeUpdate();
            }

            conexao.commit(); // Confirma a transação no Oracle
        } catch (SQLException e) {
            throw new Exception("Erro do Oracle ao inserir Beneficiário: " + e.getMessage());
        }
    }

    // 2. READ (Lista Todos)
    public List<Beneficiario> listarTodos() throws Exception {
        List<Beneficiario> lista = new ArrayList<>();
        String sql = "SELECT * FROM T_TDB_BENEFICIARIO";

        try (Connection conexao = new ConexaoFactory().conexao();
             PreparedStatement ps = conexao.prepareStatement(sql);
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
        } catch (SQLException e) {
            throw new Exception("Erro do Oracle ao listar Beneficiários: " + e.getMessage());
        }
        return lista;
    }

    // 3. UPDATE
    public void atualizar(Beneficiario b) throws Exception {
        String sql = "UPDATE T_TDB_BENEFICIARIO SET NM_BENEFICIARIO = ?, DT_NASCIMENTO = ?, ENDERECO = ? WHERE ID_BENEFICIARIO = ?";

        try (Connection conexao = new ConexaoFactory().conexao()) {
            conexao.setAutoCommit(false);

            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                ps.setString(1, b.getNome());
                ps.setDate(2, Date.valueOf(b.getDtNascimento()));
                ps.setString(3, b.getEndereco());
                ps.setString(4, b.getId());
                ps.executeUpdate();
            }

            conexao.commit();
        } catch (SQLException e) {
            throw new Exception("Erro do Oracle ao atualizar Beneficiário: " + e.getMessage());
        }
    }

    // 4. DELETE
    public void deletar(String id) throws Exception {
        String sql = "DELETE FROM T_TDB_BENEFICIARIO WHERE ID_BENEFICIARIO = ?";

        try (Connection conexao = new ConexaoFactory().conexao()) {
            conexao.setAutoCommit(false);

            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                ps.setString(1, id);
                ps.executeUpdate();
            }

            conexao.commit();
        } catch (SQLException e) {
            throw new Exception("Erro do Oracle ao deletar Beneficiário: " + e.getMessage());
        }
    }

    // Método auxiliar para busca por ID
    public Beneficiario buscarPorId(String id) throws Exception {
        String sql = "SELECT * FROM T_TDB_BENEFICIARIO WHERE ID_BENEFICIARIO = ?";

        try (Connection conexao = new ConexaoFactory().conexao();
             PreparedStatement ps = conexao.prepareStatement(sql)) {

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
        } catch (SQLException e) {
            throw new Exception("Erro do Oracle ao buscar Beneficiário: " + e.getMessage());
        }
        return null;
    }
}