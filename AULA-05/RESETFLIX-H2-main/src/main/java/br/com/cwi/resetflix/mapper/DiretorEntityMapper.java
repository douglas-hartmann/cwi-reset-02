package br.com.cwi.resetflix.mapper;

import java.util.Collections;
import java.util.List;

import br.com.cwi.resetflix.entity.FilmeEntity;
import org.springframework.stereotype.Component;

import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.request.CriarDiretorRequest;

@Component
public class DiretorEntityMapper {

//    @Autowired
//    private FilmeRepository filmeRepository;

    public DiretorEntity mapear(final CriarDiretorRequest request, final List<FilmeEntity> filmes) {
        return new DiretorEntity(request.getNome(), filmes);
    }
}
