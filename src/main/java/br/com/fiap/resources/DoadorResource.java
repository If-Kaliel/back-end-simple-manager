package br.com.fiap.resources;

import br.com.fiap.bo.DoadorBO;
import br.com.fiap.entities.Doador;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("/doadores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DoadorResource {
    private DoadorBO bo;

    public DoadorResource() {
        try { this.bo = new DoadorBO(); } catch (Exception e) { e.printStackTrace(); }
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
    public Response cadastrar(Doador d) {
        try {
            bo.cadastrar(d);
            return Response.status(201).build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") String id, Doador d) {
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