package br.com.digitalhouse.oficina.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.digitalhouse.oficina.exceptions.ArgumentInvalidException;
import br.com.digitalhouse.oficina.exceptions.ObjectNotFoundException;
import br.com.digitalhouse.oficina.model.Veiculo;
import br.com.digitalhouse.oficina.repository.VeiculoRepository;

public class VeiculoServiceTest {

	@Mock
	private VeiculoRepository veiculoRepository;

	private VeiculoService veiculoService;

	private Veiculo veiculo;

	@BeforeEach
	public void inits() {
		MockitoAnnotations.initMocks(this);
		this.veiculoService = new VeiculoService(veiculoRepository);

		veiculo = Veiculo.builder().cor("AlgumaCor").marca("AlgumaMarca").placa("ALG4333").id(1l).build();
	}

	@Test
	public void testaCreateVeiculoSuccess() {

		veiculo.setId(null);

		when(this.veiculoRepository.save(any())).thenAnswer(i -> {
			Veiculo v = i.getArgument(0);

			return Veiculo.builder().cor(v.getCor()).marca(v.getMarca()).placa(v.getPlaca()).id(1l).build();

		});

		Veiculo veiculoRetorno = veiculoService.create(veiculo);

		assertNotNull(veiculoRetorno.getId());

	}

	@Test
	public void testaFindByIdSuccess() {

		when(this.veiculoRepository.findById(any())).thenReturn(Optional.of(veiculo));

		Veiculo veiculoRetorno = veiculoService.findById(1l);

		assertEquals(veiculo, veiculoRetorno);

	}

	@Test
	public void testaFindByIdFalhaIdNulo() {

		ArgumentInvalidException exception = assertThrows(ArgumentInvalidException.class,
				() -> veiculoService.findById(null));

		assertEquals(exception.getMessage(), "O id não pode ser nulo");

	}

	@Test
	public void testaFindByIdFalhaObjetoNaoEncontrado() {

		when(this.veiculoRepository.findById(any())).thenReturn(Optional.ofNullable(null));

		ObjectNotFoundException exception = assertThrows(ObjectNotFoundException.class,
				() -> veiculoService.findById(1l));

		assertEquals(exception.getMessage(), "Não foi possivel encontrar um objeto com id 1");

	}

}
