package br.com.banco.desgraca.domain;

import java.time.LocalDate;

public class Transacao {

    private final TipoTransacao tipoTransacao;
    private final Double valor;
    private final LocalDate dataTransacao;

    public Transacao(TipoTransacao tipoTransacao,  LocalDate dataTransacao, Double valor) {
        this.tipoTransacao = tipoTransacao;
        this.dataTransacao = dataTransacao;
        this.valor = valor;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public Double getValor() {
        return valor;
    }

    public LocalDate getDataTransacao() {
        return dataTransacao;
    }
}