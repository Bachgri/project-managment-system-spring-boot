package gestion.products.service;

import org.springframework.stereotype.Service;

import antlr.collections.List;
import gestion.products.entity.Product;

@Service
public interface ProductService {
	public java.util.List<Product> findAll();
	public void save(Product p);
	public Product get(Long id);
	public void delete(Product p);
}
