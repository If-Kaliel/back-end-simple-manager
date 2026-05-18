package br.com.fiap.dto;

public class ResumoDTO {
    public double totalArrecadado;
    public int atendimentosAtivos;
    public int triagensPendentes;

    public ResumoDTO(double totalArrecadado, int atendimentosAtivos, int triagensPendentes) {
        this.totalArrecadado = totalArrecadado;
        this.atendimentosAtivos = atendimentosAtivos;
        this.triagensPendentes = triagensPendentes;
    }
}