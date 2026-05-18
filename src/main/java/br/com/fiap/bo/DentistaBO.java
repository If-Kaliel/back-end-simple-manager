package br.com.fiap.bo;

import br.com.fiap.dao.DentistaDAO;
import br.com.fiap.entities.Dentista;
import java.util.List;

public class DentistaBO {
    private DentistaDAO dao;

    public DentistaBO() throws Exception {
        this.dao = new DentistaDAO();
    }

    public List<Dentista> listar() throws Exception {
        return dao.listarTodos();
    }

    public void cadastrar(Dentista d) throws Exception {
        if (d == null) throw new Exception("Dados do dentista não podem ser nulos.");
        dao.inserir(d);
    }

    public void atualizar(Dentista d) throws Exception {
        dao.atualizar(d);
    }

    public void remover(String id) throws Exception {
        dao.deletar(id);
    }
}