import java.util.Scanner;
import java.time.Year;

// NOTA: Recuerda cambiar el nombre de la clase al formato requerido: Apellido1Apellido2Nombre
public class CalasanzGamesApp { 
    
    // Scanner global para toda la aplicación
    private static Scanner scanner = new Scanner(System.in); 
    
    // Almacenamiento simple para Opción 2.1 (Añadir juegos)
    private static int totalJuegosGuardados = 0;
    private static double totalDineroGastado = 0.0;

    public static void main(String[] args) {
        // Establecer el Locale para manejar correctamente los decimales (coma/punto)
        // Aunque no es una instrucción del enunciado, es buena práctica para I/O numérico
        // scanner.useLocale(java.util.Locale.US); // Usar punto como separador decimal
        
        mostrarMenuPrincipal();
    }

    /**
     * Muestra el menú principal de la aplicación y gestiona la selección.
     * Repite hasta que el usuario selecciona 'Salir' (opción 6).
     */
    private static void mostrarMenuPrincipal() {
        int opcionSeleccionada = -1;
        
        // Bucle principal del menú
        while (opcionSeleccionada != 6) { 
            System.out.println("\n=== BIBLIOTECA Calasanz Games ==="); // [cite: 30]
            System.out.println("1. Gestión de Usuarios"); // [cite: 31]
            System.out.println("2. Catálogo de Juegos"); // [cite: 32]
            System.out.println("3. Sistema de Valoraciones"); // [cite: 33]
            System.out.println("4. Estadísticas y Reportes"); // [cite: 34]
            System.out.println("5. Calculadora de Descuentos"); // [cite: 35]
            System.out.println("6. Salir"); // [cite: 36]
            System.out.print("Selecciona una opción: ");
            
            // Validación y control de entrada (que no sean letras) [cite: 29]
            try {
                // Verificar si hay un entero disponible
                if (scanner.hasNextInt()) {
                    opcionSeleccionada = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                } else {
                    String input = scanner.nextLine();
                    System.out.println("Entrada inválida. Por favor, introduce un número.");
                    opcionSeleccionada = -1; // Fuerza la repetición del bucle
                    continue;
                }

                // Llamar al método correspondiente a la opción seleccionada
                switch (opcionSeleccionada) {
                    case 1:
                        gestionUsuarios(); // [cite: 37]
                        break;
                    case 2:
                        catalogoJuegos(); // [cite: 73]
                        break;
                    case 3:
                        sistemaValoraciones(); // [cite: 103]
                        break;
                    case 4:
                        estadisticasYReportes(); // [cite: 125]
                        break;
                    case 5:
                        calculadoraDescuentos(); // [cite: 145]
                        break;
                    case 6:
                        System.out.println("¡Gracias por usar Calasanz Games! Saliendo del programa..."); // [cite: 36, 162]
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, selecciona un número del 1 al 6.");
                }
            } catch (Exception e) {
                System.out.println("Error inesperado en el menú principal: " + e.getMessage());
                scanner.nextLine(); // Limpiar el buffer si el error no lo hizo
            }
        }
    }

    // --- OPCIÓN 1: GESTIÓN DE USUARIOS --- [cite: 37]
    
    /**
     * Muestra el submenú de Gestión de Usuarios y gestiona la selección.
     * Repite hasta que el usuario selecciona 'Volver al menú principal' (opción 3).
     */
    private static void gestionUsuarios() {
        int opcionSubmenu = -1;
        
        while (opcionSubmenu != 3) { // [cite: 39]
            System.out.println("\n--- GESTIÓN DE USUARIOS ---"); // [cite: 40]
            System.out.println("1. Crear nuevo usuario"); // [cite: 41]
            System.out.println("2. Calcular edad del usuario"); // [cite: 42]
            System.out.println("3. Volver al menú principal"); // [cite: 43]
            System.out.print("Selecciona una opción: ");
            
            try {
                if (scanner.hasNextInt()) {
                    opcionSubmenu = scanner.nextInt();
                    scanner.nextLine(); 
                } else {
                    String input = scanner.nextLine();
                    System.out.println("Entrada inválida. Por favor, introduce un número."); // [cite: 39]
                    opcionSubmenu = -1; 
                    continue;
                }

                switch (opcionSubmenu) {
                    case 1:
                        crearNuevoUsuario(); // Opción 1.1 [cite: 50]
                        break;
                    case 2:
                        calcularEdadUsuarioPEGI(); // Opción 1.2 [cite: 65]
                        break;
                    case 3:
                        System.out.println("Volviendo al menú principal...");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, selecciona un número del 1 al 3.");
                }
            } catch (Exception e) {
                System.out.println("Error inesperado en el submenú de Usuarios: " + e.getMessage());
                scanner.nextLine(); 
            }
        }
    }
    
