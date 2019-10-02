package saga;

public class Produto {

	private double preco;
	private IdProduto idProduto;
	
	public Produto(double preco, String nome, String descricao) {
		Validador.validaEntrada(nome, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		Validador.validaEntrada(descricao, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		if (preco < 0) {
			throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
		}
		this.preco = preco;
		this.idProduto = new IdProduto(nome, descricao);
	}

	public String toString() {
		return String.format("%s - %s - R$%.2f",idProduto.getNome(), idProduto.getDescricao(), this.preco);
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getNome() {
		return idProduto.getNome();
	}

	public String getDescricao() {
		return idProduto.getDescricao();
	}
	
	public IdProduto getIdProduto() {
		return this.idProduto;
	}
	
}
