import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 * Representa una subclase de {@link Personaje} especializada en el uso de la magia.
 * Un Mago posee puntos de magia que determinan su destreza en el uso de hechizos,
 * y tiene diferentes probabilidades de mejora en sus estadisticas al subir de nivel.
 *
 * @author Joaquin Puchuri Tunjar
 * @version 1.1.1
 */
public class Mago extends Personaje{
    private int puntos_magia;

    /**
     * Constructor por defecto que inicializa un Mago con los valores
     * predetermiandos de la superclase {@link Personaje} y con los
     * puntos en 10.
     */
    public Mago() {
        super();
        setPuntos_magia(10);
    }

    /**
     * Constructor por parametros que permite inicializar al Mago con un nombre y raza
     * especificos, heredando el resto de estadisticas de la superclase {@link Personaje}.
     *
     * @param nombre de tipo String, define el nombre del Mago.
     * @param raza de tipo String, define la raza del Mago.
     */
    public Mago(String nombre, String raza) {
        super(nombre, raza);
        setPuntos_magia(10);
    }

    /**
     * Constructor de copia que permite inicializar un objeto a partir de otro ya existente.
     *
     * @param copia objeto de tipo Mago.
     */
    public Mago(Mago copia){
        super();
        this.puntos_magia = copia.puntos_magia;
    }

    /**
     * Al inicilizarse un personaje este recibira un path donde estara la ruta hacia un
     * fichero donde estara la ficha del personaje y esta se imprimira por pantalla.
     *
     * @param path de tipo String que define la ruta del fichero del cual se inicializa
     * un objeto.
     */
    public Mago(String path) {
        try {
            File fichaLectura = new File(path);
            if (fichaLectura.canRead()) {
                FileReader fr = new FileReader(fichaLectura);
                BufferedReader br = new BufferedReader(fr);
                String linea;
                int indice = 0;
                String[] atributos = new String[1];
                while ((linea = br.readLine()) != null) {
                    String[] aux = linea.split(": ");
                    if (aux.length > 1 && linea.startsWith("Magia")) {
                        String valor_atributo = aux[1].replace(".", "");
                        atributos[indice] = valor_atributo;
                    }
                }
                this.puntos_magia = Integer.parseInt(atributos[0]);
                br.close();
                fr.close();
            }
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    /**
     * Devuelve los puntos de magia del Mago.
     *
     * @return puntos_magia de tipo double.
     */
    public int getPuntos_magia() {
        return this.puntos_magia;
    }

    /**
     * Establece los puntos de magia del Mago.
     *
     * @param puntos_magia de tipo double, nuevos puntos de magia del Mago.
     */
    public void setPuntos_magia(int puntos_magia) {
        this.puntos_magia = puntos_magia;
    }

    /**
     * Realiza un ataque y devuelve los puntos de ataque del personaje.
     *
     * @return puntos de ataque del personaje.
     */
    public int luchar(){
        return getPuntos_ataque();
    }

    /**
     * Realiza un ataque con un hechizo, causando un daño basado en los puntos de magia.
     *
     * @param hechizo de tipo int, determina el tipo de hechizo a utilizar.
     * @return cantidad de dano infligido de tipo double.
     */
    public int luchar(int hechizo){
        if(hechizo == 1)
            return (int) (this.puntos_magia * 0.7);
        else if(hechizo == 3)
            return (int) (this.puntos_magia * 0.3);
        else
            return this.puntos_magia;
    }

    /**
     * Aumenta el nivel del Mago y mejora sus estadisticas segun las probabilidades especificadas:
     *
     * <ul>
     *   <li>Ataque: 15% de probabilidad de mejora, incrementando un cuarto del nivel actual.</li>
     *   <li>Armadura: 35% de probabilidad de mejora, incrementando un cuarto del nivel actual.</li>
     *   <li>Velocidad: 65% de probabilidad de mejora, incrementando segun el nivel.</li>
     *   <li>Vida: 35% de probabilidad de mejora, incrementando la mitdad del nivel actual.</li>
     *   <li>Resistencia Magica: 80% de probabilidad de mejora, incrementando segun el nivel.</li>
     *   <li>Magia: 90% de probabilidad de mejora, incrementando segun el nivel.</li>
     * </ul>
     */
    public void subirNivel(){
        setNivel(getNivel() +1);

        Random random = new Random();
        if(random.nextDouble() < 0.15){
            setPuntos_ataque(getPuntos_ataque() + (getNivel()/4));
        }
        if(random.nextDouble() < 0.35){
            setPuntos_armadura(getPuntos_armadura() + getNivel()/4);
        }
        if(random.nextDouble() < 0.65){
            setPuntos_velocidad(getPuntos_velocidad() + getNivel());
        }
        if(random.nextDouble() < 0.35){
            setPuntos_vida((int) (getPuntos_vida() + (getPuntos_vida() * 0.5)));
        }
        if(random.nextDouble() < 0.8){
            setResistencia_magica(getResistencia_magica() + getNivel());
        }
        if(random.nextDouble() < 0.9){
            setPuntos_magia(getPuntos_magia() + getNivel());
        }
    }

    /**
     * Permite al Mago lanzar un conjuro segun el tipo de hechizo indicado.
     *
     * @param tipoHechizo de tipo int, representa el conjuro a lanzar.
     * @param objetivo de tipo String, indica a quien va dirigido el conjuro.
     */
    public void lanzarConjuro(int tipoHechizo, String objetivo){
        switch (tipoHechizo){
            case 1:
                System.out.println("¡Katon: Gōkakyū no Jutsu!");
                luchar(1);
                break;

            case 2:
                System.out.println("¡Doton: Banri Doryūheki!");
                apoyar(2, objetivo);
                break;

            case 3:
                System.out.println("¡Hirudora!");
                luchar(3);
                break;

            case 4:
                System.out.println("¡Hiraishin no Jutsu!");
                apoyar(4,objetivo);
                break;

            default:
                System.out.println("Solo son validos cualquiera de las siguientes opciones: " +
                        "\n1: Lanzar bola de fuego." +
                        "\n2: Proteger a un aliado." +
                        "\n3: Lanzar un fuerte viento." +
                        "\n4: Agiliza reacciones de un aliado.");
        }
    }

    /**
     * Permite al Mago apoyar a un aliado con un conjuro.
     *
     * @param hechizo de tipo int, determina el tipo de hechizo de apoyo.
     * @param objetivo de tipo String, indica a quien se dirige el apoyo.
     */
    public void apoyar(int hechizo, String objetivo){
        if(hechizo == 2){
            setPuntos_armadura((int) (getPuntos_magia()*0.5));
            setResistencia_magica((int) (getPuntos_magia()*0.5));
        }
        if(hechizo == 4){
            setPuntos_velocidad((int) (getPuntos_magia()*2));
        }
    }

    /**
     * Devuelve una representacion en cadena del estado actual del Mago.
     *
     * @return cadena con los atributos del Mago.
     */
    public String toString(){
        return super.toString()
                + "\nMagia: " + getPuntos_magia();
    }
}