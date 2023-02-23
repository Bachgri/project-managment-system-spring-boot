package gestion.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion.products.entity.Commande;
import gestion.products.repository.CommandeRepository;

@Service
public class CommandeServiceImpl implements CommandeService {
	@Autowired
	CommandeRepository comRep;
	
	@Override
	public List<Commande> getAll() { 
		return comRep.findAll();
	}
}
