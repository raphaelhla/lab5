package saga;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Representacao de um controller de clientes.
 * 
 * @author Raphael Agra
 *
 */
public class ClienteController {

	/**
	 * Mapa com todos os clientes do sistema, identificados unicamente por seu cpf.
	 * 
	 */
	private Map<String, Cliente> clientes;

	/**
	 * Controi um controller de clientes.
	 */
	public ClienteController() {
		this.clientes = new HashMap<String, Cliente>();
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
		for(Cliente cliente: listaClientes)
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
	
	public Cliente pegaCliente(String cpf) {
		return this.clientes.get(cpf);
	}

	public void adicionaCompra(String cpf, Fornecedor fornecedor, String data, String nome, String descricao) {
//		Validador.validaEntrada(fornecedor, "Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
		Validador.validaEntrada(cpf, "Erro ao cadastrar compra: cpf nao pode ser vazio ou nulo.");
		Validador.validaEntrada(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
		Validador.validaEntrada(nome, "Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
		Validador.validaEntrada(descricao, "Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");
		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: cpf invalido.");
		}
		if (!clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: cliente nao existe.");
		}
		if (data.length() != 10) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: data invalida.");
		}
		
		this.clientes.get(cpf).adicionaCompra(fornecedor, data, nome, descricao);
	}
	
	public String exibeContas(String cpf, String fornecedor) {
		Validador.validaEntrada(fornecedor, "Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.");
		Validador.validaEntrada(cpf, "Erro ao exibir conta do cliente: cpf nao pode ser vazio ou nulo.");
		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cpf invalido.");
		}
		if (!clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cliente nao existe.");
		}
		return this.clientes.get(cpf).exibeContas(fornecedor);
	}

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

	public String getDebito(String cpf, String fornecedor) {
		Validador.validaEntrada(cpf, "Erro ao recuperar debito: cpf nao pode ser vazio ou nulo.");
		Validador.validaEntrada(fornecedor, "Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.");
		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao recuperar debito: cpf invalido.");
		}
		if (!clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao existe.");
		}
		
		return this.clientes.get(cpf).getDebito(fornecedor);
	}
}