    /**
     * Opción 1.1: Crear nuevo usuario. Pide datos, valida, calcula ID, edad, tipo, y muestra el resumen.
     */
    private static void crearNuevoUsuario() { // [cite: 50]
        System.out.println("\n--- Opción 1.1: Crear nuevo usuario ---");
        
        String nombreUsuario = "";
        int anoNacimiento = 0;
        String plataformaFavorita = "";
        boolean esPremium = false;
        
        // 1. Pedir Nombre
        System.out.print("Nombre: "); // [cite: 58]
        nombreUsuario = scanner.nextLine().trim(); 

        // 2. Pedir Año de Nacimiento (Validación)
        boolean anoValido = false;
        while (!anoValido) {
            System.out.print("Año de nacimiento: "); // [cite: 59]
            try {
                if (scanner.hasNextInt()) {
                    anoNacimiento = scanner.nextInt();
                    scanner.nextLine(); 
                    // Validar rango (asumiendo que la edad debe ser razonable, no hay un rango estricto aquí)
                    int anoActual = Year.now().getValue();
                    if (anoNacimiento >= 1900 && anoNacimiento <= anoActual) {
                        anoValido = true;
                    } else {
                        System.out.println("Año de nacimiento inválido. Debe estar entre 1900 y " + anoActual + ".");
                    }
                } else {
                    System.out.println("Entrada inválida. Introduce un número para el año.");
                    scanner.nextLine(); 
                }
            } catch (Exception e) {
                System.out.println("Error al leer el año: " + e.getMessage()); // Captura de excepciones [cite: 52]
                scanner.nextLine(); 
            }
        }

        // 3. Pedir Plataforma Favorita (Validación: PC, PlayStation, Xbox, Nintendo)
        String[] plataformasValidas = {"PC", "PLAYSTATION", "XBOX", "NINTENDO"};
        boolean plataformaValida = false;
        while (!plataformaValida) {
            System.out.print("Plataforma favorita (PC, PlayStation, Xbox, Nintendo): "); // [cite: 60]
            plataformaFavorita = scanner.nextLine().trim().toUpperCase(); 
            
            for (String p : plataformasValidas) {
                if (p.equals(plataformaFavorita)) {
                    plataformaValida = true;
                    break;
                }
            }
            
            if (!plataformaValida) {
                System.out.println("Plataforma incorrecta"); // [cite: 60]
            }
        }
        
        // 4. Pedir Suscripción Premium (S/N)
        boolean premiumValido = false;
        while (!premiumValido) {
            System.out.print("¿Tiene suscripción premium? (S/N): "); // [cite: 61]
            String respuesta = scanner.nextLine().trim().toUpperCase();
            if (respuesta.equals("S")) {
                esPremium = true;
                premiumValido = true;
            } else if (respuesta.equals("N")) {
                esPremium = false;
                premiumValido = true;
            } else {
                System.out.println("Respuesta inválida. Por favor, introduce 'S' o 'N'.");
            }
        }
        
        // --- Procesamiento ---
        
        // 5. Crear ID de usuario 
        String idUsuario = crearIDUsuario(nombreUsuario, anoNacimiento);
        
        // 6. Calcular edad del jugador (usando método con parámetro y return) 
        int edadJugador = calcularEdad(anoNacimiento); 
        
        // 7. Determinar Tipo de usuario 
        String tipoUsuario = determinarTipoUsuario(edadJugador);

        // --- Mostrar Resultado --- [cite: 57]
        System.out.println("ID Usuario: " + idUsuario); // [cite: 62]
        System.out.println("Edad: " + edadJugador); // [cite: 63]
        System.out.println("Tipo de usuario: " + tipoUsuario); // [cite: 64]
        // Mostrar la plataforma original (no la mayúscula usada para validación)
        System.out.println("Plataforma favorita: " + plataformaFavorita.charAt(0) + plataformaFavorita.substring(1).toLowerCase()); 
        System.out.println("Premium: " + (esPremium ? "Si" : "No")); // [cite: 64]
    }
    
