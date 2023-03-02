package gestion.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

import gestion.products.entity.Commande;
import gestion.products.entity.Product;
import gestion.products.service.CommandeService;
import gestion.products.service.ProductService;

@Controller
public class CommandeController {

	@Autowired
	CommandeService comServ;
	@Autowired
	ProductService prodServ;
	
	@GetMapping("/cammandes")
	public String index(Model model) {		
		model.addAttribute("commandes", comServ.getAll() );
		for (Commande c : comServ.getAll()) {
			System.out.println(c);
		}
		return "commandes";
	}
	@GetMapping("/commandes/new")
	public String newCommande(Model model) {
		Commande c = new Commande();
		List<Product> products = prodServ.findAll();
		model.addAttribute("commande", c);
		
		return"newCommande";
	}
	@PostMapping("/commande")
	public void create(@ModelAttribute Commande c) {
		System.out.println(c);
	}
	
}
