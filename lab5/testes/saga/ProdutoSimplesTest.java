package saga;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProdutoSimplesTest {

	private ProdutoSimples p1,p2,p3;

	@BeforeEach
	public void criaProdutos() {
		p1 = new ProdutoSimples("Cachorro quente", "Pao com salsicha e carne moida", 5.00);
		p2 = new ProdutoSimples("Tapioca", "Tapioca com frango", 3.50);
		p3 = new ProdutoSimples("X-tudo", "Hamburguer de carne e frango com queijo e calabresa", 7.00);
	}
	
	@Test
	public void testCadastraProdutoPrecoInvalido() {
		try {
			new ProdutoSimples("Cachorro quente", "Pao com salsicha e carne moida", -1);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de produto: preco invalido.", e.getMessage());
		}
	}
	
	@Test
	public void testToString() {
		assertEquals("Cachorro quente - Pao com salsicha e carne moida - R$5,00", p1.toString());
	}
	
	@Test
	public void testToString2() {
		assertEquals("Tapioca - Tapioca com frango - R$3,50", p2.toString());
	}
	
	@Test
	public void testGetPreco() {
		assertEquals(7.00, p3.getPreco());
	}
	
	@Test
	public void testGetPreco2() {
		assertEquals(3.50, p2.getPreco());
	}
	
	@Test
	public void testSetPreco() {
		p1.setPreco(20.00);
		assertEquals(20.00,p1.getPreco());
	}
	
	
	@Test
	public void testVerificaSeEhCombo() {
		assertFalse(p1.verificaSeEhCombo());
	}
}
