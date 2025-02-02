import java.util.Random;

/**
 * Representa a un Cazador, una subclase de {@link Personaje}. Además, tiene un Compañero Animal
 * que comparte atributos y ayuda en el combate, sumando su poder de ataque al del Cazador.
 *
 * @author Joaquin Puchuri Tunjar
 * @version 1.0
 */
public class Cazador extends Personaje{

    Mascota mascota;

    /**
     * Constructor por defecto que crea un Cazador con los valores predeterminados de la
     * superclase {@link Personaje} y asigna una mascota de raza "canido".
     */
    public Cazador(){
        super();
        this.mascota = new Mascota("canido");
        mascota.setRaza();
    }

    /**
     * Constructor que permite crear un Cazador con un nombre, raza y raza de compañero animal
     * específicos.
     *
     * @param nombre de tipo String que define el nombre del Cazador.
     * @param raza de tipo String que define la raza del Cazador.
     * @param razaAnimal de tipo String que define la raza del compañero animal.
     */
    public Cazador(String nombre, String raza, String razaAnimal){
        super(nombre,raza);
        this.mascota = new Mascota(razaAnimal);
    }

    /**
     * Incrementa el nivel del Cazador y mejora sus estadisticas segun sus ventajas
     * y penalizaciones especificas. La probabilidad de mejorar cada estadistica
     * varia segun lo siguiente:
     *
     * <ul>
     *   <li>Velocidad: 70% de probabilidad de aumento.</li>
     *   <li>Otros atributos como vida, ataque, armadura y resistencia mágico tienen un 50% de probabilidad de aumento.</li>
     * </ul>
     *
     * Se actualizan las estadísticas del compañero animal según su raza y las estadisticas del Cazador.
     */
    public void subirNivel(){
        setNivel(getNivel() +1);
        setPuntos_vida(getPuntos_vida()*1.1);

        Random random = new Random();
        if(random.nextDouble() <= 0.5){
            setPuntos_ataque(getPuntos_ataque() + getNivel());
        }
        if(random.nextDouble() <= 0.5){
            setPuntos_armadura(getPuntos_armadura() + getNivel());
        }
        if(random.nextDouble() <= 0.7){
            setPuntos_velocidad(getPuntos_velocidad() + getNivel());
        }
        if(random.nextDouble() <= 0.5){
            setResistencia_magica(getResistencia_magica() + getNivel());
        }
        mascota.setRaza();
    }

    /**
     * Calcula el ataque total del Cazador, sumando los puntos de ataque del Cazador
     * y los de su compañero animal.
     *
     * @return el valor total del ataque del Cazador y su compañero animal.
     */
    public double luchar(){
        return getPuntos_ataque() + mascota.getPuntos_ataque();
    }

    /**
     * Devuelve una representación en cadena de texto del Cazador, incluyendo sus
     * estadísticas y el estado de su mascota.
     *
     * @return cadena de texto con la información del Cazador y su mascota.
     */
    public String toString(){
        return super.toString() + mascota.toString();
    }

    /**
     * Clase anidada Mascota que representa al compañero animal del Cazador.
     * Un Mascota es un {@link Personaje} que comparte estadísticas con el Cazador,
     * pero tiene sus propios valores ajustados según su raza.
     *
     * @author Joaquin Puchuri Tunjar
     * @version 1.0
     */
    public class Mascota extends Personaje{

        /**
         * Constructor por defecto que crea una Mascota con los valores predeterminados
         * de la superclase {@link Personaje}.
         */
        public Mascota(){
            super();
        }

        /**
         * Constructor que permite crear una Mascota con una raza específica.
         *
         * @param raza de tipo String que define la raza de la mascota.
         */
        public Mascota(String raza){
            super("Compañero animal", raza);
        }

        /**
         * Asigna la raza y ajusta las estadísticas de la mascota en base a su raza.
         * Las razas disponibles son "canido", "felino" y "rapaz", y cada una tiene
         * diferentes modificaciones en los atributos.
         */
        public void setRaza(){
             switch (getRaza().toLowerCase()){
                 case "canido":
                     Canido();
                     break;

                 case "felino":
                     Felino();
                     break;

                 case "rapaz":
                     Rapaz();
                     break;

                 default:
                     System.err.println("Tu compañero animal solo puede ser uno de los siguientes tipos: " +
                             "\n-canido" +
                             "\n-felino" +
                             "\n-rapaz" +
                             "\nSe le asiganara por defecto la raza de canido a tu compañero animal.");
                     Canido();
             }
        }

        /**
         * Ajusta las estadísticas de la mascota como un "Canido", que tiene 20% de los atributos
         * del Cazador.
         */
        private void Canido(){
             setNivel(getNivel()+1);
             setPuntos_vida(Cazador.this.getPuntos_vida()*1.1);
             setPuntos_ataque(Cazador.this.getPuntos_ataque()*0.2);
             setPuntos_armadura(Cazador.this.getPuntos_armadura()*0.2);
             setPuntos_velocidad(Cazador.this.getPuntos_velocidad()*0.2);
             setResistencia_magica(Cazador.this.getResistencia_magica()*0.2);
        }

        /**
         * Ajusta las estadísticas de la mascota como un "Felino", que tiene 30% de ataque y
         * velocidad, y 15% de los demás atributos del Cazador.
         */
        private void Felino(){
            setNivel(getNivel()+1);
            setPuntos_vida(Cazador.this.getPuntos_vida()*1.1);
            setPuntos_ataque(Cazador.this.getPuntos_ataque()*0.3);
            setPuntos_armadura(Cazador.this.getPuntos_armadura()*0.15);
            setPuntos_velocidad(Cazador.this.getPuntos_velocidad()*0.3);
            setResistencia_magica(Cazador.this.getResistencia_magica()*0.15);
        }

        /**
         * Ajusta las estadísticas de la mascota como un "Rapaz", que tiene 35% de velocidad,
         * 25% de resistencia mágica, 15% de ataque, y 5% de vida y armadura.
         */
        private void Rapaz(){
            setNivel(getNivel()+1);
            setPuntos_vida(Cazador.this.getPuntos_vida()*0.5);
            setPuntos_ataque(Cazador.this.getPuntos_ataque()*0.15);
            setPuntos_armadura(Cazador.this.getPuntos_armadura()*0.5);
            setPuntos_velocidad(Cazador.this.getPuntos_velocidad()*0.35);
            setResistencia_magica(Cazador.this.getResistencia_magica()*0.25);
        }

        /**
         * Devuelve una representación en cadena de la mascota, incluyendo su raza.
         *
         * @return cadena de texto con la información de la mascota.
         */
        public String toString(){
            return super.toString() + "\nLa raza del compañero animal es: " + getRaza();
        }
    }
}
