package br.com.cwi.resetflix.response;

import java.util.List;
import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.domain.Temporada;

public class ConsultarDetalhesSerieResponse {

    private Long id;
    private String nome;
    private Genero genero;
    private Integer episodios;
    private Integer temporadas;
    private List<AtoresResponse> atores;
    private List<Temporada> episodiosAssistidos;

    public ConsultarDetalhesSerieResponse(Long id, String nome, Genero genero, Integer episodios, Integer temporadas, List<AtoresResponse> atores, List<Temporada> episodiosAssitidos) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.episodios = episodios;
        this.temporadas = temporadas;
        this.atores = atores;
        this.episodiosAssistidos=episodiosAssitidos;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Genero getGenero() {
        return genero;
    }

    public Integer getEpisodios() {
        return episodios;
    }

    public Integer getTemporadas() {
        return temporadas;
    }

    public List<AtoresResponse> getAtores() {
        return atores;
    }

    public List<Temporada> getEpisodiosAssistidos() {
        return episodiosAssistidos;
    }

}
