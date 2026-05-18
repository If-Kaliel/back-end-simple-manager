package br.com.fiap.entities;

public class Procedimento {
    private String id;              // ID_PROCEDIMENTO
    private String idAtendimento;   // ID_ATENDIMENTO (FK)
    private String descricao;       // DS_PROCEDIMENTO
    private double valor;           // VL_PROCEDIMENTO

    public Procedimento() {}

    public Procedimento(String id, String idAtendimento, String descricao, double valor) {
        this.id = id;
        this.idAtendimento = idAtendimento;
        this.descricao = descricao;
        this.valor = valor;
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getIdAtendimento() { return idAtendimento; }
    public void setIdAtendimento(String idAtendimento) { this.idAtendimento = idAtendimento; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }
}