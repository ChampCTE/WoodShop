package aa4_woodshops;
import java.util.ArrayList;
import java.util.List;

public class Tienda {
    private String nombre;
    private Zona zona;
    private List<ProductoEnTienda> productosEnTienda;

    public Tienda(String nombre, Zona zona) {
        this.nombre = nombre;
        this.zona = zona;
        this.productosEnTienda = new ArrayList<>();
    }
    // Enum de Zona
    public enum Zona { //Pongo publico porque quiero llegar hasta él.
        NORTE,
        SUR,
        ESTE,
        OESTE,
        CENTRO
    }
    // Getters
    public List<ProductoEnTienda> getInventario() {
        return productosEnTienda;
    }
    public String getNombre() {
        return nombre;
    }
    public Zona getZona() {
        return zona;
    }
    //Metodo para agregar un producto al inventario de la tienda
    public void agregarProducto(Producto producto, double precio, int stock, ProductoEnTienda productoEnTienda) {
        System.out.println("Agregando producto: " + producto.getClass().getSimpleName() +
                ", precio: " + precio + ", stock: " + stock + " a la tienda: " + nombre);
        ProductoEnTienda nuevoProducto = new ProductoEnTienda(producto, this, precio, stock);
        productosEnTienda.add(nuevoProducto);
    }
    @Override
    public String toString() {
        return new StringBuilder("Tienda: \n")
                .append("Nombre:").append(nombre)
                .append("Zona:").append(zona)
                .toString();
    }

}