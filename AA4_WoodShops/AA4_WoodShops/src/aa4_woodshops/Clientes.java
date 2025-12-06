package aa4_woodshops;

public abstract class Clientes {
    private String dni;
    private String nombre;
    private String apellido;
    private TipoCliente tipo;
    private String nif;

    public Clientes(String dni, String nombre, String apellido, String nif) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nif = nif;
    }
    // Getters
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getDni() {
        return dni;
    }
    public TipoCliente getTipo() {
        return tipo;
    }
    public String getNif() { return nif; }
    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo;
    }
    public void setNif(String nif) { this.nif = nif; }
    @Override
    public String toString() {
        return new StringBuilder("Clientes:")
                .append("DNI:").append(dni)
                .append("| Nombre:").append(nombre)
                .append("| NIF:").append(nif)
                .append("| Apellido:").append(apellido)
                .append("| Tipo:").append(tipo)
                .toString();
    }
    // Enumeración de TipoCliente
    public enum TipoCliente {
        PROFESIONALES,
        WOODFRIENDS
    }
    // SubClases. Tipos de Clientes.
    public static class ClienteProfesional extends Clientes {
        private double descuento;
        public ClienteProfesional(String nif, String nombre, String apellido, double descuento) {
            super(null, nombre, apellido, nif); // No puedo eliminar DNI, lo pongo NULL.
            this.descuento = descuento;
            setTipo(TipoCliente.PROFESIONALES);
        }
        public double getDescuento() { return descuento; }
        @Override
        public String toString() {
            return new StringBuilder("Cliente Profesional: ")
                    .append(super.toString())
                    .append(" | Descuento: ").append(descuento)
                    .toString();
        }
    }
    public static class ClienteWoodFriend extends Clientes {
        private int codigoSocio;
        public ClienteWoodFriend(String dni, String nombre, String apellido, int codigoSocio) {
            super(dni, nombre, apellido, null); // No puedo eliminar NIF, lo pongo NULL.
            this.codigoSocio = codigoSocio;
            setTipo(TipoCliente.WOODFRIENDS);
        }
        public int getCodigoSocio() { return codigoSocio; }
        @Override
        public String toString() {
            return new StringBuilder("Cliente WoodFriend: ")
                    .append(super.toString())
                    .append(" | Código de Socio: ").append(codigoSocio)
                    .toString();
        }
    }
}
