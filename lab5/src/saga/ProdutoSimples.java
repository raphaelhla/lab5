package saga;

public class ProdutoSimples extends Produto{

	private double preco;
	
	public ProdutoSimples(String nome, String descricao, double preco) {
		super(nome, descricao);
		if (preco < 0) {
			throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
		}
		this.preco = preco;
	}
	
	/**
	 * Metodo que retorna o valor double que representa o preco do produto.
	 * 
	 * @return o valor double que representa o preco do produto.
	 */
	public double getPreco() {
		return preco;
	}
	
	/**
	 * Metodo que altera o preco do produto a partir de um novo preco passado como
	 * parametro
	 * 
	 * @param preco Preco novo que o produto ira receber.
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	/**
	 * Retorna a string que representa um produto. A representacao segue o formato:
	 * "NOME - DESCRICAO - PRECO".
	 * 
	 * @return a representacao em string do produto.
	 */
	@Override
	public String toString() {
		return String.format("%s - %s - R$%.2f", idProduto.getNome(), idProduto.getDescricao(), this.preco);
	}
}
