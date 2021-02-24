package br.com.banco.desgraca.domain;

public enum TipoTransacao {
    DEPOSITAR("Depositar"),
    SACAR("Sacar"),
    TRANSFERIR("Transferir");

    private final String descricao;

    TipoTransacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}