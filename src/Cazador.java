import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 * Representa a un Cazador, una subclase de {@link Personaje}. Además, tiene un Compañero Animal
 * que comparte atributos y ayuda en el combate, sumando su poder de ataque al del Cazador.
 *
 * @author Joaquin Puchuri Tunjar
 * @version 1.1.1
 */
public class Cazador extends Personaje{

    CompanieroAnimal companieroAnimal;

    /**
     * Constructor por defecto que crea un Cazador con los valores predeterminados de la
     * superclase {@link Personaje}.
     */
    public Cazador(){
        super();
        this.companieroAnimal = new CompanieroAnimal();
    }

    /**
     * Constructor que permite crear un Cazador con un nombre, raza y raza del compañero animal
     * específicos.
     *
     * @param nombre de tipo String que define el nombre del Cazador.
     * @param raza de tipo String que define la raza del Cazador.
     * @param razaAnimal de tipo String que define la raza del compañero animal.
     * @param nombreCompaniero de tipo String que define el nombre del compañero animal.
     */
    public Cazador(String nombre, String raza, String nombreCompaniero, String razaAnimal){
        super(nombre,raza);
        this.companieroAnimal = new CompanieroAnimal(nombreCompaniero, razaAnimal);
    }

    /**
     * Constructor de copia que permite inicializar un objeto a partir de otro ya existente.
     *
     * @param copia objeto de tipo Cazador.
     */
    public Cazador(Cazador copia){
        super(copia);
    }

    /**
     * Al inicilizarse un personaje este recibira un path donde estara la ruta hacia un
     * fichero donde estara la ficha del personaje y esta se imprimira por pantalla.
     *
     * @param path de tipo String que define la ruta del fichero del cual se inicializa
     * un objeto.
     */
    public Cazador(String path){
        super(path);
        companieroAnimal = new CompanieroAnimal(path);
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
        setPuntos_vida((int) (getPuntos_vida()*1.1));

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
        companieroAnimal.setRaza();
    }

    /**
     * Calcula el ataque total del Cazador, sumando los puntos de ataque del Cazador
     * y los de su compañero animal.
     *
     * @return el valor total del ataque del Cazador y su compañero animal.
     */
    public int luchar(){
        return getPuntos_ataque() + companieroAnimal.getPuntos_ataque();
    }

    /**
     * Devuelve una representación en cadena de texto del Cazador, incluyendo sus
     * estadísticas y el estado de su mascota.
     *
     * @return cadena de texto con la información del Cazador y su mascota.
     */
    public String toString(){
        return super.toString() + "\n" + companieroAnimal.toString();
    }

    /**
     * Clase anidada Mascota que representa al compañero animal del Cazador.
     * Un Mascota es un {@link Personaje} que comparte estadísticas con el Cazador,
     * pero tiene sus propios valores ajustados según su raza.
     *
     * @author Joaquin Puchuri Tunjar
     * @version 1.1
     */
    public class CompanieroAnimal extends Personaje{

        /**
         * Constructor por defecto que crea un Compañero Animal con los valores predeterminados
         * de la superclase {@link Personaje}.
         */
        public CompanieroAnimal(){
            super();
            setRaza();
        }

        /**
         * Constructor que permite crear un Compañero Animal con una raza específica.
         *
         * @param raza de tipo String que define la raza del Compañero Animal.
         */
        public CompanieroAnimal(String nombre, String raza){
            super(nombre, raza);
            setRaza();
        }

        /**
         * Constructor de copia que permite inicializar un objeto a partir de otro ya existente.
         *
         * @param copia objeto de tipo CompañeroAnimal.
         */
        public CompanieroAnimal(CompanieroAnimal copia){
            super(copia);
            setRaza();
        }

