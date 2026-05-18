package br.com.fiap.services;

import br.com.fiap.api.Endereco;
import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ViaCepService {

    public Endereco buscarEndereco(String cep) {
        // Limpeza do CEP para evitar erro na URL
        String cepLimpo = cep.replaceAll("\\D", "");
        String url = "https://viacep.com.br/ws/" + cepLimpo + "/json/";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return new Gson().fromJson(response.body(), Endereco.class);
            }
        } catch (Exception e) {
            System.err.println("Erro na consulta ViaCep: " + e.getMessage());
        }
        return null;
    }
}