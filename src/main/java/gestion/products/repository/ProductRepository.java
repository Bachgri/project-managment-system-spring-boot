package gestion.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gestion.products.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
		
}
