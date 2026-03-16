public class App {
    public static void main(String[] args) {
        System.out.println("=== TEST DE SISTEMA BASE MK ===");

        // instanciamos dos kombatientes (Stryker es controlado por humano)
        Kombatiente stryker = new Kombatiente("Stryker", "Earthrealm", 62);
        stryker.setControladoPorHumano(true); 
        
        Kombatiente liuKang = new Kombatiente("Liu Kang", "White Lotus", 219);

        // creamos sus estadísticas para el torneo de prueba
        Estadisticas statsStryker = new Estadisticas(stryker);
        Estadisticas statsLiuKang = new Estadisticas(liuKang);

        // creamos el combate de prueba
        System.out.println(">> Poniendo a prueba el motor de Kombate...");
        Kombate pelea = new Kombate(stryker, liuKang);
        
        // Jugamos con empate permitido (como si fuera fase de grupos), false para que NO sea silencioso
        pelea.jugar(true, false); 

        // registramos el resultado del combate en las estadísticas de ambos kombatientes
        statsStryker.registrarKombate(pelea.getRoundsLocal(), pelea.getRoundsVisitante());
        statsLiuKang.registrarKombate(pelea.getRoundsVisitante(), pelea.getRoundsLocal());

        // imprimimos el resultado del combate
        System.out.println("\n=== TABLA DE POSICIONES PRUEBA ===");
        System.out.println(statsStryker.getKombatiente().getNombre() + " - Puntos: " + statsStryker.getPuntos() + " | Dif. Rounds: " + statsStryker.getDiferenciaRounds());
        System.out.println(statsLiuKang.getKombatiente().getNombre() + " - Puntos: " + statsLiuKang.getPuntos() + " | Dif. Rounds: " + statsLiuKang.getDiferenciaRounds());
    }
}