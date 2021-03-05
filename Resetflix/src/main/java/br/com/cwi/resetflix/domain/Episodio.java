package br.com.cwi.resetflix.domain;

public class Episodio {
    private final Integer numeroEpisodio;
    private Boolean assistido;

    public Episodio(Integer numeroEpisodio, Boolean assistido) {
        this.numeroEpisodio = numeroEpisodio;
        this.assistido = assistido;
    }

    public Integer getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public Boolean getAssistido() {
        return assistido;
    }

    public void assistirEpisodio() {
        this.assistido = true;
    }
}
