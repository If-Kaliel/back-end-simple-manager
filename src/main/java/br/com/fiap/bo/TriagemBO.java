package br.com.fiap.bo;

import br.com.fiap.dao.TriagemDAO;
import br.com.fiap.entities.Triagem;
import java.util.List;

public class TriagemBO {
    private TriagemDAO dao;

    public TriagemBO() throws Exception {
        this.dao = new TriagemDAO();
    }

    public void cadastrar(Triagem t, String role) throws Exception {
        if (!"FUNCIONARIO".equals(role) && !"DENTISTA".equals(role)) throw new Exception("Acesso negado.");
        dao.inserir(t);
    }

    public List<Triagem> listar(String role) throws Exception {
        return dao.listarTodos();
    }

    public void atualizar(Triagem t, String role) throws Exception {
        if (!"FUNCIONARIO".equals(role)) throw new Exception("Apenas funcionários editam triagens.");
        dao.atualizar(t);
    }

    public void excluir(String id, String role) throws Exception {
        if (!"FUNCIONARIO".equals(role)) throw new Exception("Apenas funcionários excluem triagens.");
        dao.deletar(id);
    }
}