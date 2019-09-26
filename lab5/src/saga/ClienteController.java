package saga;

import java.util.HashMap;

public class ClienteController {

	private HashMap<String, Cliente> clientes;

	public ClienteController() {
		this.clientes = new HashMap<String, Cliente>();
	} 
	
	public String cadastraCliente(String nome, String cpf, String email, String localizacao) {
		if (cpf == null) {
			throw new NullPointerException("CPF NULO.");
		}else if ("".equals(cpf.trim())) {
			throw new IllegalArgumentException("CPF INVALIDO.");
		}else if (!this.clientes.containsKey(cpf)) {
			this.clientes.put(cpf, new Cliente(nome,cpf,email,localizacao));
			return cpf;
		}else {
			throw new IllegalArgumentException("Cliente ja cadastrado.");
		}
	}
	
	public String exibirCliente(String cpf) {
		if(clientes.containsKey(cpf)) {
			return clientes.get(cpf).toString();
		}else {
			return "Cliente nao cadastrado";
		}
	}
	
	public String listarClientes() {
		String msg = "";
		int contador = 0;
		for (Cliente e : clientes.values()) {
			contador += 1;
			if (contador < clientes.size()) {
				msg += e.toString() + " | ";
			}else {
				msg += e.toString();
			}
		}
		return msg;
	}
	
	public void removeCliente(String cpf) {
		this.clientes.remove(cpf);
	}
	

}
