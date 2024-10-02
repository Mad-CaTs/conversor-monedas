package sources;

public class Convert {
    private String monedaBase;
    private String monedaCambio;
    private double monedaTotal;

    public Convert(String monedaBase, String monedaCambio, double monedaTotal) {
        this.monedaBase = monedaBase;
        this.monedaCambio = monedaCambio;
        this.monedaTotal = monedaTotal;
    }

    // Getters y Setters
    public String getMonedaBase() {
        return monedaBase;
    }
    public void setMonedaBase(String monedaBase) {
        this.monedaBase = monedaBase;
    }

    public String getMonedaCambio() {
        return monedaCambio;
    }
    public void setMonedaCambio(String monedaCambio) {
        this.monedaCambio = monedaCambio;
    }

    public double getMonedaTotal() {
        return monedaTotal;
    }
    public void setMonedaTotal(double monedaTotal) {
        this.monedaTotal = monedaTotal;
    }
}
