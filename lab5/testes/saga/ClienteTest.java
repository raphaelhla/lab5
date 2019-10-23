package saga;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteTest {

	private Cliente cliente1, cliente2, cliente3;
	
	@BeforeEach
	public void criandoCliente() {
		cliente1 = new Cliente("Raphael Agra","12345678900","raphael.agra@ccc.ufcg.edu.br","CAA");
		cliente2 = new Cliente("Ana Amari", "11111111100", "ana_amari@ccc.ufcg.edu.br", "SPG");
		cliente3 = new Cliente("Victor Emanuel","11111111100","vitao@ccc.ufcg.edu.br", "Labarc");
	}

	@Test
	public void testCadastraClienteNomeNulo() {
		try {
			new Cliente(null, "12345678900", "raphael.agra@ccc.ufcg.edu.br", "CAA");
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastraClienteNomeVazio() {
		try {
			new Cliente("", "12345678900", "raphael.agra@ccc.ufcg.edu.br", "CAA");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastraClienteCpfNulo() {
		try {
			new Cliente("Raphael Agra", null, "raphael.agra@ccc.ufcg.edu.br", "CAA");
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastraClienteCpfVazio() {
		try {
			new Cliente("Raphael Agra", "", "raphael.agra@ccc.ufcg.edu.br", "CAA");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastraClienteCpfInvalido() {
		try {
			new Cliente("Raphael Agra", "1234", "raphael.agra@ccc.ufcg.edu.br", "CAA");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do cliente: cpf invalido.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastraClienteEmailNulo() {
		try {
			new Cliente("Raphael Agra", "12345678900", null, "CAA");
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastraClienteEmailVazio() {
		try {
			new Cliente("Raphael Agra", "12345678900", "", "CAA");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastraClienteLocalizacaoNula() {
		try {
			new Cliente("Raphael Agra", "12345678900", "raphael.agra@ccc.ufcg.edu.br", null);
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastraClienteLocalizacaoVazia() {
		try {
			new Cliente("Raphael Agra", "12345678900", "raphael.agra@ccc.ufcg.edu.br", "");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testHashCode() {
		assertNotEquals(cliente1.hashCode(), cliente2.hashCode());
	}
	
	@Test
	public void testHashCode2() {
		assertEquals(cliente2.hashCode(), cliente3.hashCode());
	}
	
	@Test
	public void testEqualsClienteDiferente() {
		assertFalse(cliente1.equals(cliente2));
	}
	
	@Test
	public void testEqualsClienteComMesmoCpf() {
		assertTrue(cliente2.equals(cliente3));
	}
	
	@Test
	public void testEqualsComNull() {
		assertFalse(cliente2.equals(null));
	}
	
	@Test
	public void testEqualsComEleMesmo() {
		assertTrue(cliente2.equals(cliente2));
	}
	
	@Test
	public void testEquals5() {
		Fornecedor fornecedor = new Fornecedor("Junior", "junior@example.com", "8888-9999");
		assertFalse(cliente2.equals(fornecedor));
	}
	
	@Test
	public void testGetNome() {
		assertEquals("Raphael Agra", cliente1.getNome());
	}
		
	@Test
	public void testGetNome2() {
		assertEquals("Ana Amari", cliente2.getNome());
	}
	
	@Test
	public void testGetEmail() {
		assertEquals("raphael.agra@ccc.ufcg.edu.br", cliente1.getEmail());
	}

	@Test
	public void testGetEmail2() {
		assertEquals("ana_amari@ccc.ufcg.edu.br", cliente2.getEmail());
	}
	
	@Test
	public void testGetLocalizacao() {
		assertEquals("SPG", cliente2.getLocalizacao());
	}

	@Test
	public void testGetLocalizacao2() {
		assertEquals("Labarc", cliente3.getLocalizacao());
	}
	
	@Test
	public void testGetCpf() {
		assertEquals("12345678900", cliente1.getCpf());
	}
	
	@Test
	public void testGetCpf2() {
		assertEquals("11111111100", cliente2.getCpf());
	}
	
	@Test
	public void testSetNome() {
		cliente1.setNome("Billy");
		assertEquals("Billy", cliente1.getNome());
	}
	
	@Test
	public void testSetEmail() {
		cliente2.setEmail("ana@example.com");
		assertEquals("ana@example.com", cliente2.getEmail());
	}
	
	@Test
	public void testSetLocalizacao() {
		cliente3.setLocalizacao("CAA");
		assertEquals("CAA", cliente3.getLocalizacao());
	}
	
	@Test
	public void testToString() {
		assertEquals("Victor Emanuel - Labarc - vitao@ccc.ufcg.edu.br", cliente3.toString());
	}
	
	@Test
	public void testCompareTo() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(cliente1);
		clientes.add(cliente2);
		assertEquals("[Raphael Agra - CAA - raphael.agra@ccc.ufcg.edu.br, Ana Amari - SPG - ana_amari@ccc.ufcg.edu.br]", clientes.toString());
		Collections.sort(clientes);
		assertEquals("[Ana Amari - SPG - ana_amari@ccc.ufcg.edu.br, Raphael Agra - CAA - raphael.agra@ccc.ufcg.edu.br]", clientes.toString());
	}
	
	@Test
	public void testAdicionaCompraFornecedorNulo() {
		try {
			cliente1.adicionaCompra(null, "10/10/2019", "Tapioca", "Tapioca com frango", 5.00);
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testAdicionaCompraFornecedorVazio() {
		try {
			cliente1.adicionaCompra("", "10/10/2019", "Tapioca", "Tapioca com frango", 5.00);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testAdicionaCompraDataNula() {
		try {
			cliente1.adicionaCompra("Josenilda", null, "Tapioca", "Tapioca com frango", 5.00);
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro ao cadastrar compra: data nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testAdicionaCompraDataVazia() {
		try {
			cliente1.adicionaCompra("Josenilda", "", "Tapioca", "Tapioca com frango", 5.00);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao cadastrar compra: data nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testAdicionaCompraNomeNulo() {
		try {
			cliente1.adicionaCompra("Josenilda", "10/10/2019", null, "Tapioca com frango", 5.00);
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testAdicionaCompraNomeVazio() {
		try {
			cliente1.adicionaCompra("Josenilda", "10/10/2019", "", "Tapioca com frango", 5.00);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testAdicionaCompraDataInvalida() {
		try {
			cliente1.adicionaCompra("Josenilda", "10/103/2019", "Tapioca", "Tapioca com frango", 5.00);
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao cadastrar compra: data invalida.", e.getMessage());
		}
	}
	
	@Test
	public void testExibeContasFornecedorNulo() {
		try {
			cliente1.exibeContas(null);
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testExibeContasFornecedorVazio() {
		try {
			cliente1.exibeContas("");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testExibeContasClienteSemConta() {
		try {
			cliente1.exibeContas("Josenilda");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao exibir conta do cliente: cliente nao tem nenhuma conta com o fornecedor.", e.getMessage());
		}
	}
	
	@Test
	public void testExibeContasFeliz() {
		cliente1.adicionaCompra("Josenilda", "12/10/2019", "Tapioca", "Tapioca com frango", 5.00);
		cliente1.adicionaCompra("Josenilda", "20/10/2019", "Suco", "Suco de maracuja", 3.00);
		assertEquals("Cliente: Raphael Agra | Josenilda | Tapioca - 12-10-2019 | Suco - 20-10-2019", cliente1.exibeContas("Josenilda"));
	}
	
	@Test
	public void testExibeContasClientesSemConta() {
		try {
			cliente1.exibeContasClientes();
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao exibir contas do cliente: cliente nao tem nenhuma conta.", e.getMessage());
		}
	}
	@Test
	public void testExibeContasClientesFeliz() {
		cliente1.adicionaCompra("Josenilda", "01/04/2019", "Biscoito salgado", "Biscoito com sal", 5.00);
		cliente1.adicionaCompra("Dona Ines", "01/03/2019", "Lanche FIT", "Tapioca + suco", 3.00);
		cliente1.adicionaCompra("Dona Ines", "29/04/2019", "Salada", "Salada de frutas", 3.00);
		assertEquals("Cliente: Raphael Agra | Dona Ines | Lanche FIT - 01-03-2019 | Salada - 29-04-2019 | Josenilda | Biscoito salgado - 01-04-2019", cliente1.exibeContasClientes());
	}
	
	@Test
	public void testGetDebitoFornecedorNulo() {
		try {
			cliente1.getDebito(null);
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testGetDebitoFornecedorVazio() {
		try {
			cliente1.getDebito("");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testGetDebitoClienteSemDebito() {
		try {
			cliente1.getDebito("Josenilda");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao recuperar debito: cliente nao tem debito com fornecedor.", e.getMessage());
		}
	}
	
	@Test
	public void testGetDebitoFeliz() {
		cliente1.adicionaCompra("Dona Ines", "01/03/2019", "Lanche FIT", "Tapioca + suco", 3.00);
		cliente1.adicionaCompra("Dona Ines", "29/04/2019", "Salada", "Salada de frutas", 3.00);
		assertEquals("6.00", cliente1.getDebito("Dona Ines"));
	}
	
	@Test
	public void testRealizaPagamentoFeliz() {
		try {
			cliente1.adicionaCompra("Dona Ines", "01/03/2019", "Lanche FIT", "Tapioca + suco", 3.00);
			cliente1.realizaPagamento("Dona Ines");
			cliente1.exibeContas("Dona Ines");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao exibir conta do cliente: cliente nao tem nenhuma conta com o fornecedor.", e.getMessage());
		}
	}
	
	@Test
	public void testRealizaPagamentoSemDebito() {
		try {
			cliente1.realizaPagamento("IRINEU");
			fail("Deveria ter lancado excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no pagamento de conta: nao ha debito do cliente associado a este fornecedor.", e.getMessage());
		}
	}
	
	@Test
	public void testGetCompras() {
		cliente1.adicionaCompra("Dona Ines", "01/03/2019", "Lanche FIT", "Tapioca + suco", 3.00);
		cliente1.adicionaCompra("Dona Ines", "29/04/2019", "Salada", "Salada de frutas", 3.00);
		assertEquals("[Lanche FIT - 01-03-2019, Salada - 29-04-2019]", cliente1.getCompras().toString());
	}
}
