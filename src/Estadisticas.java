import java.io.Serializable;

/**
 * Actúa como una "mochila" de datos para un Kombatiente durante un torneo específico.
 * Implementa Comparable para permitir el ordenamiento automático de tablas de posiciones.
 */
public class Estadisticas implements Serializable, Comparable<Estadisticas> {
    private Kombatiente kombatiente;
    private int puntos, kombatesJugados, kombatesGanados, kombatesEmpatados, kombatesPerdidos, roundsFavor, roundsContra;
    
    public Estadisticas(Kombatiente k) {
        this.kombatiente = k;
    }

    /**
     * Registra el resultado de un kombate y actualiza el balance de la tabla.
     */
    public void registrarKombate(int roundsF, int roundsC) {
        this.kombatesJugados++;
        this.roundsFavor += roundsF;
        this.roundsContra += roundsC;
        
        if (roundsF > roundsC) { 
            this.puntos += 3; 
            this.kombatesGanados++; 
        } else if (roundsF == roundsC) { 
            this.puntos += 1;
            this.kombatesEmpatados++; 
        } else { 
            this.kombatesPerdidos++;
        }
    }

    // Getters
    public Kombatiente getKombatiente() { return kombatiente; }
    public int getPuntos() { return puntos; }
    public int getKombatesJugados() { return kombatesJugados; }
    public int getKombatesGanados() { return kombatesGanados; }
    public int getKombatesEmpatados() { return kombatesEmpatados; }
    public int getKombatesPerdidos() { return kombatesPerdidos; }
    public int getRoundsFavor() { return roundsFavor; }
    public int getRoundsContra() { return roundsContra; }
    public int getDiferenciaRounds() { return roundsFavor - roundsContra; }

    /**
     * Define el criterio de desempate en la tabla de posiciones:
     * 1ro: Puntos | 2do: Diferencia de Rounds | 3ro: Rounds a Favor
     */
    @Override
    public int compareTo(Estadisticas otro) {
        if (this.puntos != otro.puntos) return otro.puntos - this.puntos;
        if (this.getDiferenciaRounds() != otro.getDiferenciaRounds()) return otro.getDiferenciaRounds() - this.getDiferenciaRounds();
        return otro.roundsFavor - this.roundsFavor;
    }
}