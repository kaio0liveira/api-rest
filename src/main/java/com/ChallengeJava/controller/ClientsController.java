package com.ChallengeJava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ChallengeJava.entity.Clients;
import com.ChallengeJava.exception.ClientNotFoundException;
import com.ChallengeJava.service.ClientsService;

@RestController
@RequestMapping("api/clients")
public class ClientsController {

	@Autowired
	private ClientsService clientsService;

	@GetMapping
	public ResponseEntity<List<Clients>> list() {
		return ResponseEntity.ok(clientsService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Clients> get(@PathVariable Long id) throws ClientNotFoundException {
		return ResponseEntity.ok(clientsService.findById(id));
	}

	@PostMapping
	public ResponseEntity<Clients> save(@RequestBody Clients client) {
		clientsService.save(client);
		return ResponseEntity.status(HttpStatus.CREATED).body(client);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) throws ClientNotFoundException {
		clientsService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Clients> update(@PathVariable Long id, @RequestBody Clients client) 
			throws ClientNotFoundException {
		return ResponseEntity.ok(clientsService.update(id, client));
	}
	
}
