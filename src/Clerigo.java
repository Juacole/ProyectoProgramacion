import java.util.Random;

public class Clerigo extends Creyente{

    public Clerigo(){
        super();
    }

    public Clerigo(String nombre, String raza, int fe){
        super(nombre,raza,fe);
    }
    
    public void subirNivel(){
        setNivel(getNivel()+1);
        Random random = new Random();

        if(random.nextDouble() < 0.8){
            setFe(getFe() + ((int) getNivel()*2));
        }
        if(random.nextDouble() < 0.8){
            setResistencia_magica(getResistencia_magica() + ((int) getNivel()*2));
        }
        if(random.nextDouble() < 0.2){
            setPuntos_vida(getPuntos_vida() + (getNivel()/2));
        }
        if(random.nextDouble() < 0.2){
            setPuntos_armadura(getPuntos_armadura() + (getNivel()/2));
        }
        if(random.nextDouble() < 0.1){
            setPuntos_ataque(getPuntos_ataque() + (getNivel()/4));
        }
    }

    public void plegaria(int tipoMilagro, String objetivo){
        switch (tipoMilagro){
            case 1:
                System.out.println("¡Sanación!");
                break;

            case 2:
                System.out.println("¡Rezo sagrado!");
                break;

            case 3:
                System.out.println("¡Cólera divina!");
                luchar(3);
                break;

            default:
                System.out.println("Sin uso.");
        }
    }

    public double luchar(int tipoMilagro){
        if(tipoMilagro == 3)
            return getFe() * 0.55;
        return -1;
    }

    public void apoyar(int hechizo, String b){
        if(hechizo == 1){
            setPuntos_vida(getFe() * 0.7);
        }
        if(hechizo == 2){
            setPuntos_vida(getFe() * 0.7);
        }
    }

    public String toString(){
        return super.toString() + "\nLos puntos de fe son: " + this.fe;
    }
}
