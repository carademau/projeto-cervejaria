package com.mendes.geladaoleao.model;

import org.hibernate.validator.constraints.NotBlank;

public class Usuario {
	
	@NotBlank (message = "campo obrigatório")
	private String nome, email;
	@NotBlank (message = "campo obrigatório")
	private int datanasc;

	
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
	public int getDatanasc() {
		return datanasc;
	}
	public void setDatanasc(int datanasc) {
		this.datanasc = datanasc;
	}
	
	
}
