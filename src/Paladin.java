import java.util.Random;

public class Paladin extends Creyente{

    public Paladin(){
        super();
    }

    public Paladin(String nombre, String raza, int fe) {
        super(nombre, raza, fe);
    }

    public void subirNivel(){
        setNivel(getNivel()+1);
        Random random = new Random();

        if(random.nextDouble() < 0.7){
            setPuntos_armadura(getPuntos_armadura() + (getNivel()*2));
        }
        if(random.nextDouble() < 0.5){
            setPuntos_vida(getPuntos_vida() + (1.1 + (1.1*0.05)));
        }
        if(random.nextDouble() < 0.6){
            setPuntos_ataque(getPuntos_ataque() + getNivel());
        }
        if(random.nextDouble() < 0.15){
            setPuntos_velocidad(getPuntos_velocidad() + (getNivel()/4));
        }
        if(random.nextDouble() < 0.30){
            setFe(getFe() + (int) getNivel());
        }
    }

    @Override
    public void plegaria(int tipoMilagro, String objetivo) {
        switch (tipoMilagro){
            case 1:
                System.out.println("¡IMBUIR ARMA!");
                break;

            case 2:
                System.out.println("¡BALUARTE DE FE!");
                setPuntos_armadura(getPuntos_armadura() + (getFe()*0.3));
                break;

            default:
                System.out.println("Sin uso.");
        }
    }

    public String toString(){
        return super.toString() + "El Paladin tiene una fe de: " + getFe();
    }
}