    /**
     * Crea el ID de usuario según el formato: 3 primeras letras del nombre en mayúsculas + "GAME" + año de nacimiento.
     * @param nombre El nombre del usuario.
     * @param anoNacimiento El año de nacimiento del usuario.
     * @return El ID de usuario generado.
     */
    private static String crearIDUsuario(String nombre, int anoNacimiento) { // 
        String iniciales = "";
        if (nombre.length() >= 3) {
            iniciales = nombre.substring(0, 3).toUpperCase();
        } else {
            iniciales = nombre.toUpperCase() + "X".repeat(3 - nombre.length()); // Rellenar si el nombre es corto
        }
        return iniciales + "GAME" + anoNacimiento;
    }

    /**
     * Calcula la edad actual del usuario.
     * @param anoNacimiento El año de nacimiento del usuario.
     * @return La edad actual en años.
     */
    private static int calcularEdad(int anoNacimiento) { // 
        int anoActual = Year.now().getValue();
        return anoActual - anoNacimiento;
    }
    
    /**
     * Determina el tipo de usuario según la edad.
     * @param edad La edad del usuario.
     * @return La clasificación del tipo de usuario.
     */
    private static String determinarTipoUsuario(int edad) { // 
        if (edad >= 0 && edad <= 17) {
            return "Junior Game";
        } else if (edad >= 18 && edad <= 30) {
            return "Pro Gamer";
        } else { // 31+
            return "Master Gamer";
        }
    }
    
    /**
     * Opción 1.2: Calcular edad del usuario. Pide año de nacimiento, valida, calcula edad y muestra la etiqueta PEGI.
     */
    private static void calcularEdadUsuarioPEGI() { // [cite: 65]
        System.out.println("\n--- Opción 1.2: Calcular edad del usuario ---");
        int anoNacimiento = 0;
        boolean anoValido = false;
        
        // 1. Pedir y validar Año de Nacimiento (entre 1920 y 2025) 
        while (!anoValido) {
            System.out.print("Introduce el año de nacimiento: "); // [cite: 71]
            try {
                if (scanner.hasNextInt()) {
                    anoNacimiento = scanner.nextInt();
                    scanner.nextLine(); 
                    if (anoNacimiento >= 1920 && anoNacimiento <= 2025) { // Rango de validación 
                        anoValido = true;
                    } else {
                        System.out.println("Año inválido. Debe estar entre 1920 y 2025.");
                    }
                } else {
                    System.out.println("Entrada inválida. Introduce un número.");
                    scanner.nextLine(); 
                }
            } catch (Exception e) {
                System.out.println("Error al leer el año: " + e.getMessage()); // Captura de excepciones [cite: 70]
                scanner.nextLine(); 
            }
        }
        
        // 2. Calcular edad 
        int edad = calcularEdad(anoNacimiento); 
        
        // 3. Determinar etiqueta PEGI [cite: 67, 68]
        String etiquetaPegi = determinarPegi(edad);

        // 4. Mostrar resultado [cite: 69]
        System.out.println("Edad: " + edad); // [cite: 71]
        System.out.println("Puede jugar a juegos con etiqueta: " + etiquetaPegi); // [cite: 72]
    }
    
    /**
     * Determina la etiqueta PEGI máxima a la que puede jugar un usuario según su edad.
     * @param edad La edad del usuario.
     * @return La etiqueta PEGI.
     */
    private static String determinarPegi(int edad) { // 
        if (edad >= 18) {
            return "PEGI 18";
        } else if (edad >= 16) {
            return "PEGI 16";
        } else if (edad >= 12) {
            return "PEGI 12";
        } else if (edad >= 7) {
            return "PEGI 7";
        } else { // Para el resto (< 7)
            return "PEGI 3";
        }
    }
    
    // --- OPCIÓN 2: CATÁLOGO DE JUEGOS --- [cite: 73]
    
