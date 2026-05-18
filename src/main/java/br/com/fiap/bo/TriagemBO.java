package br.com.fiap.bo;

import br.com.fiap.dao.TriagemDAO;
import br.com.fiap.entities.Triagem;
import java.util.List;

public class TriagemBO {
    private TriagemDAO dao = new TriagemDAO();

    public void cadastrar(Triagem t) throws Exception {
        dao.inserir(t);
    }

    public List<Triagem> listar() throws Exception {
        return dao.listar();
    }

    public void atualizar(Triagem t) throws Exception {
        dao.atualizar(t);
    }

    public void remover(String id) throws Exception {
        dao.remover(id);
    }
}