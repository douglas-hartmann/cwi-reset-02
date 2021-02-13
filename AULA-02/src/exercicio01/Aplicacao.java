package exercicio01;

public class Aplicacao {

    public static void main(String[] args) {

        Diretor diretor = new Diretor("Douglas",25,10);
        Filme filme = new Filme("Coringa","O filme retrata... ",180,2019,3,diretor);
        filme.reproduzirFilme();
        Filme filme2 = new Filme("Batman","O filme conta... ",280,2008,4,diretor);
        filme2.reproduzirFilme();

    }
}
