package br.com.cwi.resetflix.request;

import java.util.List;
import br.com.cwi.resetflix.domain.Genero;

public class CriarFilmeRequest {

    private final String nome;
    private final Long idDiretor;
    private final List<Long> idsAtores;
    private final Genero genero;

    public CriarFilmeRequest(final String nome, final Long idDiretor, final List<Long> idsAtores, final Genero genero) {
        this.nome = nome;
        this.idDiretor = idDiretor;
        this.idsAtores = idsAtores;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public Long getIdDiretor() {
        return idDiretor;
    }

    public List<Long> getIdsAtores() {
        return idsAtores;
    }

    public Genero getGenero() {
        return genero;
    }
}
