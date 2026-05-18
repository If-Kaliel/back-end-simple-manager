package br.com.fiap.entities;

import java.time.LocalDate;

public class Beneficiario {
    private String id;
    private String idPrograma;
    private String nome;
    private LocalDate dtNascimento;
    private String endereco;

    // 1. Construtor Vazio (Obrigatório para o GSON/Quarkus)
    public Beneficiario() {}

    // 2. Construtor Cheio (O que vai te salvar tempo no DAO e nos Testes)
    public Beneficiario(String id, String idPrograma, String nome, LocalDate dtNascimento, String endereco) {
        this.id = id;
        this.idPrograma = idPrograma;
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.endereco = endereco;
    }

    // Getters e Setters (Mantêm-se iguais)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getIdPrograma() { return idPrograma; }
    public void setIdPrograma(String idPrograma) { this.idPrograma = idPrograma; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public LocalDate getDtNascimento() { return dtNascimento; }
    public void setDtNascimento(LocalDate dtNascimento) { this.dtNascimento = dtNascimento; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
}