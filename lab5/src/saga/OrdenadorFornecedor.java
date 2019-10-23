package saga;

import java.util.Comparator;

/**
 * Representacao de um ordenador de compras utilizando o fornecedor como
 * criterio.
 * 
 * @author Raphael Agra - 119110413
 *
 */
public class OrdenadorFornecedor implements Comparator<Compra> {

	/**
	 * Metodo que faz a comparacao entre duas contas utilizando o fornecedor como
	 * criterio de ordenacao.
	 */
	@Override
	public int compare(Compra o1, Compra o2) {
		if (o1.getFornecedor().equals(o2.getFornecedor())) {
			String msgO1 = o1.getCliente() + ", " + o1.getDescricaoProduto() + ", " + o1.getStringData();
			String msgO2 = o2.getCliente() + ", " + o2.getDescricaoProduto() + ", " + o2.getStringData();
			return msgO1.compareTo(msgO2);
		}
		return o1.getFornecedor().compareTo(o2.getFornecedor());
	}

}