    /**
     * Muestra el submenú de Catálogo de Juegos y gestiona la selección.
     * Repite hasta que el usuario selecciona 'Volver al menú principal' (opción 3).
     */
    private static void catalogoJuegos() {
        int opcionSubmenu = -1;
        
        while (opcionSubmenu != 3) { // [cite: 75]
            System.out.println("\n--- CATÁLOGO DE JUEGOS ---"); // [cite: 76]
            System.out.println("1. Añadir juegos a la biblioteca"); // [cite: 77]
            System.out.println("2. Calcular espacio total ocupado"); // [cite: 77]
            System.out.println("3. Volver al menú principal"); // [cite: 77]
            System.out.print("Selecciona una opción: ");
            
            try {
                if (scanner.hasNextInt()) {
                    opcionSubmenu = scanner.nextInt();
                    scanner.nextLine(); 
                } else {
                    String input = scanner.nextLine();
                    System.out.println("Entrada inválida. Por favor, introduce un número."); // [cite: 75]
                    opcionSubmenu = -1; 
                    continue;
                }

                switch (opcionSubmenu) {
                    case 1:
                        anadirJuegos(); // Opción 2.1 [cite: 78]
                        break;
                    case 2:
                        calcularEspacioOcupado(); // Opción 2.2 [cite: 91]
                        break;
                    case 3:
                        System.out.println("Volviendo al menú principal...");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, selecciona un número del 1 al 3.");
                }
            } catch (Exception e) {
                System.out.println("Error inesperado en el submenú de Catálogo: " + e.getMessage());
                scanner.nextLine(); 
            }
        }
    }
    
    /**
     * Opción 2.1: Añadir juegos a la biblioteca. Pregunta cuántos, pide datos (nombre, tamaño, precio) y muestra totales.
     */
    private static void anadirJuegos() { // [cite: 78]
        System.out.println("\n--- Opción 2.1: Añadir juegos a la biblioteca ---");
        int cantidadJuegos = 0;
        
        // 1. Pedir cantidad de juegos [cite: 79]
        boolean cantidadValida = false;
        while (!cantidadValida) {
            System.out.print("¿Cuántos juegos quieres añadir?: "); // [cite: 87]
            try {
                if (scanner.hasNextInt()) {
                    cantidadJuegos = scanner.nextInt();
                    scanner.nextLine(); 
                    if (cantidadJuegos > 0) {
                        cantidadValida = true;
                    } else {
                        System.out.println("Debes introducir un número positivo de juegos.");
                    }
                } else {
                    System.out.println("Entrada inválida. Introduce un número.");
                    scanner.nextLine(); 
                }
            } catch (Exception e) {
                System.out.println("Error al leer la cantidad: " + e.getMessage()); // Captura de excepciones [cite: 81]
                scanner.nextLine(); 
            }
        }
        
        // 2. Bucle para pedir datos de cada juego
        for (int i = 0; i < cantidadJuegos; i++) {
            System.out.print("Nombre del juego: "); // [cite: 79, 87]
            String nombreJuego = scanner.nextLine().trim();
            
            double tamanoGB = 0.0;
            boolean tamanoValido = false;
            while (!tamanoValido) {
                System.out.print("Tamaño en GB de " + nombreJuego + ": "); // [cite: 80, 87]
                try {
                    if (scanner.hasNextDouble()) {
                        tamanoGB = scanner.nextDouble();
                        scanner.nextLine(); 
                        if (tamanoGB > 0) {
                            tamanoValido = true;
                        } else {
                            System.out.println("El tamaño debe ser un valor positivo.");
                        }
                    } else {
                        System.out.println("Entrada inválida. Introduce un número para el tamaño.");
                        scanner.nextLine(); 
                    }
                } catch (Exception e) {
                    System.out.println("Error al leer el tamaño: " + e.getMessage()); // Captura de excepciones [cite: 81]
                    scanner.nextLine(); 
                }
            }
            
            double precio = 0.0;
            boolean precioValido = false;
            while (!precioValido) {
                System.out.print("Precio de " + nombreJuego + ": "); // [cite: 80, 87, 89]
                try {
                    if (scanner.hasNextDouble()) {
                        precio = scanner.nextDouble();
                        scanner.nextLine(); 
                        if (precio >= 0) {
                            precioValido = true;
                        } else {
                            System.out.println("El precio no puede ser negativo.");
                        }
                    } else {
                        System.out.println("Entrada inválida. Introduce un número para el precio.");
                        scanner.nextLine(); 
                    }
                } catch (Exception e) {
                    System.out.println("Error al leer el precio: " + e.getMessage()); // Captura de excepciones [cite: 81]
                    scanner.nextLine(); 
                }
            }
            
            // Acumular totales
            totalJuegosGuardados++;
            totalDineroGastado += precio;
        }
        
        // 3. Mostrar resultado [cite: 80]
        System.out.println("Total de juegos: " + totalJuegosGuardados); // [cite: 90]
        System.out.printf("Total gastado: %.1f€\n", totalDineroGastado); // [cite: 90]
    }
    
