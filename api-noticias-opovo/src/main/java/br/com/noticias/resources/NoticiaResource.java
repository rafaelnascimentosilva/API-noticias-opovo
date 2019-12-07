package br.com.noticias.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.noticias.model.Noticia;
import br.com.noticias.repository.NoticiaRepository;

@RestController
@RequestMapping(value = "/noticias")
public class NoticiaResource {
	@Autowired
	private NoticiaRepository repo;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Noticia> lista(){
		return repo.findAll();
	}
}
