package br.com.fiap.entities;

public class Voluntariado {
    private String id;           // ID_VOLUNTARIADO
    private String idPrograma;   // ID_PROGRAMA (FK)
    private String nome;         // NM_VOLUNTARIO
    private String tipoServico;  // TP_SERVICO (Ex: Dentista, Logística, Apoio)

    public Voluntariado() {}

    public Voluntariado(String id, String idPrograma, String nome, String tipoServico) {
        this.id = id;
        this.idPrograma = idPrograma;
        this.nome = nome;
        this.tipoServico = tipoServico;
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getIdPrograma() { return idPrograma; }
    public void setIdPrograma(String idPrograma) { this.idPrograma = idPrograma; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getTipoServico() { return tipoServico; }
    public void setTipoServico(String tipoServico) { this.tipoServico = tipoServico; }
}