    /**
     * Opción 2.2: Calcular espacio total ocupado. Pide memoria total, cantidad de juegos a instalar, y suma sus tamaños.
     * Se detiene si supera la memoria disponible.
     */
    private static void calcularEspacioOcupado() { // [cite: 91]
        System.out.println("\n--- Opción 2.2: Calcular espacio total ocupado ---");
        double memoriaTotalGB = 0.0;
        int cantidadJuegosAInstalar = 0;
        double espacioOcupado = 0.0;
        
        // 1. Pedir memoria disponible [cite: 92]
        boolean memoriaValida = false;
        while (!memoriaValida) {
            System.out.print("Memoria disponible en GB: "); // [cite: 96]
            try {
                if (scanner.hasNextDouble()) {
                    memoriaTotalGB = scanner.nextDouble();
                    scanner.nextLine(); 
                    if (memoriaTotalGB > 0) {
                        memoriaValida = true;
                    } else {
                        System.out.println("La memoria debe ser un valor positivo.");
                    }
                } else {
                    System.out.println("Entrada inválida. Introduce un número para la memoria.");
                    scanner.nextLine(); 
                }
            } catch (Exception e) {
                System.out.println("Error al leer la memoria: " + e.getMessage()); // Captura de excepciones [cite: 95]
                scanner.nextLine(); 
            }
        }
        
        // 2. Pedir cantidad de juegos a instalar [cite: 92]
        boolean cantidadValida = false;
        while (!cantidadValida) {
            System.out.print("¿Cuántos juegos vas a instalar?: "); // [cite: 97]
            try {
                if (scanner.hasNextInt()) {
                    cantidadJuegosAInstalar = scanner.nextInt();
                    scanner.nextLine(); 
                    if (cantidadJuegosAInstalar >= 0) {
                        cantidadValida = true;
                    } else {
                        System.out.println("La cantidad de juegos no puede ser negativa.");
                    }
                } else {
                    System.out.println("Entrada inválida. Introduce un número entero.");
                    scanner.nextLine(); 
                }
            } catch (Exception e) {
                System.out.println("Error al leer la cantidad: " + e.getMessage()); // Captura de excepciones [cite: 95]
                scanner.nextLine(); 
            }
        }
        
        // 3. Bucle para instalar juegos y verificar memoria 
        for (int i = 1; i <= cantidadJuegosAInstalar; i++) {
            double tamanoJuego = 0.0;
            boolean tamanoValido = false;
            while (!tamanoValido) {
                System.out.printf("Tamaño del juego %d en GB: ", i); // [cite: 98, 99]
                try {
                    if (scanner.hasNextDouble()) {
                        tamanoJuego = scanner.nextDouble();
                        scanner.nextLine(); 
                        if (tamanoJuego >= 0) {
                            tamanoValido = true;
                        } else {
                            System.out.println("El tamaño del juego no puede ser negativo.");
                        }
                    } else {
                        System.out.println("Entrada inválida. Introduce un número para el tamaño.");
                        scanner.nextLine(); 
                    }
                } catch (Exception e) {
                    System.out.println("Error al leer el tamaño: " + e.getMessage()); // Captura de excepciones [cite: 95]
                    scanner.nextLine(); 
                }
            }
            
            // Verificar si el nuevo juego supera la memoria 
            if (espacioOcupado + tamanoJuego > memoriaTotalGB) {
                System.out.println("¡Memoria superada! No puedes instalar más"); // [cite: 100]
                System.out.println("juegos."); // [cite: 101]
                break; // Parar el bucle
            }
            
            espacioOcupado += tamanoJuego;
        }
        
        // 4. Mostrar resultado [cite: 94]
        System.out.printf("Espacio total ocupado: %.1f GB\n", espacioOcupado); // [cite: 102]
    }
    
    // --- OPCIÓN 3: SISTEMA DE VALORACIONES --- [cite: 103]

