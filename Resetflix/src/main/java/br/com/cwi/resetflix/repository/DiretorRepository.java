package br.com.cwi.resetflix.repository;

import br.com.cwi.resetflix.entity.DiretorEntity;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DiretorRepository {

    List<DiretorEntity> diretores = new ArrayList<>();
    private Long controleIds = 1L;

    public List<DiretorEntity> getDiretores() {
        return diretores;
    }

    public Long criarDiretor(DiretorEntity diretorSalvar) {
        if(diretorSalvar.getId()==null){
            diretorSalvar.setId(controleIds);
            controleIds++;
        }
        diretores.add(diretorSalvar);
        return diretorSalvar.getId();
    }

    public DiretorEntity acharDiretorPorId(Long id) {
        for(DiretorEntity diretorEntity : diretores){
            if(diretorEntity.getId().equals(id)){
                return diretorEntity;
            }
        }
        return null;
    }

    public DiretorEntity acharDiretorFilme(Long id) {
        for(DiretorEntity diretorPorId : diretores){
            for(Long idDiretor : diretorPorId.getIdsFilmes())
                if(idDiretor.equals(id)){
                    return diretorPorId;
                }
        }
        return null;
    }

    public DiretorEntity retornarDiretorFilme(Long idDiretor) {
        for (DiretorEntity diretor : diretores){
            if(diretor.getId().equals(idDiretor)){
                return diretor;
            }
        }
        return null;
    }
}
