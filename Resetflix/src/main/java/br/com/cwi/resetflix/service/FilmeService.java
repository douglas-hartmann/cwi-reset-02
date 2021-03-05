package br.com.cwi.resetflix.service;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.exception.NotFoundException;
import br.com.cwi.resetflix.exception.UsuarioDesocupadoException;
import br.com.cwi.resetflix.mapper.ConsultarDetalhesFilmeResponseMapper;
import br.com.cwi.resetflix.mapper.FilmeEntityMapper;
import br.com.cwi.resetflix.mapper.FilmeResponseMapper;
import br.com.cwi.resetflix.repository.AtoresRepository;
import br.com.cwi.resetflix.repository.DiretorRepository;
import br.com.cwi.resetflix.repository.FilmeRepository;
import br.com.cwi.resetflix.request.CriarFilmeRequest;
import br.com.cwi.resetflix.response.ConsultarDetalhesFilmeResponse;
import br.com.cwi.resetflix.response.FilmeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FilmeService {

    @Autowired
    FilmeRepository filmeRepository;

    @Autowired
    AtoresRepository atoresRepository;

    @Autowired
    DiretorRepository diretorRepository;

    static FilmeEntityMapper MAPPER_ENTITY = new FilmeEntityMapper();
    static FilmeResponseMapper MAPPER_RESPONSE_LIST = new FilmeResponseMapper();
    static ConsultarDetalhesFilmeResponseMapper MAPPER_DETALHES_RESPONSE = new ConsultarDetalhesFilmeResponseMapper();

    public Long criarFilme(CriarFilmeRequest request) {
        FilmeEntity filmeSalvar = MAPPER_ENTITY.mapear(request);
        return filmeRepository.criarFilme(filmeSalvar);
    }

    public List<FilmeResponse> getFilmes(Genero genero) {
        List<FilmeEntity> filmes = filmeRepository.getFilmes(genero);
        if(filmes.size() == 0 ){
            throw new NotFoundException("Nenhum filme do gênero " + genero + " cadastrado no sistema.");
        }
        return MAPPER_RESPONSE_LIST.mapear(filmes);
    }

    public ConsultarDetalhesFilmeResponse consultarDetalhesFilme(Long id) {
        FilmeEntity filmePorId = filmeRepository.consultarPorId(id);
        verificaSeExisteIdCadastradaFilme(filmePorId,id);
        List<AtorEntity> atorEntityList = atoresRepository.acharAtoresFilme(id);
        Long idDiretor = filmeRepository.acharIdDiretor(filmePorId);
        DiretorEntity diretorEntity = diretorRepository.retornarDiretorFilme(idDiretor);
        if (diretorEntity == null) {
            throw new NotFoundException("Diretor com id: " + idDiretor + " não cadastrado no sistema. ");
        }
        return MAPPER_DETALHES_RESPONSE.mapear(filmePorId,atorEntityList,diretorEntity);
    }

    public void assistirFilme(Long id) {
        FilmeEntity filmePorId = filmeRepository.consultarPorId(id);
        verificaSeExisteIdCadastradaFilme(filmePorId,id);
        filmePorId.setFilmeAssistido(true);
    }

    public void verificaSeExisteIdCadastradaFilme(FilmeEntity filmePorId, Long id){
        if (filmePorId == null) {
            throw new NotFoundException("Filme com id: " + id + " não encontrado no sistema.");
        }
    }

    public List<FilmeResponse> getRecomendacoes() {

        List<Genero> generosAssistidos = filmeRepository.getRecomendacoes();
        if(generosAssistidos.size() == 0){
            throw new UsuarioDesocupadoException("Impossivel sugerir filme, pois o usuário não assistiu nenhum filme.");
        }
        Map<Genero,Integer> generoMap = new HashMap<>();
        for(Genero generoAssistido : generosAssistidos){
            if(generoMap.containsKey(generoAssistido)){
                Integer oldValue = generoMap.get(generoAssistido);
                generoMap.put(generoAssistido,++oldValue);
            }else{
                generoMap.put(generoAssistido,1);
            }
        }
        //iterar sobre o hashMap
        Genero generoMaisAssistido=null;
        Integer indice=0;
        for(Map.Entry<Genero,Integer> entrada : generoMap.entrySet()){
            if(entrada.getValue()>indice){
                indice=entrada.getValue();
                generoMaisAssistido = entrada.getKey();
            }
        }
        List <FilmeEntity> filmesRecomendados = filmeRepository.buscarFilmePorGenero(generoMaisAssistido);
        if (filmesRecomendados.size() == 0) {
            throw new NotFoundException("Nenhum filme do gênero " + generoMaisAssistido + " para sugerir");
        }
        return MAPPER_RESPONSE_LIST.mapear(filmesRecomendados);
    }
}
