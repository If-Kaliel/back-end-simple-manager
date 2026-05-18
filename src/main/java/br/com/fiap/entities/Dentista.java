package br.com.fiap.entities;

public class Dentista {
    private String id;        // ID_DENTISTA
    private String nome;      // NM_DENTISTA
    private String cro;       // NR_CRO
    private String especialidade; // ESPECIALIDADE

    public Dentista() {}

    public Dentista(String id, String nome, String cro, String especialidade) {
        this.id = id;
        this.nome = nome;
        this.cro = cro;
        this.especialidade = especialidade;
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCro() { return cro; }
    public void setCro(String cro) { this.cro = cro; }
    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }
}