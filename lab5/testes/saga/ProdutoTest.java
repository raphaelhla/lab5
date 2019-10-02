package saga;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProdutoTest {

	private Produto p1,p2,p3;

	@BeforeEach
	public void criaProdutos() {
		p1 = new Produto(5.00, "Cachorro quente", "Pao com salsicha e carne moida");
		p2 = new Produto(3.50, "Tapioca", "Tapioca com frango");
		p3 = new Produto(7.00, "X-tudo", "Hamburguer de carne e frango com queijo e calabresa");
	}
	
	@Test
	public void testCadastraProdutoNomeNulo() {
		try {
			new Produto(5.00, null, "Pao com salsicha e carne moida");
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastraProdutoNomeVazio() {
		try {
			new Produto(5.00, "", "Pao com salsicha e carne moida");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastraProdutoDescricaoNula() {
		try {
			new Produto(5.00, "Cachorro quente", null);
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastraProdutoDescricaoVazia() {
		try {
			new Produto(5.00, "Cachorro quente", "");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastraProdutoPrecoInvalido() {
		try {
			new Produto(-1, "Cachorro quente", "Pao com salsicha e carne moida");
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
	public void testGetNome() {
		assertEquals("Tapioca", p2.getNome());
	}
	
	@Test
	public void testGetNome2() {
		assertEquals("Cachorro quente", p1.getNome());
	}
	
	@Test
	public void testGetDescricao() {
		assertEquals("Tapioca com frango", p2.getDescricao());
	}
	
	@Test
	public void testGetDescricao2() {
		assertEquals("Hamburguer de carne e frango com queijo e calabresa", p3.getDescricao());
	}
	
	@Test
	public void testGetIdProduto() {
		IdProduto id = new IdProduto(p1.getNome(), p1.getDescricao());
		assertEquals(id, p1.getIdProduto());
	}
	
	@Test
	public void testGetIdProduto2() {
		IdProduto id = new IdProduto(p2.getNome(), p2.getDescricao());
		assertEquals(id, p2.getIdProduto());
	}
	
	@Test
	public void testSetPreco() {
		p1.setPreco(20.00);
		assertEquals(20.00,p1.getPreco());
	}
	
	@Test
	public void testHashCode() {
		assertNotEquals(p1.hashCode(), p2.hashCode());
	}
	
	@Test
	public void testHashCode2() {
		Produto p4 = new Produto(15.00 ,"Tapioca", "Tapioca com frango");
		assertEquals(p2.hashCode(), p4.hashCode());
	}
	
	@Test
	public void testHashCode3() {
		assertEquals(p1.hashCode(), p1.hashCode());
	}
	
	@Test
	public void testEqualsIdProdutoDiferente() {
		assertFalse(p1.equals(p2));
	}
	
	@Test
	public void testEqualsIdProdutoIguais() {
		Produto p4 = new Produto(15.00 ,"Tapioca", "Tapioca com frango");
		assertTrue(p2.equals(p4));
	}
	
	@Test
	public void testEqualsMesmoProduto() {
		assertTrue(p3.equals(p3));
	}
	
	@Test
	public void testEqualsComOutraClasse() {
		Fornecedor fornecedor = new Fornecedor("Irineu", "irineu@example.com", "83 99988-0000");
		assertFalse(p3.equals(fornecedor));
	}
	
	@Test
	public void testEqualsComNull() {
		assertFalse(p3.equals(null));
	}
}
