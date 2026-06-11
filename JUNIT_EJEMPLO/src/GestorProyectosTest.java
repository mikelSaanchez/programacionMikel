import static org.junit.jupiter.api.Assertions.*;
 
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GestorProyectosTest {

	GestorProyectos gt;

	@BeforeEach
	void setUp() {
		gt = new GestorProyectos();
	}

	@Test
	void testValidarCierreTareaNull() {
		boolean comprobar = gt.validarCierreTarea(null, false);

		assertFalse(comprobar);
	}

	@Test
	void testValidarCierreTareaEmty() {
		boolean comprobar = gt.validarCierreTarea("", false);

		assertFalse(comprobar);
	}

	@Test
	void testValidarCierreTareaCompletada() {
		boolean comprobar = gt.validarCierreTarea("Completada", false);

		assertTrue(comprobar);
	}

	@Test
	void testValidarCierreTareaCierre_Forzado() {
		boolean comprobar = gt.validarCierreTarea("Cierre_Forzado", false);

		assertTrue(comprobar);
	}

	@Test
	void testValidarCierreTarea_NoEntra() {
		boolean comprobar = gt.validarCierreTarea("Cierre", false);

		assertFalse(comprobar);
	}

	@Test
	void testAsignarEquipo_lista0() {
		List<String> comporbar = gt.asignarEquipo(-5);

		assertEquals(0, comporbar.size());
	}

	@Test
	void testAsignarEquipoPrincipioMedioFin() {
		// Arrange: Pedimos 5 integrantes
		// El bucle generará internamente: "Dev-1", "Dev-2", "Dev-3", "Dev-4", "Dev-5"
		List<String> resultado = gt.asignarEquipo(5);

		// 1. Siempre es buena idea comprobar primero el tamaño para que el test no
		// explote
		// al buscar índices que no existen.
		assertEquals(5, resultado.size(), "La lista debería tener 5 elementos");

		// 2. Comprobamos al PRINCIPIO (índice 0)
		assertEquals("Dev-1", resultado.get(0), "El primer elemento falla");

		// 3. Comprobamos en el MEDIO (índice 2, que es la mitad de 5)
		assertEquals("Dev-3", resultado.get(2), "El elemento del medio falla");

		// 4. Comprobamos al FINAL usando size() - 1 (esto le encanta a los profesores)
		int indiceFinal = resultado.size() - 1;
		assertEquals("Dev-5", resultado.get(indiceFinal), "El último elemento falla");
	}

	@Test
	void buscarProyecto1() {
		String comprobar = gt.buscarProyecto(1);

		assertEquals("Proyecto Ubuntu", comprobar);
	}

	@Test
	void buscarProyecto2() {
		String comprobar = gt.buscarProyecto(2);

		assertEquals("Proyecto BIND9", comprobar);
	}

	@Test
	void buscarProyectoNull() {
		String comprobar = gt.buscarProyecto(4);

		assertNull(comprobar);
	}

}
