package com.company.dominio;

import com.company.Exceptions.EditoraException;

public class Editora {
    private static final String NOME_INVALIDO = "DC Comics";
    private String nome;
    private String cidadeSede;

    public Editora(String nome, String cidadeSede) {
        this.nome = nome;
        regitraEditora();
        this.cidadeSede = cidadeSede;
    }

    public void regitraEditora() {
        if (nome.equals(NOME_INVALIDO)) {
            throw new EditoraException("Impossível instanciar esta editora");
        }
        else{
            System.out.println("Editora cadastrada!");
            System.out.println("Nome: " + this.nome);
        }

    }


}
