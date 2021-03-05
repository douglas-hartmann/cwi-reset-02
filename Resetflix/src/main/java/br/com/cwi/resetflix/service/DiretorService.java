package br.com.cwi.resetflix.service;

import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.exception.NotFoundException;
import br.com.cwi.resetflix.mapper.ConsultarDetalhesDiretorResponseMapper;
import br.com.cwi.resetflix.mapper.DiretorEntityMapper;
import br.com.cwi.resetflix.mapper.DiretorResponseMapper;
import br.com.cwi.resetflix.repository.DiretorRepository;
import br.com.cwi.resetflix.repository.FilmeRepository;
import br.com.cwi.resetflix.request.CriarDiretorRequest;
import br.com.cwi.resetflix.response.ConsultarDetalhesDiretorResponse;
import br.com.cwi.resetflix.response.DiretoresResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DiretorService {

    @Autowired
    DiretorRepository diretorRepository;

    @Autowired
    FilmeRepository filmeRepository;

    static DiretorResponseMapper MAPPER_RESPONSE = new DiretorResponseMapper();
    static DiretorEntityMapper MAPPER_ENTITY = new DiretorEntityMapper();
    static ConsultarDetalhesDiretorResponseMapper MAPPER_DETALHES_DIRETOR = new ConsultarDetalhesDiretorResponseMapper();

    public List<DiretoresResponse> getDiretores() {
        List<DiretorEntity> diretores = diretorRepository.getDiretores();
        if(diretores.size() == 0){
            throw new NotFoundException("Nenhum diretor cadastrado no sitema.");
        }
        return MAPPER_RESPONSE.mapear(diretores);
    }

    public Long criarDiretor(CriarDiretorRequest request) {
        DiretorEntity diretorSalvar = MAPPER_ENTITY.mapear(request);
        return diretorRepository.criarDiretor(diretorSalvar);
    }

    public ConsultarDetalhesDiretorResponse consultarDetalheDiretor(Long id) {
        DiretorEntity diretorPorId = diretorRepository.acharDiretorPorId(id);
        if (diretorPorId == null) {
            throw new NotFoundException("Diretor com " + id + " não encontrado no sistema.");
        }
        List<FilmeEntity> filmeEntity = filmeRepository.acharFilmesDiretor(id);
        return MAPPER_DETALHES_DIRETOR.mapear(diretorPorId,filmeEntity);
    }
}
