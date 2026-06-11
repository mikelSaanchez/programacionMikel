import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SistemaTorneoTest {

	SistemaTorneo st;

	@BeforeEach
	void setUp() {
		st = new SistemaTorneo();
	}

	@Test
	void testValidarEstadoPartidoNull() {

		boolean comprobacion = st.validarEstadoPartido(null, false);

		assertFalse(comprobacion);
	}

	@Test
	void testValidarEstadoPartidoEmty() {

		boolean comprobacion = st.validarEstadoPartido("", false);

		assertFalse(comprobacion);
	}

	@Test
	void testValidarEstadoPartidoCompletada() {

		boolean comprobacion = st.validarEstadoPartido("Completada", false);

		assertFalse(comprobacion);
	}

	@Test
	void testValidarEstadoPartidoPendiente() {

		boolean comprobacion = st.validarEstadoPartido("Pendiente", true);

		assertTrue(comprobacion);

	}

	@Test
	void testValidarEstadoPartido() {

		boolean comprobacion = st.validarEstadoPartido("asdfasdf", false);

		assertFalse(comprobacion);
	}

	@Test
	void testDeterminarFase1() {

		String prueba = st.determinarFase(1);

		assertEquals("FASE_GRUPOS", prueba);
	}

	@Test
	void testDeterminarFase2() {

		String prueba = st.determinarFase(2);

		assertEquals("PLAYOFFS", prueba);
	}

	@Test
	void testDeterminarFase3() {

		String prueba = st.determinarFase(3);

		assertEquals("SEMIFINAL", prueba);
	}

	@Test
	void testDeterminarFase4() {

		String prueba = st.determinarFase(4);

		assertEquals("FINAL", prueba);
	}

	@Test
	void testDeterminarFaseDefault() {

		String prueba = st.determinarFase(5);

		assertEquals("JORNADA_INVALIDA", prueba);
	}

	@Test
	void testCalcularPuntosPorVictoria0() {

		int[] prueba = st.calcularPuntosPorVictoria(-5);

		assertArrayEquals(new int[0], prueba);

	}

	@Test
	void testCalcularPuntosPorVictoriaPrincipioMedioFin() {

		int[] prueba = st.calcularPuntosPorVictoria(5);

		// Comprobamos al PRINCIPIO (índice 0)
		assertEquals(3, prueba[0]);

		// Comprobamos en el MEDIO (índice 2, que es la mitad de 5)
		assertEquals(3, prueba[2]);

		// Comprobamos al FINAL (índice 4, que equivale a prueba.length - 1)
		assertEquals(3, prueba[4]);
	}

	@Test
	void testInscribirEquipoNull() {

		IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> st.inscribirEquipo(null, 6));

		assertEquals("El nombre del equipo no puede estar vacío", exc.getMessage());

	}

	@Test
	void testInscribirEquipoEmty() {

		IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> st.inscribirEquipo("", 6));

		assertEquals("El nombre del equipo no puede estar vacío", exc.getMessage());

	}

	@Test
	void testInscribirEquipoNumJug() {

		IllegalStateException exc = assertThrows(IllegalStateException.class, () -> st.inscribirEquipo("Madrid", 4));

		assertEquals("Se requieren al menos 5 jugadores para competir", exc.getMessage());

	}

}
