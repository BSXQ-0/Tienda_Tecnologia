public class ClienteRegular extends Cliente{

    public ClienteRegular() {
    }

    public ClienteRegular(String nombre, String identificacion, double valorCompra) {
        super(nombre, identificacion, valorCompra);
    }

    @Override
    public double calcularTotalPagar() {
        if (valorCompra>300000){
            valorCompra=valorCompra-(valorCompra*0.08);
        } else if (valorCompra>150000) {
            valorCompra=valorCompra-(valorCompra*0.05);
        } else if (valorCompra<60000) {
            valorCompra=valorCompra+(valorCompra*0.06);
        }
        return valorCompra;
    }
}
