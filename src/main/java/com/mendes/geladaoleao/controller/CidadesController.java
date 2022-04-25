package com.mendes.geladaoleao.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mendes.geladaoleao.model.Cidade;

@Controller
public class CidadesController {
	@RequestMapping ("/cidades/novo")
		public String novo (Cidade cidade) {
			return "cidade/CadastroCidade";
	}
	@RequestMapping (value="/cidades/novo", method = RequestMethod.POST)
	
	public String cadastrar (@Valid Cidade cidade, BindingResult result, Model model, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return novo (cidade);
		}
		attr.addFlashAttribute("msg", "Cidade adicionada");
		System.out.println(">>>>>>>cidade" +cidade.getCidade());
		return "redirect:/cidades/novo";
	}
	
	
}
