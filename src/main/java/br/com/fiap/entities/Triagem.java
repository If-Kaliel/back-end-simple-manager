package br.com.fiap.entities;
import java.time.LocalDateTime;

public class Triagem {
    private String id, idDentista, idBeneficiario, dsPrioridade, dsLocal;
    private LocalDateTime dtHr;

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
    public String getIdDentista() { return idDentista; }
    public String getIdBeneficiario() { return idBeneficiario; }
    public String getDsPrioridade() { return dsPrioridade; }
    public String getDsLocal() { return dsLocal; }
}