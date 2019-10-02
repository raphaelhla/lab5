package saga;

import static org.junit.jupiter.api.Assertions.*;

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
}
