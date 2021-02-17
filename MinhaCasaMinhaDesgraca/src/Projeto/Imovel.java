package Projeto;

import java.text.DecimalFormat;

public class Imovel {
    private Endereco endereco;
    private double valor;

    public Imovel(Endereco endereco, double valor) {
        this.endereco = endereco;
        this.valor = valor;
    }

    //método deve retornar uma string com endereço e valor do imóvel
    public String apresentcao(){
        return ("Imóvel localizado no seguinte endereço:" +
                "\nLogradouro: " + endereco.getLogradouro()+
                "\nNúmero: " + endereco.getNumero()+
                "\nComplemento: " + endereco.getComplemento()+
                "\nBairro: " + endereco.getBairro()+
                "\nCidade: " + endereco.getCidade()+
                "\nEstado: " + endereco.getEstado().getDescricao()+
                "\nValor: R$ " + DecimalFormat.getCurrencyInstance().format(this.valor));
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public double getValor() {
        return valor;
    }
}
