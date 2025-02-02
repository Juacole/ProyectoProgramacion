import java.util.Random;

/**
 * La clase {@code Clerigo} es una subclase de {@link Creyente} que representa a un Clérigo,
 * un tipo de Creyente que combate a distancia y sana a sus aliados. Los Clérigos tienen
 * una gran capacidad de curación y resistencia mágica, pero sus habilidades de ataque y
 * defensa son limitadas.
 *
 * @author Joaquin Puchuri Tunjar
 * @version 1.0
 */
public class Clerigo extends Creyente{

    /**
     * Constructor por defecto, que inicializa los atributos del Clerigo
     * utilizando el constructor de la superclase {@link Creyente}.
     */
    public Clerigo(){
        super();
    }

    /**
     * Constructor que inicializa los atributos del Clerigo utilizando el
     * constructor de la superclase {@link Creyente} y configurando los puntos de fe.
     *
     * @param nombre el nombre del Clerigo.
     * @param raza la raza del Clerigo.
     * @param fe los puntos de fe del Clerigo.
     */
    public Clerigo(String nombre, String raza, int fe){
        super(nombre,raza,fe);
    }

    /**
     * Aumenta el nivel del Clerigo y mejora sus estadisticas segun las probabilidades especificadas:
     *
     * <ul>
     *   <li>Fe y Resistencia magica: Probabilidad del 80% de incrementar los puntos de fe y resistencia mágica el doble de lo habitual.</li>
     *   <li>Vida y Armadura: Probabilidad del 20% de incrementar la vida y la armadura la mitad de lo habitual.</li>
     *   <li>Ataque: Probabilidad del 10% de incrementar el ataque un cuarto de lo habitual.</li>
     * </ul>
     */
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

    /**
     * Sobrescribe el método plegaria para implementar los milagros
     * disponibles para un Clerigo.
     *
     * @param tipoMilagro el tipo de milagro que se va a realizar.
     * @param objetivo el objetivo al que se dirige el milagro.
     */
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

    /**
     * Sobrecarga el método luchar para que el Clérigo pueda realizar un
     * ataque utilizando sus puntos de fe dependiendo del tipo de milagro.
     *
     * @param tipoMilagro el tipo de milagro que se va a realizar.
     * @return el valor del daño causado por el milagro, o los puntos de ataque.
     */
    public double luchar(int tipoMilagro){
        if(tipoMilagro == 3)
            return getFe() * 0.55;
        return getPuntos_ataque();
    }

    /**
     * Permite que el Clerigo apoye a un aliado objetivo con un hechizo.
     * El Clerigo solo puede usar conjuros no ofensivos para apoyar.
     *
     * @param hechizo el tipo de hechizo que el Clerigo usa para apoyar.
     * @param objetivo un parámetro adicional, que no es utilizado en esta implementación.
     */
    public void apoyar(int hechizo, String objetivo){
        if(hechizo == 1){
            setPuntos_vida(getFe() * 0.7);
        }
        if(hechizo == 2){
            setPuntos_vida(getFe() * 0.7);
        }
    }


    /**
     * Devuelve una representacion en cadena del estado actual del Clerigo.
     *
     * @return una representación en formato de texto del estado del Clérigo.
     */
    public String toString(){
        return super.toString() + "\nLos puntos de fe son: " + this.fe;
    }
}
