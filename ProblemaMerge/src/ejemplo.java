
    public class ejemplo{
     public static final double descuentoUnitario=0.10;
     public static final double costoArticulo=500;
    public static void main(String[]args){
        int cantidadArticulos=2;
        double calcularTotal=calcularTotal(cantidadArticulos);
            System.out.println("El total a pagar es :"+calcularTotal);
        }
        public static double calcularTotal(int cantidadArticulos){

        double subtotal=cantidadArticulos*costoArticulo;
         double descuento=subtotal*descuentoUnitario;
         return subtotal-descuento;
        }
    }


