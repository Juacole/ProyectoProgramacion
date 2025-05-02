package main.java.equipamiento;

import java.util.HashMap;

public class Equipamiento {
    private String nombre;
    private HashMap<String, Integer> estadisticas;
    private String rareza;
    private double valor_economico;

    public Equipamiento() {
        this.nombre = "";
        this.estadisticas = new HashMap<>();
        this.estadisticas.put("ataque", 0);
        this.estadisticas.put("velocidad", 0);
        this.estadisticas.put("magia", 0);
        this.estadisticas.put("fe", 0);
        this.estadisticas.put("armadura", 0);
        this.estadisticas.put("resistencia_magica", 0);
        this.rareza = "";
        this.valor_economico = 0;
    }

    public Equipamiento(String nombre, HashMap<String, Integer> estadisticas, String rareza, double valor_economico) {
        this.nombre = nombre;
        this.estadisticas = new HashMap<>(estadisticas);
        this.rareza = rareza;
        this.valor_economico = valor_economico;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getRareza() {
        return this.rareza;
    }

    public double getValorEconomico() {
        return this.valor_economico;
    }

    public void setNombre(String nombre) {
        if (nombre.length() > 20) {
            System.err.println("El nombre no puede tener mas de 20 digitos.");
        } else {
            this.nombre = nombre;
        }
    }

    public void setRareza(String rareza) {
        switch (rareza.toLowerCase().strip()) {
            case "comun":
                this.rareza = rareza;
                break;

            case "raro":
                this.rareza = rareza;
                break;

            case "epico":
                this.rareza = rareza;
                break;

            case "legendario":
                this.rareza = rareza;
                break;

            default:
                System.err.println("La rareza solo puede ser comun, raro, epico y legendario.");
                this.nombre = "comun";
                break;
        }
    }

    public void setValorEconomico(double valor_economico) {
        if (valor_economico < 1) {
            System.err.println("El valor economico de un equipamiento no puede ser menor que 1 moneda de oro.");
            this.valor_economico = 1;
        } else {
            this.valor_economico = valor_economico;
        }
    }

    public double recuperaEstadistica(String estadistica) {
        switch (estadistica.toLowerCase().strip()) {
            case "ataque":
                return this.estadisticas.get(estadistica);

            case "velocidad":
                return this.estadisticas.get(estadistica);

            case "magia":
                return this.estadisticas.get(estadistica);

            case "fe":
                return this.estadisticas.get(estadistica);

            case "armadura":
                return this.estadisticas.get(estadistica);

            case "resistencia_magica":
                return this.estadisticas.get(estadistica);

            default:
                System.err.println(
                        "Estadistica no valida. Las estadisticas validas son: ataque, velocidad, magia, fe, armadura y resistencia_magica.");
                break;
        }
        return -1;
    }

    public boolean equals(Equipamiento equipamiento) {
        if (this.nombre.equals(equipamiento.getNombre()) && this.rareza.equals(equipamiento.getRareza())
                && this.valor_economico == equipamiento.getValorEconomico())
            return true;

        if (this.estadisticas.size() == equipamiento.estadisticas.size()) {
            for (String llave : equipamiento.estadisticas.keySet()) {
                if (this.estadisticas.get(llave) == equipamiento.estadisticas.get(llave))
                    return true;
            }
        }
        return false;
    }

    public String toString() {
        return "Nombre: " + this.nombre +
                "\nRareza: " + this.rareza +
                "\nValor economico: " + this.valor_economico +
                "\nEstadisticas: " + this.estadisticas.toString();

    }
}
