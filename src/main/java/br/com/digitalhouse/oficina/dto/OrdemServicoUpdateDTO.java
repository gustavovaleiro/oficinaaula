package br.com.digitalhouse.oficina.dto;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class OrdemServicoUpdateDTO {
	@Valid
	@NotNull
	private String descricao;
	@Valid
	@NotNull
	private BigDecimal preco;

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
