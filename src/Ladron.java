import java.util.Random;

/**
 * Representa una subclase de {@link Personaje} especializada en el robo y el uso de la velocidad
 * en combate. El Ladron tiene la capacidad de robar, utilizando su velocidad en lugar de su ataque
 * en combate.
 *
 * @author Joaquin Puchuri Tunjar
 * @version 1.0
 */
public class Ladron extends Personaje{

    /**
     * Constructor por defecto que inicializa un Ladron con los valores predeterminados
     * de la superclase {@link Personaje}.
     */
    public Ladron() {
        super();
    }

    /**
     * Constructor por parametros que permite inicializar el Ladron con un nombre y raza
     * especificos, heredando el resto de estadisticas de la superclase {@link Personaje}.
     *
     * @param nombre de tipo String que define el nombre del Ladron.
     * @param raza de tipo String que define la raza del Ladron.
     */
    public Ladron(String nombre, String raza) {
        super(nombre, raza);
    }

    /**
     * Realiza una accion especial de robo, devolviendo la velocidad del Ladron.
     *
     * @return la velocidad del Ladron.
     */
    public double Robar(){
        return getPuntos_velocidad();
    }

    /**
     * Incrementa el nivel del Ladron y mejora sus estadisticas segun sus ventajas
     * y penalizaciones especificas. La probabilidad de mejorar cada estadistica
     * varia segun lo siguiente:
     *
     * <ul>
     *   <li>Velocidad: 85% de probabilidad de mejora, duplicando la velocidad.</li>
     *   <li>Ataque: 60% de probabilidad de mejora, incrementando segun el nivel.</li>
     *   <li>Armadura: 40% de probabilidad de mejora, incrementando segun el nivel.</li>
     *   <li>Vida: 40% de probabilidad de mejora, incrementando en un 10%.</li>
     *   <li>Resistencia Magica: 40% de probabilidad de mejora, incrementando segun el nivel.</li>
     * </ul>
     */
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
            setPuntos_vida((getPuntos_vida() + (getPuntos_vida() * 1.1)));
        }
        if(random.nextDouble() < 0.40){
            setResistencia_magica(getResistencia_magica() + getNivel());
        }
    }

    /**
     * Devuelve una representacion en cadena del Ladron, incluyendo sus estadisticas
     * heredadas de {@link Personaje}.
     *
     * @return cadena de texto con la informacion del Ladron.
     */
    public String toString() {
        return super.toString();
    }
}
