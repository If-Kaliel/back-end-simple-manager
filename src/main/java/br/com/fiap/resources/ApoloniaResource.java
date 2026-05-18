package br.com.fiap.resources;

import br.com.fiap.bo.ApoloniaBO;
import br.com.fiap.entities.Apolonia;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.util.List;

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
    public Response listar(@HeaderParam("role") String role) {
        try {
            return Response.ok(bo.listar(role)).build();
        } catch (Exception e) {
            return Response.status(403).entity(e.getMessage()).build();
        }
    }

    @POST
    public Response cadastrar(Apolonia a, @HeaderParam("role") String role) {
        try {
            bo.cadastrar(a, role);
            return Response.status(201).build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") String id, Apolonia a, @HeaderParam("role") String role) {
        try {
            a.setId(id);
            bo.atualizar(a, role);
            return Response.ok("{\"status\": \"Sucesso\"}").build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") String id, @HeaderParam("role") String role) {
        try {
            bo.remover(id, role);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }
}