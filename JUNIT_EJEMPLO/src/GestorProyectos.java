
import java.util.ArrayList;
import java.util.List;

public class GestorProyectos {

	// ==========================================
	// 1. CONDICIONALES COMPLEJOS (Combinación AND / OR)
	// ==========================================
	/**
	 * Valida si se puede dar por cerrada una tarea. Cuidado con la lógica: Si es
	 * "Completada", NO puede tener subtareas pendientes. Si el estado es
	 * "Cierre_Forzado", se cierra siempre.
	 */
	public boolean validarCierreTarea(String estado, boolean subtareasPendientes) {
		if (estado == null || estado.isEmpty()) {
			return false;
		}

		if (estado.equalsIgnoreCase("Completada")) {
			return !subtareasPendientes;
		} else if (estado.equalsIgnoreCase("Cierre_Forzado")) {
			return true;
		}

		return false;
	}

	// ==========================================
	// 2. COLECCIONES (Listas y Bucles)
	// ==========================================
	/**
	 * Genera una lista de desarrolladores usando un bucle.
	 */
	public List<String> asignarEquipo(int cantidad) {
		if (cantidad <= 0) {
			return new ArrayList<>(); // Retorna lista vacía, NO nulo
		}

		List<String> equipo = new ArrayList<>();
		for (int i = 1; i <= cantidad; i++) {
			equipo.add("Dev-" + i);
		}
		return equipo;
	}

	// ==========================================
	// 3. RETORNOS NULOS
	// ==========================================
	/**
	 * Busca un proyecto por ID. Puede no encontrarlo.
	 */
	public String buscarProyecto(int idProyecto) {
		if (idProyecto == 1)
			return "Proyecto Ubuntu";
		if (idProyecto == 2)
			return "Proyecto BIND9";

		return null; // Si no existe, devuelve null
	}
}
