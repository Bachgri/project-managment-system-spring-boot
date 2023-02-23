package gestion.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gestion.products.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
	
}
