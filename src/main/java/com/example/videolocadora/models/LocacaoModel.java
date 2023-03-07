package com.example.videolocadora.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_LOCACAO")
public class LocacaoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private String idLocacao;

    @Column(nullable = false)
    private String idCliente;

    @Column(nullable = false)
    private String idFilme;

    @Column(nullable = false)
    private String dataRetirada;

    @Column(nullable = false)
    private String dataDevolucao;

    @Column(nullable = false)
    private String valor;

    @Column(nullable = false)
    private String feitoPagamento;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getFeitoPagamento() {
        return feitoPagamento;
    }

    public void setFeitoPagamento(String feitoPagamento) {
        this.feitoPagamento = feitoPagamento;
    }
}
