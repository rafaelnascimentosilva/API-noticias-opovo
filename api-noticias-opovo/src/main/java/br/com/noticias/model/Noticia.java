package br.com.noticias.model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Noticia implements Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	private String titulo;
	private String noticia;
	private String data;
	private String autor;

	public Noticia() {

	}

	public Noticia(long id, String titulo, String noticia, String tipoNoticia, String autor) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.noticia = noticia;

		this.autor = autor;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNoticia() {
		return noticia;
	}

	public void setNoticia(String noticia) {
		this.noticia = noticia;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

}
