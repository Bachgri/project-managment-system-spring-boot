package gestion.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion.products.entity.Client;
import gestion.products.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {
	@Autowired
	ClientRepository cr;
	
	@Override
	public List<Client> getAll() { 
		return cr.findAll();
	}
	 @Override
	public Client get(Long id) { 
		return cr.getById(id);
	}
	@Override
	public void save(Client c) { 
		cr.save(c);
	}
	@Override
	public void delete(Long id) {
		cr.delete(cr.getById(id));
	}
}
