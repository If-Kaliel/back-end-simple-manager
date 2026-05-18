package br.com.fiap.bo;

import br.com.fiap.dao.ContatoDAO;
import br.com.fiap.entities.Contato;
import java.util.List;

public class ContatoBO {
    private ContatoDAO dao;

    public ContatoBO() throws Exception {
        this.dao = new ContatoDAO();
    }

    public List<Contato> listar() throws Exception {
        return dao.listarTodos();
    }

    public void cadastrar(Contato c) throws Exception {
        if (c == null) throw new Exception("Dados do contato não podem ser nulos.");
        dao.inserir(c);
    }

    public void atualizar(Contato c) throws Exception {
        dao.atualizar(c);
    }

    public void remover(String id) throws Exception {
        dao.deletar(id);
    }
}