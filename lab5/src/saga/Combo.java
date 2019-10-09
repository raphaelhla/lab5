package saga;

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
	private double precoSemDesconto;

	/**
	 * Constroi um combo de produtos a partir do nome, descricao, preco sem desconto
	 * do combo e do fator de desconto do combo.
	 * 
	 * @param nome             Nome do combo.
	 * @param descricao        Descricao do combo.
	 * @param precoSemDesconto Preco sem desconto do combo.
	 * @param fator            Fator de desconto do combo.
	 */
	public Combo(String nome, String descricao, double precoSemDesconto, double fator) {
		super(precoSemDesconto, nome, descricao);
		if (fator < 0 || fator >= 1) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fator invalido.");
		}

		this.precoSemDesconto = precoSemDesconto;
		this.preco = precoSemDesconto * (1 - fator);
	}

	/**
	 * Metodo que altera o preco do combo a partir de um novo fator de desconto
	 * passado como parametro
	 * 
	 * @param novoFator Novo fator de desconto que o combo ira utilizar.
	 */
	public void setPreco(double novoFator) {
		this.preco = this.precoSemDesconto * (1 - novoFator);
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