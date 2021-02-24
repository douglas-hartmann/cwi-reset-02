package br.com.banco.desgraca;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoConta;
import br.com.banco.desgraca.domain.conta.ContaCorrente;
import br.com.banco.desgraca.domain.conta.ContaDigital;
import br.com.banco.desgraca.domain.conta.ContaPoupanca;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class BancoDaDesgraca {

    public static void main(String[] args) {

        ContaCorrente contaCorrente = new ContaCorrente(TipoConta.CONTA_CORRENTE,InstituicaoBancaria.BANCO_DO_BRASIL,123);
        ContaDigital contaDigital = new ContaDigital(TipoConta.CONTA_DIGITAL,InstituicaoBancaria.NUBANK,12334);
        ContaPoupanca contaPoupanca = new ContaPoupanca(TipoConta.CONTA_POUPANCA,InstituicaoBancaria.BANCO_DO_BRASIL,3214);

        contaCorrente.depositar(50.0);
        contaCorrente.transferir(25.0,contaDigital);
        contaDigital.depositar(50.5);
        contaDigital.sacar(10.0);
        contaCorrente.sacar(15.0);
        contaDigital.transferir(30.0,contaPoupanca);
        contaPoupanca.depositar(90.0);
        contaPoupanca.sacar(50.0);
        contaPoupanca.transferir(10.0,contaDigital);

        contaCorrente.exibirExtrato(null,null);
        System.out.println("\n");
        contaDigital.exibirExtrato(null,null);
        System.out.println("\n");
        contaPoupanca.exibirExtrato(null,null);

        contaCorrente.exibirExtrato(LocalDate.parse("2020-07-11"),null);
        System.out.println("\n");
        contaDigital.exibirExtrato(LocalDate.parse("2020-07-16"),null);
        System.out.println("\n");
        contaPoupanca.exibirExtrato(LocalDate.parse("2020-08-10"),null);

        contaCorrente.exibirExtrato(null,LocalDate.parse("2020-07-11"));
        System.out.println("\n");
        contaDigital.exibirExtrato(null,LocalDate.parse("2020-07-16"));
        System.out.println("\n");
        contaPoupanca.exibirExtrato(null,LocalDate.parse("2020-08-20"));

        System.out.println("\n");
        contaDigital.exibirExtrato(LocalDate.parse("2020-07-26"),LocalDate.parse("2020-08-05"));

        System.out.println("Saldo "+contaCorrente+ DecimalFormat.getCurrencyInstance().format(contaCorrente.consultarSaldo()));
        System.out.println("Saldo "+contaDigital+ DecimalFormat.getCurrencyInstance().format(contaDigital.consultarSaldo()));
        System.out.println("Saldo "+contaPoupanca+ DecimalFormat.getCurrencyInstance().format(contaPoupanca.consultarSaldo()));
    }



}
