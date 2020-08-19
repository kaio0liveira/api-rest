package com.ChallengeJava.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ChallengeJava.entity.Client;
import com.ChallengeJava.exception.ClientNotFoundException;
import com.ChallengeJava.repository.ClientRepository;

@Service
public class ServiceClient {
	
	@Autowired
	private ClientRepository cr;
	
	//validação de cliente, caso ID não existir
	public Client FindId(Long id) throws ClientNotFoundException {
		Optional<Client> client = cr.findById(id);
		
		Client client1 = null;
		if(!client.isPresent()) {
			throw new ClientNotFoundException("ID not found!");
		}else {
			client1 = client.get();
		}
		return client1;
	}
	
	
}
