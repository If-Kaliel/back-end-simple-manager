package br.com.fiap.dao;

import br.com.fiap.dto.RelatorioGeralDTO;
import java.sql.*;

public class DatabaseAdminDAO {

    private Connection getConnection() throws Exception {
        String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
        // Usuário e senha (020106) configurados
        return DriverManager.getConnection(url, "RM567587", "020106");
    }

    public RelatorioGeralDTO obterEstatisticasGerais() throws Exception {
        RelatorioGeralDTO dto = new RelatorioGeralDTO();

        // A query completa que busca os dados das suas 9 tabelas
        String sql = "SELECT " +
                "(SELECT COUNT(*) FROM T_TDB_BENEFICIARIO) as tot_ben, " +
                "(SELECT COUNT(*) FROM T_TDB_BENEFICIARIO WHERE ID_PROGRAMA = 'P2') as tot_apo, " +
                "(SELECT COUNT(*) FROM T_TDB_DENTISTA) as tot_den, " +
                "(SELECT COUNT(*) FROM T_TDB_ATENDIMENTO) as tot_ate, " +
                "(SELECT COUNT(*) FROM T_TDB_DOADOR) as tot_dor, " +
                "(SELECT SUM(VALOR_DOACAO) FROM T_TDB_DOACAO) as val_total " +
                "FROM DUAL";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                dto.totalBeneficiarios = rs.getLong("tot_ben");
                dto.totalApolonias = rs.getLong("tot_apo");
                dto.totalDentistas = rs.getLong("tot_den");
                dto.totalAtendimentos = rs.getLong("tot_ate");
                dto.totalDoadores = rs.getLong("tot_dor");
                dto.valorTotalArrecadado = rs.getDouble("val_total");
            }
        }
        return dto;
    }

    public void limparTudo() throws Exception {

        // Agora o wipe limpa as tabelas principais em ordem de restrição (FK)

        try (Connection conn = getConnection();
             Statement st = conn.createStatement()) {
            st.executeUpdate("DELETE FROM T_TDB_PROCEDIMENTO");
            st.executeUpdate("DELETE FROM T_TDB_ATENDIMENTO");
            st.executeUpdate("DELETE FROM T_TDB_DOACAO");

        }
    }
}