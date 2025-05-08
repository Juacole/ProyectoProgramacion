package main.java;

import main.java.equipamiento.Arma;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> estadisticas = new HashMap<>();
        estadisticas.put("ataque", 54);
        estadisticas.put("velocidad", 76);
        estadisticas.put("magia", 23);
        estadisticas.put("fe", 65);
        estadisticas.put("armadura", 98);
        estadisticas.put("resistencia_magica", 45);

        Arma arma = new Arma("Palo", estadisticas, "Comun", 34.8, false, "espada");

        HashMap<String, Integer> estadisticas2 = new HashMap<>();
        estadisticas2.put("ataque", 54);
        estadisticas2.put("velocidad", 76);
        estadisticas2.put("magia", 23);
        estadisticas2.put("fe", 65);
        estadisticas2.put("armadura", 98);
        estadisticas2.put("resistencia_magica", 45);

        System.out.println(arma.toString());
        Arma arma2 = new Arma(arma);
        System.out.println(arma2.toString());
    }
}
