package gestion.products.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	@GetMapping("/fournisseur/edite/{id}")
	public String getVueToUpdate(Model model, @PathVariable("id") Long id) {
		model.addAttribute("fournisseur", fs.get(id));
		return "editFournisseur";
	}
	@PostMapping("/fournisseur/update/{id}")
	public String update(@PathVariable("id") Long id, @ModelAttribute Fournisseur f) {
		Fournisseur f0 = fs.get(id);
		f0.setEmail(f.getEmail());
		f0.setName(f.getName());
		f0.setPhone(f.getPhone());
		f0.setVille(f.getVille());
		fs.save(f0);
		return "redirect:/fournisseurs";
	}
	@GetMapping("/fournisseur/delete/{id}")
	public String selete(@PathVariable("id") Long id) {
		fs.delete(id);
		return "redirect:/fournisseurs";
	}
	
	
	
}	