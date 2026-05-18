package br.com.fiap.resources;

import br.com.fiap.bo.ApoloniaBO;
import br.com.fiap.entities.Apolonia;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("/apolonias")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ApoloniaResource {
    private ApoloniaBO bo;

    public ApoloniaResource() {
        try {
            this.bo = new ApoloniaBO();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GET
    public Response listar() {
        try {
            // Removido o envio do 'role'
            return Response.ok(bo.listar()).build();
        } catch (Exception e) {
            // Mudei de 403 (Proibido) para 400/500, já que não tem mais bloqueio de acesso
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @POST
    public Response cadastrar(Apolonia a) {
        try {
            bo.cadastrar(a);
            return Response.status(201).build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") String id, Apolonia a) {
        try {
            a.setId(id);
            bo.atualizar(a);
            return Response.ok("{\"status\": \"Sucesso\"}").build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") String id) {
        try {
            bo.remover(id);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }
}