package br.com.fiap.resources;

import br.com.fiap.bo.BeneficiarioBO;
import br.com.fiap.entities.Beneficiario;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("/beneficiarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BeneficiarioResource {
    private BeneficiarioBO bo;

    public BeneficiarioResource() {
        try { this.bo = new BeneficiarioBO(); } catch (Exception e) { e.printStackTrace(); }
    }

    @GET
    public Response listar() {
        System.out.println("🔍 TESTE BENEFICIARIO - Listando todos");
        try {
            return Response.ok(bo.listar()).build();
        } catch (Exception e) {
            System.err.println("❌ ERRO GRAVE NO JAVA (BENEFICIARIO):");
            e.printStackTrace();
            return Response.status(500).entity("Erro interno: " + e.getMessage()).build();
        }
    }

    @POST
    public Response cadastrar(Beneficiario b) {
        try {
            bo.cadastrar(b);
            return Response.status(201).build();
        } catch (Exception e) {
            System.err.println("❌ ERRO GRAVE NO JAVA (BENEFICIARIO):");
            e.printStackTrace();
            return Response.status(500).entity("Erro interno: " + e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") String id, Beneficiario b) {
        try {
            b.setId(id);
            bo.atualizar(b);
            return Response.ok("{\"status\": \"Sucesso\"}").build();
        } catch (Exception e) {
            System.err.println("❌ ERRO GRAVE NO JAVA (BENEFICIARIO):");
            e.printStackTrace();
            return Response.status(500).entity("Erro interno: " + e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") String id) {
        try {
            bo.remover(id);
            return Response.noContent().build();
        } catch (Exception e) {
            System.err.println("❌ ERRO GRAVE NO JAVA (BENEFICIARIO):");
            e.printStackTrace();
            return Response.status(500).entity("Erro interno: " + e.getMessage()).build();
        }
    }
}