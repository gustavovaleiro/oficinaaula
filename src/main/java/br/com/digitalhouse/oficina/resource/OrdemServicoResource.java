package br.com.digitalhouse.oficina.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.digitalhouse.oficina.dto.OrdemServicoInsertDTO;
import br.com.digitalhouse.oficina.dto.OrdemServicoModel;
import br.com.digitalhouse.oficina.model.OrdemServico;
import br.com.digitalhouse.oficina.service.OrdemServicoService;
import br.com.digitalhouse.oficina.repository.OrdemServicoRepository;

@RestController
@RequestMapping("/ordens-servico")
public class OrdemServicoResource {

	@Autowired
	private OrdemServicoService ordemServicoService;

	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping // /ordensServicos
	public ResponseEntity<List<OrdemServicoModel>> listar(){
		
		return ResponseEntity.ok(toCollectionModel(ordemServicoRepository.findAll()));
		
	}
	
	@PostMapping
	public ResponseEntity<Void> create(@Valid @RequestBody OrdemServicoInsertDTO ordemServicoInsertDTO) {
		OrdemServico ordemServico = toEntity(ordemServicoInsertDTO);
		
		toModel(ordemServicoService.create(ordemServico));
		
		URI uri = ServletUriComponentsBuilder
				 .fromCurrentRequest()
				 .path("/{id}")
				 .buildAndExpand(ordemServico.getId())
				 .toUri();
		
		
		return ResponseEntity.created(uri).build();
	}
	
	private OrdemServico toEntity(OrdemServicoInsertDTO ordemServicoInsertDTO) {
		return modelMapper.map(ordemServicoInsertDTO, OrdemServico.class);
	}
	
	private OrdemServicoModel toModel(OrdemServico ordemServico) {
		return modelMapper.map(ordemServico, OrdemServicoModel.class);
	}
	
	private List<OrdemServicoModel> toCollectionModel(List<OrdemServico> ordensServico){
		return ordensServico.stream().map(ordemServico -> toModel(ordemServico)).collect(Collectors.toList());
	}
}
