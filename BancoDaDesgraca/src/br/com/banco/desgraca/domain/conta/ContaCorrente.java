package br.com.banco.desgraca.domain.conta;


import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoConta;
import br.com.banco.desgraca.domain.TipoTransacao;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.Data;
import br.com.banco.desgraca.exception.RegraSaqueException;

import java.text.DecimalFormat;

public class ContaCorrente extends ContaGenerica {

    public ContaCorrente(TipoConta tipoConta,InstituicaoBancaria instituicaoBancaria, Integer numeroConta) {
        super(tipoConta, instituicaoBancaria, numeroConta);
    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        super.verificaSaldo(valor);
        Double valorTotal;
        if(contaDestino.getInstituicaoBancaria().equals(super.getInstituicaoBancaria())){
            valorTotal =valor;
        }else{
            valorTotal =valor*TipoConta.CONTA_CORRENTE.valorTaxaTransferenciaOutraInstituicao();
        }
        Transacao transacao = new Transacao(TipoTransacao.TRANSFERIR,Data.getDataTransacao(), valorTotal);
        System.out.println("Transferindo valor "+ DecimalFormat.getCurrencyInstance().format(valor)+" da "+
                super.toString() + " para " + contaDestino);
        super.transacoesBancarias(transacao);
        super.setSaldo(super.getSaldo()- valorTotal);
        contaDestino.depositar(valor);
    }

    @Override
    public void sacar(Double valor) {
        super.verificaSaldo(valor);
        if((valor%TipoConta.CONTA_CORRENTE.valorSaqueMinimo() == 0)){
            super.setSaldo(super.getSaldo()-valor);
            System.out.println("Sacando valor "+ DecimalFormat.getCurrencyInstance().format(valor)+" da "+super.toString());
            Transacao transacao = new Transacao(TipoTransacao.SACAR, Data.getDataTransacao(),valor);
            super.transacoesBancarias(transacao);
        }else{
            throw new RegraSaqueException("Valor inválido para saque. Necessário ser múltiplo de 5.");
        }
    }
}