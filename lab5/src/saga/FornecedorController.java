package saga;

import java.util.HashMap;

public class FornecedorController {

	private HashMap<String, Fornecedor> fornecedores;

	public FornecedorController() {
		this.fornecedores = new HashMap<String, Fornecedor>();
	}

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

	public String exibirFornecedor(String nome) {
		Validador.validaEntrada(nome, "Erro na exibicao do fornecedor: nome nao pode ser vazio ou nulo.");
		if(!fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
		}
		return fornecedores.get(nome).toString();
	}

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

	public void editaFornecedor(String nome, String atributo, String novoValor) {
		Validador.validaEntrada(nome, "Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
		Validador.validaEntrada(atributo, "Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
		Validador.validaEntrada(novoValor, "Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
		if (!fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: fornecedor nao existe.");
		}
		if (atributo.equals("email")) {
			fornecedores.get(nome).setEmail(novoValor);
		}else if(atributo.equals("telefone")) {
			fornecedores.get(nome).setTelefone(novoValor);
		}else if (atributo.equals("nome")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
		}else {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
		}
	}

	public void removeFornecedor(String nome) {
		Validador.validaEntrada(nome, "Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.");
		if (!fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro na remocao do fornecedor: fornecedor nao existe.");
		}
		fornecedores.remove(nome);
	}
	
	public void cadastraProduto(String nomeFornecedor, String nomeProduto, String descricao, double preco) {
		Validador.validaEntrada(nomeFornecedor, "Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		Validador.validaEntrada(nomeProduto, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		Validador.validaEntrada(descricao, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		if (!fornecedores.containsKey(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
		}
		if(preco < 0) {
			throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
		}
		fornecedores.get(nomeFornecedor).cadastraProduto(preco, nomeProduto, descricao);
	}
	
	public String exibirProduto(String nomeProduto, String descricao, String nomeFornecedor) {
		Validador.validaEntrada(nomeFornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		Validador.validaEntrada(nomeProduto, "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		Validador.validaEntrada(descricao, "Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		if (!fornecedores.containsKey(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
		}
		return fornecedores.get(nomeFornecedor).exibirProduto(nomeProduto, descricao);
	}
	
	public String listarProdutosDeUmFornecedor(String nomeFornecedor) {
		return fornecedores.get(nomeFornecedor).listarProdutos();
	}
	
	public String listarProdutosDeTodosFornecedores() {
		String msg = "";
		int contador = 0;
		for (Fornecedor e : fornecedores.values()) {
			contador += 1;
			if (contador < fornecedores.size()) {
				msg += e.listarProdutos() + " | ";
			}else {
				msg += e.listarProdutos();
			}
		}
		return msg;
	}

	public void editaProduto(String nomeFornecedor, String nomeProduto, String descricao, double precoNovo) {
		Validador.validaEntrada(nomeFornecedor, "Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		Validador.validaEntrada(nomeProduto, "Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		Validador.validaEntrada(descricao, "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		if (!fornecedores.containsKey(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
		}
		if(precoNovo < 0) {
			throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
		}
		fornecedores.get(nomeFornecedor).editaProduto(nomeProduto, descricao, precoNovo);
	}

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
