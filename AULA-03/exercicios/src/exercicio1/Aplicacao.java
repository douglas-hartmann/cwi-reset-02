package exercicio1;

import java.util.ArrayList;
import java.util.List;

public class Aplicacao {

    public static void main(String[] args) {

        List<Pessoa> elenco = new ArrayList<>();
        Ator ator1 = new Ator("JOLIE",33,3,Genero.FEMININO);
        elenco.add(ator1);
        Ator ator2 = new Ator("DICAPRIO",45,6,Genero.MASCULINO);
        elenco.add(ator2);
        Ator ator3 = new Ator("STALLONE",78,15,Genero.MASCULINO);
        elenco.add(ator3);

        Diretor diretor = new Diretor("Douglas",25,10,Genero.MASCULINO);
        elenco.add(diretor);
        Filme filme = new Filme("Batman vs Superman","O filme retrata... ",180,2019,10,diretor,elenco);
        filme.exibirCreditos();
    }
}
