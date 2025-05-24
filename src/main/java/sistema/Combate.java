package main.java.sistema;

import main.java.equipamiento.Arma;
import main.java.equipamiento.Armadura;
import main.java.equipamiento.Artefacto;
import main.java.equipamiento.Equipamiento;
import main.java.personajes.Personaje;
import main.java.utils.GameLogger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

import static java.util.Collections.addAll;

/**
 * La clase Combate representa un combate entre dos personajes. Este combate se resuelve
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
    private final static String path = "C:\\Users\\Hp\\Desktop\\DAM\\PROGRAMACION\\PRACTICAS\\ProyectoProgramacion\\Ficheros\\equipamiento\\tesoros\\";
    private static ArrayList<String> armas = new ArrayList<>();
    private static ArrayList<String> armaduras = new ArrayList<>();
    private static ArrayList<String> artefactos = new ArrayList<>();
    private static  String[] ficheros = {
            "armas.csv",
            "armadura.csv",
            "artefactos.csv"
    };

    private static void recuperarEquipamientos(){
        try {
            for(int i = 0; i < ficheros.length; i++){
                File fichero = new File(path + ficheros[i]);
                if(fichero.canRead()){
                    FileReader fr = new FileReader(fichero);
                    BufferedReader br = new BufferedReader(fr);
                    String linea;
                    while((linea = br.readLine()) != null){
                        if(i == 0 && !linea.startsWith("Nombre")){
                            armas.add(linea);
                        }else if(i == 1 && !linea.startsWith("Nombre")){
                            armaduras.add(linea);
                        }else if(i == 2 && !linea.startsWith("Nombre")){
                            artefactos.add(linea);
                        }
                    }
                }
            }
        }catch (IOException ioe){
            throw new RuntimeException(ioe);
        }
    }

    public static Arma generarArma(){
        Random random = new Random();
        int num_random = random.nextInt(armas.size());
        HashMap<String, Integer> estadisticas_totales = new HashMap<>();
        String[] arma_inicializar = armas.get(num_random).toLowerCase().split(",");
        armas.remove(num_random);
        String[] estadisticas = arma_inicializar[3].split("-");
        estadisticas_totales.put("ataque", Integer.parseInt(estadisticas[0]));
        estadisticas_totales.put("velocidad", Integer.parseInt(estadisticas[1]));
        estadisticas_totales.put("magia", Integer.parseInt(estadisticas[2]));
        estadisticas_totales.put("fe", Integer.parseInt(estadisticas[3]));
        estadisticas_totales.put("armadura", 0);
        estadisticas_totales.put("resistencia_magica", 0);
        estadisticas_totales.put("vida", 0);

        Arma arma = new Arma(arma_inicializar[0],
                estadisticas_totales,
                arma_inicializar[1],
                Integer.parseInt(arma_inicializar[4]),
                arma_inicializar[2]
        );
        return arma;
    }

    private static Armadura generarArmadura(){
        Random random = new Random();
        HashMap<String, Integer> estadisticas_totales = new HashMap<>();
        int num_random = random.nextInt(armaduras.size());
        String[] armadura_inicializar = armaduras.get(num_random).toLowerCase().split(",");
        armaduras.remove(num_random);
        String[] estadisticas = armadura_inicializar[4].split("-");
        estadisticas_totales.put("ataque", 0);
        estadisticas_totales.put("velocidad", 0);
        estadisticas_totales.put("magia", 0);
        estadisticas_totales.put("fe", 0);
        estadisticas_totales.put("armadura",  Integer.parseInt(estadisticas[0]));
        estadisticas_totales.put("resistencia_magica",  Integer.parseInt(estadisticas[1]));
        estadisticas_totales.put("vida", Integer.parseInt(estadisticas[2]));

        Armadura armadura = new Armadura(
                armadura_inicializar[0],
                estadisticas_totales,
                armadura_inicializar[1],
                Integer.parseInt(armadura_inicializar[5]),
                armadura_inicializar[2],
                armadura_inicializar[3]
        );
        return armadura;
    }

    private static Artefacto generarArtefacto(){
        Random random = new Random();
        HashMap<String, Integer> estadisticas_totales = new HashMap<>();
        int num_random = random.nextInt(artefactos.size());
        String[] artefacto_inicializar = artefactos.get(num_random).toLowerCase().split(",");
        String[] estadisticas = artefacto_inicializar[3].split("-");
        estadisticas_totales.put("ataque", Integer.parseInt(estadisticas[0]));
        estadisticas_totales.put("velocidad", Integer.parseInt(estadisticas[1]));
        estadisticas_totales.put("magia", Integer.parseInt(estadisticas[2]));
        estadisticas_totales.put("fe", Integer.parseInt(estadisticas[3]));
        estadisticas_totales.put("armadura",  Integer.parseInt(estadisticas[4]));
        estadisticas_totales.put("resistencia_magica", Integer.parseInt(estadisticas[5]));
        estadisticas_totales.put("vida", Integer.parseInt(estadisticas[6]));

        Artefacto artefacto = new Artefacto(
                artefacto_inicializar[0],
                estadisticas_totales,
                artefacto_inicializar[1],
                Integer.parseInt(artefacto_inicializar[4]),
                artefacto_inicializar[2]
        );
        return artefacto;
    }

    public static void equiparGanador(Personaje pepeGanador){
        Random random = new Random();
        int eleccion = random.nextInt(3);
        switch (eleccion) {
            case 0:
                pepeGanador.setArma(generarArma());
                System.out.println(
                        "El personaje " +
                                pepeGanador.getNombre() +
                                " ha sido recompensado con un arma por ganar su combate."
                );
                break;
            case 1:
                pepeGanador.setArmadura(generarArmadura());
                System.out.println(
                        "El personaje " +
                                pepeGanador.getNombre() +
                                " ha sido recompensado con una pieza de armadura por ganar su combate."
                );
                break;
            case 2:
                pepeGanador.setArtefacto(generarArtefacto());
                System.out.println(
                        "El personaje " +
                                pepeGanador.getNombre() +
                                " ha sido recompensado con un artefacto por ganar su combate."
                );
                break;
        }
    }

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
            presentacionCombate(pepe1,pepe2);
            do {
                if (pepe1.getPuntos_velocidad() >= pepe2.getPuntos_velocidad() * 2) {
                    System.out.println(pepe1.getNombre() + " es increíblemente rápido y ataca dos veces seguidas");
                    pepe2.defender( pepe1.luchar() * 2);
                    System.out.println("---" + pepe1.getNombre() + " inflige un total de " + pepe1.luchar()*2 + " puntos de ataque---");
                    System.out.println(pepe2.getNombre() + " contraataca con todas sus fuerzas.");
                    pepe1.defender(pepe2.luchar());
                    System.out.println("---" + pepe2.getNombre() + " inflige un total de " + pepe2.luchar() + " puntos de ataque---");

                } else if (pepe2.getPuntos_velocidad() >= pepe1.getPuntos_velocidad() * 2) {
                    System.out.println(pepe2.getNombre() + " aprovecha su agilidad y ataca dos veces seguidas");
                    pepe1.defender(pepe2.luchar() * 2);
                    System.out.println("---" + pepe2.getNombre() + " inflige un total de " + pepe2.luchar()*2 + " puntos de ataque---");
                    System.out.println(pepe1.getNombre() + " responde con un feroz contraataque.");
                    pepe2.defender(pepe1.luchar());
                    System.out.println("---" + pepe1.getNombre() + " inflige un total de " + pepe1.luchar() + " puntos de ataque---");

                } else if (pepe1.getPuntos_velocidad() > pepe2.getPuntos_velocidad()) {
                    System.out.println(pepe1.getNombre() + " es más rápido y ataca primero!");
                    pepe2.defender(pepe1.luchar());
                    System.out.println("---" + pepe1.getNombre() + " inflige un total de " + pepe1.luchar() + " puntos de ataque---");
                    System.out.println(pepe1.getNombre() + " golpea a " + pepe2.getNombre() + " con precisión, pero " + pepe2.getNombre() + " responde con un fuerte golpe.");
                    pepe1.defender(pepe2.luchar());
                    System.out.println("---" + pepe2.getNombre() + " inflige un total de " + pepe2.luchar() + " puntos de ataque---");

                } else {
                    System.out.println(pepe2.getNombre() + " es más rápido y ataca primero!");
                    pepe1.defender(pepe2.luchar());
                    System.out.println("---" + pepe2.getNombre() + " inflige un total de " + pepe2.luchar() + " puntos de ataque---");
                    System.out.println(pepe2.getNombre() + " ataca sin dudarlo, pero " + pepe1.getNombre() + " contraataca con furia.");
                    pepe2.defender(pepe1.luchar());
                    System.out.println("---" + pepe1.getNombre() + " inflige un total de " + pepe1.luchar() + " puntos de ataque---");
                }
                System.out.println("\nVida de " + pepe1.getNombre() + ": " + pepe1.getPuntos_vida());
                System.out.println("Vida de " + pepe2.getNombre() + ": " + pepe2.getPuntos_vida() + "\n");

            } while (pepe1.getPuntos_vida() > 0 && pepe2.getPuntos_vida() > 0);
            recuperarEquipamientos();
            generarArma();
            generarArmadura();
            generarArtefacto();

            if (pepe1.getPuntos_vida() > 0) {
                System.out.println("El ganador es " + pepe1.getNombre() + ", ha derrotado a " + pepe2.getNombre());
                equiparGanador(pepe1);
            } else {
                System.out.println("El ganador es " + pepe2.getNombre() + ", ha derrotado a " + pepe1.getNombre());
                equiparGanador(pepe2);
            }
            System.out.println("El combate ha terminado. Solo el más fuerte queda en pie.");
        }
    }

    public static void combateGrupo(ArrayList<Personaje> grupo1, ArrayList<Personaje> grupo2) {
        int totalRecompensas1 = grupo1.size();
        int totalRecompensas2 = grupo2.size();

        ArrayList<Personaje> grupo1Ordenado = new ArrayList<>(ordenarPorNivel(grupo1));
        ArrayList<Personaje> grupo2Ordenado = new ArrayList<>(ordenarPorNivel(grupo2));

        int i = 0;
        int j = 0;

        System.out.println("=== COMIENZA EL COMBATE ===");
        System.out.println("Equipo 1 (" + grupo1.size() + " miembros) vs Equipo 2 (" + grupo2.size() + " miembros)");
        System.out.println("---------------------------");

        while (i < grupo1Ordenado.size() && j < grupo2Ordenado.size()) {
            Personaje p1 = grupo1Ordenado.get(i);
            Personaje p2 = grupo2Ordenado.get(j);

            boolean p1Valido = grupo1.contains(p1);
            boolean p2Valido = grupo2.contains(p2);

            if (!p1Valido) {
                i++;
            }
            else if (!p2Valido) {
                j++;
            }
            else {
                System.out.println("\nNUEVO COMBATE:");
                System.out.println(p1.getNombre() + " (Nivel " + p1.getNivel() + ") vs " +
                        p2.getNombre() + " (Nivel " + p2.getNivel() + ")");

                if (p1.getPuntos_vida() > 0 && p2.getPuntos_vida() > 0) {
                    System.out.println("Vida inicial: " + p1.getNombre() + " (" + p1.getPuntos_vida() + " HP) - " +
                            p2.getNombre() + " (" + p2.getPuntos_vida() + " HP)");

                    boolean combateEnCurso = true;
                    int round = 1;

                    while (combateEnCurso) {
                        System.out.println("\nRound " + round + ":");

                        p2.defender(p1.luchar());
                        System.out.println(p1.getNombre() + " ataca a " + p2.getNombre() +
                                " causando daño. Vida restante: " + p2.getPuntos_vida() + " HP");

                        if (p2.getPuntos_vida() <= 0) {
                            System.out.println("\n¡" + p2.getNombre() + " ha sido derrotado!");
                            grupo2.remove(p2);
                            combateEnCurso = false;
                            j++;
                        }
                        else {
                            p1.defender(p2.luchar());
                            System.out.println(p2.getNombre() + " contraataca a " + p1.getNombre() +
                                    " causando daño. Vida restante: " + p1.getPuntos_vida() + " HP");

                            if (p1.getPuntos_vida() <= 0) {
                                System.out.println("\n¡" + p1.getNombre() + " ha sido derrotado!");
                                grupo1.remove(p1);
                                combateEnCurso = false;
                                i++;
                            }
                        }
                        round++;
                    }
                }
                else {
                    System.out.println("¡Uno de los combatientes ya está derrotado! Combate cancelado.");
                    if (p1.getPuntos_vida() <= 0) {
                        grupo1.remove(p1);
                        i++;
                    }
                    if (p2.getPuntos_vida() <= 0) {
                        grupo2.remove(p2);
                        j++;
                    }
                }

                System.out.println("\nEstado actual:");
                System.out.println("Equipo 1: " + grupo1.size() + " miembros restantes");
                System.out.println("Equipo 2: " + grupo2.size() + " miembros restantes");
                System.out.println("---------------------------");
            }
        }
        System.out.println("\n=== RESULTADO FINAL ===");
        if (grupo1.isEmpty() && grupo2.isEmpty()) {
            System.out.println("¡Empate! Todos los combatientes han caído");
        }
        else if (grupo1.isEmpty()) {
            System.out.println("¡El Equipo 2 es el vencedor!");
            repartirRecompensasGrupo(grupo2, totalRecompensas1);
        }
        else {
            System.out.println("¡El Equipo 1 es el vencedor!");
            repartirRecompensasGrupo(grupo1, totalRecompensas2);
        }
    }

    private static void repartirRecompensasGrupo(ArrayList<Personaje> grupoGanador, int cantidadRecompensas) {
        recuperarEquipamientos();
        System.out.println("\n=== REPARTO DE RECOMPENSAS ===");
        System.out.println("El grupo ganador recibirá " + cantidadRecompensas + " piezas de equipamiento.");

        ArrayList<Equipamiento> recompensas = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < cantidadRecompensas; i++) {
            int tipo = random.nextInt(3);

            switch (tipo) {
                case 0:
                    recompensas.add(generarArma());
                    break;
                case 1:
                    recompensas.add(generarArmadura());
                    break;
                case 2:
                    recompensas.add(generarArtefacto());
                    break;
            }
        }

        for (Equipamiento recompensa : recompensas) {
            int indice = random.nextInt(grupoGanador.size());
            Personaje ganador = grupoGanador.get(indice);

            //Segui el modelo de diablo, si el objeto te queda, bien, si no te queda pues mala suerte
            if (recompensa instanceof Arma) {
                ganador.setArma((Arma) recompensa);
                System.out.println(ganador.getNombre() + " ha recibido el arma: " + recompensa.getNombre());
            } else if (recompensa instanceof Armadura) {
                ganador.setArmadura((Armadura) recompensa);
                System.out.println(ganador.getNombre() + " ha recibido la armadura: " + recompensa.getNombre());
            } else if (recompensa instanceof Artefacto) {
                ganador.setArtefacto((Artefacto) recompensa);
                System.out.println(ganador.getNombre() + " ha recibido el artefacto: " + recompensa.getNombre());
            }
        }

        System.out.println("FIN DEL REPARTO\n");
    }

    private static ArrayList<Personaje> ordenarPorNivel(ArrayList<Personaje> grupo){
        ArrayList<Personaje> listaOrdenada = new ArrayList<>(grupo);
        Personaje temp;

        for (int i = 0; i < grupo.size() - 1; i++) {
            for (int j = 0; j < grupo.size() - i - 1; j++) {
                if (listaOrdenada.get(j).getNivel() < listaOrdenada.get(j + 1).getNivel()) {
                    temp = listaOrdenada.get(j);
                    listaOrdenada.set(j, listaOrdenada.get(j + 1));
                    listaOrdenada.set(j + 1, temp);
                }
            }
        }

        return listaOrdenada;
    }

    private static void presentacionCombate(Personaje pepe1, Personaje pepe2){
        System.out.println("\nEn un mundo donde solo los más fuertes sobreviven...");
        System.out.println("Dos guerreros se encuentran en un campo de batalla marcado por antiguas luchas.");
        System.out.println(pepe1.getNombre() + ", un valeroso " + pepe1.getRaza() + ", afila su arma mientras observa a su oponente.");
        System.out.println("A unos pasos de distancia, " + pepe2.getNombre() + ", un feroz " + pepe2.getRaza() + ", deja escapar una risa desafiante.");
        System.out.println("El viento se detiene. La tensión es insoportable.");
        System.out.println("¡Que comience el combate!\n");
        System.out.println(pepe1.toString() + "\n");
        System.out.println(pepe2.toString() + "\n");
    }
}
