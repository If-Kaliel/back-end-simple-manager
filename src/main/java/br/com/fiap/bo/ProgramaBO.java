package br.com.fiap.bo;

import br.com.fiap.dao.ProgramaDAO;
import br.com.fiap.entities.Programa;
import java.util.List;

public class ProgramaBO {
    private ProgramaDAO dao = new ProgramaDAO();

    public List<Programa> listar() throws Exception { return dao.listar(); }
    public void cadastrar(Programa p) throws Exception { dao.inserir(p); }
    public void atualizar(Programa p) throws Exception { dao.atualizar(p); }
    public void deletar(String id) throws Exception { dao.deletar(id); }
}