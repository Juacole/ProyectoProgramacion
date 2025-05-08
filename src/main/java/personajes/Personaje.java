package main.java.personajes; 
/**
 * Representa un personaje generico de un juego de rol con unas estadisticas basicas.
 * Esta clase main.java.personajes.Personaje sera extenddida a traves de varias subclases de personajes con
 * nuevos comportamientos y cambios en sus estadisticas basicas de acuerdo a su categoria.
 *
 * @author Joaquin Puchuri Tunjar
 * @version 1.1.1
 * */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public abstract class Personaje{
    private String nombre;
    private String raza;
    private int nivel;
    private int puntos_vida;
    private int puntos_ataque;
    private int puntos_velocidad;
    private int puntos_armadura;
    private int resistencia_magica;
    private boolean estado;

    /**
     * Constructor por defecto que inicializa los atributos a unas estadisticas predeterminadas..
     * */
    public Personaje(){
        this.nombre="";
        this.raza="";
        this.nivel=1;
        this.puntos_vida=100;
        this.puntos_ataque=10;
        this.puntos_velocidad=10;
        this.puntos_armadura=10;
        this.resistencia_magica=10;
        this.estado=true;
    }

    /**
     * Constructor por parametros que inicializa el nombre y la raza del personaje,
     * manteniendo sus estadisticas predeterminadas.
     *
     * @param nombre de tipo String define el nombre del personaje.
     * @param raza de tipo String define la raza del personaje.
     * */
    public Personaje(String nombre, String raza){
        setNombre(nombre);
        razaElegida(raza);
        this.nivel=1;
        this.puntos_vida=100;
        this.puntos_ataque=10;
        this.puntos_velocidad=10;
        this.puntos_armadura=10;
        this.resistencia_magica=10;
        this.estado=true;
    }

    /**
     * Constructor de copia que permite inicializar un objeto a partir de otro ya existente.
     *
     * @param copia objeto de tipo main.java.personajes.Personaje.
     */
    public Personaje(Personaje copia){
        this.nombre=copia.nombre;
        this.raza=copia.raza;
        this.nivel=copia.nivel;
        this.puntos_vida=copia.puntos_vida;
        this.puntos_ataque=copia.puntos_ataque;
        this.puntos_velocidad=copia.puntos_velocidad;
        this.puntos_armadura=copia.puntos_armadura;
        this.resistencia_magica=copia.resistencia_magica;
        this.estado=copia.estado;
    }

    /**
     * Al inicilizarse un personaje este recibira un path donde estara la ruta hacia un
     * fichero donde estara la ficha del personaje y esta se imprimira por pantalla.
     *
     * @param path de tipo String que define la ruta del fichero del cual se inicializa
     * un objeto.
     */
    public Personaje(String path){
        try{
            File fichaLectura = new File(path);
            if(fichaLectura.canRead()){
                FileReader fr = new FileReader(fichaLectura);
                BufferedReader br = new BufferedReader(fr);
                String linea;
                int indice = 0;
                String[] atributos = new String[9];
                while((linea = br.readLine()) != null && indice < 9){
                    String[] aux = linea.split(": ");
                    if(aux.length > 1 && !linea.startsWith("Clase")){
                        String valor_atributo = aux[1].replace(".","");
                        atributos[indice] = valor_atributo;
                        indice++;
                    }
                }
                this.nombre = atributos[0];
                this.raza = atributos[1];
                this.nivel = Integer.parseInt(atributos[2]);
                this.puntos_vida = Integer.parseInt(atributos[3]);
                this.puntos_ataque = Integer.parseInt(atributos[4]);
                this.puntos_velocidad = Integer.parseInt(atributos[5]);
                this.puntos_armadura = Integer.parseInt(atributos[6]);
                this.resistencia_magica = Integer.parseInt(atributos[7]);
                if(atributos[8].contains("vivo")){
                    this.estado = true;
                }else if(atributos[8].contains("muerto")) {
                    this.estado = false;
                }
                br.close();
                fr.close();
            }
        } catch (IOException ioe){
            throw new RuntimeException(ioe);
        }
    }


    /**
     * Devuelve el valor del atributo nombre
     *
     * @return nombre de tipo String.
     * */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el valor del atributo raza.
     *
     * @return raza de tipo String.
     * */
    public String getRaza() {
        return raza;
    }

    /**
     * Devuelve el valor del atributo nivel.
     *
     * @return sitio_web de tipo double.
     * */
    public int getNivel() {
        return nivel;
    }

    /**
     * Devuelve el valor del atributo puntos_vida.
     *
     * @return puntos_vida de tipo double.
     * */
    public int getPuntos_vida() {
        return puntos_vida;
    }

    /**
     * Devuelve el valor del atributo puntos_ataque.
     *
     * @return puntos_ataque de tipo double.
     * */
    public int getPuntos_ataque() {
        return puntos_ataque;
    }

    /**
     * Devuelve el valor del atributo puntos_velocidad.
     *
     * @return puntos_velocidad de tipo double.
     * */
    public int getPuntos_velocidad() {
        return puntos_velocidad;
    }

    /**
     * Devuelve el valor del atributo puntos_armadura.
     *
     * @return puntos_armadura de tipo double.
     * */
    public int getPuntos_armadura() {
        return puntos_armadura;
    }

    /**
     * Devuelve el valor del atributo resistencia_magica.
     *
     * @return resistencia_magica de tipo double.
     * */
    public int getResistencia_magica() {
        return resistencia_magica;
    }

    /**
     * Devuelve el valor del atributo estado, si el personaje esta vivo
     * devuelve true, en caos contrario devolvera false.
     *
     * @return estado de tipo boolean.
     * */
    public boolean isEstado() {
        return this.estado;
    }

    /**
     * Devuelve una cadena de texto en funcion del valor del atributo estado.
     *
     * @return vivo si estado es true, y muerto si estado es false.
     */
    public String vitalidad(){
        if(this.estado == false)
            return "muerto";
        return "vivo";
    }

    /**
     * Establece la raza del personaje.
     *
     * @param raza del personaje.
     */
    public void setRaza(String raza) {
        this.raza = raza;
    }

    /**
     * Establece el nivel del personaje.
     *
     * @param nivel del personaje.
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    /**
     * Establece los puntos de vida del personaje.
     *
     * @param puntos_vida del personaje.
     */
    public void setPuntos_vida(int puntos_vida) {
        this.puntos_vida = puntos_vida;
    }

    /**
     * Establece los puntos de ataque del personaje.
     *
     * @param puntos_ataque del personaje.
     */
    public void setPuntos_ataque(int puntos_ataque) {
        this.puntos_ataque = puntos_ataque;
    }

    /**
     * Establece los puntos de velocidad del personaje.
     *
     * @param puntos_velocidad del personaje.
     */
    public void setPuntos_velocidad(int puntos_velocidad) {
        this.puntos_velocidad = puntos_velocidad;
    }

    /**
     * Establece la resistencia magica del personaje.
     *
     * @param resistencia_magica del personaje.
     */
    public void setResistencia_magica(int resistencia_magica) {
        this.resistencia_magica = resistencia_magica;
    }

    /**
     * Establece los puntos de armadura del personaje.
     *
     * @param puntos_armadura del personaje.
     */
    public void setPuntos_armadura(int puntos_armadura) {
        this.puntos_armadura = puntos_armadura;
    }

    /**
     * Establece el estado del personaje, true si esta vivo, false si esta muerto
     *
     * @param estado del personaje.
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * Establece el nombre del personaje siempre que este tenga una longitud mayor a 4,
     * y en caso de que contenga espacios se eliminaran.
     *
     * @param nombre del personaje.
     * */
    public void setNombre(String nombre){
        if(nombre.length() < 4){
            System.err.println("El nombre no puede contener menos de 4 caracteres.");
            this.nombre = "";
        } else if(nombre.contains(" ")){
            this.nombre = nombre.replace(" ", "");;
        } else{
            this.nombre = nombre;
        }
    }

    /**
     * Establece la raza del personaje siempre y cuando no sea ni angel ni demonio.
     *
     * @param raza del personaje.
     * */
    public void razaElegida(String raza){
        if(raza.equals("angel") || raza.equals("demonio")){
            System.out.println("La raza del personaje no puede ser ángel ni demonio, asegurese de elegir otra raza.");
            this.raza="";
        } else{
            this.raza=raza;
        }
    }

    /**
     * Aumenta el nivel del personaje y mejora sus estadisticas con una probabilidad
     * del 50% de aunmentar la cantidad equivalente a los puntos de vida.
     */
    public void subirNivel(){
        this.nivel++;
        this.puntos_vida += this.puntos_vida * 1.1;
        Random random = new Random();
        if(random.nextDouble() > 0.5) {
            this.puntos_ataque += this.nivel;
        }
        if(random.nextDouble() > 0.5){
            this.resistencia_magica += this.nivel;
        }
        if(random.nextDouble() > 0.5){
            this.puntos_armadura += this.nivel;
        }
        if(random.nextDouble() > 0.5){
            this.puntos_velocidad += this.nivel;
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
     * Realiza una accion de defensa basada en el tipo de ataque recibido.
     *
     * @param tipoDefensa tipo de ataque recibido, 1 para fisico y 2 para magico.
     * @param personaje nombre del personaje que se defiende.
     */
    public void defender(int tipoDefensa, String personaje) {
        switch (tipoDefensa) {
            case 1:
                this.puntos_vida -= (this.puntos_armadura - tipoDefensa);
                break;

            case 2:
                this.puntos_vida -= (this.resistencia_magica - tipoDefensa);
                break;

            default:
                System.out.println("Asegure de elegir entre los siguientes tipos de ataque: \n-1 para fisico \n-2 para magico");
                break;
        }
    }

    /**
     * Devuele la informacion actual del personaje, describiendo sus estadisticas.
     *
     * @return cadena de texto con el resumen del personaje.
     */
    public String toString(){
        return "Ficha del " + getClass().getSimpleName() + " " + getNombre() + "."
                + "\nNombre: " + getNombre() + "."
                + "\nClase: " + getClass().getSimpleName() + "."
                + "\nRaza: " + getRaza() + ".\n"
                + "\nNivel: " + getNivel() + "."
                + "\nVida: " + getPuntos_vida() + "."
                + "\nAtaque: " + getPuntos_ataque() + "."
                + "\nVelocidad: " + getPuntos_velocidad() + "."
                + "\nArmadura: " + getPuntos_armadura() + "."
                + "\nResistencia magica: " + getResistencia_magica() + ".\n"
                + "\n"
                + "Esta actualmente: " + vitalidad() + ".";
    }
}
