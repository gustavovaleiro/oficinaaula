package br.com.digitalhouse.oficina.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.digitalhouse.oficina.model.Cliente;
import br.com.digitalhouse.oficina.model.Veiculo;

public class OrdemServicoInsertDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Valid
	@NotNull
	private ClienteIdInput cliente;
	@Valid
	@NotNull
	private VeiculoIdInput veiculo;
	@NotBlank
	private String descricao;
	@NotNull
	private BigDecimal preco;

	public OrdemServicoInsertDTO() {
		super();
	}

	public ClienteIdInput getCliente() {
		return cliente;
	}

	public void setCliente(ClienteIdInput cliente) {
		this.cliente = cliente;
	}

	public VeiculoIdInput getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(VeiculoIdInput veiculo) {
		this.veiculo = veiculo;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
