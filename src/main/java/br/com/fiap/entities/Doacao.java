package br.com.fiap.entities;

import java.time.LocalDate;

public class Doacao {
    private String id;          // ID_DOACAO
    private String idDoador;    // ID_DOADOR (FK)
    private double valor;       // VL_DOACAO
    private LocalDate dtDoacao; // DT_DOACAO

    public Doacao() {}

    public Doacao(String id, String idDoador, double valor, LocalDate dtDoacao) {
        this.id = id;
        this.idDoador = idDoador;
        this.valor = valor;
        this.dtDoacao = dtDoacao;
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getIdDoador() { return idDoador; }
    public void setIdDoador(String idDoador) { this.idDoador = idDoador; }
    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }
    public LocalDate getDtDoacao() { return dtDoacao; }
    public void setDtDoacao(LocalDate dtDoacao) { this.dtDoacao = dtDoacao; }
}