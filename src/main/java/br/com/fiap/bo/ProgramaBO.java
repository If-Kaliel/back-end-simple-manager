package br.com.fiap.bo;

import br.com.fiap.dao.ProgramaDAO;
import br.com.fiap.entities.Programa;
import java.util.List;

public class ProgramaBO {
    private ProgramaDAO dao;

    public ProgramaBO() throws Exception {
        this.dao = new ProgramaDAO();
    }

    public void cadastrar(Programa p, String role) throws Exception {
        if (!"FUNCIONARIO".equals(role)) throw new Exception("Acesso Negado.");
        if (p.getNome() == null || p.getNome().isEmpty()) throw new Exception("Nome do programa é obrigatório.");
        dao.inserir(p);
    }

    public List<Programa> listar(String role) throws Exception {
        // Dentistas e Funcionários podem ver os programas disponíveis
        if (!"FUNCIONARIO".equals(role) && !"DENTISTA".equals(role)) throw new Exception("Acesso Negado.");
        return dao.listarTodos();
    }

    public void atualizar(Programa p, String role) throws Exception {
        if (!"FUNCIONARIO".equals(role)) throw new Exception("Apenas funcionários editam programas.");
        dao.atualizar(p);
    }

    public void excluir(String id, String role) throws Exception {
        if (!"FUNCIONARIO".equals(role)) throw new Exception("Apenas funcionários excluem programas.");
        dao.deletar(id);
    }
}