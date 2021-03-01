package exercicio2;

import java.time.LocalDate;

public class Diretor extends Pessoa {

        private int quantidadeFilmes;

        public Diretor(String nome, LocalDate dataNascimento, int quantidadeFilmes, Genero genero) {
            super(nome, dataNascimento, genero);
            this.quantidadeFilmes = quantidadeFilmes;
        }

        @Override
        public void imprimirInformacoes() {
            System.out.println("Diretor");
            super.imprimirInformacoes();
            System.out.println("Quantidade de Filmes: " + this.quantidadeFilmes);
        }
    }
