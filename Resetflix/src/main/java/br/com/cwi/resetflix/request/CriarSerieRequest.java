package br.com.cwi.resetflix.request;

import br.com.cwi.resetflix.domain.Genero;
import java.util.List;

public class CriarSerieRequest {

    private final String nome;
    private final Integer episodios;
    private final Integer temporadas;
    private final List<Long> idsAtores;
    private final Genero genero;

    public CriarSerieRequest(String nome, Integer episodios, Integer temporadas, List<Long> idsAtores, Genero genero) {
        this.nome = nome;
        this.episodios = episodios;
        this.temporadas = temporadas;
        this.idsAtores = idsAtores;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public Integer getEpisodios() {
        return episodios;
    }

    public Integer getTemporadas() {
        return temporadas;
    }

    public List<Long> getIdsAtores() {
        return idsAtores;
    }

    public Genero getGenero() {
        return genero;
    }
}
