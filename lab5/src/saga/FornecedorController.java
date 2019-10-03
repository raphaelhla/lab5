package saga;

import java.util.HashMap;

/**
 * Representacao de um controller de fornecedores.
 * 
 * @author Raphael Agra
 *
 */
public class FornecedorController {

	/**
	 * Mapa com todos os fornecedores cadastrados no sistema, identificados
	 * unicamente pelo seu nome
	 */
	private HashMap<String, Fornecedor> fornecedores;

	/**
	 * Constroi um controller de fornecedores.
	 */
	public FornecedorController() {
		this.fornecedores = new HashMap<String, Fornecedor>();
	}

	/**
	 * Metodo que cadastra um fornecedor no sistema a partir de seu nome, email e
	 * telefone e retorna seu nome caso o cadastro seja bem sucedido.
	 * 
	 * @param nome     Nome do fornecedor.
	 * @param email    Email do fornecedor.
	 * @param telefone Telefone do fornecedor
	 * @return o nome do fornecedor caso o cadastro tenha sido bem sucedido.
	 */
	public String cadastraFornecedor(String nome, String email, String telefone) {
		Validador.validaEntrada(nome, "Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		Validador.validaEntrada(email, "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		Validador.validaEntrada(telefone, "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		if (!fornecedores.containsKey(nome)) {
			this.fornecedores.put(nome, new Fornecedor(nome, email, telefone));
			return nome;
		} else {
			throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
		}
	}

	/**
	 * Metodo que exibe a representacao em string de um fornecedor a partir de seu
	 * nome.
	 * 
	 * @param nome Nome do fornecedor.
	 * @return a representacao em string do fornecedor.
	 */
	public String exibeFornecedor(String nome) {
		Validador.validaEntrada(nome, "Erro na exibicao do fornecedor: nome nao pode ser vazio ou nulo.");
		if (!fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
		}
		return fornecedores.get(nome).toString();
	}

	/**
	 * Metodo que retorna a representacao em string da lista de todos os
	 * fornecedores cadastrados no sistema.
	 * 
	 * @return a representacao em string da lista de todos os fornecedores
	 *         cadastrados no sistema
	 */
	public String listarFornecedores() {
		String msg = "";
		int contador = 0;
		for (Fornecedor e : fornecedores.values()) {
			contador += 1;
			if (contador < fornecedores.size()) {
				msg += e.toString() + " | ";
			} else {
				msg += e.toString();
			}
		}
		return msg;
	}

	/**
	 * Metodo que edita um fornecedor a partir de seu nome, atributo que vai ser
	 * editado e um novo valor para o atributo.
	 * 
	 * @param nome      Nome do fornecedor.
	 * @param atributo  Atributo do fornecedor que vai ser editado.
	 * @param novoValor Novo valor que vai ser atribuido ao atributo passado como
	 *                  parametro.
	 */
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		Validador.validaEntrada(nome, "Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
		Validador.validaEntrada(atributo, "Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
		Validador.validaEntrada(novoValor, "Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
		if (!fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: fornecedor nao existe.");
		}
		if (atributo.equals("email")) {
			fornecedores.get(nome).setEmail(novoValor);
		} else if (atributo.equals("telefone")) {
			fornecedores.get(nome).setTelefone(novoValor);
		} else if (atributo.equals("nome")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
		} else {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
		}
	}

	/**
	 * Metodo que remove um fornecedore do sistema a partir de seu nome.
	 * 
	 * @param nome Nome do fornecedor.
	 */
	public void removeFornecedor(String nome) {
		Validador.validaEntrada(nome, "Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.");
		if (!fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro na remocao do fornecedor: fornecedor nao existe.");
		}
		fornecedores.remove(nome);
	}

	/**
	 * Metodo que cadastra um novo produto para um fornecedor a partir do preco,
	 * nome e descricao do produto e a partir do nome do fornecedor.
	 * 
	 * @param nomeFornecedor Nome do fornecedor.
	 * @param nomeProduto    Nome do produto.
	 * @param descricao      Descricao do produto.
	 * @param preco          Preco do produto.
	 */
	public void cadastraProduto(String nomeFornecedor, String nomeProduto, String descricao, double preco) {
		Validador.validaEntrada(nomeFornecedor, "Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		Validador.validaEntrada(nomeProduto, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		Validador.validaEntrada(descricao, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		if (!fornecedores.containsKey(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
		}
		if (preco < 0) {
			throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
		}
		fornecedores.get(nomeFornecedor).cadastraProduto(preco, nomeProduto, descricao);
	}

	/**
	 * Metodo que exibe a representacao em string de um produto a partir de seu nome
	 * e sua descricao e de um nome do fornecedor ao qual o produto esta associado.
	 * 
	 * @param nomeProduto    Nome do produto.
	 * @param descricao      Descricao do produto.
	 * @param nomeFornecedor Nome do fornecedor
	 * @return a representacao em string de um produto.
	 */
	public String exibeProduto(String nomeProduto, String descricao, String nomeFornecedor) {
		Validador.validaEntrada(nomeFornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		Validador.validaEntrada(nomeProduto, "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		Validador.validaEntrada(descricao, "Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		if (!fornecedores.containsKey(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
		}
		return fornecedores.get(nomeFornecedor).exibeProduto(nomeProduto, descricao);
	}

	/**
	 * Metodo que retorna a representacao em string da lista de todos os produtos de
	 * um determinado fornecedor a partir de seu nome.
	 * 
	 * @param nomeFornecedor Nome do fornecedor.
	 * @return a representacao em string da lista de todos os produtos do
	 *         fornecedor.
	 */
	public String listarProdutosDeUmFornecedor(String nomeFornecedor) {
		return fornecedores.get(nomeFornecedor).listarProdutos();
	}

	/**
	 * Metodo que retorna a representacao em string da lista de todos os produtos de
	 * todos os fornecedores do sistema.
	 * 
	 * @return a representacao em string da lista de todos os produtos de todos os
	 *         fornecedores do sistema.
	 */
	public String listarProdutosDeTodosFornecedores() {
		String msg = "";
		int contador = 0;
		for (Fornecedor e : fornecedores.values()) {
			contador += 1;
			if (contador < fornecedores.size()) {
				msg += e.listarProdutos() + " | ";
			} else {
				msg += e.listarProdutos();
			}
		}
		return msg;
	}

	/**
	 * Metodo que edita o preco de um produto a partir de seu nome, descricao e seu
	 * novo preco e do nome do fornecedor ao qual o produto esta associado.
	 * 
	 * @param nomeFornecedor Nome do fornecedor.
	 * @param nomeProduto    Nome do produto.
	 * @param descricao      Descricao do produto.
	 * @param precoNovo      Preco novo do produto.
	 */
	public void editaProduto(String nomeFornecedor, String nomeProduto, String descricao, double precoNovo) {
		Validador.validaEntrada(nomeFornecedor, "Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		Validador.validaEntrada(nomeProduto, "Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		Validador.validaEntrada(descricao, "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		if (!fornecedores.containsKey(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
		}
		if (precoNovo < 0) {
			throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
		}
		fornecedores.get(nomeFornecedor).editaProduto(nomeProduto, descricao, precoNovo);
	}

	/**
	 * Metodo que remove um produto da lista de produtos do fornecedor a partir do
	 * seu nome e sua descricao e do nome do fornecedor ao qual o produto esta
	 * associado.
	 * 
	 * @param nomeFornecedor Nome do fornecedor.
	 * @param nomeProduto    Nome do produto.
	 * @param descricao      Descricao do produto.
	 */
	public void removeProduto(String nomeFornecedor, String nomeProduto, String descricao) {
		Validador.validaEntrada(nomeFornecedor, "Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		Validador.validaEntrada(nomeProduto, "Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		Validador.validaEntrada(descricao, "Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		if (!fornecedores.containsKey(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");
		}
		fornecedores.get(nomeFornecedor).removeProduto(nomeProduto, descricao);
	}
}
