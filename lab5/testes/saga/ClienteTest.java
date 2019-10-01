package saga;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteTest {

	private Cliente cliente1;
	private Cliente cliente2;
	private Cliente cliente3;
	
	@BeforeEach
	public void criandoCliente() {
		cliente1 = new Cliente("Raphael","12345678900","raphael.agra@ccc.ufcg.edu.br","CAA");
	}

	@Test
	public void testGetNome() {
		assertEquals("Raphael", cliente1.getNome());
	}

}
