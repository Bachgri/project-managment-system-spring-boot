package gestion.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion.products.entity.Fournisseur;
import gestion.products.repository.FournisseurRepository;

@Service
public class FounisseurServiceImpl implements FournisseurService {
	
	@Autowired
	FournisseurRepository fr;
	
	
	@Override
	public List<Fournisseur> getAll() {
		return fr.findAll();
	}
	@Override
	public void save(Fournisseur f) {
		fr.save(f);
	}
	
}
