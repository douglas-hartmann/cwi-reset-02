package exercicio2;

import java.time.LocalDate;
import java.time.Period;

public class Pessoa {

        private String nome;
        private LocalDate dataNascimento;
        private Genero genero;
        private Integer idade;

        public Pessoa(String nome, LocalDate dataNascimento, Genero genero) {
            this.nome = nome;
            this.dataNascimento = dataNascimento;
            this.genero = genero;
        }

        public void imprimirInformacoes() {
            Period periodo = Period.between(dataNascimento,LocalDate.now());
            idade = periodo.getYears();
            System.out.println("Nome: " + getNome());
            System.out.println("Idade: " + idade);
            System.out.println("Genero: " + getGenero().getGenero());
        }

        public String getNome() {
            return nome;
        }

       public Genero getGenero() {
           return genero;
       }

   }
