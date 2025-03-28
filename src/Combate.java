/**
 * La clase COmbate representa un combate entre dos personajes. Este combate se resuelve
 * mediante un enfrentamiento en el que los dos personajes infligen daño por turnos hasta que uno de ellos
 * tenga sus puntos de vida reducidos a cero, momento en el que se considera derrotado. El combate se basa
 * en las siguientes reglas:
 * <ul>
 *   <li>Los personajes se infligen daño por turnos, y cada uno ataca dependiendo de su velocidad.</li>
 *   <li>El personaje con mayor velocidad ataca primero. Si un personaje tiene el doble de velocidad que el otro, ataca dos veces consecutivas.</li>
 *   <li>Los ataques se calculan usando el método luchar de cada personaje.</li>
 *   <li>El primer personaje en reducir los puntos de vida del oponente a cero es declarado vencedor.</li>
 *   <li>Se imprime un registro detallado de cada turno del combate.</li>
 * </ul>
 *
 * @author Joaquin Puchuri Tunjar
 * @version 1.0
 */
public final class Combate {

    /**
     * Inicia el combate entre dos personajes, y los personajes se atacarán según
     * su velocidad, y el combate continuará hasta que uno de los personajes tenga
     * cero puntos de vida.
     *
     * @param pepe1 el primer personaje que participa en el combate.
     * @param pepe2 el segundo personaje que participa en el combate.
     */
    public static void iniciarCombate(Personaje pepe1, Personaje pepe2) {
        if (pepe1.getPuntos_vida() > 0 && pepe2.getPuntos_vida() > 0) {
            System.out.println("\nEn un mundo donde solo los más fuertes sobreviven...");
            System.out.println("Dos guerreros se encuentran en un campo de batalla marcado por antiguas luchas.");
            System.out.println(pepe1.getNombre() + ", un valeroso " + pepe1.getRaza() + ", afila su arma mientras observa a su oponente.");
            System.out.println("A unos pasos de distancia, " + pepe2.getNombre() + ", un feroz " + pepe2.getRaza() + ", deja escapar una risa desafiante.");
            System.out.println("El viento se detiene. La tensión es insoportable.");
            System.out.println("¡Que comience el combate!\n");

            System.out.println(pepe1.toString() + "\n");
            System.out.println(pepe2.toString() + "\n");

            do {
                if (pepe1.getPuntos_velocidad() >= pepe2.getPuntos_velocidad() * 2) {
                    System.out.println(pepe1.getNombre() + " es increíblemente rápido y ataca dos veces seguidas");
                    pepe2.setPuntos_vida(pepe2.getPuntos_vida() - (pepe1.luchar() * 2));
                    System.out.println("---" + pepe1.getNombre() + " inflige un total de " + pepe1.luchar()*2 + " puntos de ataque---");
                    System.out.println(pepe2.getNombre() + " contraataca con todas sus fuerzas.");
                    pepe1.setPuntos_vida(pepe1.getPuntos_vida() - pepe2.luchar());
                    System.out.println("---" + pepe2.getNombre() + " inflige un total de " + pepe2.luchar() + " puntos de ataque---");

                } else if (pepe2.getPuntos_velocidad() >= pepe1.getPuntos_velocidad() * 2) {
                    System.out.println(pepe2.getNombre() + " aprovecha su agilidad y ataca dos veces seguidas");
                    pepe1.setPuntos_vida(pepe1.getPuntos_vida() - (pepe2.luchar() * 2));
                    System.out.println("---" + pepe2.getNombre() + " inflige un total de " + pepe2.luchar()*2 + " puntos de ataque---");
                    System.out.println(pepe1.getNombre() + " responde con un feroz contraataque.");
                    pepe2.setPuntos_vida(pepe2.getPuntos_vida() - pepe1.luchar());
                    System.out.println("---" + pepe1.getNombre() + " inflige un total de " + pepe1.luchar() + " puntos de ataque---");

                } else if (pepe1.getPuntos_velocidad() > pepe2.getPuntos_velocidad()) {
                    System.out.println(pepe1.getNombre() + " es más rápido y ataca primero!");
                    pepe2.setPuntos_vida(pepe2.getPuntos_vida() - pepe1.luchar());
                    System.out.println("---" + pepe1.getNombre() + " inflige un total de " + pepe1.luchar() + " puntos de ataque---");
                    System.out.println(pepe1.getNombre() + " golpea a " + pepe2.getNombre() + " con precisión, pero " + pepe2.getNombre() + " responde con un fuerte golpe.");
                    pepe1.setPuntos_vida(pepe1.getPuntos_vida() - pepe2.luchar());
                    System.out.println("---" + pepe2.getNombre() + " inflige un total de " + pepe2.luchar() + " puntos de ataque---");

                } else {
                    System.out.println(pepe2.getNombre() + " es más rápido y ataca primero!");
                    pepe1.setPuntos_vida(pepe1.getPuntos_vida() - pepe2.luchar());
                    System.out.println("---" + pepe2.getNombre() + " inflige un total de " + pepe2.luchar() + " puntos de ataque---");
                    System.out.println(pepe2.getNombre() + " ataca sin dudarlo, pero " + pepe1.getNombre() + " contraataca con furia.");
                    pepe2.setPuntos_vida(pepe2.getPuntos_vida() - pepe1.luchar());
                    System.out.println("---" + pepe1.getNombre() + " inflige un total de " + pepe1.luchar() + " puntos de ataque---");
                }
                System.out.println("\nVida de " + pepe1.getNombre() + ": " + pepe1.getPuntos_vida());
                System.out.println("Vida de " + pepe2.getNombre() + ": " + pepe2.getPuntos_vida() + "\n");

            } while (pepe1.getPuntos_vida() > 0 && pepe2.getPuntos_vida() > 0);

            if (pepe1.getPuntos_vida() > 0) {
                System.out.println(pepe1.getNombre() + " ha derrotado a " + pepe2.getNombre());
            } else {
                System.out.println(pepe2.getNombre() + " ha derrotado a " + pepe1.getNombre());
            }

            System.out.println("El combate ha terminado. Solo el más fuerte queda en pie.");
        }
    }
}
