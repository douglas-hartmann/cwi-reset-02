package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.Data;
import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoConta;
import br.com.banco.desgraca.domain.TipoTransacao;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.exception.CriacaoDeContaException;
import br.com.banco.desgraca.exception.DataExibirExtratoException;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContaGenerica implements ContaBancaria {

    private final InstituicaoBancaria instituicaoBancaria;
    private final Integer numeroConta;
    private final TipoConta tipoConta;
    private Double saldo=0.0;
    private final List<Transacao> listaTransacoes = new ArrayList<>();

    public ContaGenerica(TipoConta tipoConta,InstituicaoBancaria instituicaoBancaria, Integer numeroConta) {
        this.tipoConta=tipoConta;
        this.instituicaoBancaria = instituicaoBancaria;
        this.numeroConta = numeroConta;
        verificarConta();
    }

    //método que verifica se a instituição bancária permite criação de determinado tipo de conta (digital, poupança ou corrente).
    public void verificarConta() {
        if (tipoConta == TipoConta.CONTA_CORRENTE) {
            if (!instituicaoBancaria.permiteContaCorrente()) {
                imprimeVerificacaoConta(TipoConta.CONTA_CORRENTE.getDescricao());
            }
        } else if (tipoConta == TipoConta.CONTA_POUPANCA) {
            if (!instituicaoBancaria.permiteContaPoupanca()) {
                imprimeVerificacaoConta(TipoConta.CONTA_POUPANCA.getDescricao());
            }
        } else {
            if (!instituicaoBancaria.permiteContaDigital()) {
                imprimeVerificacaoConta(TipoConta.CONTA_DIGITAL.getDescricao());
            }
        }
    }

    public void imprimeVerificacaoConta(String tipoConta){
        throw new CriacaoDeContaException(instituicaoBancaria.getDescricao() + " não aceita criar " + tipoConta);
    }

    public void verificaSaldo(Double valor) {
        if (this.saldo < valor) {
            throw new SaldoInsuficienteException("Saldo insuficiente na " + toString());
        }
    }

    @Override
    public InstituicaoBancaria getInstituicaoBancaria() {
        return instituicaoBancaria;
    }

    @Override
    public Double consultarSaldo() {
        return this.saldo;
    }

    @Override
    public void depositar(Double valor) {
        this.saldo = this.saldo + valor;
        System.out.println("Depositando valor "+ DecimalFormat.getCurrencyInstance().format(valor)+" na " + toString());
        Transacao transacao = new Transacao(TipoTransacao.DEPOSITAR, Data.getDataTransacao(), valor);
        transacoesBancarias(transacao);
    }

    @Override
    public void sacar(Double valor) {

    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        verificaSaldo(valor);
        System.out.println("Transferindo valor "+ DecimalFormat.getCurrencyInstance().format(valor)+" da "+
                toString() + " para " + contaDestino);
        Transacao transacao = new Transacao(TipoTransacao.TRANSFERIR,Data.getDataTransacao(),valor);
        listaTransacoes.add(transacao);
        this.saldo = this.saldo - valor;
        contaDestino.depositar(valor);
    }


    @Override
    public void exibirExtrato(LocalDate inicio, LocalDate fim) {
        System.out.println("---- EXTRATO" + " " + toString());

        for(Transacao extrato : listaTransacoes){

            if(inicio==null && fim == null) { //exibe extrato completo.
                imprimeLinhaExtrato(extrato.getTipoTransacao().getDescricao(),extrato.getValor(),extrato.getDataTransacao());
            }else if(fim==null){ //exibe extrato completo a partir da data de inicio definida
                if (extrato.getDataTransacao().compareTo(inicio) >= 0) {
                    imprimeLinhaExtrato(extrato.getTipoTransacao().getDescricao(), extrato.getValor(), extrato.getDataTransacao());
                    }
                }else if(inicio==null){ //exibe extrato completo até a data de fim definida
                    if (extrato.getDataTransacao().compareTo(fim) <= 0) {
                        imprimeLinhaExtrato(extrato.getTipoTransacao().getDescricao(), extrato.getValor(), extrato.getDataTransacao());
                    }
                    }else{ //exibe extrato de um determinado periodo
                        if(inicio.isAfter(fim)){
                            throw new DataExibirExtratoException("Data incio maior que fim.");
                        }
                        if ((extrato.getDataTransacao().compareTo(inicio) >= 0) && (extrato.getDataTransacao().compareTo(fim) <= 0)) {
                            imprimeLinhaExtrato(extrato.getTipoTransacao().getDescricao(), extrato.getValor(), extrato.getDataTransacao());
                        }
                    }
        }
        System.out.println("---- ");
    }

    public void imprimeLinhaExtrato(String tipoTransacao, Double valor, LocalDate dataTransacao){
        if (tipoTransacao.equals("Depositar")) {
            System.out.println("+      " + DecimalFormat.getCurrencyInstance().format(valor) + "       " + dataTransacao);
        } else {
            System.out.println("-      " + DecimalFormat.getCurrencyInstance().format(valor) + "       " + dataTransacao);
        }
    }

    @Override
    public String toString() {
        return tipoConta.getDescricao() +
                " " + instituicaoBancaria.getDescricao() +
                " " + numeroConta + " ";
    }

    public void transacoesBancarias(Transacao transacao){
        listaTransacoes.add(transacao);
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

}
