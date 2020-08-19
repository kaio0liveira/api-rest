package com.ChallengeJava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import com.ChallengeJava.entity.Clients;
import com.ChallengeJava.repository.ClientRepository;

@Component
public class DataInitilizr implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	ClientRepository repos;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		
		Clients c = new Clients(1L,"kaio", "12324353", "Brasilia - DF");
		
		repos.save(c);

}
}
