package br.com.digitalhouse.oficina.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digitalhouse.oficina.exception.NegocioException;
import br.com.digitalhouse.oficina.model.Cliente;
import br.com.digitalhouse.oficina.model.OrdemServico;
import br.com.digitalhouse.oficina.model.Veiculo;
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
	
	public OrdemServico findById(Long id) {
		Optional
			.ofNullable(id)
			.orElseThrow( () -> new RuntimeException("O id não pode ser nulo"));  // todo: criar exceção personalizada para argumento ilegal
		
		return this.ordemServicoRepository.findById(id)
				.orElseThrow( () -> new RuntimeException("Não foi possivel encontrar um objeto com id " + id)); // todo: mudar pra object not found exception
	}
	
	public OrdemServico update(OrdemServico ordemServico) {
		return ordemServicoRepository.save(ordemServico);
	}
	
	public void excluir(Long id) {
		ordemServicoRepository.deleteById(id);
	}
}
