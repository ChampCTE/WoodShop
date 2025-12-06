package aa4_woodshops;

public class DetallesFactura {
    private final int cantidad;
    private final ProductoEnTienda productoEnTienda;

    public DetallesFactura(int cantidad, ProductoEnTienda productoEnTienda) {
        this.cantidad = cantidad;
        this.productoEnTienda = productoEnTienda;
    }
    public int getCantidad() {
        return cantidad;
    }
    public ProductoEnTienda getProductoEnTienda() {
        return productoEnTienda;
    }

    @Override
    public String toString() {
        return new StringBuilder("Detalles de Factura:")
                .append("Cantidad: ").append(cantidad)
                .append("| Producto en Tienda: ").append(productoEnTienda)
                .toString();
    }
}
