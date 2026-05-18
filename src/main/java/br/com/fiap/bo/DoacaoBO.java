package br.com.fiap.bo;

import br.com.fiap.dao.DoacaoDAO;
import br.com.fiap.entities.Doacao;
import java.util.List;

public class DoacaoBO {
    private DoacaoDAO dao = new DoacaoDAO();

    public void cadastrar(Doacao d) throws Exception {
        dao.inserir(d);
    }

    public List<Doacao> listar() throws Exception {
        return dao.listar();
    }

    public void atualizar(Doacao d) throws Exception {
        dao.atualizar(d);
    }

    public void remover(String id) throws Exception {
        dao.remover(id);
    }
}