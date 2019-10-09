package saga;

import java.util.Map;

/**
 * Representacao de um combo de produtos, todo combo precisa ter o valor do
 * preco dos produtos sem desconto.
 * 
 * @author Raphael Agra - 119110413
 *
 */
public class Combo extends Produto {

	/**
	 * Preco do combo de produtos antes de aplicar o desconto.
	 */
	private double fator;
	private Map<IdProduto, ProdutoSimples> produtos;

	/**
	 * Constroi um combo de produtos a partir do nome, descricao, preco sem desconto
	 * do combo e do fator de desconto do combo.
	 * 
	 * @param nome             Nome do combo.
	 * @param descricao        Descricao do combo.
	 * @param precoSemDesconto Preco sem desconto do combo.
	 * @param fator            Fator de desconto do combo.
	 */
	public Combo(String nome, String descricao, double fator, Map<IdProduto, ProdutoSimples> produtos) {
		super(nome, descricao);
		if (fator < 0 || fator >= 1) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fator invalido.");
		}

		this.fator = fator;
		this.produtos = produtos;
	}

	/**
	 * Metodo que retorna o valor double que representa o preco do produto.
	 * 
	 * @return o valor double que representa o preco do produto.
	 */
	public double getPreco() {
		double preco = 0;
		for (ProdutoSimples e : produtos.values()) {
			preco += e.getPreco();
		}
		return preco * (1 - this.fator);
	}

	/**
	 * Metodo que altera o fator de desconto do combo a partir de um novo fator de desconto
	 * passado como parametro
	 * 
	 * @param novoFator Novo fator de desconto que o combo ira utilizar.
	 */
	public void setFator(double novoFator) {
		this.fator = novoFator;
	}

	/**
	 * Retorna a string que representa um combo. A representacao segue o formato:
	 * "NOME - DESCRICAO - PRECO".
	 * 
	 * @return a representacao em string do combo.
	 */
	@Override
	public String toString() {
		return String.format("%s - %s - R$%.2f", idProduto.getNome(), idProduto.getDescricao(), this.getPreco());
	}
	
	/**
	 * Metodo que retorna o valor booeano verdade se o produto for um combo, caso
	 * contrario retorna falso.
	 * 
	 * @return Retorna um valor booleano verdade caso o produto for um combo, caso
	 *         contrario retorna falso.
	 */
	public boolean verificaSeEhCombo() {
		return true;
	}
}