package saga;

/**
 * Representacao de um produto. Todo produto precisa de um preco, um nome e uma
 * descricao.
 * 
 * @author Raphael Agra
 *
 */
public class Produto {

	/**
	 * Preco do produto.
	 */
	private double preco;

	/**
	 * Classe de identificacao do produto que contem o seu nome e sua descricao.
	 */
	private IdProduto idProduto;

	/**
	 * Constroi um produto a partir do seu preco, nome e descricao.
	 * 
	 * @param preco     Preco do produto.
	 * @param nome      Nome do produto.
	 * @param descricao Descricao do produto.
	 */
	public Produto(double preco, String nome, String descricao) {
		Validador.validaEntrada(nome, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		Validador.validaEntrada(descricao, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		if (preco < 0) {
			throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
		}
		this.preco = preco;
		this.idProduto = new IdProduto(nome, descricao);
	}

	/**
	 * Retorna a string que representa um produto. A representacao segue o formato:
	 * "NOME - DESCRICAO - PRECO".
	 * 
	 * @return a representacao em string do produto.
	 */
	public String toString() {
		return String.format("%s - %s - R$%.2f", idProduto.getNome(), idProduto.getDescricao(), this.preco);
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
	 * Metodo que retorna a string que representa o nome do produto.
	 * 
	 * @return a string que representa o nome do produto.
	 */
	public String getNome() {
		return idProduto.getNome();
	}

	/**
	 * Metodo que retorna a string que representa a descricao do produto.
	 * 
	 * @return a string que representa a descricao do produto.
	 */
	public String getDescricao() {
		return idProduto.getDescricao();
	}

	/**
	 * Metodo que retorna um objeto do tipo IdProduto, que representa o nome e a
	 * descricao do produto.
	 * 
	 * @return um objeto que representa o ID do produto.
	 */
	public IdProduto getIdProduto() {
		return this.idProduto;
	}

	/**
	 * Retorna um inteiro que representa um produto.
	 * 
	 * @return um inteiro que representa um produto.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idProduto.hashCode();
		return result;
	}

	/**
	 * Metodo que verifica a se dois produtos sao iguais. Retorna um valor booleano
	 * verdade caso sejam iguais, caso contrario retorna falso. Para dois produtos
	 * serem iguais eles devem possuir o mesmo ID, ou seja, o mesmo nome e
	 * descricao.
	 * 
	 * @return Retorna um valor booleano verdade caso os produtos sejam iguais, caso
	 *         contrario retorna falso.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (!idProduto.equals(other.idProduto))
			return false;
		return true;
	}
}
