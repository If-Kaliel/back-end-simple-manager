package br.com.fiap.resources;

import br.com.fiap.bo.AtendimentoBO;
import br.com.fiap.entities.Atendimento;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("/atendimentos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AtendimentoResource {
    private AtendimentoBO bo;

    public AtendimentoResource() {
        try { this.bo = new AtendimentoBO(); } catch (Exception e) { e.printStackTrace(); }
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
    public Response cadastrar(Atendimento a, @HeaderParam("role") String role) {
        try {
            bo.cadastrar(a, role);
            return Response.status(201).build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") String id, Atendimento a, @HeaderParam("role") String role) {
        try {
            a.setId(id);
            bo.atualizar(a, role);
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