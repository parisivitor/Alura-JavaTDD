package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void SeSalarioMaiorQue10000BonusSeria0() {
		BonusService service = new BonusService();
//		BigDecimal bonus = service.calcularBonus(new Funcionario("Vitor", LocalDate.now(), new BigDecimal("25000")));
//		assertEquals(new BigDecimal("0"), bonus);
		
		assertThrows(IllegalArgumentException.class, 
				()->service.calcularBonus(new Funcionario("Vitor", LocalDate.now(), new BigDecimal("25000"))));
		
//		as duas maneiras de tratar atravez de Exception, a de cima, quanto a de baixo 
//		try {
//			service.calcularBonus(new Funcionario("Vitor", LocalDate.now(), new BigDecimal("25000")));
//			fail("Não ocorreu a Exeption!"); //
//		} catch (Exception e) {	
////			assertEquals("Salario para receber Bonus não pode ser maior que R$10.000,00!", e.getMessage()); //compara com a mensagem lancada pela Exception 
//		}
	}
	
	@Test
	void SeSalario2500BonusSeria250() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Vitor", LocalDate.now(), new BigDecimal("2500")));
		assertEquals(new BigDecimal("250.0"), bonus);
	}
	
	@Test
	void SeSalarioIgualA10000BonusSeria1000() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Vitor", LocalDate.now(), new BigDecimal("10000")));
		assertEquals(new BigDecimal("1000.0"), bonus);
	}

}
