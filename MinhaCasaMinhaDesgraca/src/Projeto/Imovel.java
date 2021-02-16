package Projeto;

public class Imovel {
    private Endereco endereco;
    private double valor;

    public Imovel(Endereco endereco, double valor) {
        this.endereco = endereco;
        this.valor = valor;
    }

    //método deve retornar uma string com endereço e valor do imovel
    public String apresentcao(){
        return ("Imóvel localizaddo no seguinte endereço:" +
                "\nLogradouoro: " + endereco.getLogradouro()+
                "\nNúmero: " + endereco.getNumero()+
                "\nComplemento: " + endereco.getComplemento()+
                "\nBairro: " + endereco.getBairro()+
                "\nCidade: " + endereco.getCidade()+
                "\nEstado: " + endereco.getEstado()+
                "\nValor: R$ " + this.valor);
        //return "Teste";
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public double getValor() {
        return valor;
    }
}
