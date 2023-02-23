package gestion.products.service;

import java.util.List;

import gestion.products.entity.Fournisseur;

public interface FournisseurService {
	public List<Fournisseur> getAll();
	public void save(Fournisseur f);
	public Fournisseur get(Long id);
}
