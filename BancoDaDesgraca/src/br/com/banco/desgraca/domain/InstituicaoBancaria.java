
package br.com.banco.desgraca.domain;

public enum InstituicaoBancaria {

    BANCO_DO_BRASIL("Banco do Brasil",false,true,true),
    BRADESCO("Bradesco",false,true,true),
    CAIXA("Caixa",false,true,true),
    ITAU("Itau",true,true,true),
    NUBANK("Nubank",true,false,true);

    private final String descricao;
    private final boolean contaDigital;
    private final boolean contaPoupanca;
    private final boolean contaCorrente;

    InstituicaoBancaria(String descricao,boolean contaDigital,boolean contaPoupanca,boolean contaCorrente){
        this.descricao=descricao;
        this.contaDigital=contaDigital;
        this.contaPoupanca=contaPoupanca;
        this.contaCorrente=contaCorrente;
    }

    public boolean permiteContaDigital() {
        return contaDigital;
    }

    public boolean permiteContaPoupanca() {
        return contaPoupanca;
    }

    public boolean permiteContaCorrente() {
        return contaCorrente;
    }

    public String getDescricao() {
        return descricao;
    }
}
