package br.com.cwi.resetflix.response;

import java.util.List;
import br.com.cwi.resetflix.domain.Genero;

public class ConsultarDetalhesFilmeResponse {

    private Long id;
    private String nome;
    private Genero genero;
    private DiretoresResponse diretor;
    private List<AtoresResponse> atores;
    private boolean filmeAssistido = false;

    public ConsultarDetalhesFilmeResponse(final Long id, final String nome, final Genero genero,
        final DiretoresResponse diretor, final List<AtoresResponse> atores, boolean filmeAssistido) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.diretor = diretor;
        this.atores = atores;
        this.filmeAssistido=filmeAssistido;
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

    public DiretoresResponse getDiretor() {
        return diretor;
    }

    public List<AtoresResponse> getAtores() {
        return atores;
    }

    public boolean isFilmeAssistido() {
        return filmeAssistido;
    }
}
