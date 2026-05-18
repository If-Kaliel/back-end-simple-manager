package br.com.fiap.entities;

public class Funcionario {
    private String id;     // ID_FUNCIONARIO
    private String nome;   // NM_FUNCIONARIO
    private String cargo;  // CARGO

    public Funcionario() {}

    public Funcionario(String id, String nome, String cargo) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }
}