package br.com.fiap.dao;
import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.entities.Triagem;
import java.sql.*;
import java.util.*;

public class TriagemDAO {
    public void inserir(Triagem t) throws Exception {
        String sql = "INSERT INTO T_TDB_TRIAGEM (ID_TRIAGEM, DT_HR, ID_DENTISTA, ID_BENEFICIARIO, DS_PRIORIDADE, DS_LOCAL) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = new ConexaoFactory().conexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, t.getId());
            ps.setTimestamp(2, Timestamp.valueOf(t.getDtHr()));
            ps.setString(3, t.getIdDentista());
            ps.setString(4, t.getIdBeneficiario());
            ps.setString(5, t.getDsPrioridade());
            ps.setString(6, t.getDsLocal());
            ps.executeUpdate();
            conn.commit();
        }
    }
    public List<Triagem> listar() throws Exception {
        List<Triagem> lista = new ArrayList<>();
        try (Connection conn = new ConexaoFactory().conexao(); PreparedStatement ps = conn.prepareStatement("SELECT * FROM T_TDB_TRIAGEM"); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) lista.add(new Triagem(rs.getString("ID_TRIAGEM"), rs.getTimestamp("DT_HR").toLocalDateTime(), rs.getString("ID_DENTISTA"), rs.getString("ID_BENEFICIARIO"), rs.getString("DS_PRIORIDADE"), rs.getString("DS_LOCAL")));
        }
        return lista;
    }
    public void atualizar(Triagem t) throws Exception {
        try (Connection conn = new ConexaoFactory().conexao(); PreparedStatement ps = conn.prepareStatement("UPDATE T_TDB_TRIAGEM SET DT_HR=?, ID_DENTISTA=?, ID_BENEFICIARIO=?, DS_PRIORIDADE=?, DS_LOCAL=? WHERE ID_TRIAGEM=?")) {
            ps.setTimestamp(1, Timestamp.valueOf(t.getDtHr()));
            ps.setString(2, t.getIdDentista());
            ps.setString(3, t.getIdBeneficiario());
            ps.setString(4, t.getDsPrioridade());
            ps.setString(5, t.getDsLocal());
            ps.setString(6, t.getId());
            ps.executeUpdate();
            conn.commit();
        }
    }
    public void remover(String id) throws Exception {
        try (Connection conn = new ConexaoFactory().conexao(); PreparedStatement ps = conn.prepareStatement("DELETE FROM T_TDB_TRIAGEM WHERE ID_TRIAGEM = ?")) {
            ps.setString(1, id);
            ps.executeUpdate();
            conn.commit();
        }
    }
}