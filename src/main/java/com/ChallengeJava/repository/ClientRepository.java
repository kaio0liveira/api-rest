package com.ChallengeJava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ChallengeJava.entity.Clients;


@Repository
public interface ClientRepository extends JpaRepository<Clients, Long>{

}
