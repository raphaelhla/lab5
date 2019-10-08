package saga;

public class Combo extends Produto{

	private double fator;
	private double precoSemDesconto;
	
	public Combo(String nome, String descricao, double preco, double fator) {
		super(preco, nome, descricao);
		this.precoSemDesconto = preco;
		this.fator = fator;
		
		double precoCombo = preco * (1 - fator);
		this.setPreco(precoCombo);
		
	}
	
	public double getFator() {
		return this.fator;
	}
	
	public void setFator(double novoFator) {
		this.fator = novoFator;
	}

	public double getPrecoSemDesconto() {
		return precoSemDesconto;
	}
	
	public boolean verificaSeEhCombo() {
		return true;
	}
}