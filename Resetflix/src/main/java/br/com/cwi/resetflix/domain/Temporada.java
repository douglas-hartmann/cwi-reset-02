package br.com.cwi.resetflix.domain;

import java.util.ArrayList;
import java.util.List;

public class Temporada {
    private final Integer temporada;
    private final Integer numeroEpisodios;
    private List<Episodio> episodios = new ArrayList<>();


    public Temporada(Integer temporada, Integer numeroEpisodios) {
        this.temporada = temporada;
        this.numeroEpisodios=numeroEpisodios;
        criarEpisodio();
    }

    public void criarEpisodio() {
        Integer i = 1;
        while (i <= this.numeroEpisodios) {
            episodios.add(new Episodio(i,false));
            i++;
        }
    }

    public Integer getTemporada() {
        return temporada;
    }

    public List<Episodio> getEpisodios() {
        return episodios;
    }
}
