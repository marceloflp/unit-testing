package br.com.unitesting.springboot.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unitesting.springboot.entities.User;
import br.com.unitesting.springboot.entities.dto.UserDTO;
import br.com.unitesting.springboot.repositories.UserRepository;
import br.com.unitesting.springboot.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public UserDTO findById(Long id) {
		User user = repository.findById(id).
				orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
		return convertDTO(user);
	}

	public List<UserDTO> findAll() {
		List<User> listUsers = repository.findAll();
		return listUsers.stream()
				.map(usuario -> new UserDTO(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getSenha()))
				.collect(Collectors.toList());
	}
	
	private UserDTO convertDTO(User user) {
		return new UserDTO(user.getId(), user.getNome(), user.getEmail(), user.getSenha());
	}

}
