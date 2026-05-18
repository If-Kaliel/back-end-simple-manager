package br.com.fiap.bo;

import br.com.fiap.dao.DatabaseAdminDAO;
import br.com.fiap.dto.RelatorioGeralDTO;

public class AdminBO {
    private DatabaseAdminDAO dao;

    public AdminBO() throws Exception {
        this.dao = new DatabaseAdminDAO();
    }

    public RelatorioGeralDTO gerarDashboard(String role) throws Exception {
        if (!"ADMIN".equalsIgnoreCase(role)) throw new Exception("Não autorizado");

        RelatorioGeralDTO dto = dao.obterEstatisticasGerais();
        dto.statusBanco = "OPERACIONAL";
        return dto;
    }

    public void executarWipe(String role) throws Exception {
        if (!"ADMIN".equalsIgnoreCase(role)) throw new Exception("Não autorizado");
        dao.limparTudo();
    }
}