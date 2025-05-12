package main.java.equipamiento;

import java.util.HashMap;
import java.util.Set;

public class Armadura extends Equipamiento {
    private String tipo;
    private String material;

    public Armadura() {
        super();
        this.tipo = "";
        this.material = "";
    }

    public Armadura(String nombre, HashMap<String, Integer> estadisticas, String rareza, double valor_economico, String tipo, String material) {
        super(nombre,estadisticas,rareza,valor_economico);
        setTipo(tipo);
        setMaterial(material);
    }

    public Armadura(Armadura armadura) {
        super(armadura);
        setTipo(armadura.getTipo());
        setMaterial(armadura.getMaterial());
    }

    public String getTipo() {
        return this.tipo;
    }

    public String getMaterial() {
        return this.material;
    }

    public void setTipo(String tipo) {
        Set<String> tiposValidos = Set.of("yelmo", "pechera", "hombreras", "guanteletes", "grebas", "botas");

        if(tiposValidos.contains(tipo.toLowerCase())){
            this.tipo = tipo.toLowerCase();
        }else {
            System.err.println("El tipo de armadura solo puede ser: \n-" + String.join("\n-", tiposValidos));
            this.tipo = "";
        }
    }

    public void setMaterial(String material) {
        Set<String> materialesValidos = Set.of("tela","cuero","metal");

        if(materialesValidos.contains(material.toLowerCase())){
            this.material = material.toLowerCase();
        }else {
            System.err.println("Los materiales de la armadura solo puedes ser: \n-" + String.join("\n-", materialesValidos));
        }
    }

    public boolean equals(Armadura armadura) {
        super.equals(armadura);
        if (!this.tipo.equals(armadura.getTipo())) {
            return false;
        }
        if (!this.material.equals(armadura.getMaterial())) {
            return false;
        }

        return true;
    }

    public String toString() {
        return super.toString() +
                "\nTipo de armadura: " + this.tipo +
                "\nEl material es de: " + this.material;
    }

}
