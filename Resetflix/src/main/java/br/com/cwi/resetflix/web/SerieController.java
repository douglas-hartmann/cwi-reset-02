package br.com.cwi.resetflix.web;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.request.CriarSerieRequest;
import br.com.cwi.resetflix.response.ConsultarDetalhesSerieResponse;
import br.com.cwi.resetflix.response.SerieResponse;
import br.com.cwi.resetflix.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieController implements SeriesContract{

    @Autowired
    private SerieService serieService;

    @GetMapping
    @Override
    public List<SerieResponse> getSeries(@RequestParam(value = "genero", required = false) final Genero genero) {
        return serieService.getSerie(genero);
    }

    @GetMapping("/{id}")
    @Override
    public ConsultarDetalhesSerieResponse getSerieById(@PathVariable("id") final Long id) {
        return serieService.consultarDetalheSerie(id);
    }

    @PostMapping
    @Override
    public Long criarSerie(@RequestBody CriarSerieRequest request) {
        return serieService.criarSerie(request);
    }

    @GetMapping("/recomendacoes")
    @Override
    public List<SerieResponse> getRecomendaçõesSeries() {

        return serieService.getRecomendacoes();
    }

    @PostMapping("/{id}/{temporada}/{episodio}/assistir")
    @Override
    public void assistirSerie(@PathVariable Long id, @PathVariable  Integer temporada, @PathVariable Integer episodio) {
        serieService.assitirSerie(id,temporada,episodio);

    }
}
