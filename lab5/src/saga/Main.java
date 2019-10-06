package saga;

public class Main {

	public static void main(String[] args) {
		Facade facade = new Facade();
		facade.adicionaCliente("11122233300", "Ana Silva", "anasilva@ccc.ufcg.edu.br", "Embedded");
		facade.adicionaCliente("99988877700", "Washington", "washington@ccc.ufcg.edu.br", "SPLAB");
		facade.adicionaCliente("10290935474", "Raphael", "raphael@ccc.ufcg.edu.br", "LCC3");
		facade.adicionaCliente("10290935494", "Carlos", "carlos@ccc.ufcg.edu.br", "LCC5");
//		System.out.println(facade.exibeClientes());
//		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXX");

		facade.adicionaFornecedor("Dona Ines", "dines@gmail.com", "83 9999-5050");
		facade.adicionaFornecedor("Josenilda", "nilda@computacao.ufcg.edu.br", "83 98736-5050");
		facade.adicionaFornecedor("Alan Weasley", "alaweasley@splab.ufcg.edu.br", "83 99936-5050");
//		System.out.println(facade.exibeFornecedores());
//		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

		facade.adicionaProduto("Dona Ines", "Tapioca simples", "Tapioca com manteiga", 3.00);
		facade.adicionaProduto("Dona Ines", "Tapioca completa", "Tapioca com coco, queijo e manteiga", 3.50);
		facade.adicionaProduto("Dona Ines", "Bolo", "Bolo de chocolate", 3.00);
		facade.adicionaProduto("Josenilda", "Mousse", "Mousse de Limão", 4.00);
		facade.adicionaProduto("Josenilda", "Salada", "Salada de frutas com leite condensado", 4.50);
		facade.adicionaProduto("Alan Weasley", "X-tudo", "hamburguer de carne", 10.00);
//		System.out.println(facade.exibeProdutos());

//		Combo c1 = new Combo("t1", "d1", 1.00);
//		Combo c2 = new Combo("t1", "d1", 20.00);
//		System.out.println(c2.getPreco());

//		System.out.println(c1.getClass());
	}
}
