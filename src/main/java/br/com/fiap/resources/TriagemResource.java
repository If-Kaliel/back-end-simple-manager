package br.com.fiap.resources;

import br.com.fiap.bo.TriagemBO;
import br.com.fiap.entities.Triagem;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("/triagens")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TriagemResource {
    private TriagemBO bo;

    public TriagemResource() {
        try { this.bo = new TriagemBO(); } catch (Exception e) { e.printStackTrace(); }
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
    public Response cadastrar(Triagem t, @HeaderParam("role") String role) {
        try {
            bo.cadastrar(t, role);
            return Response.status(201).build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") String id, Triagem t, @HeaderParam("role") String role) {
        try {
            t.setId(id);
            bo.atualizar(t, role);
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