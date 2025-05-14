package main.java.equipamiento;

import java.util.HashMap;

public class Arma extends Equipamiento {
    private boolean empuñadura;
    private String tipo;

    public Arma() {
        super();
        this.empuñadura = false;
        this.tipo = "";
    }

    public Arma(String nombre, HashMap<String, Integer> estadisticas, String rareza, int valor_economico, boolean empuñadura, String tipo) {
        super(nombre, estadisticas, rareza, valor_economico);
        setEmpuñadura(empuñadura);
        setTipo(tipo);
    }

    public Arma(Arma arma) {
        super(arma);
        setEmpuñadura(arma.getEmpuñadura());
        setTipo(arma.getTipo());
    }

    public boolean getEmpuñadura() {
        return this.empuñadura;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setEmpuñadura(boolean empuñadura) {
        this.empuñadura = empuñadura;
    }

    public void setTipo(String tipo) {
        if (this.empuñadura) {
            armaDeUnaMano(tipo);
        } else if (!this.empuñadura) {
            armaDeDosMano(tipo);
        }
    }

    private void armaDeUnaMano(String tipo) {
        if (tipo.equals("espada")) {
            this.tipo = tipo;
        } else if (tipo.equals("maza")) {
            this.tipo = tipo;
        } else if (tipo.equals("hacha")) {
            this.tipo = tipo;
        } else if (tipo.equals("cetro")) {
            this.tipo = tipo;
        } else if (tipo.equals("daga")) {
            this.tipo = tipo;
        } else {
            System.err.println(

                    "Si la empuñadura es false solo son validas las armas: \n-espadas \n-mazas \n-hachas \n-cetros \n-dagas");
        }

    }

    private void armaDeDosMano(String tipo) {
        if (tipo.equals("espadones")) {
            this.tipo = tipo;
        } else if (tipo.equals("martillos")) {
            this.tipo = tipo;
        } else if (tipo.equals("arco")) {
            this.tipo = tipo;
        } else if (tipo.equals("baston")) {
            this.tipo = tipo;
        } else {

            System.err.println("Si la empuñadura es true solo son validas las armas: \n-espadones \n-martillos \n-arco \n-baston");
        }

    }

    public boolean equals(Arma arma) {
        super.equals(arma);
        if (this.empuñadura != arma.getEmpuñadura()) {
            return false;
        }
        if (!this.tipo.equals(arma.getTipo())) {
            return false;
        }

        return true;
    }

    public String toString() {
        return super.toString() + "\nLa empuñadura es de: " + this.empuñadura + "\nEl tipo es: " + this.tipo;
    }

}
