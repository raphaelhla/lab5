package saga;

import java.util.HashMap;

public class ClienteController {

	private HashMap<String, Cliente> clientes;

	public ClienteController() {
		this.clientes = new HashMap<String, Cliente>();
	}

	public String cadastraCliente(String nome, String cpf, String email, String localizacao) {
		Validador.validaEntrada(nome, "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		Validador.validaEntrada(cpf, "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		Validador.validaEntrada(email, "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		Validador.validaEntrada(localizacao, "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
		}
		if (!this.clientes.containsKey(cpf)) {
			this.clientes.put(cpf, new Cliente(nome, cpf, email, localizacao));
			return cpf;
		} else {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
		}
	}

	public String exibeCliente(String cpf) {
		Validador.validaEntrada(cpf, "Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.");
		if (!clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
		}
		return clientes.get(cpf).toString();
	}

	public String listarClientes() {
		String msg = "";
		int contador = 0;
		for (Cliente e : clientes.values()) {
			contador += 1;
			if (contador < clientes.size()) {
				msg += e.toString() + " | ";
			} else {
				msg += e.toString();
			}
		}
		return msg;
	}

	public void editaCliente(String cpf, String atributo, String novoValor) {
		Validador.validaEntrada(cpf, "Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");
		Validador.validaEntrada(atributo, "Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		Validador.validaEntrada(novoValor, "Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		if (!clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
		}
		if (atributo.equals("nome")) {
			clientes.get(cpf).setNome(novoValor);
		} else if (atributo.equals("email")) {
			clientes.get(cpf).setEmail(novoValor);
		} else if (atributo.equals("localizacao")) {
			clientes.get(cpf).setLocalizacao(novoValor);
		}else if(atributo.equals("cpf")) {
			throw new IllegalArgumentException("Erro na edicao do cliente: cpf nao pode ser editado.");
		}else {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
		}
		
	}

	public void removeCliente(String cpf) {
		Validador.validaEntrada(cpf, "Erro na remocao do cliente: cpf nao pode ser vazio ou nulo");
		if (!clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro na remocao do cliente: cliente nao existe.");
		}
		this.clientes.remove(cpf);
	}
}
