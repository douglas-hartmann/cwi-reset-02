package br.com.cwi.resetflix.mapper;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.SerieEntity;
import br.com.cwi.resetflix.response.AtoresResponse;
import br.com.cwi.resetflix.response.ConsultarDetalhesSerieResponse;
import java.util.List;

public class ConsultarDetalhesSerieResponseMapper {
    public ConsultarDetalhesSerieResponse mapear(SerieEntity seriePorId, List<AtorEntity> atoresDaSerie) {
        List <AtoresResponse> atoresResponse = new AtoresResponseMapper().mapear(atoresDaSerie);
        return new ConsultarDetalhesSerieResponse(seriePorId.getId(),seriePorId.getNome(),seriePorId.getGenero(),seriePorId.getEpisodios(),seriePorId.getTemporadas(),atoresResponse, seriePorId.getEpisodiosAssitidos());
    }
}
