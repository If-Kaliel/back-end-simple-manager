package br.com.fiap.bo;

import br.com.fiap.dao.ContatoDAO;
import br.com.fiap.entities.Contato;
import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.time.LocalDateTime;
import java.util.UUID;

@ApplicationScoped
public class ContatoBO {

    @Inject
    Mailer mailer;

    // Se o seu ContatoDAO tiver um construtor padrão (sem argumentos),
    // certifique-se de que ele existe lá.
    public ContatoBO() {}

    public void processarContato(Contato c) throws Exception {
        c.setId(UUID.randomUUID().toString());
        c.setDtEnvio(LocalDateTime.now());

        // Tenta enviar o e-mail
        if (mailer != null) {
            mailer.send(
                    Mail.withText("kaliel.aquino1303@gmail.com",
                            "Contato via Site: " + c.getNome(),
                            "De: " + c.getEmail() + "\n\nMensagem: " + c.getMensagem())
            );
        }

        // Instancia o DAO e insere
        ContatoDAO dao = new ContatoDAO();
        dao.inserir(c);
    }
    public void atualizar(Contato c) throws Exception {
        new ContatoDAO().atualizar(c);
    }

    public void deletar(String id) throws Exception {
        new ContatoDAO().deletar(id);
    }

    public java.util.List<Contato> listarTodos() throws Exception {
        return new ContatoDAO().listarTodos();
    }
}