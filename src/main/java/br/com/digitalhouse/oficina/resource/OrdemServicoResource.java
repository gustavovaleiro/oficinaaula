package br.com.digitalhouse.oficina.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.digitalhouse.oficina.model.OrdemServico;
import br.com.digitalhouse.oficina.service.OrdemServicoService;

@RestController
@RequestMapping("/ordens-servico")
public class OrdemServicoResource {

	@Autowired
	private OrdemServicoService ordemServicoService;

	@GetMapping // /ordensServicos
	public ResponseEntity<List<OrdemServico>> listar(){
		List<OrdemServico> ordensServico = this.ordemServicoService.findAll();
		
		return ResponseEntity.ok(ordensServico);
	}
}
