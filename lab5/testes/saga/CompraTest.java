package saga;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CompraTest {

	private Compra c1, c2, c3;
	
	@BeforeEach
	public void criaCompra() {
		c1 = new Compra("Raphael", "Josenilda", "Tapioca", "Tapioca com frango", "12/10/2019", 5.00);
		c2 = new Compra("Joao", "Josenilda", "Cachoro quente", "Pao com carne moida", "20/10/2019", 7.00);
	}

	@Test
	public void testCriaCompraClienteNulo() {
		try {
			new Compra(null, "Josenilda", "Tapioca", "Tapioca com frango", "12/10/2019", 5.00);
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro ao cadastrar compra: cliente nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testCriaCompraClienteVazio() {
		try {
			new Compra("", "Josenilda", "Tapioca", "Tapioca com frango", "12/10/2019", 5.00);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao cadastrar compra: cliente nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testCriaCompraFornecedorNulo() {
		try {
			new Compra("Raphael", null, "Tapioca", "Tapioca com frango", "12/10/2019", 5.00);
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testCriaCompraFornecedorVazio() {
		try {
			new Compra("Raphael", "", "Tapioca", "Tapioca com frango", "12/10/2019", 5.00);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testCriaCompraNomeProdNulo() {
		try {
			new Compra("Raphael", "Josenilda", null, "Tapioca com frango", "12/10/2019", 5.00);
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testCriaCompraNomeProdVazio() {
		try {
			new Compra("Raphael", "Josenilda", "", "Tapioca com frango", "12/10/2019", 5.00);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testCriaCompraDescricaoProdVazia() {
		try {
			new Compra("Raphael", "Josenilda", "Tapioca", "", "12/10/2019", 5.00);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testCriaCompraDescricaoProdNulo() {
		try {
			new Compra("Raphael", "Josenilda", "Tapioca", null, "12/10/2019", 5.00);
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testCriaCompraDataNula() {
		try {
			new Compra("Raphael", "Josenilda", "Tapioca", "Tapioca com frango", null, 5.00);
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro ao cadastrar compra: data nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testCriaCompraDataVazia() {
		try {
			new Compra("Raphael", "Josenilda", "Tapioca", "Tapioca com frango", "", 5.00);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao cadastrar compra: data nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testCriaCompraDataInvalida() {
		try {
			new Compra("Raphael", "Josenilda", "Tapioca", "Tapioca com frango", "20/10/200000", 5.00);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao cadastrar compra: data invalida.", e.getMessage());
		}
	}
	
	@Test
	public void testToString() {
		assertEquals("Tapioca - 12-10-2019", c1.toString());
	}
	
	@Test
	public void testGetPreco() {
		assertEquals(7.00, c2.getPreco());
	}
	
	@Test
	public void testGetCliente() {
		assertEquals("Joao", c2.getCliente());
	}
	
	@Test
	public void testGetFornecedor() {
		assertEquals("Josenilda", c2.getFornecedor());
	}
	
	@Test
	public void testGetNomeProduto() {
		assertEquals("Tapioca", c1.getNomeProduto());
	}
	
	@Test
	public void testGetDescricaoProduto() {
		assertEquals("Tapioca com frango", c1.getDescricaoProduto());
	}
	
	@Test
	public void testGetStringData() {
		assertEquals("12/10/2019", c1.getStringData());
	}
	
	@Test
	public void testExibeOrdenaCliente() {
		assertEquals("Raphael, Josenilda, Tapioca com frango, 12/10/2019", c1.exibeOrdenaCliente());
	}
	
	@Test
	public void testExibeOrdenaFornecedor() {
		assertEquals("Josenilda, Raphael, Tapioca com frango, 12/10/2019", c1.exibeOrdenaFornecedor());
	}
	
	@Test
	public void testExibeOrdenaData() {
		assertEquals("20/10/2019, Joao, Josenilda, Pao com carne moida", c2.exibeOrdenaData());
	}
	
	@Test
	public void testGetData() {
		assertFalse(c2.getData().equals(c1.getData()));
	}
	
}
