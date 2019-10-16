package saga;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;


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
		fornecedorController.cadastraFornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");
		fornecedorController.cadastraFornecedor("Raphael", "raphael@gmail.com", "83 98737-2109");
		fornecedorController.cadastraFornecedor("Biu Gate", "biu@gmail.com", "83 98787-2109");
		assertEquals("Biu Gate - biu@gmail.com - 83 98787-2109 | Raphael - raphael@gmail.com - 83 98737-2109 | Seu Olavo - olavo@gmail.com - 83 99348-1092",fornecedorController.exibeFornecedores());
	}
	
	@Test
	public void testListarFornecedoresSemNenhumFornecedor() {
		assertEquals("",fornecedorController.exibeFornecedores());
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
			fornecedorController.exibeProduto(null, "Tapioca", "Tapioca com frango");
			fail("Deveria lancar excecao.");
		} catch (NullPointerException e) {
			assertEquals("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testExibeProdutoFornecedorVazio() {
		try {
			fornecedorController.cadastraFornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");
			fornecedorController.exibeProduto("", "Tapioca", "Tapioca com frango");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testExibeProdutoNomeNulo() {
		try {
			fornecedorController.cadastraFornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");
			fornecedorController.exibeProduto("Seu Olavo", null, "Tapioca com frango");
			fail("Deveria lancar excecao.");
		} catch (NullPointerException e) {
			assertEquals("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testExibeProdutoNomeVazio() {
		try {
			fornecedorController.cadastraFornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");
			fornecedorController.exibeProduto("Seu Olavo", "", "Tapioca com frango");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testExibeProdutoDescricaoNula() {
		try {
			fornecedorController.cadastraFornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");
			fornecedorController.exibeProduto("Seu Olavo", "Tapioca", null);
			fail("Deveria lancar excecao.");
		} catch (NullPointerException e) {
			assertEquals("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testExibeProdutoDescricaoVazia() {
		try {
			fornecedorController.cadastraFornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");
			fornecedorController.exibeProduto("Seu Olavo","Tapioca", "");
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
		fornecedorController.exibeProduto("Seu Olavo", "Tapioca", "Tapioca com frango");
		assertEquals("Tapioca - Tapioca com frango - R$10,00",fornecedorController.exibeProduto("Seu Olavo", "Tapioca", "Tapioca com frango"));
	}
	
	@Test
	public void testExibeProdutosFornecedorInexistente() {
		try {
			fornecedorController.exibeProdutosFornecedor("IRINEU");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na exibicao de produto: fornecedor nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testListarProdutosDeUmFornecedor() {
		fornecedorController.cadastraFornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");
		fornecedorController.cadastraProduto("Seu Olavo", "X-frango","Hamburguer de frango com queijo e calabresa", 5.00);
		fornecedorController.cadastraProduto("Seu Olavo", "Burguer","Hamburguer de carne com queijo e calabresa", 4.50);
		assertEquals("Seu Olavo - Burguer - Hamburguer de carne com queijo e calabresa - R$4,50 | Seu Olavo - X-frango - Hamburguer de frango com queijo e calabresa - R$5,00", fornecedorController.exibeProdutosFornecedor("Seu Olavo"));
	}
	
	@Test
	public void testListarProdutosDeTodosFornecedores() {
		fornecedorController.cadastraFornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");
		fornecedorController.cadastraProduto("Seu Olavo", "X-frango","Hamburguer de frango com queijo e calabresa", 5.00);
		fornecedorController.cadastraProduto("Seu Olavo", "X-tudo","Hamburguer de frango e carne com queijo e calabresa", 10.00);
		
		fornecedorController.cadastraFornecedor("Raphael", "raphael@gmail.com", "83 98737-2109");
		fornecedorController.cadastraProduto("Raphael", "X-burguer","Hamburguer de carne com queijo e calabresa", 4.50);
		fornecedorController.cadastraProduto("Raphael", "Cachorro Quente","Pao com salsicha e carne moida", 7.00);
		
		assertEquals("Raphael - Cachorro Quente - Pao com salsicha e carne moida - R$7,00 | Raphael - X-burguer - Hamburguer de carne com queijo e calabresa - R$4,50 | Seu Olavo - X-frango - Hamburguer de frango com queijo e calabresa - R$5,00 | Seu Olavo - X-tudo - Hamburguer de frango e carne com queijo e calabresa - R$10,00", fornecedorController.exibeProdutos());
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
			assertEquals("Tapioca - Tapioca com frango - R$10,00", fornecedorController.exibeProduto("Raphael", "Tapioca", "Tapioca com frango"));
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
			fornecedorController.exibeProduto("Raphael", "Tapioca", "Tapioca com frango");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na exibicao de produto: produto nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testAdicionaComboFornecedorNulo() {
		try {
			fornecedorController.adicionaCombo(null, "Lanche FIT", "Lanche saudavael", 0.5, "Tapioca - Tapioca com frango, Suco - Suco de maracuja");
			fail("Deveria lancar excecao.");
		} catch (NullPointerException e) {
			assertEquals("Erro no cadastro de combo: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testAdicionaComboFornecedorVazio() {
		try {
			fornecedorController.adicionaCombo("", "Lanche FIT", "Lanche saudavael", 0.5, "Tapioca - Tapioca com frango, Suco - Suco de maracuja");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de combo: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testAdicionaComboNomeNulo() {
		try {
			fornecedorController.adicionaCombo("Josenilda", null, "Lanche saudavael", 0.5, "Tapioca - Tapioca com frango, Suco - Suco de maracuja");
			fail("Deveria lancar excecao.");
		} catch (NullPointerException e) {
			assertEquals("Erro no cadastro de combo: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testAdicionaComboNomeVazio() {
		try {
			fornecedorController.adicionaCombo("Josenilda", "", "Lanche saudavael", 0.5, "Tapioca - Tapioca com frango, Suco - Suco de maracuja");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de combo: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testAdicionaComboDescricaoNula() {
		try {
			fornecedorController.adicionaCombo("Josenilda", "Lanche FIT", null, 0.5, "Tapioca - Tapioca com frango, Suco - Suco de maracuja");
			fail("Deveria lancar excecao.");
		} catch (NullPointerException e) {
			assertEquals("Erro no cadastro de combo: descricao nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testAdicionaComboDescricaoVazia() {
		try {
			fornecedorController.adicionaCombo("Josenilda", "Lanche FIT", "", 0.5, "Tapioca - Tapioca com frango, Suco - Suco de maracuja");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de combo: descricao nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testAdicionaComboProdutosNulo() {
		try {
			fornecedorController.adicionaCombo("Josenilda", "Lanche FIT", "Lanche saudavael", 0.5, null);
			fail("Deveria lancar excecao.");
		} catch (NullPointerException e) {
			assertEquals("Erro no cadastro de combo: combo deve ter produtos.", e.getMessage());
		}
	}
	
	@Test
	public void testAdicionaComboProdutoVazio() {
		try {
			fornecedorController.adicionaCombo("Josenilda", "Lanche FIT", "Lanche saudavael", 0.5, "");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de combo: combo deve ter produtos.", e.getMessage());
		}
	}
	
	@Test
	public void testAdicionaComboFatorInvalido() {
		try {
			fornecedorController.adicionaCombo("Josenilda", "Lanche FIT", "Lanche saudavael", 1, "Tapioca - Tapioca com frango, Suco - Suco de maracuja");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de combo: fator invalido.", e.getMessage());
		}
		
		try {
			fornecedorController.adicionaCombo("Josenilda", "Lanche FIT", "Lanche saudavael", -1, "Tapioca - Tapioca com frango, Suco - Suco de maracuja");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de combo: fator invalido.", e.getMessage());
		}
	}
	
	@Test
	public void testAdicionaComboFornecedorInexistente() {
		try {
			fornecedorController.adicionaCombo("IRINEU", "Lanche FIT", "Lanche saudavael", 0.5, "Tapioca - Tapioca com frango, Suco - Suco de maracuja");
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de combo: fornecedor nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testEditaComboNomeNulo() {
		try {
			fornecedorController.editaCombo(null, "Lanche saudavel", "Josenilda", 0.20);
			fail("Deveria lancar excecao.");
		} catch (NullPointerException e) {
			assertEquals("Erro na edicao de combo: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testEditaComboNomeVazio() {
		try {
			fornecedorController.editaCombo("", "Lanche saudavel", "Josenilda", 0.20);
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao de combo: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testEditaComboDescricaoNula() {
		try {
			fornecedorController.editaCombo("Lanche FIT", null, "Josenilda", 0.20);
			fail("Deveria lancar excecao.");
		} catch (NullPointerException e) {
			assertEquals("Erro na edicao de combo: descricao nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testEditaComboDescricaoVazia() {
		try {
			fornecedorController.editaCombo("Lanche FIT", "", "Josenilda", 0.20);
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao de combo: descricao nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testEditaComboFornecedorNulo() {
		try {
			fornecedorController.editaCombo("Lanche FIT", "Lanche saudavel", null, 0.20);
			fail("Deveria lancar excecao.");
		} catch (NullPointerException e) {
			assertEquals("Erro na edicao de combo: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testEditaComboFornecedorVazio() {
		try {
			fornecedorController.editaCombo("Lanche FIT", "Lanche saudavel", "", 0.20);
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao de combo: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testEditaComboFatorInvalido() {
		try {
			fornecedorController.editaCombo("Lanche FIT", "Lanche saudavel", "Josenilda", 1.5);
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao de combo: fator invalido.", e.getMessage());
		}
		
		try {
			fornecedorController.editaCombo("Lanche FIT", "Lanche saudavel", "Josenilda", -1);
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao de combo: fator invalido.", e.getMessage());
		}
	}
	
	@Test
	public void testEditaComboFornecedorInexistente() {
		try {
			fornecedorController.editaCombo("Lanche FIT", "Lanche saudavel", "IRINEU", 0.20);
			fail("Deveria lancar excecao.");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao de combo: fornecedor nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testEditaComboFeliz() {
		fornecedorController.cadastraFornecedor("Josenilda", "josenilda@gmail.com", "83 99988-0077");
		fornecedorController.cadastraProduto("Josenilda", "Tapioca", "Tapioca com frango", 5.00);
		fornecedorController.cadastraProduto("Josenilda", "Suco", "Suco de maracuja", 3.00);
		fornecedorController.adicionaCombo("Josenilda", "Lanche FIT", "Lanche saudavel", 0.2, "Tapioca - Tapioca com frango, Suco - Suco de maracuja");
		fornecedorController.editaCombo("Lanche FIT", "Lanche saudavel", "Josenilda", 0.5);
		assertEquals(4.0, fornecedorController.getPrecoProdutoFornecedor("Josenilda", "Lanche FIT", "Lanche saudavel"), 0.01);
	}
	
	@Test
	public void testExisteFornecedor() {
		assertFalse(fornecedorController.existeFornecedor("IRINEU"));
	}
	
	@Test
	public void testExisteProdutoFornecedor( ){
		fornecedorController.cadastraFornecedor("Josenilda", "josenilda@gmail.com", "83 99988-0077");
		fornecedorController.cadastraProduto("Josenilda", "Tapioca", "Tapioca com frango", 5.00);
		assertTrue(fornecedorController.existeProdutoFornecedor("Josenilda", "Tapioca", "Tapioca com frango"));
	}
	
	@Test
	public void testGetPrecoProdutoFornecedor() {
		fornecedorController.cadastraFornecedor("Josenilda", "josenilda@gmail.com", "83 99988-0077");
		fornecedorController.cadastraProduto("Josenilda", "Tapioca", "Tapioca com frango", 5.00);
		assertEquals(5.0, fornecedorController.getPrecoProdutoFornecedor("Josenilda", "Tapioca", "Tapioca com frango"), 0.01);
	}
}
