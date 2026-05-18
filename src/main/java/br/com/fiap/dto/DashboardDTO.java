package br.com.fiap.dto;

import br.com.fiap.entities.*;
import java.util.List;

public class DashboardDTO {
    public List<Beneficiario> beneficiarios;
    public List<Programa> programas;
    public List<Triagem> triagens;
    public List<Dentista> dentistas;
    public List<Funcionario> funcionarios;
    public List<Atendimento> atendimentos;
    public List<Doacao> doacoes;
    public List<Doador> doadores;
    public List<Procedimento> procedimentos;
    public List<Apolonia> apolonias;
    public List<Contato> contatos;

    public DashboardDTO(List<Beneficiario> beneficiarios, List<Programa> programas,
                        List<Triagem> triagens, List<Dentista> dentistas,
                        List<Funcionario> funcionarios, List<Atendimento> atendimentos,
                        List<Doacao> doacoes, List<Doador> doadores,
                        List<Procedimento> procedimentos, List<Apolonia> apolonias,
                        List<Contato> contatos) {
        this.beneficiarios = beneficiarios;
        this.programas = programas;
        this.triagens = triagens;
        this.dentistas = dentistas;
        this.funcionarios = funcionarios;
        this.atendimentos = atendimentos;
        this.doacoes = doacoes;
        this.doadores = doadores;
        this.procedimentos = procedimentos;
        this.apolonias = apolonias;
        this.contatos = contatos;
    }
}