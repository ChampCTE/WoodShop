package aa4_woodshops;
import aa4_woodshops.Producto;
import aa4_woodshops.ProductoEnTienda;
import aa4_woodshops.Proveedor;
import aa4_woodshops.Tienda;
import java.util.*;
import java.util.Date; //Para representar las fechas.
import java.text.SimpleDateFormat;  //Para convertir las fechas que ingresamos en formato string ("23/04/2025") a objetos Date que Java pueda comparar.
import java.text.ParseException; //Para que avise si hay un error en la conversión

public class AA4_WoodShops {
    static List<Proveedor> proveedores = new ArrayList<>();
    static List<Tienda> tiendas = new ArrayList<>();
    static List<Clientes> clientes = new ArrayList<>();
    static List<Factura> facturas = new ArrayList<>();

    public static void main(String[] args) throws ParseException { //throws ParseException para agregar las Facturas Nuevas para los datos de fecha.
        Scanner scanner = new Scanner(System.in);
        int opcion;
        Datos();
        do {
            System.out.println("\n- WoodShops -");
            System.out.println("1. Añadir nuevos productos a una tienda");
            System.out.println("2. Listar productos de una tienda por tipo");
            System.out.println("3. Mostrar el stock total de un producto en todas las tiendas");
            System.out.println("4. Añadir nuevos Clientes");
            System.out.println("5. Listar Clientes");
            System.out.println("6. Añadir nueva factura");
            System.out.println("7. Mostrar detalles de la factura");
            System.out.println("8. Mostrar resumen de ventas en Tiendas");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); //Importante limpiar el buffer!
            switch (opcion) {
                case 1:
                    AgregarProducto(scanner);
                    break;
                case 2:
                    listarProductos(scanner);
                    break;
                case 3:
                    mostrarStockTotal(scanner);
                    break;
                case 4:
                    agrearCliente(scanner);
                    break;
                case 5:
                    mostrarTodosClientes(scanner);
                    break;
                case 6:
                    agregarFactura(scanner);
                    break;
                case 7:
                    mostrarDetallesFactura(scanner);
                    break;
                case 8:
                    mostrarResumenVentas(scanner);
                    break;
                case 9:
                    System.out.println("¡Adios!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 9);
        scanner.close();
    }

    //Creación de los datos (Para una mejor optimización, pongo los datos después de Menú)
    public static void Datos() throws ParseException {
        //Proveedores
        Proveedor proveedor1 = new Proveedor("A123456789", "Leroy Merlin, S.A.");
        Proveedor proveedor2 = new Proveedor("B987654321", "Fes Més, S.L.");
        Proveedor proveedor3 = new Proveedor("C159753824", "ObraMat, S.L.");
        proveedores.add(proveedor1);
        proveedores.add(proveedor2);
        proveedores.add(proveedor3);
        //Tiendas
        Tienda tienda1 = new Tienda("WoodShops Tarragona", Tienda.Zona.SUR);
        Tienda tienda2 = new Tienda("WoodShops Lleida", Tienda.Zona.OESTE);
        Tienda tienda3 = new Tienda("WoodShops Girona", Tienda.Zona.ESTE);
        Tienda tienda4 = new Tienda("Woodshops Barcelona", Tienda.Zona.CENTRO);
        tiendas.add(tienda1);
        tiendas.add(tienda2);
        tiendas.add(tienda3);
        tiendas.add(tienda4);
        //Clientes
        Clientes clientes1 = new Clientes.ClienteProfesional("V47843858", "Cèlia", "Trullà", 50);
        Clientes clientes2 = new Clientes.ClienteWoodFriend("15475958H", "Hana", "Bannana", 101);
        clientes.add(clientes1);
        clientes.add(clientes2);
        //Productos
        Producto.Tablero tablero1 = new Producto.Tablero("TB001", "Tablero de pino", proveedor1, 2.0, 1.0, Producto.Tablero.TipoTablero.AGLOMERADO);
        Producto.Barniz barniz1 = new Producto.Barniz("BR001", "Barniz incoloro", proveedor2, 500, Producto.Barniz.TipoBarniz.INCOLORO);
        Producto.Articulo armario1 = new Producto.Articulo("AR001", "Armario Empodrado", proveedor3, Producto.Articulo.TipoArticulo.ARMARIO);
        //ProductoEnTienda
        //Tarragona
        ProductoEnTienda productoEnTienda1 = new ProductoEnTienda(tablero1, tienda1, 50, 100);
        ProductoEnTienda productoEnTienda2 = new ProductoEnTienda(barniz1, tienda1, 25, 50);
        ProductoEnTienda productoEnTienda3 = new ProductoEnTienda(armario1,tienda1,150,50);
        //Agregar productos al inventario
        tienda1.agregarProducto(tablero1, 50, 100, productoEnTienda1);
        tienda1.agregarProducto(barniz1, 25, 50, productoEnTienda2);
        tienda1.agregarProducto(armario1,150,50,productoEnTienda3);
        //Lleida
        ProductoEnTienda productoEnTienda4 = new ProductoEnTienda(tablero1, tienda2, 70, 500);
        ProductoEnTienda productoEnTienda5 = new ProductoEnTienda(barniz1, tienda2, 30, 100);
        ProductoEnTienda productoEnTienda6 = new ProductoEnTienda(armario1,tienda2,200,20);
        //Agregar productos al inventario
        tienda2.agregarProducto(tablero1, 70, 500, productoEnTienda4);
        tienda2.agregarProducto(barniz1, 30, 100, productoEnTienda5);
        tienda2.agregarProducto(armario1,200,20,productoEnTienda6);
        //Girona
        ProductoEnTienda productoEnTienda7 = new ProductoEnTienda(tablero1, tienda3, 100, 100);
        ProductoEnTienda productoEnTienda8 = new ProductoEnTienda(barniz1, tienda3, 10, 500);
        ProductoEnTienda productoEnTienda9 = new ProductoEnTienda(armario1,tienda3,150,30);
        //Agregar productos al inventario
        tienda3.agregarProducto(tablero1, 100, 100, productoEnTienda7);
        tienda3.agregarProducto(barniz1, 10, 500, productoEnTienda8);
        tienda3.agregarProducto(armario1,150,30,productoEnTienda9);
        //Barcelona
        ProductoEnTienda productoEnTienda10 = new ProductoEnTienda(tablero1, tienda4, 150, 1000);
        ProductoEnTienda productoEnTienda11 = new ProductoEnTienda(barniz1, tienda4, 15, 2000);
        ProductoEnTienda productoEnTienda12 = new ProductoEnTienda(armario1,tienda4,120,500);
        //Agregar productos al inventario
        tienda4.agregarProducto(tablero1, 150, 1000, productoEnTienda10);
        tienda4.agregarProducto(barniz1, 15, 2000, productoEnTienda11);
        tienda4.agregarProducto(armario1,120,200,productoEnTienda12);
        //Facturas
        //FR001
        List<DetallesFactura> detallesFacturaA = new ArrayList<>();
        detallesFacturaA.add(new DetallesFactura(2, productoEnTienda1));
        detallesFacturaA.add(new DetallesFactura(1, productoEnTienda2));
        facturas.add(new Factura(
                "FR001",
                new SimpleDateFormat("dd/MM/yyyy").parse("01/04/2025"),
                clientes1,
                tienda1,
                detallesFacturaA
        ));
        //FR002
        List<DetallesFactura> detallesFacturaB = new ArrayList<>();
        detallesFacturaB.add(new DetallesFactura(1, productoEnTienda4));
        detallesFacturaB.add(new DetallesFactura(1, productoEnTienda6));
        facturas.add(new Factura(
                "FR002",
                new SimpleDateFormat("dd/MM/yyyy").parse("14/04/2025"),
                clientes2,
                tienda2,
                detallesFacturaB
        ));
        //FR003
        List<DetallesFactura> detallesFacturaC = new ArrayList<>();
        detallesFacturaC.add(new DetallesFactura(3, productoEnTienda8));
        facturas.add(new Factura(
                "FR003",
                new SimpleDateFormat("dd/MM/yyyy").parse("18/04/2025"),
                null,
                tienda3,
                detallesFacturaC
        ));
        //FR004
        List<DetallesFactura> detallesFacturaD = new ArrayList<>();
        detallesFacturaD.add(new DetallesFactura(1, productoEnTienda12));
        facturas.add(new Factura(
                "FR004",
                new SimpleDateFormat("dd/MM/yyyy").parse("30/04/2025"),
                clientes1,
                tienda4,
                detallesFacturaD
        ));
    }

    //Función CASE 1. Se agregar un Prodcuto después de: selecionar un proveedor, seleccionar una tienda y cuando tenemos el prodcuto, rellenar los datos.
    public static void AgregarProducto(Scanner scanner) {
        System.out.println("\n- Añadir Producto -");
        // Paso 1: Seleccionar el proveedor
        Proveedor proveedorSeleccionado = seleccionarProveedor(scanner); //Llamamos al metodo para que el usuario elija prooveedor en este caso.
        if (proveedorSeleccionado == null) {
            System.out.println("Proveedor no válido.");
            return;
        }
        // Paso 2: Seleccionar la tienda
        Tienda tiendaSeleccionada = seleccionarTienda(scanner);
        if (tiendaSeleccionada == null) {
            System.out.println("Tienda no válida.");
            return;
        }
        // Paso 3: Crear el producto
        Producto productoNuevo = crearProducto(scanner, proveedorSeleccionado);
        if (productoNuevo == null) {
            System.out.println("Producto no válido.");
            return;
        }
        // Paso 4: Especificar precio y stock
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();
        System.out.print("Ingrese el stock del producto: ");
        int stock = scanner.nextInt();
        // Tengo que crear una instancia para que se cree un nuevo precio y número de stock en tienda.
        ProductoEnTienda productoEnTienda = new ProductoEnTienda(productoNuevo, tiendaSeleccionada, precio, stock);
        tiendaSeleccionada.agregarProducto(productoNuevo, precio, stock, productoEnTienda);
        System.out.println("\nProducto añadido exitosamente a " + tiendaSeleccionada.getNombre());
    }

    // Función para seleccionar un proveedor
    public static Proveedor seleccionarProveedor(Scanner scanner) {
        System.out.println("\nSeleccione un proveedor:");
        for (int i = 0; i < proveedores.size(); i++) { // Mostrar la lista de proveedores con números para selección
            System.out.println((i + 1) + ". " + proveedores.get(i).getNombre());
        }
        while (true) { //Bucle para asegurar que se ingrese un valor válido
            try {
                System.out.print("Ingrese el número del proveedor: ");
                int opcionProveedor = scanner.nextInt();
                scanner.nextLine();

                if (opcionProveedor > 0 && opcionProveedor <= proveedores.size()) {
                    return proveedores.get(opcionProveedor - 1); // Retornar el proveedor seleccionado
                } else {
                    System.out.println("Opción inválida. Intente de nuevo.");
                }
            } catch (
                    InputMismatchException e) { //Este libreria nos sirve para controlar los errores si la entrada no es un número entero
                System.out.println("¡Error! Ingrese un número válido.");
                scanner.nextLine();
            }
        }
    }

    //Función para seleccionar una Tienda
    public static Tienda seleccionarTienda(Scanner scanner) {
        System.out.println("\nSeleccione una Tienda:");
        for (int i = 0; i < tiendas.size(); i++) {
            System.out.println((i + 1) + ". " + tiendas.get(i).getNombre());
        }
        while (true) {
            try {
                System.out.print("Ingrese el número de la tienda: ");
                int opcionTienda = scanner.nextInt();
                scanner.nextLine();

                if (opcionTienda > 0 && opcionTienda <= tiendas.size()) {
                    return tiendas.get(opcionTienda - 1);
                } else {
                    System.out.println("Opción inválida. Intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("¡Error! Ingrese un número válido.");
                scanner.nextLine();
            }
        }
    }

    //Función para crear un Prodcuto
    public static Producto crearProducto(Scanner scanner, Proveedor proveedor) {
        System.out.println("\nSeleccione un tipo de prodcucto:");
        System.out.println("1. Tablero");
        System.out.println("2. Barniz");
        System.out.println("3. Articulo");

        int TipoProducto = scanner.nextInt();
        scanner.nextLine();
        switch (TipoProducto) {
            case 1:
                System.out.println("Código:");
                String CodigoTablero = scanner.nextLine();
                System.out.println("Descripción:");
                String DescripcionTablero = scanner.nextLine();
                System.out.println("Altura:");
                double altura = scanner.nextDouble(); //nextDouble para los elementos introducidos que sean double.
                scanner.nextLine();
                System.out.println("Anhcura:");
                double anchura = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Tipo:");
                System.out.println("1. Algomerado:");
                System.out.println("2. Contrachapado:");
                System.out.println("3. MDF:");
                int opcionTipo = scanner.nextInt();
                scanner.nextLine();
                Producto.Tablero.TipoTablero tipoTablero = switch (opcionTipo) {
                    case 1 ->
                            Producto.Tablero.TipoTablero.AGLOMERADO; //Para enums mejor usar -> para acceder a la lista.
                    case 2 -> Producto.Tablero.TipoTablero.CONTRACHAPADO;
                    case 3 -> Producto.Tablero.TipoTablero.MDF;
                    default -> null; //Recomenado siempre poerque el defaul sea null o otra variante,
                };
                return new Producto.Tablero(CodigoTablero, DescripcionTablero, proveedor, altura, anchura, tipoTablero);
            case 2:
                System.out.println("Código:");
                String CodigoBarniz = scanner.nextLine();
                System.out.println("Descripción:");
                String DescripcionBarniz = scanner.nextLine();
                System.out.println("Mililitros:");
                double mililitros = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Color:");
                System.out.println("1. Incoloro:");
                System.out.println("2. Caoba:");
                System.out.println("3. Nogal:");
                int opcionBarniz = scanner.nextInt();
                scanner.nextLine();
                Producto.Barniz.TipoBarniz tipoBarniz = switch (opcionBarniz) {
                    case 1 -> Producto.Barniz.TipoBarniz.INCOLORO;
                    case 2 -> Producto.Barniz.TipoBarniz.CAOBA;
                    case 3 -> Producto.Barniz.TipoBarniz.NOGAL;
                    default -> null;
                };
                return new Producto.Barniz(CodigoBarniz, DescripcionBarniz, proveedor, mililitros, tipoBarniz);
            case 3:
                System.out.println("Código:");
                String CodigoArticulo = scanner.nextLine();
                System.out.println("Descripción:");
                String DescripcionCodigo = scanner.nextLine();
                System.out.println("Tipo:");
                System.out.println("1. Esntaneria:");
                System.out.println("2. Mesa:");
                System.out.println("3. Silla:");
                System.out.println("4. Armario:");
                int opcionArticulo = scanner.nextInt();
                scanner.nextLine();
                Producto.Articulo.TipoArticulo tipoArticulo = switch (opcionArticulo) {
                    case 1 -> Producto.Articulo.TipoArticulo.SILLA;
                    case 2 -> Producto.Articulo.TipoArticulo.MESA;
                    case 3 -> Producto.Articulo.TipoArticulo.ESTANTERIA;
                    case 4 -> Producto.Articulo.TipoArticulo.ARMARIO;
                    default -> null;
                };
                return new Producto.Articulo(CodigoArticulo, DescripcionCodigo, proveedor, tipoArticulo);
            default:
                System.out.println("Opción no válida.");
                return null;
        }
    }

    //Función de CASE 2. Dondé se muestra una lista de prodcutos después de seleccioanr una tienda y el prodcuto.
    public static void listarProductos(Scanner scanner) {
        //Paso 1: Seleccionar la tienda (TIENDAS)
        System.out.println("\nSeleccione una Tienda:");
        Tienda tiendaSeleccionada = seleccionarTienda(scanner);
        if (tiendaSeleccionada == null) {
            System.out.println("Tienda no válida.");
            return;
        }
        //Paso 2: Seleccionar el tipo de producto (PRODCUTOSENTIENDA)
        System.out.println("\nSeleccione el tipo de producto:");
        System.out.println("1.Tablero");
        System.out.println("2.Barniz");
        System.out.println("3.Artículo");
        int tipoProducto;
        try {
            tipoProducto = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("¡Error! Ingrese un número válido.");
            scanner.nextLine();
            return;
        }
        //Paso 3: Mostrar los productos según el tipo seleccionado (TABLERO, BARNIZ, ARTICULO)
        List<ProductoEnTienda> productosEnTienda = tiendaSeleccionada.getInventario();
        if (productosEnTienda.isEmpty()) {
            System.out.println("No hay productos en esta tienda.");
            return;
        }
        System.out.println("\nProductos en " + tiendaSeleccionada.getNombre() + " del tipo seleccionado:");
        boolean hayProductos = false; //Creamos uns booleana, de esta forma nos guiamos por TRUE o FALSE para saber si existen prodcutos en vez del Stock.

        for (ProductoEnTienda productoEnTienda : productosEnTienda) {
            Producto producto = productoEnTienda.getProducto();
            switch (tipoProducto) {
                case 1:
                    if (producto instanceof Producto.Tablero) { //Es un operador que verifica si un objeto es una instancia de una clase o subclase.
                        System.out.println("- Código: " + producto.getCodigo() + ", Descripción: " + producto.getDescripcion());
                        hayProductos = true;
                    }
                    break;
                case 2:
                    if (producto instanceof Producto.Barniz) {
                        System.out.println("- Código: " + producto.getCodigo() + ", Descripción: " + producto.getDescripcion());
                        hayProductos = true;
                    }
                    break;
                case 3:
                    if (producto instanceof Producto.Articulo) {
                        System.out.println("- Código: " + producto.getCodigo() + ", Descripción: " + producto.getDescripcion());
                        hayProductos = true;
                    }
                    break;
                default:
                    System.out.println("Opción no válida.");
                    return;
            }
        }
        if (!hayProductos) {
            System.out.println("No hay productos del tipo seleccionado en esta tienda.");
        }
    }

    //Función CASE 3. Mostrar el stock después de introducir un código.
    public static void mostrarStockTotal(Scanner scanner) {
        //Paso 1: Pedir código del producto
        System.out.print("Ingrese el código del producto: ");
        String codigoBuscado = scanner.nextLine();

        boolean productoEncontrado = false; //Booleana para producto encontrado.
        //Paso 2: Comprobación de código + Buscar el producto en todas las tiendas (PRODCUTO EN TIENDA)
        System.out.println("\nStock del producto " + codigoBuscado + ":");
        for (Tienda tienda : tiendas) {
            for (ProductoEnTienda productoEnTienda : tienda.getInventario()) {
                Producto producto = productoEnTienda.getProducto();

                if (producto.getCodigo().equalsIgnoreCase(codigoBuscado)) { //Metodo compara dos cadenas ignorando mayúsculas y minúsculas.
                    System.out.println("- Tienda: " + tienda.getNombre() +
                            " | Stock: " + productoEnTienda.getStock() +
                            " | Precio: " + productoEnTienda.getPrecio() + "€");
                    productoEncontrado = true;
                }
            }
        }
        if (!productoEncontrado) {
            System.out.println("El producto no existe en ninguna tienda.");
        }
    }

    //Función CASE 4. Añadir nuevos clientes.
    public static void agrearCliente(Scanner scanner) {
        System.out.println("\n-- Añadir Cliente --");
        System.out.println("Seleccione el tipo de cliente (pulsa 0 si no es cliente):");
        System.out.println("1. Profesional");
        System.out.println("2. Wood Friend");
        int tipo = -1;
        while (tipo < 0 || tipo > 2) {
            System.out.print("Opción (0-2): ");
            try {
                tipo = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduzca un número válido.");
                scanner.nextLine();
            }
        }
        //Cliente Anónimo
        if (tipo == 0) {
            System.out.println("Se ha seleccionado cliente anónimo. No se añadirá a la lista de clientes.");
            return;
        }
        // Cliente Profesional
        if (tipo == 1) {
            System.out.print("Ingrese el NIF: ");
            String nif = scanner.nextLine();
            System.out.print("Ingrese el nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el apellido: ");
            String apellido = scanner.nextLine();
            System.out.print("Ingrese el descuento (%): ");
            double descuento = -1;
            while (descuento < 0 || descuento > 100) { //Tengo que evitar número negativo o un descuento descomunal.
                try {
                    descuento = scanner.nextDouble();
                    scanner.nextLine();
                    if (descuento < 0 || descuento > 100) {
                        System.out.println("El descuento debe estar entre 0 y 100.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, introduzca un número válido.");
                    scanner.nextLine();
                }
            }
            Clientes nuevoCliente = new Clientes.ClienteProfesional(nif, nombre, apellido, descuento);
            clientes.add(nuevoCliente);
            System.out.println("Cliente Profesional añadido correctamente.");

            // Cliente Wood Friend
        } else if (tipo == 2) {
            System.out.print("Ingrese el nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el apellido: ");
            String apellido = scanner.nextLine();
            System.out.print("Ingrese el DNI: ");
            String dni = scanner.nextLine();
            System.out.print("Ingrese el código de socio: ");
            int codigoSocio = 0;
            boolean valido = false;
            while (!valido) {
                try {
                    codigoSocio = scanner.nextInt();
                    scanner.nextLine();
                    valido = true;
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, introduzca un número válido.");
                    scanner.nextLine();
                }
            }
            Clientes nuevoCliente = new Clientes.ClienteWoodFriend(dni, nombre, apellido, codigoSocio);
            clientes.add(nuevoCliente);
            System.out.println("Cliente Wood Friend añadido correctamente.");
        }
    }

    //Función CASE 5. Mostrar listado de clientes.
    public static void mostrarTodosClientes(Scanner scanner) {
        //Paso 1. Opción por si la lista está vacía.
        System.out.println("- Listado de los Clientes -");
        if (clientes.isEmpty()) {
            System.out.println("No existen clientes registrados.");
            return;
        }
        //Paso 2. Imprimir listado. Hacer un if para mostrar los tipos
        for (Clientes cliente : clientes) {
            if (cliente instanceof Clientes.ClienteProfesional) {
                Clientes.ClienteProfesional profesional = (Clientes.ClienteProfesional) cliente;
                System.out.println("Tipo: Profesional");
                System.out.println("Nombre: " + profesional.getNombre());
                System.out.println("Apellido: " + profesional.getApellido());
                System.out.println("NIF: " + profesional.getNif());
                System.out.println("Descuento: " + profesional.getDescuento() + "%");
                System.out.println("--------------------------------");
            } else if (cliente instanceof Clientes.ClienteWoodFriend) {
                Clientes.ClienteWoodFriend woodFriend = (Clientes.ClienteWoodFriend) cliente;
                System.out.println("Tipo: WoodFriend");
                System.out.println("Nombre: " + woodFriend.getNombre());
                System.out.println("Apellido: " + woodFriend.getApellido());
                System.out.println("DNI: " + woodFriend.getDni());
                System.out.println("Código de Socio: " + woodFriend.getCodigoSocio());
                System.out.println("--------------------------------");
            }
        }
    }

    //Función CASE 6. Agregar una factura al sistema
    public static void agregarFactura (Scanner scanner) {
        //Paso 1. Ingresar datos
        System.out.println("Ingrese número de factura");
        String numeroFactura = scanner.nextLine();
        //Tengo que convertir el String desde aquí para que se almacene corectamente.
        System.out.println("Ingrese fecha de compra (DD/MM/AAAA):");
        String fechaStr = scanner.nextLine();
        Date fecha = null;
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            fecha = formato.parse(fechaStr);
        } catch (ParseException e) {
            System.out.println("Error al parsear la fecha. Asegúrese de usar el formato DD/MM/AAAA.");
            return; // salir si hay error
        }
        System.out.println("Ingrese tienda");
        for (int i = 0; i < tiendas.size(); i++) {
            System.out.println((i +1) + "." + tiendas.get(i).getNombre()); //Mostramos listado de Tiendas.
        }
        int opcionTienda = scanner.nextInt();
        scanner.nextLine();
        if (opcionTienda < 1 || opcionTienda > tiendas.size()) {
            System.out.println("Tienda no válida."); //Sí el número seleccionado no está entre la lista. No existe.
            return;
        }
        //Paso 1.2 - Cliente. Se ha de tener en cuenta que Tipo de cliente es por si tiene descuentos.
        Tienda tiendaSeleccionada = tiendas.get(opcionTienda - 1);
        System.out.println("Ingrese cliente");
        System.out.println("¿El cliente está registrado? (Sí/ No)");
        String respuestaCliente = scanner.nextLine();

        Clientes clienteSeleccionado = null;
        double descuento = 0;

        if (respuestaCliente.equalsIgnoreCase("Sí")) {
            // Mostramos lista de clientes disponibles
            if (clientes.isEmpty()) {
                System.out.println("No hay clientes registrados.");
            } else {
                System.out.println("\nSeleccione un cliente:");
                for (int i = 0; i < clientes.size(); i++) {
                    Clientes cliente = clientes.get(i);
                    String info = (i + 1) + ". " + cliente.getNombre() + " " + cliente.getApellido();
                    if (cliente instanceof Clientes.ClienteProfesional) {
                        info += " - NIF: " + cliente.getNif();
                    } else if (cliente instanceof Clientes.ClienteWoodFriend) {
                        info += " - DNI: " + cliente.getDni();
                    }
                    System.out.println(info);
                }
                int opcionCliente = scanner.nextInt();
                scanner.nextLine();

                if (opcionCliente > 0 && opcionCliente <= clientes.size()) {
                    clienteSeleccionado = clientes.get(opcionCliente - 1);

                    //Aqiu es donde verificamos si el cliente seleccionado es Profesional, por qué entonces hacemos un getDescuento.
                    if (clienteSeleccionado instanceof Clientes.ClienteProfesional) {
                        Clientes.ClienteProfesional clientePro = (Clientes.ClienteProfesional) clienteSeleccionado;
                        descuento = clientePro.getDescuento();
                    }
                }
            }
        }

        //Paso 1.3 - Es una Factura, se deben mostrar Prodcutos.
        List<ProductoEnTienda> productosTicket = new ArrayList<>();
        List<Integer> cantidades = new ArrayList<>();

        boolean continuarAgregando = true; //Booleoano que nos ayudara a cerrar el loop en caso de FALSE.
        while (continuarAgregando) {
            List<ProductoEnTienda> inventario = tiendaSeleccionada.getInventario();
            if (inventario.isEmpty()) {
                System.out.println("No hay productos disponibles en la tienda seleccionada.");
                break;
            }
            //Mostrar lisatdo de prodcutos disponibles en la tienda
            System.out.println("\nProductos disponibles en " + tiendaSeleccionada.getNombre() + ":");
            for (int i = 0; i < inventario.size(); i++) {
                ProductoEnTienda producto = inventario.get(i);
                System.out.println((i + 1) + ". " + producto.getProducto().getDescripcion() +
                        " - Precio: " + producto.getPrecio() + "€" +
                        " - Stock: " + producto.getStock());
            }
            //Luego seleccionamos el prodcuto que queremos.
            System.out.print("\nSeleccione un producto (0 para finalizar): ");
            int opcionProducto = scanner.nextInt();
            scanner.nextLine();
            if (opcionProducto == 0) {
                break;
            }
            //Finalmente seleccionamos la cantidad
            if (opcionProducto > 0 && opcionProducto <= inventario.size()) {
                ProductoEnTienda productoSeleccionado = inventario.get(opcionProducto - 1);
                System.out.print("Cantidad: ");
                int cantidad = scanner.nextInt();
                scanner.nextLine();
                if (cantidad > 0 && cantidad <= productoSeleccionado.getStock()) {
                    productosTicket.add(productoSeleccionado);
                    cantidades.add(cantidad);

                    //Actualizar stock!!
                    productoSeleccionado.setStock(productoSeleccionado.getStock() - cantidad);
                    System.out.println("Producto añadido al ticket.");
                } else {
                    System.out.println("Error: cantidad no válida o stock insuficiente.");
                }
            } else {
                System.out.println("Error: selección no válida.");
            }
            //Rompemos el Loop
            System.out.print("¿Desea añadir más productos? (Sí/No): ");
            String respuesta = scanner.nextLine();
            continuarAgregando = respuesta.equalsIgnoreCase("Sí");
        }

        //Paso 2. Mostrar los detalles de la factura completa
        System.out.println("\n--- Detalles de la Factura ---");
        System.out.println("Número de Factura: " + numeroFactura);
        System.out.println("Fecha de Compra: " + fecha);
        System.out.println("Tienda: " + tiendaSeleccionada.getNombre());
        //Si el cliente no está registrado pondremos, se pone anonimo
        if (clienteSeleccionado == null) {
            System.out.println("Cliente: Anónimo");
        } else {
            System.out.println("Cliente: " + clienteSeleccionado.getNombre() + " " + clienteSeleccionado.getApellido());
            //Si el CLiente es profenila mostramos el descuento
            if (clienteSeleccionado instanceof Clientes.ClienteProfesional) {
                System.out.println("Descuento aplicado: " + descuento + "%");
            }
        }
        //Luego iteramos sobre los prodcutos de la factura.
        System.out.println("Productos:");
        double totalFactura = 0; //Aquí vamos contando el total de la Factura
        for (int i = 0; i < productosTicket.size(); i++) {
            ProductoEnTienda producto = productosTicket.get(i);
            int cantidad = cantidades.get(i);
            double subtotal = producto.getPrecio() * cantidad;
            System.out.println("- " + producto.getProducto().getDescripcion() + " - " + cantidad + " x " + producto.getPrecio() + "€ = " + subtotal + "€");
            totalFactura += subtotal; //Acumulamos el subtotal al total de la factura
        }
        //Y aplicamos descuento si es necesario.
        if (descuento > 0 && clienteSeleccionado instanceof Clientes.ClienteProfesional) {
            double descuentoAplicado = totalFactura * (descuento / 100);
            totalFactura -= descuentoAplicado;
            System.out.println("Descuento del cliente profesional (" + descuento + "%): " + descuentoAplicado + "€");
        }

        System.out.println("Total de la Factura: " + totalFactura + "€");

        List<DetallesFactura> detallesFactura = new ArrayList<>();
        for (int i = 0; i < productosTicket.size(); i++) {
            ProductoEnTienda productoEnTienda = productosTicket.get(i);
            int cantidad = cantidades.get(i);
            detallesFactura.add(new DetallesFactura(cantidad, productoEnTienda));
        }
        Factura factura = new Factura(numeroFactura, fecha, clienteSeleccionado, tiendaSeleccionada, detallesFactura);
        facturas.add(factura);
    }

    //Función CASE 7. Mostrar las Facturas
    public static void mostrarDetallesFactura(Scanner scanner) {
        //Paso 1. Ingresar las fechas
        System.out.println("\n--- Mostrar Detalles Factura ---");
        System.out.println("Ingrese fecha de inicio (DD/MM/AAAA):");
        String fechaInicioString = scanner.nextLine();
        System.out.println("Ingrese fecha de fin (DD/MM/AAAA):");
        String fechaFinString = scanner.nextLine();
        //Paso 1.2 - Conversión de los Strings en Date
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaInicio, fechaFin;
        try {
            fechaInicio = sdf.parse(fechaInicioString);
            fechaFin = sdf.parse(fechaFinString);
        } catch (ParseException e) {
            System.out.println("Formato de fecha incorrecto. Use DD/MM/AAAA.");
            return;
        }
        //Paso 2. Coger las fechas que tenemos almacenadas y comprarlas + imrpimir si todo es correcto
        boolean hayFacturas = false;
        System.out.println("\n--- Resumen de Tickets ---");
        for (Factura factura : facturas) {
            Date fechaFactura = factura.getFecha();
            if (!fechaFactura.before(fechaInicio) && !fechaFactura.after(fechaFin)) {
                hayFacturas = true;
                System.out.println("Número: " + factura.getNumeroFactura());
                System.out.println("Fecha: " + sdf.format(fechaFactura));

                Clientes cliente = factura.getClientes();
                if (cliente == null) {
                    System.out.println("Cliente: Anónimo");
                } else {
                    System.out.print("Cliente: " + cliente.getNombre() + " " + cliente.getApellido());
                    if (cliente instanceof Clientes.ClienteProfesional) {
                        double descuento = ((Clientes.ClienteProfesional) cliente).getDescuento();
                        System.out.print(" (Descuento: " + descuento + "%)");
                    }
                    System.out.println();
                }
                //Si el cliente es Profesional, comprobar el descuento en la factura.
                double totalFactura = 0;
                double descuento = 0;
                if (cliente instanceof Clientes.ClienteProfesional) {
                    descuento = ((Clientes.ClienteProfesional) cliente).getDescuento();
                }
                for (DetallesFactura detalle : factura.getDetalles()) {
                    double subtotal = detalle.getProductoEnTienda().getPrecio() * detalle.getCantidad();
                    totalFactura += subtotal;
                }
                if (descuento > 0) {
                    double descuentoAplicado = totalFactura * (descuento / 100);
                    totalFactura -= descuentoAplicado;
                    System.out.println("Descuento aplicado: " + descuento + "% (" + String.format("%.2f", descuentoAplicado) + "€)");
                } else {
                    System.out.println("Descuento aplicado: No");
                }
                System.out.println("Total: " + String.format("%.2f", totalFactura) + "€");
                System.out.println("-----------------------------------");
            }
        }
        if (!hayFacturas) {
            System.out.println("No hay facturas en el periodo indicado.");
        }
    }

    //Función CASE 8. Mostrar el resumen de todas las ventas
    public static void mostrarResumenVentas (Scanner scanner) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaInicio = null;
        Date fechaFin = null;
        //Paso 1. Pedir intervalo de fechas.
        try {
            System.out.println("\n--- Mostrar Detalles Factura ---");
            System.out.println("Ingrese fecha de inicio (DD/MM/AAAA):");
            String fechaInicioStr = scanner.nextLine();
            fechaInicio = sdf.parse(fechaInicioStr);

            System.out.print("Ingrese la fecha de fin (DD/MM/AAAA): ");
            String fechaFinStr = scanner.nextLine();
            fechaFin = sdf.parse(fechaFinStr);

            if (fechaFin.before(fechaInicio)) {
                System.out.println("La fecha de fin debe ser posterior o igual a la fecha de inicio.");
                return;
            }
        } catch (ParseException e) {
            System.out.println("Formato de fecha inválido. Use DD/MM/AAAA.");
            return;
        }
        //Paso 2. Printear aquellas que cumplan los requisitos. Tiene que salir Tienda, total suma tickets entre las fechas ingresadas.
            System.out.println("\nResumen de ventas por tienda entre " + sdf.format(fechaInicio) + " y " + sdf.format(fechaFin) + ":");
            for (Tienda tienda : tiendas) {
                double totalVentas = 0.0;

                for (Factura factura : facturas) {
                    if (factura.getTienda().equals(tienda)) {
                        Date fechaFactura = factura.getFecha();
                        if (!fechaFactura.before(fechaInicio) && !fechaFactura.after(fechaFin)) {
                            // Aquí lo que hago es calculcar Todos los precios de las Facturas para tener el reulstado TOTAL general.
                            for (DetallesFactura detalle : factura.getDetalles()) {
                                int cantidad = detalle.getCantidad();
                                ProductoEnTienda productoEnTienda = detalle.getProductoEnTienda();
                                double precio = productoEnTienda.getPrecio();
                                totalVentas += cantidad * precio;
                            }
                        }
                    }
                }
                System.out.printf("- %s: %.2f €\n", tienda.getNombre(), totalVentas);
            }
        }
    }

