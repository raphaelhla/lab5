package saga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Representacao de uma conta de um cliente com um fornecedor. Toda conta
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
	private String fornecedor;

	/**
	 * Lista que contem as compras de um cliente com um fornecedor.
	 */
	private List<Compra> listaCompras;

	/**
	 * Controi uma conta a partir do nome do fornecedor.
	 * 
	 * @param nomeFornecedor Nome do fornecedor.
	 */
	public Conta(String fornecedor) {
		Validador.validaEntrada(fornecedor, "Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
		this.fornecedor = fornecedor;
		this.listaCompras = new ArrayList<Compra>();
	}

	/**
	 * Metodo que adiciona uma compra na conta, a partir do nome do produto, da data
	 * e do valor do produto.
	 * 
	 * @param nomeProd Nome do produto.
	 * @param data     Data da compra.
	 * @param valor    Valor do produto.
	 */
	public void adicionaCompra(String cliente, String fornecedor, String nomeProd, String descricaoProd, String data,
			double preco) {
		Validador.validaEntrada(nomeProd, "Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
		Validador.validaEntrada(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
		if (data.length() != 10) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: data invalida.");
		}

		listaCompras.add(new Compra(cliente, fornecedor, nomeProd, descricaoProd, data, preco));
	}

	/**
	 * Retorna a string que representa uma conta. A representacao segue o formato:
	 * "NOME DO FORNECEDOR | COMPRAS - DATA DA COMPRA".
	 * 
	 * @return a representacao em string da conta
	 */
	@Override
	public String toString() {
		String msg = this.fornecedor + " | ";
		List<String> stringCompras = new ArrayList<String>();
		for (int i = 0; i < listaCompras.size(); i++) {
			stringCompras.add(listaCompras.get(i).toString());
		}
		msg += String.join(" | ", stringCompras);
		return msg;
	}

	/**
	 * Metodo que retorna a string que representa o nome do fornecedor.
	 * 
	 * @return a string que representa o nome do fornecedor.
	 */
	public String getNomeFornecedor() {
		return this.fornecedor;
	}

	/**
	 * Metodo que retorna a string que representa o debito da conta.
	 * 
	 * @return a string que representa o debito da conta.
	 */
	public String getDebito() {
		double debito = 0;
		for (Compra compra : listaCompras) {
			debito += compra.getPreco();
		}
		return String.format("%.2f", debito).replace(",", ".");
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
	 * Metodo da interface comparable que é utilizado na ordenacao de contas e
	 * utiliza o nome do fornecedor para ordenacao em ordem alfabetica.
	 * 
	 * @param o a conta que vai ser comparado com a conta atual.
	 */
	@Override
	public int compareTo(Conta o) {
		return this.getNomeFornecedor().compareTo(o.getNomeFornecedor());
	}

	/**
	 * Metodo que retorna a lista de compras que a conta possui.
	 * 
	 * @return a lista de compras que a conta possui.
	 */
	public List<Compra> getCompras() {
		return this.listaCompras;
	}
}