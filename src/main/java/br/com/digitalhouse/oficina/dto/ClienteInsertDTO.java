package br.com.digitalhouse.oficina.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class ClienteInsertDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	private String nome;

	public ClienteInsertDTO() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
