package br.com.fiap.bo;

import br.com.fiap.dao.AtendimentoDAO;
import br.com.fiap.entities.Atendimento;
import java.util.List;

public class AtendimentoBO {
    private AtendimentoDAO dao;

    public AtendimentoBO() throws Exception {
        this.dao = new AtendimentoDAO();
    }

    public void cadastrar(Atendimento a, String role) throws Exception {
        // Apenas Dentistas ou Funcionários registram atendimentos
        if (!"DENTISTA".equals(role) && !"FUNCIONARIO".equals(role)) throw new Exception("Acesso negado.");
        dao.inserir(a);
    }

    public List<Atendimento> listar(String role) throws Exception {
        return dao.listarTodos();
    }

    public void atualizar(Atendimento a, String role) throws Exception {
        if (!"DENTISTA".equals(role)) throw new Exception("Apenas o dentista pode alterar o diagnóstico.");
        dao.atualizar(a);
    }

    public void excluir(String id, String role) throws Exception {
        if (!"FUNCIONARIO".equals(role)) throw new Exception("Apenas funcionários podem excluir registros de atendimento.");
        dao.deletar(id);
    }
}