package saga;

/**
 * Representacao de um cliente. Todo cliente precisa ter um nome, cpf, email e
 * localizacao.
 * 
 * @author Raphael Agra
 *
 */
public class Cliente {

	/**
	 * Nome do cliente.
	 */
	private String nome;

	/**
	 * Cpf do cliente.
	 */
	private String cpf;

	/**
	 * Email do cliente.
	 */
	private String email;

	/**
	 * Localizacao do cliente.
	 */
	private String localizacao;

	/**
	 * Constroi um cliente a partir de seu nome, cpf, email e localizacao.
	 * 
	 * @param nome        Nome do cliente.
	 * @param cpf         Cpf do cliente.
	 * @param email       Email do cliente.
	 * @param localizacao Localizacao do cliente.
	 */
	public Cliente(String nome, String cpf, String email, String localizacao) {
		Validador.validaEntrada(nome, "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		Validador.validaEntrada(cpf, "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		Validador.validaEntrada(email, "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		Validador.validaEntrada(localizacao, "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
		}
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.localizacao = localizacao;
	}

	/**
	 * Retorna um inteiro que representa um cliente.
	 * 
	 * @return um inteiro que representa um cliente.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cpf.hashCode();
		return result;
	}

	/**
	 * Metodo que verifica a se dois clientes sao iguais. Retorna um valor
	 * booleano verdade caso sejam iguais, caso contrario retorna falso. Para dois
	 * clientes serem iguais eles devem possuir o mesmo cpf.
	 * 
	 * @return Retorna um valor booleano verdade caso os clientes sejam iguais, caso
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
		Cliente other = (Cliente) obj;
		if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	/**
	 * Retorna a representacao em string de um cliente. A representacao segue o formato: "NOME - LOCALIZACAO - EMAIL".
	 * 
	 * @return a representacao em string de um cliente.
	 */
	@Override
	public String toString() {
		return this.nome + " - " + this.localizacao + " - " + this.email;
	}

	/**
	 * Metodo que retorna a string que representa o nome do cliente.
	 * 
	 * @return a string que representa o nome do cliente.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Metodo que altera o nome do cliente a partir de um novo nome passado como
	 * parametro
	 * 
	 * @param nome Nome novo que o cliente ira receber.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Metodo que retorna a string que representa o email do cliente.
	 * 
	 * @return a string que representa o email do cliente.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Metodo que altera o email do cliente a partir de um novo email passado como
	 * parametro
	 * 
	 * @param email Email novo que o cliente ira receber.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Metodo que retorna a string que representa a localizacao do cliente.
	 * 
	 * @return a string que representa a localizacao do cliente.
	 */
	public String getLocalizacao() {
		return localizacao;
	}

	/**
	 * Metodo que altera a localizacao do cliente a partir de uma nova localizacao passada como
	 * parametro
	 * 
	 * @param localizacao Localizacao nova que o cliente ira receber.
	 */
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	/**
	 * Metodo que retorna a string que representa o cpf do cliente.
	 * 
	 * @return a string que representa o cpf do cliente.
	 */
	public String getCpf() {
		return cpf;
	}
}
