package main.java;

import main.java.equipamiento.Equipamiento;

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
        Equipamiento equipamiento = new Equipamiento("Prueba", estadisticas, "Comun", 34.8);

        System.out.println(equipamiento.toString());

        HashMap<String, Integer> estadisticas2 = new HashMap<>();
        estadisticas2.put("ataque", 54);
        estadisticas2.put("velocidad", 76);
        estadisticas2.put("magia", 23);
        estadisticas2.put("fe", 65);
        estadisticas2.put("armadura", 98);
        estadisticas2.put("resistencia_magica", 45);
        Equipamiento equipamiento2 = new Equipamiento("Prueba", estadisticas2, "Comun", 34.8);

        System.out.println(equipamiento2.toString());

        System.out.println(equipamiento.equals(equipamiento2));
    }
}
