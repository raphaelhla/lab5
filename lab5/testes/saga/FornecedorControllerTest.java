package saga;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FornecedorControllerTest {

	private FornecedorController fornecedorController;
	
	@BeforeEach
	public void criaController() {
		fornecedorController = new FornecedorController();
	}
	
	@Test
	public void testCadastraFornecedorValido() {
		assertEquals("Seu Olavo", fornecedorController.cadastraFornecedor("Seu Olavo", "olavo@gmail.com", "83 99999-8888"));
	}

	@Test
	public void testCadastraFornecedorExistente() {
		try {
			fornecedorController.cadastraFornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");
			fornecedorController.cadastraFornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de fornecedor: fornecedor ja existe.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastraFornecedorNomeNulo() {
		try {
			fornecedorController.cadastraFornecedor(null, "olavo@gmail.com", "83 99348-1092");
			fail("Deveria lancar excecao.");
		} catch (NullPointerException e) {
			assertEquals("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastraFornecedorNomeVazio() {
		try {
			fornecedorController.cadastraFornecedor("", "olavo@gmail.com", "83 99348-1092");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastraFornecedorEmailNulo() {
		try {
			fornecedorController.cadastraFornecedor("Seu Olavo", null, "83 99348-1092");
			fail("Deveria lancar excecao.");
		} catch (NullPointerException e) {
			assertEquals("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastraFornecedorEmailVazio() {
		try {
			fornecedorController.cadastraFornecedor("Seu Olavo", "", "83 99348-1092");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastraFornecedorTelefoneNulo() {
		try {
			fornecedorController.cadastraFornecedor("Seu Olavo", "olavo@gmail.com", null);
			fail("Deveria lancar excecao.");
		} catch (NullPointerException e) {
			assertEquals("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastraFornecedorTelefoneVazio() {
		try {
			fornecedorController.cadastraFornecedor("Seu Olavo", "olavo@gmail.com", "");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testExibeFornecedorValido() {
		fornecedorController.cadastraFornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");
		assertEquals("Seu Olavo - olavo@gmail.com - 83 99348-1092", fornecedorController.exibeFornecedor("Seu Olavo"));
	}
	
	@Test
	public void testExibeFornecedorNomeNulo() {
		try {
			fornecedorController.exibeFornecedor(null);
			fail("Deveria lancar excecao.");
		} catch (NullPointerException e) {
			assertEquals("Erro na exibicao do fornecedor: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testExibeFornecedorNomeVazio() {
		try {
			fornecedorController.exibeFornecedor("");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na exibicao do fornecedor: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testExibeFornecedorNomeInexistente() {
		try {
			fornecedorController.exibeFornecedor("Irineu");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na exibicao do fornecedor: fornecedor nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testListarFornecedores() {
		HashSet<String> listaFornecedores1 = new HashSet<String>();
		HashSet<String> listaFornecedores2 = new HashSet<String>();
		
		fornecedorController.cadastraFornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");
		fornecedorController.cadastraFornecedor("Raphael", "raphael@gmail.com", "83 98737-2109");
		listaFornecedores1.add(fornecedorController.exibeFornecedor("Seu Olavo"));
		listaFornecedores1.add(fornecedorController.exibeFornecedor("Raphael"));
		
		String[] x = fornecedorController.listarFornecedores().split(" \\| ");
		for (int i = 0; i < x.length; i++) {
			listaFornecedores2.add(x[i]);
		}
		assertEquals(listaFornecedores1,listaFornecedores2);
	}
	
	@Test
	public void testListarFornecedoresSemNenhumFornecedor() {
		assertEquals("",fornecedorController.listarFornecedores());
	}
	
	@Test
	public void testEditaFornecedorNomeNulo() {
		try {
			fornecedorController.editaFornecedor(null, "nome", "Irineu");
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testEditaFornecedorNomeVazio() {
		try {
			fornecedorController.editaFornecedor("", "nome", "Irineu");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testEditaFornecedorAtributoNulo() {
		try {
			fornecedorController.editaFornecedor("Raphael", null, "Irineu");
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testEditaFornecedorAtributoVazio() {
		try {
			fornecedorController.editaFornecedor("Raphael", "", "Irineu");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	
	@Test
	public void testEditaFornecedorNovoValorNulo() {
		try {
			fornecedorController.editaFornecedor("Raphael", "nome", null);
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testEditaFornecedorNovoValorVazio() {
		try {
			fornecedorController.editaFornecedor("Raphael", "nome", "");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testEditaFornecedorInexistente() {
		try {
			fornecedorController.editaFornecedor("Raphael", "nome", "Irineu");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao do fornecedor: fornecedor nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testEditaNomeFornecedor() {
		try {
			fornecedorController.cadastraFornecedor("Raphael", "raphael@gmail.com", "83 98737-2109");
			fornecedorController.editaFornecedor("Raphael", "nome", "Irineu");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao do fornecedor: nome nao pode ser editado.", e.getMessage());
		}
	}
	
	@Test
	public void testEditaEmailFornecedor() {
		fornecedorController.cadastraFornecedor("Raphael", "raphael@gmail.com", "83 98737-2109");
		fornecedorController.editaFornecedor("Raphael", "email", "biu@gmail.com");
		assertEquals("Raphael - biu@gmail.com - 83 98737-2109", fornecedorController.exibeFornecedor("Raphael"));
	}
	
	@Test
	public void testEditaTelefoneFornecedor() {
		fornecedorController.cadastraFornecedor("Raphael", "raphael@gmail.com", "83 98737-2109");
		fornecedorController.editaFornecedor("Raphael", "telefone", "99 99009-8888");
		assertEquals("Raphael - raphael@gmail.com - 99 99009-8888", fornecedorController.exibeFornecedor("Raphael"));
	}
	
	@Test
	public void testEditaFornecedorAtributoInexistente() {
		try {
			fornecedorController.cadastraFornecedor("Raphael", "raphael@gmail.com", "83 98737-2109");
			fornecedorController.editaFornecedor("Raphael", "xxxx", "Irineu");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao do fornecedor: atributo nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testRemoveFornecedorNomeNulo() {
		try {
			fornecedorController.removeFornecedor(null);
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testRemoveFornecedorNomeVazio() {
		try {
			fornecedorController.removeFornecedor("");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testRemoveFornecedorInexistente() {
		try {
			fornecedorController.removeFornecedor("Irineu");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na remocao do fornecedor: fornecedor nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testRemoveFornecedorValido() {
		try {
			fornecedorController.cadastraFornecedor("Raphael", "raphael@gmail.com", "83 98737-2109");
			fornecedorController.removeFornecedor("Raphael");
			fornecedorController.exibeFornecedor("Raphael");
			fail("Deveria lancar excecao");
		} catch(IllegalArgumentException e) {
			assertEquals("Erro na exibicao do fornecedor: fornecedor nao existe.", e.getMessage());
		}
	}
	//
	@Test
	public void testCadastraProdutoFornecedorNulo() {
		try {
			fornecedorController.cadastraFornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");
			fornecedorController.cadastraProduto(null, "Tapioca", "Tapioca com frango", 10.00);
			fail("Deveria lancar excecao.");
		} catch (NullPointerException e) {
			assertEquals("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastraProdutoFornecedorVazio() {
		try {
			fornecedorController.cadastraFornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");
			fornecedorController.cadastraProduto("", "Tapioca", "Tapioca com frango", 10.00);
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastraProdutoFornecedorInexistente() {
		try {
			fornecedorController.cadastraProduto("Irineu", "Tapioca", "Tapioca com frango", 10.00);
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de produto: fornecedor nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastraProdutoNomeNulo() {
		try {
			fornecedorController.cadastraFornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");
			fornecedorController.cadastraProduto("Seu Olavo", null, "Tapioca com frango", 10.00);
			fail("Deveria lancar excecao.");
		} catch (NullPointerException e) {
			assertEquals("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastraProdutoNomeVazio() {
		try {
			fornecedorController.cadastraFornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");
			fornecedorController.cadastraProduto("Seu Olavo", "", "Tapioca com frango", 10.00);
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastraProdutoDescricaoNula() {
		try {
			fornecedorController.cadastraFornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");
			fornecedorController.cadastraProduto("Seu Olavo", "Tapioca", null, 10.00);
			fail("Deveria lancar excecao.");
		} catch (NullPointerException e) {
			assertEquals("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastraProdutoDescricaoVazia() {
		try {
			fornecedorController.cadastraFornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");
			fornecedorController.cadastraProduto("Seu Olavo", "Tapioca", "", 10.00);
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastraProdutoPrecoInvalido() {
		try {
			fornecedorController.cadastraFornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");
			fornecedorController.cadastraProduto("Seu Olavo", "Tapioca", "Tapioca com frango", -1);
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de produto: preco invalido.", e.getMessage());
		}
	}
	
	@Test
	public void testCadastraProdutoExistente() {
		try {
			fornecedorController.cadastraFornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");
			fornecedorController.cadastraProduto("Seu Olavo", "Tapioca", "Tapioca com frango", 10.00);
			fornecedorController.cadastraProduto("Seu Olavo", "Tapioca", "Tapioca com frango", 10.00);
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de produto: produto ja existe.", e.getMessage());
		}
	}
		
	@Test
	public void testExibeProdutoFornecedorNulo() {
		try {
			fornecedorController.cadastraFornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");
			fornecedorController.exibeProduto("Tapioca", "Tapioca com frango", null);
			fail("Deveria lancar excecao.");
		} catch (NullPointerException e) {
			assertEquals("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testExibeProdutoFornecedorVazio() {
		try {
			fornecedorController.cadastraFornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");
			fornecedorController.exibeProduto("Tapioca", "Tapioca com frango", "");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testExibeProdutoNomeNulo() {
		try {
			fornecedorController.cadastraFornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");
			fornecedorController.exibeProduto(null, "Tapioca com frango", "Seu Olavo");
			fail("Deveria lancar excecao.");
		} catch (NullPointerException e) {
			assertEquals("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testExibeProdutoNomeVazio() {
		try {
			fornecedorController.cadastraFornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");
			fornecedorController.exibeProduto("", "Tapioca com frango", "Seu Olavo");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testExibeProdutoDescricaoNula() {
		try {
			fornecedorController.cadastraFornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");
			fornecedorController.exibeProduto("Tapioca", null, "Seu Olavo");
			fail("Deveria lancar excecao.");
		} catch (NullPointerException e) {
			assertEquals("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testExibeProdutoDescricaoVazia() {
		try {
			fornecedorController.cadastraFornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");
			fornecedorController.exibeProduto("Tapioca", "", "Seu Olavo");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testExibeProdutoFornecedorInexistente() {
		try {
			fornecedorController.cadastraFornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");
			fornecedorController.exibeProduto("Tapioca", "Tapioca com frango", "Irineu");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na exibicao de produto: fornecedor nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testExibeProdutoValido() {
		fornecedorController.cadastraFornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");
		fornecedorController.cadastraProduto("Seu Olavo", "Tapioca", "Tapioca com frango", 10.00);
		fornecedorController.exibeProduto("Tapioca", "Tapioca com frango", "Seu Olavo");
		assertEquals("Tapioca - Tapioca com frango - R$10,00",fornecedorController.exibeProduto("Tapioca", "Tapioca com frango", "Seu Olavo"));
	}
	
	@Test
	public void testListarProdutosDeUmFornecedor() {
		HashSet<String> listaProdutos1 = new HashSet<String>();
		HashSet<String> listaProdutos2 = new HashSet<String>();
		
		fornecedorController.cadastraFornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");
		fornecedorController.cadastraProduto("Seu Olavo", "X-frango","Hamburguer de frango com queijo e calabresa", 5.00);
		fornecedorController.cadastraProduto("Seu Olavo", "X-burguer","Hamburguer de carne com queijo e calabresa", 4.50);
		listaProdutos1.add("Seu Olavo - " + fornecedorController.exibeProduto("X-frango", "Hamburguer de frango com queijo e calabresa", "Seu Olavo"));
		listaProdutos1.add("Seu Olavo - " + fornecedorController.exibeProduto("X-burguer", "Hamburguer de carne com queijo e calabresa", "Seu Olavo"));
		
		String[] x = fornecedorController.listarProdutosDeUmFornecedor("Seu Olavo").split(" \\| ");
		for (int i = 0; i < x.length; i++) {
			listaProdutos2.add(x[i]);
		}
		assertEquals(listaProdutos1,listaProdutos2);
	}
	
	@Test
	public void testListarProdutosDeTodosFornecedores() {
		HashSet<String> listaProdutos1 = new HashSet<String>();
		HashSet<String> listaProdutos2 = new HashSet<String>();
		
		fornecedorController.cadastraFornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");
		fornecedorController.cadastraProduto("Seu Olavo", "X-frango","Hamburguer de frango com queijo e calabresa", 5.00);
		fornecedorController.cadastraProduto("Seu Olavo", "X-tudo","Hamburguer de frango e carne com queijo e calabresa", 10.00);
		
		fornecedorController.cadastraFornecedor("Raphael", "raphael@gmail.com", "83 98737-2109");
		fornecedorController.cadastraProduto("Raphael", "X-burguer","Hamburguer de carne com queijo e calabresa", 4.50);
		fornecedorController.cadastraProduto("Raphael", "Cachorro Quente","Pao com salsicha e carne moida", 7.00);
		listaProdutos1.add("Seu Olavo - " + fornecedorController.exibeProduto("X-frango", "Hamburguer de frango com queijo e calabresa", "Seu Olavo"));
		listaProdutos1.add("Seu Olavo - " + fornecedorController.exibeProduto("X-tudo", "Hamburguer de frango e carne com queijo e calabresa", "Seu Olavo"));
		
		listaProdutos1.add("Raphael - " + fornecedorController.exibeProduto("X-burguer", "Hamburguer de carne com queijo e calabresa", "Raphael"));
		listaProdutos1.add("Raphael - " + fornecedorController.exibeProduto("Cachorro Quente","Pao com salsicha e carne moida", "Raphael"));
		
		String[] x = fornecedorController.listarProdutosDeTodosFornecedores().split(" \\| ");
		for (int i = 0; i < x.length; i++) {
			listaProdutos2.add(x[i]);
		}
		assertEquals(listaProdutos1,listaProdutos2);
	}
	
	@Test
	public void testEditaProdutoFornecedorNulo() {
		try {
			fornecedorController.cadastraFornecedor("Raphael", "raphael@gmail.com", "83 98737-2109");
			fornecedorController.cadastraProduto("Raphael", "Tapioca", "Tapioca com frango", 5.00);
			fornecedorController.editaProduto(null,"Tapioca", "Tapioca com frango", 10.00);
			fail("Deveria lancar excecao.");
		} catch (NullPointerException e) {
			assertEquals("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testEditaProdutoFornecedorVazio() {
		try {
			fornecedorController.cadastraFornecedor("Raphael", "raphael@gmail.com", "83 98737-2109");
			fornecedorController.cadastraProduto("Raphael", "Tapioca", "Tapioca com frango", 5.00);
			fornecedorController.editaProduto("","Tapioca", "Tapioca com frango", 10.00);
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testEditaProdutoNomeNulo() {
		try {
			fornecedorController.cadastraFornecedor("Raphael", "raphael@gmail.com", "83 98737-2109");
			fornecedorController.cadastraProduto("Raphael", "Tapioca", "Tapioca com frango", 5.00);
			fornecedorController.editaProduto("Raphael",null, "Tapioca com frango", 10.00);
			fail("Deveria lancar excecao.");
		} catch (NullPointerException e) {
			assertEquals("Erro na edicao de produto: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testEditaProdutoNomeVazio() {
		try {
			fornecedorController.cadastraFornecedor("Raphael", "raphael@gmail.com", "83 98737-2109");
			fornecedorController.cadastraProduto("Raphael", "Tapioca", "Tapioca com frango", 5.00);
			fornecedorController.editaProduto("Raphael","", "Tapioca com frango", 10.00);
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao de produto: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testEditaProdutoDescricaoNula() {
		try {
			fornecedorController.cadastraFornecedor("Raphael", "raphael@gmail.com", "83 98737-2109");
			fornecedorController.cadastraProduto("Raphael", "Tapioca", "Tapioca com frango", 5.00);
			fornecedorController.editaProduto("Raphael","Tapioca", null, 10.00);
			fail("Deveria lancar excecao.");
		} catch (NullPointerException e) {
			assertEquals("Erro na edicao de produto: descricao nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testEditaProdutoDescricaoVazia() {
		try {
			fornecedorController.cadastraFornecedor("Raphael", "raphael@gmail.com", "83 98737-2109");
			fornecedorController.cadastraProduto("Raphael", "Tapioca", "Tapioca com frango", 5.00);
			fornecedorController.editaProduto("Raphael","Tapioca", "", 10.00);
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao de produto: descricao nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testEditaProdutoFornecedorInexistente() {
		try {
			fornecedorController.cadastraFornecedor("Raphael", "raphael@gmail.com", "83 98737-2109");
			fornecedorController.cadastraProduto("Raphael", "Tapioca", "Tapioca com frango", 5.00);
			fornecedorController.editaProduto("IRINEU","Tapioca", "Tapioca com frango", 10.00);
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao de produto: fornecedor nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testEditaProdutoPrecoInvalido() {
		try {
			fornecedorController.cadastraFornecedor("Raphael", "raphael@gmail.com", "83 98737-2109");
			fornecedorController.cadastraProduto("Raphael", "Tapioca", "Tapioca com frango", 5.00);
			fornecedorController.editaProduto("Raphael","Tapioca", "Tapioca com frango", -1);
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao de produto: preco invalido.", e.getMessage());
		}
	}
	
	@Test
	public void testEditaProdutoValido() {
			fornecedorController.cadastraFornecedor("Raphael", "raphael@gmail.com", "83 98737-2109");
			fornecedorController.cadastraProduto("Raphael", "Tapioca", "Tapioca com frango", 5.00);
			fornecedorController.editaProduto("Raphael","Tapioca", "Tapioca com frango", 10.00);
			assertEquals("Tapioca - Tapioca com frango - R$10,00", fornecedorController.exibeProduto("Tapioca", "Tapioca com frango", "Raphael"));
	}
	
	@Test
	public void testRemoveProdutoFornecedorNulo() {
		try {
			fornecedorController.cadastraFornecedor("Raphael", "raphael@gmail.com", "83 98737-2109");
			fornecedorController.cadastraProduto("Raphael", "Tapioca", "Tapioca com frango", 5.00);
			fornecedorController.removeProduto(null,"Tapioca", "Tapioca com frango");
			fail("Deveria lancar excecao.");
		} catch (NullPointerException e) {
			assertEquals("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testRemoveProdutoFornecedorVazio() {
		try {
			fornecedorController.cadastraFornecedor("Raphael", "raphael@gmail.com", "83 98737-2109");
			fornecedorController.cadastraProduto("Raphael", "Tapioca", "Tapioca com frango", 5.00);
			fornecedorController.removeProduto("","Tapioca", "Tapioca com frango");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testRemoveProdutoNomeNulo() {
		try {
			fornecedorController.cadastraFornecedor("Raphael", "raphael@gmail.com", "83 98737-2109");
			fornecedorController.cadastraProduto("Raphael", "Tapioca", "Tapioca com frango", 5.00);
			fornecedorController.removeProduto("Raphael",null, "Tapioca com frango");
			fail("Deveria lancar excecao.");
		} catch (NullPointerException e) {
			assertEquals("Erro na remocao de produto: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testRemoveProdutoNomeVazio() {
		try {
			fornecedorController.cadastraFornecedor("Raphael", "raphael@gmail.com", "83 98737-2109");
			fornecedorController.cadastraProduto("Raphael", "Tapioca", "Tapioca com frango", 5.00);
			fornecedorController.removeProduto("Raphael","", "Tapioca com frango");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na remocao de produto: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testRemoveProdutoDescricaoNula() {
		try {
			fornecedorController.cadastraFornecedor("Raphael", "raphael@gmail.com", "83 98737-2109");
			fornecedorController.cadastraProduto("Raphael", "Tapioca", "Tapioca com frango", 5.00);
			fornecedorController.removeProduto("Raphael","Tapioca", null);
			fail("Deveria lancar excecao.");
		} catch (NullPointerException e) {
			assertEquals("Erro na remocao de produto: descricao nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testRemoveProdutoDescricaoVazia() {
		try {
			fornecedorController.cadastraFornecedor("Raphael", "raphael@gmail.com", "83 98737-2109");
			fornecedorController.cadastraProduto("Raphael", "Tapioca", "Tapioca com frango", 5.00);
			fornecedorController.removeProduto("Raphael","Tapioca", "");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na remocao de produto: descricao nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testRemoveProdutoFornecedorInexistente() {
		try {
			fornecedorController.cadastraFornecedor("Raphael", "raphael@gmail.com", "83 98737-2109");
			fornecedorController.cadastraProduto("Raphael", "Tapioca", "Tapioca com frango", 5.00);
			fornecedorController.removeProduto("IRINEU","Tapioca", "Tapioca com frango");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na remocao de produto: fornecedor nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testRemoveProdutoValido() {
		try {
			fornecedorController.cadastraFornecedor("Raphael", "raphael@gmail.com", "83 98737-2109");
			fornecedorController.cadastraProduto("Raphael", "Tapioca", "Tapioca com frango", 5.00);
			fornecedorController.removeProduto("Raphael","Tapioca", "Tapioca com frango");
			fornecedorController.exibeProduto("Tapioca", "Tapioca com frango", "Raphael");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na exibicao de produto: produto nao existe.", e.getMessage());
		}
	}
}
