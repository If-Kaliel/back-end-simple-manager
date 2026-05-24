package br.com.fiap.entities;
import java.time.LocalDateTime;

public class Triagem {
    private String id, idDentista, idBeneficiario, dsPrioridade, dsLocal;
    private LocalDateTime dtHr;

    public Triagem() {}

    public Triagem(String id, LocalDateTime dtHr, String idDentista, String idBeneficiario, String dsPrioridade, String dsLocal) {
        this.id = id;
        this.dtHr = dtHr;
        this.idDentista = idDentista;
        this.idBeneficiario = idBeneficiario;
        this.dsPrioridade = dsPrioridade;
        this.dsLocal = dsLocal;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public LocalDateTime getDtHr() { return dtHr; }
    public void setDtHr(LocalDateTime dtHr) { this.dtHr = dtHr; }
    public String getIdDentista() { return idDentista; }
    public void setIdDentista(String idDentista) { this.idDentista = idDentista; }
    public String getIdBeneficiario() { return idBeneficiario; }
    public void setIdBeneficiario(String idBeneficiario) { this.idBeneficiario = idBeneficiario; }
    public String getDsPrioridade() { return dsPrioridade; }
    public void setDsPrioridade(String dsPrioridade) { this.dsPrioridade = dsPrioridade; }
    public String getDsLocal() { return dsLocal; }
    public void setDsLocal(String dsLocal) { this.dsLocal = dsLocal; }
}