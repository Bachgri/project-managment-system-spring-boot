package gestion.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gestion.products.entity.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long> {

}
