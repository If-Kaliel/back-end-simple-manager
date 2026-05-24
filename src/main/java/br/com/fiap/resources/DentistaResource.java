package br.com.fiap.resources;

import br.com.fiap.bo.DentistaBO;
import br.com.fiap.entities.Dentista;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("/dentistas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DentistaResource {
    private DentistaBO bo;

    public DentistaResource() {
        try { this.bo = new DentistaBO(); } catch (Exception e) { e.printStackTrace(); }
    }

    @GET
    public Response listar() {
        try {
            return Response.ok(bo.listar()).build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") String id) {
        try {
            return Response.ok(bo.listar().stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Dentista nao encontrado: " + id)))
                .build();
        } catch (Exception e) {
            return Response.status(404).entity(e.getMessage()).build();
        }
    }

    @POST
    public Response cadastrar(Dentista d) {
        try {
            bo.cadastrar(d);
            return Response.status(201).build();
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") String id, Dentista d) {
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