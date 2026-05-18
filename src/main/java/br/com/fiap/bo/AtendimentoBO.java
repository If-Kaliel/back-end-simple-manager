package br.com.fiap.bo;
import br.com.fiap.dao.AtendimentoDAO;
import br.com.fiap.entities.Atendimento;
import java.util.List;

public class AtendimentoBO {
    private AtendimentoDAO dao = new AtendimentoDAO();
    public void cadastrar(Atendimento a) throws Exception { dao.inserir(a); }
    public List<Atendimento> listar() throws Exception { return dao.listar(); }
    public void atualizar(Atendimento a) throws Exception { dao.atualizar(a); }
    public void remover(String id) throws Exception { dao.remover(id); }
}