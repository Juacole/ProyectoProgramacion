package main.java.equipamiento;

import java.util.HashMap;

public class Artefacto extends Equipamiento {
    private String tipo;

    public Artefacto() {
        super();
        this.tipo = "";
    }

    public Artefacto(String nombre, HashMap<String, Integer> estadisticas, String rareza, int valor_economico, String tipo) {
        super(nombre, estadisticas, rareza, valor_economico);
        setTipo(tipo);
    }

    public Artefacto(Artefacto artefacto) {
        super(artefacto);
        setTipo(artefacto.getTipo());
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        if (tipo.toLowerCase().trim().equals("anillo")) {
            this.tipo = tipo;
        } else if (tipo.toLowerCase().trim().equals("amuleto")) {
            this.tipo = tipo;
        }  else {
            System.err.println("El artefacto solo puede ser un anillo o un amuleto.");
            this.tipo = "";
        }
    }

    public boolean equals(Artefacto artefacto) {
        super.equals(artefacto);
        if (!this.tipo.equals(artefacto.getTipo())) {
            return false;
        }
        return true;
    }

    public String toString() {
        return super.toString() +
                "\nTipo de artefacto: " + this.tipo;
    }
}
