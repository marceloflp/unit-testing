package br.com.unitesting.springboot.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.unitesting.springboot.entities.User;
import br.com.unitesting.springboot.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository repository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Mark", "mark@email.com", "12345");
		User u2 = new User(null, "Shelly", "shelly@email.com", "12345");
		User u3 = new User(null, "Cloe", "cloe@email.com", "12345");
		
		repository.saveAll(List.of(u1,u2,u3));
		
	}
	
}
