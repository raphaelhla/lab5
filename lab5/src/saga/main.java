package saga;

import java.text.SimpleDateFormat;
import java.util.Date;

public class main {

	public static void main(String[] args) {
		Date data = new Date();
		SimpleDateFormat x = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(x.format(data));
	}
}
