package br.com.cwi.resetflix.service;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.SerieEntity;
import br.com.cwi.resetflix.exception.NotFoundException;
import br.com.cwi.resetflix.exception.UsuarioDesocupadoException;
import br.com.cwi.resetflix.mapper.ConsultarDetalhesSerieResponseMapper;
import br.com.cwi.resetflix.mapper.SerieEntityMapper;
import br.com.cwi.resetflix.mapper.SerieResponseMapper;
import br.com.cwi.resetflix.repository.AtoresRepository;
import br.com.cwi.resetflix.repository.SerieRepository;
import br.com.cwi.resetflix.request.CriarSerieRequest;
import br.com.cwi.resetflix.response.ConsultarDetalhesSerieResponse;
import br.com.cwi.resetflix.response.SerieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SerieService {

    @Autowired
    SerieRepository serieRepository;

    @Autowired
    AtoresRepository atoresRepository;

    private static SerieResponseMapper MAPPER_RESPONSE = new SerieResponseMapper();
    private static SerieEntityMapper MAPPER_ENTITY = new SerieEntityMapper();
    private static ConsultarDetalhesSerieResponseMapper MAPPER_DETALHES_SERIE_RESPONSE = new ConsultarDetalhesSerieResponseMapper();

    public List<SerieResponse> getSerie(Genero genero) {
        List<SerieEntity> series = serieRepository.getSerie(genero);
        if(series.size() == 0){
            throw new NotFoundException("Nenhuma série do gênero " + genero + " cadastrada no sistema.");
        }
        return MAPPER_RESPONSE.mapear(series);
    }

    public Long criarSerie(CriarSerieRequest request) {
        SerieEntity serieSalvar = MAPPER_ENTITY.mapear(request);
        return serieRepository.criarSerie(serieSalvar);
    }


    public ConsultarDetalhesSerieResponse consultarDetalheSerie(Long id) {
        SerieEntity seriePorId = serieRepository.consultarSeriePorId(id);
        verificaSeExisteIdCadastradaSerie(seriePorId,id);
        List<Long> idAtoresDaSerie = serieRepository.acharAtoresDaSeriePorId(id);
        List<AtorEntity> atoresDaSerie = atoresRepository.acharAtoresDaSerie(idAtoresDaSerie);
        return MAPPER_DETALHES_SERIE_RESPONSE.mapear(seriePorId,atoresDaSerie);
    }

    public void assitirSerie(Long id, Integer temporada, Integer episodio) {
        SerieEntity seriePorId = serieRepository.consultarSeriePorId(id);
        verificaSeExisteIdCadastradaSerie(seriePorId,id);
        seriePorId.getEpisodiosAssitidos().get(temporada-1).getEpisodios().get(episodio-1).assistirEpisodio();
    }

    public void verificaSeExisteIdCadastradaSerie(SerieEntity seriePorId, Long id){
        if (seriePorId == null) {
            throw new NotFoundException("Serie com id: " + id + " não encontrada no sistema.");
        }
    }

    public List<SerieResponse> getRecomendacoes() {
        List<Genero> generosAssistidos = serieRepository.getRecomendacoes();
        if (generosAssistidos.size() == 0) {
            throw new UsuarioDesocupadoException("Impossivel sugerir séries, pois o usuário não iniciou nenhuma série.");
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
        List <SerieEntity> seriesRecomendadas = serieRepository.buscarSeriePorGenero(generoMaisAssistido);
        if (seriesRecomendadas.size() == 0) {
            throw new NotFoundException("Nenhuma série do gênero " + generoMaisAssistido + " para sugerir");
        }
        return MAPPER_RESPONSE.mapear(seriesRecomendadas);
    }
}
