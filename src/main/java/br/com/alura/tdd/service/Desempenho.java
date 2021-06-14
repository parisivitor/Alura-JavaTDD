package br.com.alura.tdd.service;

import java.math.BigDecimal;

public enum Desempenho {
	MEDIANO {
		@Override
		public BigDecimal porcentagemDesempenho() {
			return new BigDecimal("0.03");
		}
	}, BOM {
		@Override
		public BigDecimal porcentagemDesempenho() {
			return new BigDecimal("0.15");
		}
	}, OTIMO {
		@Override
		public BigDecimal porcentagemDesempenho() {
			return new BigDecimal("0.2");
		}
	};
	
	
	public abstract BigDecimal porcentagemDesempenho();

}
