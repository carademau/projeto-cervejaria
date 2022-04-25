package com.mendes.geladaoleao.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mendes.geladaoleao.model.Estilo;

@Controller
public class EstiloController {
	@RequestMapping ("/estilos/novo")
	public String novo (Estilo estilo) {
		return "estilo/CadastroEstilo";
	}
	@RequestMapping (value="/estilos/novo", method = RequestMethod.POST) 
	public String cadastrar (@Valid Estilo estilo, BindingResult result, Model model, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return novo (estilo);
		}
		
		attr.addFlashAttribute("msg", "Estilo adicionado");
		System.out.println(">>>>>>>>estilo" +estilo.getNome());
		
		return "redirect:/estilos/novo";
	}
}
