package saga;

import easyaccept.EasyAccept;

/**
 * Representacao de uma facade.
 * 
 * @author Raphael Agra - 119110413
 *
 */
public class Facade {

	/**
	 * Metodo para exibir os erros, se houver, dos testes de aceitacao.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		args = new String[] { "saga.Facade", "TestesAceitacao/use_case_1.txt", "TestesAceitacao/use_case_2.txt",
				"TestesAceitacao/use_case_3.txt", "TestesAceitacao/use_case_4.txt", "TestesAceitacao/use_case_5.txt",
				"TestesAceitacao/use_case_6.txt", "TestesAceitacao/use_case_7.txt" };
		EasyAccept.main(args);
	}

	/**
	 * Controller de clientes.
	 */
	private ClienteController clienteController;

	/**
	 * Controller de fornecedor.
	 */
	private FornecedorController fornecedorController;

	/**
	 * Constroi uma facade.
	 */
	public Facade() {
		this.fornecedorController = new FornecedorController();
		this.clienteController = new ClienteController(fornecedorController);
	}

	/**
	 * Metodo que cadastra um cliente no sistema a partir de seu nome, cpf, email e
	 * localizacao e retorna seu cpf caso o cadastro seja bem sucedido.
	 * 
	 * @param nome        Nome do cliente.
	 * @param cpf         Cpf do cliente.
	 * @param email       Email do cliente
	 * @param localizacao Localizacao do cliente.
	 * @return o cpf do cliente caso o cadastro tenha sido bem sucedido.
	 */
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		return clienteController.cadastraCliente(nome, cpf, email, localizacao);
	}

	/**
	 * Metodo que exibe a representacao em string de um cliente a partir de seu cpf.
	 * 
	 * @param cpf Cpf do cliente.
	 * @return a representacao em string do cliente.
	 */
	public String exibeCliente(String cpf) {
		return clienteController.exibeCliente(cpf);
	}

	/**
	 * Metodo que retorna a representacao em string da lista de todos os clientes
	 * cadastrados no sistema.
	 * 
	 * @return a representacao em string da lista de todos os clientes cadastrados
	 *         no sistema
	 */
	public String exibeClientes() {
		return clienteController.exibeClientes();
	}

	/**
	 * Metodo que edita um cliente a partir de seu cpf, atributo que vai ser editado
	 * e um novo valor para o atributo.
	 * 
	 * @param cpf       Cpf do cliente.
	 * @param atributo  Atributo do cliente que vai ser editado.
	 * @param novoValor Novo valor que vai ser atribuido ao atributo passado como
	 *                  parametro.
	 */
	public void editaCliente(String cpf, String atributo, String novoValor) {
		clienteController.editaCliente(cpf, atributo, novoValor);
	}

	/**
	 * Metodo que remove um cliente do sistema a partir de seu cpf.
	 * 
	 * @param cpf Cpf do cliente.
	 */
	public void removeCliente(String cpf) {
		clienteController.removeCliente(cpf);
	}

	/**
	 * Metodo que cadastra um fornecedor no sistema a partir de seu nome, email e
	 * telefone e retorna seu nome caso o cadastro seja bem sucedido.
	 * 
	 * @param nome     Nome do fornecedor.
	 * @param email    Email do fornecedor.
	 * @param telefone Telefone do fornecedor
	 * @return o nome do fornecedor caso o cadastro tenha sido bem sucedido.
	 */
	public String adicionaFornecedor(String nome, String email, String telefone) {
		return fornecedorController.cadastraFornecedor(nome, email, telefone);
	}

	/**
	 * Metodo que exibe a representacao em string de um fornecedor a partir de seu
	 * nome.
	 * 
	 * @param nome Nome do fornecedor.
	 * @return a representacao em string do fornecedor.
	 */

	public String exibeFornecedor(String nome) {
		return fornecedorController.exibeFornecedor(nome);
	}

	/**
	 * Metodo que retorna a representacao em string da lista de todos os
	 * fornecedores cadastrados no sistema.
	 * 
	 * @return a representacao em string da lista de todos os fornecedores
	 *         cadastrados no sistema
	 */
	public String exibeFornecedores() {
		return fornecedorController.exibeFornecedores();
	}

	/**
	 * Metodo que edita um fornecedor a partir de seu nome, atributo que vai ser
	 * editado e um novo valor para o atributo.
	 * 
	 * @param nome      Nome do fornecedor.
	 * @param atributo  Atributo do fornecedor que vai ser editado.
	 * @param novoValor Novo valor que vai ser atribuido ao atributo passado como
	 *                  parametro.
	 */
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		fornecedorController.editaFornecedor(nome, atributo, novoValor);
	}

	/**
	 * Metodo que remove um fornecedore do sistema a partir de seu nome.
	 * 
	 * @param nome Nome do fornecedor.
	 */
	public void removeFornecedor(String nome) {
		fornecedorController.removeFornecedor(nome);
	}

	/**
	 * Metodo que cadastra um novo produto para um fornecedor a partir do preco,
	 * nome e descricao do produto e a partir do nome do fornecedor.
	 * 
	 * @param nomeFornecedor Nome do fornecedor.
	 * @param nomeProduto    Nome do produto.
	 * @param descricao      Descricao do produto.
	 * @param preco          Preco do produto.
	 */
	public void adicionaProduto(String nomeFornecedor, String nomeProduto, String descricao, double preco) {
		fornecedorController.cadastraProduto(nomeFornecedor, nomeProduto, descricao, preco);
	}

	/**
	 * Metodo que exibe a representacao em string de um produto a partir de seu nome
	 * e sua descricao e de um nome do fornecedor ao qual o produto esta associado.
	 * 
	 * @param nomeProduto    Nome do produto.
	 * @param descricao      Descricao do produto.
	 * @param nomeFornecedor Nome do fornecedor
	 * @return a representacao em string de um produto.
	 */
	public String exibeProduto(String nomeProduto, String descricao, String nomeFornecedor) {
		return fornecedorController.exibeProduto(nomeFornecedor, nomeProduto, descricao);
	}

	/**
	 * Metodo que retorna a representacao em string da lista de todos os produtos de
	 * um determinado fornecedor a partir de seu nome.
	 * 
	 * @param nomeFornecedor Nome do fornecedor.
	 * @return a representacao em string da lista de todos os produtos do
	 *         fornecedor.
	 */
	public String exibeProdutosFornecedor(String nomeFornecedor) {
		return fornecedorController.exibeProdutosFornecedor(nomeFornecedor);
	}

	/**
	 * Metodo que retorna a representacao em string da lista de todos os produtos de
	 * todos os fornecedores do sistema.
	 * 
	 * @return a representacao em string da lista de todos os produtos de todos os
	 *         fornecedores do sistema.
	 */
	public String exibeProdutos() {
		return fornecedorController.exibeProdutos();
	}

	/**
	 * Metodo que edita o preco de um produto a partir de seu nome, descricao e seu
	 * novo preco e do nome do fornecedor ao qual o produto esta associado.
	 * 
	 * @param nomeFornecedor Nome do fornecedor.
	 * @param nomeProduto    Nome do produto.
	 * @param descricao      Descricao do produto.
	 * @param precoNovo      Preco novo do produto.
	 */
	public void editaProduto(String nomeProduto, String descricao, String nomeFornecedor, double precoNovo) {
		fornecedorController.editaProduto(nomeFornecedor, nomeProduto, descricao, precoNovo);
	}

	/**
	 * Metodo que remove um produto da lista de produtos do fornecedor a partir do
	 * seu nome e sua descricao e do nome do fornecedor ao qual o produto esta
	 * associado.
	 * 
	 * @param nomeFornecedor Nome do fornecedor.
	 * @param nomeProduto    Nome do produto.
	 * @param descricao      Descricao do produto.
	 */
	public void removeProduto(String nomeProduto, String descricao, String nomeFornecedor) {
		fornecedorController.removeProduto(nomeFornecedor, nomeProduto, descricao);
	}

	/**
	 * Metodo que adiciona um novo combo de produtos para um fornecedor, a partir do
	 * nome do fornecedor, do nome do combo, descricao do combo, fator de desconto
	 * do comboe dos produtos que vao fazer parte do combo.
	 * 
	 * @param fornecedor Nome do fornecedor.
	 * @param nome       Nome do combo.
	 * @param descricao  Descricao do combo.
	 * @param fator      Fator de desconto do combo.
	 * @param produtos   Produtos que vao fazer parte do combo.
	 */
	public void adicionaCombo(String fornecedor, String nome, String descricao, double fator, String produtos) {
		fornecedorController.adicionaCombo(fornecedor, nome, descricao, fator, produtos);
	}

	/**
	 * Metodo que edita o preco do combo de um fornecedor, a partir do nome do
	 * fornecedor, do nome do produto, descricao do produto e seu novo fator de
	 * desconto.
	 * 
	 * @param nome       Nome do combo.
	 * @param descricao  Descricao do combo.
	 * @param fornecedor Nome do fornecedor.
	 * @param novoFator  Novo fator de desconto do combo.
	 */
	public void editaCombo(String nome, String descricao, String fornecedor, double novoFator) {
		fornecedorController.editaCombo(nome, descricao, fornecedor, novoFator);
	}

	/**
	 * Metodo que adiciona uma compra de um produto de um fornecedor na conta de um
	 * cliente com o fornecedor, a partir do cpf do cliente, do nome do fornecedor,
	 * da data da compra, do nome do produto e da descricao do produto. Se o cliente
	 * nao tiver nenhuma conta com o fornecedor, uma nova conta deve ser criada.
	 * 
	 * @param cpf        Cpf do cliente.
	 * @param fornecedor Nome do fornecedor.
	 * @param data       Data da compra.
	 * @param nome       Nome do produto.
	 * @param descricao  Descricao do produto.
	 */
	public void adicionaCompra(String cpf, String fornecedor, String data, String nome, String descricao) {
		clienteController.adicionaCompra(cpf, fornecedor, data, nome, descricao);
	}

	/**
	 * Metodo que retorna a representacao em string da conta de um cliente com um
	 * fornecedor, a partir do cpf do cliente e do nome do fornecedor.
	 * 
	 * @param cpf        Cpf do cliente.
	 * @param fornecedor Nome do fornecedor.
	 * @return a string que representa a conta de um cliente com um fornecedor.
	 */
	public String exibeContas(String cpf, String fornecedor) {
		return clienteController.exibeContas(cpf, fornecedor);
	}

	/**
	 * Metodo que retorna a representacao em string de todas as contas de todos os
	 * fornecedores com qual um cliente possui conta, a partir do cpf do cliente.
	 * 
	 * @param cpf Cpf do cliente.
	 * @return a string que representa todas as contas de todos os fornecedores que
	 *         um determinado cliente cliente possui conta.
	 */
	public String exibeContasClientes(String cpf) {
		return clienteController.exibeContasClientes(cpf);
	}

	/**
	 * Metodo que retorna a string que representa o valor do debito que um cliente
	 * tem com um fornecedor, a partir do cpf do cliente e do nome do fornecedor.
	 * 
	 * @param cpf        Cpf do cliente.
	 * @param fornecedor Nome do fornecedor.
	 * @return a representacao em string do debito de um cliente com um fornecedor.
	 */
	public String getDebito(String cpf, String fornecedor) {
		return clienteController.getDebito(cpf, fornecedor);
	}
	
	public void realizaPagamento(String cpf, String fornecedor) {
		clienteController.realizaPagamento(cpf, fornecedor);
	}
}