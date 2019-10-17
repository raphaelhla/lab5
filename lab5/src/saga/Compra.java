package saga;

public class Compra {

	private String cliente;
	private String fornecedor;
	private String nomeProduto;
	private String data;
	private double preco;
	
	public Compra(String cliente, String fornecedor, String nomeProduto, String data, double preco) {
		this.cliente = cliente;
		this.fornecedor = fornecedor;
		this.nomeProduto = nomeProduto;
		this.data = data;
		this.preco = preco;
	}

	@Override
	public String toString() {
		return nomeProduto + " - " + data;
	}
	
	public double getPreco() {
		return this.preco;
	}
	
	public String getCliente() {
		return this.cliente;
	}
	
	public String getFornecedor() {
		return this.fornecedor;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public String getData() {
		return data;
	}
	
	public String restoOrdenaCliente() {
		return fornecedor + ", " + nomeProduto + ", " + data;
	}
	
	
}
