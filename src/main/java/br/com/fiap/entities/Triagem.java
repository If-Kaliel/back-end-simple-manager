package br.com.fiap.entities;

import java.time.LocalDate;

public class Triagem {
    private String id;              // ID_TRIAGEM
    private String idBeneficiario;  // ID_BENEFICIARIO (FK)
    private LocalDate dtTriagem;    // DT_TRIAGEM
    private String necessidade;     // NECESSIDADE
    private String prioridade;      // PRIORIDADE

    public Triagem() {}

    public Triagem(String id, String idBeneficiario, LocalDate dtTriagem, String necessidade, String prioridade) {
        this.id = id;
        this.idBeneficiario = idBeneficiario;
        this.dtTriagem = dtTriagem;
        this.necessidade = necessidade;
        this.prioridade = prioridade;
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getIdBeneficiario() { return idBeneficiario; }
    public void setIdBeneficiario(String idBeneficiario) { this.idBeneficiario = idBeneficiario; }
    public LocalDate getDtTriagem() { return dtTriagem; }
    public void setDtTriagem(LocalDate dtTriagem) { this.dtTriagem = dtTriagem; }
    public String getNecessidade() { return necessidade; }
    public void setNecessidade(String necessidade) { this.necessidade = necessidade; }
    public String getPrioridade() { return prioridade; }
    public void setPrioridade(String prioridade) { this.prioridade = prioridade; }
}