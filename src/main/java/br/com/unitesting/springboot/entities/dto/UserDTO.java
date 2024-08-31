package br.com.unitesting.springboot.entities.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {

	private Long id;
	private String nome;
	private String email;
	
	//@JsonIgnore //IGNORA senha durante processamento
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //SENHA SERÁ APENAS ESCRITA, MAS NÃO RETORNADA
	private String senha;

	public UserDTO(Long id, String nome, String email, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
