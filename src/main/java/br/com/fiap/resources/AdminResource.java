package br.com.fiap.resources;

import br.com.fiap.bo.*;
import br.com.fiap.dto.DashboardDTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AdminResource {

    @GET
    public Response getDashboard() {
        try {
            DashboardDTO dashboard = new DashboardDTO(
                    new BeneficiarioBO().listar(),
                    new ProgramaBO().listar(),
                    new TriagemBO().listar(),
                    new DentistaBO().listar(),
                    new FuncionarioBO().listar(),
                    new AtendimentoBO().listar(),
                    new DoacaoBO().listar(),
                    new DoadorBO().listar(),
                    new ProcedimentoBO().listar(),
                    new ApoloniaBO().listar(),
                    new ContatoBO().listar()
            );
            return Response.ok(dashboard).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao carregar dados: " + e.getMessage())
                    .build();
        }
    }
}