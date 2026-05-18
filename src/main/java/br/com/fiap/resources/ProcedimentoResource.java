package br.com.fiap.resources;

import br.com.fiap.bo.ProcedimentoBO;
import br.com.fiap.entities.Procedimento;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("/procedimentos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProcedimentoResource {
    private ProcedimentoBO bo;

    public ProcedimentoResource() {
        try { this.bo = new ProcedimentoBO(); } catch (Exception e) { e.printStackTrace(); }
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
    public Response cadastrar(Procedimento p) {
        try {
            bo.cadastrar(p);
            return Response.status(201).build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") String id, Procedimento p) {
        try {
            p.setId(id);
            bo.atualizar(p);
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