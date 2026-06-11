public class SistemaTorneo {

	public boolean validarEstadoPartido(String estado, boolean reportadoPorAmbos) {
		if (estado == null || estado.isEmpty()) {
			return false;
		}

		if (estado.equalsIgnoreCase("Completada")) {

			return reportadoPorAmbos;
			
		} else if (estado.equalsIgnoreCase("Pendiente")) {
			return true;
		}

		return false;
	}

	public String determinarFase(int jornada) {
		switch (jornada) {
		case 1:
			return "FASE_GRUPOS";
		case 2:
			return "PLAYOFFS";
		case 3:
			return "SEMIFINAL";
		case 4:
			return "FINAL";
		default:
			return "JORNADA_INVALIDA";
		}
	}

	public int[] calcularPuntosPorVictoria(int cantidadVictorias) {
		if (cantidadVictorias < 0) {
			return new int[0]; 
		}

		int[] historialPuntos = new int[cantidadVictorias];

		
		for (int i = 0; i < cantidadVictorias; i++) {
			historialPuntos[i] = 3;
		}

		return historialPuntos;
	}

	public void inscribirEquipo(String nombreEquipo, int numeroJugadores) {
		if (nombreEquipo == null || nombreEquipo.trim().isEmpty()) {
			throw new IllegalArgumentException("El nombre del equipo no puede estar vacío");
		}

		if (numeroJugadores < 5) {
			throw new IllegalStateException("Se requieren al menos 5 jugadores para competir");
		}

	}
}