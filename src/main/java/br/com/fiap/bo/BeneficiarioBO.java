package br.com.fiap.bo;

import br.com.fiap.dao.BeneficiarioDAO;
import br.com.fiap.entities.Beneficiario;
import java.util.List;

public class BeneficiarioBO {
    private BeneficiarioDAO dao;

    public BeneficiarioBO() throws Exception {
        this.dao = new BeneficiarioDAO();
    }

    public List<Beneficiario> listar() throws Exception {
        return dao.listarTodos();
    }

    public Beneficiario buscar(String id) throws Exception {
        return dao.buscarPorId(id);
    }

    public void cadastrar(Beneficiario b) throws Exception {
        if (b == null) throw new Exception("Dados do beneficiário não podem ser nulos.");
        dao.inserir(b);
    }

    public void atualizar(Beneficiario b) throws Exception {
        dao.atualizar(b);
    }

    public void remover(String id) throws Exception {
        dao.deletar(id);
    }
}