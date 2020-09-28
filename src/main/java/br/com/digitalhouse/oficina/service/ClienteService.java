package br.com.digitalhouse.oficina.service;

import org.springframework.stereotype.Service;

import br.com.digitalhouse.oficina.repository.ClienteRepository;

@Service
public class ClienteService {

	private final ClienteRepository clienteRepository;
	
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
}
