package main.java;

import main.java.equipamiento.Arma;
import main.java.equipamiento.Armadura;
import main.java.equipamiento.Artefacto;
import main.java.personajes.*;
import main.java.personajes.creyentes.Clerigo;
import main.java.personajes.creyentes.Paladin;
import main.java.sistema.Combate;
import main.java.sistema.Mazmorra;
import main.java.sistema.Simulador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {

        final String path = "C:\\Users\\Hp\\Desktop\\DAM\\PROGRAMACION\\PRACTICAS\\ProyectoProgramacion\\Ficheros\\registro_combates\\";
        /*
        HashMap<String, Integer> estadisticas = new HashMap<>();
        estadisticas.put("ataque", 54);
        estadisticas.put("velocidad", 76);
        estadisticas.put("magia", 23);
        estadisticas.put("fe", 65);
        estadisticas.put("armadura", 98);
        estadisticas.put("resistencia_magica", 45);

        Armadura armadura1 = new Armadura("prueba1",estadisticas,"comun",34.7,"yelmo","cuero");
        Armadura armadura2 = new Armadura("prueba1",estadisticas,"comun",34.7,"pechera","cuero");
        Armadura armadura3 = new Armadura("prueba1",estadisticas,"comun",34.7,"hombreras","cuero");
        Armadura armadura4 = new Armadura("prueba1",estadisticas,"comun",34.7,"guanteletes","cuero");
        Armadura armadura5 = new Armadura("prueba1",estadisticas,"comun",34.7,"grebas","cuero");
        Armadura armadura6 = new Armadura("prueba1",estadisticas,"comun",34.7,"botas","cuero");
        HashMap<String,Armadura> armadura = new HashMap<String, Armadura>();
        armadura.put("yelmo", armadura1);
        armadura.put("pechera", armadura2);
        armadura.put("hombreras", armadura3);
        armadura.put("guanteletes", armadura4);
        armadura.put("grebas", armadura5);
        armadura.put("botas", armadura6);
        Personaje nuevo_personaje = new Personaje("pedro", "humano");
        nuevo_personaje.setArmadura(armadura1);
        //System.out.println(nuevo_personaje.getArmadura());
        System.out.println(nuevo_personaje.toString());

         */
        /*
        HashMap<String, Integer> estadisticas2 = new HashMap<>();
        estadisticas2.put("ataque", 54);
        estadisticas2.put("velocidad", 76);
        estadisticas2.put("magia", 23);
        estadisticas2.put("fe", 65);
        estadisticas2.put("armadura", 98);
        estadisticas2.put("resistencia_magica", 45);

        Armadura armadura = new Armadura();
        armadura.setTipo("pechera");
        */
        /*
        Arma arma = new Arma();
        Guerrero guerrero = new Guerrero();
        guerrero.setArmaComplementaria(arma);
        Mago mago = new Mago();

         */

        /*
        Combate combate = new Combate();

        System.out.println(combate.getArmas());


        Guerrero guerrero = new Guerrero();
        guerrero.setArmaComplementaria(combate.generarArma());
        System.out.println(combate.getArmas());

         */

        /*
        String path = "C:\\Users\\Hp\\Desktop\\DAM\\PROGRAMACION\\PRACTICAS\\ProyectoProgramacion\\Ficheros\\equipamiento\\tesoros\\";
        ArrayList<String> armas = new ArrayList<>();
        ArrayList<String> armaduras = new ArrayList<>();
        ArrayList<String> artefactos = new ArrayList<>();

         */

        /*
        String[] ficheros = {"armas.csv","armadura.csv","artefactos.csv"};
        try {
            for(int i = 0; i < ficheros.length; i++){
                File fichero = new File(path + ficheros[i]);
                if(fichero.canRead()){
                    FileReader fr = new FileReader(fichero);
                    BufferedReader br = new BufferedReader(fr);
                    String linea;
                    while((linea = br.readLine()) != null){
                        if(i == 0 && !linea.startsWith("Nombre")){
                            armas.add(linea + "\n");
                        }else if(i == 1 && !linea.startsWith("Nombre")){
                            armaduras.add(linea + "\n");
                        }else if(i == 2 && !linea.startsWith("Nombre")){
                            artefactos.add(linea + "\n");
                        }
                    }
                }
            }
        }catch (IOException ioe){
            throw new RuntimeException(ioe);
        }
        Random random = new Random();
        String[] arma = armas.get(random.nextInt(armas.size())).toLowerCase().split(",");
        for(int i = 0; i < arma.length; i++){
            System.out.println(arma[i]);
        }

         */
        /*
        HashMap<String, Integer> estadisticas2 = new HashMap<>();
        estadisticas2.put("ataque", 54);
        estadisticas2.put("velocidad", 76);
        estadisticas2.put("magia", 23);
        estadisticas2.put("fe", 65);
        estadisticas2.put("armadura", 98);
        estadisticas2.put("resistencia_magica", 45);
        Arma arma = new Arma("escalibur",estadisticas2,"comun",12,"espada");

        HashMap<String, Integer> estadisticas = new HashMap<>();
        estadisticas.put("ataque", 54);
        estadisticas.put("velocidad", 76);
        estadisticas.put("magia", 23);
        estadisticas.put("fe", 65);
        estadisticas.put("armadura", 98);
        estadisticas.put("resistencia_magica", 45);
        Artefacto artefacto = new Artefacto("lujuria",estadisticas,"legendario",35,"amuleto");
        Combate combate = new Combate();
        Guerrero guerrero = new Guerrero("guerrero", "Orco",arma);
        Ladron ladron = new Ladron("ladron", "Humano",artefacto);
        Mago mago = new Mago("mago","humano");
        Cazador cazador = new Cazador("cazador", "elfo", "mondonguito", "canido");
        Paladin paladin = new Paladin("paladin","humano");
        Clerigo clerigo = new Clerigo("clerigo","ariquipeño");
        for(int i = 0; i < 30; i++){
            paladin.subirNivel();
        }

        for (int i = 0; i < 7; i++){
            mago.subirNivel();
            cazador.subirNivel();
        }

        for(int i = 0; i < 4; i++){
            ladron.subirNivel();
            clerigo.subirNivel();
            guerrero.subirNivel();
        }

        ArrayList<Personaje> grupo1 = new ArrayList<>();
        grupo1.add(clerigo);
        grupo1.add(cazador);
        grupo1.add(guerrero);

        ArrayList<Personaje> grupo2 = new ArrayList<>();
        grupo2.add(mago);
        grupo2.add(ladron);
        grupo2.add(paladin);

        Combate.combateGrupo(grupo1,grupo2);
        //Combate.iniciarCombate(manolo,maicelo);
        //System.out.println(manolo.toString());

         */


        Mazmorra mazmorra = new Mazmorra("C:\\Users\\Hp\\Desktop\\DAM\\PROGRAMACION\\PRACTICAS\\ProyectoProgramacion\\Ficheros\\equipamiento\\mazmorras\\hogarDelHacedor.csv");
        //System.out.println(mazmorra.toString());


        HashMap<String, Integer> estadisticas2 = new HashMap<>();
        estadisticas2.put("ataque", 54);
        estadisticas2.put("velocidad", 76);
        estadisticas2.put("magia", 23);
        estadisticas2.put("fe", 65);
        estadisticas2.put("armadura", 98);
        estadisticas2.put("resistencia_magica", 45);
        Arma arma = new Arma("escalibur",estadisticas2,"comun",12,"espada");

        HashMap<String, Integer> estadisticas = new HashMap<>();
        estadisticas.put("ataque", 54);
        estadisticas.put("velocidad", 76);
        estadisticas.put("magia", 23);
        estadisticas.put("fe", 65);
        estadisticas.put("armadura", 98);
        estadisticas.put("resistencia_magica", 45);
        Artefacto artefacto = new Artefacto("lujuria",estadisticas,"legendario",35,"amuleto");
        Combate combate = new Combate();
        Guerrero guerrero = new Guerrero("guerrero", "Orco",arma);
        Ladron ladron = new Ladron("ladron", "Humano",artefacto);
        Mago mago = new Mago("mago","humano");
        Cazador cazador = new Cazador("cazador", "elfo", "mondonguito", "canido");
        Paladin paladin = new Paladin("paladin","humano");
        Clerigo clerigo = new Clerigo("clerigo","ariquipeño");
        for(int i = 0; i < 30; i++){
            paladin.subirNivel();
        }

        for (int i = 0; i < 7; i++){
            mago.subirNivel();
            cazador.subirNivel();
        }

        for(int i = 0; i < 4; i++){
            ladron.subirNivel();
            clerigo.subirNivel();
            guerrero.subirNivel();
        }

        ArrayList<Personaje> grupo1 = new ArrayList<>();
        grupo1.add(clerigo);
        grupo1.add(cazador);
        grupo1.add(guerrero);
        grupo1.add(ladron);
        grupo1.add(mago);
        grupo1.add(paladin);

        Simulador simulador = new Simulador(mazmorra,grupo1);
        simulador.iniciarSimulacion();
    }
}
