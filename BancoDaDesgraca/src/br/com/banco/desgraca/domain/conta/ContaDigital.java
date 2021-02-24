package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.Data;
import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoConta;
import br.com.banco.desgraca.domain.TipoTransacao;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.exception.RegraSaqueException;

import java.text.DecimalFormat;

public class ContaDigital extends ContaGenerica{


    //private TipoConta contaDigital = TipoConta.CONTA_DIGITAL;

    public ContaDigital(TipoConta tipoConta,InstituicaoBancaria instituicaoBancaria, Integer numeroConta) {
        super(tipoConta, instituicaoBancaria, numeroConta);
    }

    @Override
    public void sacar(Double valor) {
        super.verificaSaldo(valor);
        if (valor>=TipoConta.CONTA_DIGITAL.valorSaqueMinimo()){
            setSaldo(getSaldo()-valor);
            System.out.println("Sacando valor "+ DecimalFormat.getCurrencyInstance().format(valor)+" da "+ super.toString());
            Transacao transacao = new Transacao(TipoTransacao.SACAR, Data.getDataTransacao(),valor);
            super.transacoesBancarias(transacao);
        }else{
            throw new RegraSaqueException("Saque inválido. Valor mínimo R$ 10,00");
        }
    }
}
