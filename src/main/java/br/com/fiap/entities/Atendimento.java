package br.com.fiap.entities;
import java.time.LocalDateTime;

public class Atendimento {
    private String id, idDentista, idBeneficiario, idPrograma, descricaoTratamento, cronogramaProcedimentos, status;
    private LocalDateTime dtHora;

    public Atendimento() {}

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

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getIdDentista() { return idDentista; }
    public void setIdDentista(String idDentista) { this.idDentista = idDentista; }
    public String getIdBeneficiario() { return idBeneficiario; }
    public void setIdBeneficiario(String idBeneficiario) { this.idBeneficiario = idBeneficiario; }
    public String getIdPrograma() { return idPrograma; }
    public void setIdPrograma(String idPrograma) { this.idPrograma = idPrograma; }
    public LocalDateTime getDtHora() { return dtHora; }
    public void setDtHora(LocalDateTime dtHora) { this.dtHora = dtHora; }
    public String getDescricaoTratamento() { return descricaoTratamento; }
    public void setDescricaoTratamento(String descricaoTratamento) { this.descricaoTratamento = descricaoTratamento; }
    public String getCronogramaProcedimentos() { return cronogramaProcedimentos; }
    public void setCronogramaProcedimentos(String cronogramaProcedimentos) { this.cronogramaProcedimentos = cronogramaProcedimentos; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}