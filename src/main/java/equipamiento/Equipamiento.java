package main.java.equipamiento;

import java.util.HashMap;
import java.util.Set;

public abstract class Equipamiento {
    private String nombre;
    private HashMap<String, Integer> estadisticas;
    private String rareza;
    private int valor_economico;
    private static final Set<String> rarezas_validos = Set.of(
            "comun", "raro", "epico", "legendario"
    );

    public Equipamiento() {
        this.nombre = "";
        this.estadisticas = new HashMap<>();
        this.estadisticas.put("ataque", 0);
        this.estadisticas.put("velocidad", 0);
        this.estadisticas.put("magia", 0);
        this.estadisticas.put("fe", 0);
        this.estadisticas.put("armadura", 0);
        this.estadisticas.put("resistencia_magica", 0);
        this.estadisticas.put("vida", 0);
        this.rareza = "";
        this.valor_economico = 0;
    }

    public Equipamiento(String nombre, HashMap<String, Integer> estadisticas, String rareza, int valor_economico) {
        setNombre(nombre);
        this.estadisticas = new HashMap<>(estadisticas);
        setRareza(rareza);
        setValorEconomico(valor_economico);
    }

    public Equipamiento(Equipamiento equipamiento) {
        setNombre(equipamiento.getNombre());
        this.estadisticas = new HashMap<>(); // Inicializar siempre el hashmap
        setEstadisticas(equipamiento.getEstadistica());
        setRareza(equipamiento.getRareza());
        setValorEconomico(equipamiento.getValorEconomico());
    }

    public String getNombre() {
        return this.nombre;
    }

    public HashMap<String, Integer> getEstadistica() {
        return this.estadisticas;
    }

    public String getRareza() {
        return this.rareza;
    }

    public int getValorEconomico() {
        return this.valor_economico;
    }

    public void setNombre(String nombre) {
        if (nombre.length() > 20) {
            System.err.println("El nombre no puede tener mas de 20 digitos.");
            this.nombre = nombre.substring(0,19);
        } else {
            this.nombre = nombre;
        }
    }

    public void setEstadisticas(HashMap<String, Integer> estadisticas) {
        this.estadisticas.putAll(estadisticas);
    }

    public void setRareza(String rareza) {
        if(rarezas_validos.contains(rareza.toLowerCase().trim())){
                this.rareza = rareza;
        }else {
                System.err.println("La rareza solo puede ser comun, raro, epico y legendario.");
                this.rareza = "";
        }
    }

    public void setValorEconomico(int valor_economico) {
        if (valor_economico < 1) {
            System.err.println("El valor economico de un equipamiento no puede ser menor que 1 moneda de oro.");
            this.valor_economico = 1;
        } else {
            this.valor_economico = valor_economico;
        }
    }

    public double recuperaEstadistica(String estadistica) {
        double valor_estadistica = 0;
        switch (estadistica.toLowerCase().strip()) {
            case "ataque":
                valor_estadistica = this.estadisticas.get(estadistica);
                break;

            case "velocidad":
                valor_estadistica = this.estadisticas.get(estadistica);
                break;

            case "magia":
                valor_estadistica = this.estadisticas.get(estadistica);
                break;

            case "fe":
                valor_estadistica = this.estadisticas.get(estadistica);
                break;

            case "armadura":
                valor_estadistica = this.estadisticas.get(estadistica);
                break;

            case "resistencia_magica":
                valor_estadistica = this.estadisticas.get(estadistica);
                break;

            case "vida":
                valor_estadistica = this.estadisticas.get(estadistica);
                break;

            default:
                System.err.println(
                        "Estadistica no valida. Las estadisticas validas son: ataque, velocidad, magia, fe, armadura, resistencia_magica y vida.");
                break;
        }
        return valor_estadistica;
    }

    public boolean equals(Equipamiento equipamiento) {
        if (!this.nombre.equals(equipamiento.getNombre())) {
            return false;
        }

        if (this.valor_economico != equipamiento.getValorEconomico()) {
            return false;
        }

        if (!this.rareza.equals(equipamiento.getRareza())) {
            return false;
        }

        if (this.estadisticas.size() == equipamiento.estadisticas.size()) {
            for (String llave : equipamiento.estadisticas.keySet()) {
                if (this.estadisticas.get(llave) != equipamiento.estadisticas.get(llave))
                    return false;
            }
        }
        return true;
    }

    public String toString() {
        return "Nombre: " + this.nombre +
                "\nRareza: " + this.rareza +
                "\nValor economico: " + this.valor_economico +
                "\nEstadisticas: " + this.estadisticas.toString();

    }
}
