import java.util.HashMap;

public abstract class Equipamiento {
    private String nombre;
    private HashMap<String, Integer> estadisticas;
    private String rareza;
    private double valor_economico;

    public Equipamiento() {
        this.nombre = "";
        this.estadisticas = new HashMap<>();
        this.rareza = "";
        this.valor_economico = -1;
    }

    public Equipamiento(HashMap<String, Integer> estadisticas, String rareza, double valor_economico) {
        this.nombre = "Equipamiento";
        this.estadisticas = new HashMap<>(estadisticas);
        this.rareza = rareza;
        this.valor_economico = valor_economico;
    }
}
