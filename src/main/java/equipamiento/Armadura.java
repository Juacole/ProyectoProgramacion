package main.java.equipamiento;

import java.util.HashMap;
import java.util.Set;

public class Armadura extends Equipamiento {
    private String tipo;
    private String material;
    private static final Set<String> tipos_validos = Set.of(
            "yelmo", "pechera", "hombreras", "guanteletes", "grebas", "botas"
    );
    private static final Set<String> materiales_validos = Set.of(
            "tela", "cuero", "metal"
    );

    public Armadura() {
        super();
        this.tipo = "";
        this.material = "";
    }

    public Armadura(String nombre, HashMap<String, Integer> estadisticas, String rareza, int valor_economico, String tipo, String material) {
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
        if (tipos_validos.contains(tipo.toLowerCase().trim())) {
            this.tipo = tipo;
        } else {
            System.err.println("Tipo no válido. Valores permitidos: \n-" +
                    String.join("\n-", tipos_validos));
            this.tipo = "";
        }
    }

    public void setMaterial(String material) {
        if (materiales_validos.contains(material.toLowerCase().trim())) {
            this.material = material;
        } else {
            System.err.println("Material no válido. Valores permitidos: \n-" +
                    String.join("\n-", materiales_validos));
            this.material = "";
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
