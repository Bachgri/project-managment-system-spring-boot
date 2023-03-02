package gestion.products.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StoreController {
	
	@GetMapping("/store")
	public String index() {
		return "store";
	}
	@GetMapping("/")
	public String home(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		List<String> roles = new ArrayList<>();
		authentication.getAuthorities().forEach(t -> {
			roles.add(t.getAuthority());
		});
		Map<String, Object> map= new HashMap<>(); 
		map.put("user", currentPrincipalName);
		map.put("roles", roles);
		model.addAllAttributes(map);
		return "home";
	}
}
