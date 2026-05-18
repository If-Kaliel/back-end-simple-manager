package br.com.fiap.resources;

import br.com.fiap.bo.DoacaoBO;
import br.com.fiap.entities.Doacao;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("/doacoes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DoacaoResource {
    private DoacaoBO bo;

    public DoacaoResource() {
        try { this.bo = new DoacaoBO(); } catch (Exception e) { e.printStackTrace(); }
    }

    @GET
    public Response listar() {
        try {
            return Response.ok(bo.listar()).build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @POST
    public Response registrar(Doacao d) {
        try {
            bo.cadastrar(d);
            return Response.status(201).build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") String id, Doacao d) {
        try {
            d.setId(id);
            bo.atualizar(d);
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