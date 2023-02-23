package gestion.products.service;

import java.util.List;

import org.springframework.stereotype.Service;

import gestion.products.entity.Client;
 

@Service
public interface ClientService {
	public List<Client> getAll();
	public Client get(Long id);
	public void save(Client c);
	public void delete(Long id);
	
}
