package br.com.cwi.resetflix.mapper;

import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.response.ConsultarDetalhesDiretorResponse;
import br.com.cwi.resetflix.response.FilmeResponse;
import java.util.List;

public class ConsultarDetalhesDiretorResponseMapper {
    public ConsultarDetalhesDiretorResponse mapear(DiretorEntity diretorPorId, List<FilmeEntity> filmeEntity) {
        List<FilmeResponse> filmeResponses = new FilmeResponseMapper().mapear(filmeEntity);
        return new ConsultarDetalhesDiretorResponse(diretorPorId.getId(),diretorPorId.getNome(),filmeResponses);
    }
}
