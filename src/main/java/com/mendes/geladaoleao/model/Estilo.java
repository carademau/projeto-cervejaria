package com.mendes.geladaoleao.model;

import org.hibernate.validator.constraints.NotBlank;

public class Estilo {
	
	@NotBlank (message="campo obrigatório")
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
