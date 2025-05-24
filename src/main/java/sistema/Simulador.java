package main.java.sistema;

import main.java.personajes.Personaje;
import main.java.personajes.monstruos.Monstruo;

import java.util.ArrayList;
import java.util.Random;

public class Simulador {
    private Mazmorra mazmorra;
    private ArrayList<Personaje> grupoPersonajes;
    private int combatesRealizados;
    private boolean victoria;

    public Simulador() {
        this.mazmorra = null;
        this.grupoPersonajes = new ArrayList<>();
        this.combatesRealizados = 0;
        this.victoria = false;
    }

    public Simulador(Mazmorra mazmorra, ArrayList<Personaje> grupoPersonajes) {
        setMazmorra(mazmorra);
        this.grupoPersonajes = new ArrayList<>();
        setGrupoPersonajes(grupoPersonajes);
        this.combatesRealizados = 0;
        this.victoria = false;
    }

    public Simulador(Simulador copia) {
        setMazmorra(copia.getMazmorra());
        this.grupoPersonajes = new ArrayList<>();
        setGrupoPersonajes(copia.getGrupoPersonajes());
        this.combatesRealizados = copia.getCombatesRealizados();
        this.victoria = copia.getVictoria();
    }

    public void iniciarSimulacion() {
        if (this.mazmorra == null || this.grupoPersonajes.isEmpty()) {
            System.out.println("No se puede iniciar la simulación sin una mazmorra y un grupo de personajes.");
            this.victoria = false;
        }

        System.out.println("\n=== INICIO DE LA SIMULACIÓN EN " + mazmorra.getNombre() + " ===");
        System.out.println("Grupo de aventureros: ");
        for (Personaje p : grupoPersonajes) {
            System.out.println("- " + p.getNombre() + " (" + p.getRaza() + ", Nivel " + p.getNivel() + ")");
        }
        System.out.println("\nComienzan los combates...\n");

        this.combatesRealizados = 0;
        this.victoria = false;

        while (this.combatesRealizados < 10 && !this.grupoPersonajes.isEmpty()) {
            this.combatesRealizados++;
            System.out.println("\n=== COMBATE " + this.combatesRealizados + " DE 10 ===");

            ArrayList<Personaje> grupoMonstruos = generarGrupoMonstruos();

            if (grupoMonstruos.isEmpty()) {
                System.out.println("No hay monstruos disponibles en la mazmorra. Avanzando al siguiente combate.");
            }else {
                System.out.println("El grupo se enfrenta a:");
                for (Personaje m : grupoMonstruos) {
                    System.out.println("- " + m.getNombre() + " (" + m.getRaza() + ", Nivel " + m.getNivel() + ")");
                }
                Combate.combateGrupo(this.grupoPersonajes, grupoMonstruos);
            }
        }

        if (this.combatesRealizados >= 10 && !this.grupoPersonajes.isEmpty()) {
            this.victoria = true;
            System.out.println("\n¡VICTORIA! El grupo ha superado los 10 combates en la mazmorra " + this.mazmorra.getNombre());
            System.out.println("Sobrevivientes:");
            for (Personaje p : this.grupoPersonajes) {
                System.out.println("- " + p.getNombre() + " (Nivel " + p.getNivel() + ", Vida: " + p.getPuntos_vida() + ")");
            }
        } else if (this.grupoPersonajes.isEmpty()) {
            System.out.println("\n¡DERROTA! Todos los personajes han caído en la mazmorra " + this.mazmorra.getNombre());
            System.out.println("La expedición ha fracasado después de " + this.combatesRealizados + " combates.");
        }
    }

    private ArrayList<Personaje> generarGrupoMonstruos() {
        ArrayList<Personaje> grupoMonstruos = new ArrayList<>();
        Random random = new Random();
        int cantidadMonstruos = random.nextInt(3) + 1;

        for (int i = 0; i < cantidadMonstruos; i++) {
            Monstruo monstruo = this.mazmorra.combateAleatorio();
            if (monstruo != null) {
                Monstruo copiaMonstruo = new Monstruo(monstruo);
                grupoMonstruos.add(copiaMonstruo);
            }
        }
        return grupoMonstruos;
    }

    public Mazmorra getMazmorra() {
        return this.mazmorra;
    }

    public void setMazmorra(Mazmorra mazmorra) {
        this.mazmorra = new Mazmorra(mazmorra);
    }

    public ArrayList<Personaje> getGrupoPersonajes() {
        return this.grupoPersonajes;
    }

    public void setGrupoPersonajes(ArrayList<Personaje> grupoPersonajes) {
        this.grupoPersonajes = new ArrayList<>(grupoPersonajes);
    }

    public int getCombatesRealizados() {
        return this.combatesRealizados;
    }

    public boolean getVictoria() {
        return this.victoria;
    }
}
