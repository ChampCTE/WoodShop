package aa4_woodshops;

public class Producto {
    private String codigo;
    private String descripcion;
    private Proveedor proveedor;

    public Producto(String codigo, String descripcion, Proveedor proveedor) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.proveedor = proveedor;
    }
    //Getters
    public String getCodigo() {
        return codigo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public Proveedor getProveedor() {
        return proveedor;
    }
    //Override para sobreescribir las herecias y mostramos los atributos.
    @Override
    public String toString() {
        return new StringBuilder("Producto:")
                .append("Código:").append(codigo)
                .append("| Descripcion:").append(descripcion)
                .append("| Proveedor:").append(proveedor)
                .toString();
    }
    //SubClase Tablero
    public static class Tablero extends Producto {
        private double altura;
        private double anchura;
        private TipoTablero tipo;

        public Tablero(String codigo, String descripcion, Proveedor proveedor, double altura, double anchura, TipoTablero tipo) {
            super(codigo, descripcion, proveedor);
            this.altura = altura;
            this.anchura = anchura;
            this.tipo = tipo;
        }
        public enum TipoTablero {
            AGLOMERADO,
            CONTRACHAPADO,
            MDF
        }
        @Override
        public String toString() {
            // Formato: Tablero{super=..., altura=..., anchura=..., tipo=...}
            return new StringBuilder("Tablero:")
                    .append(super.toString())
                    .append("| Altura:").append(altura)
                    .append("| Anchura:").append(anchura)
                    .append("| Tipo:").append(tipo)
                    .toString();
        }
    }
    //SubClase Barniz
    public static class Barniz extends Producto {
        private double mililitros;
        private TipoBarniz tipo;

        public Barniz(String codigo, String descripcion, Proveedor proveedor, double mililitros, TipoBarniz tipo) {
            super(codigo, descripcion, proveedor);
            this.mililitros = mililitros;
            this.tipo = tipo;
        }
        public enum TipoBarniz {
            INCOLORO,
            CAOBA,
            NOGAL
        }
        @Override
        public String toString() {
            // Formato: Barniz{super=..., mililitros=..., tipo=...}
            return new StringBuilder("Barniz:")
                    .append(super.toString())
                    .append("| Mililitros:").append(mililitros)
                    .append("| Tipo:").append(tipo)
                    .toString();
        }
    }
    //SubClase Articulo
    public static class Articulo extends Producto {
        private TipoArticulo tipo;
        public Articulo(String codigo, String descripcion, Proveedor proveedor, TipoArticulo tipo) {
            super(codigo, descripcion, proveedor);
            this.tipo = tipo;
        }
        public enum TipoArticulo {
            ESTANTERIA,
            MESA,
            SILLA,
            ARMARIO
        }
        @Override
        public String toString() {
            return new StringBuilder("Articulo:")
                    .append(super.toString())
                    .append("Tipo:").append(tipo)
                    .toString();
        }
    }
}