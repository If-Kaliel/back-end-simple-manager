package br.com.fiap.bo;

import br.com.fiap.dao.DoadorDAO;
import br.com.fiap.entities.Doador;
import java.util.List;

public class DoadorBO {
    private DoadorDAO dao = new DoadorDAO();

    public void cadastrar(Doador d) throws Exception {
        dao.inserir(d);
    }

    public List<Doador> listar() throws Exception {
        return dao.listar();
    }

    public void atualizar(Doador d) throws Exception {
        dao.atualizar(d);
    }

    public void remover(String id) throws Exception {
        dao.remover(id);
    }
}