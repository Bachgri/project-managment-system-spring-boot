package gestion.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gestion.products.entity.Fournisseur;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long>{

}
