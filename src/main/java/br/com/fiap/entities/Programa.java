package br.com.fiap.entities;

public class Programa {
    private String id;       // ID_PROGRAMA
    private String nome;     // NM_PROGRAMA
    private String objetivo; // OBJETIVO

    // Construtor Vazio
    public Programa() {}

    // Construtor Cheio
    public Programa(String id, String nome, String objetivo) {
        this.id = id;
        this.nome = nome;
        this.objetivo = objetivo;
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getObjetivo() { return objetivo; }
    public void setObjetivo(String objetivo) { this.objetivo = objetivo; }
}