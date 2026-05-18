package br.com.fiap.bo;

import br.com.fiap.dao.DentistaDAO;
import br.com.fiap.entities.Dentista;
import java.util.List;

public class DentistaBO {
    private DentistaDAO dao;

    public DentistaBO() throws Exception {
        this.dao = new DentistaDAO();
    }

    public void cadastrar(Dentista d, String role) throws Exception {
        if (!"FUNCIONARIO".equals(role)) throw new Exception("Acesso Negado.");
        dao.inserir(d);
    }

    public List<Dentista> listar(String role) throws Exception {
        return dao.listarTodos();
    }

    public void atualizar(Dentista d, String role) throws Exception {
        if (!"FUNCIONARIO".equals(role)) throw new Exception("Acesso Negado.");
        dao.atualizar(d);
    }

    public void excluir(String id, String role) throws Exception {
        if (!"FUNCIONARIO".equals(role)) throw new Exception("Acesso Negado.");
        dao.deletar(id);
    }
}