        /**
         * Al inicilizarse un personaje este recibira un path donde estara la ruta hacia un
         * fichero donde estara la ficha del personaje y esta se imprimira por pantalla.
         *
         * @param path de tipo String que define la ruta del fichero del cual se inicializa
         * un objeto.
         */
        public CompanieroAnimal(String path){
            try{
                File fichaLectura = new File(path);
                if(fichaLectura.canRead()){
                    FileReader fr = new FileReader(fichaLectura);
                    BufferedReader br = new BufferedReader(fr);
                    String linea;
                    int indice = 0;
                    String[] atributos = new String[9];
                    for(int i = 0; i < 14; i++){
                        br.readLine();
                    }
                    while((linea = br.readLine()) != null && indice < 9){
                        String[] aux = linea.split(": ");
                        if(aux.length > 1 && !linea.startsWith("Clase")){
                            String valor_atributo = aux[1].replace(".","");
                            atributos[indice] = valor_atributo;
                            indice++;
                        }
                    }
                    setNombre(atributos[0]);
                    setRaza(atributos[1]);
                    setNivel(Integer.parseInt(atributos[2]));
                    setPuntos_vida(Integer.parseInt(atributos[3]));
                    setPuntos_ataque(Integer.parseInt(atributos[4]));
                    setPuntos_velocidad(Integer.parseInt(atributos[5]));
                    setPuntos_armadura(Integer.parseInt(atributos[6]));
                    setResistencia_magica(Integer.parseInt(atributos[7]));
                    if(atributos[8].contains("vivo")){
                        setEstado(true);
                    }else if(atributos[8].contains("muerto")) {
                        setEstado(false);
                    }
                    br.close();
                    fr.close();
                }
            } catch (IOException ioe){
                throw new RuntimeException(ioe);
            }
        }

        /**
         * Asigna la raza y ajusta las estadísticas del Compañero Animal en base a su raza.
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
         * Ajusta las estadísticas del Compañero Animal como un "Canido", que tiene 20% de los atributos
         * del Cazador.
         */
        private void Canido(){
            setRaza("canido");
            setNivel(getNivel()+1);
            setPuntos_vida((int) (Cazador.this.getPuntos_vida()*1.1));
            setPuntos_ataque((int) (Cazador.this.getPuntos_ataque()*0.2));
            setPuntos_armadura((int) (Cazador.this.getPuntos_armadura()*0.2));
            setPuntos_velocidad((int) (Cazador.this.getPuntos_velocidad()*0.2));
            setResistencia_magica((int) (Cazador.this.getResistencia_magica()*0.2));
        }

        /**
         * Ajusta las estadísticas del Compañero Animal como un "Felino", que tiene 30% de ataque y
         * velocidad, y 15% de los demás atributos del Cazador.
         */
        private void Felino(){
            setRaza("felino");
            setNivel(getNivel()+1);
            setPuntos_vida((int) (Cazador.this.getPuntos_vida()*1.1));
            setPuntos_ataque((int) (Cazador.this.getPuntos_ataque()*0.3));
            setPuntos_armadura((int) (Cazador.this.getPuntos_armadura()*0.15));
            setPuntos_velocidad((int) (Cazador.this.getPuntos_velocidad()*0.3));
            setResistencia_magica((int) (Cazador.this.getResistencia_magica()*0.15));
        }

        /**
         * Ajusta las estadísticas del Compañero Animal como un "Rapaz", que tiene 35% de velocidad,
         * 25% de resistencia mágica, 15% de ataque, y 5% de vida y armadura.
         */
        private void Rapaz(){
            setRaza("rapaz");
            setNivel(getNivel()+1);
            setPuntos_vida((int) (Cazador.this.getPuntos_vida()*0.5));
            setPuntos_ataque((int) (Cazador.this.getPuntos_ataque()*0.15));
            setPuntos_armadura((int) (Cazador.this.getPuntos_armadura()*0.5));
            setPuntos_velocidad((int) (Cazador.this.getPuntos_velocidad()*0.35));
            setResistencia_magica((int) (Cazador.this.getResistencia_magica()*0.25));
        }

        /**
         * Devuelve una representación en cadena del Compañero Animal, incluyendo su raza.
         *
         * @return cadena de texto con la información del Compañero Animal.
         */
        public String toString(){
            return "\n" + super.toString();
        }
    }
}
