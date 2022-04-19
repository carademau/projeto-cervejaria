package com.mendes.geladaoleao.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mendes.geladaoleao.model.Cliente;

@Controller
public class ClientesController {
	@RequestMapping("/clientes/novo")
	public String novo(Cliente cliente) {
		return "cliente/CadastroCliente";
	}
	@RequestMapping(value="/clientes/novo", method = RequestMethod.POST)
	
	public String cadastrar (@Valid Cliente cliente, BindingResult result, Model model, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return novo (cliente);
		}
			attr.addFlashAttribute("msg", "Cliente adicionado");
			System.out.println(">>>testnome" +cliente.getNome());
			return "redirect:/clientes/novo";	
	}
}
