import java.util.Random;

/**
 * Representa una subclase de {@link Personaje} especializada en el combate fisico.
 * El Guerrero tiene la capacidad de entrar en un estado de furia lo que duplica
 * temporalmente su ataque, pero tambien incrementa el daño recibido al defenderse.
 *
 * @author Joaquin Puchuri Tunjar
 * @version 1.1.1
 */
public class Guerrero extends Personaje{
    private boolean furia;

    /**
     * Constructor por defecto que inicializa un Guerrero con los valores predeterminados
     * de la superclase {@link Personaje} y con el estado de furia desactivado.
     */
    public Guerrero(){
        super();
        this.furia = false;
    }

    /**
     * Constructor por parametros que permite inicializar el Guerrero con un nombre y raza
     * especificos, heredando el resto de estadisticas de la superclase {@link Personaje}.
     *
     * @param nombre de tipo String que define el nombre del guerrero.
     * @param raza de tipo String que define la raza del guerrero.
     */
    public Guerrero(String nombre, String raza) {
        super(nombre, raza);
        this.furia = false;
    }

    /**
     * Constructor de copia que permite inicializar un objeto a partir de otro ya existente.
     *
     * @param copia objeto de tipo Guerrero.
     */
    public Guerrero(Guerrero copia){
        super();
        this.furia = copia.furia;
    }

    /**
     * Devuelve el estado de furia del Guerrero.
     *
     * @return furia de tipo boolean, true si la furia esta activada, false en caso contrario.
     */
    public boolean getFuria() {
        return furia;
    }

    /**
     * Establece el estado de furia del Guerrero.
     *
     * @param furia de tipo boolean, true para activar la furia, false para desactivarla.
     */
    public void setFuria(boolean furia) {
        this.furia = furia;
    }

    /**
     * Incrementa el nivel del Guerrero y mejora sus estadisticas segun sus ventajas
     * y penalizaciones especificas. La probabilidad de mejorar cada estadistica
     * varia segun lo siguiente:
     *
     * <ul>
     *   <li>Ataque: 80% de probabilidad de mejora, incrementando el doble del nivel.</li>
     *   <li>Armadura: 75% de probabilidad de mejora, incrementando segun el nivel.</li>
     *   <li>Velocidad: 50% de probabilidad de mejora, incrementando segun el nivel.</li>
     *   <li>Vida: 75% de probabilidad de mejora, incrementando en un 10%.</li>
     *   <li>Resistencia Magica: 50% de probabilidad de mejora, incrementando la mitad del nivel.</li>
     * </ul>
     */
    public void subirNivel(){
        this.setNivel(getNivel() +1);
        Random random = new Random();

        if(random.nextDouble() < 0.8){
            this.setPuntos_ataque(getPuntos_ataque() + (getNivel()*2));
        }
        if(random.nextDouble() < 0.75){
            this.setPuntos_armadura(getPuntos_armadura() + getNivel());
        }
        if(random.nextDouble() < 0.5){
            this.setPuntos_velocidad(getPuntos_velocidad() + getNivel());
        }
        if(random.nextDouble() < 0.75){
            this.setPuntos_vida((int) (getPuntos_vida() + (getPuntos_vida() * 1.1)));
        }
        if(random.nextDouble() < 0.5){
            this.setResistencia_magica(getResistencia_magica() + getNivel());
        }
    }

    /**
     * Realiza un ataque y devuelve los puntos de ataque del Guerrero.
     * Si el Guerrero no esta en estado de furia, su ataque es normal.
     * Si esta en estado de furia, su ataque se duplica.
     *
     * @return puntos de ataque del Guerrero en base a su estado de furia.
     */
    public int Luchar(){
        if(!this.furia){
            return getPuntos_ataque() *2;
        }
        return getPuntos_ataque();
    }

    /**
     * Permite al Guerrero defenderse de un ataque, reduciendo su vida o resistencia
     * segun el tipo de ataque recibido. Si la furia esta activa, el Guerrero recibe
     * el doble de daño.
     *
     * @param tipoAtaque de tipo int, 1 para ataque fisico, 2 para ataque magico.
     * @param objetivo de tipo String, el nombre del personaje que se defiende.
     */
    public void defender(int tipoAtaque, String objetivo){
        switch (tipoAtaque){
            case 1:
                if(furia == true){
                    setPuntos_vida((int) (getPuntos_vida() - (getPuntos_armadura() - luchar())));
                } else{
                    setPuntos_vida((int) (getPuntos_vida() - (getPuntos_armadura() - luchar())));
                }
                break;
            case 2:
                if(furia == true){
                    setResistencia_magica((int) (getPuntos_vida() - (getResistencia_magica() - luchar())));
                } else{
                    setResistencia_magica((int) (getPuntos_vida() - (getResistencia_magica() - luchar())));
                }
                break;
            default:
                System.out.println("Asegure de elegir entre los siguientes tipos de ataque: \n- 1 para el daño fisico. \n- 2 para el dano magino.");
                break;
        }
    }

    /**
     * Devuelve una representacion en cadena del Guerrero, incluyendo sus estadisticas
     * y el estado de furia.
     *
     * @return cadena de texto con la informacion del Guerrero.
     */
    public String toString() {
        return super.toString() + "\nEstado de la furia: " + getFuria();
    }
}
