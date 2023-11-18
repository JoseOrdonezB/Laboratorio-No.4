// La clase SistemaReservas gestiona un sistema simple de reservas de vuelo
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaReservas {
    // Atributos de la clase SistemaReservas
    private static Scanner scanner = new Scanner(System.in);
    private static List<Confirmacion> confirmaciones = new ArrayList<>();
    private static Usuario usuarioAutenticado;

    // Método principal que inicia el sistema de reservas
    public static void main(String[] args) {
        usuarioAutenticado = autenticarUsuario();

        // Verifica si la autenticación fue exitosa
        if (usuarioAutenticado != null) {
            while (true) {
                mostrarMenu();
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea después de leer un número

                // Switch para manejar las diferentes opciones del menú
                switch (opcion) {
                    case 1:
                        registrarNuevoUsuario();
                        break;
                    case 2:
                        realizarReserva();
                        break;
                    case 3:
                        realizarConfirmacion();
                        break;
                    case 4:
                        modificarPerfil();
                        break;
                    case 5:
                        System.out.println("Saliendo del sistema. ¡Hasta luego!");
                        guardarConfirmacionesEnCSV();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
            }
        } else {
            System.out.println("Autenticación fallida. Saliendo del sistema.");
        }
    }

    // Método para autenticar al usuario
    private static Usuario autenticarUsuario() {
        System.out.print("Ingrese su usuario: ");
        String usuario = scanner.nextLine();

        System.out.print("Ingrese su contraseña: ");
        String contraseña = scanner.nextLine();

        // Lógica de autenticación (puedes personalizar según tus necesidades)
        if (usuario.equals("user1") && contraseña.equals("pass1")) {
            return new Usuario(usuario, contraseña, false);
        } else if (usuario.equals("user2") && contraseña.equals("pass2")) {
            return new Usuario(usuario, contraseña, true);
        } else {
            System.out.println("Autenticación fallida.");
            return null;
        }
    }

    // Método para mostrar el menú de opciones
    private static void mostrarMenu() {
        System.out.println("\nMenú de opciones:");
        System.out.println("1. Modo Registro");
        System.out.println("2. Modo Reservas");
        System.out.println("3. Modo Confirmación");
        System.out.println("4. Modo Perfil");
        System.out.println("5. Salir");

        // Verifica si el usuario autenticado es premium para mostrar opción adicional
        if (usuarioAutenticado != null && usuarioAutenticado.esPremium()) {
            System.out.println("6. Opción adicional para usuarios premium");
        }
    }

    // Método para registrar a un nuevo usuario
    private static void registrarNuevoUsuario() {
        System.out.println("Registro de nuevo usuario:");

        // Solicita información adicional del usuario si es necesario
        System.out.print("Ingrese un nuevo nombre de usuario: ");
        String nuevoUsuario = scanner.nextLine();

        System.out.print("Ingrese una nueva contraseña: ");
        String nuevaContraseña = scanner.nextLine();

        // Lógica para crear una nueva instancia de Usuario y almacenarla
        Usuario nuevoUsuarioObj = new Usuario(nuevoUsuario, nuevaContraseña, false);
        System.out.println("Usuario registrado con éxito: " + nuevoUsuarioObj);
    }

    // Método para realizar una reserva
    private static void realizarReserva() {
        System.out.println("Modo Reservas:");

        // Solicita información para la reserva
        System.out.print("Ingrese la fecha de viaje: ");
        String fechaViaje = scanner.nextLine();

        System.out.print("¿Es un vuelo de ida y vuelta? (Sí/No): ");
        boolean esIdaYVuelta = scanner.nextLine().equalsIgnoreCase("Sí");

        System.out.print("Ingrese la cantidad de boletos: ");
        int cantidadBoletos = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea después de leer un número

        System.out.print("Ingrese la aerolínea: ");
        String aerolinea = scanner.nextLine();

        // Crea una nueva instancia de Reserva y muestra la información
        Reserva nuevaReserva = new Reserva(fechaViaje, esIdaYVuelta, cantidadBoletos, aerolinea, usuarioAutenticado);
        nuevaReserva.imprimirInformacion();
    }

    // Método para realizar una confirmación
    private static void realizarConfirmacion() {
        System.out.println("Modo Confirmación:");

        // Solicita información para la confirmación
        System.out.print("Ingrese el número de tarjeta: ");
        String numeroTarjeta = scanner.nextLine();

        System.out.print("Ingrese la cantidad de cuotas: ");
        int cantidadCuotas = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea después de leer un número

        System.out.print("Ingrese la clase de vuelo (Coach/Primera Clase): ");
        String claseVuelo = scanner.nextLine();

        // Crea una nueva instancia de Confirmacion y la almacena
        Confirmacion nuevaConfirmacion = new Confirmacion(numeroTarjeta, cantidadCuotas, claseVuelo, 1, usuarioAutenticado);
        nuevaConfirmacion.imprimirItinerario();
        confirmaciones.add(nuevaConfirmacion);
        System.out.println("Confirmación realizada con éxito.");
    }

    // Método para modificar el perfil del usuario
    private static void modificarPerfil() {
        System.out.println("Modo Perfil:");

        // Permite al usuario modificar su perfil
        System.out.println("1. Cambiar contraseña");
        System.out.println("2. Volver al menú principal");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea después de leer un número

        switch (opcion) {
            case 1:
                System.out.print("Ingrese la nueva contraseña: ");
                String nuevaContraseña = scanner.nextLine();
                usuarioAutenticado.setContraseña(nuevaContraseña);
                System.out.println("Contraseña cambiada con éxito.");
                break;
            case 2:
                break; // No hacer nada, simplemente volver al menú principal
            default:
                System.out.println("Opción no válida.");
        }
    }

    // Método para guardar las confirmaciones en un archivo CSV
    private static void guardarConfirmacionesEnCSV() {
        // Lógica para guardar las confirmaciones en un archivo CSV
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("confirmaciones.csv"))) {
            for (Confirmacion confirmacion : confirmaciones) {
                writer.write(confirmacion.toString());
                writer.newLine();
            }
            System.out.println("Confirmaciones guardadas en el archivo CSV.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
