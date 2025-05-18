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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

import main.java.equipamiento.Arma;
import main.java.equipamiento.Armadura;
import main.java.equipamiento.Artefacto;

public abstract class Personaje {
    private String nombre;
    private String raza;
    private int nivel;
    private int puntos_vida;
    private int puntos_ataque;
    private int puntos_velocidad;
    private int puntos_armadura;
    private int resistencia_magica;
    private boolean estado;
    private Arma arma;
    private HashMap<String, Armadura> armadura;
    private ArrayList<Artefacto> artefactos;

    /**
     * Constructor por defecto que inicializa los atributos a unas estadisticas
     * predeterminadas..
     */
    public Personaje() {
        this.nombre = "";
        this.raza = "";
        this.nivel = 1;
        this.puntos_vida = 100;
        this.puntos_ataque = 10;
        this.puntos_velocidad = 10;
        this.puntos_armadura = 10;
        this.resistencia_magica = 10;
        this.estado = true;
        this.arma = new Arma();
        this.armadura = new HashMap<>();
        this.armadura.put("yelmo", null);
        this.armadura.put("pechera", null);
        this.armadura.put("hombreras", null);
        this.armadura.put("guanteletes", null);
        this.armadura.put("grebas", null);
        this.armadura.put("botas", null);
        this.artefactos = new ArrayList<>();
    }

    /**
     * Constructor por parametros que inicializa el nombre y la raza del personaje,
     * manteniendo sus estadisticas predeterminadas.
     *
     * @param nombre de tipo String define el nombre del personaje.
     * @param raza   de tipo String define la raza del personaje.
     */
    public Personaje(String nombre, String raza) {
        setNombre(nombre);
        razaElegida(raza);
        this.nivel = 1;
        this.puntos_vida = 100;
        this.puntos_ataque = 10;
        this.puntos_velocidad = 10;
        this.puntos_armadura = 10;
        this.resistencia_magica = 10;
        this.estado = true;
        this.arma = new Arma();
        this.armadura = new HashMap<>();
        this.armadura.put("yelmo", null);
        this.armadura.put("pechera", null);
        this.armadura.put("hombreras", null);
        this.armadura.put("guanteletes", null);
        this.armadura.put("grebas", null);
        this.armadura.put("botas", null);
        this.artefactos = new ArrayList<>();
    }

    public Personaje(String nombre, String raza, Arma arma) {
        setNombre(nombre);
        razaElegida(raza);
        this.nivel = 1;
        this.puntos_vida = 100;
        this.puntos_ataque = 10;
        this.puntos_velocidad = 10;
        this.puntos_armadura = 10;
        this.resistencia_magica = 10;
        this.estado = true;
        setArma(arma);
        this.armadura = new HashMap<>();
        this.armadura.put("yelmo", null);
        this.armadura.put("pechera", null);
        this.armadura.put("hombreras", null);
        this.armadura.put("guanteletes", null);
        this.armadura.put("grebas", null);
        this.armadura.put("botas", null);
        this.artefactos = new ArrayList<>();
    }

    public Personaje(String nombre, String raza, Armadura equipamiento) {
        setNombre(nombre);
        razaElegida(raza);
        this.nivel = 1;
        this.puntos_vida = 100;
        this.puntos_ataque = 10;
        this.puntos_velocidad = 10;
        this.puntos_armadura = 10;
        this.resistencia_magica = 10;
        this.estado = true;
        this.arma = new Arma();
        this.armadura = new HashMap<>();
        this.armadura.put("yelmo", null);
        this.armadura.put("pechera", null);
        this.armadura.put("hombreras", null);
        this.armadura.put("guanteletes", null);
        this.armadura.put("grebas", null);
        this.armadura.put("botas", null);
        setArmadura(equipamiento);
    }

    public Personaje(String nombre, String raza, ArrayList<Artefacto> artefactos) {
        setNombre(nombre);
        razaElegida(raza);
        this.nivel = 1;
        this.puntos_vida = 100;
        this.puntos_ataque = 10;
        this.puntos_velocidad = 10;
        this.puntos_armadura = 10;
        this.resistencia_magica = 10;
        this.estado = true;
        this.arma = new Arma();
        this.armadura = new HashMap<>();
        this.armadura.put("yelmo", null);
        this.armadura.put("pechera", null);
        this.armadura.put("hombreras", null);
        this.armadura.put("guanteletes", null);
        this.armadura.put("grebas", null);
        this.armadura.put("botas", null);
        setArtefactos(artefactos);
    }


