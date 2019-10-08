package saga;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IdProdutoTest {

	private IdProduto id1, id2;
	
	@BeforeEach
	public void criaId() {
		id1 = new IdProduto("Tapioca", "Tapioca com frango");
		id2 = new IdProduto("Cachorro quente", "Pao com salsicha e carne moida");
	}
	
	@Test
	public void testCadastraIdProdutoNomeNulo() {
		try {
			new IdProduto(null, "Pao com salsicha e carne moida");
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro no cadastro de idProduto: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastraIdProdutoNomeVazio() {
		try {
			new IdProduto("", "Pao com salsicha e carne moida");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de idProduto: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastraIdProdutoDescricaoNula() {
		try {
			new IdProduto("Cachorro quente", null);
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro no cadastro de idProduto: descricao nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastraIdProdutoDescricaoVazia() {
		try {
			new IdProduto("Cachorro quente", "");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de idProduto: descricao nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testGetNome() {
		assertEquals("Tapioca", id1.getNome());
	}
	
	@Test
	public void testGetNome2() {
		assertEquals("Cachorro quente", id2.getNome());
	}
	
	@Test 
	public void testGetDescricao() {
		assertEquals("Tapioca com frango", id1.getDescricao());
	}
	
	@Test
	public void testGetDescricao2() {
		assertEquals("Pao com salsicha e carne moida", id2.getDescricao());
	}
	
	@Test
	public void testHashCode() {
		assertNotEquals(id1.hashCode(),id2.hashCode());
	}
	
	@Test
	public void testEqualsObjetoDiferente() {
		assertFalse(id1.equals(id2));
	}
	
	@Test
	public void testEqualsMesmoObjeto() {
		assertTrue(id1.equals(id1));
	}
	
	@Test
	public void testEqualsComNull() {
		assertFalse(id1.equals(null));
	}
	
	@Test
	public void testEqualsComOutraClasse() {
		Produto p1 = new Produto(5.00, "Cachorro quente", "Pao com salsicha e carne moida");
		assertFalse(id1.equals(p1));
	}

}
