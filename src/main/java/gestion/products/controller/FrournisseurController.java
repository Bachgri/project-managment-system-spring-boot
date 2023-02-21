package gestion.products.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import gestion.products.entity.Fournisseur;
import gestion.products.repository.FournisseurRepository;
import gestion.products.service.FournisseurService;

@Controller
public class FrournisseurController {

	FournisseurService fs;
	
	public FrournisseurController(FournisseurService fs) {
		super();
		this.fs = fs;
	}


	@GetMapping("/fournisseurs")
	public String index(Model model) {
		model.addAttribute("fournisseurs",fs.getAll());
		return "fournisseurs";
	}
	@GetMapping("/fournisseur/new")
	public String addF(Model model) {
		model.addAttribute("fournisseur", new Fournisseur());
		return "addF";
	}
	@PostMapping("/fournisseur")
	public String add(@ModelAttribute Fournisseur fournisseur) {
		fs.save(fournisseur);
		return "redirect:/fournisseurs";
	}
	
}
