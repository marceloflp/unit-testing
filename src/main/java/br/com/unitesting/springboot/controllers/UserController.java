package br.com.unitesting.springboot.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.unitesting.springboot.entities.User;
import br.com.unitesting.springboot.entities.dto.UserDTO;
import br.com.unitesting.springboot.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping(value = "/findById/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable Long id){
		UserDTO obj = service.findById(id);
		return ResponseEntity.ok().body(obj);	
	}

	@GetMapping(value = "/findAll")
	public ResponseEntity<List<UserDTO>> findAll(){
		List<UserDTO> users = service.findAll();
		return ResponseEntity.ok().body(users);
	}
	
	@PostMapping()
	public ResponseEntity<User> inserirUsuario(@RequestBody User obj) {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}
