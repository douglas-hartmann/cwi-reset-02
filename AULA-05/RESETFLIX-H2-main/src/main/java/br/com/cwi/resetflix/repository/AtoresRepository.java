package br.com.cwi.resetflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;

import java.util.List;

@Repository
public interface AtoresRepository extends JpaRepository<AtorEntity, Long> {

}
