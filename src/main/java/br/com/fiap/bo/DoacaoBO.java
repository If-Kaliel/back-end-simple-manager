package br.com.fiap.bo;

import br.com.fiap.dao.DoacaoDAO;
import br.com.fiap.entities.Doacao;
import java.util.List;

public class DoacaoBO {
    private DoacaoDAO dao;

    public DoacaoBO() throws Exception {
        this.dao = new DoacaoDAO();
    }

    public void registrar(Doacao d, String role) throws Exception {
        if (!"FUNCIONARIO".equals(role)) throw new Exception("Acesso negado.");
        if (d.getValor() <= 0) throw new Exception("Valor inválido.");
        dao.inserir(d);
    }

    public List<Doacao> listar(String role) throws Exception {
        if (!"FUNCIONARIO".equals(role)) throw new Exception("Acesso negado.");
        return dao.listarTodos();
    }

    public void atualizar(Doacao d, String role) throws Exception {
        if (!"FUNCIONARIO".equals(role)) throw new Exception("Acesso negado.");
        dao.atualizar(d);
    }

    public void excluir(String id, String role) throws Exception {
        if (!"FUNCIONARIO".equals(role)) throw new Exception("Acesso negado.");
        dao.deletar(id);
    }
}