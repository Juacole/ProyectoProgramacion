package main.java.equipamiento;

public class Arma extends Equipamiento {
    private boolean empuñadura;
    private String tipo;

    public Arma() {
        this.empuñadura = false;
        this.tipo = "";
    }

    public Arma(boolean empuñadura, String tipo) {
        this.empuñadura = empuñadura;
        this.tipo = tipo;
    }
}
