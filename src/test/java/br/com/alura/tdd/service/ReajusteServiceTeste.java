package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class ReajusteServiceTeste {

	private BigDecimal salarioTeste;
	private ReajusteService reajuste;
	private Funcionario func;

	@BeforeAll
	public static void AntesDeTudo() {
		System.out.println("ANTES DE TUDO");
	}

	@BeforeEach
	public void Inicializa() {
		reajuste = new ReajusteService();
		salarioTeste = new BigDecimal("1000.0");
		func = new Funcionario("vitor", LocalDate.now(), salarioTeste);
	}

	@AfterEach
	public void DepoisDeCadaMetodo() {
		System.out.println("DEPOIS de CADA metodo");
	}

	@AfterAll
	public static void DepoisDeTudo() {
		System.out.println("DEPOIS DE TUDO");
	}

	@Test
	void SeDesempenhoForMedianoAcrescimoDe3PorCento() {
		BigDecimal salarioReajuste = new BigDecimal("1.03");
		reajuste.concederReajuste(func, Desempenho.MEDIANO);
		assertEquals(salarioTeste.multiply(salarioReajuste).setScale(2, RoundingMode.HALF_UP), func.getSalario());
	}

	@Test
	void SeDesempenhoForBomAcrescimoDe15PorCento() {
		BigDecimal salarioReajuste = new BigDecimal("1.15");
		reajuste.concederReajuste(func, Desempenho.BOM);
		assertEquals(salarioTeste.multiply(salarioReajuste).setScale(2, RoundingMode.HALF_UP), func.getSalario());
	}

	@Test
	void SeDesempenhoForOtimoAcrescimoDe20PorCento() {
		BigDecimal salarioReajuste = new BigDecimal("1.20");
		reajuste.concederReajuste(func, Desempenho.OTIMO);
		assertEquals(salarioTeste.multiply(salarioReajuste).setScale(2, RoundingMode.HALF_UP), func.getSalario());
	}

}
