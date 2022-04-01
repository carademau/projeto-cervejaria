package com.mendes.geladaoleao.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Cerveja {
	
	//@NotBlank importado pela validação do hibernate lá no pom
	//usado para não permitir que o atributo (no caso sku) NÃO seja vazio e nem seja preenchido c/ espaço
	@NotBlank
	private String sku;
	
	@NotBlank
	private String nome;
	
	@Size(max=250)
	private String descricao;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}	
}
