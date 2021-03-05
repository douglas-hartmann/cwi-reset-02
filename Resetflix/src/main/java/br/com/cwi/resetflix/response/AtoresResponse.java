package br.com.cwi.resetflix.response;

public class AtoresResponse {

    Long id;
    String nome;

    public AtoresResponse(final Long id, final String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
