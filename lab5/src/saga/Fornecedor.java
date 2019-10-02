package saga;

import java.util.HashMap;

public class Fornecedor {

	private String nome;
	private String email;
	private String telefone;
	private HashMap<IdProduto, Produto> produtos;

	public Fornecedor(String nome, String email, String telefone) {
		Validador.validaEntrada(nome, "Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		Validador.validaEntrada(email, "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		Validador.validaEntrada(telefone, "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.produtos = new HashMap<IdProduto, Produto>();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nome.hashCode();
		return result;
	}

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

	public String toString() {
		return this.nome + " - " + this.email + " - " + this.telefone;
	}
	
	public void cadastraProduto(double preco, String nome, String descricao) {
		Produto p1 = new Produto(preco, nome, descricao);
		if (!produtos.containsKey(p1.getIdProduto())) {
			this.produtos.put(p1.getIdProduto(), p1);
		}else {
			throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
		}
		
	}
	
	public String exibirProduto(String nomeProduto, String descricao) {
		IdProduto idProduto = new IdProduto(nomeProduto, descricao);
		if (produtos.containsKey(idProduto)) {
			return produtos.get(idProduto).toString();
		}else {
			throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
		}
		
	}

	public String listarProdutos() {
		String msg = "";
		int contador = 0;
		for (Produto e : produtos.values()) {
			contador += 1;
			if (contador < produtos.size()) {
				msg += e.toString() + " | ";
			}else {
				msg += e.toString();
			}
		}
		return msg;
	}
	
	public void editaProduto(String nomeProduto, String descricao, double precoNovo) {
		IdProduto idProduto = new IdProduto(nomeProduto, descricao);
		if (produtos.containsKey(idProduto)) {
			produtos.get(idProduto).setPreco(precoNovo);
		}else {
			throw new IllegalArgumentException("Erro na edicao de produto: produto nao existe.");
		}
	}

	public void removeProduto(String nomeProduto, String descricao) {
		IdProduto idProduto = new IdProduto(nomeProduto, descricao);
		if (produtos.containsKey(idProduto)) {
			produtos.remove(idProduto);
		}else {
			throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
		}	
	}
}
