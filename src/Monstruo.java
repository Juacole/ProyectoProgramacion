public class Monstruo extends Personaje{

    public Monstruo(){
        super();
        setRaza("bestia");
    }

    public Monstruo(String nombre, String raza){
        super(nombre,raza);
        setRaza();
    }

    public String getNombre(){
        return super.getNombre();
    }

    public void setRaza(){
        switch (getRaza().toLowerCase().replace(" ","")){
            case "bestia":
                setPuntos_ataque(getPuntos_vida()*2);
                setPuntos_velocidad(getNivel()*2);
                setPuntos_vida(getNivel());
                setPuntos_armadura(getNivel()/2);
                setResistencia_magica(getNivel()/2);
                break;

            case "nomuerto":
                setResistencia_magica(getNivel()*4);
                setPuntos_ataque(getNivel());
                setPuntos_vida(getNivel()/2);
                setPuntos_armadura(getNivel()/2);
                setPuntos_velocidad(getNivel()/4);
                break;

            case "gigante":
                setPuntos_vida(getNivel()*4);
                setPuntos_ataque(getNivel()*4);
                setPuntos_armadura(getNivel());
                setResistencia_magica(getNivel()/4);
                setPuntos_velocidad(getNivel()/4);
                break;

            default:
                System.out.println("Asegurese de eleiger una de las siguientes opciones: " +
                        "\n-Bestia" +
                        "\n-No muerto" +
                        "\n-Gigante");
        }
    }

    public String toString(){
        return super.toString();
    }
}
