package com.ChallengeJava.entity;



import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Clients implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	private String name;

	private String cpf;
	
	private String address;

	public Clients() {
	}

	public Clients (Long id, String name, String cpf, String address) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getAddress() {
		return address;
	}

	public void setAnddress(String anddress) {
		this.address = anddress;
	}
	
}