    /**
     * Opción 3: Sistema de Valoraciones. Pide nombre del juego, cantidad de usuarios y sus notas (validando el rango).
     * Calcula la media y el resumen de la valoración.
     */
    private static void sistemaValoraciones() { // [cite: 103]
        System.out.println("\n--- OPCIÓN 3: SISTEMA DE VALORACIONES ---");
        
        System.out.print("Nombre del juego a valorar: "); // [cite: 107]
        String nombreJuego = scanner.nextLine().trim();
        
        int cantidadUsuarios = 0;
        double sumaValoraciones = 0.0;
        
        // 1. Pedir cantidad de usuarios [cite: 104]
        boolean cantidadValida = false;
        while (!cantidadValida) {
            System.out.printf("¿Cuántos usuarios han valorado el juego %s ?: ", nombreJuego); // [cite: 108]
            try {
                if (scanner.hasNextInt()) {
                    cantidadUsuarios = scanner.nextInt();
                    scanner.nextLine(); 
                    if (cantidadUsuarios >= 0) {
                        cantidadValida = true;
                    } else {
                        System.out.println("La cantidad de usuarios no puede ser negativa.");
                    }
                } else {
                    System.out.println("Entrada inválida. Introduce un número entero.");
                    scanner.nextLine(); 
                }
            } catch (Exception e) {
                System.out.println("Error al leer la cantidad: " + e.getMessage()); // Captura de excepciones [cite: 106]
                scanner.nextLine(); 
            }
        }
        
        // 2. Bucle para pedir y validar cada nota 
        for (int i = 1; i <= cantidadUsuarios; i++) {
            double valoracion = 0.0;
            boolean notaValida = false;
            while (!notaValida) {
                System.out.printf("Valoración del usuario %d (0-10): ", i); // [cite: 109, 110, 111]
                try {
                    if (scanner.hasNextDouble()) {
                        valoracion = scanner.nextDouble();
                        scanner.nextLine(); 
                        
                        // Validación de rango (0 a 10)
                        if (valoracion >= 0.0 && valoracion <= 10.0) {
                            notaValida = true;
                            sumaValoraciones += valoracion;
                        } else {
                            System.out.println("Nota inválida. Debe estar entre 0 y 10."); // [cite: 113]
                        }
                    } else {
                        System.out.println("Entrada inválida. Introduce un número."); // [cite: 114]
                        scanner.nextLine(); 
                    }
                } catch (Exception e) {
                    System.out.println("Error inesperado al leer la valoración: " + e.getMessage()); // Captura de excepciones [cite: 106]
                    scanner.nextLine(); 
                }
            }
        }
        
        // 3. Calcular nota media y resumen 
        double notaMedia = 0.0;
        if (cantidadUsuarios > 0) {
            notaMedia = sumaValoraciones / cantidadUsuarios;
        }
        
        String resumenValoracion = determinarResumenValoracion(notaMedia);

        // 4. Mostrar resultado 
        System.out.println("Nota media: " + notaMedia); // [cite: 116]
        System.out.println("Resumen: " + resumenValoracion); // [cite: 117]
    }
    
    /**
     * Determina el resumen de la valoración del juego según la nota media.
     * @param notaMedia La nota media del juego.
     * @return El resumen de la valoración.
     */
    private static String determinarResumenValoracion(double notaMedia) { // 
        if (notaMedia >= 9.5 && notaMedia <= 10.0) {
            return "Obra Maestra";
        } else if (notaMedia >= 8.5) {
            return "Excelente";
        } else if (notaMedia >= 7.0) {
            return "Bueno";
        } else if (notaMedia >= 5.0) {
            return "Aceptable";
        } else { // 0.0 - 4.9
            return "Decepcionante";
        }
    }

    // --- OPCIÓN 4: ESTADÍSTICAS Y REPORTES --- [cite: 125]
    
    /**
     * Muestra el submenú de Estadísticas y Reportes y gestiona la selección.
     * Repite hasta que el usuario selecciona 'Volver al menú principal' (opción 3).
     */
    private static void estadisticasYReportes() {
        int opcionSubmenu = -1;
        
        while (opcionSubmenu != 3) { // [cite: 127]
            System.out.println("\n--- ESTADÍSTICAS Y REPORTES ---"); // [cite: 128]
            System.out.println("1. Contador de juegos completados"); // [cite: 129]
            System.out.println("2. Calcular horas totales de juego"); // [cite: 129]
            System.out.println("3. Volver al menú principal"); // [cite: 129]
            System.out.print("Selecciona una opción: ");
            
            try {
                if (scanner.hasNextInt()) {
                    opcionSubmenu = scanner.nextInt();
                    scanner.nextLine(); 
                } else {
                    String input = scanner.nextLine();
                    System.out.println("Entrada inválida. Por favor, introduce un número."); // [cite: 127]
                    opcionSubmenu = -1; 
                    continue;
                }

                switch (opcionSubmenu) {
                    case 1:
                        contadorJuegosCompletados(); // Opción 4.1 [cite: 130]
                        break;
                    case 2:
                        calcularHorasTotalesJuego(); // Opción 4.2 [cite: 137]
                        break;
                    case 3:
                        System.out.println("Volviendo al menú principal...");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, selecciona un número del 1 al 3.");
                }
            } catch (Exception e) {
                System.out.println("Error inesperado en el submenú de Estadísticas: " + e.getMessage());
                scanner.nextLine(); 
            }
        }
    }