    public Personaje(String nombre, String raza, Arma arma, Armadura armadura) {
        setNombre(nombre);
        razaElegida(raza);
        this.nivel = 1;
        this.puntos_vida = 100;
        this.puntos_ataque = 10;
        this.puntos_velocidad = 10;
        this.puntos_armadura = 10;
        this.resistencia_magica = 10;
        this.estado = true;
        setArma(arma);
        this.armadura = new HashMap<>();
        this.armadura.put("yelmo", null);
        this.armadura.put("pechera", null);
        this.armadura.put("hombreras", null);
        this.armadura.put("guanteletes", null);
        this.armadura.put("grebas", null);
        this.armadura.put("botas", null);
        setArmadura(armadura);
    }

    public Personaje(String nombre, String raza, Armadura equipamiento, ArrayList<Artefacto> artefactos) {
        setNombre(nombre);
        razaElegida(raza);
        this.nivel = 1;
        this.puntos_vida = 100;
        this.puntos_ataque = 10;
        this.puntos_velocidad = 10;
        this.puntos_armadura = 10;
        this.resistencia_magica = 10;
        this.estado = true;
        this.arma = new Arma();
        this.armadura = new HashMap<>();
        this.armadura.put("yelmo", null);
        this.armadura.put("pechera", null);
        this.armadura.put("hombreras", null);
        this.armadura.put("guanteletes", null);
        this.armadura.put("grebas", null);
        this.armadura.put("botas", null);
        setArmadura(equipamiento);
        setArtefactos(artefactos);
    }

    public Personaje(String nombre, String raza, Arma arma, ArrayList<Artefacto> artefactos) {
        setNombre(nombre);
        razaElegida(raza);
        this.nivel = 1;
        this.puntos_vida = 100;
        this.puntos_ataque = 10;
        this.puntos_velocidad = 10;
        this.puntos_armadura = 10;
        this.resistencia_magica = 10;
        this.estado = true;
        setArma(arma);
        this.armadura = new HashMap<>();
        this.armadura.put("yelmo", null);
        this.armadura.put("pechera", null);
        this.armadura.put("hombreras", null);
        this.armadura.put("guanteletes", null);
        this.armadura.put("grebas", null);
        this.armadura.put("botas", null);
        setArtefactos(artefactos);
    }

    public Personaje(String nombre, String raza, Arma arma, Armadura equipamiento, ArrayList<Artefacto> artefactos) {
        setNombre(nombre);
        razaElegida(raza);
        this.nivel = 1;
        this.puntos_vida = 100;
        this.puntos_ataque = 10;
        this.puntos_velocidad = 10;
        this.puntos_armadura = 10;
        this.resistencia_magica = 10;
        this.estado = true;
        setArma(arma);
        this.armadura = new HashMap<>();
        this.armadura.put("yelmo", null);
        this.armadura.put("pechera", null);
        this.armadura.put("hombreras", null);
        this.armadura.put("guanteletes", null);
        this.armadura.put("grebas", null);
        this.armadura.put("botas", null);
        setArmadura(equipamiento);
        setArtefactos(artefactos);
    }

    /**
     * Constructor de copia que permite inicializar un objeto a partir de otro ya
     * existente.
     *
     * @param copia objeto de tipo main.java.personajes.Personaje.
     */
    public Personaje(Personaje copia) {
        setNombre(copia.getNombre());
        setRaza(copia.getRaza());
        setNivel(copia.getNivel());
        setPuntos_vida(copia.getPuntos_vida());
        setPuntos_ataque(copia.getPuntos_ataque());
        setPuntos_velocidad(copia.getPuntos_velocidad());
        setPuntos_armadura(copia.getPuntos_armadura());
        setResistencia_magica(copia.getResistencia_magica());
        setEstado(copia.isEstado());
        setArma(copia.getArma());
        setArmadura(copia.getArmadura());
        setArtefactos(copia.getArtefactos());
    }

