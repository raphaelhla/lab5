package saga;

import java.util.Comparator;

public class OrdenadorData implements Comparator<Compra>{

	@Override
	public int compare(Compra o1, Compra o2) {
		if (o1.getData().equals(o2.getData())) {
			String msgO1 = o1.getCliente() + ", " + o1.getFornecedor() + ", " + o1.getNomeProduto();
			String msgO2 = o2.getCliente() + ", " + o2.getFornecedor() + ", " + o2.getNomeProduto();
			return msgO1.compareTo(msgO2);
		}
		return o1.getData().compareTo(o2.getData());
	}

}