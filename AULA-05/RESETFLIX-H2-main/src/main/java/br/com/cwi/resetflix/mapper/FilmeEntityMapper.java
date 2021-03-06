package br.com.cwi.resetflix.mapper;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.repository.AtoresRepository;
import br.com.cwi.resetflix.repository.DiretoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.request.CriarFilmeRequest;

import java.util.List;

@Component
public class FilmeEntityMapper {

    @Autowired
    private AtoresRepository atoresRepository;

    @Autowired
    private DiretoresRepository diretoresRepository;

    public FilmeEntity mapear(final CriarFilmeRequest request) {
        List<AtorEntity> atores = atoresRepository.findAllById(request.getIdsAtores());
        DiretorEntity diretor = diretoresRepository.getOne(request.getIdDiretor());
        return new FilmeEntity(request.getNome(), request.getGenero(), diretor, atores);
    }
}
