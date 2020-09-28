package br.com.digitalhouse.oficina.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digitalhouse.oficina.dto.ClienteInsertDTO;
import br.com.digitalhouse.oficina.model.Cliente;
import br.com.digitalhouse.oficina.repository.ClienteRepository;

@Service
public class ClienteService {
	
	private final ClienteRepository clienteRepository;
	
	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	
	public Cliente create(ClienteInsertDTO clienteDTO) {
//		cliente.setId(null);
		
		Cliente entity = new Cliente();
		entity.setNome(clienteDTO.getNome());
		
		return this.clienteRepository.save(entity);
	}
	
	public Cliente update(Cliente novo) {
	
		Cliente antigo = this.findById(novo.getId());
		
		antigo.setNome(novo.getNome());
		
		return this.clienteRepository.save(antigo);
		
	}
	 
	
	public Cliente findById(Long id) {
		Optional
			.ofNullable(id)
			.orElseThrow( () -> new RuntimeException("O id não pode ser nulo"));  // todo: criar exceção personalizada para argumento ilegal
		
		return this.clienteRepository.findById(id)
				.orElseThrow( () -> new RuntimeException("Não foi possivel encontrar um objeto com id " + id)); // todo: mudar pra object not found exception
	}
	
	public List<Cliente> findAll(){
		return this.clienteRepository.findAll();
	}
	
	public void deleteById(Long id) {
		this.findById(id);
		
		this.clienteRepository.deleteById(id);
	}
	
}
