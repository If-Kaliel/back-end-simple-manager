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
    public Response listar(@HeaderParam("role") String role) {
        try {
            return Response.ok(bo.listar(role)).build();
        } catch (Exception e) {
            return Response.status(403).entity(e.getMessage()).build();
        }
    }

    @POST
    public Response cadastrar(Procedimento p, @HeaderParam("role") String role) {
        try {
            bo.cadastrar(p, role);
            return Response.status(201).build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") String id, Procedimento p, @HeaderParam("role") String role) {
        try {
            p.setId(id);
            bo.atualizar(p, role);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") String id, @HeaderParam("role") String role) {
        try {
            bo.excluir(id, role);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }
}