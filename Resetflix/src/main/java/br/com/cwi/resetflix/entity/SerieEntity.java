package br.com.cwi.resetflix.entity;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.domain.Temporada;
import java.util.ArrayList;
import java.util.List;

public class SerieEntity {

    private Long id;
    private String nome;
    private Genero genero;
    private final Integer episodios;
    private final Integer temporadas;
    private final List<Long> idsAtores;
    private final List<Temporada> episodiosAssitidos = new ArrayList<>();

    public SerieEntity(Long id, String nome, Genero genero, Integer episodios, Integer temporadas, List<Long> idsAtores) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.episodios = episodios;
        this.temporadas = temporadas;
        this.idsAtores = idsAtores;
    }

    public SerieEntity(String nome, Genero genero, Integer episodios, Integer temporadas, List<Long> idsAtores) {
        this.nome = nome;
        this.genero = genero;
        this.episodios = episodios;
        this.temporadas = temporadas;
        this.idsAtores = idsAtores;
        criarEpisodiosAssitidos(episodios, temporadas);

    }

    public void criarEpisodiosAssitidos(Integer episodios, Integer temporadas) {
        Integer i = 1;
        while (i <= temporadas) {
            episodiosAssitidos.add(new Temporada(i, episodios));
            i++;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
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

    public List<Temporada> getEpisodiosAssitidos() {
        return episodiosAssitidos;
    }
}

