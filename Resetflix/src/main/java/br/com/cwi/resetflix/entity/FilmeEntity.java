package br.com.cwi.resetflix.entity;

import br.com.cwi.resetflix.domain.Genero;
import java.util.List;

public class FilmeEntity {

    private Long id;
    private String nome;
    private Genero genero;
    private final Long idDiretor;
    private final List<Long> idsAtores;
    private boolean filmeAssistido=false;

    public FilmeEntity(final Long id, final String nome, final Genero genero, final Long idDiretor,
        final List<Long> idsAtores, boolean filmeAssistido) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.idDiretor = idDiretor;
        this.idsAtores = idsAtores;
        this.filmeAssistido=filmeAssistido;
    }

    public FilmeEntity(final String nome, final Long idDiretor, final List<Long> idsAtores, final Genero genero) {
        this.nome = nome;
        this.genero = genero;
        this.idDiretor = idDiretor;
        this.idsAtores = idsAtores;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(final Genero genero) {
        this.genero = genero;
    }

    public Long getIdDiretor() {
        return idDiretor;
    }

    public List<Long> getIdsAtores() {
        return idsAtores;
    }

    public boolean isFilmeAssistido() {
        return filmeAssistido;
    }

    public void setFilmeAssistido(boolean filmeAssistido) {
        this.filmeAssistido = filmeAssistido;
    }
}
