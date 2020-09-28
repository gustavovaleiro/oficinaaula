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
	private Long cliente_id;
	@Valid
	@NotNull
	private Long veiculo_id;
	@NotBlank
	private String descricao;
	@NotNull
	private BigDecimal preco;

	public OrdemServicoInsertDTO() {
		super();
	}

	public Long getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(Long cliente_id) {
		this.cliente_id = cliente_id;
	}

	public Long getVeiculo_id() {
		return veiculo_id;
	}

	public void setVeiculo_id(Long veiculo_id) {
		this.veiculo_id = veiculo_id;
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
