import java.util.Random;

public class Ladron extends Personaje{

    public Ladron() {
        super();
    }

    public Ladron(String nombre, String raza) {
        super(nombre, raza);
    }

    public double Robar(){
        return getPuntos_velocidad();
    }

    public void subirNivel(){
        setNivel(getNivel() +1);

        Random random = new Random();
        if(random.nextDouble() < 0.60){
            setPuntos_ataque(getPuntos_ataque() + getNivel());
        }
        if(random.nextDouble() < 0.40){
            setPuntos_armadura(getPuntos_armadura() + getNivel());
        }
        if(random.nextDouble() < 0.85){
            setPuntos_velocidad(getPuntos_velocidad() *2);
        }
        if(random.nextDouble() < 0.40){
            int aux = (int) (getPuntos_vida() + (getPuntos_vida() * 1.1));
            setPuntos_vida(aux);
        }
        if(random.nextDouble() < 0.40){
            setResistencia_magica(getResistencia_magica() + getNivel());
        }
    }

    public String toString() {
        return super.toString();
    }
}
