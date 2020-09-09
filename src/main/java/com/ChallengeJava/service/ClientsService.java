package com.ChallengeJava.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ChallengeJava.entity.Clients;
import com.ChallengeJava.exception.ClientNotFoundException;
import com.ChallengeJava.repository.ClientRepository;

@Service
public class ClientsService {
	
	@Autowired
	private ClientRepository clientsRepository;
	
	//validação de cliente, caso ID não existir
	public Clients findById(Long id) throws ClientNotFoundException {
		Optional<Clients> client = clientsRepository.findById(id);
		
		Clients client1 = null;
		if(!client.isPresent()) {
			throw new ClientNotFoundException("ID "+id+" not found!");
		}else {
			client1 = client.get();
		}
		return client1;
	}
	public List<Clients> findAll() {
		return clientsRepository.findAll();
	}

	public void delete(Long id) throws ClientNotFoundException {
		Optional <Clients> client = clientsRepository.findById(id);
		
		
		if (!client.isPresent()) {
			throw new ClientNotFoundException("ID "+id+" not found!");
		}else {
			clientsRepository.deleteById(id);
		}
	}
	
	public Clients update(Long id, Clients client) throws ClientNotFoundException {
		findById(id);
		
		client.setId(id);
		return clientsRepository.save(client);
	}
	
	public Clients save(Clients client) {
		return clientsRepository.save(client);
	}
	
	
}
