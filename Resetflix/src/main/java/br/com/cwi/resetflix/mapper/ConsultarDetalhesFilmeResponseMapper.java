package br.com.cwi.resetflix.mapper;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.response.AtoresResponse;
import br.com.cwi.resetflix.response.ConsultarDetalhesFilmeResponse;
import br.com.cwi.resetflix.response.DiretoresResponse;

import java.util.List;

public class ConsultarDetalhesFilmeResponseMapper {
    public ConsultarDetalhesFilmeResponse mapear(FilmeEntity filmePorId, List<AtorEntity> atorEntityList, DiretorEntity diretorEntity) {
        List <AtoresResponse> atoresResponse = new AtoresResponseMapper().mapear(atorEntityList);
        DiretoresResponse diretoresResponse = new DiretoresResponse(diretorEntity.getId(),diretorEntity.getNome());
        return new ConsultarDetalhesFilmeResponse(filmePorId.getId(),filmePorId.getNome(),filmePorId.getGenero(),diretoresResponse,atoresResponse, filmePorId.isFilmeAssistido());
    }
}
