package br.com.digitalhouse.oficina.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Builder;




@Entity
@Table(name = "veiculos")
public class Veiculo {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length = 7, nullable = false)
	@NotNull
	private String placa;
	
	@Column(length = 30, nullable = false)
	@NotNull
	private String cor;
	@Column(length = 30, nullable = false)
	@NotNull
	private String modelo;
	@Column(length = 30, nullable = false)
	@NotNull
	private String marca;

	
	public Veiculo() {}
	
	
	@Builder
	public Veiculo(Long id, String placa, String cor, String modelo, String marca) {
		this.id = id;
		this.placa = placa;
		this.cor = cor;
		this.modelo = modelo;
		this.marca = marca;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	
}
