public class Cliente {

    protected String nombre;
    protected String identificacion;
    protected double valorCompra;

    public Cliente() {
    }

    public Cliente(String nombre, String identificacion, double valorCompra) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.valorCompra = valorCompra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", valorCompra=" + valorCompra +
                '}';
    }

    public double calcularTotalPagar(){
        return valorCompra;
    }
    public void descontar(double porcentaje){
        valorCompra=valorCompra-(valorCompra*porcentaje);
    }
    public void aumentar(double porcentaje){
        valorCompra=valorCompra+(valorCompra*porcentaje);
    }
    public boolean compraAlta(){
        if (valorCompra>300000){
            return true;
        }else {
            return false;
        }
    }
    public void imprimirResumen(double total){
            System.out.println("Cliente"+"\n"+
                    "   Nombre = " + nombre + "\n"+
                    "   Identificacion = " + identificacion + "\n"+
                    "   Valor original = " + valorCompra + "\n"+
                    "   Valor Final = " + valorCompra);
    }
}
