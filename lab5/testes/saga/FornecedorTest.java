package saga;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FornecedorTest {

	private Fornecedor fornecedor1, fornecedor2, fornecedor3;

	@BeforeEach
	public void criandoFornecedor() {
		fornecedor1 = new Fornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");
		fornecedor2 = new Fornecedor("Raphael", "raphael@gmail.com", "83 98737-2109");
		fornecedor3 = new Fornecedor("Dona Alba", "alba@gmail.com", "83 99945-1294");
	}

	@Test
	public void testCadastraFornecedorNomeNulo() {
		try {
			new Fornecedor(null, "olavo@gmail.com", "83 99348-1092");
			fail("Deveria lancar excecao.");
		} catch (NullPointerException e) {
			assertEquals("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastraFornecedorNomeVazio() {
		try {
			new Fornecedor("", "olavo@gmail.com", "83 99348-1092");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastraFornecedorEmailNulo() {
		try {
			new Fornecedor("Seu Olavo", null, "83 99348-1092");
			fail("Deveria lancar excecao.");
		} catch (NullPointerException e) {
			assertEquals("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastraFornecedorEmailVazio() {
		try {
			new Fornecedor("Seu Olavo", "", "83 99348-1092");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastraFornecedorTelefoneNulo() {
		try {
			new Fornecedor("Seu Olavo", "olavo@gmail.com", null);
			fail("Deveria lancar excecao.");
		} catch (NullPointerException e) {
			assertEquals("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastraFornecedorTelefoneVazio() {
		try {
			new Fornecedor("Seu Olavo", "olavo@gmail.com", "");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testGetEmailFornecedor() {
		assertEquals("olavo@gmail.com", fornecedor1.getEmail());
	}
	
	@Test
	public void testGetEmailFornecedor2() {
		assertEquals("raphael@gmail.com", fornecedor2.getEmail());
	}
	
	@Test
	public void testGetTelefoneFornecedor() {
		assertEquals("83 99348-1092", fornecedor1.getTelefone());
	}
	
	@Test
	public void testGetTelefoneFornecedor2() {
		assertEquals("83 98737-2109", fornecedor2.getTelefone());
	}
	
	@Test
	public void testGetNomeFornecedor() {
		assertEquals("Seu Olavo", fornecedor1.getNome());
	}
	
	@Test
	public void testGetNomeFornecedor2() {
		assertEquals("Dona Alba", fornecedor3.getNome());
	}
	
	@Test
	public void testSetEmailFornecedor() {
		fornecedor1.setEmail("olavinho@gmail.com");
		assertEquals("olavinho@gmail.com", fornecedor1.getEmail());
	}
	
	@Test
	public void testSetTelefoneFornecedor() {
		fornecedor3.setTelefone("83 99999-9999");
		assertEquals("83 99999-9999", fornecedor3.getTelefone());
	}
	
	@Test
	public void testHashCode() {
		assertNotEquals(fornecedor1.hashCode(), fornecedor2.hashCode());
	}
	
	@Test
	public void testHashCode2() {
		Fornecedor f4 = new Fornecedor("Seu Olavo", "irineu@gmail.com", "333333333");
		assertEquals(fornecedor1.hashCode(), f4.hashCode());
	}
	
	@Test
	public void testEqualsFornecedorMesmoNome() {
		Fornecedor f4 = new Fornecedor("Seu Olavo", "irineu@gmail.com", "333333333");
		assertTrue(fornecedor1.equals(f4));
	}
	
	@Test
	public void testEqualsFornecedorDiferente() {
		assertFalse(fornecedor1.equals(fornecedor2));
	}
	
	@Test
	public void testEqualsFornecedorComOutraClasse() {
		Cliente cliente = new Cliente("Raphael Agra", "12345678900", "raphael.agra@ccc.ufcg.edu.br", "CAA");
		assertFalse(fornecedor1.equals(cliente));
	}
	
	@Test
	public void testEqualsComNull() {
		assertFalse(fornecedor1.equals(null));
	}
	
	@Test
	public void testEqualsComEleMesmo() {
		assertTrue(fornecedor1.equals(fornecedor1));
	}
	
	@Test
	public void testFornecedorToString() {
		assertEquals("Seu Olavo - olavo@gmail.com - 83 99348-1092", fornecedor1.toString());
	}
	
	@Test
	public void testFornecedorToString2() {
		assertEquals("Raphael - raphael@gmail.com - 83 98737-2109", fornecedor2.toString());
	}
	
	@Test
	public void testCadastraProdutoNomeNulo() {
		try {
			fornecedor1.cadastraProduto(10.00, null, "Tapioca com frango");
			fail("Deveria lancar excecao.");
		} catch (NullPointerException e) {
			assertEquals("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastraProdutoNomeVazio() {
		try {
			fornecedor1.cadastraProduto(10.00, "", "Tapioca com frango");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastraProdutoDescricaoNula() {
		try {
			fornecedor1.cadastraProduto(10.00, "Tapioca", null);
			fail("Deveria lancar excecao.");
		} catch (NullPointerException e) {
			assertEquals("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastraProdutoDescricaoVazia() {
		try {
			fornecedor1.cadastraProduto(10.00, "Tapioca", "");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastraProdutoPrecoInvalido() {
		try {
			fornecedor1.cadastraProduto(-1, "Tapioca", "Tapioca com frango");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de produto: preco invalido.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastraProdutoExistente() {
		try {
			fornecedor1.cadastraProduto(10.00, "Tapioca", "Tapioca com frango");
			fornecedor1.cadastraProduto(10.00, "Tapioca", "Tapioca com frango");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de produto: produto ja existe.", e.getMessage());
		}
	}
	
	@Test
	public void testExibeProdutoNomeNulo() {
		try {
			fornecedor1.exibeProduto(null, "Tapioca com frango");
			fail("Deveria lancar excecao.");
		} catch (NullPointerException e) {
			assertEquals("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testExibeProdutoNomeVazio() {
		try {
			fornecedor1.exibeProduto("", "Tapioca com frango");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testExibeProdutoDescricaoNula() {
		try {
			fornecedor1.exibeProduto("Tapioca", null);
			fail("Deveria lancar excecao.");
		} catch (NullPointerException e) {
			assertEquals("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testExibeProdutoDescricaoVazia() {
		try {
			fornecedor1.exibeProduto("Tapioca", "");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testExibeProdutoInexistente() {
		try {
			fornecedor1.exibeProduto("Tapioca", "Tapioca com cogumelo espacial");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na exibicao de produto: produto nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testExibeProdutoValido() {
		fornecedor1.cadastraProduto(10.00, "Tapioca", "Tapioca com frango");
		assertEquals("Tapioca - Tapioca com frango - R$10,00", fornecedor1.exibeProduto("Tapioca", "Tapioca com frango"));
	}
	
	@Test
	public void testListarProdutos() {
		HashSet<String> listaProdutos1 = new HashSet<String>();
		HashSet<String> listaProdutos2 = new HashSet<String>();
		
		fornecedor2.cadastraProduto(5.00, "X-frango","Hamburguer de frango com queijo e calabresa");
		fornecedor2.cadastraProduto(4.50, "X-burguer","Hamburguer de carne com queijo e calabresa");
		listaProdutos1.add(fornecedor2.getNome() + " - " + fornecedor2.exibeProduto("X-frango", "Hamburguer de frango com queijo e calabresa"));
		listaProdutos1.add(fornecedor2.getNome() + " - " + fornecedor2.exibeProduto("X-burguer", "Hamburguer de carne com queijo e calabresa"));
		
		String[] x = fornecedor2.listarProdutos().split(" \\| ");
		for (int i = 0; i < x.length; i++) {
			listaProdutos2.add(x[i]);
		}
		assertEquals(listaProdutos1,listaProdutos2);
	}
	
	@Test
	public void testListarProdutosListaVazia() {
		assertEquals("",fornecedor3.listarProdutos());
	}
	
	@Test
	public void testEditaProdutoNomeNulo() {
		try {
			fornecedor1.editaProduto(null, "Tapioca com frango", 20.00);
			fail("Deveria lancar excecao.");
		} catch (NullPointerException e) {
			assertEquals("Erro na edicao de produto: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testEditaProdutoNomeVazio() {
		try {
			fornecedor1.editaProduto("", "Tapioca com frango", 20.00);
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao de produto: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testEditaProdutoDescricaoNula() {
		try {
			fornecedor1.editaProduto("Tapioca", null, 20.00);
			fail("Deveria lancar excecao.");
		} catch (NullPointerException e) {
			assertEquals("Erro na edicao de produto: descricao nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testEditaProdutoDescricaoVazia() {
		try {
			fornecedor1.editaProduto("Tapioca", "", 20.00);
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao de produto: descricao nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testEditaProdutoPrecoInvalido() {
		try {
			fornecedor1.editaProduto("Tapioca", "Tapioca com frango", -1);
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao de produto: preco invalido.", e.getMessage());
		}
	}

	@Test
	public void testEditaProdutoInexistente() {
		try {
			fornecedor1.editaProduto("Tapioca", "Tapioca com cogumelo espacial", 20.00);
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao de produto: produto nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testEditaProdutoValido() {
		fornecedor1.cadastraProduto(10.00, "Tapioca", "Tapioca com frango");
		fornecedor1.editaProduto("Tapioca", "Tapioca com frango", 20.00);
		assertEquals("Tapioca - Tapioca com frango - R$20,00", fornecedor1.exibeProduto("Tapioca", "Tapioca com frango"));
	}
	
	@Test
	public void testRemoveProdutoNomeNulo() {
		try {
			fornecedor1.removeProduto(null, "Tapioca com cogumelo espacial");
			fail("Deveria lancar excecao.");
		} catch (NullPointerException e) {
			assertEquals("Erro na remocao de produto: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testRemoveProdutoNomeVazio() {
		try {
			fornecedor1.removeProduto("", "Tapioca com cogumelo espacial");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na remocao de produto: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testRemoveProdutoDescricaoNula() {
		try {
			fornecedor1.removeProduto("Tapioca", null);
			fail("Deveria lancar excecao.");
		} catch (NullPointerException e) {
			assertEquals("Erro na remocao de produto: descricao nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testRemoveProdutoDescricaoVazia() {
		try {
			fornecedor1.removeProduto("Tapioca", "");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na remocao de produto: descricao nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testRemoveProdutoInexistente() {
		try {
			fornecedor1.removeProduto("Tapioca", "Tapioca com cogumelo espacial");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na remocao de produto: produto nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testRemoveProdutoValido() {
		try {
			fornecedor1.cadastraProduto(10.00, "Tapioca", "Tapioca com frango");
			fornecedor1.removeProduto("Tapioca", "Tapioca com frango");
			fornecedor1.exibeProduto("Tapioca", "Tapioca com frango");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na exibicao de produto: produto nao existe.", e.getMessage());
		}
	}
}
