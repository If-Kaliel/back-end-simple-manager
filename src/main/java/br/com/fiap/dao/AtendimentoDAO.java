package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.entities.Atendimento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AtendimentoDAO {
    public void inserir(Atendimento a) throws Exception {
        String sql = "INSERT INTO T_TDB_ATENDIMENTO (ID_ATENDIMENTO, ID_DENTISTA, ID_BENEFICIARIO, ID_PROGRAMA, DT_HORA, DESCRICAO_TRATAMENTO, CRONOGRAMA_PROCEDIMENTOS, STATUS) VALUES (SQ_ATENDIMENTO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = new ConexaoFactory().conexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, a.getIdDentista());
            ps.setString(2, a.getIdBeneficiario());
            ps.setString(3, a.getIdPrograma());
            ps.setTimestamp(4, Timestamp.valueOf(a.getDtHora()));
            ps.setString(5, a.getDescricaoTratamento());
            ps.setString(6, a.getCronogramaProcedimentos());
            ps.setString(7, a.getStatus());
            ps.executeUpdate();
            conn.commit();
        }
    }

    public List<Atendimento> listar() throws Exception {
        List<Atendimento> lista = new ArrayList<>();
        String sql = "SELECT * FROM T_TDB_ATENDIMENTO";
        try (Connection conn = new ConexaoFactory().conexao(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Atendimento(rs.getString("ID_ATENDIMENTO"), rs.getString("ID_DENTISTA"), rs.getString("ID_BENEFICIARIO"), rs.getString("ID_PROGRAMA"), rs.getTimestamp("DT_HORA").toLocalDateTime(), rs.getString("DESCRICAO_TRATAMENTO"), rs.getString("CRONOGRAMA_PROCEDIMENTOS"), rs.getString("STATUS")));
            }
        }
        return lista;
    }

    public void atualizar(Atendimento a) throws Exception {
        String sql = "UPDATE T_TDB_ATENDIMENTO SET ID_DENTISTA=?, ID_BENEFICIARIO=?, ID_PROGRAMA=?, DT_HORA=?, DESCRICAO_TRATAMENTO=?, CRONOGRAMA_PROCEDIMENTOS=?, STATUS=? WHERE ID_ATENDIMENTO=?";
        try (Connection conn = new ConexaoFactory().conexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, a.getIdDentista());
            ps.setString(2, a.getIdBeneficiario());
            ps.setString(3, a.getIdPrograma());
            ps.setTimestamp(4, Timestamp.valueOf(a.getDtHora()));
            ps.setString(5, a.getDescricaoTratamento());
            ps.setString(6, a.getCronogramaProcedimentos());
            ps.setString(7, a.getStatus());
            ps.setString(8, a.getId());
            ps.executeUpdate();
            conn.commit();
        }
    }

    public void remover(String id) throws Exception {
        String sql = "DELETE FROM T_TDB_ATENDIMENTO WHERE ID_ATENDIMENTO = ?";
        try (Connection conn = new ConexaoFactory().conexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            ps.executeUpdate();
            conn.commit();
        }
    }
}