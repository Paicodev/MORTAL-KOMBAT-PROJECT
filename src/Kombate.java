import java.util.Random;
import java.util.Scanner;

/**
 * Controlador que maneja la lógica de enfrentamiento entre dos Kombatientes.
 * Permite tanto la simulación mediante IA como el ingreso manual de resultados.
 */
public class Kombate {
    private Kombatiente local;
    private Kombatiente visitante;
    private int roundsLocal;
    private int roundsVisitante;

    public Kombate(Kombatiente local, Kombatiente visitante) {
        this.local = local;
        this.visitante = visitante;
    }

    /**
     * Inicia el kombate. Decide si abre el modo manual (si hay un humano) o simula.
     */
    public void jugar(boolean permiteEmpate, boolean silencioso) {
        if (local.esHumano() || visitante.esHumano()) {
            jugarManual(permiteEmpate);
        } else {
            simularIA(permiteEmpate);
            if (!silencioso) {
                System.out.println("RESULTADO: " + local.getNombre() + " " + roundsLocal + " - " + roundsVisitante + " " + visitante.getNombre());
            }
        }
    }

    private void jugarManual(boolean permiteEmpate) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Rounds ganados por " + local.getNombre() + ": ");
                roundsLocal = Integer.parseInt(sc.nextLine());
                System.out.print("Rounds ganados por " + visitante.getNombre() + ": ");
                roundsVisitante = Integer.parseInt(sc.nextLine());

                // Validación estricta MK para Playoffs
                if (!permiteEmpate && roundsLocal == roundsVisitante) {
                    System.out.println("No puede haber empate en Playoffs. Ingresa un ganador (Ej: 2-0 o 2-1).");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Error de ingreso. Digita un número válido.");
            }
        }
    }

    /**
     * Simula el kombate calculando probabilidades según el PuntosRanking de cada personaje.
     */
    private void simularIA(boolean permiteEmpate) {
        Random rnd = new Random();
        double factorL = local.getPuntosRanking() + rnd.nextInt(50);
        double factorV = visitante.getPuntosRanking() + rnd.nextInt(50);

        if (permiteEmpate && Math.abs(factorL - factorV) < 30 && rnd.nextInt(100) < 35) {
            // Empate por similitud de poder
            roundsLocal = 1;
            roundsVisitante = 1;
        } else if (factorL > factorV) {
            // Gana Local
            roundsLocal = 2;
            roundsVisitante = rnd.nextInt(2);
        } else {
            // Gana Visitante
            roundsLocal = rnd.nextInt(2);
            roundsVisitante = 2;
        }
    }

    public int getRoundsLocal() { return roundsLocal; }
    public int getRoundsVisitante() { return roundsVisitante; }
}