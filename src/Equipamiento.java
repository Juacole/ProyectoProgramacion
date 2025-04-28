import java.util.HashMap;

public abstract class Equipamiento {
    private String nombre;
    private HashMap<String, Integer> estadisticas;
    private String rareza;
    private double valor_economico;

    public Equipamiento() {
        this.nombre = "";
        this.estadisticas = new HashMap<>();
        this.estadisticas.put("Ataque", 0);
        this.estadisticas.put("Velocidad", 0);
        this.estadisticas.put("Magia", 0);
        this.estadisticas.put("Fe", 0);
        this.estadisticas.put("Armadura", 0);
        this.estadisticas.put("ResistenciaMagica", 0);
        this.rareza = "";
        this.valor_economico = 0;
    }

    public Equipamiento(HashMap<String, Integer> estadisticas, String rareza, double valor_economico) {
        this.nombre = "Equipamiento";
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

}
