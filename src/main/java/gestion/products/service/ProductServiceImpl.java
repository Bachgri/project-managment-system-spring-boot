package gestion.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion.products.entity.Product;
import gestion.products.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository pr;
	
	@Override
	public List<Product> findAll() {
		return pr.findAll();
	}
	@Override
	public void save(Product p) {
		pr.save(p);
	}
	@Override
	public Product get(Long id) {
		return pr.getOne(id);
	}
	@Override
	public void delete(Product p) {
		pr.delete(p);
	}
}
