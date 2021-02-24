package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.Data;
import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoConta;
import br.com.banco.desgraca.domain.TipoTransacao;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.exception.RegraSaqueException;

import java.text.DecimalFormat;

public class ContaPoupanca extends ContaGenerica{

    private Double valorTotal;

    public ContaPoupanca(TipoConta tipoConta,InstituicaoBancaria instituicaoBancaria, Integer numeroConta) {
        super(tipoConta, instituicaoBancaria, numeroConta);
    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        super.verificaSaldo(valor);
        if(contaDestino.getInstituicaoBancaria().equals(super.getInstituicaoBancaria())){
            valorTotal=valor*TipoConta.CONTA_POUPANCA.valorTaxaTransferenciaMesmaInstituicao();
        }else{
            valorTotal=valor*TipoConta.CONTA_POUPANCA.valorTaxaTransferenciaOutraInstituicao();
        }
        System.out.println("Transferindo valor "+ DecimalFormat.getCurrencyInstance().format(valor)+" da "+
                super.toString() + " para " + contaDestino);
        Transacao transacao = new Transacao(TipoTransacao.TRANSFERIR,Data.getDataTransacao(),valorTotal);
        super.transacoesBancarias(transacao);
        setSaldo(getSaldo()-valorTotal);
        contaDestino.depositar(valor);
    }

    @Override
    public void sacar(Double valor) {
        verificaSaldo(valor);
        if(valor>=TipoConta.CONTA_POUPANCA.valorSaqueMinimo()){
            valorTotal=valor*TipoConta.CONTA_POUPANCA.valorTaxaSaque();
            super.setSaldo(super.getSaldo()-valorTotal);
            System.out.println("Sacando valor "+ DecimalFormat.getCurrencyInstance().format(valor)+" da "+ super.toString());
            Transacao transacao = new Transacao(TipoTransacao.SACAR, Data.getDataTransacao(),valorTotal);
            super.transacoesBancarias(transacao);
        }else{
            throw new RegraSaqueException("Saque inválido. Valor mínimo R$ 50,00.");
        }
    }
}
