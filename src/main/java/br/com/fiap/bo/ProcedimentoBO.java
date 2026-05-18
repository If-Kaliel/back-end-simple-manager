package br.com.fiap.bo;

import br.com.fiap.dao.ProcedimentoDAO;
import br.com.fiap.entities.Procedimento;
import java.util.List;

public class ProcedimentoBO {
    private ProcedimentoDAO dao = new ProcedimentoDAO();

    public void cadastrar(Procedimento p) throws Exception {
        dao.inserir(p);
    }

    public List<Procedimento> listar() throws Exception {
        return dao.listar();
    }

    public void atualizar(Procedimento p) throws Exception {
        dao.atualizar(p);
    }

    public void remover(String id) throws Exception {
        dao.remover(id);
    }
}