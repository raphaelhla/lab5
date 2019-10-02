package saga;

import easyaccept.EasyAccept;

public class Facade {

	public static void main(String[] args) {
		args = new String[] { "saga.Facade", "TestesAceitacao/use_case_1.txt", "TestesAceitacao/use_case_2.txt", "TestesAceitacao/use_case_3.txt"};
		EasyAccept.main(args);
	}
	
	private ClienteController clienteController;
	private FornecedorController fornecedorController;
	
	public Facade() {
		this.clienteController = new ClienteController();
		this.fornecedorController = new FornecedorController();
	}
	
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		return clienteController.cadastraCliente(nome, cpf, email, localizacao);
	}
	
	public String exibeCliente(String cpf) {
		return clienteController.exibeCliente(cpf);
	}
	
	public String listarClientes() {
		return clienteController.listarClientes();
	}
	
	public void editaCliente(String cpf, String atributo, String novoValor) {
		clienteController.editaCliente(cpf, atributo, novoValor);
	}
	
	public void removeCliente(String cpf) {
		clienteController.removeCliente(cpf);
	}
	
	public String adicionaFornecedor(String nome, String email, String telefone) {
		return fornecedorController.cadastraFornecedor(nome, email, telefone);
	}
	
	public String exibeFornecedor(String nome) {
		return fornecedorController.exibirFornecedor(nome);
	}
	
	public String listarFornecedores() {
		return fornecedorController.listarFornecedores();
	}
	
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		fornecedorController.editaFornecedor(nome, atributo, novoValor);
	}
	
	public void removeFornecedor(String nome) {
		fornecedorController.removeFornecedor(nome);
	}
	
	public void adicionaProduto(String nomeFornecedor, String nomeProduto, String descricao, double preco) {
		fornecedorController.cadastraProduto(nomeFornecedor, nomeProduto, descricao, preco);
	}
	
	public String exibeProduto(String nomeFornecedor, String nomeProduto, String descricao) {
		return fornecedorController.exibirProduto(nomeFornecedor, nomeProduto, descricao);
	}
	
	public String listarProdutosDeUmFornecedor(String nomeFornecedor) {
		return fornecedorController.listarProdutosDeUmFornecedor(nomeFornecedor);
	}
	
	public String listarProdutosDeTodosFornecedores() {
		return fornecedorController.listarProdutosDeTodosFornecedores();
	}
	
	public void editaProduto(String nomeProduto, String descricao, String nomeFornecedor, double precoNovo) {
		fornecedorController.editaProduto(nomeFornecedor, nomeProduto, descricao, precoNovo);
	}
	
	public void removeProduto(String nomeProduto, String descricao, String nomeFornecedor) {
		fornecedorController.removeProduto(nomeFornecedor, nomeProduto, descricao);
	}
}
