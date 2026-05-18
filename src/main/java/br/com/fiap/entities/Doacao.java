package br.com.fiap.entities;
import java.time.LocalDate;

public class Doacao {
    private String id, idDoador, formaPagamento, periodicidadePagamento;
    private double valorDoacao;
    private LocalDate dtDoacao;

    public Doacao(String id, String idDoador, double valorDoacao, LocalDate dtDoacao, String formaPagamento, String periodicidadePagamento) {
        this.id = id;
        this.idDoador = idDoador;
        this.valorDoacao = valorDoacao;
        this.dtDoacao = dtDoacao;
        this.formaPagamento = formaPagamento;
        this.periodicidadePagamento = periodicidadePagamento;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getIdDoador() { return idDoador; }
    public double getValorDoacao() { return valorDoacao; }
    public LocalDate getDtDoacao() { return dtDoacao; }
    public String getFormaPagamento() { return formaPagamento; }
    public String getPeriodicidadePagamento() { return periodicidadePagamento; }
}