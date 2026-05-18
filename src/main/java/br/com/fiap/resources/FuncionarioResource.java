package br.com.fiap.resources;

import br.com.fiap.bo.FuncionarioBO;
import br.com.fiap.entities.Funcionario;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.util.List;

@Path("/funcionarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FuncionarioResource {
    private FuncionarioBO bo;

    public FuncionarioResource() {
        try { this.bo = new FuncionarioBO(); } catch (Exception e) { e.printStackTrace(); }
    }

    @GET
    public Response listar() {
        System.out.println("🔍 TESTE - Listando funcionários (Sem credencial necessária)");
        try {
            List<Funcionario> lista = bo.listar();
            System.out.println("✅ BANCO DE DADOS ENCONTRADO " + lista.size() + " funcionarios.");
            return Response.ok(lista).build();
        } catch (Exception e) {
            System.err.println("❌ ERRO GRAVE NO JAVA:");
            e.printStackTrace();
            return Response.status(500).entity("Erro interno: " + e.getMessage()).build();
        }
    }

    @POST
    public Response cadastrar(Funcionario f) {
        try {
            bo.cadastrar(f);
            return Response.status(201).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).entity("Erro no servidor/banco: " + e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") String id, Funcionario f) {
        try {
            f.setId(id);
            bo.atualizar(f);
            return Response.ok("{\"status\": \"Sucesso\"}").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).entity("Erro no servidor/banco: " + e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") String id) {
        try {
            bo.remover(id);
            return Response.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).entity("Erro no servidor/banco: " + e.getMessage()).build();
        }
    }
}