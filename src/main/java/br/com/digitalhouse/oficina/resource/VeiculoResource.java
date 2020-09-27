package br.com.digitalhouse.oficina.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.digitalhouse.oficina.dto.VeiculoInsertDTO;
import br.com.digitalhouse.oficina.model.Veiculo;
import br.com.digitalhouse.oficina.service.VeiculoService;

@RestController
@RequestMapping("/veiculos")
public class VeiculoResource {
	
	private final VeiculoService veiculoService;

	@Autowired
	public VeiculoResource(VeiculoService veiculoService) {
		this.veiculoService = veiculoService;
	}
	
	
	@PostMapping
	public ResponseEntity<Void> create( @RequestBody VeiculoInsertDTO veiculoDTO){
		
		Veiculo veiculo = this.veiculoService.create(veiculoDTO);
		
		URI uri = ServletUriComponentsBuilder
				 .fromCurrentRequest()
				 .path("/{id}")
				 .buildAndExpand(veiculo.getId())
				 .toUri();
		
		
		return ResponseEntity.created(uri).build();
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Veiculo veiculo){
		veiculo.setId(id);
		
		this.veiculoService.update(veiculo);
		
		return ResponseEntity.noContent().build();
		
	}
	
	
	@GetMapping("/{id}")  // /veiculos/3
	public ResponseEntity<Veiculo> findById(@PathVariable Long id){
		
		Veiculo veiculo = this.veiculoService.findById(id);
		
		return ResponseEntity.ok(veiculo);
	}
	
	@GetMapping // /veiculos
	public ResponseEntity<List<Veiculo>> findAll(){
		
		List<Veiculo> veiculos = this.veiculoService.findAll();
		
		return ResponseEntity.ok(veiculos);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		this.veiculoService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
