package br.com.fiap.entities;

public class Apolonia {
    private String id;           // Mapeia para ID_BENEFICIARIO
    private String nome;         // Mapeia para NM_BENEFICIARIO
    private String dtNascimento; // Mapeia para DT_NASCIMENTO
    private String endereco;     // Mapeia para ENDERECO

    public Apolonia() {}

    public Apolonia(String id, String nome, String dtNascimento, String endereco) {
        this.id = id;
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.endereco = endereco;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDtNascimento() { return dtNascimento; }
    public void setDtNascimento(String dtNascimento) { this.dtNascimento = dtNascimento; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
}