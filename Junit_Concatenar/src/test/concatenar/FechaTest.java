package test.concatenar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.concatenar.Fecha;

class FechaTest {
	
	Fecha fecha;

	@BeforeEach
	void reseteoFecha() {
		fecha = new Fecha();
	}

	@Test
	void testDevuelveFecha1() {

		String resultado = fecha.devuelveFecha(1);

		assertEquals("2026/05", resultado);
	}

	@Test
	void testDevuelveFecha2() {

		String resultado = fecha.devuelveFecha(2);

		assertEquals("05/2026", resultado);
	}

	@Test
	void testDevuelveFecha3() {

		String resultado = fecha.devuelveFecha(3);

		assertEquals("05/26", resultado);
	}

	@Test
	void testDevuelveFechaDefault() {

		assertThrows(NumberFormatException.class, () -> fecha.devuelveFecha(6));
	}
	
}
