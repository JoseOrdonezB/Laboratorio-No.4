// La clase Confirmacion implementa la interfaz FuncionalidadPremium
class Confirmacion implements FuncionalidadPremium {
    // Atributos de la clase Confirmacion
    private String numeroTarjeta;    // Número de tarjeta asociado a la confirmación
    private int cantidadCuotas;       // Cantidad de cuotas seleccionadas
    private String claseVuelo;        // Clase de vuelo (Coach, Primera Clase, etc.)
    private int cantidadMaletas;      // Cantidad de maletas asociadas a la confirmación
    private Usuario usuario;          // Usuario asociado a la confirmación

    // Constructor de la clase Confirmacion
    public Confirmacion(String numeroTarjeta, int cantidadCuotas, String claseVuelo, int cantidadMaletas, Usuario usuario) {
        this.numeroTarjeta = numeroTarjeta;
        this.cantidadCuotas = cantidadCuotas;
        this.claseVuelo = claseVuelo;
        this.cantidadMaletas = cantidadMaletas;
        this.usuario = usuario;
    }

    // Método para imprimir el itinerario de la confirmación
    public void imprimirItinerario() {
        System.out.println("Itinerario de confirmación:");
        // Imprimir información del itinerario
    }

    // Método de la interfaz FuncionalidadPremium para seleccionar un asiento
    @Override
    public void seleccionarAsiento() {
        System.out.println("Asiento seleccionado.");
    }

    // Método de la interfaz FuncionalidadPremium para definir la cantidad de maletas
    @Override
    public void definirCantidadMaletas() {
        System.out.println("Cantidad de maletas definida: " + cantidadMaletas);
    }

    // Método toString para obtener una representación de cadena del objeto Confirmacion
    @Override
    public String toString() {
        return "Confirmacion{" +
                "numeroTarjeta='" + numeroTarjeta + '\'' +
                ", cantidadCuotas=" + cantidadCuotas +
                ", claseVuelo='" + claseVuelo + '\'' +
                ", cantidadMaletas=" + cantidadMaletas +
                ", usuario=" + usuario +
                '}';
    }
}