package gestion.products.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import gestion.products.entity.Fournisseur;
import gestion.products.entity.Product;
import gestion.products.service.FournisseurService;
import gestion.products.service.ProductService;

@Controller
public class ProductController {
 
	ProductService ps;
	FournisseurService fs;
	
	


	public ProductController(ProductService ps, FournisseurService fs) {
		super();
		this.ps = ps;
		this.fs = fs;
	}
	@GetMapping("/products")
	public String products(Model model) {
		Map<String, Object> map = new HashMap<>();
		map.put("products", ps.findAll());
		model.addAllAttributes(map);
		return "Products";
	}
	@GetMapping("/product/new")
	public String createProduct(Model model) {
		Map<String, Object> map = new HashMap<>();
		map.put("product", new Product());
		map.put("fournisseurs", fs.getAll());
		model.addAllAttributes(map);
		return "addProduct";
	}
	@PostMapping("/product")
	public String insert(@ModelAttribute Product product) {
		ps.save(product);
		return "redirect:/products";
	}
	@GetMapping("/edit/{id}")
	public String toedit(Model model, @PathVariable Long id) {
		Product product = ps.get(id);
		Map<String, Object> map = new HashMap<>();
		map.put("product", product);
		Fournisseur f = fs.get(product.getFournisseur().getId());
		System.err.println();
		List<Fournisseur> lf = fs.getAll();
		//lf.add(f);
		map.put("fournisseurs", lf);
		map.put("currentF", f);
		model.addAllAttributes(map);
		
		return "editProduct";
	}
	
	@PostMapping("/product/{id}")
	public String put(@ModelAttribute Product p, @PathVariable Long id) {
		System.out.println(id);
		Product oldP = ps.get(id);
		oldP.setDesignation(p.getDesignation());
		oldP.setDiscription(p.getDiscription());
		oldP.setPrice(p.getPrice());
		oldP.setReference(p.getReference());
		//ps.delete(oldP);
		ps.save(oldP);
		return "redirect:/products";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		ps.delete(ps.get(id));
		return "redirect:/products";
	}
	
	
	
}	