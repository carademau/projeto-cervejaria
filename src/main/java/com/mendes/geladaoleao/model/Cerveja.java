package com.mendes.geladaoleao.model;

import org.hibernate.validator.constraints.NotBlank;

public class Cerveja {
	
	//@NotBlank importado pela validação do hibernate lá no pom
	//usado para não permitir que o atributo (no caso sku) NÃO seja vazio e nem seja preenchido c/ espaço
	@NotBlank (message = "SKU é obrigatório")
	private String sku;
	
	@NotBlank (message = "Nome obrigatório")
	private String nome;
	
	@NotBlank (message = "Descrição deve conter entre 1 e 50 caracteres")
	private String desc;
	
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
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
