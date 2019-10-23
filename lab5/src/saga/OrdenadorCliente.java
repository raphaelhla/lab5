package saga;

import java.util.Comparator;

/**
 * Representacao de um ordenador de compras utilizando o cliente como criterio.
 * 
 * @author Raphael Agra - 119110413
 *
 */
public class OrdenadorCliente implements Comparator<Compra> {

	/**
	 * Metodo que faz a comparacao entre duas contas utilizando o cliente como
	 * criterio de ordenacao.
	 */
	@Override
	public int compare(Compra o1, Compra o2) {
		if (o1.getCliente().equals(o2.getCliente())) {
			String msgO1 = o1.getFornecedor() + ", " + o1.getDescricaoProduto() + ", " + o1.getStringData();
			String msgO2 = o2.getFornecedor() + ", " + o2.getDescricaoProduto() + ", " + o2.getStringData();
			return msgO1.compareTo(msgO2);
		}
		return o1.getCliente().compareTo(o2.getCliente());
	}
}
