package com.mendes.geladaoleao.model;

import org.hibernate.validator.constraints.NotBlank;

public class Cidade {
	
	@NotBlank (message="campos obrigatórios")
	private String cidade, estado;

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
