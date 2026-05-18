package br.com.fiap.entities;

public class Doador {
    private String id, nmDoador, email;

    public Doador(String id, String nmDoador, String email) {
        this.id = id;
        this.nmDoador = nmDoador;
        this.email = email;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNmDoador() { return nmDoador; }
    public String getEmail() { return email; }
}