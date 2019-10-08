package saga;

/**
 * Representacao de um ID de um produto. Todo IdProduto precisa de um nome e uma
 * descricao.
 * 
 * @author Raphael Agra
 *
 */
public class IdProduto {

	/**
	 * Nome do produto.
	 */
	private String nome;

	/**
	 * Descricao do produto.
	 */
	private String descricao;

	/**
	 * Constroi um ID do produto a partir de seu nome e sua descricao
	 * 
	 * @param nome      Nome do produto.
	 * @param descricao Descricao do produto.
	 */
	public IdProduto(String nome, String descricao) {
		Validador.validaEntrada(nome, "Erro no cadastro de idProduto: nome nao pode ser vazio ou nulo.");
		Validador.validaEntrada(descricao, "Erro no cadastro de idProduto: descricao nao pode ser vazia ou nula.");
		this.nome = nome;
		this.descricao = descricao;
	}

	/**
	 * Metodo que retorna a string que representa o nome de um produto.
	 * 
	 * @return a string que representa o nome de um produto.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Metodo que retorna a string que representa a descricao de um produto.
	 * 
	 * @return a string que representa a descricao de um produto.
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * Retorna um inteiro que representa um ID de um produto.
	 * 
	 * @return um inteiro que representa um ID de um produto.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + descricao.hashCode();
		result = prime * result + nome.hashCode();
		return result;
	}

	/**
	 * Metodo que verifica a se dois produtos ID sao iguais. Retorna um valor
	 * booleano verdade caso sejam iguais, caso contrario retorna falso. Para dois
	 * produtos ID serem iguais eles devem possuir o mesmo nome e descricao.
	 * 
	 * @return Retorna um valor booleano verdade caso os produtos ID sejam iguais,
	 *         caso contrario retorna falso.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IdProduto other = (IdProduto) obj;
		if (!nome.equals(other.nome))
			return false;
		return true;
	}

}