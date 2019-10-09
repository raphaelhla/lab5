package saga;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComboTest {

	private Combo c1, c2;
	
	@BeforeEach
	public void criaCombos() {
		c1 = new Combo("Lanche FIT", "Lanche saudavel", 8.00, 0.5);
		c2 = new Combo("Promo 1", "Tapioca + Suco", 5.00, 0.3);
	}
	
	@Test
	public void testCriaComboFatorInvalido() {
		try {
			new Combo("Lanche FIT", "Lanche saudavel", 8.00, 2);
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de combo: fator invalido.", e.getMessage());
		}
		
		try {
			new Combo("Lanche FIT", "Lanche saudavel", 8.00, -1);
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de combo: fator invalido.", e.getMessage());
		}
	}
	
	@Test
	public void testSetPreco() {
		c1.setPreco(0.1);
		assertEquals(7.2, c1.getPreco());
	}
	
	@Test
	public void testEhCombo() {
		assertTrue(c2.verificaSeEhCombo());
	}

}
