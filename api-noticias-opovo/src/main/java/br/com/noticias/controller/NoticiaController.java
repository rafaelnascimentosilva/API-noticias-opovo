package br.com.noticias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.noticias.model.Noticia;
import br.com.noticias.service.NoticiaService;

@Controller
public class NoticiaController {
	@Autowired
	private NoticiaService service;

	@RequestMapping("/")
	public ModelAndView home(Model model) {
		List<Noticia> listaNoticias = service.listar();

		ModelAndView mav = new ModelAndView("index");
		mav.addObject("listaNoticias", listaNoticias);
		return mav;

		// insert into NOTICIA (AUTOR ,DATA ,NOTICIA ,TITULO
		// )values('Raul','reste','fafafafa','fdafa');
	}
}