    /**
     * Opción 4.1: Contador de juegos completados. Pide un número y llama a un método recursivo para contarlos de forma descendente.
     */
    private static void contadorJuegosCompletados() { // [cite: 130]
        System.out.println("\n--- Opción 4.1: Contador de juegos completados ---");
        int numJuegos = 0;
        
        // 1. Pedir y validar número de juegos (no mayor de 500) [cite: 131, 135]
        boolean numValido = false;
        while (!numValido) {
            System.out.print("Número de juegos completados este año: "); // [cite: 136]
            try {
                if (scanner.hasNextInt()) {
                    numJuegos = scanner.nextInt();
                    scanner.nextLine(); 
                    if (numJuegos >= 0 && numJuegos <= 500) {
                        numValido = true;
                    } else if (numJuegos > 500) {
                        System.out.println("Número imposible. No puede ser mayor de 500."); // 
                    } else {
                        System.out.println("El número de juegos no puede ser negativo.");
                    }
                } else {
                    System.out.println("Entrada inválida. Introduce un número entero.");
                    scanner.nextLine(); 
                }
            } catch (Exception e) {
                System.out.println("Error al leer el número de juegos: " + e.getMessage()); // Captura de excepciones 
                scanner.nextLine(); 
            }
        }
        
        // 2. Llamar al método recursivo 
        contarJuegosRecursivo(numJuegos);
    }
    
    /**
     * Método recursivo para contar los juegos completados en orden descendente.
     * @param numero El número de juegos restantes por contar.
     */
    private static void contarJuegosRecursivo(int numero) { // 
        // Caso Base: cuando número == 0, no hace nada y finaliza 
        if (numero == 0) {
            return;
        }
        
        // Caso General: muestra el mensaje y llama recursivamente con numero - 1 [cite: 133, 134]
        System.out.println("Has completado el juego número: " + numero); // [cite: 136]
        contarJuegosRecursivo(numero - 1);
    }

    /**
     * Opción 4.2: Calcular horas totales de juego. Usa sobrecarga de métodos para calcular solo horas, o horas y minutos.
     */
    private static void calcularHorasTotalesJuego() { // [cite: 137]
        System.out.println("\n--- Opción 4.2: Calcular horas totales de juego ---");
        
        String opcionTipo = "";
        
        // 1. Pedir si solo horas (H) o horas y minutos (HM) [cite: 138]
        boolean opcionValida = false;
        while (!opcionValida) {
            System.out.print("¿Quieres introducir solo horas (H) o horas y minutos (HM)?: "); // [cite: 142]
            opcionTipo = scanner.nextLine().trim().toUpperCase();
            if (opcionTipo.equals("H") || opcionTipo.equals("HM")) {
                opcionValida = true;
            } else {
                System.out.println("Opción inválida. Introduce 'H' o 'HM'.");
            }
        }
        
        // 2. Pedir datos y llamar al método sobrecargado 
        double totalHoras = 0.0;
        
        try { // Captura de excepciones para las entradas numéricas [cite: 141]
            System.out.print("Horas: "); // [cite: 142]
            int horas = -1;
            if (scanner.hasNextInt()) {
                horas = scanner.nextInt();
                scanner.nextLine();
            } else {
                scanner.nextLine();
                throw new Exception("Entrada inválida para horas. Introduce un número entero.");
            }
            if (horas < 0) {
                throw new Exception("Las horas no pueden ser negativas.");
            }

            if (opcionTipo.equals("H")) {
                // Llama al método sobrecargado con un solo parámetro
                totalHoras = calcularHorasTotales(horas); // 
            } else if (opcionTipo.equals("HM")) {
                System.out.print("Minutos: "); // [cite: 143]
                int minutos = -1;
                if (scanner.hasNextInt()) {
                    minutos = scanner.nextInt();
                    scanner.nextLine();
                } else {
                    scanner.nextLine();
                    throw new Exception("Entrada inválida para minutos. Introduce un número entero.");
                }
                if (minutos < 0 || minutos >= 60) {
                    throw new Exception("Los minutos deben ser un valor positivo entre 0 y 59.");
                }
                // Llama al método sobrecargado con dos parámetros
                totalHoras = calcularHorasTotales(horas, minutos); // 
            }
            
            // 3. Mostrar el resultado [cite: 141]
            System.out.println("Total de horas jugadas: " + totalHoras); // [cite: 144]
            
        } catch (Exception e) {
            System.out.println("Error en el cálculo de horas: " + e.getMessage()); // [cite: 141]
        }
    }
    
