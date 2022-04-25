package com.mendes.geladaoleao.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mendes.geladaoleao.model.Cerveja;

@Controller
public class CervejasController {
	
	/* Depois de configurar a VIEW no WebConfig
	 * e definir o html no CadastroCerveja >
	 * (caminho: src/main/resources > templates > cerveja > CadastroCerveja.html
	 * o próximo passo é definir um método aqui no Controller onde será devolvido 
	 * o método dessa view CadastroCerveja no caso.
	 * Pra isso defino o método que vai retornar o nome da view
	 * (n precisa informar que eh html pois na webconfig ja defini como html)
	 * */
	@RequestMapping("/cervejas/novo")
	public String novo(Cerveja cerveja) {
		return "cerveja/CadastroCerveja";
	}
	/* novamente o requestmapping pra achar nosso metodo
	 * passando o value 
	 * */
	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
	//@valid adicionado pra poder valer a anotação @NotBlank da classe Cerveja
	//que tá sendo passada como parâmetro do metodo cadastrar
	//BindingResult sendo passado p/ mostrar possíveis erros
	//mas para isso necessário passar o if result.hasErros
	//Model usado para poder exibir a mensagem de erro que defini no html
	/*RedirectAttributes utilizado pra poder passar o msm span de mensagem do model definido no html,
	 *mas como estou retornando redirect e não forward (como eh o caso aqui de quando o campo tá em branco)
	 *preciso  usar este RedirectAttributes pra quando o cadastro der certo*/
	public String cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return novo(cerveja);
		}
			//attr nome dado ao RedirectAttributes chamando o ".addFlashAttribute"
			//pra poder permanecer a mensagem mesmo após o redirect retornado
			attr.addFlashAttribute("msg", "Cerveja adicionada!");
		System.out.println(">>>sku: " +cerveja.getSku());
		return "redirect:/cervejas/novo";
	}
	
}
