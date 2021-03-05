package br.com.cwi.resetflix.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import br.com.cwi.resetflix.entity.AtorEntity;

@Repository
public class AtoresRepository {
    static List<AtorEntity> atores = new ArrayList<>();
    static Long contadorIds = 1L;
    public List<AtorEntity> getAtores(){
        return atores;
    }

    public Long criarAtor(final AtorEntity atorSalvar) {
        if(atorSalvar.getId() == null){
            atorSalvar.setId(contadorIds);
            contadorIds++;
        }
        atores.add(atorSalvar);
        return atorSalvar.getId();
    }

    public AtorEntity acharAtorPorId(final Long id) {
        for(AtorEntity atorEntity : atores){
            if(atorEntity.getId().equals(id)){
                return atorEntity;
            }
        }
        return null;
    }

    public List<AtorEntity> acharAtoresFilme(Long id) {
        List<AtorEntity> listaAtoresDoFilme = new ArrayList<>();
        for(AtorEntity atoresFilme : atores){
            for(Long idFilme : atoresFilme.getIdsFilmes() ){
                if(idFilme.equals(id)){
                    listaAtoresDoFilme.add(atoresFilme);
                }
            }
        }
        return listaAtoresDoFilme;
    }

    public List<AtorEntity> acharAtoresDaSerie(List<Long> idAtoresDaSerie) {
        List<AtorEntity> listaAtoresDaSerie = new ArrayList<>();
        for (AtorEntity ator : atores){
            for(Long idAtor : idAtoresDaSerie){
                if(ator.getId().equals(idAtor)){
                    listaAtoresDaSerie.add(ator);
                }
            }
        }
        return listaAtoresDaSerie;
    }
}
