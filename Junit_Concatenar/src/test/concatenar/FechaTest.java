package test.concatenar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.concatenar.Fecha;

class FechaTest {

	@Test
	void testDevuelveFecha1() {
		Fecha fecha = new Fecha();

		String resultado = fecha.devuelveFecha(1);

		assertEquals("2026/04", resultado);
	}

	@Test
	void testDevuelveFecha2() {
		Fecha fecha = new Fecha();

		String resultado = fecha.devuelveFecha(2);

		assertEquals("04/2026", resultado);
	}

	@Test
	void testDevuelveFecha3() {
		Fecha fecha = new Fecha();

		String resultado = fecha.devuelveFecha(3);

		assertEquals("04/26", resultado);
	}

	@Test
	void testDevuelveFechaDefault() {
		Fecha fecha = new Fecha();

		String resultado = fecha.devuelveFecha(4);

		assertEquals("ERROR", resultado);
	}

}
