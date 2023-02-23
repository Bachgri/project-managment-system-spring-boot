package gestion.products.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import gestion.products.entity.Commande;
import gestion.products.service.CommandeService;

@Controller
public class CommandeController {

	CommandeService comServ;
	
	
	public CommandeController(CommandeService comServ) {
		super();
		this.comServ = comServ;
	}


	@GetMapping("/cammandes")
	public String index(Model model) {		
		model.addAttribute("commandes", comServ.getAll() );
		for (Commande c : comServ.getAll()) {
			System.out.println(c);
		}
		return "commandes";
	}
	
	
}
