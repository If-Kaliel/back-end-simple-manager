package br.com.fiap.bo;

import br.com.fiap.dao.BeneficiarioDAO;
import br.com.fiap.entities.Beneficiario;
import br.com.fiap.services.ViaCepService;
import java.util.List;

public class BeneficiarioBO {
    private BeneficiarioDAO dao;
    private ViaCepService viaCep = new ViaCepService();

    public BeneficiarioBO() throws Exception {
        this.dao = new BeneficiarioDAO();
    }

    public void cadastrar(Beneficiario b, String role) throws Exception {
        // Validação de segurança flexível
        if (role == null || !role.equalsIgnoreCase("ADMIN")) {
            throw new Exception("Acesso Negado.");
        }
        // Se o endereço for um CEP (8 dígitos), busca na API
        if (b.getEndereco() != null && b.getEndereco().matches("\\d{8}")) {
            var end = viaCep.buscarEndereco(b.getEndereco());
            if (end != null) b.setEndereco(end.toString());
        }
        dao.inserir(b);
    }

    public List<Beneficiario> listar(String role) throws Exception {
        // Validação de segurança flexível
        if (role == null || !role.equalsIgnoreCase("ADMIN")) {
            throw new Exception("Acesso Negado.");
        }
        return dao.listarTodos();
    }

    public void atualizar(Beneficiario b, String role) throws Exception {
        // Validação de segurança flexível
        if (role == null || !role.equalsIgnoreCase("ADMIN")) {
            throw new Exception("Acesso Negado.");
        }
        // Faltava chamar o DAO e fechar a chave!
        dao.atualizar(b);
    }

    public void excluir(String id, String role) throws Exception {
        // Corrigido para ADMIN, padronizando com o resto do sistema
        if (role == null || !role.equalsIgnoreCase("ADMIN")) {
            throw new Exception("Acesso Negado. Apenas ADMIN pode excluir.");
        }
        dao.deletar(id);
    }
}