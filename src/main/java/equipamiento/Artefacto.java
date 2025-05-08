package main.java.equipamiento;

public class Artefacto extends Equipamiento {
    private String tipo;

    public Artefacto() {
        this.tipo = "";
    }

    public Artefacto(String tipo) {
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
        if (tipo.toLowerCase().equals("anillo")) {
            this.tipo = tipo;
        } else if (tipo.toLowerCase().equals("amuleto")) {
            this.tipo = tipo;
        }  else {
            System.err.println("El artefacto solo puede ser un anillo o amuleto.");
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
