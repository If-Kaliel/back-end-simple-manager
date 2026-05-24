package br.com.fiap.entities;
import java.time.LocalDate;

public class Doacao {
    private String id, idDoador, formaPagamento, periodicidadePagamento;
    private double valorDoacao;
    private LocalDate dtDoacao;

    public Doacao() {}

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
    public void setIdDoador(String idDoador) { this.idDoador = idDoador; }
    public double getValorDoacao() { return valorDoacao; }
    public void setValorDoacao(double valorDoacao) { this.valorDoacao = valorDoacao; }
    public LocalDate getDtDoacao() { return dtDoacao; }
    public void setDtDoacao(LocalDate dtDoacao) { this.dtDoacao = dtDoacao; }
    public String getFormaPagamento() { return formaPagamento; }
    public void setFormaPagamento(String formaPagamento) { this.formaPagamento = formaPagamento; }
    public String getPeriodicidadePagamento() { return periodicidadePagamento; }
    public void setPeriodicidadePagamento(String periodicidadePagamento) { this.periodicidadePagamento = periodicidadePagamento; }
}