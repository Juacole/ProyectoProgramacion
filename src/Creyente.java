
/**
 * Representa a un Creyente, una subclase abstracta de {@link Personaje} que tiene un
 * atributo nuevo fe. Los Creyentes son personajes que pueden realizar milagros basados
 * en su cantidad de fe, lo que afecta a su destreza y habilidades en combate.
 *
 * @author Joaquin Puchuri Tunjar
 * @version 1.0
 */
public abstract class Creyente extends Personaje {
    public int fe;

    /**
     * Constructor por defecto que crea un Creyente con valores predeterminados y
     * asigna un nivel de fe de 10.
     */
    public Creyente(){
        super();
        this.fe = 10;
    }

    /**
     * Constructor que permite crear un Creyente con un nombre, raza y nivel de fe específicos.
     *
     * @param nombre de tipo String que define el nombre del Creyente.
     * @param raza de tipo String que define la raza del Creyente.
     * @param fe de tipo int que define la cantidad de fe del Creyente.
     */
    public Creyente(String nombre, String raza, int fe){
        super(nombre, raza);
        this.fe = fe;
    }

    /**
     * Devuelve el nivel de fe del Creyente, que determina su capacidad para realizar milagros.
     *
     * @return el valor actual de los puntos de fe del Creyente.
     */
    public int getFe() {
        return fe;
    }

    /**
     * Establece el nivel de fe del Creyente.
     *
     * @param fe de tipo int que representa el nuevo nivel de fe del Creyente.
     */
    public void setFe(int fe){
        this.fe = fe;
    }

    /**
     * Método abstracto que representa la plegaria del Creyente. Este método se implementa
     * en las subclases de Creyente y permite al Creyente realizar milagros, afectando a
     * un objetivo específico dependiendo del tipo de milagro indicado.
     *
     * @param tipoMilagro de tipo int que indica el tipo de milagro a realizar.
     * @param objetivo de tipo String que especifica el objetivo del milagro.
     */
    public abstract void plegaria(int tipoMilagro, String objetivo);


    /**
     * Sobrescribe el método toString para proporcionar una representación
     * completa del estado del Creyente, incluyendo su cantidad de fe.
     *
     * @return una cadena de texto que describe el estado del Creyente y sus puntos de fe.
     */
    public String toString(){
        return super.toString() + "\nEl creyente tiene unos puntos de fe de: " + getFe();
    }
}
