package ejercicio4_JUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ComprobacionesTest {

	static Integer[] enteros = { 2, 3, 7, 6, 1 };
	static Comprobaciones comp;

	@BeforeAll
	static void rellenarArray() {
		comp = new Comprobaciones(enteros);
	}

	@Test
	void testComprobacionesOK() {
		Integer[] enteros = { 2, 3, 7, 6, 1 };

		Integer[] resultado = comp.getEnteros();

		assertArrayEquals(resultado, enteros);
	}

	@Test
	void testComprobacionesArrayNull() {

		IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> new Comprobaciones(null));
		assertEquals("No hay elementos", exc.getMessage());

	}

	@Test
	void testComprobacionesArrayVacio() {
		Integer[] enteros = {};

		IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> new Comprobaciones(enteros));
		assertEquals("No hay elementos", exc.getMessage());
	}

	@Test
	void testSumaEnteros() {
		int resultado = comp.sumaEnteros();
		assertEquals(19, resultado);
	}

	@Test
	void testMayorValor() {
		int resultado = comp.mayorValor();
		assertEquals(7, resultado);
	}

	@Test
	void testPosicionValor() {
		int resultado = comp.posicionValor(7);
		assertEquals(3, resultado);
	}
	
	@Test
	void testPosicionValorLanzaExc() {
		comp.posicionValor(90);
		
		NoSuchElementException exc = assertThrows(NoSuchElementException.class, () -> new Comprobaciones(enteros));
		assertEquals("El valor 8 no se encuentra en la tabla", exc.getMessage());
		
		
	}

}
