package exercicio2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Aplicacao {

    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate meunascimento = LocalDate.parse("25-04-1995", formatter);

        Pessoa nascimento = new Pessoa("Douglas",meunascimento,Genero.MASCULINO);
        nascimento.imprimirInformacoes();

       /* List<Pessoa> elenco = new ArrayList<>();
        Ator ator1 = new Ator("JOLIE","1995-04-25",3, Genero.FEMININO);
        elenco.add(ator1);
        Ator ator2 = new Ator("DICAPRIO","1995-04-25",6,Genero.MASCULINO);
        elenco.add(ator2);
        Ator ator3 = new Ator("STALLONE","1995-04-25",15,Genero.MASCULINO);
        elenco.add(ator3);

        Diretor diretor = new Diretor("Douglas","1995-04-25",10,Genero.MASCULINO);
        elenco.add(diretor);
        Filme filme = new Filme("Batman vs Superman","O filme retrata... ",180,2019,10,diretor,elenco);
        filme.exibirCreditos();*/

    }
}
