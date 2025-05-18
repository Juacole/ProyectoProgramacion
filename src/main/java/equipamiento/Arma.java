package main.java.equipamiento;

import java.util.HashMap;
import java.util.Set;

public class Arma extends Equipamiento {
    private boolean empuniadura;
    private String tipo;
    private static final Set<String> armas_una_mano = Set.of(
            "espada", "maza", "hacha", "cetro", "daga"
    );
    private static final Set<String> armas_dos_manos = Set.of(
            "espadon", "martillo", "arco", "baston", "pica"
    );

    public Arma() {
        super();
        this.empuniadura = false;
        this.tipo = "";
    }

    public Arma(String nombre, HashMap<String, Integer> estadisticas, String rareza, int valor_economico, String tipo) {
        super(nombre, estadisticas, rareza, valor_economico);
        setTipo(tipo);
    }

    public Arma(Arma arma) {
        super(arma);
        setTipo(arma.getTipo());
        setEmpuniadura(arma.getEmpuniadura());
    }

    public boolean getEmpuniadura() {
        return this.empuniadura;
    }

    public String getTipo() {
        return this.tipo;
    }

    protected void setEmpuniadura(boolean empuniadura) {
        this.empuniadura = empuniadura;
    }

    public void setTipo(String tipo) {
        if (armas_una_mano.contains(tipo.toLowerCase().trim())) {
            this.tipo = tipo;
            this.empuniadura = false;
        }
        else if (armas_dos_manos.contains(tipo.toLowerCase().trim())) {
            this.tipo = tipo;
            this.empuniadura = true;
        }
        else {
            System.err.println("Tipo de arma no valido: " + tipo);
        }
    }

    public boolean equals(Arma arma) {
        super.equals(arma);
        if (this.empuniadura != arma.getEmpuniadura()) {
            return false;
        }
        if (!this.tipo.equals(arma.getTipo())) {
            return false;
        }

        return true;
    }

    public String toString() {
        return super.toString() + "\nLa empuñadura es de: " + this.empuniadura + "\nEl tipo es: " + this.tipo;
    }

}
