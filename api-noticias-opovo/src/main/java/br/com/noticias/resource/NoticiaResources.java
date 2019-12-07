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
public class NoticiaResources {
	@Autowired
	private NoticiaService service;

	/*
	 * @RequestMapping(method = RequestMethod.GET, value = "/noticias") public
	 * List<Noticia> lista() { return service.listar(); }
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/noticias")
	public ResponseEntity<List<Noticia>> findAll() {
		List<Noticia> list = service.listar();
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Noticia> insert(@RequestBody Noticia noticia) {

		noticia = service.salvar(noticia);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(noticia.getId())
				.toUri();
		return ResponseEntity.created(uri).body(noticia);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		service.remover(id);
		return ResponseEntity.noContent().build();
	}
}
