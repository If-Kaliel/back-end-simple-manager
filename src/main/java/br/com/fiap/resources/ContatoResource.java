package br.com.fiap.resources;

import br.com.fiap.bo.ContatoBO;
import br.com.fiap.entities.Contato;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("/contato")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContatoResource {

    private ContatoBO bo;

    // Construtor manual igual às outras Resources (substituindo o @Inject)
    public ContatoResource() {
        try {
            this.bo = new ContatoBO();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GET
    public Response listar() {
        try {
            return Response.ok(bo.listar()).build();
        } catch (Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

    @POST
    public Response enviar(Contato c) {
        try {
            bo.cadastrar(c);
            return Response.status(201).entity("Mensagem enviada com sucesso!").build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
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
            bo.remover(id);
            return Response.ok("Deletado com sucesso!").build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }
}