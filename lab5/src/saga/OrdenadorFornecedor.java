package saga;

import java.util.Comparator;

public class OrdenadorFornecedor implements Comparator<Compra>{

	@Override
	public int compare(Compra o1, Compra o2) {
		return o1.getFornecedor().compareTo(o2.getFornecedor());
	}

}