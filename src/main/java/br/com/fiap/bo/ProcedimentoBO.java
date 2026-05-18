package br.com.fiap.bo;

import br.com.fiap.dao.ProcedimentoDAO;
import br.com.fiap.entities.Procedimento;
import java.util.List;

public class ProcedimentoBO {
    private ProcedimentoDAO dao;

    public ProcedimentoBO() throws Exception {
        this.dao = new ProcedimentoDAO();
    }

    public void cadastrar(Procedimento p, String role) throws Exception {
        if (!"DENTISTA".equals(role) && !"FUNCIONARIO".equals(role)) throw new Exception("Acesso negado.");
        if (p.getValor() < 0) throw new Exception("Valor não pode ser negativo.");
        dao.inserir(p);
    }

    public List<Procedimento> listar(String role) throws Exception {
        return dao.listarTodos();
    }

    public void atualizar(Procedimento p, String role) throws Exception {
        if (!"FUNCIONARIO".equals(role)) throw new Exception("Apenas funcionários editam valores de procedimentos.");
        dao.atualizar(p);
    }

    public void excluir(String id, String role) throws Exception {
        if (!"FUNCIONARIO".equals(role)) throw new Exception("Acesso negado.");
        dao.deletar(id);
    }
}