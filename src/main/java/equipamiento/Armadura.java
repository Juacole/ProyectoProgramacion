package main.java.equipamiento;

public class Armadura extends Equipamiento {
    private String tipo;
    private String material;

    public Armadura() {
        this.tipo = "";
        this.material = "";
    }

    public Armadura(String tipo, String material) {
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
        if (tipo.toLowerCase().equals("yelmo")) {
            this.tipo = tipo;
        } else if (tipo.toLowerCase().equals("pechera")) {
            this.tipo = tipo;
        } else if (tipo.toLowerCase().equals("hombreras")) {
            this.tipo = tipo;
        } else if (tipo.toLowerCase().equals("guanteletes")) {
            this.tipo = tipo;
        } else if (tipo.toLowerCase().equals("grebas")) {
            this.tipo = tipo;
        } else if (tipo.toLowerCase().equals("botas")) {
            this.tipo = tipo;
        } else {
            System.err.println("El tipo de armadura solo puede ser: \n-yelmo \n-pechera \n-hombreras \n-guanteletes \n-grebas \n-botas");
        }
    }

    public void setMaterial(String material) {
        if (material.toLowerCase().equals("tela")) {
            this.material = material;
        } else if (material.toLowerCase().equals("cuero")) {
            this.material = material;
        } else if (material.toLowerCase().equals("metal")) {
            this.material = material;
        } else {
            System.err.println("Los materiales de la armadura solo puedes ser: \n-tela \n-cuero \n-metal");
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
