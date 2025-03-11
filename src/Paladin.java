import java.util.Random;

/**
 * Representa a un Paladin, una subclase de {@link Creyente}. Un Paladin es un tipo
 * de creyente que se especializa en el combate cuerpo a cuerpo. Además de usar su fe
 * para realizar milagros, tiene ventajas en su armadura, vida, y ataque.
 *
 * @author Joaquin Puchuri Tunjar
 * @version 1.0.1
 */
public class Paladin extends Creyente{

    /**
     * Constructor por defecto que crea un Paladin con valores predeterminados.
     */
    public Paladin(){
        super();
    }


    /**
     * Constructor que permite crear un Paladín con un nombre, raza y cantidad de fe específicos.
     *
     * @param nombre de tipo String que define el nombre del Paladin.
     * @param raza de tipo String que define la raza del Paladin.
     * @param fe de tipo int que define la cantidad de fe del Paladin.
     */
    public Paladin(String nombre, String raza, int fe) {
        super(nombre, raza, fe);
    }

    /**
     * Aumenta el nivel del Mago y mejora sus estadisticas segun las probabilidades especificadas:
     *
     * <ul>
     *   <li>Armadura: Probabilidad del 70% de incrementar el doble de lo habitual.</li>
     *   <li>Vida: Probabilidad del 50% de incrementar la vida en un 5% adicional.</li>
     *   <li>Ataque: Probabilidad del 60% de incrementar el ataque.</li>
     *   <li>Velocidad: Probabilidad del 15% de incrementar la velocidad un cuarto de lo habitual.</li>
     *   <li>Fe: Probabilidad del 30% de incrementar los puntos de fe.</li>
     * </ul>
     */
    public void subirNivel(){
        setNivel(getNivel()+1);
        Random random = new Random();

        if(random.nextDouble() < 0.7){
            setPuntos_armadura(getPuntos_armadura() + (getNivel()*2));
        }
        if(random.nextDouble() < 0.5){
            setPuntos_vida((int) (getPuntos_vida() + (1.1 + (1.1*0.05))));
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

    /**
     * Sobrescribe el método {@link Creyente#plegaria(int, String)} para definir los milagros
     * que un Paladín puede realizar. Los milagros disponibles son:
     *
     * @param tipoMilagro de tipo int que indica el tipo de milagro a realizar.
     * @param objetivo de tipo String que define el objetivo del milagro.
     */
    @Override
    public void plegaria(int tipoMilagro, String objetivo) {
        switch (tipoMilagro){
            case 1:
                System.out.println("¡IMBUIR ARMA!");
                break;

            case 2:
                System.out.println("¡BALUARTE DE FE!");
                setPuntos_armadura((int) (getPuntos_armadura() + (getFe()*0.3)));
                break;

            default:
                System.out.println("Sin uso.");
        }
    }

    /**
     * Devuelve una representacion en cadena del estado actual del Paladin.
     *
     * @return una cadena que describe el estado del Paladín y sus puntos de fe.
     */
    public String toString(){
        return super.toString() + "El Paladin tiene una fe de: " + getFe();
    }
}
