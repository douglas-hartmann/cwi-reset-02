package exercicio2;

import java.time.LocalDate;

public class Ator extends Pessoa {

        private int quantidadeOscar;

        public Ator(String nome, LocalDate dataNascimento, int quantidadeOscar, Genero genero) {
            super(nome,dataNascimento,genero);
            this.quantidadeOscar = quantidadeOscar;
        }

        @Override
        public void imprimirInformacoes() {
            System.out.println("Ator");
            super.imprimirInformacoes();
            System.out.println("Quantidade de Oscar: " + this.quantidadeOscar);
        }

    }
