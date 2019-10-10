package saga;

/**
 * Representacao de um produto simples. Todo produto simples precisa de um
 * preco.
 * 
 * @author Raphael Agra - 119110413
 *
 */
public class ProdutoSimples extends Produto {

	/**
	 * Preco do produto
	 */
	private double preco;

	/**
	 * Controi um produto simples a partir do seu nome, descricao e preco.
	 * 
	 * @param nome      Nome do produto.
	 * @param descricao Descricao do produto.
	 * @param preco     Preco do produto.
	 */
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
		return String.format("%s - %s - R$%.2f", getNome(), getDescricao(), this.preco);
	}
}
