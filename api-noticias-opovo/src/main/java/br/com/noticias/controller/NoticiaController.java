package br.com.noticias.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NoticiaController {

	@RequestMapping("/home")
	public String home() {
		return "index";
	}
}
