package saga;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteControllerTest {

	private ClienteController clienteController;
	private FornecedorController fornecedorController;

	@BeforeEach
	public void criaController() {
		fornecedorController = new FornecedorController();
		clienteController = new ClienteController(fornecedorController);
	}

	@Test
	public void testCadastraClienteValido() {
		assertEquals("12345678900", clienteController.cadastraCliente("Raphael Agra", "12345678900",
				"raphael.agra@ccc.ufcg.edu.br", "CAA"));
	}

	@Test
	public void testCadastraClienteNomeNulo() {
		try {
			clienteController.cadastraCliente(null, "12345678900", "raphael.agra@ccc.ufcg.edu.br", "CAA");
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}

	@Test
	public void testCadastraClienteNomeVazio() {
		try {
			clienteController.cadastraCliente("", "12345678900", "raphael.agra@ccc.ufcg.edu.br", "CAA");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}

	@Test
	public void testCadastraClienteCpfNulo() {
		try {
			clienteController.cadastraCliente("Raphael Agra", null, "raphael.agra@ccc.ufcg.edu.br", "CAA");
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.", e.getMessage());
		}
	}

	@Test
	public void testCadastraClienteCpfVazio() {
		try {
			clienteController.cadastraCliente("Raphael Agra", "", "raphael.agra@ccc.ufcg.edu.br", "CAA");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.", e.getMessage());
		}
	}

	@Test
	public void testCadastraClienteCpfInvalido() {
		try {
			clienteController.cadastraCliente("Raphael Agra", "1234", "raphael.agra@ccc.ufcg.edu.br", "CAA");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do cliente: cpf invalido.", e.getMessage());
		}
	}

	@Test
	public void testCadastraClienteEmailNulo() {
		try {
			clienteController.cadastraCliente("Raphael Agra", "12345678900", null, "CAA");
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.", e.getMessage());
		}
	}

	@Test
	public void testCadastraClienteEmailVazio() {
		try {
			clienteController.cadastraCliente("Raphael Agra", "12345678900", "", "CAA");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.", e.getMessage());
		}
	}

	@Test
	public void testCadastraClienteLocalizacaoNula() {
		try {
			clienteController.cadastraCliente("Raphael Agra", "12345678900", "raphael.agra@ccc.ufcg.edu.br", null);
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.", e.getMessage());
		}
	}

	@Test
	public void testCadastraClienteLocalizacaoVazia() {
		try {
			clienteController.cadastraCliente("Raphael Agra", "12345678900", "raphael.agra@ccc.ufcg.edu.br", "");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.", e.getMessage());
		}
	}

	@Test
	public void testCadastraClienteExistente() {
		try {
			clienteController.cadastraCliente("Raphael Agra", "12345678900", "raphael.agra@ccc.ufcg.edu.br", "CAA");
			clienteController.cadastraCliente("Raphael Agra", "12345678900", "raphael.agra@ccc.ufcg.edu.br", "CAA");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do cliente: cliente ja existe.", e.getMessage());
		}
	}

	@Test
	public void testExibeClienteCpfNulo() {
		try {
			clienteController.cadastraCliente("Raphael Agra", "12345678900", "raphael.agra@ccc.ufcg.edu.br", "CAA");
			clienteController.exibeCliente(null);
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.", e.getMessage());
		}
	}

	@Test
	public void testExibeClienteCpfVazio() {
		try {
			clienteController.exibeCliente("");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.", e.getMessage());
		}
	}

	@Test
	public void testExibeClienteInexistente() {
		try {
			clienteController.exibeCliente("99999999900");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na exibicao do cliente: cliente nao existe.", e.getMessage());
		}
	}

	@Test
	public void testExibeClienteValido() {
		clienteController.cadastraCliente("Raphael Agra", "12345678900", "raphael.agra@ccc.ufcg.edu.br", "CAA");
		assertEquals("Raphael Agra - CAA - raphael.agra@ccc.ufcg.edu.br",
				clienteController.exibeCliente("12345678900"));
	}

	@Test
	public void testListarClientes() {
		HashSet<String> listaClientes = new HashSet<String>();
		HashSet<String> listaClientes2 = new HashSet<String>();
		
		clienteController.cadastraCliente("Raphael Agra", "12345678900","raphael.agra@ccc.ufcg.edu.br", "CAA");
		clienteController.cadastraCliente("Ana Amari", "11111111100","ana_amari@ccc.ufcg.edu.br", "SPG");
		listaClientes.add(clienteController.exibeCliente("12345678900"));
		listaClientes.add(clienteController.exibeCliente("11111111100"));
		
		String[] x = clienteController.exibeClientes().split(" \\| ");
		for (int i = 0; i < x.length; i++) {
			listaClientes2.add(x[i]);
		}
		assertEquals(listaClientes,listaClientes2);
	}
	
	@Test
	public void testListarClientesSemNenhumCliente() {
		assertEquals("",clienteController.exibeClientes());
	}

	@Test
	public void editaClienteCpfNulo() {
		try {
			clienteController.cadastraCliente("Raphael Agra", "12345678900", "raphael.agra@ccc.ufcg.edu.br", "CAA");
			clienteController.editaCliente(null, "nome", "Junio");
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.", e.getMessage());
		}
	}

	@Test
	public void editaClienteCpfVazio() {
		try {
			clienteController.cadastraCliente("Raphael Agra", "12345678900", "raphael.agra@ccc.ufcg.edu.br", "CAA");
			clienteController.editaCliente("", "nome", "Junior");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.", e.getMessage());
		}
	}

	@Test
	public void editaClienteAtributoNulo() {
		try {
			clienteController.cadastraCliente("Raphael Agra", "12345678900", "raphael.agra@ccc.ufcg.edu.br", "CAA");
			clienteController.editaCliente("12345678900", null, "Junior");
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.", e.getMessage());
		}
	}

	@Test
	public void editaClienteAtributoVazio() {
		try {
			clienteController.cadastraCliente("Raphael Agra", "12345678900", "raphael.agra@ccc.ufcg.edu.br", "CAA");
			clienteController.editaCliente("12345678900", "", "Junior");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.", e.getMessage());
		}
	}

	@Test
	public void testEditaClienteNovoValorNulo() {
		try {
			clienteController.cadastraCliente("Raphael Agra", "12345678900", "raphael.agra@ccc.ufcg.edu.br", "CAA");
			clienteController.editaCliente("12345678900", "nome", null);
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.", e.getMessage());
		}
	}

	@Test
	public void testEditaClienteNovoValorVazio() {
		try {
			clienteController.cadastraCliente("Raphael Agra", "12345678900", "raphael.agra@ccc.ufcg.edu.br", "CAA");
			clienteController.editaCliente("12345678900", "nome", "");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.", e.getMessage());
		}
	}

	@Test
	public void testEditaClienteInexistente() {
		try {
			clienteController.cadastraCliente("Raphael Agra", "12345678900", "raphael.agra@ccc.ufcg.edu.br", "CAA");
			clienteController.editaCliente("99999999999", "nome", "Junior");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao do cliente: cliente nao existe.", e.getMessage());
		}
	}

	@Test
	public void testEditaClienteNomeValido() {
		clienteController.cadastraCliente("Raphael Agra", "12345678900", "raphael.agra@ccc.ufcg.edu.br", "CAA");
		clienteController.editaCliente("12345678900", "nome", "Junior");
		assertEquals("Junior - CAA - raphael.agra@ccc.ufcg.edu.br", clienteController.exibeCliente("12345678900"));
	}

	@Test
	public void testEditaClienteEmailValido() {
		clienteController.cadastraCliente("Raphael Agra", "12345678900", "raphael.agra@ccc.ufcg.edu.br", "CAA");
		clienteController.editaCliente("12345678900", "email", "raphael@gmail.com");
		assertEquals("Raphael Agra - CAA - raphael@gmail.com", clienteController.exibeCliente("12345678900"));
	}

	@Test
	public void testEditaClienteLocalizacaoValida() {
		clienteController.cadastraCliente("Raphael Agra", "12345678900", "raphael.agra@ccc.ufcg.edu.br", "CAA");
		clienteController.editaCliente("12345678900", "localizacao", "BG");
		assertEquals("Raphael Agra - BG - raphael.agra@ccc.ufcg.edu.br", clienteController.exibeCliente("12345678900"));
	}

	@Test
	public void testEditaClienteCpf() {
		try {
			clienteController.cadastraCliente("Raphael Agra", "12345678900", "raphael.agra@ccc.ufcg.edu.br", "CAA");
			clienteController.editaCliente("12345678900", "cpf", "00000000000");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao do cliente: cpf nao pode ser editado.", e.getMessage());
		}
	}

	@Test
	public void testEditaClienteAtributoInexistente() {
		try {
			clienteController.cadastraCliente("Raphael Agra", "12345678900", "raphael.agra@ccc.ufcg.edu.br", "CAA");
			clienteController.editaCliente("12345678900", "xxxx", "XXXXXXXXXX");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na edicao do cliente: atributo nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testRemoveClienteCpfNulo() {
		try {
			clienteController.cadastraCliente("Raphael Agra", "12345678900", "raphael.agra@ccc.ufcg.edu.br", "CAA");
			clienteController.removeCliente(null);
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro na remocao do cliente: cpf nao pode ser vazio ou nulo", e.getMessage());
		}
	}
	
	@Test
	public void testRemoveClienteCpfVazio() {
		try {
			clienteController.cadastraCliente("Raphael Agra", "12345678900", "raphael.agra@ccc.ufcg.edu.br", "CAA");
			clienteController.removeCliente("");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na remocao do cliente: cpf nao pode ser vazio ou nulo", e.getMessage());
		}
	}
	
	@Test
	public void testRemoveClienteInexistente() {
		try {
			clienteController.cadastraCliente("Raphael Agra", "12345678900", "raphael.agra@ccc.ufcg.edu.br", "CAA");
			clienteController.removeCliente("00000000000");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na remocao do cliente: cliente nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testRemoveClienteValido() {
		try {
			clienteController.cadastraCliente("Raphael Agra", "12345678900", "raphael.agra@ccc.ufcg.edu.br", "CAA");
			clienteController.removeCliente("12345678900");
			clienteController.exibeCliente("12345678900");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro na exibicao do cliente: cliente nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testAdicionaCompraFornecedorNulo() {
		try {
			clienteController.adicionaCompra("12345678900", null, "12/10/2019", "Tapioca", "Tapioca com frango");
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testAdicionaCompraFornecedorVazio() {
		try {
			clienteController.adicionaCompra("12345678900", "", "12/10/2019", "Tapioca", "Tapioca com frango");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testAdicionaCompraCpfNulo() {
		try {
			clienteController.adicionaCompra(null, "Josenilda", "12/10/2019", "Tapioca", "Tapioca com frango");
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro ao cadastrar compra: cpf nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testAdicionaCompraCpfVazio() {
		try {
			clienteController.adicionaCompra("", "Josenilda", "12/10/2019", "Tapioca", "Tapioca com frango");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao cadastrar compra: cpf nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testAdicionaCompraNomeNulo() {
		try {
			clienteController.adicionaCompra("12345678900", "Josenilda", "12/10/2019", null, "Tapioca com frango");
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testAdicionaCompraNomeVazio() {
		try {
			clienteController.adicionaCompra("12345678900", "Josenilda", "12/10/2019", "", "Tapioca com frango");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testAdicionaCompraDescricaoNula() {
		try {
			clienteController.adicionaCompra("12345678900", "Josenilda", "12/10/2019", "Tapioca", null);
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testAdicionaCompraDescricaoVazia() {
		try {
			clienteController.adicionaCompra("12345678900", "Josenilda", "12/10/2019", "Tapioca", "");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testAdicionaCompraDataNula() {
		try {
			clienteController.adicionaCompra("12345678900", "Josenilda", null, "Tapioca", "Tapioca com frango");
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro ao cadastrar compra: data nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testAdicionaCompraDataVazia() {
		try {
			clienteController.adicionaCompra("12345678900", "Josenilda", "", "Tapioca", "Tapioca com frango");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao cadastrar compra: data nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	public void testAdicionaCompraCpfInvalido() {
		try {
			clienteController.adicionaCompra("1234567822900", "Josenilda", "10/12/2019", "Tapioca", "Tapioca com frango");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao cadastrar compra: cpf invalido.", e.getMessage());
		}
	}
	
	@Test
	public void testAdicionaCompraDataInvalida() {
		try {
			clienteController.adicionaCompra("12345678900", "Josenilda", "1000/12/2019", "Tapioca", "Tapioca com frango");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao cadastrar compra: data invalida.", e.getMessage());
		}
	}
	
	@Test
	public void testAdicionaCompraClienteInexistente() {
		try {
			clienteController.adicionaCompra("00000000000", "Josenilda", "10/12/2019", "Tapioca", "Tapioca com frango");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao cadastrar compra: cliente nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testAdicionaCompraFornecedorInexistente() {
		try {
			clienteController.cadastraCliente("Raphael Agra", "10290935474", "raphael.agra@gmail.com", "LCC3");
			clienteController.adicionaCompra("10290935474", "Irineu", "10/12/2019", "Tapioca", "Tapioca com frango");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao cadastrar compra: fornecedor nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testAdicionaComprapProdutoInexistente() {
		try {
			clienteController.cadastraCliente("Raphael Agra", "10290935474", "raphael.agra@gmail.com", "LCC3");
			fornecedorController.cadastraFornecedor("Josenilda", "josenilda@example.com", "83 93322-1199");
			clienteController.adicionaCompra("10290935474", "Josenilda", "10/12/2019", "Tapioca", "Tapioca com frango");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao cadastrar compra: produto nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testExibeContasCpfNulo() {
		try {
			clienteController.exibeContas(null, "Josenilda");
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro ao exibir conta do cliente: cpf nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testExibeContasCpfVazio() {
		try {
			clienteController.exibeContas("", "Josenilda");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao exibir conta do cliente: cpf nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testExibeContasFornecedorVazio() {
		try {
			clienteController.exibeContas("12345678900", "");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testExibeContasFornecedorNulo() {
		try {
			clienteController.exibeContas("12345678900", null);
			fail("Deveria lancar excecao");
		} catch (NullPointerException e) {
			assertEquals("Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	public void testExibeContasCpfInvalido() {
		try {
			clienteController.exibeContas("1234567890000", "Josenilda");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao exibir conta do cliente: cpf invalido.", e.getMessage());
		}
	}
	
	@Test
	public void testExibeContasFornecedorInexistente() {
		try {
			clienteController.cadastraCliente("Raphael Agra", "10290935474", "raphael.agra@gmail.com", "LCC3");
			fornecedorController.cadastraFornecedor("Josenilda", "josenilda@example.com", "83 93322-1199");
			clienteController.exibeContas("10290935474", "Irineu");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao exibir conta do cliente: fornecedor nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testExibeContasClienteInexistente() {
		try {
			fornecedorController.cadastraFornecedor("Josenilda", "josenilda@example.com", "83 93322-1199");
			clienteController.exibeContas("10290935474", "Josenilda");
			fail("Deveria lancar excecao");
		} catch (IllegalArgumentException e) {
			assertEquals("Erro ao exibir conta do cliente: cliente nao existe.", e.getMessage());
		}
	}
	
	@Test
	public void testExibeContasFeliz() {
		clienteController.cadastraCliente("Raphael Agra", "10290935474", "raphael.agra@gmail.com", "LCC3");
		fornecedorController.cadastraFornecedor("Josenilda", "josenilda@example.com", "83 93322-1199");
		fornecedorController.cadastraProduto("Josenilda", "Tapioca", "Tapioca com frango", 5.00);
		fornecedorController.cadastraProduto("Josenilda", "Suco", "Suco de maracuja", 3.00);
		clienteController.adicionaCompra("10290935474", "Josenilda", "12/10/2019", "Tapioca", "Tapioca com frango");
		clienteController.adicionaCompra("10290935474", "Josenilda", "15/10/2019", "Suco", "Suco de maracuja");
		assertEquals("Cliente: Raphael Agra | Josenilda | Tapioca - 12-10-2019 | Suco - 15-10-2019", clienteController.exibeContas("10290935474", "Josenilda"));
	}
	
	@Test
	public void testExibeContasClientesFeliz() {
		clienteController.cadastraCliente("Raphael Agra", "10290935474", "raphael.agra@gmail.com", "LCC3");
		fornecedorController.cadastraFornecedor("Josenilda", "josenilda@example.com", "83 93322-1199");
		fornecedorController.cadastraProduto("Josenilda", "Tapioca", "Tapioca com frango", 5.00);
		fornecedorController.cadastraProduto("Josenilda", "Suco", "Suco de maracuja", 3.00);
		clienteController.adicionaCompra("10290935474", "Josenilda", "12/10/2019", "Tapioca", "Tapioca com frango");
		clienteController.adicionaCompra("10290935474", "Josenilda", "15/10/2019", "Suco", "Suco de maracuja");
		fornecedorController.cadastraFornecedor("Diniz", "diniz@example.com", "83 98822-1199");
		fornecedorController.cadastraProduto("Diniz", "Bolo", "Bolo de chocolate", 5.00);
		clienteController.adicionaCompra("10290935474", "Diniz", "01/10/2019", "Bolo", "Bolo de chocolate");
		assertEquals("Cliente: Raphael Agra | Diniz | Bolo - 01-10-2019 | Josenilda | Tapioca - 12-10-2019 | Suco - 15-10-2019", clienteController.exibeContasClientes("10290935474"));
	}
}
