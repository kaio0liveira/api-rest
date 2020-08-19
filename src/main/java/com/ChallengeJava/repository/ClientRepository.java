package com.ChallengeJava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ChallengeJava.entity.Client;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
