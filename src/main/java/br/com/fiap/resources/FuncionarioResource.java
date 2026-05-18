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
    public Response listar(@HeaderParam("role") String role) {
        System.out.println("🔍 TESTE - Credencial recebida do Front: " + role);

        try {

            List<Funcionario> lista = bo.listar(role);
            System.out.println("✅ BANCO DE DADOS ENCONTRADO " + lista.size() + " funcionarios.");

            return Response.ok(lista).build();

        } catch (Exception e) {
            // AGORA O ERRO VAI APARECER EM VERMELHO NO SEU TERMINAL DO INTELLIJ!
            System.err.println("❌ ERRO GRAVE NO JAVA:");
            e.printStackTrace();

            // Se for erro de acesso, devolve 403. Qualquer outra coisa, devolve 500.
            if(e.getMessage() != null && e.getMessage().contains("Acesso negado")) {
                return Response.status(403).entity(e.getMessage()).build();
            }
            return Response.status(500).entity("Erro interno: " + e.getMessage()).build();
        }
    }
    @POST
    public Response cadastrar(Funcionario f, @HeaderParam("role") String role) {
        try {
            bo.cadastrar(f, role);
            return Response.status(201).build();
        } catch (Exception e) {
            // 1. Isso vai imprimir o erro GIGANTE e real em vermelho no terminal do IntelliJ
            e.printStackTrace();

            // 2. Mudamos para 500 (Erro Interno do Servidor) se o banco cair,
            // ou deixamos 403 só se a mensagem for realmente "Acesso negado"
            if(e.getMessage() != null && e.getMessage().contains("Acesso negado")) {
                return Response.status(403).entity(e.getMessage()).build();
            }
            return Response.status(500).entity("Erro no servidor/banco: " + e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") String id, Funcionario f, @HeaderParam("role") String role) {
        try {
            f.setId(id);
            bo.atualizar(f, role);
            return Response.ok().build();
        } catch (Exception e) {
            // 1. Isso vai imprimir o erro GIGANTE e real em vermelho no terminal do IntelliJ
            e.printStackTrace();

            // 2. Mudamos para 500 (Erro Interno do Servidor) se o banco cair,
            // ou deixamos 403 só se a mensagem for realmente "Acesso negado"
            if(e.getMessage() != null && e.getMessage().contains("Acesso negado")) {
                return Response.status(403).entity(e.getMessage()).build();
            }
            return Response.status(500).entity("Erro no servidor/banco: " + e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") String id, @HeaderParam("role") String role) {
        try {
            bo.excluir(id, role);
            return Response.noContent().build();
        } catch (Exception e) {
            // 1. Isso vai imprimir o erro GIGANTE e real em vermelho no terminal do IntelliJ
            e.printStackTrace();

            // 2. Mudamos para 500 (Erro Interno do Servidor) se o banco cair,
            // ou deixamos 403 só se a mensagem for realmente "Acesso negado"
            if(e.getMessage() != null && e.getMessage().contains("Acesso negado")) {
                return Response.status(403).entity(e.getMessage()).build();
            }
            return Response.status(500).entity("Erro no servidor/banco: " + e.getMessage()).build();
        }
    }
}