    /**
     * Al inicilizarse un personaje este recibira un path donde estara la ruta hacia
     * un
     * fichero donde estara la ficha del personaje y esta se imprimira por pantalla.
     *
     * @param path de tipo String que define la ruta del fichero del cual se
     *             inicializa
     *             un objeto.
     */
    public Personaje(String path) {
        try {
            File fichaLectura = new File(path);
            if (fichaLectura.canRead()) {
                FileReader fr = new FileReader(fichaLectura);
                BufferedReader br = new BufferedReader(fr);
                String linea;
                int indice = 0;
                String[] atributos = new String[9];
                while ((linea = br.readLine()) != null && indice < 9) {
                    String[] aux = linea.split(": ");
                    if (aux.length > 1 && !linea.startsWith("Clase")) {
                        String valor_atributo = aux[1].replace(".", "");
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
                if (atributos[8].contains("vivo")) {
                    this.estado = true;
                } else if (atributos[8].contains("muerto")) {
                    this.estado = false;
                }
                br.close();
                fr.close();
            }
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    /**
     * Devuelve el valor del atributo nombre
     *
     * @return nombre de tipo String.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el valor del atributo raza.
     *
     * @return raza de tipo String.
     */
    public String getRaza() {
        return raza;
    }

    /**
     * Devuelve el valor del atributo nivel.
     *
     * @return sitio_web de tipo double.
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Devuelve el valor del atributo puntos_vida.
     *
     * @return puntos_vida de tipo double.
     */
    public int getPuntos_vida() {
        return puntos_vida;
    }

    /**
     * Devuelve el valor del atributo puntos_ataque.
     *
     * @return puntos_ataque de tipo double.
     */
    public int getPuntos_ataque() {
        return puntos_ataque;
    }

    /**
     * Devuelve el valor del atributo puntos_velocidad.
     *
     * @return puntos_velocidad de tipo double.
     */
    public int getPuntos_velocidad() {
        return puntos_velocidad;
    }

    /**
     * Devuelve el valor del atributo puntos_armadura.
     *
     * @return puntos_armadura de tipo double.
     */
    public int getPuntos_armadura() {
        return puntos_armadura;
    }

    /**
     * Devuelve el valor del atributo resistencia_magica.
     *
     * @return resistencia_magica de tipo double.
     */
    public int getResistencia_magica() {
        return resistencia_magica;
    }

    public Arma getArma() {
        return this.arma;
    }

    public ArrayList<Artefacto> getArtefactos() {
        return this.artefactos;
    }

    /**
     * Devuelve el valor del atributo estado, si el personaje esta vivo
     * devuelve true, en caos contrario devolvera false.
     *
     * @return estado de tipo boolean.
     */
    public boolean isEstado() {
        return this.estado;
    }

    /**
     * Devuelve una cadena de texto en funcion del valor del atributo estado.
     *
     * @return vivo si estado es true, y muerto si estado es false.
     */
    public String vitalidad() {
        if (!this.estado)
            return "muerto";
        return "vivo";
    }

    public HashMap<String, Armadura> getArmadura() {
        return this.armadura;
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
     * Establece el nombre del personaje siempre que este tenga una longitud mayor a
     * 4,
     * y en caso de que contenga espacios se eliminaran.
     *
     * @param nombre del personaje.
     */
    public void setNombre(String nombre) {
        if (nombre.length() < 4) {
            System.err.println("El nombre no puede contener menos de 4 caracteres.");
            this.nombre = "";
        } else if (nombre.contains(" ")) {
            this.nombre = nombre.replace(" ", "");
        } else {
            this.nombre = nombre;
        }
    }

    /**
     * Establece la raza del personaje siempre y cuando no sea ni angel ni demonio.
     *
     * @param raza del personaje.
     */
    public void razaElegida(String raza) {
        if (raza.equals("angel") || raza.equals("demonio")) {
            System.out.println("La raza del personaje no puede ser ángel ni demonio, asegurese de elegir otra raza.");
            this.raza = "";
        } else {
            this.raza = raza;
        }
    }

    public void setArmadura(Armadura equipamiento) {
        if(this.armadura.get(equipamiento.getTipo()) != null){
            this.armadura.put(equipamiento.getTipo(), equipamiento);
        }
    }

    public void setArmadura(HashMap<String, Armadura> armadura) {
        Set<String> piezasValidas = Set.of("yelmo", "pechera", "hombreras", "guanteletes", "grebas", "botas");
        for (String clave : armadura.keySet()) {
            if (!piezasValidas.contains(clave) && UnaPiezaPorCadaTipoDeArmadura(armadura)) {
                System.err.println("Pieza invalida: " + clave + " : " + armadura.get(clave));
            }
        }
        this.armadura.putAll(armadura);
    }

    public boolean UnaPiezaPorCadaTipoDeArmadura(HashMap<String, Armadura> armadura) {
        int contadorYelmo = 0;
        int contadorPechera = 0;
        int contadorHombreras = 0;
        int contadorGuanteletes = 0;
        int contadorGrebas = 0;
        int contadorBotas = 0;
        for (String clave : armadura.keySet()) {
            if (armadura.get(clave).getTipo().equals("yelmo")) {
                contadorYelmo++;
                if (contadorYelmo > 1) return false;
            }else  if (armadura.get(clave).getTipo().equals("pechera")) {
                contadorPechera++;
                if (contadorPechera > 1) return false;
            }else  if (armadura.get(clave).getTipo().equals("hombreras")) {
                contadorHombreras++;
                if (contadorHombreras > 1) return false;
            }else  if (armadura.get(clave).getTipo().equals("guanteletes")) {
                contadorGuanteletes++;
                if (contadorGuanteletes > 1) return false;
            }else  if (armadura.get(clave).getTipo().equals("grebas")) {
                contadorGrebas++;
                if (contadorGrebas > 1) return false;
            }else  if (armadura.get(clave).getTipo().equals("botas")) {
                contadorBotas++;
                if (contadorBotas > 1) return false;
            }
        }
        int total = contadorHombreras + contadorGrebas + contadorBotas + contadorGuanteletes + contadorPechera + contadorYelmo;
        return total == 6;
    }

    public void setArma(Arma arma) {
        this.arma = new Arma(arma);
    }

    public void setArtefacto(Artefacto artefacto){
        this.artefactos.add(artefacto);
    }

    public void setArtefactos(ArrayList<Artefacto> artefactos) {
        int contador = 0;
        for(Artefacto artefacto : artefactos){
            if(tieneExactamenteUnAmuleto(artefactos)){
                this.artefactos.add(artefacto);
            }else if(tieneExactamenteUnoOdosAnillos(artefactos)){
                this.artefactos.add(artefacto);
            }else{
                System.err.println("El personaje solo puede tener un amuleto como maximo, y dos anillos como maximo.");
            }
        }
    }

    public boolean tieneExactamenteUnAmuleto(ArrayList<Artefacto> artefactos) {
        int contador = 0;
        for (Artefacto art : artefactos) {
            if (art.getTipo().toLowerCase().equals("amuleto")) {
                contador++;
                if (contador > 1) return false;
            }
        }
        return contador == 1;
    }

    public boolean tieneExactamenteUnoOdosAnillos(ArrayList<Artefacto> artefactos) {
        int contador = 0;
        for (Artefacto art : artefactos) {
            if (art.getTipo().toLowerCase().equals("anillo")) {
                contador++;
                if (contador > 2) return false;
            }
        }
        return contador >= 1 && contador <= 2;
    }

    /**
     * Aumenta el nivel del personaje y mejora sus estadisticas con una probabilidad
     * del 50% de aunmentar la cantidad equivalente a los puntos de vida.
     */
    public void subirNivel() {
        this.nivel++;
        this.puntos_vida += this.puntos_vida * 1.1;
        Random random = new Random();
        if (random.nextDouble() > 0.5) {
            this.puntos_ataque += this.nivel;
        }
        if (random.nextDouble() > 0.5) {
            this.resistencia_magica += this.nivel;
        }
        if (random.nextDouble() > 0.5) {
            this.puntos_armadura += this.nivel;
        }
        if (random.nextDouble() > 0.5) {
            this.puntos_velocidad += this.nivel;
        }
    }

    /**
     * Realiza un ataque y devuelve los puntos de ataque del personaje.
     *
     * @return puntos de ataque del personaje.
     */
    public int luchar() {
        return getPuntos_ataque();
    }

    /**
     * Realiza una accion de defensa basada en el tipo de ataque recibido.
     *
     * @param tipoDefensa tipo de ataque recibido, 1 para fisico y 2 para magico.
     * @param personaje   nombre del personaje que se defiende.
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
                System.out.println(
                        "Asegure de elegir entre los siguientes tipos de ataque: \n-1 para fisico \n-2 para magico");
                break;
        }
    }

    /**
     * Devuele la informacion actual del personaje, describiendo sus estadisticas.
     *
     * @return cadena de texto con el resumen del personaje.
     */
    public String toString() {
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
                + "Esta actualmente: " + vitalidad() + "."
                + "\nArma: " + getArma() + "."
                + "\nArmadura: " + "\n" + getArmadura().toString() + "."
                + "\nArtefactos: " + getArtefactos().toString() + ".";
    }
}
