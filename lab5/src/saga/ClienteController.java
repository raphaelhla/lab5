package saga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Representacao de um controller de clientes.
 * 
 * @author Raphael Agra - 119110413
 *
 */
public class ClienteController {

	/**
	 * Mapa com todos os clientes do sistema, identificados unicamente por seu cpf.
	 * 
	 */
	private Map<String, Cliente> clientes;
	private FornecedorController fornecedorController;

	/**
	 * Constroi um controller de clientes e se relaciona com um controller de
	 * fornecedor.
	 * 
	 * @param fornecedorController Controller de fornecedor.
	 */
	public ClienteController(FornecedorController fornecedorController) {
		this.clientes = new HashMap<String, Cliente>();
		this.fornecedorController = fornecedorController;
	}

	/**
	 * Metodo que cadastra um cliente no sistema a partir de seu nome, cpf, email e
	 * localizacao e retorna seu cpf caso o cadastro seja bem sucedido.
	 * 
	 * @param nome        Nome do cliente.
	 * @param cpf         Cpf do cliente.
	 * @param email       Email do cliente
	 * @param localizacao Localizacao do cliente.
	 * @return o cpf do cliente caso o cadastro tenha sido bem sucedido.
	 */
	public String cadastraCliente(String nome, String cpf, String email, String localizacao) {
		Validador.validaEntrada(nome, "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		Validador.validaEntrada(cpf, "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		Validador.validaEntrada(email, "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		Validador.validaEntrada(localizacao, "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
		}
		if (!this.clientes.containsKey(cpf)) {
			this.clientes.put(cpf, new Cliente(nome, cpf, email, localizacao));
			return cpf;
		} else {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
		}
	}

	/**
	 * Metodo que exibe a representacao em string de um cliente a partir de seu cpf.
	 * 
	 * @param cpf Cpf do cliente.
	 * @return a representacao em string do cliente.
	 */
	public String exibeCliente(String cpf) {
		Validador.validaEntrada(cpf, "Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.");
		if (!clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
		}
		return clientes.get(cpf).toString();
	}

	/**
	 * Metodo que retorna a representacao em string da lista de todos os clientes
	 * cadastrados no sistema.
	 * 
	 * @return a representacao em string da lista de todos os clientes cadastrados
	 *         no sistema
	 */
	public String exibeClientes() {
		String msg = "";
		List<Cliente> listaClientes = new ArrayList<>(clientes.values());
		Collections.sort(listaClientes);
		List<String> nomes = new ArrayList<>();
		for (Cliente cliente : listaClientes)
			nomes.add(cliente.toString());

		msg = String.join(" | ", nomes);
		return msg;
	}

	/**
	 * Metodo que edita um cliente a partir de seu cpf, atributo que vai ser editado
	 * e um novo valor para o atributo.
	 * 
	 * @param cpf       Cpf do cliente.
	 * @param atributo  Atributo do cliente que vai ser editado.
	 * @param novoValor Novo valor que vai ser atribuido ao atributo passado como
	 *                  parametro.
	 */
	public void editaCliente(String cpf, String atributo, String novoValor) {
		Validador.validaEntrada(cpf, "Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");
		Validador.validaEntrada(atributo, "Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		Validador.validaEntrada(novoValor, "Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		if (!clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
		}
		if (atributo.equals("nome")) {
			clientes.get(cpf).setNome(novoValor);
		} else if (atributo.equals("email")) {
			clientes.get(cpf).setEmail(novoValor);
		} else if (atributo.equals("localizacao")) {
			clientes.get(cpf).setLocalizacao(novoValor);
		} else if (atributo.equals("cpf")) {
			throw new IllegalArgumentException("Erro na edicao do cliente: cpf nao pode ser editado.");
		} else {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
		}
	}

	/**
	 * Metodo que remove um cliente do sistema a partir de seu cpf.
	 * 
	 * @param cpf Cpf do cliente.
	 */
	public void removeCliente(String cpf) {
		Validador.validaEntrada(cpf, "Erro na remocao do cliente: cpf nao pode ser vazio ou nulo");
		if (!clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro na remocao do cliente: cliente nao existe.");
		}
		this.clientes.remove(cpf);
	}

	/**
	 * Metodo que adiciona uma compra de um produto de um fornecedor na conta de um
	 * cliente com o fornecedor, a partir do cpf do cliente, do nome do fornecedor,
	 * da data da compra, do nome do produto e da descricao do produto. Se o cliente
	 * nao tiver nenhuma conta com o fornecedor, uma nova conta deve ser criada.
	 * 
	 * @param cpf        Cpf do cliente.
	 * @param fornecedor Nome do fornecedor.
	 * @param data       Data da compra.
	 * @param nome       Nome do produto.
	 * @param descricao  Descricao do produto.
	 */
	public void adicionaCompra(String cpf, String fornecedor, String data, String nome, String descricao) {
		Validador.validaEntrada(fornecedor, "Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
		Validador.validaEntrada(cpf, "Erro ao cadastrar compra: cpf nao pode ser vazio ou nulo.");
		Validador.validaEntrada(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
		Validador.validaEntrada(nome, "Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
		Validador.validaEntrada(descricao,
				"Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");
		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: cpf invalido.");
		}
		if (data.length() != 10) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: data invalida.");
		}
		if (!clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: cliente nao existe.");
		}
		if (!fornecedorController.existeFornecedor(fornecedor)) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao existe.");
		}
		if (!fornecedorController.existeProdutoFornecedor(fornecedor, nome, descricao)) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: produto nao existe.");
		}
		double preco = fornecedorController.getPrecoProdutoFornecedor(fornecedor, nome, descricao);
		this.clientes.get(cpf).adicionaCompra(fornecedor, data, nome, descricao, preco);
	}

	/**
	 * Metodo que retorna a representacao em string da conta de um cliente com um
	 * fornecedor, a partir do cpf do cliente e do nome do fornecedor.
	 * 
	 * @param cpf        Cpf do cliente.
	 * @param fornecedor Nome do fornecedor.
	 * @return a string que representa a conta de um cliente com um fornecedor.
	 */
	public String exibeContas(String cpf, String fornecedor) {
		Validador.validaEntrada(fornecedor, "Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.");
		Validador.validaEntrada(cpf, "Erro ao exibir conta do cliente: cpf nao pode ser vazio ou nulo.");
		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cpf invalido.");
		}
		if (!fornecedorController.existeFornecedor(fornecedor)) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: fornecedor nao existe.");
		}
		if (!clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cliente nao existe.");
		}
		return this.clientes.get(cpf).exibeContas(fornecedor);
	}

	/**
	 * Metodo que retorna a representacao em string de todas as contas de todos os
	 * fornecedores com qual um cliente possui conta, a partir do cpf do cliente.
	 * 
	 * @param cpf Cpf do cliente.
	 * @return a string que representa todas as contas de todos os fornecedores que
	 *         um determinado cliente cliente possui conta.
	 */
	public String exibeContasClientes(String cpf) {
		Validador.validaEntrada(cpf, "Erro ao exibir contas do cliente: cpf nao pode ser vazio ou nulo.");
		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cpf invalido.");
		}
		if (!clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao existe.");
		}
		return this.clientes.get(cpf).exibeContasClientes();
	}

	/**
	 * Metodo que retorna a string que representa o valor do debito que um cliente
	 * tem com um fornecedor, a partir do cpf do cliente e do nome do fornecedor.
	 * 
	 * @param cpf        Cpf do cliente.
	 * @param fornecedor Nome do fornecedor.
	 * @return a representacao em string do debito de um cliente com um fornecedor.
	 */
	public String getDebito(String cpf, String fornecedor) {
		Validador.validaEntrada(cpf, "Erro ao recuperar debito: cpf nao pode ser vazio ou nulo.");
		Validador.validaEntrada(fornecedor, "Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.");
		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao recuperar debito: cpf invalido.");
		}
		if (!fornecedorController.existeFornecedor(fornecedor)) {
			throw new IllegalArgumentException("Erro ao recuperar debito: fornecedor nao existe.");
		}
		if (!clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao existe.");
		}

		return this.clientes.get(cpf).getDebito(fornecedor);
	}
}