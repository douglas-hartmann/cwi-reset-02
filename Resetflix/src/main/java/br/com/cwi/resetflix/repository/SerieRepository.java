package br.com.cwi.resetflix.repository;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.SerieEntity;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SerieRepository {

    private List<SerieEntity> series = new ArrayList<>();
    private Long controleIds = 1L;

    public List<SerieEntity> getSerie(Genero genero) {
        List<SerieEntity> listaSerieGenero = new ArrayList<>();
        for(SerieEntity serieGenero : series){
            if(serieGenero.getGenero().equals(genero)){
                listaSerieGenero.add(serieGenero);
            }
        }
        return listaSerieGenero;
    }

    public Long criarSerie(SerieEntity serieSalvar) {
        if(serieSalvar.getId()==null){
            serieSalvar.setId(controleIds);
            controleIds++;
        }
        series.add(serieSalvar);
        return serieSalvar.getId();
    }

    public SerieEntity consultarSeriePorId(Long id) {
        for (SerieEntity seriePorId: series){
            if(seriePorId.getId().equals(id)){
                return seriePorId;
            }
        }
        return null;
    }

    public List<Long> acharAtoresDaSeriePorId(Long id) {
        for(SerieEntity serie : series){
            if(serie.getId().equals(id)){
                return serie.getIdsAtores();
            }
        }
        return null;
    }

    public List<Genero> getRecomendacoes() {
        List<Genero> generosAssistidos = new ArrayList<>();
        for(SerieEntity serie : series){
            //verifica se o primeiro episodio da serie foi assistido.
            if(serie.getEpisodiosAssitidos().get(0).getEpisodios().get(0).getAssistido()){
                generosAssistidos.add(serie.getGenero());
            }
        }
        return generosAssistidos;
    }

    public List<SerieEntity> buscarSeriePorGenero(Genero generoMaisAssistido) {
        List<SerieEntity> seriesRecomendadas = new ArrayList<>();
        for (SerieEntity serie : series){
            if(serie.getGenero().equals(generoMaisAssistido) && !serie.getEpisodiosAssitidos().get(0).getEpisodios().get(0).getAssistido()){
                seriesRecomendadas.add(serie);
            }
        }
        return seriesRecomendadas;
    }
}
