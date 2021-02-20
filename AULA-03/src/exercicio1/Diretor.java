package exercicio1;

    public class Diretor extends Pessoa {

        private int quantidadeFilmes;

        public Diretor(String nome, int idade, int quantidadeFilmes, Genero genero) {
            super(nome, idade, genero);
            this.quantidadeFilmes = quantidadeFilmes;
        }

        @Override
        public void imprimirInformacoes() {
            System.out.println("Diretor");
            super.imprimirInformacoes();
            System.out.println("Quantidade de Filmes: " + this.quantidadeFilmes);
        }
    }
