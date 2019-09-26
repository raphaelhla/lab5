package saga;

public class Facade {

	private ClienteController clienteController;
	
	public Facade() {
		this.clienteController = new ClienteController();
	}
	
	public String CadastraCliente(String nome, String cpf, String email, String localizacao) {
		return clienteController.cadastraCliente(nome, cpf, email, localizacao);
	}
	
	public String exibirCliente(String cpf) {
		return clienteController.exibirCliente(cpf);
	}
	
	public String listarClientes() {
		return clienteController.listarClientes();
	}
	
	public void removeCliente(String cpf) {
		clienteController.removeCliente(cpf);
	}
}
