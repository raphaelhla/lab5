package saga;

import java.text.SimpleDateFormat;

public class Compra {

	private String cliente;
	private String fornecedor;
	private String nomeProduto;
	private String descricaoProd;
	private String data;
	private double preco;
	SimpleDateFormat formato;
	
	public Compra(String cliente, String fornecedor, String nomeProduto, String descricaoProd, String data, double preco) {
		this.cliente = cliente;
		this.fornecedor = fornecedor;
		this.nomeProduto = nomeProduto;
		this.descricaoProd = descricaoProd;
		this.data = data;
		this.preco = preco;
		formato = new SimpleDateFormat();
	}

	@Override
	public String toString() {
		
		return nomeProduto + " - " + data.replace("/", "-");
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
	
	public String getDescricaoProduto() {
		return descricaoProd;
	}

	public String getData() {
		return data;
	}
	
	public String exibeOrdenaCliente() {
		return cliente + ", " + fornecedor + ", " + descricaoProd + ", " + data;
	}
	
	public String exibeOrdenaFornecedor() {
		return fornecedor + ", " + cliente + ", " + descricaoProd + ", " + data;
	}
	
	public String exibeOrdenaData() {
		return data + ", " + cliente + ", " + fornecedor + ", " + descricaoProd;
	}
}

