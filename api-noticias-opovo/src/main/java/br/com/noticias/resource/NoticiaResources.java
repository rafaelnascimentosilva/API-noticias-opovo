package br.com.noticias.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.noticias.model.Noticia;
import br.com.noticias.service.NoticiaService;

@RestController
@RequestMapping(value = "/noticias")
public class NoticiaResources {
	
	@Autowired
	private NoticiaService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Noticia>> lista() {
		List<Noticia> list = service.listar();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/{id}")
	public ResponseEntity<Noticia> obtem(@PathVariable Integer id) {
		Noticia noticia = service.obter(id);
		return ResponseEntity.ok().body(noticia);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Noticia> inseri(@RequestBody Noticia noticia) {
		noticia = service.salvar(noticia);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(noticia.getId())
				.toUri();
		return ResponseEntity.created(uri).body(noticia);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleta(@PathVariable Integer id) {
		service.remover(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Noticia> atualiza( @RequestBody Noticia noticia, @PathVariable Integer id) {
		noticia = service.atualizar(id, noticia);
		return ResponseEntity.ok().body(noticia);
	}
}
