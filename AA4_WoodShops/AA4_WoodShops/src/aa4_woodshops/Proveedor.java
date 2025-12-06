package aa4_woodshops;

public class Proveedor {
    private String nif;
    private String nombre;

    public Proveedor(String nif, String nombre) {
        this.nif = nif;
        this.nombre = nombre;
    }
    //Getters
    public String getNif(){
        return nif;
    }
    public String getNombre(){
        return nombre;
    }
    //Setters
    public void setNif(String nif){
        this.nif = nif;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return new StringBuilder("Proveedor:")
                .append("NIF:").append(nif)
                .append("| Nombre:").append(nombre)
                .toString();
    }
}