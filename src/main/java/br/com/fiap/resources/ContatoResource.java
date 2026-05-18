package br.com.fiap.resources;

import br.com.fiap.bo.ContatoBO;
import br.com.fiap.entities.Contato;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("/contato")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContatoResource {

    @Inject
    ContatoBO bo;

    @POST
    public Response enviar(Contato c) {
        try {
            // Processa o envio de e-mail e salvamento no banco
            bo.processarContato(c);

            // Retorna 201 Created se tudo ocorrer bem
            return Response.status(201).entity("Mensagem enviada com sucesso!").build();
        } catch (Exception e) {
            // Retorna 400 Bad Request se houver erro
            return Response.status(400).entity(e.getMessage()).build();
        }
    }
    @GET
    public Response listar() {
        try {
            return Response.ok(bo.listarTodos()).build();
        } catch (Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") String id, Contato c) {
        try {
            c.setId(id);
            bo.atualizar(c);
            return Response.ok("Atualizado com sucesso!").build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") String id) {
        try {
            bo.deletar(id);
            return Response.ok("Deletado com sucesso!").build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }
}