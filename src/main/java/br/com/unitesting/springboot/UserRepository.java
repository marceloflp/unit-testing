package br.com.unitesting.springboot;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unitesting.springboot.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
