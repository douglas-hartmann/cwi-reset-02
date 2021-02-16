package Projeto;

public class PropostaFinanciamento {

    private Beneficiario beneficiario;
    private Imovel imovel;
    private int mesesParaPagamento;

    public PropostaFinanciamento(Beneficiario beneficiario, Imovel imovel, int mesesParaPagamento) {
        this.beneficiario = beneficiario;
        this.imovel = imovel;
        this.mesesParaPagamento = mesesParaPagamento;
    }

    /**
     * Valida a proposta de financiamento e apresenta o resultado para o cliente.
     *
     * A proposta de financiamento é aceita somente se o salário do beneficiário multiplicado pelo prazo de pagamento
     *   for equivalente a pelo menos 50% do valor do imóvel.
     *
     *   Esta regra possui duas exceções: se o imóvel se localiza no estado SP ou RJ,
     *      o salário multiplicado pelo prazo deve ser equivalente a 65% e 60% do valor imóvel (respectivamente).
     */
    public void validarProposta() {
        if("São Paulo".equals(imovel.getEndereco().getEstado())){
            if((beneficiario.getSalario() * mesesParaPagamento) >= (imovel.getValor()*0.65)){
                imprimirPropostaAprovada();
            }else {
                imprimirPropostaNegada();
            }
        }else if("Rio de Janeiro".equals(imovel.getEndereco().getEstado())) {
            if ((beneficiario.getSalario() * mesesParaPagamento) >= (imovel.getValor() * 0.60)) {
                imprimirPropostaAprovada();
            } else {
                imprimirPropostaNegada();
            }
        }else{
            if((beneficiario.getSalario() * mesesParaPagamento) >= (imovel.getValor()*0.50)){
                imprimirPropostaAprovada();
            }else {
                imprimirPropostaNegada();
            }
        }
    }

    public void imprimirPropostaAprovada(){
        System.out.println("PARABÉNS, " + beneficiario.getNome() +"!!! Seu financiamento foi aprovado!");
    }

    public void imprimirPropostaNegada(){
        System.out.println(beneficiario.getNome() +", infelizmente seu financiamento foi recusado. Tente outras opções mais acessíveis.");

    }
}