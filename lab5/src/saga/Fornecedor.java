package saga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Representacao de um fornecedor. Todo fornecedor precisa ter seus produtos e
 * um nome, email e telefone.
 * 
 * @author Raphael Agra - 119110413
 *
 */
public class Fornecedor implements Comparable<Fornecedor> {

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
	private Map<IdProduto, Produto> produtos;
	
	/**
	 * Mapa com todos os produtos simples do fornecedor, identificados unicamente por um ID
	 * com seu nome e sua descricao.
	 */
	private Map<IdProduto, ProdutoSimples> produtosSimples;
	
	/**
	 * Mapa com todos os combos do fornecedor, identificados unicamente por um ID
	 * com seu nome e sua descricao.
	 */
	private Map<IdProduto, Combo> combos;

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
		this.produtosSimples = new HashMap<IdProduto, ProdutoSimples>();
		this.combos = new HashMap<IdProduto, Combo>();
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
	@Override
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
		ProdutoSimples p1 = new ProdutoSimples(nomeProduto, descricao, preco);
		if (produtos.containsKey(p1.getIdProduto())) {
			throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
		}
		this.produtosSimples.put(p1.getIdProduto(), p1);
		this.produtos.put(p1.getIdProduto(), p1);
		
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
		if (produtosSimples.containsKey(idProduto)) {
			return produtosSimples.get(idProduto).toString();
		} else if (combos.containsKey(idProduto)) {
			return combos.get(idProduto).toString();
		} else {
			throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
		}
	}

	/**
	 * Metodo que retorna a representacao em string da lista de todos os produtos do
	 * fornecedor.
	 * 
	 * @return a representacao em string da lista de todos os produtos do
	 *         fornecedor.
	 */
	public String listarProdutos() {
		String msg = "";
		List<Produto> listaProdutos = new ArrayList<>(produtos.values());
		Collections.sort(listaProdutos);
		List<String> produtosToString = new ArrayList<>();

		if (listaProdutos.size() != 0) {
			for (Produto e : listaProdutos) {
				produtosToString.add(this.nome + " - " + e.toString());
			}
		} else {
			produtosToString.add(this.nome + " -");
		}
		msg = String.join(" | ", produtosToString);
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
		if (!produtos.containsKey(idProduto)) {
			throw new IllegalArgumentException("Erro na edicao de produto: produto nao existe.");
		}
		ProdutoSimples produto = produtosSimples.get(idProduto);
		produto.setPreco(precoNovo);
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
		if (!produtos.containsKey(idProduto)) {
			throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
		} if (produtosSimples.containsKey(idProduto)) {
			produtosSimples.remove(idProduto);
		} if (combos.containsKey(idProduto)) {
			combos.remove(idProduto);
		}
		produtos.remove(idProduto);
	}

	/**
	 * Metodo da interface comparable que é utilizado na ordenacao de fornecedores e
	 * utiliza o nome do fornecedor para ordenacao em ordem alfabetica.
	 * 
	 * @param o um fornecedor que vai ser comparado com o fornecedor atual.
	 */
	@Override
	public int compareTo(Fornecedor o) {
		return this.getNome().compareTo(o.getNome());
	}

	/**
	 * Metodo que adiciona um novo combo de produtos para o fornecedor, a partir do
	 * nome do combo, descricao do combo, fator de desconto e dos produtos que vao
	 * fazer parte do combo.
	 * 
	 * @param nome            Nome do combo.
	 * @param descricao       Descricao do combo.
	 * @param fator           Fator de desconto do combo.
	 * @param produtosDoCombo Produtos que vao fazer parte do combo.
	 */
	public void adicionaCombo(String nome, String descricao, double fator, String produtosDoCombo) {
		Validador.validaEntrada(nome, "Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
		Validador.validaEntrada(descricao, "Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");
		Validador.validaEntrada(produtosDoCombo, "Erro no cadastro de combo: combo deve ter produtos.");
		if (fator < 0 || fator >= 1) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fator invalido.");
		}
		IdProduto idCombo = new IdProduto(nome, descricao);
		if (this.produtos.containsKey(idCombo)) {
			throw new IllegalArgumentException("Erro no cadastro de combo: combo ja existe.");
		}

		Set<ProdutoSimples> produtosCombo = new HashSet<ProdutoSimples>();
		String[] listaDeProdutos = produtosDoCombo.split(", ");

		for (String e : listaDeProdutos) {
			String nomeProduto = e.split(" - ")[0];
			String descricaoProduto = e.split(" - ")[1];
			IdProduto idProduto = new IdProduto(nomeProduto, descricaoProduto);
			if (!this.produtos.containsKey(idProduto)) {
				throw new IllegalArgumentException("Erro no cadastro de combo: produto nao existe.");
			}
			if (this.combos.containsKey(idProduto)) {
				throw new IllegalArgumentException(
						"Erro no cadastro de combo: um combo nao pode possuir combos na lista de produtos.");
			}
			produtosCombo.add(produtosSimples.get(idProduto));
		}

		Combo c1 = new Combo(nome, descricao, fator, produtosCombo);
		this.produtos.put(idCombo, c1);
		this.combos.put(idCombo, c1);
	}

	/**
	 * Metodo que edita o fator de desconto de um combo a partir de seu nome,
	 * descricao e seu novo fator de desconto.
	 * 
	 * @param nome      Nome do combo.
	 * @param descricao Descricao do combo.
	 * @param novoFator Novo fator de desconto do combo.
	 */
	public void editaCombo(String nome, String descricao, double novoFator) {
		Validador.validaEntrada(nome, "Erro na edicao de combo: nome nao pode ser vazio ou nulo.");
		Validador.validaEntrada(descricao, "Erro na edicao de combo: descricao nao pode ser vazia ou nula.");
		if (novoFator <= 0 || novoFator >= 1) {
			throw new IllegalArgumentException("Erro na edicao de combo: fator invalido.");
		}

		IdProduto idCombo = new IdProduto(nome, descricao);
		if (!produtos.containsKey(idCombo)) {
			throw new IllegalArgumentException("Erro na edicao de combo: produto nao existe.");
		}

		Combo combo = combos.get(idCombo);
		combo.setFator(novoFator);
	}

	/**
	 * Metodo que retorna um valor double que representa o preco de um determinado
	 * produto do fornecedor, a partir do nome do produto e da sua descricao.
	 * 
	 * @param nome      Nome do produto.
	 * @param descricao Descricao do produto.
	 * @return um valor double que representa o preco de um determinado produto do
	 *         fornecedor.
	 */
	public double getPrecoProduto(String nome, String descricao) {
		IdProduto idProduto = new IdProduto(nome, descricao);
		if (combos.containsKey(idProduto)) {
			return combos.get(idProduto).getPreco();
		}else if (produtosSimples.containsKey(idProduto)) {
			return produtosSimples.get(idProduto).getPreco();
		}else {
			throw new IllegalArgumentException("Erro ao recuperar preco do produto: produto nao existe.");
		}
	}

	/**
	 * Metodo que verifica se o fornecedor possui um determinado produto, a partir
	 * do seu nome e sua descricao. Retorna um valor booleano verdade caso o produto
	 * exista, caso contrario retorna falso.
	 * 
	 * @param nome      Nome do produto.
	 * @param descricao Descricao do produto.
	 * @return um valor booleano verdade caso o produto exista, caso contrario
	 *         retorna falso.
	 */
	public boolean existeProduto(String nome, String descricao) {
		IdProduto idProduto = new IdProduto(nome, descricao);
		if (!produtos.containsKey(idProduto)) {
			return false;
		}
		return true;
	}
}