package com.company;

import com.company.dominio.Editora;
import com.company.dominio.Filme;
import com.company.enumeradores.Genero;
import com.company.heranca.Diretor;

public class AplicacaoTeste {

    public static void main(String[] args){

        Editora editora = new Editora("DC Comics","Porto Alegre");
        Diretor diretor = new Diretor("Douglas",25,10, Genero.MASCULINO);
        Filme filme = new Filme("Batman","O filme conta... ",280,2008,6,diretor);

    }

}