    /**
     * Método sobrecargado para calcular el total de horas (solo horas).
     * @param horas Las horas introducidas.
     * @return Las horas, sin cambios.
     */
    private static double calcularHorasTotales(int horas) { // 
        return (double) horas;
    }
    
    /**
     * Método sobrecargado para calcular el total de horas (horas y minutos).
     * @param horas Las horas introducidas.
     * @param minutos Los minutos introducidos.
     * @return El total de horas (minutos convertidos y sumados).
     */
    private static double calcularHorasTotales(int horas, int minutos) { // 
        // Convierte minutos a horas y los suma
        return horas + (minutos / 60.0); 
    }

    // --- OPCIÓN 5: CALCULADORA DE DESCUENTOS --- [cite: 145]

    /**
     * Opción 5: Calculadora de Descuentos. Pide precio, descuento, y calcula el precio final, aplicando un descuento adicional
     * del 5% si el precio original es > 15€, llamando al método de descuento de forma recursiva.
     */
    private static void calculadoraDescuentos() { // [cite: 145]
        System.out.println("\n--- OPCIÓN 5: CALCULADORA DE DESCUENTOS ---");
        
        double precioOriginal = 0.0;
        double porcentajeDescuento = 0.0;
        
        try { // Captura de excepciones para todas las entradas [cite: 161]
            // 1. Pedir precio del juego
            System.out.print("Introduce el precio del juego: "); // [cite: 148]
            if (scanner.hasNextDouble()) {
                precioOriginal = scanner.nextDouble();
                scanner.nextLine();
            } else {
                scanner.nextLine();
                throw new Exception("Entrada inválida. Introduce un número para el precio.");
            }
            if (precioOriginal < 0) {
                throw new Exception("El precio no puede ser negativo.");
            }
            
            // 2. Pedir porcentaje de descuento (validación 0-100)
            boolean descuentoValido = false;
            while (!descuentoValido) {
                System.out.print("Introduce el porcentaje de descuento (0-100): "); // [cite: 149]
                if (scanner.hasNextDouble()) {
                    porcentajeDescuento = scanner.nextDouble();
                    scanner.nextLine();
                    if (porcentajeDescuento >= 0 && porcentajeDescuento <= 100) { // Validación 0-100 [cite: 146]
                        descuentoValido = true;
                    } else {
                        System.out.println("El descuento debe estar entre 0 y 100.");
                    }
                } else {
                    System.out.println("Entrada inválida. Introduce un número para el descuento.");
                    scanner.nextLine();
                }
            }
            
            // 3. Calcular precio final (el método gestiona el descuento adicional recursivo) [cite: 146]
            double precioFinal = calcularPrecioFinal(precioOriginal, porcentajeDescuento);
            
            // 4. Calcular ahorro total
            double ahorroTotal = precioOriginal - precioFinal;
            
            // 5. Mostrar resultados [cite: 160]
            System.out.printf("Precio original: %.1f€\n", precioOriginal); // [cite: 150]
            System.out.printf("Precio final: %.1f€\n", precioFinal); // [cite: 151]
            System.out.printf("Ahorro total: %.1f€\n", ahorroTotal); // [cite: 152]
            
        } catch (Exception e) {
            System.out.println("Error en la calculadora de descuentos: " + e.getMessage()); // [cite: 161]
        }
    }
    
    /**
     * Método recursivo para calcular el precio final con descuento.
     * Aplica el descuento inicial. Si el precio original > 15€, se llama recursivamente
     * con un descuento adicional del 5%.
     * @param precio El precio actual del juego.
     * @param descuento El porcentaje de descuento a aplicar.
     * @return El precio final.
     */
    private static double calcularPrecioFinal(double precio, double descuento) { // [cite: 146]
        double precioDescontado = precio * (1 - (descuento / 100.0));
        
        // Descuento adicional recursivo 
        if (precio > 15.0 && descuento != -5.0) { // Usamos -5.0 como marca para evitar recursión infinita
            // Aplicar el descuento adicional del 5%
            return calcularPrecioFinal(precioDescontado, 5.0); // Llamada recursiva con 5% adicional [cite: 160]
        }
        
        return precioDescontado;
    }
}