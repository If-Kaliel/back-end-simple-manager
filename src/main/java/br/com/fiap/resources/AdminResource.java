package br.com.fiap.resources;

import br.com.fiap.bo.AdminBO;
import br.com.fiap.dto.RelatorioGeralDTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
public class AdminResource {
    private AdminBO bo;

    public AdminResource() {
        try {
            this.bo = new AdminBO();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GET
    @Path("/dashboard")
    public Response dashboard(@HeaderParam("role") String role) {
        if (bo == null) return Response.status(500).entity("{\"msg\":\"Erro de conexão com o banco\"}").build();
        try {
            return Response.ok(bo.gerarDashboard(role)).build();
        } catch (Exception e) {
            return Response.status(403).entity("{\"msg\":\"" + e.getMessage() + "\"}").build();
        }
    }
}