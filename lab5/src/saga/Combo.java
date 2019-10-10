package saga;

import java.util.Set;

/**
 * Representacao de um combo de produtos. Todo combo precisa ter um fator de
 * desconto e dos produtos que fazem parte do combo.
 * 
 * @author Raphael Agra - 119110413
 *
 */
public class Combo extends Produto {

	/**
	 * Preco do combo de produtos antes de aplicar o desconto.
	 */
	private double fator;

	/**
	 * Conjunto dos produtos que fazem parte do combo.
	 */
	private Set<ProdutoSimples> produtos;

	/**
	 * Constroi um combo de produtos a partir do seu nome, descricao, fator de
	 * desconto e dos produtos que vao fazer parte do combo.
	 * 
	 * @param nome      Nome do combo.
	 * @param descricao Descricao do combo.
	 * @param fator     Fator de desconto do combo.
	 * @param produtos  Produtos que vao fazer parte do combo.
	 */
	public Combo(String nome, String descricao, double fator, Set<ProdutoSimples> produtos) {
		super(nome, descricao);
		if (fator < 0 || fator >= 1) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fator invalido.");
		}

		this.fator = fator;
		this.produtos = produtos;
	}

	/**
	 * Metodo que retorna o valor double que representa o preco do combo.
	 * 
	 * @return o valor double que representa o preco do combo.
	 */
	public double getPreco() {
		double preco = 0;
		for (ProdutoSimples e : produtos) {
			preco += e.getPreco();
		}
		return preco * (1 - this.fator);
	}

	/**
	 * Metodo que altera o fator de desconto do combo a partir de um novo fator de
	 * desconto passado como parametro
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
		return String.format("%s - %s - R$%.2f", getNome(), getDescricao(), this.getPreco());
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