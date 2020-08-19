package com.ChallengeJava.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ChallengeJava.entity.Client;
import com.ChallengeJava.exception.ClientNotFoundException;
import com.ChallengeJava.repository.ClientRepository;
import com.ChallengeJava.service.ClientService;



@RestController
public class ClientController {
	
	@Autowired
	private ClientService sc;
	 
	@Autowired
	private ClientRepository cp;
	
	@GetMapping(path = "api/client/{id}")
	public Client clientId(@PathVariable(name = "id", required = true)Long id) throws ClientNotFoundException {
		return sc.findId(id);
	}
	@GetMapping(path = "client")
	public List<Client>find() {
		return cp.findAll();
	}
	
	@PostMapping(path = "client/save", produces = "application/json")
	public void save(@RequestBody Client client) {
		cp.save(client);
	}
	
	@DeleteMapping(path = "client/delete/{id}")
	public void delete(@PathVariable (name = "id", required = true) Long id) throws ClientNotFoundException {
		Client client = sc.findId(id);
		cp.delete(client);
		
	}
	
	@PutMapping(path = "/client/edit/{id}")
	public Client edit(@PathVariable (name = "id",required = true) Long id, @RequestBody Client client) throws ClientNotFoundException {
		Optional<Client> clientOptional = cp.findById(id);

		if(!clientOptional.isPresent()){
		    throw new ClientNotFoundException("Client not found for id: "+id);
		}
		client.setId(id);
		cp.save(client);

		return client;
	}
}