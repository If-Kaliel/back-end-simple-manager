package br.com.fiap.resources;

import br.com.fiap.bo.VoluntariadoBO;
import br.com.fiap.entities.Voluntariado;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("/voluntariados")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VoluntariadoResource {
    private VoluntariadoBO bo;

    public VoluntariadoResource() {
        try { this.bo = new VoluntariadoBO(); } catch (Exception e) { e.printStackTrace(); }
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
    public Response cadastrar(Voluntariado v, @HeaderParam("role") String role) {
        try {
            bo.cadastrar(v, role);
            return Response.status(201).build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") String id, Voluntariado v, @HeaderParam("role") String role) {
        try {
            v.setId(id);
            bo.atualizar(v, role);
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