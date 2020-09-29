package br.com.digitalhouse.oficina.service;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digitalhouse.oficina.exception.NegocioException;
import br.com.digitalhouse.oficina.model.Cliente;
import br.com.digitalhouse.oficina.model.OrdemServico;
import br.com.digitalhouse.oficina.repository.ClienteRepository;
import br.com.digitalhouse.oficina.repository.OrdemServicoRepository;
import br.com.digitalhouse.oficina.repository.VeiculoRepository;

@Service
public class OrdemServicoService {

	@Autowired
	private OrdemServicoRepository ordemServicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private VeiculoRepository veiculoRepository;

	public OrdemServico create(OrdemServico ordemServico) {
		Cliente cliente = clienteRepository.findById(ordemServico.getCliente().getId())
				.orElseThrow(() -> new NegocioException("Cliente não encontrado"));

		ordemServico.setCliente(cliente);

		return ordemServicoRepository.save(ordemServico);
	}

	public List<OrdemServico> findAll() {
		return this.ordemServicoRepository.findAll();
	}
}
