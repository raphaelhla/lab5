package saga;

import java.util.HashMap;

/**
 * Representacao de um fornecedor. Todo fornecedor precisa ter um seus produtos
 * e um nome, email e telefone.
 * 
 * @author Raphael Agra
 *
 */
public class Fornecedor {

	/**
	 * Nome do fornecedor.
	 */
	private String nome;

	/**
	 * Email do fornecedor.
	 */
	private String email;

	/**
	 * Telefone do fornecedor.
	 */
	private String telefone;

	/**
	 * Mapa com todos os produtos do fornecedor, identificados unicamente por um ID
	 * com seu nome e sua descricao.
	 */
	private HashMap<IdProduto, Produto> produtos;

	/**
	 * Controi um fornecedor a partir de seu nome, email e telefone.
	 * 
	 * @param nome     Nome do fornecedor.
	 * @param email    Email do fornecedor.
	 * @param telefone Telefone do fornecedor.
	 */
	public Fornecedor(String nome, String email, String telefone) {
		Validador.validaEntrada(nome, "Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		Validador.validaEntrada(email, "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		Validador.validaEntrada(telefone, "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.produtos = new HashMap<IdProduto, Produto>();
	}

	/**
	 * Metodo que retorna a string que representa o email do fornecedor.
	 * 
	 * @return a string que representa o email do fornecedor.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Metodo que altera o email do fornecedor a partir de um novo email passado
	 * como parametro
	 * 
	 * @param email Email novo que o fornecedor ira receber.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Metodo que retorna a string que representa o telefone do fornecedor.
	 * 
	 * @return a string que representa o telefone do fornecedor.
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * Metodo que altera o telefone do fornecedor a partir de um novo telefone
	 * passado como parametro
	 * 
	 * @param telefone Telefone novo que o fornecedor ira receber.
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * Metodo que retorna a string que representa o nome do fornecedor.
	 * 
	 * @return a string que representa o nome do fornecedor.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Retorna um inteiro que representa um fornecedor.
	 * 
	 * @return um inteiro que representa um fornecedor.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nome.hashCode();
		return result;
	}

	/**
	 * Metodo que verifica a se dois fornecedores sao iguais. Retorna um valor
	 * booleano verdade caso sejam iguais, caso contrario retorna falso. Para dois
	 * fornecedores serem iguais eles devem possuir o mesmo nome.
	 * 
	 * @return Retorna um valor booleano verdade caso os fornecedores sejam iguais,
	 *         caso contrario retorna falso.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		if (!nome.equals(other.nome))
			return false;
		return true;
	}

	/**
	 * Retorna a string que representa o fornecedor. A representacao segue o
	 * formato: "NOME - EMAIL - TELEFONE".
	 * 
	 * @return a representacao em string do fornecedor
	 */
	public String toString() {
		return this.nome + " - " + this.email + " - " + this.telefone;
	}

	/**
	 * Metodo que cadastra um novo produto para o fornecedor a partir do preco, nome
	 * e descricao do produto.
	 * 
	 * @param preco       Preco do produto.
	 * @param nomeProduto Nome do produto.
	 * @param descricao   Descricao do produto.
	 */
	public void cadastraProduto(double preco, String nomeProduto, String descricao) {
		Validador.validaEntrada(nomeProduto, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		Validador.validaEntrada(descricao, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		if (preco < 0) {
			throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
		}
		Produto p1 = new Produto(preco, nomeProduto, descricao);
		if (!produtos.containsKey(p1.getIdProduto())) {
			this.produtos.put(p1.getIdProduto(), p1);
		} else {
			throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
		}

	}

	/**
	 * Metodo que exibe a representacao em string de um produto a partir de seu nome
	 * e sua descricao.
	 * 
	 * @param nomeProduto Nome do produto.
	 * @param descricao   Descricao do produto.
	 * @return a representacao em string de um produto.
	 */
	public String exibeProduto(String nomeProduto, String descricao) {
		Validador.validaEntrada(nomeProduto, "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		Validador.validaEntrada(descricao, "Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		IdProduto idProduto = new IdProduto(nomeProduto, descricao);
		if (produtos.containsKey(idProduto)) {
			return produtos.get(idProduto).toString();
		} else {
			throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
		}

	}

	/**
	 * Metodo que retorna a representacao em string da lista de todos os produtos do
	 * fornecedor.
	 * 
	 * @return a representacao em string da lista de todos os produtos do fornecedor.
	 */
	public String listarProdutos() {
		String msg = "";
		int contador = 0;
		for (Produto e : produtos.values()) {
			contador += 1;
			if (contador < produtos.size()) {
				msg += this.nome + " - " + e.toString() + " | ";
			} else {
				msg += this.nome + " - " + e.toString();
			}
		}
		return msg;
	}

	/**
	 * Metodo que edita o preco de um produto a partir de seu nome, descricao e seu
	 * novo preco.
	 * 
	 * @param nomeProduto Nome do produto.
	 * @param descricao   Descricao do produto.
	 * @param precoNovo   Preco novo do produto.
	 */
	public void editaProduto(String nomeProduto, String descricao, double precoNovo) {
		Validador.validaEntrada(nomeProduto, "Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		Validador.validaEntrada(descricao, "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		if (precoNovo < 0) {
			throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
		}
		IdProduto idProduto = new IdProduto(nomeProduto, descricao);
		if (produtos.containsKey(idProduto)) {
			produtos.get(idProduto).setPreco(precoNovo);
		} else {
			throw new IllegalArgumentException("Erro na edicao de produto: produto nao existe.");
		}
	}

	/**
	 * Metodo que remove um produto da lista de produtos do fornecedor a partir do
	 * seu nome e sua descricao.
	 * 
	 * @param nomeProduto Nome do produto.
	 * @param descricao   Descricao do produto.
	 */
	public void removeProduto(String nomeProduto, String descricao) {
		Validador.validaEntrada(nomeProduto, "Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		Validador.validaEntrada(descricao, "Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		IdProduto idProduto = new IdProduto(nomeProduto, descricao);
		if (produtos.containsKey(idProduto)) {
			produtos.remove(idProduto);
		} else {
			throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
		}
	}
}
