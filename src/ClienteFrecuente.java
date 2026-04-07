public class ClienteFrecuente extends Cliente{

    private int numeroCompras;

    public ClienteFrecuente() {
    }

    public ClienteFrecuente(String nombre, String identificacion, double valorCompra, int numeroCompras) {
        super(nombre, identificacion, valorCompra);
        this.numeroCompras = numeroCompras;
    }

    public int getNumeroCompras() {
        return numeroCompras;
    }

    public void setNumeroCompras(int numeroCompras) {
        this.numeroCompras = numeroCompras;
    }

    @Override
    public double calcularTotalPagar() {
        if (numeroCompras>=20){
            valorCompra=valorCompra-(valorCompra*0.3);
        } else if (numeroCompras>=10) {
            valorCompra=valorCompra-(valorCompra*0.2);
        } else if (numeroCompras<10) {
            valorCompra=valorCompra-(valorCompra*0.1);
        }
        if (compraAlta()) {
            valorCompra=valorCompra-(valorCompra*0.05);
        }
        return valorCompra;
    }
}
