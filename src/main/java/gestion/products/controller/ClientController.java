package gestion.products.controller;

import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import gestion.products.entity.Client;
import gestion.products.entity.Commande;
import gestion.products.service.ClientService;

@Controller
public class ClientController {
	
	ClientService cs;
	
	
	public ClientController(ClientService cs) {
		super();
		this.cs = cs;
	}


	@GetMapping("/clients")
	public String index(Model model) {
		model.addAttribute("clients", cs.getAll() );
		return "clients";
	}
	@GetMapping("/client/new")
	public String New(Model model) {
		model.addAttribute("client", new Client());
		return "addC";
	}
	@PostMapping("/client")
	public String save(@ModelAttribute Client c) {
		cs.save(c);
		return "redirect:/clients";
	}
	@GetMapping("client/delete/{id}")
	public String delete(@PathVariable Long id) {
		cs.delete(id);
		return "redirect:/clients";
	}
	
	
}	