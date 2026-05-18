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
    public Response listar(@HeaderParam("role") String role) {
        try {
            return Response.ok(bo.listar(role)).build();
        } catch (Exception e) {
            return Response.status(403).entity(e.getMessage()).build();
        }
    }

    @POST
    public Response registrar(Doacao d, @HeaderParam("role") String role) {
        try {
            bo.registrar(d, role);
            return Response.status(201).build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") String id, Doacao d, @HeaderParam("role") String role) {
        try {
            d.setId(id);
            bo.atualizar(d, role);
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