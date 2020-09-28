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

import br.com.digitalhouse.oficina.dto.ClienteInsertDTO;
import br.com.digitalhouse.oficina.model.Cliente;
import br.com.digitalhouse.oficina.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService;

//	@Autowired
//	public ClienteResource(ClienteService clienteService) {
//		this.clienteService = clienteService;
//	}
	
	
	@PostMapping
	public ResponseEntity<Void> create( @RequestBody ClienteInsertDTO clienteDTO){
		
		Cliente cliente = this.clienteService.create(clienteDTO);
		
		URI uri = ServletUriComponentsBuilder
				 .fromCurrentRequest()
				 .path("/{id}")
				 .buildAndExpand(cliente.getId())
				 .toUri();
		
		
		return ResponseEntity.created(uri).build();
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody ClienteInsertDTO clienteDTO){
		Cliente cliente = new Cliente();		
		cliente.setId(id);
		cliente.setNome(clienteDTO.getNome());
		
		this.clienteService.update(cliente);
		
		return ResponseEntity.noContent().build();
		
	}
	
	
	@GetMapping("/{id}")  // /clientes/3
	public ResponseEntity<Cliente> findById(@PathVariable Long id){
		
		Cliente cliente = this.clienteService.findById(id);
		
		return ResponseEntity.ok(cliente);
	}
	
	@GetMapping // /clientes
	public ResponseEntity<List<Cliente>> findAll(){
		
		List<Cliente> cliente = this.clienteService.findAll();
		
		return ResponseEntity.ok(cliente);
		
	}
	
	// Funcionando somente para clientes sem veiculos cadastrados
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		
		this.clienteService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
		
	
	
	
	
	

}
