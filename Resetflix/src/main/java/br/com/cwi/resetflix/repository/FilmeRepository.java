package br.com.cwi.resetflix.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.FilmeEntity;

@Repository
public class FilmeRepository {

    static List<FilmeEntity> filmes = new ArrayList<>();
    private Long contadorIds=1L;

    public List<FilmeEntity> getFilmes(Genero genero){
        List<FilmeEntity> listaFilmesGenero = new ArrayList<>();
        for(FilmeEntity filmesGenero : filmes){
            if(filmesGenero.getGenero().equals(genero)){
                listaFilmesGenero.add(filmesGenero);
            }
        }
        return listaFilmesGenero;
    }

    public List<FilmeEntity> acharFilmesAtor(final Long id) {
        List<FilmeEntity> listaFilmesAtor = new ArrayList<>();
        for(FilmeEntity filmesAtor : filmes){
            for(Long idAtor : filmesAtor.getIdsAtores()) {
                if (idAtor.equals(id)) {
                    listaFilmesAtor.add(filmesAtor);
                }
            }
        }
        return listaFilmesAtor;
    }

    public Long criarFilme(FilmeEntity filmeSalvar) {
        if(filmeSalvar.getId()==null){
            filmeSalvar.setId(contadorIds);
            contadorIds++;
        }
        filmes.add(filmeSalvar);
        return filmeSalvar.getId();
    }

    public List<FilmeEntity> acharFilmesDiretor(Long id) {
        List<FilmeEntity> listaFilmesDiretor = new ArrayList<>();
        for(FilmeEntity filmesDiretor : filmes){
                if (filmesDiretor.getIdDiretor().equals(id)) {
                    listaFilmesDiretor.add(filmesDiretor);
                }
        }
        return listaFilmesDiretor;
    }

    public FilmeEntity consultarPorId(Long id) {
        for (FilmeEntity filmePorId : filmes){
            if(filmePorId.getId().equals(id)){
                return filmePorId;
            }
        }
        return null;
    }

    public List<Genero> getRecomendacoes() {
        List<Genero> generosAssistidos = new ArrayList<>();
        for(FilmeEntity filme : filmes){
            if(filme.isFilmeAssistido()){
                generosAssistidos.add(filme.getGenero());
            }

        }
        return generosAssistidos;
    }

    public List<FilmeEntity> buscarFilmePorGenero(Genero generoMaisAssistido) {
        List<FilmeEntity> filmesRecomendados = new ArrayList<>();
        for (FilmeEntity filme : filmes){
            if(filme.getGenero().equals(generoMaisAssistido) && !filme.isFilmeAssistido()){
                filmesRecomendados.add(filme);
            }
        }
        return filmesRecomendados;

    }

    public Long acharIdDiretor(FilmeEntity filmePorId) {
        return filmePorId.getIdDiretor();
    }
}
