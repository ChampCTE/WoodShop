package aa4_woodshops;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Factura {
    private String numeroFactura;
    private Date fecha;
    private Clientes cliente;
    private Tienda tienda;

    private List<DetallesFactura> detalles;

    public Factura(String numeroFactura, Date fecha, Clientes cliente, Tienda tienda, List<DetallesFactura> detalles) {
        this.numeroFactura = numeroFactura;
        this.fecha = fecha;
        this.cliente = cliente;
        this.tienda = tienda;
        this.detalles = detalles;
    }
    //Getters
    public String getNumeroFactura() {
        return numeroFactura;
    }
    public Date getFecha() {
        return fecha;
    }
    public Clientes getClientes() {
        return cliente;
    }
    public Tienda getTienda() {
        return tienda;
    }
    public List<DetallesFactura> getDetalles() {
        return detalles;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Factura:");
        sb.append("Número Factura:").append(numeroFactura)
                .append("| Fecha:").append(fecha)
                .append("| Cliente:").append(cliente != null ? cliente : "Anónimo")
                .append("| Tienda:").append(tienda)
                .append("| Detalles:").append(detalles);
        return sb.toString();
    }
}
