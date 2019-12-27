package br.com.noticias.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.noticias.model.Noticia;
@Repository
public interface NoticiaRepository extends JpaRepository<Noticia, Long> {

}
