package br.com.fiap.bo;

import br.com.fiap.dao.FuncionarioDAO;
import br.com.fiap.entities.Funcionario;
import java.util.List;

public class FuncionarioBO {
    private FuncionarioDAO dao;

    public FuncionarioBO() throws Exception {
        this.dao = new FuncionarioDAO();
    }

    public void cadastrar(Funcionario f, String role) throws Exception {
        if (!"ADMIN".equals(role)) throw new Exception("Apenas administradores cadastram funcionários.");
        dao.inserir(f);
    }

    public List<Funcionario> listar(String role) throws Exception {
        if (!"ADMIN".equals(role) && !"FUNCIONARIO".equals(role)) throw new Exception("Acesso negado.");
        return dao.listarTodos();
    }

    public void atualizar(Funcionario f, String role) throws Exception {
        if (!"ADMIN".equals(role)) throw new Exception("Acesso negado.");
        dao.atualizar(f);
    }

    public void excluir(String id, String role) throws Exception {
        if (!"ADMIN".equals(role)) throw new Exception("Acesso negado.");
        dao.deletar(id);
    }
}