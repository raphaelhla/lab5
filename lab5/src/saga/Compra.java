package saga;

public class Compra {

	private String nomeProduto;
	private String data;
	private double preco;
	
	public Compra(String nomeProduto, String data, double preco) {
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
}
