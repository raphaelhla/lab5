package saga;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComboTest {

	private Combo c1, c2;
	private ProdutoSimples p1, p2, p3, p4;
	private Set<ProdutoSimples> produtosDoCombo1, produtosDoCombo2;

	@BeforeEach
	public void criaCombos() {
		produtosDoCombo1 = new HashSet<ProdutoSimples>();
		produtosDoCombo2 = new HashSet<ProdutoSimples>();

		p1 = new ProdutoSimples("Cachorro quente", "Pao com salsicha e carne moida", 8.00);
		p2 = new ProdutoSimples("Whey", "Whey de chocolate", 3.00);
		p3 = new ProdutoSimples("Tapioca", "Tapioca com frango", 5.00);
		p4 = new ProdutoSimples("Suco", "Suco de maracuja", 3.00);

		produtosDoCombo1.add(p1);
		produtosDoCombo1.add(p2);
		produtosDoCombo2.add(p3);
		produtosDoCombo2.add(p4);

		c1 = new Combo("Lanche FIT", "Lanche saudavel", 0.5, produtosDoCombo1);
		c2 = new Combo("Promo 1", "Tapioca + Suco", 0.3, produtosDoCombo2);
	}

	@Test
	public void testCriaComboFatorInvalido() {
		try {
			new Combo("Lanche FIT", "Lanche saudavel", 2, produtosDoCombo1);
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de combo: fator invalido.", e.getMessage());
		}

		try {
			new Combo("Lanche FIT", "Lanche saudavel", -1, produtosDoCombo2);
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de combo: fator invalido.", e.getMessage());
		}
	}

	@Test
	public void testSetFator() {
		c2.setFator(0.1);
		assertEquals(7.2, c2.getPreco());
	}

	@Test
	public void testGetPreco() {
		assertEquals(5.5, c1.getPreco());
	}

	@Test
	public void testEhCombo() {
		assertTrue(c2.verificaSeEhCombo());
	}

	@Test
	public void testToString() {
		assertEquals("Lanche FIT - Lanche saudavel - R$5,50", c1.toString());
	}

	@Test
	public void testToString2() {
		assertEquals("Promo 1 - Tapioca + Suco - R$5,60", c2.toString());
	}
}
