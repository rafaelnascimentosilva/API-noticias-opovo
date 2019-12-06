package br.com.noticias.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.noticias.model.Noticia;

public interface NoticiaRepository extends JpaRepository<Noticia, Long> {

}
