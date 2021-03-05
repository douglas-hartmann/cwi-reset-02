package br.com.cwi.resetflix.web;

import java.util.Collections;
import java.util.List;

import br.com.cwi.resetflix.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.request.CriarFilmeRequest;
import br.com.cwi.resetflix.response.ConsultarDetalhesFilmeResponse;
import br.com.cwi.resetflix.response.FilmeResponse;

@RestController
@RequestMapping("/filmes")
public class FilmesController implements FilmesContract {

    @Autowired
    private FilmeService filmeService;

    @Override
    @GetMapping
    public List<FilmeResponse> getFilmes(@RequestParam(value = "genero", required = false) final Genero genero) {
        return filmeService.getFilmes(genero);
    }

    @Override
    @GetMapping("/{id}")
    public ConsultarDetalhesFilmeResponse getFilmeById(@PathVariable("id") final Long id) {
        return filmeService.consultarDetalhesFilme(id);
    }

    @Override
    @PostMapping
    public Long criarFilme(@RequestBody final CriarFilmeRequest request) {

        return filmeService.criarFilme(request);
    }

    @Override
    @GetMapping("/recomendacoes")
    public List<FilmeResponse> getRecomendacoesFilmes() {

        return filmeService.getRecomendacoes();
    }

    @Override
    @PostMapping("/{id}/assistir")
    public void assistirFilme(@PathVariable("id") final Long id) {
        filmeService.assistirFilme(id);
    }
}
