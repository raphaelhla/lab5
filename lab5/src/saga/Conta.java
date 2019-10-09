package saga;

import java.util.ArrayList;
import java.util.List;

/**
 * Representacao de uma conta de um cliente com um fornecedor, toda conta
 * precisa do nome de um fornecedor, um valor de debito da conta e uma lista das
 * compras dos produtos.
 * 
 * @author Raphael Agra - 119110413
 *
 */
public class Conta implements Comparable<Conta> {

	/**
	 * Nome do fornecedor com quem um cliente mantem uma conta.
	 */
	private String nomeFornecedor;

	/**
	 * Debito total que um cliente deve pagar ao fornecedor.
	 */
	private double debito;

	/**
	 * Lista que contem o nome do produto e a data de todos os produtos que um
	 * cliente comprou do fornecedor.
	 */
	private List<String> listaCompras;

	/**
	 * Controi uma conta a partir do nome do fornecedor.
	 * 
	 * @param nomeFornecedor Nome do fornecedor.
	 */
	public Conta(String nomeFornecedor) {
		Validador.validaEntrada(nomeFornecedor, "Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
		this.nomeFornecedor = nomeFornecedor;
		this.debito = 0;
		this.listaCompras = new ArrayList<String>();
	}

	/**
	 * Metodo que adiciona uma compra na conta, a partir do nome do produto, da data
	 * e do valor do produto.
	 * 
	 * @param nomeProd Nome do produto.
	 * @param data     Data da compra.
	 * @param valor    Valor do produto.
	 */
	public void adicionaCompra(String nomeProd, String data, double valor) {
		Validador.validaEntrada(nomeProd, "Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
		Validador.validaEntrada(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
		if (data.length() != 10) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: data invalida.");
		}

		String novoFormatoData = data.replace("/", "-");
		listaCompras.add(nomeProd + " - " + novoFormatoData);
		this.debito += valor;
	}

	/**
	 * Retorna a string que representa uma conta. A representacao segue o formato:
	 * "NOME DO FORNECEDOR | COMPRAS - DATA DA COMPRA".
	 * 
	 * @return a representacao em string da conta
	 */
	@Override
	public String toString() {
		String msg = "";
		msg = this.nomeFornecedor + " | " + String.join(" | ", listaCompras);
		return msg;
	}

	/**
	 * Metodo que retorna a string que representa o nome do fornecedor.
	 * 
	 * @return a string que representa o nome do fornecedor.
	 */
	public String getNomeFornecedor() {
		return this.nomeFornecedor;
	}

	/**
	 * Metodo que retorna a string que representa o debito da conta.
	 * 
	 * @return a string que representa o debito da conta.
	 */
	public String getDebito() {
		return String.format("%.2f", this.debito).replace(",", ".");
	}

	/**
	 * Metodo que retorna o valor inteiro que representa a quantidade de compras que
	 * a conta possui.
	 * 
	 * @return o valor inteiro que representa a quantidade de compras que a conta
	 *         possui.
	 */
	public int getQtdCompras() {
		return this.listaCompras.size();
	}

	/**
	 * Retorna um inteiro que representa uma conta.
	 * 
	 * @return um inteiro que representa um conta.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(debito);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + listaCompras.hashCode();
		result = prime * result + nomeFornecedor.hashCode();
		return result;
	}

	/**
	 * Metodo que verifica a se duas contas sao iguais. Retorna um valor booleano
	 * verdade caso sejam iguais, caso contrario retorna falso.
	 * 
	 * @return Retorna um valor booleano verdade caso as contas sejam iguais, caso
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
		Conta other = (Conta) obj;
		if (Double.doubleToLongBits(debito) != Double.doubleToLongBits(other.debito))
			return false;
		if (!listaCompras.equals(other.listaCompras))
			return false;
		if (!nomeFornecedor.equals(other.nomeFornecedor))
			return false;
		return true;
	}

	/**
	 * Metodo da interface comparable que é utilizado na ordenacao de contas e
	 * utiliza o nome do fornecedor para ordenacao em ordem alfabetica.
	 * 
	 * @param a conta que vai ser comparado com a conta atual.
	 */
	@Override
	public int compareTo(Conta o) {
		return this.getNomeFornecedor().compareTo(o.getNomeFornecedor());
	}
}