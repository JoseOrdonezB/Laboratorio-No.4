// La clase Reserva representa una reserva de vuelo
class Reserva {
    // Atributos de la clase Reserva
    private String fechaViaje;          // Fecha de viaje asociada a la reserva
    private boolean esIdaYVuelta;        // Indica si la reserva es para un vuelo de ida y vuelta
    private int cantidadBoletos;         // Cantidad de boletos reservados
    private String aerolinea;            // Nombre de la aerolínea asociada a la reserva
    private Usuario usuario;             // Usuario asociado a la reserva

    // Constructor de la clase Reserva
    public Reserva(String fechaViaje, boolean esIdaYVuelta, int cantidadBoletos, String aerolinea, Usuario usuario) {
        this.fechaViaje = fechaViaje;
        this.esIdaYVuelta = esIdaYVuelta;
        this.cantidadBoletos = cantidadBoletos;
        this.aerolinea = aerolinea;
        this.usuario = usuario;
    }

    // Método para imprimir la información de la reserva
    public void imprimirInformacion() {
        System.out.println("Información de la reserva:");
        System.out.println("Fecha de viaje: " + fechaViaje);
        System.out.println("Tipo de vuelo: " + (esIdaYVuelta ? "Ida y vuelta" : "Solo ida"));
        System.out.println("Cantidad de boletos: " + cantidadBoletos);
        System.out.println("Aerolínea: " + aerolinea);
        System.out.println("Nombre del usuario: " + usuario);
    }

    // Método toString para obtener una representación de cadena del objeto Reserva
    @Override
    public String toString() {
        return "Reserva{" +
                "fechaViaje='" + fechaViaje + '\'' +
                ", esIdaYVuelta=" + esIdaYVuelta +
                ", cantidadBoletos=" + cantidadBoletos +
                ", aerolinea='" + aerolinea + '\'' +
                ", usuario=" + usuario +
                '}';
    }
}
