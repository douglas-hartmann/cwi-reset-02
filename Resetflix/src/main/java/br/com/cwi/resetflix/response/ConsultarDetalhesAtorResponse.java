package br.com.cwi.resetflix.response;

import java.util.List;

public class ConsultarDetalhesAtorResponse {

    private Long id;
    private String nome;
    private List<FilmeResponse> filmes;

    public ConsultarDetalhesAtorResponse(final Long id, final String nome,
        final List<FilmeResponse> filmes) {
        this.id = id;
        this.nome = nome;
        this.filmes = filmes;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<FilmeResponse> getFilmes() {
        return filmes;
    }
}
