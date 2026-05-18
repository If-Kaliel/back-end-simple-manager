package br.com.fiap.bo;

import br.com.fiap.dao.ApoloniaDAO;
import br.com.fiap.entities.Apolonia;
import java.util.List;

public class ApoloniaBO {
    private ApoloniaDAO dao;

    public ApoloniaBO() throws Exception {
        this.dao = new ApoloniaDAO();
    }

    private void validarAcesso(String role) throws Exception {
        if (role == null || (!"ADMIN".equalsIgnoreCase(role.trim()) && !"FUNCIONARIO".equalsIgnoreCase(role.trim()))) {
            throw new Exception("Acesso negado.");
        }
    }

    public List<Apolonia> listar(String role) throws Exception {
        if (role == null) throw new Exception("Role obrigatoria.");
        return dao.listarTodas();
    }

    public void cadastrar(Apolonia a, String role) throws Exception {
        validarAcesso(role);
        if (a.getId() == null || a.getNome() == null) throw new Exception("Dados incompletos.");
        dao.inserir(a);
    }

    public void atualizar(Apolonia a, String role) throws Exception {
        validarAcesso(role);
        dao.atualizar(a);
    }

    public void remover(String id, String role) throws Exception {
        validarAcesso(role);
        dao.excluir(id);
    }
}