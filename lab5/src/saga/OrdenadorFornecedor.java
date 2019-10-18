package saga;

import java.util.Comparator;

public class OrdenadorFornecedor implements Comparator<Compra>{

	@Override
	public int compare(Compra o1, Compra o2) {
		if (o1.getFornecedor().equals(o2.getFornecedor())) {
			String msgO1 = o1.getCliente() + ", " + o1.getNomeProduto() + ", " + o1.getData();
			String msgO2 = o2.getCliente() + ", " + o2.getNomeProduto() + ", " + o2.getData();
			return msgO1.compareTo(msgO2);
		}
		return o1.getFornecedor().compareTo(o2.getFornecedor());
	}

}