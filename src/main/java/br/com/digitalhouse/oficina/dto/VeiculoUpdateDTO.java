package br.com.digitalhouse.oficina.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class VeiculoUpdateDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	@NotBlank
	private String placa;
	@NotBlank
	private String cor;
	@NotBlank
	private String modelo;
	@NotBlank
	private String marca;

	public VeiculoUpdateDTO() {
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

}
