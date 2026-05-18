package br.com.fiap.entities;
import java.time.LocalDateTime;

public class Atendimento {
    private String id, idDentista, idBeneficiario, idPrograma, descricaoTratamento, cronogramaProcedimentos, status;
    private LocalDateTime dtHora;

    public Atendimento(String id, String idDentista, String idBeneficiario, String idPrograma, LocalDateTime dtHora, String descricaoTratamento, String cronogramaProcedimentos, String status) {
        this.id = id;
        this.idDentista = idDentista;
        this.idBeneficiario = idBeneficiario;
        this.idPrograma = idPrograma;
        this.dtHora = dtHora;
        this.descricaoTratamento = descricaoTratamento;
        this.cronogramaProcedimentos = cronogramaProcedimentos;
        this.status = status;
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getIdDentista() { return idDentista; }
    public String getIdBeneficiario() { return idBeneficiario; }
    public String getIdPrograma() { return idPrograma; }
    public LocalDateTime getDtHora() { return dtHora; }
    public String getDescricaoTratamento() { return descricaoTratamento; }
    public String getCronogramaProcedimentos() { return cronogramaProcedimentos; }
    public String getStatus() { return status; }
}