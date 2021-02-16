package exercicios;

public class Aplicacao {

    public static void main(String[] args) {

        /*
        EXERCICIO 1
        Diretor diretor = new Diretor("Douglas",25,10,Genero.MASCULINO);
        Filme filme = new Filme("Coringa","O filme retrata... ",180,2019,3,diretor);
        filme.reproduzirFilme();
        Filme filme2 = new Filme("Batman","O filme conta... ",280,2008,4,diretor);
        filme2.reproduzirFilme(); */

        /* EXERCÍCIO 2
        Diretor diretor = new Diretor("Douglas",25,10,Genero.MASCULINO);
        Ator ator = new Ator("Betina",25,15,Genero.FEMININO);
        diretor.imprimirNome();
        ator.imprimirNome();*/

        //EXERCICIO 3
        Diretor diretor = new Diretor("Douglas",25,10,Genero.MASCULINO);
        Filme filme = new Filme("Batman vs Superman","O filme retrata... ",180,2019,10,diretor);
        filme.reproduzirFilme();
    }
}
