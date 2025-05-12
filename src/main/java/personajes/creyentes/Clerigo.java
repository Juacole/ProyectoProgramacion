package main.java.personajes.creyentes;

import main.java.equipamiento.Arma;
import main.java.equipamiento.Armadura;
import main.java.equipamiento.Artefacto;

import java.util.ArrayList;
import java.util.Random;

/**
 * La clase {@code main.java.personajes.creyentes.Clerigo} es una subclase de {@link Creyente} que representa a un Clérigo,
 * un tipo de main.java.personajes.creyentes.Creyente que combate a distancia y sana a sus aliados. Los Clérigos tienen
 * una gran capacidad de curación y resistencia mágica, pero sus habilidades de ataque y
 * defensa son limitadas.
 *
 * @author Joaquin Puchuri Tunjar
 * @version 1.1.1
 */
public class Clerigo extends Creyente{

    /**
     * Constructor por defecto, que inicializa los atributos del main.java.personajes.creyentes.Clerigo
     * utilizando el constructor de la superclase {@link Creyente}.
     */
    public Clerigo(){
        super();
    }

    /**
     * Constructor que inicializa los atributos del main.java.personajes.creyentes.Clerigo utilizando el
     * constructor de la superclase {@link Creyente} y configurando los puntos de fe.
     *
     * @param nombre el nombre del main.java.personajes.creyentes.Clerigo.
     * @param raza la raza del main.java.personajes.creyentes.Clerigo.
     */
    public Clerigo(String nombre, String raza){
        super(nombre,raza);
    }

    public Clerigo(String nombre, String raza, Arma arma) {
        super(nombre, raza);
        setArma(arma);
    }

    public Clerigo(String nombre, String raza, Armadura equipamiento) {
        super(nombre, raza);
        setArmadura(equipamiento);
    }

    public Clerigo(String nombre, String raza, ArrayList<Artefacto> artefactos) {
        super(nombre, raza, artefactos);
    }

    public Clerigo(String nombre, String raza, Arma arma, Armadura equipamiento) {
        super(nombre, raza);
        setArma(arma);
        setArmadura(equipamiento);
    }

    public Clerigo(String nombre, String raza, Arma arma, ArrayList<Artefacto> artefactos) {
        super(nombre, raza, artefactos);
        setArma(arma);
    }

    public Clerigo(String nombre, String raza, Armadura equipamiento, ArrayList<Artefacto> artefactos) {
        super(nombre, raza, artefactos);
        setArmadura(equipamiento);
    }

    public Clerigo(String nombre, String raza, Arma arma, Armadura equipamiento, ArrayList<Artefacto> artefactos) {
        super(nombre, raza, artefactos);
        setArma(arma);
        setArmadura(equipamiento);
    }

    /**
     * Constructor de copia que permite inicializar un objeto a partir de otro ya existente.
     *
     * @param copia objeto de tipo main.java.personajes.creyentes.Clerigo.
     */
    public Clerigo(Clerigo copia){
        super(copia);
    }

    /**
     * Al inicilizarse un personaje este recibira un path donde estara la ruta hacia un
     * fichero donde estara la ficha del personaje y esta se imprimira por pantalla.
     *
     * @param path de tipo String que define la ruta del fichero del cual se inicializa
     * un objeto.
     */
    public Clerigo(String path){
        super(path);
    }

    public void serArma(Arma arma){
        if(arma.getTipo().equals("baston")) super.setArma(arma);
        else System.err.println("Los sacerdotes solo podran empuñar bastones.");
    }

    public void setArmadura(Armadura armadura){
        if(armadura.getMaterial().equals("tela")) super.setArmadura(armadura);
        else System.err.println("El Clerigo solo puede llevar armadura de tela.");
    }

    /**
     * Aumenta el nivel del main.java.personajes.creyentes.Clerigo y mejora sus estadisticas segun las probabilidades especificadas:
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
            setFe(getFe() + (getNivel()*2));
        }
        if(random.nextDouble() < 0.8){
            setResistencia_magica(getResistencia_magica() + (getNivel()*2));
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
     * disponibles para un main.java.personajes.creyentes.Clerigo.
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
     * Realiza un ataque y devuelve los puntos de ataque del personaje.
     *
     * @return puntos de ataque del personaje.
     */
    public int luchar(){
        return getPuntos_ataque();
    }

    /**
     * Sobrecarga el método luchar para que el Clérigo pueda realizar un
     * ataque utilizando sus puntos de fe dependiendo del tipo de milagro.
     *
     * @param tipoMilagro el tipo de milagro que se va a realizar.
     * @return el valor del daño causado por el milagro, o los puntos de ataque.
     */
    public int luchar(int tipoMilagro){
        if(tipoMilagro == 3)
            return (int) (getFe() * 0.55);
        return getPuntos_ataque();
    }

    /**
     * Permite que el main.java.personajes.creyentes.Clerigo apoye a un aliado objetivo con un hechizo.
     * El main.java.personajes.creyentes.Clerigo solo puede usar conjuros no ofensivos para apoyar.
     *
     * @param hechizo el tipo de hechizo que el main.java.personajes.creyentes.Clerigo usa para apoyar.
     * @param objetivo un parámetro adicional, que no es utilizado en esta implementación.
     */
    public void apoyar(int hechizo, String objetivo){
        if(hechizo == 1){
            setPuntos_vida((int) (getFe() * 0.7));
        }
        if(hechizo == 2){
            setPuntos_vida((int) (getFe() * 0.7));
        }
    }

    /**
     * Devuelve una representacion en cadena del estado actual del main.java.personajes.creyentes.Clerigo.
     *
     * @return una representación en formato de texto del estado del Clérigo.
     */
    public String toString(){
        return super.toString();
    }
}
