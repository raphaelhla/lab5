package saga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Representacao de um cliente. Todo cliente precisa ter um nome, cpf, email e
 * localizacao.
 * 
 * @author Raphael Agra - 119110413
 *
 */
public class Cliente implements Comparable<Cliente> {

	/**
	 * Nome do cliente.
	 */
	private String nome;

	/**
	 * Cpf do cliente.
	 */
	private String cpf;

	/**
	 * Email do cliente.
	 */
	private String email;

	/**
	 * Localizacao do cliente.
	 */
	private String localizacao;

	/**
	 * Mapa com todas as contas do cliente com determinados fornecedores,
	 * identificadas unicamente pelo nome do fornecedor.
	 */
	private Map<String, Conta> contas;

	/**
	 * Constroi um cliente a partir de seu nome, cpf, email e localizacao.
	 * 
	 * @param nome        Nome do cliente.
	 * @param cpf         Cpf do cliente.
	 * @param email       Email do cliente.
	 * @param localizacao Localizacao do cliente.
	 */
	public Cliente(String nome, String cpf, String email, String localizacao) {
		Validador.validaEntrada(nome, "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		Validador.validaEntrada(cpf, "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		Validador.validaEntrada(email, "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		Validador.validaEntrada(localizacao, "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
		}
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.localizacao = localizacao;
		this.contas = new HashMap<String, Conta>();
	}

	/**
	 * Retorna um inteiro que representa um cliente.
	 * 
	 * @return um inteiro que representa um cliente.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cpf.hashCode();
		return result;
	}

	/**
	 * Metodo que verifica a se dois clientes sao iguais. Retorna um valor booleano
	 * verdade caso sejam iguais, caso contrario retorna falso. Para dois clientes
	 * serem iguais eles devem possuir o mesmo cpf.
	 * 
	 * @return Retorna um valor booleano verdade caso os clientes sejam iguais, caso
	 *         contrario retorna falso.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	/**
	 * Retorna a representacao em string de um cliente. A representacao segue o
	 * formato: "NOME - LOCALIZACAO - EMAIL".
	 * 
	 * @return a representacao em string de um cliente.
	 */
	@Override
	public String toString() {
		return this.nome + " - " + this.localizacao + " - " + this.email;
	}

	/**
	 * Metodo que retorna a string que representa o nome do cliente.
	 * 
	 * @return a string que representa o nome do cliente.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Metodo que altera o nome do cliente a partir de um novo nome passado como
	 * parametro
	 * 
	 * @param nome Nome novo que o cliente ira receber.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Metodo que retorna a string que representa o email do cliente.
	 * 
	 * @return a string que representa o email do cliente.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Metodo que altera o email do cliente a partir de um novo email passado como
	 * parametro
	 * 
	 * @param email Email novo que o cliente ira receber.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Metodo que retorna a string que representa a localizacao do cliente.
	 * 
	 * @return a string que representa a localizacao do cliente.
	 */
	public String getLocalizacao() {
		return localizacao;
	}

	/**
	 * Metodo que altera a localizacao do cliente a partir de uma nova localizacao
	 * passada como parametro
	 * 
	 * @param localizacao Localizacao nova que o cliente ira receber.
	 */
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	/**
	 * Metodo que retorna a string que representa o cpf do cliente.
	 * 
	 * @return a string que representa o cpf do cliente.
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * Metodo da interface comparable que é utilizado na ordenacao de clientes e
	 * utiliza o nome do cliente para ordenacao em ordem alfabetica.
	 * 
	 * @param um cliente que vai ser comparado com o cliente atual.
	 */
	public int compareTo(Cliente o) {
		return this.getNome().compareTo(o.getNome());
	}

	/**
	 * Metodo que adiciona uma compra de um produto de um fornecedor na conta de um
	 * cliente com o fornecedor, a partir do nome do fornecedor, da data da compra,
	 * do nome do produto, da descricao do produto e do preco do produto. Se o
	 * cliente nao tiver nenhuma conta com o fornecedor, uma nova conta deve ser
	 * criada.
	 * 
	 * @param fornecedor Nome do fornecedor.
	 * @param data       Data da compra.
	 * @param nome       Nome do produto.
	 * @param descricao  Descricao do produto.
	 * @param preco      Preco do produto.
	 */
	public void adicionaCompra(String fornecedor, String data, String nome, String descricao, double preco) {
		Validador.validaEntrada(fornecedor, "Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
		Validador.validaEntrada(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
		Validador.validaEntrada(nome, "Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
		Validador.validaEntrada(descricao,
				"Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");
		if (data.length() != 10) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: data invalida.");
		}
		if (!contas.containsKey(fornecedor)) {
			contas.put(fornecedor, new Conta(fornecedor));
		}
		contas.get(fornecedor).adicionaCompra(nome, data, preco);
	}

	/**
	 * Metodo que retorna a representacao em string da conta do cliente com um
	 * fornecedor, a partir do nome do fornecedor.
	 * 
	 * @param fornecedor Nome do fornecedor.
	 * @return a string que representa a conta do cliente com um determinado
	 *         fornecedor.
	 */
	public String exibeContas(String fornecedor) {
		Validador.validaEntrada(fornecedor, "Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.");
		if (!contas.containsKey(fornecedor)) {
			throw new IllegalArgumentException(
					"Erro ao exibir conta do cliente: cliente nao tem nenhuma conta com o fornecedor.");
		}
		String msg = "Cliente: " + this.nome + " | ";
		msg += contas.get(fornecedor).toString();
		return msg;
	}

	/**
	 * Metodo que retorna a representacao em string de todas as contas de todos os
	 * fornecedores com quem o cliente possui conta.
	 * 
	 * @return a string que representa todas as contas de todos os fornecedores que
	 *         o cliente possui conta.
	 */
	public String exibeContasClientes() {
		if (contas.size() == 0) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao tem nenhuma conta.");
		}
		String msg = "Cliente: " + this.nome + " | ";
		List<Conta> listaContas = new ArrayList<>(contas.values());
		Collections.sort(listaContas);
		List<String> toStringDasContas = new ArrayList<String>();
		for (Conta e : listaContas) {
			if (e.getQtdCompras() != 0)
				toStringDasContas.add(e.toString());
		}
		msg += String.join(" | ", toStringDasContas);
		return msg;
	}

	/**
	 * Metodo que retorna a string que representa o valor do debito que o cliente
	 * tem com um fornecedor, a partir do nome do fornecedor.
	 * 
	 * @param fornecedor Nome do fornecedor
	 * @return a representacao em string do debito do cliente com um fornecedor.
	 */
	public String getDebito(String fornecedor) {
		Validador.validaEntrada(fornecedor, "Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.");
		if (!contas.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao tem debito com fornecedor.");
		}
		return contas.get(fornecedor).getDebito();
	}
}