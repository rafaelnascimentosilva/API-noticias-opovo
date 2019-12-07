package br.com.noticias.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.noticias.model.Noticia;
import br.com.noticias.repository.NoticiaRepository;

@Service
@Transactional
public class NoticiaService {
	@Autowired
	private NoticiaRepository repo;
	
	public List<Noticia> listar(){
		return repo.findAll();
	}
    public Noticia salvar(Noticia Noticia) {
       return repo.save(Noticia);
    }
     
    public Noticia obter(long id) {
        return repo.findById(id).get();
    }
     
    public void remover(long id) {
        repo.deleteById(id);
    }
}
