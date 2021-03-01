package exercicio1;

    public class Ator extends Pessoa{

        private int quantidadeOscar;

        public Ator(String nome, int idade, int quantidadeOscar, Genero genero) {
            super(nome,idade,genero);
            this.quantidadeOscar = quantidadeOscar;
        }

        @Override
        public void imprimirInformacoes() {
            System.out.println("Ator");
            super.imprimirInformacoes();
            System.out.println("Quantidade de Oscar: " + this.quantidadeOscar);
        }

    }
