package saga;

public class Validador {

	public static void validaEntrada(String entrada,String mensagem) {
		if (entrada == null) {
			throw new NullPointerException(mensagem);
		}
		if ("".equals(entrada.trim())) {
			throw new IllegalArgumentException(mensagem);
		}
	}
	
}
