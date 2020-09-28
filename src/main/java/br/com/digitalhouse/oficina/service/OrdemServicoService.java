package br.com.digitalhouse.oficina.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digitalhouse.oficina.model.OrdemServico;
import br.com.digitalhouse.oficina.repository.OrdemServicoRepository;

@Service
public class OrdemServicoService {
	
	@Autowired
	private OrdemServicoRepository ordemServiceRepository;
	
	public OrdemServico create(OrdemServicoDTO ordemServicoDTO) {
		return OrdemServico
	}
}
