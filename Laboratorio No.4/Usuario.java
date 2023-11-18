// La clase Usuario representa a un usuario en el sistema
class Usuario {
    // Atributos de la clase Usuario
    private String usuario;         // Nombre de usuario
    private String contraseña;      // Contraseña del usuario
    private boolean esPremium;      // Indica si el usuario tiene una cuenta premium

    // Constructor de la clase Usuario
    public Usuario(String usuario, String contraseña, boolean esPremium) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.esPremium = esPremium;
    }

    // Método para verificar si el usuario es premium
    public boolean esPremium() {
        return esPremium;
    }

    // Método toString para obtener una representación de cadena del objeto Usuario
    @Override
    public String toString() {
        return "Usuario{" +
                "usuario='" + usuario + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", esPremium=" + esPremium +
                '}';
    }

    // Método para establecer una nueva contraseña del usuario
    public void setContraseña(String nuevaContraseña) {
    }
}
