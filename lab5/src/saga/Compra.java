package saga;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Compra {

	private String cliente;
	private String fornecedor;
	private String nomeProduto;
	private String descricaoProd;
	private Date data;
	private double preco;
	SimpleDateFormat formato;
	
	public Compra(String cliente, String fornecedor, String nomeProduto, String descricaoProd, String data, double preco) {
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

	@Override
	public String toString() {
		return nomeProduto + " - " + getStringData().replace("/", "-");
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

	public String getStringData() {
		return formato.format(data);
	}
	
	public Date getData() {
		return data;
	}
	
	public String exibeOrdenaCliente() {
		return cliente + ", " + fornecedor + ", " + descricaoProd + ", " + getStringData();
	}
	
	public String exibeOrdenaFornecedor() {
		return fornecedor + ", " + cliente + ", " + descricaoProd + ", " + getStringData();
	}
	
	public String exibeOrdenaData() {
		return getStringData() + ", " + cliente + ", " + fornecedor + ", " + descricaoProd;
	}
}

