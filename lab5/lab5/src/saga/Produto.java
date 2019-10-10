package saga;

/**
 * Representacao de um produto. Todo produto precisa de um nome e uma
 * descricao.
 * 
 * @author Raphael Agra - 119110413
 *
 */
public abstract class Produto implements Comparable<Produto> {

	/**
	 * Classe de identificacao do produto que contem o seu nome e sua descricao.
	 */
	protected IdProduto idProduto;

	/**
	 * Constroi um produto a partir do seu nome e descricao.
	 * 
	 * @param nome      Nome do produto.
	 * @param descricao Descricao do produto.
	 */
	public Produto(String nome, String descricao) {
		Validador.validaEntrada(nome, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		Validador.validaEntrada(descricao, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		
		this.idProduto = new IdProduto(nome, descricao);
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
	 * Retorna a string que representa um produto. A representacao segue o formato:
	 * "NOME - DESCRICAO".
	 * 
	 * @return a representacao em string do produto.
	 */
	@Override
	public String toString() {
		return String.format("%s - %s", idProduto.getNome(), idProduto.getDescricao());
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

	/**
	 * Metodo da interface comparable que é utilizado na ordenacao de produtos e
	 * utiliza o nome do produto para ordenacao em ordem alfabetica. Caso o nome dos
	 * produtos que estao sendo comparados forem iguais, o metodo utilizará a
	 * descricao do produto para ordena-los.
	 * 
	 * @param o produto que vai ser comparado com o produto atual.
	 */
	@Override
	public int compareTo(Produto o) {
		if (!this.getNome().equals(o.getNome())) {
			return this.getNome().compareTo(o.getNome());
		}
		return this.getDescricao().compareTo(o.getDescricao());
	}

	/**
	 * Metodo que retorna o valor booeano verdade se o produto for um combo, caso
	 * contrario retorna falso.
	 * 
	 * @return Retorna um valor booleano verdade caso o produto for um combo, caso
	 *         contrario retorna falso.
	 */
	public boolean verificaSeEhCombo() {
		return false;
	}
}