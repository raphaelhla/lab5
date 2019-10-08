package saga;

/**
 * Representaçao de um verificador de entradas nulas ou vazias.
 * 
 * @author Raphael Agra
 *
 */
public class Validador {

	/**
	 * /** Metodo que verifica se uma entrada é nula ou vazia. Recebe como
	 * parametros a entrada a ser testada e uma mensagem a ser lancada.
	 * 
	 * @param entrada  a ser testada.
	 * @param mensagem a ser lancada.
	 */
	public static void validaEntrada(String entrada, String mensagem) {
		if (entrada == null) {
			throw new NullPointerException(mensagem);
		}
		if ("".equals(entrada.trim())) {
			throw new IllegalArgumentException(mensagem);
		}
	}

}
