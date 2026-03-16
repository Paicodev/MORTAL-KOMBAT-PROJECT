import java.io.Serializable;

/**
 * Modelo que encapsula los datos puros de cada luchador.
 * Implementa Serializable para poder guardar el estado en archivos.
 */
public class Kombatiente implements Serializable {
    private String nombre;
    private String confederacion;
    private double puntosRanking;
    private boolean controladoPorHumano;

    /**
     * Constructor para inicializar un nuevo kombatiente.
     */
    public Kombatiente(String nombre, String confederacion, double puntosRanking) {
        this.nombre = nombre;
        this.confederacion = confederacion;
        this.puntosRanking = puntosRanking;
        this.controladoPorHumano = false;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public String getConfederacion() { return confederacion; }
    public double getPuntosRanking() { return puntosRanking; }
    public void setPuntosRanking(double puntosRanking) { this.puntosRanking = puntosRanking; }
    public boolean esHumano() { return controladoPorHumano; }
    public void setControladoPorHumano(boolean controladoPorHumano) { this.controladoPorHumano = controladoPorHumano; }
}