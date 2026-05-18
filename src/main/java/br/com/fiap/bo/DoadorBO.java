package br.com.fiap.bo;

import br.com.fiap.dao.DoadorDAO;
import br.com.fiap.entities.Doador;
import java.util.List;

public class DoadorBO {
    private DoadorDAO dao;

    public DoadorBO() throws Exception {
        this.dao = new DoadorDAO();
    }

    public void cadastrar(Doador d, String role) throws Exception {
        // Apenas funcionários registram doadores oficialmente
        if (!"FUNCIONARIO".equals(role)) throw new Exception("Acesso Negado.");
        if (d.getVlDoacao() <= 0) throw new Exception("Valor da doação deve ser positivo.");
        dao.inserir(d);
    }

    public List<Doador> listar(String role) throws Exception {
        if (!"FUNCIONARIO".equals(role)) throw new Exception("Acesso Negado.");
        return dao.listarTodos();
    }

    public void atualizar(Doador d, String role) throws Exception {
        if (!"FUNCIONARIO".equals(role)) throw new Exception("Acesso Negado.");
        dao.atualizar(d);
    }

    public void excluir(String id, String role) throws Exception {
        if (!"FUNCIONARIO".equals(role)) throw new Exception("Acesso Negado.");
        dao.deletar(id);
    }
}