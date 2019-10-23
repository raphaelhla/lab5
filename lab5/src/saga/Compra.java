package saga;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Representacao de uma compra. Toda compra precisa de um cliente, um
 * fornecedor, nome e descricao de um produto, data da compra e preco do
 * produto.
 * 
 * @author Raphael Agra - 119110413
 *
 */
public class Compra {

	/**
	 * Nome do cliente que comprou o produto.
	 */
	private String cliente;

	/**
	 * Nome do fornecedor que comprou o produto.
	 */
	private String fornecedor;

	/**
	 * Nome do produto comprado.
	 */
	private String nomeProduto;

	/**
	 * Descricao do produto comprado.
	 */
	private String descricaoProd;

	/**
	 * Data da compra do produto.
	 */
	private Date data;

	/**
	 * Preco do produto comprado.
	 */
	private double preco;

	/**
	 * Atributo utilizado para manipulacao da data.
	 */
	SimpleDateFormat formato;

	/**
	 * Constroi uma compra a partir do cliente, fornecedor, nome, descricao e preco
	 * do produto e a data da compra.
	 * 
	 * @param cliente       Nome do cliente.
	 * @param fornecedor    Nome do fornecedor.
	 * @param nomeProduto   Nome do produto.
	 * @param descricaoProd Descricao do produto.
	 * @param data          Data da compra.
	 * @param preco         Preco do produto.
	 */
	public Compra(String cliente, String fornecedor, String nomeProduto, String descricaoProd, String data,
			double preco) {
		Validador.validaEntrada(cliente, "Erro ao cadastrar compra: cliente nao pode ser vazio ou nulo.");
		Validador.validaEntrada(fornecedor, "Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
		Validador.validaEntrada(nomeProduto, "Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
		Validador.validaEntrada(descricaoProd, "Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");
		Validador.validaEntrada(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
		if (data.length() != 10) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: data invalida.");
		}
		formato = new SimpleDateFormat("dd/MM/yyyy");
		this.cliente = cliente;
		this.fornecedor = fornecedor;
		this.nomeProduto = nomeProduto;
		this.descricaoProd = descricaoProd;
		this.preco = preco;
		try {
			this.data = formato.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retorna a string que representa uma compra. A representacao segue o formato:
	 * "NOME DO PRODUTO - DATA DA COMPRA".
	 * 
	 * @return a representacao em string da compra.
	 */
	@Override
	public String toString() {
		return nomeProduto + " - " + getStringData().replace("/", "-");
	}

	/**
	 * Metodo que retorna o valor double que representa o preco do produto.
	 * 
	 * @return o valor double que representa o preco do produto.
	 */
	public double getPreco() {
		return this.preco;
	}

	/**
	 * Metodo que retorna a string que representa o nome do cliente.
	 * 
	 * @return a string que representa o nome do cliente.
	 */
	public String getCliente() {
		return this.cliente;
	}

	/**
	 * Metodo que retorna a string que representa o nome do fornecedor.
	 * 
	 * @return a string que representa o nome do fornecedor.
	 */
	public String getFornecedor() {
		return this.fornecedor;
	}

	/**
	 * Metodo que retorna a string que representa o nome do produto.
	 * 
	 * @return a string que representa o nome do produto.
	 */
	public String getNomeProduto() {
		return nomeProduto;
	}

	/**
	 * Metodo que retorna a string que representa a descricao do produto.
	 * 
	 * @return a string que representa a descricao do produto.
	 */
	public String getDescricaoProduto() {
		return descricaoProd;
	}

	/**
	 * Metodo que retorna a string que representa a data da compra.
	 * 
	 * @return a string que representa a data da compra.
	 */
	public String getStringData() {
		return formato.format(data);
	}

	/**
	 * Metodo que retorna a date que representa a data da compra.
	 * 
	 * @return a date que representa a data da compra.
	 */
	public Date getData() {
		return data;
	}

	/**
	 * Metodo que retorna a string que representa a compra quando ela é ordenada
	 * utilizando o cliente como criterio de ordenacao.
	 * 
	 * @return a string que representa a conta quando ela é ordenada pelo cliente.
	 */
	public String exibeOrdenaCliente() {
		return cliente + ", " + fornecedor + ", " + descricaoProd + ", " + getStringData();
	}

	/**
	 * Metodo que retorna a string que representa a compra quando ela é ordenada
	 * utilizando o fornecedor como criterio de ordenacao.
	 * 
	 * @return a string que representa a conta quando ela é ordenada pelo
	 *         fornecedor.
	 */
	public String exibeOrdenaFornecedor() {
		return fornecedor + ", " + cliente + ", " + descricaoProd + ", " + getStringData();
	}

	/**
	 * Metodo que retorna a string que representa a compra quando ela é ordenada
	 * utilizando a data como criterio de ordenacao.
	 * 
	 * @return a string que representa a conta quando ela é ordenada pela data.
	 */
	public String exibeOrdenaData() {
		return getStringData() + ", " + cliente + ", " + fornecedor + ", " + descricaoProd;
	}
}
