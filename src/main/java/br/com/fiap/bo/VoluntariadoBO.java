package br.com.fiap.bo;

import br.com.fiap.dao.VoluntariadoDAO;
import br.com.fiap.entities.Voluntariado;
import java.util.List;

public class VoluntariadoBO {
    private VoluntariadoDAO dao;

    public VoluntariadoBO() throws Exception {
        this.dao = new VoluntariadoDAO();
    }

    public void cadastrar(Voluntariado v, String role) throws Exception {
        if (!"FUNCIONARIO".equals(role)) throw new Exception("Acesso negado.");
        if (v.getNome() == null || v.getNome().length() < 3) throw new Exception("Nome inválido.");
        dao.inserir(v);
    }

    public List<Voluntariado> listar(String role) throws Exception {
        // Funcionários e Dentistas podem ver a lista de voluntários
        if (!"FUNCIONARIO".equals(role) && !"DENTISTA".equals(role)) throw new Exception("Acesso negado.");
        return dao.listarTodos();
    }

    public void atualizar(Voluntariado v, String role) throws Exception {
        if (!"FUNCIONARIO".equals(role)) throw new Exception("Acesso negado.");
        dao.atualizar(v);
    }

    public void excluir(String id, String role) throws Exception {
        if (!"FUNCIONARIO".equals(role)) throw new Exception("Acesso negado.");
        dao.deletar(id);
    }
}