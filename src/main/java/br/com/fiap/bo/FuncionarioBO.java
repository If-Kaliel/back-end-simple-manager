package br.com.fiap.bo;

import br.com.fiap.dao.FuncionarioDAO;
import br.com.fiap.entities.Funcionario;
import java.util.List;

public class FuncionarioBO {
    private FuncionarioDAO dao;

    public FuncionarioBO() throws Exception {
        this.dao = new FuncionarioDAO();
    }

    public List<Funcionario> listar() throws Exception {
        return dao.listarTodos();
    }

    public void cadastrar(Funcionario f) throws Exception {
        if (f == null) throw new Exception("Dados do funcionário não podem ser nulos.");
        dao.inserir(f);
    }

    public void atualizar(Funcionario f) throws Exception {
        dao.atualizar(f);
    }

    public void remover(String id) throws Exception {
        dao.deletar(id);
    }
}