package br.com.fiap.dao;
import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.entities.Doacao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoacaoDAO {
    public void inserir(Doacao d) throws Exception {
        String sql = "INSERT INTO T_TDB_DOACAO (ID_DOACAO, ID_DOADOR, VALOR_DOACAO, DT_DOACAO, FORMA_PAGAMENTO, PERIODICIDADE_PAGAMENTO) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = new ConexaoFactory().conexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, d.getId());
            ps.setString(2, d.getIdDoador());
            ps.setDouble(3, d.getValorDoacao());
            ps.setDate(4, Date.valueOf(d.getDtDoacao()));
            ps.setString(5, d.getFormaPagamento());
            ps.setString(6, d.getPeriodicidadePagamento());
            ps.executeUpdate();
            conn.commit();
        }
    }

    public List<Doacao> listar() throws Exception {
        List<Doacao> lista = new ArrayList<>();
        String sql = "SELECT * FROM T_TDB_DOACAO";
        try (Connection conn = new ConexaoFactory().conexao(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Doacao(rs.getString("ID_DOACAO"), rs.getString("ID_DOADOR"), rs.getDouble("VALOR_DOACAO"), rs.getDate("DT_DOACAO").toLocalDate(), rs.getString("FORMA_PAGAMENTO"), rs.getString("PERIODICIDADE_PAGAMENTO")));
            }
        }
        return lista;
    }

    public void atualizar(Doacao d) throws Exception {
        String sql = "UPDATE T_TDB_DOACAO SET ID_DOADOR=?, VALOR_DOACAO=?, DT_DOACAO=?, FORMA_PAGAMENTO=?, PERIODICIDADE_PAGAMENTO=? WHERE ID_DOACAO=?";
        try (Connection conn = new ConexaoFactory().conexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, d.getIdDoador());
            ps.setDouble(2, d.getValorDoacao());
            ps.setDate(3, Date.valueOf(d.getDtDoacao()));
            ps.setString(4, d.getFormaPagamento());
            ps.setString(5, d.getPeriodicidadePagamento());
            ps.setString(6, d.getId());
            ps.executeUpdate();
            conn.commit();
        }
    }

    public void remover(String id) throws Exception {
        try (Connection conn = new ConexaoFactory().conexao(); PreparedStatement ps = conn.prepareStatement("DELETE FROM T_TDB_DOACAO WHERE ID_DOACAO = ?")) {
            ps.setString(1, id);
            ps.executeUpdate();
            conn.commit();
        }
    }
}