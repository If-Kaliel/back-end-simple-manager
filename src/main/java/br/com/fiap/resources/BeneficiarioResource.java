package br.com.fiap.resources;

import br.com.fiap.bo.BeneficiarioBO;
import br.com.fiap.entities.Beneficiario;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.util.List;

@Path("/beneficiarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BeneficiarioResource {
    private BeneficiarioBO bo;

    public BeneficiarioResource() {
        try { this.bo = new BeneficiarioBO(); } catch (Exception e) { e.printStackTrace(); }
    }

    @GET
    public Response listar(@HeaderParam("role") String role) {
        System.out.println("🔍 TESTE BENEFICIARIO - Credencial recebida: " + role);

        try {
            return Response.ok(bo.listar(role)).build();
        } catch (Exception e) {
            // AGORA O ERRO VAI APARECER EM VERMELHO NO TERMINAL!
            System.err.println("❌ ERRO GRAVE NO JAVA (BENEFICIARIO):");
            e.printStackTrace();

            if(e.getMessage() != null && e.getMessage().contains("Acesso negado")) {
                return Response.status(403).entity(e.getMessage()).build();
            }
            return Response.status(500).entity("Erro interno: " + e.getMessage()).build();
        }
    }

    @POST
    public Response cadastrar(Beneficiario b, @HeaderParam("role") String role) {
        try {
            return Response.ok(bo.listar(role)).build();
        } catch (Exception e) {
            // AGORA O ERRO VAI APARECER EM VERMELHO NO TERMINAL!
            System.err.println("❌ ERRO GRAVE NO JAVA (BENEFICIARIO):");
            e.printStackTrace();

            if(e.getMessage() != null && e.getMessage().contains("Acesso negado")) {
                return Response.status(403).entity(e.getMessage()).build();
            }
            return Response.status(500).entity("Erro interno: " + e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") String id, Beneficiario b, @HeaderParam("role") String role) {
        try {
            return Response.ok(bo.listar(role)).build();
        } catch (Exception e) {
            // AGORA O ERRO VAI APARECER EM VERMELHO NO TERMINAL!
            System.err.println("❌ ERRO GRAVE NO JAVA (BENEFICIARIO):");
            e.printStackTrace();

            if(e.getMessage() != null && e.getMessage().contains("Acesso negado")) {
                return Response.status(403).entity(e.getMessage()).build();
            }
            return Response.status(500).entity("Erro interno: " + e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") String id, @HeaderParam("role") String role) {
        try {
            return Response.ok(bo.listar(role)).build();
        } catch (Exception e) {
            // AGORA O ERRO VAI APARECER EM VERMELHO NO TERMINAL!
            System.err.println("❌ ERRO GRAVE NO JAVA (BENEFICIARIO):");
            e.printStackTrace();

            if(e.getMessage() != null && e.getMessage().contains("Acesso negado")) {
                return Response.status(403).entity(e.getMessage()).build();
            }
            return Response.status(500).entity("Erro interno: " + e.getMessage()).build();
        }
    }
}