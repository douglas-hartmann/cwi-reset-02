package Projeto;

import java.text.DecimalFormat;

public class Casa extends Imovel{

    private String patio;

    public Casa(Endereco endereco, double valor,String patio) {
        super(endereco, valor);
        this.patio = patio;
    }

    @Override
    public String apresentcao() {
        return ("Casa localizada no seguinte endereço:" +
                "\nLogradouro: " + getEndereco().getLogradouro()+
                "\nNúmero: " + getEndereco().getNumero()+
                "\nComplemento: " + getEndereco().getComplemento()+
                "\nBairro: " + getEndereco().getBairro()+
                "\nCidade: " + getEndereco().getCidade()+
                "\nEstado: " + getEndereco().getEstado().getDescricao()+
                "\nPátio: " + this.patio +
                "\nValor: R$ " + DecimalFormat.getCurrencyInstance().format(getValor()));

    }
}
