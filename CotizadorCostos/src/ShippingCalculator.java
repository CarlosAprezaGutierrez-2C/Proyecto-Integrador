public class ShippingCalculator {

    // Constantes
    public static final double IVA = 0.16;
    public static final double IMPUESTO_ZONA_REMOTA = 0.10;

    // Atributos
    private double pesoKg;
    private int distanciaKm;
    private int tipoServicio; // 1 = Estándar, 2 = Express
    private boolean esZonaRemota;


    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }

    public void setDistanciaKm(int distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    public void setTipoServicio(int tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public void setEsZonaRemota(boolean esZonaRemota) {
        this.esZonaRemota = esZonaRemota;
    }

    // Lógica de cálculo
    public double calcularSubtotal() {
        double subtotal = 0;

        if (tipoServicio == 1) {
            subtotal += 50;
        } else if (tipoServicio == 2) {
            subtotal += 90;
        }

        if (distanciaKm <= 50) {
            subtotal += 20;
        } else if (distanciaKm <= 200) {
            subtotal += 60;
        } else {
            subtotal += 120;
        }
        subtotal += pesoKg * 12;

        if (esZonaRemota) {
            subtotal += subtotal * IMPUESTO_ZONA_REMOTA;
        }

        return subtotal;
    }

    public double calcularIVA(double subtotal) {
        return subtotal * IVA;
    }

    public double calcularTotal(double subtotal, double iva) {
        return subtotal + iva;
    }
}
