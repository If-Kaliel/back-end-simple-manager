package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.entities.Apolonia;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ApoloniaDAO {

    public void inserir(Apolonia a) throws Exception {
        String sql = "INSERT INTO T_TDB_BENEFICIARIO (ID_BENEFICIARIO, ID_PROGRAMA, NM_BENEFICIARIO, DT_NASCIMENTO, ENDERECO) VALUES (?, 'P2', ?, TO_DATE(?, 'DD/MM/YYYY'), ?)";
        try (Connection conn = new ConexaoFactory().conexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, a.getId());
            ps.setString(2, a.getNome());
            ps.setString(3, a.getDtNascimento());
            ps.setString(4, a.getEndereco());
            ps.executeUpdate();
            conn.commit();
        }
    }

    public List<Apolonia> listarTodas() throws Exception {
        List<Apolonia> lista = new ArrayList<>();
        String sql = "SELECT * FROM T_TDB_BENEFICIARIO WHERE ID_PROGRAMA = 'P2'";
        try (Connection conn = new ConexaoFactory().conexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Apolonia ap = new Apolonia(
                        rs.getString("ID_BENEFICIARIO"),
                        rs.getString("NM_BENEFICIARIO"),
                        rs.getDate("DT_NASCIMENTO") != null ? rs.getDate("DT_NASCIMENTO").toString() : null,
                        rs.getString("ENDERECO")
                );
                lista.add(ap);
            }
        }
        return lista;
    }

    public void atualizar(Apolonia a) throws Exception {
        String sql = "UPDATE T_TDB_BENEFICIARIO SET NM_BENEFICIARIO = ?, DT_NASCIMENTO = TO_DATE(?, 'YYYY-MM-DD'), ENDERECO = ? WHERE ID_BENEFICIARIO = ? AND ID_PROGRAMA = 'P2'";
        try (Connection conn = new ConexaoFactory().conexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, a.getNome());
            ps.setString(2, a.getDtNascimento());
            ps.setString(3, a.getEndereco());
            ps.setString(4, a.getId());
            ps.executeUpdate();
            conn.commit();
        }
    }

    public void excluir(String id) throws Exception {
        String sql = "DELETE FROM T_TDB_BENEFICIARIO WHERE ID_BENEFICIARIO = ? AND ID_PROGRAMA = 'P2'";
        try (Connection conn = new ConexaoFactory().conexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            ps.executeUpdate();
            conn.commit();
        }
    }
}