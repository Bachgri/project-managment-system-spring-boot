package gestion.products.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.management.relation.Role;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import gestion.products.entity.Authoritie;
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
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		List<String> roles = new ArrayList<>();
		authentication.getAuthorities().forEach(t -> {
			roles.add(t.getAuthority());
		});
		Map<String, Object> map= new HashMap<>();
		map.put("clients",cs.getAll() );
		map.put("user", currentPrincipalName);
		map.put("roles", roles);
		model.addAllAttributes(map);
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