package com.example.videolocadora.dtos;

import jakarta.validation.constraints.NotBlank;

public class LocacaoDto {
    @NotBlank
    private String idLocacao;

    @NotBlank
    private String idCliente;

    @NotBlank
    private String idFilme;

    @NotBlank
    private String dataRetirada;

    @NotBlank
    private String dataDevolucao;

    @NotBlank
    private String valor;

    @NotBlank
    private String feitoPagamento;

    public String getIdLocacao() {
        return idLocacao;
    }

    public void setIdLocacao(String idLocacao) {
        this.idLocacao = idLocacao;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(String idFilme) {
        this.idFilme = idFilme;
    }

    public String getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(String dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valorLocacao) {
        this.valor = valorLocacao;
    }

    public String getFeitoPagamento() {
        return feitoPagamento;
    }

    public void setFeitoPagamento(String feitoPagamento) {
        this.feitoPagamento = feitoPagamento;
    }
}
