package br.com.cwi.resetflix.mapper;

import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.response.DiretoresResponse;
import java.util.ArrayList;
import java.util.List;

public class DiretorResponseMapper {

    public List<DiretoresResponse> mapear(List<DiretorEntity> diretores) {
        List<DiretoresResponse> diretoresResponses = new ArrayList<>();
        for (DiretorEntity diretorEntity : diretores){
            DiretoresResponse diretoresResponse = new DiretoresResponse(diretorEntity.getId(),diretorEntity.getNome());
            diretoresResponses.add(diretoresResponse);
        }
        return diretoresResponses;
    }
}
