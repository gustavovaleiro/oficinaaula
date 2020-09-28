package br.com.digitalhouse.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digitalhouse.oficina.dto.OrdemServicoModel;
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

//	public OrdemServico create(OrdemServicoInsertDTO ordemServicoInsertDTO) {
//		OrdemServico entity = new OrdemServico();
//		entity.setDescricao(ordemServicoInsertDTO.getDescricao());
//		entity.setPreco(ordemServicoInsertDTO.getPreco());
//
//		Cliente cliente = clienteRepository.findById(ordemServicoInsertDTO.getCliente_id())
//
//		Optional<Veiculo> veiculo = veiculoRepository.findById(ordemServicoInsertDTO.getVeiculo_id());
//
//		entity.setCliente(cliente);
//		entity.setVeiculo(veiculo);
//
//		return ordemServicoRepository.save(entity);
//	}

	public List<OrdemServico> findAll() {
		return this.ordemServicoRepository.findAll();
	}
}
