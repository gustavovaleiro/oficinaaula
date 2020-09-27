package br.com.digitalhouse.oficina.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 60, nullable = false)
	private String nome;
	
	@OneToMany(mappedBy = "cliente")
	private Set<Veiculo> veiculos = new HashSet<Veiculo>();

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

//	public Set<Veiculo> getVeiculos() {
//		return veiculos;
//	}
//
//	public void setVeiculos(Set<Veiculo> veiculos) {
//		this.veiculos = veiculos;
//	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
