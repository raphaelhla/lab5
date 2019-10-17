package saga;

import java.util.Comparator;

public class OrdenadorData implements Comparator<Compra>{

	@Override
	public int compare(Compra o1, Compra o2) {
		return o1.getData().compareTo(o2.getData());
	}

}