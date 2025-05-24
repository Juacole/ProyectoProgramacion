package main.java.personajes.creyentes;

import main.java.equipamiento.Arma;
import main.java.equipamiento.Armadura;
import main.java.equipamiento.Artefacto;
import main.java.personajes.Personaje;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Representa a un main.java.personajes.creyentes.Creyente, una subclase abstracta de {@link Personaje} que tiene un
 * atributo nuevo fe. Los Creyentes son personajes que pueden realizar milagros basados
 * en su cantidad de fe, lo que afecta a su destreza y habilidades en combate.
 *
 * @author Joaquin Puchuri Tunjar
 * @version 1.1.1
 */
public abstract class Creyente extends Personaje {
    public int fe;

    /**
     * Constructor por defecto que crea un main.java.personajes.creyentes.Creyente con valores predeterminados y
     * asigna un nivel de fe de 10.
     */
    public Creyente(){
        super();
        this.fe = 10;
    }

    public Creyente(String nombre, String raza, Arma arma) {
        super(nombre, raza, arma);
        this.fe = 10;
    }

    public Creyente(String nombre, String raza, Armadura equipamiento) {
        super(nombre, raza, equipamiento);
        this.fe = 10;
    }

    public Creyente(String nombre, String raza, Artefacto artefacto) {
        super(nombre, raza, artefacto);
        this.fe = 10;
    }

    public Creyente(String nombre, String raza, Arma arma, Armadura equipamiento) {
        super(nombre, raza, arma, equipamiento);
        this.fe = 10;
    }

    public Creyente(String nombre, String raza, Arma arma, Artefacto artefacto) {
        super(nombre, raza, arma, artefacto);
        this.fe = 10;
    }

    public Creyente(String nombre, String raza, Armadura equipamiento, Artefacto artefacto) {
        super(nombre, raza, equipamiento, artefacto);
        this.fe = 10;
    }

    public Creyente(String nombre, String raza, Arma arma, Armadura equipamiento, Artefacto artefacto) {
        super(nombre, raza, arma, equipamiento, artefacto);
        this.fe = 10;
    }

    /**
     * Constructor que permite crear un main.java.personajes.creyentes.Creyente con un nombre, raza y nivel de fe específicos.
     *
     * @param nombre de tipo String que define el nombre del main.java.personajes.creyentes.Creyente.
     * @param raza de tipo String que define la raza del main.java.personajes.creyentes.Creyente.
     */
    public Creyente(String nombre, String raza){
        super(nombre, raza);
        this.fe = 10;
    }

    /**
     * Constructor de copia que permite inicializar un objeto a partir de otro ya existente.
     *
     * @param copia objeto de tipo main.java.personajes.creyentes.Creyente.
     */
    public Creyente(Creyente copia){
        super(copia);
        this.fe = copia.fe;
    }

    /**
     * Al inicilizarse un personaje este recibira un path donde estara la ruta hacia un
     * fichero donde estara la ficha del personaje y esta se imprimira por pantalla.
     *
     * @param path de tipo String que define la ruta del fichero del cual se inicializa
     * un objeto.
     */
    public Creyente(String path){
        super(path);
        try{
            File fichaLectura = new File(path);
            if(fichaLectura.canRead()){
                FileReader fr = new FileReader(fichaLectura);
                BufferedReader br = new BufferedReader(fr);
                String linea;
                int indice = 0;
                String[] atributos = new String[1];
                while((linea = br.readLine()) != null){
                    String[] aux = linea.split(": ");
                    if(aux.length > 1 && !linea.startsWith("Fe")){
                        String valor_atributo = aux[1].replace(".","");
                        atributos[indice] = valor_atributo;
                    }
                }
                this.fe = Integer.parseInt(atributos[0]);
                br.close();
                fr.close();
            }
        } catch (IOException ioe){
            throw new RuntimeException(ioe);
        }
    }

    /**
     * Devuelve el nivel de fe del main.java.personajes.creyentes.Creyente, que determina su capacidad para realizar milagros.
     *
     * @return el valor actual de los puntos de fe del main.java.personajes.creyentes.Creyente.
     */
    public int getFe() {
        return fe;
    }

    /**
     * Establece el nivel de fe del main.java.personajes.creyentes.Creyente.
     *
     * @param fe de tipo int que representa el nuevo nivel de fe del main.java.personajes.creyentes.Creyente.
     */
    public void setFe(int fe){
        this.fe = fe;
    }

    /**
     * Método abstracto que representa la plegaria del main.java.personajes.creyentes.Creyente. Este método se implementa
     * en las subclases de main.java.personajes.creyentes.Creyente y permite al main.java.personajes.creyentes.Creyente realizar milagros, afectando a
     * un objetivo específico dependiendo del tipo de milagro indicado.
     *
     * @param tipoMilagro de tipo int que indica el tipo de milagro a realizar.
     * @param objetivo de tipo String que especifica el objetivo del milagro.
     */
    public abstract void plegaria(int tipoMilagro, String objetivo);


    /**
     * Sobrescribe el método toString para proporcionar una representación
     * completa del estado del main.java.personajes.creyentes.Creyente, incluyendo su cantidad de fe.
     *
     * @return una cadena de texto que describe el estado del main.java.personajes.creyentes.Creyente y sus puntos de fe.
     */
    public String toString(){
        return super.toString() + "\nFe: " + getFe();
    }
}
