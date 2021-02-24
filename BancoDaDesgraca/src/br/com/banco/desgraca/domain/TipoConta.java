package br.com.banco.desgraca.domain;

public enum TipoConta {
    CONTA_DIGITAL("Conta Digital",10.0,1.0,1.0,1.0),
    CONTA_POUPANCA("Conta Poupanca",50.0,1.02,1.01,1.005),
    CONTA_CORRENTE("Conta Corrente",5.0,1.0,1.01,1.0);

    private final String descricao;
    private final Double saqueMinimo;
    private final Double taxaSaque;
    private final Double taxaTransferenciaOutraInstituicao;
    private final Double getTaxaTransferenciaMesmaInstituicao;

    TipoConta(String descricao, Double saqueMinimo, Double taxaSaque, Double taxaTransferenciaOutraInstituicao, Double getTaxaTransferenciaMesmaInstituicao) {
        this.descricao=descricao;
        this.saqueMinimo = saqueMinimo;
        this.taxaSaque = taxaSaque;
        this.taxaTransferenciaOutraInstituicao = taxaTransferenciaOutraInstituicao;
        this.getTaxaTransferenciaMesmaInstituicao = getTaxaTransferenciaMesmaInstituicao;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double valorSaqueMinimo() {
        return saqueMinimo;
    }

    public Double valorTaxaSaque() {
        return taxaSaque;
    }

    public Double valorTaxaTransferenciaOutraInstituicao() {
        return taxaTransferenciaOutraInstituicao;
    }

    public Double valorTaxaTransferenciaMesmaInstituicao() {
        return getTaxaTransferenciaMesmaInstituicao;
    }
}
