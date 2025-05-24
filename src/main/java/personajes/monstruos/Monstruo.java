package main.java.personajes.monstruos;

import main.java.equipamiento.Arma;
import main.java.equipamiento.Armadura;
import main.java.equipamiento.Artefacto;
import main.java.personajes.Personaje;

/**
 * La clase main.java.personajes.monstruos.Monstruo es una subclase de {@link Personaje} que representa a un monstruo,
 * un tipo de main.java.personajes.Personaje enemigo cuya estadísticas varían en función de su raza (tipo de monstruo).
 * Los monstruos tienen diferentes ventajas y desventajas según su tipo (Bestia, No-muerto o Gigante).
 *
 * @author Joaquin Puchuri Tunjar
 * @version 1.1.1
 */
public class Monstruo extends Personaje {

    /**
     * Constructor por defecto que inicializa un nuevo main.java.personajes.monstruos.Monstruo con la raza "bestia".
     * Utiliza el constructor de la superclase {@link Personaje}.
     */
    public Monstruo() {
        super();
    }

    /**
     * Constructor que inicializa un nuevo main.java.personajes.monstruos.Monstruo con el nombre y la raza especificados.
     * Utiliza el constructor de la superclase {@link Personaje}.
     *
     * @param nombre el nombre del main.java.personajes.monstruos.Monstruo.
     * @param raza   la raza del main.java.personajes.monstruos.Monstruo.
     */
    public Monstruo(String nombre, String raza) {
        super(nombre, raza);
        setRaza(raza);
    }

    /**
     * Constructor de copia que permite inicializar un objeto a partir de otro ya existente.
     *
     * @param copia objeto de tipo main.java.personajes.Guerrero.
     */
    public Monstruo(Monstruo copia){
        super(copia);
    }

    /**
     * Al inicilizarse un personaje este recibira un path donde estara la ruta hacia un
     * fichero donde estara la ficha del personaje y esta se imprimira por pantalla.
     *
     * @param path de tipo String que define la ruta del fichero del cual se inicializa
     * un objeto.
     */
    public Monstruo(String path){
        super(path);
    }

    /**
     * Método que establece las estadísticas del main.java.personajes.monstruos.Monstruo según su raza. Dependiendo
     * de la raza del main.java.personajes.monstruos.Monstruo (Bestia, No-muerto o Gigante), las estadísticas se
     * ajustan. Las razas y sus estadísticas son las siguientes:
     * <ol>
     *   <li>Bestia:
     *       <ul>
     *           <li>El doble de su nivel en ataque y velocidad.</li>
     *           <li>La misma cantidad de puntos de vida que su nivel.</li>
     *           <li>La mitad de su nivel en armadura y resistencia mágica.</li>
     *       </ul>
     *   </li>
     *   <li>No-muerto:
     *       <ul>
     *           <li>Cuatro veces su nivel en resistencia mágica.</li>
     *           <li>El mismo valor de su nivel en ataque.</li>
     *           <li>La mitad de su nivel en vida y armadura.</li>
     *           <li>Un cuarto de su nivel en velocidad.</li>
     *       </ul>
     *   </li>
     *   <li>Gigante:
     *       <ul>
     *           <li>Cuatro veces su nivel en vida y ataque.</li>
     *           <li>La misma cantidad de su nivel en armadura.</li>
     *           <li>Un cuarto de su nivel en velocidad y resistencia mágica.</li>
     *       </ul>
     *   </li>
     * </ol>
     */
    public void setRaza(String raza){
        switch (raza.toLowerCase().replace(" ","").replace("-","")){
            case "bestia":
                setPuntos_ataque(getPuntos_vida()*2);
                setPuntos_velocidad(getNivel()*2);
                setPuntos_vida(getNivel());
                setPuntos_armadura(getNivel()/2);
                setResistencia_magica(getNivel()/2);
                break;

            case "nomuerto":
                setResistencia_magica(getNivel()*4);
                setPuntos_ataque(getNivel());
                setPuntos_vida(getNivel()/2);
                setPuntos_armadura(getNivel()/2);
                setPuntos_velocidad(getNivel()/4);
                break;

            case "gigante":
                setPuntos_vida(getNivel()*4);
                setPuntos_ataque(getNivel()*4);
                setPuntos_armadura(getNivel());
                setResistencia_magica(getNivel()/4);
                setPuntos_velocidad(getNivel()/4);
                break;

            default:
                System.out.println("Asegurese de eleiger una de las siguientes opciones: " +
                        "\n-Bestia" +
                        "\n-No muerto" +
                        "\n-Gigante" +
                        "\nPor defecto se asiganara la raza de Bestia.");
                setPuntos_ataque(getPuntos_vida()*2);
                setPuntos_velocidad(getNivel()*2);
                setPuntos_vida(getNivel());
                setPuntos_armadura(getNivel()/2);
                setResistencia_magica(getNivel()/2);
        }
    }

    public void equiparMonstruo(Arma arma, Armadura armadura, Artefacto artefacto){
        switch (getRaza().toLowerCase().replace(" ","").replace("-","")){
            case "bestia":
                equiparBestia(artefacto);
                break;

            case "nomuerto":
                equiparNoMuerto(arma);
                break;

            case "gigante":
                equiparGigante(armadura);
                break;
        }

    }

    private void equiparBestia(Artefacto artefacto){
        if(artefacto.getTipo().equals("amuleto")){
            super.setArtefacto(artefacto);
        }
    }

    private void equiparNoMuerto(Arma arma){
        super.setArma(arma);
    }

    private void equiparGigante(Armadura armadura){
        if(armadura.getMaterial().equals("cuero")){
            super.setArmadura(armadura);
        }
    }

    /**
     * Devuelve una representacion en cadena del estado actual Mosntruo.
     *
     * @return una cadena de texto que representa al main.java.personajes.monstruos.Monstruo.
     */
    public String toString(){
        return super.toString();
    }
}
