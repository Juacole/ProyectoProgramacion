package main.java.personajes;

import main.java.equipamiento.Arma;
import main.java.equipamiento.Armadura;
import main.java.equipamiento.Artefacto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Representa una subclase de {@link Personaje} especializada en el combate fisico.
 * El main.java.personajes.Guerrero tiene la capacidad de entrar en un estado de furia lo que duplica
 * temporalmente su ataque, pero tambien incrementa el daño recibido al defenderse.
 *
 * @author Joaquin Puchuri Tunjar
 * @version 1.1.1
 */
public class Guerrero extends Personaje{
    private boolean furia;
    private Arma armaComplementaria;

    /**
     * Constructor por defecto que inicializa un main.java.personajes.Guerrero con los valores predeterminados
     * de la superclase {@link Personaje} y con el estado de furia desactivado.
     */
    public Guerrero(){
        super();
        this.furia = false;
        this.armaComplementaria = new Arma();
    }

    /**
     * Constructor por parametros que permite inicializar el main.java.personajes.Guerrero con un nombre y raza
     * especificos, heredando el resto de estadisticas de la superclase {@link Personaje}.
     *
     * @param nombre de tipo String que define el nombre del guerrero.
     * @param raza de tipo String que define la raza del guerrero.
     */
    public Guerrero(String nombre, String raza) {
        super(nombre, raza);
        this.furia = false;
        this.armaComplementaria = new Arma();
    }

    public Guerrero(String nombre, String raza, Arma arma){
        super(nombre,raza);
        setArma(arma);
        this.furia = false;
        this.armaComplementaria = new Arma();
    }

    public Guerrero(String nombre, String raza, Armadura equipamiento){
        super(nombre, raza);
        setArmadura(equipamiento);
        this.furia = false;
        this.armaComplementaria = new Arma();
    }

    public Guerrero(String nombre, String raza, Artefacto artefacto){
        super(nombre, raza, artefacto);
        this.furia = false;
        this.armaComplementaria = new Arma();
    }

    public Guerrero(String nombre, String raza, Arma arma, Armadura equipamiento){
        super(nombre, raza, arma);
        setArmadura(equipamiento);
        this.furia = false;
        this.armaComplementaria = new Arma();
    }

    public Guerrero(String nombre, String raza, Arma arma, Artefacto artefacto){
        super(nombre, raza, arma, artefacto);
        this.furia = false;
        this.armaComplementaria = new Arma();
    }

    public Guerrero(String nombre, String raza, Armadura equipamiento, Artefacto artefacto){
        super(nombre, raza, artefacto);
        setArmadura(equipamiento);
        this.furia = false;
        this.armaComplementaria = new Arma();
    }

    public Guerrero(String nombre, String raza, Arma arma, Armadura equipamiento, Artefacto artefacto){
        super(nombre, raza, arma, artefacto);
        setArmadura(equipamiento);
        this.furia = false;
        this.armaComplementaria = new Arma();
    }

    /**
     * Constructor de copia que permite inicializar un objeto a partir de otro ya existente.
     *
     * @param copia objeto de tipo main.java.personajes.Guerrero.
     */
    public Guerrero(Guerrero copia){
        super();
        this.furia = copia.furia;
        setArmaComplementaria(copia.getArmaComplementaria());
    }

    /**
     * Al inicilizarse un personaje este recibira un path donde estara la ruta hacia un
     * fichero donde estara la ficha del personaje y esta se imprimira por pantalla.
     *
     * @param path de tipo String que define la ruta del fichero del cual se inicializa
     * un objeto.
     */
    public Guerrero(String path){
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
                    if(aux.length > 1 && linea.startsWith("Furia")){
                        String valor_atributo = aux[1].replace(".","");
                        atributos[indice] = valor_atributo;
                    }
                }
                if(atributos[0].contains("Inactiva")){
                    this.furia = false;
                }else if(atributos[0].contains("Activa")){
                    this.furia = true;
                }
                br.close();
                fr.close();
            }
        } catch (IOException ioe){
            throw new RuntimeException(ioe);
        }
    }

    /**
     * Devuelve el estado de furia del main.java.personajes.Guerrero.
     *
     * @return furia de tipo boolean, true si la furia esta activada, false en caso contrario.
     */
    public boolean getFuria() {
        return furia;
    }

    public Arma getArmaComplementaria(){
        return this.armaComplementaria;
    }

    /**
     * Devuelve la cadena de texto Inactiva si el atributo furia es false, en caso contrario
     * devuelve Activa.
     *
     * @return "Inactiva" o "Activa" en funcion del atributo furia.
     */
    public String estadoFuria(){
        if(!this.furia){
            return "Inactiva";
        }
        return "Activa";
    }

    /**
     * Establece el estado de furia del main.java.personajes.Guerrero.
     *
     * @param furia de tipo boolean, true para activar la furia, false para desactivarla.
     */
    public void setFuria(boolean furia) {
        this.furia = furia;
    }

    public void setArma(Arma arma){
        if(!arma.getTipo().equals("cetro") && !arma.getTipo().equals("arco") && !arma.getTipo().equals("baston")) super.setArma(arma);
        else System.err.println("El arma del guerrero no puede ser ni cetro, arco y baston.");
    }

    public void setArmaComplementaria(Arma armaComplementaria){
        if(!super.getArma().getEmpuniadura() && !armaComplementaria.getEmpuniadura()){
            this.armaComplementaria = new Arma(armaComplementaria);
        }
    }

    public void setArmadura(Armadura armadura){
        if(armadura.getMaterial().equals("metal")) super.setArmadura(armadura);
        else System.err.println("La armadura del Guerrero solo puede ser de metal, no de otro material.");
    }

    /**
     * Incrementa el nivel del main.java.personajes.Guerrero y mejora sus estadisticas segun sus ventajas
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
     * Realiza un ataque y devuelve los puntos de ataque del main.java.personajes.Guerrero.
     * Si el main.java.personajes.Guerrero no esta en estado de furia, su ataque es normal.
     * Si esta en estado de furia, su ataque se duplica.
     *
     * @return puntos de ataque del main.java.personajes.Guerrero en base a su estado de furia.
     */
    public int Luchar(){
        if(!this.furia){
            return getPuntos_ataque() *2;
        }
        return getPuntos_ataque();
    }

    /**
     * Permite al main.java.personajes.Guerrero defenderse de un ataque, reduciendo su vida o resistencia
     * segun el tipo de ataque recibido. Si la furia esta activa, el Guerrero recibe el doble de daño.
     *
     * @param tipoAtaque de tipo int, 1 para ataque fisico, 2 para ataque magico.
     * @param objetivo de tipo String, el nombre del personaje que se defiende.
     */
    public void defender(int tipoAtaque, String objetivo){
        switch (tipoAtaque){
            case 1:
                if(this.furia){
                    setPuntos_vida((int) 2*(getPuntos_vida() - (getPuntos_armadura() - luchar())));
                } else{
                    setPuntos_vida((int) (getPuntos_vida() - (getPuntos_armadura() - luchar())));
                }
                break;
            case 2:
                if(this.furia){
                    setResistencia_magica((int) 2*(getPuntos_vida() - (getResistencia_magica() - luchar())));
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
     * Devuelve una representacion en cadena del main.java.personajes.Guerrero, incluyendo sus estadisticas
     * y el estado de furia.
     *
     * @return cadena de texto con la informacion del main.java.personajes.Guerrero.
     */
    public String toString() {
        return super.toString() + "\nFuria: " + estadoFuria();
    }
}
