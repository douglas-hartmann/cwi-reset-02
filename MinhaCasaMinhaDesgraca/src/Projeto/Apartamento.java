package Projeto;

import java.text.DecimalFormat;

public class Apartamento extends Imovel {

    private int andar;

    public Apartamento(Endereco endereco, double valor,int andar) {
        super(endereco, valor);
        this.andar=andar;
    }

    @Override
    public String apresentcao() {
            return ("Apartamento localizado no seguinte endereço:" +
                    "\nLogradouro: " + getEndereco().getLogradouro()+
                    "\nNúmero: " + getEndereco().getNumero()+
                    "\nComplemento: " + getEndereco().getComplemento()+
                    "\nBairro: " + getEndereco().getBairro()+
                    "\nCidade: " + getEndereco().getCidade()+
                    "\nEstado: " + getEndereco().getEstado().getDescricao()+
                    "\nValor: R$ " + DecimalFormat.getCurrencyInstance().format(getValor()));

    }
}
