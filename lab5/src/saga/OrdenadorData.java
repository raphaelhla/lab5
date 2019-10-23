package saga;

import java.util.Comparator;

/**
 * Representacao de um ordenador de compras utilizando a data como criterio.
 * 
 * @author Raphael Agra - 119110413
 *
 */
public class OrdenadorData implements Comparator<Compra> {

	/**
	 * Metodo que faz a comparacao entre duas contas utilizando a data como criterio
	 * de ordenacao.
	 */
	@Override
	public int compare(Compra o1, Compra o2) {
		if (o1.getStringData().equals(o2.getStringData())) {
			String msgO1 = o1.getCliente() + ", " + o1.getFornecedor() + ", " + o1.getDescricaoProduto();
			String msgO2 = o2.getCliente() + ", " + o2.getFornecedor() + ", " + o2.getDescricaoProduto();
			return msgO1.compareTo(msgO2);
		}
		return o1.getData().compareTo(o2.getData());
	}

}