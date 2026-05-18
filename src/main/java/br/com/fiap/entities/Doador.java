package br.com.fiap.entities;

public class Doador {
    private String id;        // ID_DOADOR
    private String nome;      // NM_DOADOR
    private double vlDoacao;  // VL_DOACAO (Número no banco)
    private String contato;   // CONTATO

    // Construtor Vazio
    public Doador() {}

    // Construtor Cheio
    public Doador(String id, String nome, double vlDoacao, String contato) {
        this.id = id;
        this.nome = nome;
        this.vlDoacao = vlDoacao;
        this.contato = contato;
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public double getVlDoacao() { return vlDoacao; }
    public void setVlDoacao(double vlDoacao) { this.vlDoacao = vlDoacao; }
    public String getContato() { return contato; }
    public void setContato(String contato) { this.contato = contato; }
}