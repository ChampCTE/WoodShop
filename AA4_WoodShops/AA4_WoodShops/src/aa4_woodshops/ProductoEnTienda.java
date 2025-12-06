package aa4_woodshops;

public class ProductoEnTienda {
    private Producto producto;
    private Tienda tienda;
    private double precio;
    private int stock;

    public ProductoEnTienda(Producto producto, Tienda tienda, double precio, int stock) {
        if (precio <= 0 || stock < 0) {
            throw new IllegalArgumentException("Precio y stock deben ser valores positivos");
        }
        this.producto = producto;
        this.tienda = tienda;
        this.precio = precio;
        this.stock = stock;
    }
    //Getters
    public Producto getProducto() {
        return producto;
    }
    public Tienda getTienda(){
        return tienda;
    }
    public double getPrecio(){
        return precio;
    }
    public int getStock(){
        return stock;
    }
    //Setters
    public void setProdcuto(Producto prodcuto) {
        this.producto = prodcuto;
    }
    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return new StringBuilder("Producto en Tienda:")
                .append("Producto:").append(producto)
                .append("| Tienda:").append(tienda)
                .append("| Precio:").append(precio)
                .append("| Stock:").append(stock)
                .toString();
    }
}