public class ClienteMayorista extends Cliente{

    private int cantidadProductos;

    public ClienteMayorista() {
    }

    public ClienteMayorista(String nombre, String identificacion, double valorCompra, int cantidadProductos) {
        super(nombre, identificacion, valorCompra);
        this.cantidadProductos = cantidadProductos;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    @Override
    public double calcularTotalPagar() {
        if (cantidadProductos>=50){
            valorCompra=valorCompra-(valorCompra*0.5);
        } else if (cantidadProductos>=20) {
            valorCompra=valorCompra-(valorCompra*0.35);
        } else {
            valorCompra=valorCompra-(valorCompra*0.2);
        }

        return valorCompra;
    }
}
