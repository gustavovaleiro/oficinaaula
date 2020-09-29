package br.com.digitalhouse.oficina.dto;

import java.math.BigDecimal;

public class OrdemServicoModel {
	private Long id;
	private String descricao;
	private BigDecimal preco;
	private ClienteModel cliente;
	private VeiculoModel veiculo;

	public ClienteModel getCliente() {
		return cliente;
	}

	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}

	public VeiculoModel getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(VeiculoModel veiculo) {
		this.veiculo = veiculo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

}
