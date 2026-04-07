import java.sql.SQLOutput;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Scanner teclado = new Scanner(System.in);
    ArrayList<Cliente> lstClientes = new ArrayList<>();
    int opc, opc1;
    do {
        System.out.println("""
                    Menu
                1. Registrar cliente regular
                2. Registrar cliente frecuente
                3. Registrar cliente mayorista
                4. Buscar cliente por identificacion
                5. Mostrar todos los clientes
                6. Mostrar clientes por tipo
                7. Calcular total de la compra
                8. Mostrar compras altas
                9. Mostrar cliente con mayor pago
                10. Salir
                """);
        opc=teclado.nextInt();

        switch (opc){
            case 1:
                System.out.println("Ingrese nombre: ");
                String nombre = teclado.next();
                System.out.println("Ingrese identificacion: ");
                String documento = teclado.next();
                System.out.println("Valor de la compra: ");
                double valorCompra = teclado.nextDouble();
                lstClientes.add(new ClienteRegular(nombre,documento,valorCompra));
                break;
            case 2:
                System.out.println("Ingrese nombre: ");
                nombre = teclado.next();
                System.out.println("Ingrese identificacion: ");
                documento = teclado.next();
                System.out.println("Valor de la compra: ");
                valorCompra = teclado.nextDouble();
                System.out.println("Numero Compras: ");
                int numeroCompras = teclado.nextInt();
                lstClientes.add(new ClienteFrecuente(nombre,documento,valorCompra,numeroCompras));
                break;
            case 3:
                System.out.println("Ingrese nombre: ");
                nombre = teclado.next();
                System.out.println("Ingrese identificacion: ");
                documento = teclado.next();
                System.out.println("Valor de la compra: ");
                valorCompra = teclado.nextDouble();
                System.out.println("Cantidad de productos: ");
                int cantidadProductos = teclado.nextInt();
                lstClientes.add(new ClienteMayorista(nombre,documento,valorCompra,cantidadProductos));
                break;
            case 4:
                System.out.println("Ingrese la identificacion a buscar");
                String id = teclado.next();
                Cliente c1 = null;
                for (Cliente c: lstClientes) {
                    if (c.getIdentificacion().equalsIgnoreCase(id)){
                        c1=c;
                    }
                }
                if (c1 == null) {
                    System.out.println("Paciente no encontrado");
                } else {
                    c1.imprimirResumen(c1.calcularTotalPagar());
                }
                break;
            case 5:
                for (Cliente c: lstClientes) {
                    c.imprimirResumen(c.calcularTotalPagar());
                }
                break;
            case 6:
                do{
                    System.out.println("""
                    Tipo de Cliente
                        1. Cliente Regular
                        2. Cliente Frecuente
                        3. Cliente Mayorista
                        4. Salir
                    """);
                    opc1=teclado.nextInt();
                    switch(opc1){
                        case 1:
                            for (Cliente c : lstClientes) {
                                if (c instanceof ClienteRegular){
                                    System.out.println(c);
                                }
                            };
                            break;
                        case 2:
                            for (Cliente c : lstClientes) {
                                if (c instanceof ClienteFrecuente){
                                    System.out.println(c);
                                }
                            };
                            break;
                        case 3:
                            for (Cliente c : lstClientes) {
                                if (c instanceof ClienteMayorista){
                                    System.out.println(c);
                                }
                            };
                            break;
                        case 4:
                            System.out.println("Saliendo.............");
                            break;
                        default:
                            System.out.println("Opcion Incorrecta");
                    }
                }while(opc1!=4);
                break;
            case 7:
                System.out.println("Ingrese identificacion:");
                id = teclado.next();
                for (Cliente c : lstClientes) {
                    if (c.getIdentificacion().equalsIgnoreCase(id)) {
                        double total = c.calcularTotalPagar();
                        System.out.println("Costo final: " + total);
                    }
                }
                break;
            case 8:
                for (Cliente c : lstClientes) {
                    if (c.compraAlta()) {
                        c.imprimirResumen(c.calcularTotalPagar());
                    }
                }
                break;
            case 9:
                Cliente mayor = null;
                double max = 0;

                for (Cliente c : lstClientes) {
                    double total = c.calcularTotalPagar();
                    if (total > max) {
                        max = total;
                        mayor = c;
                    }
                }

                if (mayor != null) {
                    System.out.println("Paciente que más pagó:");
                    mayor.imprimirResumen(max);
                }
                break;
            case 10:
                System.out.println("Saliendo.................");
                break;
            default:
                System.out.println("Opcion Incorrecta");
                break;
        }
    }while(opc!=10);

}
