package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.entities.Procedimento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProcedimentoDAO {
    public void inserir(Procedimento p) throws Exception {
        String sql = "INSERT INTO T_TDB_PROCEDIMENTO (ID_PROCEDIMENTO, ID_ATENDIMENTO, NM_PROCEDIMENTO, DURACAO) VALUES (SQ_PROCEDIMENTO.NEXTVAL, ?, ?, ?)";
        try (Connection conn = new ConexaoFactory().conexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getIdAtendimento());
            ps.setString(2, p.getNmProcedimento());
            ps.setString(3, p.getDuracao());
            ps.executeUpdate();
            conn.commit();
        }
    }

    public List<Procedimento> listar() throws Exception {
        List<Procedimento> lista = new ArrayList<>();
        try (Connection conn = new ConexaoFactory().conexao(); PreparedStatement ps = conn.prepareStatement("SELECT * FROM T_TDB_PROCEDIMENTO"); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) lista.add(new Procedimento(rs.getString("ID_PROCEDIMENTO"), rs.getString("ID_ATENDIMENTO"), rs.getString("NM_PROCEDIMENTO"), rs.getString("DURACAO")));
        }
        return lista;
    }

    public void atualizar(Procedimento p) throws Exception {
        try (Connection conn = new ConexaoFactory().conexao(); PreparedStatement ps = conn.prepareStatement("UPDATE T_TDB_PROCEDIMENTO SET ID_ATENDIMENTO=?, NM_PROCEDIMENTO=?, DURACAO=? WHERE ID_PROCEDIMENTO=?")) {
            ps.setString(1, p.getIdAtendimento());
            ps.setString(2, p.getNmProcedimento());
            ps.setString(3, p.getDuracao());
            ps.setString(4, p.getId());
            ps.executeUpdate();
            conn.commit();
        }
    }

    public void remover(String id) throws Exception {
        try (Connection conn = new ConexaoFactory().conexao(); PreparedStatement ps = conn.prepareStatement("DELETE FROM T_TDB_PROCEDIMENTO WHERE ID_PROCEDIMENTO = ?")) {
            ps.setString(1, id);
            ps.executeUpdate();
            conn.commit();
        }
    }
}