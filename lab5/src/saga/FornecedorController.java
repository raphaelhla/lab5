package saga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Representacao de um controller de fornecedores.
 * 
 * @author Raphael Agra - 119110413
 *
 */
public class FornecedorController {

	/**
	 * Mapa com todos os fornecedores cadastrados no sistema, identificados
	 * unicamente pelo seu nome
	 */
	private Map<String, Fornecedor> fornecedores;

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
		if (fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
		}
		this.fornecedores.put(nome, new Fornecedor(nome, email, telefone));
		return nome;
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
	public String exibeFornecedores() {
		String msg = "";
		List<Fornecedor> listaFornecedores = new ArrayList<Fornecedor>(fornecedores.values());
		Collections.sort(listaFornecedores);
		List<String> fornecedoresToString = new ArrayList<String>();
		for (Fornecedor e : listaFornecedores) {
			fornecedoresToString.add(e.toString());
		}
		msg = String.join(" | ", fornecedoresToString);
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
	public String exibeProduto(String nomeFornecedor, String nomeProduto, String descricao) {
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
	public String exibeProdutosFornecedor(String nomeFornecedor) {
		Validador.validaEntrada(nomeFornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		if (!fornecedores.containsKey(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
		}
		return fornecedores.get(nomeFornecedor).listarProdutos();
	}

	/**
	 * Metodo que retorna a representacao em string da lista de todos os produtos de
	 * todos os fornecedores do sistema.
	 * 
	 * @return a representacao em string da lista de todos os produtos de todos os
	 *         fornecedores do sistema.
	 */
	public String exibeProdutos() {
		String msg = "";
		List<Fornecedor> listaFornecedores = new ArrayList<Fornecedor>(fornecedores.values());
		Collections.sort(listaFornecedores);
		List<String> listaProdutosDosFonecedores = new ArrayList<>();
		for (Fornecedor e : listaFornecedores) {
			listaProdutosDosFonecedores.add(e.listarProdutos());
		}
		msg = String.join(" | ", listaProdutosDosFonecedores);
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

	/**
	 * Metodo que adiciona um novo combo de produtos para um fornecedor, a partir do
	 * nome do fornecedor, do nome do combo, descricao do combo, fator de desconto
	 * do comboe dos produtos que vao fazer parte do combo.
	 * 
	 * @param fornecedor Nome do fornecedor.
	 * @param nome       Nome do combo.
	 * @param descricao  Descricao do combo.
	 * @param fator      Fator de desconto do combo.
	 * @param produtos   Produtos que vao fazer parte do combo.
	 */
	public void adicionaCombo(String fornecedor, String nome, String descricao, double fator, String produtos) {
		Validador.validaEntrada(fornecedor, "Erro no cadastro de combo: fornecedor nao pode ser vazio ou nulo.");
		Validador.validaEntrada(nome, "Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
		Validador.validaEntrada(descricao, "Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");
		Validador.validaEntrada(produtos, "Erro no cadastro de combo: combo deve ter produtos.");
		if (fator < 0 || fator >= 1) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fator invalido.");
		}
		if (!fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fornecedor nao existe.");
		}

		fornecedores.get(fornecedor).adicionaCombo(nome, descricao, fator, produtos);
	}

	/**
	 * Metodo que edita o preco do combo de um fornecedor, a partir do nome do
	 * fornecedor, do nome do produto, descricao do produto e seu novo fator de
	 * desconto.
	 * 
	 * @param nome       Nome do combo.
	 * @param descricao  Descricao do combo.
	 * @param fornecedor Nome do fornecedor.
	 * @param novoFator  Novo fator de desconto do combo.
	 */
	public void editaCombo(String nome, String descricao, String fornecedor, double novoFator) {
		Validador.validaEntrada(nome, "Erro na edicao de combo: nome nao pode ser vazio ou nulo.");
		Validador.validaEntrada(descricao, "Erro na edicao de combo: descricao nao pode ser vazia ou nula.");
		Validador.validaEntrada(fornecedor, "Erro na edicao de combo: fornecedor nao pode ser vazio ou nulo.");
		if (novoFator <= 0 || novoFator >= 1) {
			throw new IllegalArgumentException("Erro na edicao de combo: fator invalido.");
		}
		if (!fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro na edicao de combo: fornecedor nao existe.");
		}

		fornecedores.get(fornecedor).editaCombo(nome, descricao, novoFator);
	}

	/**
	 * Metodo que verifica se um fornecedor existe, a partir do seu nome. Retorna um
	 * valor verdade caso ele exista, caso contrario retorna falso.
	 * 
	 * @param fornecedor Nome do fornecedor.
	 * @return um valor verdade caso o fornecedor exista, caso contrario retorna
	 *         falso.
	 */
	public boolean existeFornecedor(String fornecedor) {
		if (!fornecedores.containsKey(fornecedor)) {
			return false;
		}
		return true;
	}

	/**
	 * Metodo que verifica se um fornecedor possui um determinado produto, a partir
	 * do nome do fornecedor, do nome do produto e sua descricao. Retorna um valor
	 * booleano verdade caso o produto exista, caso contrario retorna falso.
	 * 
	 * @param fornecedor Nome do fornecedor.
	 * @param nome       Nome do produto.
	 * @param descricao  Descricao do produto.
	 * @return um valor booleano verdade caso o produto exista, caso contrario
	 *         retorna falso.
	 */
	public boolean existeProdutoFornecedor(String fornecedor, String nome, String descricao) {
		return fornecedores.get(fornecedor).existeProduto(nome, descricao);
	}

	/**
	 * Metodo que retorna um valor double que representa o preco de um determinado
	 * produto de um fornecedor, a partir do nome do fornecedor, do nome do produto
	 * e da sua descricao.
	 * 
	 * @param fornecedor Nome do fornecedor.
	 * @param nome       Nome do produto.
	 * @param descricao  Descricao do produto.
	 * @return um valor double que representa o preco de um determinado produto de
	 *         um fornecedor.
	 */
	public double getPrecoProdutoFornecedor(String fornecedor, String nome, String descricao) {
		return fornecedores.get(fornecedor).getPrecoProduto(nome, descricao);
	}
}