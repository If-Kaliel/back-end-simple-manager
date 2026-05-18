package br.com.fiap.entities;

public class Procedimento {
    private String id, idAtendimento, nmProcedimento, duracao;

    public Procedimento(String id, String idAtendimento, String nmProcedimento, String duracao) {
        this.id = id;
        this.idAtendimento = idAtendimento;
        this.nmProcedimento = nmProcedimento;
        this.duracao = duracao;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getIdAtendimento() { return idAtendimento; }
    public String getNmProcedimento() { return nmProcedimento; }
    public String getDuracao() { return duracao; }
}