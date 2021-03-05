package br.com.cwi.resetflix.response;

import br.com.cwi.resetflix.domain.Genero;

public class FilmeResponse {

    private Long id;
    private String nome;
    private Genero genero;

    public FilmeResponse(final Long id, final String nome, final Genero genero) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public Genero getGenero() {
        return genero;
    }

    public Long getId() {
        return id;
    }
}
