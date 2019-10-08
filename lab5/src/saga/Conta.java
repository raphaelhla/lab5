package saga;

import java.util.ArrayList;
import java.util.List;

public class Conta implements Comparable<Conta>{

	private String nomeFornecedor;
	private double debito;
	private List<String> listaCompras;
	
	public Conta(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
		this.debito = 0;
		this.listaCompras = new ArrayList<String>();
	}
	
	public void adicionaCompra(String nomeProd, String data, double valor) {
		String novoFormatoData = data.replace("/", "-");
		listaCompras.add(nomeProd + " - " + novoFormatoData);
		this.debito += valor;
	}
	
	@Override
	public String toString() {
		String msg = "";
		msg = this.nomeFornecedor + " | " + String.join(" | ", listaCompras);
		return msg;
	}
	
	public String getNomeFornecedor() {
		return this.nomeFornecedor;
	}
	
	public String getDebito() {
		return String.format("%.2f", this.debito).replace(",", ".");
	}
	
	public int getQtdCompras() {
		return this.listaCompras.size();
	}

	@Override
	public int compareTo(Conta o) {
		return this.getNomeFornecedor().compareTo(o.getNomeFornecedor());
	}
}
