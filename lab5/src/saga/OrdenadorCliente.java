package saga;

import java.util.Comparator;

public class OrdenadorCliente implements Comparator<Compra>{

	@Override
	public int compare(Compra o1, Compra o2) {
		if (o1.getCliente().equals(o2.getCliente())) {
			String msgO1 = o1.getFornecedor() + ", " + o1.getNomeProduto() + ", " + o1.getData();
			String msgO2 = o2.getFornecedor() + ", " + o2.getNomeProduto() + ", " + o2.getData();
			return msgO1.compareTo(msgO2);
		}
		return o1.getCliente().compareTo(o2.getCliente());
	}

}
