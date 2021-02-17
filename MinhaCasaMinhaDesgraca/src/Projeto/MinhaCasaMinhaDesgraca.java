package Projeto;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MinhaCasaMinhaDesgraca {

    public static void main(String[] args) throws Exception {

            System.out.println("\n ### Olá, seja bem vindo ao magnífico programa Minha Casa - Minha Desgraça ###\n");

            ImoveisParaFinanciamento opcoesParaFinanciamento = new ImoveisParaFinanciamento();


            /**
             * INÍCIO
             *
             * NÃO MODIFICAR ESTA CLASSE ANTES DESTA LINHA.
             */
            Endereco endereco1 = new Endereco("Parma", 77, 0, "Vista Alegre", "Tramandai", UnidadeFederativa.RIOGRANDEDOSUL);
            Endereco endereco2 = new Endereco("Albano Hansen", 156, 0, "Sete de Setembro", "Sao Paulo", UnidadeFederativa.RIOGRANDEDOSUL);
            Endereco endereco3 = new Endereco("Tiradentes", 188, 203, "Centro", "Canoas", UnidadeFederativa.RIOGRANDEDOSUL);
            Endereco endereco4 = new Endereco("José de Alencar", 1544, 0, "Menino Deus", "Ivoti", UnidadeFederativa.RIODEJANEIRO);
            Endereco endereco5 = new Endereco("Presidente Lucena", 23678, 2, "Travessão", "Dois Irmaos", UnidadeFederativa.SAOPAULO);
            Endereco endereco6 = new Endereco("Av. do Forte", 153, 10, "Copacabana", "Rio de Janeiro", UnidadeFederativa.RIODEJANEIRO);
            Endereco endereco7 = new Endereco("Av. Brasil", 98, 0, "Jardim Paulista", "São Paulo", UnidadeFederativa.SAOPAULO);
            Endereco endereco8 = new Endereco("Av. Amazonas", 1765, 0, "Travessão", "Dois Irmaos", UnidadeFederativa.RIOGRANDEDOSUL);
            Endereco endereco9 = new Endereco("Heitor Beltrão", 78, 15, "Tijuca", "Rio de Janeiro", UnidadeFederativa.RIODEJANEIRO);
            Endereco endereco10 = new Endereco("Av. General Osório", 432, 0, "Conceicao", "Campinas", UnidadeFederativa.SAOPAULO);
            Casa casa1 = new Casa(endereco1, 1000001, "Sim");
            opcoesParaFinanciamento.registrarImovel(casa1);
            Casa casa2 = new Casa(endereco2, 49999, "Não");
            opcoesParaFinanciamento.registrarImovel(casa2);
            Casa casa3 = new Casa(endereco3, 500000, "Sim");
            opcoesParaFinanciamento.registrarImovel(casa3);
            Casa casa4 = new Casa(endereco4, 500000, "Sim");
            opcoesParaFinanciamento.registrarImovel(casa4);
            Casa casa5 = new Casa(endereco5, 500000, "Não");
            opcoesParaFinanciamento.registrarImovel(casa5);
            Apartamento apartamento1 = new Apartamento(endereco6, 1000001, 3);
            opcoesParaFinanciamento.registrarImovel(apartamento1);
            Apartamento apartamento2 = new Apartamento(endereco7, 49999, 13);
            opcoesParaFinanciamento.registrarImovel(apartamento2);
            Apartamento apartamento3 = new Apartamento(endereco8, 500000, 7);
            opcoesParaFinanciamento.registrarImovel(apartamento3);
            Apartamento apartamento4 = new Apartamento(endereco9, 500000, 8);
            opcoesParaFinanciamento.registrarImovel(apartamento4);
            Apartamento apartamento5 = new Apartamento(endereco10, 500000, 8);
            opcoesParaFinanciamento.registrarImovel(apartamento5);


            /**
             * FIM
             *
             * NÃO MODIFICAR ESTA CLASSE APÓS ESTA LINHA.
             */


            List<Imovel> todasAsOpcoes = opcoesParaFinanciamento.buscarOpcoes(Double.MAX_VALUE);
            if (todasAsOpcoes == null || todasAsOpcoes.isEmpty()) {
                throw new RuntimeException("\n\nAtenção! Você precisa registrar opções de financiamento antes de começar a usar o programa.\n"
                        + "Use o método 'registrarImovel', do objeto 'opcoesParaFinanciamento', para incluir algumas opções.\n");
            }

            System.out.println("\nVamos lá, preciso de algumas respostas...\n");
            Thread.sleep(1000);

            System.out.println(" Qual é o teu nome?");
            String nomeBeneficiario = new Scanner(System.in).next();
            Thread.sleep(500);

            System.out.println(" Agora eu preciso saber sobre a mascada, " + nomeBeneficiario + ". Qual é o teu salário?");
            double salarioBeneficiario = new Scanner(System.in).nextDouble();
            Thread.sleep(500);

            Beneficiario beneficiario = new Beneficiario(nomeBeneficiario, salarioBeneficiario);

            System.out.println(" Hummmm, tá grandão hein. E qual é o limite do valor de imóveis que você procura?");
            double valorParaPesquisa = new Scanner(System.in).nextDouble();
            Thread.sleep(500);

            System.out.println("\nTá, deixa eu ver aqui o que eu tenho de opções até " + DecimalFormat.getCurrencyInstance().format(valorParaPesquisa) + "...");
            Thread.sleep(new Random().nextInt(4000) + 1000);

            List<Imovel> opcoesViaveis = opcoesParaFinanciamento.buscarOpcoes(valorParaPesquisa);
            if (opcoesViaveis == null || opcoesViaveis.isEmpty()) {
                throw new RuntimeException("\n\nPQP! Essa desgraça de programa não tem casas neste valor! Comece uma nova simulação.");
            }

            System.out.println("\nCerto! Encontrei " + opcoesViaveis.size() + " opções aqui. Dá uma olhada:");
            int index = 0;
            for (Imovel imovel : opcoesViaveis) {
                System.out.printf(" [%d] %s\n", ++index, imovel.apresentcao());
                Thread.sleep(250);
            }

            Imovel imovelEscolhido = null;
            while (imovelEscolhido == null) {

                Thread.sleep(250);

                System.out.println("\nQual a opção que mais te agrada? (Me diz apenas o número.)");
                int opcaoEscolhida = new Scanner(System.in).nextInt();

                Thread.sleep(250);

                if (opcaoEscolhida < 1 || opcaoEscolhida > opcoesViaveis.size()) {
                    System.out.println(" > Opção inválida!");
                } else {
                    imovelEscolhido = opcoesViaveis.get(opcaoEscolhida - 1);
                }
            }

            System.out.println("\nShow de bola! Agora me diz em quantos meses você quer pagar essa tranqueira:");
            int mesesParaPagamento = new Scanner(System.in).nextInt();

            System.out.printf("\nHumm, certo %s. Você ganha %s e quer financiar um imóvel de %s, no estado %s, pagando em %d meses. Deixa eu ver se é possível...\n\n",
                    beneficiario.getNome(),
                    DecimalFormat.getCurrencyInstance().format(beneficiario.getSalario()),
                    DecimalFormat.getCurrencyInstance().format(imovelEscolhido.getValor()),
                    imovelEscolhido.getEndereco().getEstado(),
                    mesesParaPagamento);
            Thread.sleep(new Random().nextInt(4000) + 1000);

            PropostaFinanciamento financiamento = new PropostaFinanciamento(beneficiario, imovelEscolhido, mesesParaPagamento);
            financiamento.validarProposta();
    }
}
