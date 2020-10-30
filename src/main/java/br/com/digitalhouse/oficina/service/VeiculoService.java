package br.com.digitalhouse.oficina.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.digitalhouse.oficina.exceptions.ArgumentInvalidException;
import br.com.digitalhouse.oficina.exceptions.ObjectNotFoundException;
import br.com.digitalhouse.oficina.model.Veiculo;
import br.com.digitalhouse.oficina.repository.VeiculoRepository;

@Service
@Validated
public class VeiculoService {
	
	private final VeiculoRepository veiculoRepository;
	
	@Autowired
	public VeiculoService(VeiculoRepository veiculoRepository) {
		this.veiculoRepository = veiculoRepository;
	}
	
	
	public Veiculo create(@Valid Veiculo veiculo) {
		veiculo.setId(null);
		return this.veiculoRepository.save(veiculo);
	}
	
	public Veiculo update(Veiculo novo) {
	
		Veiculo antigo = this.findById(novo.getId());
		
		antigo.setCor(novo.getCor());
		antigo.setMarca(novo.getMarca());
		antigo.setModelo(novo.getModelo());
		antigo.setPlaca(novo.getPlaca());
		
		return this.veiculoRepository.save(antigo);
		
	}
	 
	
	public Veiculo findById(Long id) {
		Optional
			.ofNullable(id)
			.orElseThrow( () -> new ArgumentInvalidException("O id não pode ser nulo"));  
		return this.veiculoRepository.findById(id)
				.orElseThrow( () -> new ObjectNotFoundException("Não foi possivel encontrar um objeto com id " + id)); 
	}
	
	public List<Veiculo> findAll(){
		return this.veiculoRepository.findAll();
	}
	
	public void deleteById(Long id) {
		this.findById(id);
		
		this.veiculoRepository.deleteById(id);
	}
	
	
	public List<Veiculo> findByCor(String cor) {
		
		return this.veiculoRepository.findAllByCor(cor);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
