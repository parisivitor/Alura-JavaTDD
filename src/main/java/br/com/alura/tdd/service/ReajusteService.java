package br.com.alura.tdd.service;

import java.math.BigDecimal;

import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteService {

	public void concederReajuste(Funcionario func, Desempenho desempenho) {
		func.concederReajuste(func.getSalario().multiply(desempenho.porcentagemDesempenho()));

	}

}
