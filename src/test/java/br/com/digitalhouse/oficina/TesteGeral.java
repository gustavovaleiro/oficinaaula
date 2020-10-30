package br.com.digitalhouse.oficina;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TesteGeral {
	
	
	@BeforeAll
	public static void antesDeTudo() {
		System.out.println("@BeforeAll:Eu sou um metodo que esta executando uma vez antes de todos os outros");
		System.out.println();

	}
	@AfterAll
	public static void depoisDeTudo() {
		System.out.println();
		System.out.println();
		System.out.println("@AfterAll: eu sou um metodo que executa depois de todos os outros");
	}
	
	@BeforeEach
	public void antesDeCadaMetodo() {
		System.out.println();
		System.out.println("@BeforeEach: eu sou um metodo que executa uma vez antes de cada teste");
	}
	

	@AfterEach
	public void depoisDeCadaMetodo() {
		System.out.println("@AfterEach eu sou um metodo que executa depois de cada metodo de teste");
	}
	
	
	@Test
	public void testeUm() {
		System.out.println("@Test Metodo de teste 1");
	}
	
	

	
	@Test
	public void testeDois() {
		System.out.println("@TestMetodo de teste 2");
	}
	
	
	@Test
	public void testeTres() {
		System.out.println("@TestMetodo de teste 3");
	}
	
	

}
