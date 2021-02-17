package Projeto;

import java.text.DecimalFormat;

public abstract class Imovel {
    private Endereco endereco;
    private double valor;

    public Imovel(Endereco endereco, double valor) {
        this.endereco = endereco;
        this.valor = valor;
    }

    //método deve retornar uma string com endereço e valor do imóvel
    public abstract String apresentcao();

    public Endereco getEndereco() {
        return endereco;
    }

    public double getValor() {
        return valor;
    }
}
