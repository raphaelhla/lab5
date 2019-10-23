package saga;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

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
		assertEquals("Tapioca - Tapioca com frango - R$10,00",
				fornecedor1.exibeProduto("Tapioca", "Tapioca com frango"));
	}

	@Test
	public void testExibeProdutoComboValido() {
		fornecedor2.cadastraProduto(5.00, "X-frango", "Hamburguer de frango com queijo e calabresa");
		fornecedor2.cadastraProduto(4.50, "X-burguer", "Hamburguer de carne com queijo e calabresa");
		fornecedor2.adicionaCombo("Combo X", "X-burguer + X-frango", 0.3,
				"X-frango - Hamburguer de frango com queijo e calabresa, X-burguer - Hamburguer de carne com queijo e calabresa");
		assertEquals("Combo X - X-burguer + X-frango - R$6,65",
				fornecedor2.exibeProduto("Combo X", "X-burguer + X-frango"));

	}

	@Test
	public void testListarProdutos() {
		fornecedor2.cadastraProduto(5.00, "X-frango", "Hamburguer de frango com queijo e calabresa");
		fornecedor2.cadastraProduto(4.50, "X-burguer", "Hamburguer de carne com queijo e calabresa");
		assertEquals(
				"Raphael - X-burguer - Hamburguer de carne com queijo e calabresa - R$4,50 | Raphael - X-frango - Hamburguer de frango com queijo e calabresa - R$5,00",
				fornecedor2.listarProdutos());
	}

	@Test
	public void testListarProdutosListaVazia() {
		assertEquals("Dona Alba -", fornecedor3.listarProdutos());
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
		assertEquals("Tapioca - Tapioca com frango - R$20,00",
				fornecedor1.exibeProduto("Tapioca", "Tapioca com frango"));
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

	@Test
	public void testRemoveComboValido() {
		try {
			fornecedor2.cadastraProduto(5.00, "X-frango", "Hamburguer de frango com queijo e calabresa");
			fornecedor2.cadastraProduto(4.50, "X-burguer", "Hamburguer de carne com queijo e calabresa");
			fornecedor2.adicionaCombo("Combo X", "X-burguer + X-frango", 0.3,
					"X-frango - Hamburguer de frango com queijo e calabresa, X-burguer - Hamburguer de carne com queijo e calabresa");
			fornecedor2.removeProduto("Combo X", "X-burguer + X-frango");
			fornecedor2.exibeProduto("Combo X", "X-burguer + X-frango");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na exibicao de produto: produto nao existe.", e.getMessage());
		}
	}

	@Test
	public void testAdicionaComboNomeNulo() {
		try {
			fornecedor1.adicionaCombo(null, "Lanche saudavel", 0.5,
					"Tapioca - Tapioca com frango, Suco - Suco de maracuja");
			fail("Deveria lancar excecao.");
		} catch (NullPointerException e) {
			assertEquals("Erro no cadastro de combo: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}

	@Test
	public void testAdicionaComboNomeVazio() {
		try {
			fornecedor1.adicionaCombo("", "Lanche saudavel", 0.5,
					"Tapioca - Tapioca com frango, Suco - Suco de maracuja");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de combo: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}

	@Test
	public void testAdicionaComboDescricaoNula() {
		try {
			fornecedor1.adicionaCombo("Lanche FIT", null, 0.5, "Tapioca - Tapioca com frango, Suco - Suco de maracuja");
			fail("Deveria lancar excecao.");
		} catch (NullPointerException e) {
			assertEquals("Erro no cadastro de combo: descricao nao pode ser vazia ou nula.", e.getMessage());
		}
	}

	@Test
	public void testAdicionaComboDescricaoVazia() {
		try {
			fornecedor1.adicionaCombo("Lanche FIT", "", 0.5, "Tapioca - Tapioca com frango, Suco - Suco de maracuja");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de combo: descricao nao pode ser vazia ou nula.", e.getMessage());
		}
	}

	@Test
	public void testAdicionaComboProdutosNulo() {
		try {
			fornecedor1.adicionaCombo("Lanche FIT", "Lanche saudavel", 0.5, null);
			fail("Deveria lancar excecao.");
		} catch (NullPointerException e) {
			assertEquals("Erro no cadastro de combo: combo deve ter produtos.", e.getMessage());
		}
	}

	@Test
	public void testAdicionaComboProdutoVazio() {
		try {
			fornecedor1.adicionaCombo("Lanche FIT", "Lanche saudavel", 0.5, "");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de combo: combo deve ter produtos.", e.getMessage());
		}
	}

	@Test
	public void testAdicionaComboFatorInvalido() {
		try {
			fornecedor1.adicionaCombo("Lanche FIT", "Lanche saudavel", 1.5,
					"Tapioca - Tapioca com frango, Suco - Suco de maracuja");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de combo: fator invalido.", e.getMessage());
		}

		try {
			fornecedor1.adicionaCombo("Lanche FIT", "Lanche saudavel", -1,
					"Tapioca - Tapioca com frango, Suco - Suco de maracuja");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de combo: fator invalido.", e.getMessage());
		}
	}

	@Test
	public void testAdicionaComboExistente() {
		try {
			fornecedor1.cadastraProduto(3.00, "Biscoito Salgado", "Bolachinha de cebola");
			fornecedor1.cadastraProduto(4.00, "Sobremesa", "Mousse de limão");
			fornecedor1.adicionaCombo("Promo 1", "Bolachinha de cebola + Mousse de limão", 0.10,
					"Biscoito Salgado - Bolachinha de cebola, Sobremesa - Mousse de limão");
			fornecedor1.adicionaCombo("Promo 1", "Bolachinha de cebola + Mousse de limão", 0.10,
					"Biscoito Salgado - Bolachinha de cebola, Sobremesa - Mousse de limão");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de combo: combo ja existe.", e.getMessage());
		}
	}

	@Test
	public void testAdicionaComboProdutoInexistente() {
		try {
			fornecedor1.cadastraProduto(3.00, "Biscoito Salgado", "Bolachinha de cebola");
			fornecedor1.cadastraProduto(4.00, "Sobremesa", "Mousse de limão");
			fornecedor1.adicionaCombo("Promo 1", "Bolachinha de cebola + Mousse de limão", 0.10,
					"Biscoito Salgado - Bolachinha de cebola, IRINEU - Mousse de limão");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de combo: produto nao existe.", e.getMessage());
		}
	}

	@Test
	public void testAdicionaComboDentroDeCombo() {
		try {
			fornecedor1.cadastraProduto(3.00, "Biscoito Salgado", "Bolachinha de cebola");
			fornecedor1.cadastraProduto(4.00, "Sobremesa", "Mousse de limão");
			fornecedor1.adicionaCombo("Promo 1", "Bolachinha de cebola + Mousse de limão", 0.10,
					"Biscoito Salgado - Bolachinha de cebola, Sobremesa - Mousse de limão");
			fornecedor1.adicionaCombo("Promo 2", "Bolachinha de cebola + Mousse de limão2", 0.30,
					"Biscoito Salgado - Bolachinha de cebola, Promo 1 - Bolachinha de cebola + Mousse de limão");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de combo: um combo nao pode possuir combos na lista de produtos.",
					e.getMessage());
		}
	}

	@Test
	public void testEditaComboNomeNulo() {
		try {
			fornecedor1.editaCombo(null, "Lanche saudavel", 0.3);
			fail("Deveria lancar excecao.");
		} catch (NullPointerException e) {
			assertEquals("Erro na edicao de combo: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}

	@Test
	public void testEditaComboNomeVazio() {
		try {
			fornecedor1.editaCombo("", "Lanche saudavel", 0.3);
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao de combo: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}

	@Test
	public void testEditaComboDescricaoNula() {
		try {
			fornecedor1.editaCombo("Lanche FIT", null, 0.3);
			fail("Deveria lancar excecao.");
		} catch (NullPointerException e) {
			assertEquals("Erro na edicao de combo: descricao nao pode ser vazia ou nula.", e.getMessage());
		}
	}

	@Test
	public void testEditaComboDescricaoVazia() {
		try {
			fornecedor1.editaCombo("Lanche FIT", "", 0.3);
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao de combo: descricao nao pode ser vazia ou nula.", e.getMessage());
		}
	}

	@Test
	public void testEditaComboFatorInvalido() {
		try {
			fornecedor1.editaCombo("Lanche FIT", "Lanche saudavel", 1);
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao de combo: fator invalido.", e.getMessage());
		}

		try {
			fornecedor1.editaCombo("Lanche FIT", "Lanche saudavel", -1);
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao de combo: fator invalido.", e.getMessage());
		}
	}

	@Test
	public void testEditaComboInexistente() {
		try {
			fornecedor1.editaCombo("Lanche FIT", "Lanche saudavel", 0.5);
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao de combo: produto nao existe.", e.getMessage());
		}
	}

	@Test
	public void testEditaComboFeliz() {
		fornecedor1.cadastraProduto(3.00, "Biscoito Salgado", "Bolachinha de cebola");
		fornecedor1.cadastraProduto(4.00, "Sobremesa", "Mousse de limão");
		fornecedor1.adicionaCombo("Promo 1", "Bolachinha de cebola + Mousse de limão", 0.10,
				"Biscoito Salgado - Bolachinha de cebola, Sobremesa - Mousse de limão");
		fornecedor1.editaCombo("Promo 1", "Bolachinha de cebola + Mousse de limão", 0.30);
		assertEquals(4.90, fornecedor1.getPrecoProduto("Promo 1", "Bolachinha de cebola + Mousse de limão"), 0.01);
	}

	@Test
	public void testExisteProduto() {
		fornecedor1.cadastraProduto(3.00, "Biscoito Salgado", "Bolachinha de cebola");
		assertTrue(fornecedor1.existeProduto("Biscoito Salgado", "Bolachinha de cebola"));
	}
	
	@Test
	public void testGetPrecoProdutoInexistente() {
		try {
			fornecedor1.getPrecoProduto("Lanche FIT", "Lanche saudavel");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao recuperar preco do produto: produto nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testGetPrecoProdutoSimples() {
		fornecedor1.cadastraProduto(3.00, "Biscoito Salgado", "Bolachinha de cebola");
		assertEquals(3.00, fornecedor1.getPrecoProduto("Biscoito Salgado", "Bolachinha de cebola"), 0.01);
	}
	
	@Test
	public void testGetPrecoCombo() {
		fornecedor1.cadastraProduto(3.00, "Biscoito Salgado", "Bolachinha de cebola");
		fornecedor1.cadastraProduto(4.00, "Sobremesa", "Mousse de limão");
		fornecedor1.adicionaCombo("Promo 1", "Bolachinha de cebola + Mousse de limão", 0.10,
				"Biscoito Salgado - Bolachinha de cebola, Sobremesa - Mousse de limão");
		assertEquals(6.30, fornecedor1.getPrecoProduto("Promo 1", "Bolachinha de cebola + Mousse de limão"), 0.01);
	}
}
