package br.com.fiap.entities;

import java.time.LocalDateTime;

public class Contato {
    private String id;
    private String nome;
    private String email;
    private String mensagem;
    private LocalDateTime dtEnvio;

    public Contato() {}

    public Contato(String id, String nome, String email, String mensagem, LocalDateTime dtEnvio) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.mensagem = mensagem;
        this.dtEnvio = dtEnvio;
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }
    public LocalDateTime getDtEnvio() { return dtEnvio; }
    public void setDtEnvio(LocalDateTime dtEnvio) { this.dtEnvio = dtEnvio; }
}