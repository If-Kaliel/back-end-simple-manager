package br.com.fiap.bo;

import br.com.fiap.dao.ApoloniaDAO;
import br.com.fiap.entities.Apolonia;
import java.util.List;

public class ApoloniaBO {
    private ApoloniaDAO dao;

    public ApoloniaBO() throws Exception {
        this.dao = new ApoloniaDAO();
    }

    public List<Apolonia> listar() throws Exception {
        return dao.listarTodas();
    }

    public void cadastrar(Apolonia a) throws Exception {
        // Mantemos apenas a validação de dados da entidade!
        if (a.getId() == null || a.getNome() == null) {
            throw new Exception("Dados incompletos.");
        }
        dao.inserir(a);
    }

    public void atualizar(Apolonia a) throws Exception {
        dao.atualizar(a);
    }

    public void remover(String id) throws Exception {
        dao.excluir(id);
    }
}