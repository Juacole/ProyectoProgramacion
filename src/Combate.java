public final class Combate {

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
