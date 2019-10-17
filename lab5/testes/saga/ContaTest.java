package saga;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContaTest {

	private Conta c1, c2;
	
	@BeforeEach
	public void criaConta() {
		c1 = new Conta("Josenilda");
		c2 = new Conta("Raphael");
	}

	@Test
	public void testCriaContaFornecedorNulo() {
		try {
			new Conta(null);
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testCriaContaFornecedorVazio() {
		try {
			new Conta("");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testAdicionaContaNomeProdutoNulo() {
		try {
			c1.adicionaCompra(null, "10/12/2019", 10.0);;
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testAdicionaContaNomeProdutoVazio() {
		try {
			c1.adicionaCompra("", "10/12/2019", 10.0);;
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testAdicionaContaDataVazia() {
		try {
			c1.adicionaCompra("Tapioca", "", 10.0);;
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao cadastrar compra: data nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testAdicionaContaDataNula() {
		try {
			c1.adicionaCompra("Tapioca", null, 10.0);;
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro ao cadastrar compra: data nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testAdicionaContaDataInvalida() {
		try {
			c1.adicionaCompra("Tapioca", "10/1000/20000", 10.0);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao cadastrar compra: data invalida.", e.getMessage());
		}
	}
	
	@Test
	public void testToString() {
		c2.adicionaCompra("Tapioca", "10/10/2019", 10.0);
		c2.adicionaCompra("Suco", "19/10/2019", 8.0);
		assertEquals("Raphael | Tapioca - 10-10-2019 | Suco - 19-10-2019", c2.toString());
	}
	
	@Test
	public void testGetNomeFornecedor() {
		assertEquals("Raphael", c2.getNomeFornecedor());
	}
	
	@Test
	public void testGetDebito() {
		c2.adicionaCompra("Tapioca", "10/10/2019", 10.0);
		c2.adicionaCompra("Suco", "19/10/2019", 8.0);
		assertEquals("18.00", c2.getDebito());
	}
	
	@Test
	public void testGetQtdContas() {
		c2.adicionaCompra("Tapioca", "10/10/2019", 10.0);
		c2.adicionaCompra("Suco", "19/10/2019", 8.0);
		assertEquals(2, c2.getQtdCompras());
	}
	
	@Test
	public void testCompareTo() {
		List<Conta> contas = new ArrayList<Conta>();
		contas.add(c2);
		contas.add(c1);
		c1.adicionaCompra("Tapioca", "10/10/2019", 10.0);
		c2.adicionaCompra("Suco", "19/10/2019", 8.0);
		Collections.sort(contas);
		assertEquals("[Josenilda | Tapioca - 10-10-2019, Raphael | Suco - 19-10-2019]", contas.toString());
	}
}
