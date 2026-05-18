package br.com.fiap.entities;

import java.time.LocalDate;

public class Atendimento {
    private String id;              // ID_ATENDIMENTO
    private String idDentista;      // ID_DENTISTA (FK)
    private String idBeneficiario;  // ID_BENEFICIARIO (FK)
    private String idTriagem;       // ID_TRIAGEM (FK)
    private LocalDate dtAtendimento; // DT_ATENDIMENTO
    private String diagnostico;      // DIAGNOSTICO

    public Atendimento() {}

    public Atendimento(String id, String idDentista, String idBeneficiario, String idTriagem, LocalDate dtAtendimento, String diagnostico) {
        this.id = id;
        this.idDentista = idDentista;
        this.idBeneficiario = idBeneficiario;
        this.idTriagem = idTriagem;
        this.dtAtendimento = dtAtendimento;
        this.diagnostico = diagnostico;
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getIdDentista() { return idDentista; }
    public void setIdDentista(String idDentista) { this.idDentista = idDentista; }
    public String getIdBeneficiario() { return idBeneficiario; }
    public void setIdBeneficiario(String idBeneficiario) { this.idBeneficiario = idBeneficiario; }
    public String getIdTriagem() { return idTriagem; }
    public void setIdTriagem(String idTriagem) { this.idTriagem = idTriagem; }
    public LocalDate getDtAtendimento() { return dtAtendimento; }
    public void setDtAtendimento(LocalDate dtAtendimento) { this.dtAtendimento = dtAtendimento; }
    public String getDiagnostico() { return diagnostico; }
    public void setDiagnostico(String diagnostico) { this.diagnostico = diagnostico; }
}