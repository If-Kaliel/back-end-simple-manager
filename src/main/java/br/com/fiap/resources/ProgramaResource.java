package br.com.fiap.resources;

import br.com.fiap.bo.ProgramaBO;
import br.com.fiap.entities.Programa;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/programas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProgramaResource {

    private ProgramaBO bo = new ProgramaBO();

    @GET
    public Response listar() {
        try { return Response.ok(bo.listar()).build(); }
        catch (Exception e) { return Response.serverError().entity(e.getMessage()).build(); }
    }

    @POST
    public Response cadastrar(Programa p) {
        try { bo.cadastrar(p); return Response.status(201).build(); }
        catch (Exception e) { return Response.serverError().entity(e.getMessage()).build(); }
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") String id, Programa p) {
        try {
            p.setId(id);
            bo.atualizar(p);
            return Response.ok("Atualizado").build();
        }
        catch (Exception e) { return Response.serverError().entity(e.getMessage()).build(); }
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") String id) {
        try { bo.deletar(id); return Response.ok("Deletado").build(); }
        catch (Exception e) { return Response.serverError().entity(e.getMessage()).build(); }
    }
}