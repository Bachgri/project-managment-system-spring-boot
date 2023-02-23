package gestion.products.service;

import java.util.List;

import org.springframework.stereotype.Service;

import gestion.products.entity.Commande;

@Service
public interface CommandeService {
	public List<Commande> getAll();
}
