/**
 * La clase ofrece metodos para crear y trabajar con ficheros, crear
 * instancias a partir de objetos y modificar instancias a partir de
 * ficheros.
 *
 * @author Joaquin Puchuri Tunjar
 * @version 2.0
 */

import java.io.*;
public class GameLogger {

    /**
     * Metodo para emitir fichas de un grupo de personajes en un fichero de texto.
     *
     * @param path de tipo String, recibe la ruta hacia el directorio donde se
     * emitira la ficha.
     * @param personaje de tipo Personje, sirve para guardar la ficha del personaje
     * en funcion de su nombre.
     */
    public static void fichaPersonaje(String path, Personaje personaje){
        try{
            FileWriter fw = new FileWriter(path + personaje.getNombre() + ".txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(personaje.toString());
            bw.close();
            fw.close();
        }catch (IOException ioe){
            throw new RuntimeException(ioe);
        }
    }

    /**
     * Emite un fichero en funcion de varias fichas de personajes, ordenando
     * la escritura de las fichas por estadística de velocidad y en caso de
     * empate llama al metodo privado ordenarAlfabeticamente().
     *
     * @param lista un array de Personajes.
     * @param path de tipo String, recibe la ruta hacia el directorio donde se
     * emitira la ficha.
     */
    public static void party(Personaje[] lista, String path){
        for(int i = 0; i < lista.length -1; i++){
            for(int j = 0; j < lista.length -i -1; j++){
                if(lista[j].getPuntos_velocidad() < lista[j+1].getPuntos_velocidad()){
                    Personaje aux = lista[j];
                    lista[j] = lista[j+1];
                    lista[j+1] = aux;
                }else if(lista[j].getPuntos_velocidad() == lista[j+1].getPuntos_velocidad()) ordenarAlfabeticamente(lista, j);
            }
        }
        try{
            File fihceroSalida = new File(path);
            FileWriter fw = new FileWriter(fihceroSalida);
            BufferedWriter bw = new BufferedWriter(fw);
            int indice = 1;
            for(int i = 0; i < lista.length; i++){
                bw.write(indice++ + "- " + lista[i].getNombre() + "\n");
                bw.write(lista[i].toString() + "\n");
                bw.newLine();
            }
            bw.close();
            fw.close();
        }catch (IOException ioe){
            throw new RuntimeException(ioe);
        }
    }


    /**
     * Actualiza el estado de un personaje leyendo sus atributos desde un fichero,
     * asignando los atributos al personaje proporcionado.
     *
     * @param pj de tipo Personaje, el personaje cuyos atributos serán actualizados.
     * @param path de tipo String, la ruta al fichero que contiene los atributos del personaje.
     */
    public static void estadoPersonaje(Personaje pj, String path){
        try{
            File fichaLectura = new File(path);
            if(fichaLectura.canRead()){
                FileReader fr = new FileReader(fichaLectura);
                BufferedReader br = new BufferedReader(fr);
                String linea;
                int indice = 0;
                String[] atributos = new String[11];
                while((linea = br.readLine()) != null && indice < 11){
                    String[] aux = linea.split(": ");
                    if(aux.length > 1){
                        String valor_atributo = aux[1].replace(".","");
                        atributos[indice] = valor_atributo;
                        indice++;
                    }
                }
                asignarAtributos(atributos, pj, path);
                br.close();
                fr.close();
            }
        } catch (IOException ioe){
            throw new RuntimeException(ioe);
        }
    }


    /**
     * Verifica si un personaje con el nombre especificado existe en los registros del juego,
     * buscando en todos los archivos proporcionados en el array de paths.
     *
     * @param paths array de String que contiene las rutas a los ficheros de personajes.
     * @param nombrePersonaje de tipo String, el nombre del personaje a buscar.
     */
    public static void existePersonaje(String[] paths, String nombrePersonaje){
        boolean noEncontrado = false;
        for(int i = 0; i < paths.length; i++){
            String[] aux = paths[i].replace(".txt", "").split("\\\\");
            for(int j = 0; j < aux.length; j++){
                if(aux[j].equals(nombrePersonaje)) {
                    noEncontrado = true;
                    System.out.println(nombrePersonaje + " existe en los registros del juego.");
                }
            }
        }
        if(!noEncontrado) System.out.println(nombrePersonaje + " no existe en los registros del juego.");
    }

    /**
     * Cuenta cuántas veces aparece una clase específica en los registros del juego,
     * buscado en todos los archivos proporcionados en el array de paths.
     *
     * @param paths array de String que contiene las rutas a los ficheros de personajes.
     * @param nombreClass de tipo String, el nombre de la clase a buscar.
     */
    public static void numClases(String[] paths, String nombreClass){
        int contador = 0;
        try{
            for(int i = 0; i < paths.length; i++){
                String path = paths[i];
                File lectura = new File(path);
                if(lectura.canRead()){
                    FileReader fr = new FileReader(lectura);
                    BufferedReader br = new BufferedReader(fr);
                    String linea;
                    while((linea = br.readLine()) != null){
                        if(linea.startsWith("Clase") && linea.contains(nombreClass)){
                            contador++;
                        }
                    }
                    br.close();
                    fr.close();
                }
            }
            if(contador > 0) System.out.println("La clase " + nombreClass + " aparece " + contador + " veces en los archivos del juego.");
            else System.out.println("La clase " + nombreClass + " no aparece en los registros del juego.");
        }catch (IOException ioe){
            throw new RuntimeException(ioe);
        }
    }

    /**
     * Crea un registro detallado de un combate entre dos personajes y lo guarda en un fichero.
     * El registro incluye la narrativa del combate, los ataques realizados y el resultado final.
     *
     * @param path de tipo String, la ruta donde se guardará el registro del combate.
     * @param pepe1 de tipo Personaje, el primer participante del combate.
     * @param pepe2 de tipo Personaje, el segundo participante del combate.
     */
    public static void registroCombate(String path, Personaje pepe1, Personaje pepe2){
        try{
            FileWriter fw = new FileWriter(path + pepe1.getNombre() + " vs " + pepe2.getNombre() + ".txt");
            BufferedWriter bw = new BufferedWriter(fw);
            if (pepe1.getPuntos_vida() > 0 && pepe2.getPuntos_vida() > 0) {
                bw.write("\nEn un mundo donde solo los más fuertes sobreviven...");
                bw.newLine();
                bw.write("Dos guerreros se encuentran en un campo de batalla marcado por antiguas luchas.");
                bw.newLine();
                bw.write(pepe1.getNombre() + ", un valeroso " + pepe1.getRaza() + ", afila su arma mientras observa a su oponente.");
                bw.newLine();
                bw.write("A unos pasos de distancia, " + pepe2.getNombre() + ", un feroz " + pepe2.getRaza() + ", deja escapar una risa desafiante.");
                bw.newLine();
                bw.write("El viento se detiene. La tensión es insoportable.");
                bw.newLine();
                bw.write("¡Que comience el combate!\n");
                bw.newLine();

                bw.write(pepe1.toString() + "\n\n");
                bw.write(pepe2.toString() + "\n");

                do {
                    if (pepe1.getPuntos_velocidad() >= pepe2.getPuntos_velocidad() * 2) {
                        bw.write("\n" + pepe1.getNombre() + " es increíblemente rápido y ataca dos veces seguidas");
                        bw.write(pepe2.getPuntos_vida() - (pepe1.luchar() * 2));
                        bw.newLine();
                        bw.write("---" + pepe1.getNombre() + " inflige un total de " + pepe1.luchar()*2 + " puntos de ataque---");
                        bw.newLine();
                        bw.write(pepe2.getNombre() + " contraataca con todas sus fuerzas.");
                        bw.newLine();
                        pepe1.setPuntos_vida(pepe1.getPuntos_vida() - pepe2.luchar());
                        bw.write("---" + pepe2.getNombre() + " inflige un total de " + pepe2.luchar() + " puntos de ataque---");
                        bw.newLine();

                    } else if (pepe2.getPuntos_velocidad() >= pepe1.getPuntos_velocidad() * 2) {
                        bw.write("\n" + pepe2.getNombre() + " aprovecha su agilidad y ataca dos veces seguidas");
                        bw.newLine();
                        pepe1.setPuntos_vida(pepe1.getPuntos_vida() - (pepe2.luchar() * 2));
                        bw.write("---" + pepe2.getNombre() + " inflige un total de " + pepe2.luchar()*2 + " puntos de ataque---");
                        bw.newLine();
                        bw.write(pepe1.getNombre() + " responde con un feroz contraataque.");
                        pepe2.setPuntos_vida(pepe2.getPuntos_vida() - pepe1.luchar());
                        bw.newLine();
                        bw.write("---" + pepe1.getNombre() + " inflige un total de " + pepe1.luchar() + " puntos de ataque---");
                        bw.newLine();

                    } else if (pepe1.getPuntos_velocidad() > pepe2.getPuntos_velocidad()) {
                        bw.write("\n" + pepe1.getNombre() + " es más rápido y ataca primero!");
                        bw.newLine();
                        pepe2.setPuntos_vida(pepe2.getPuntos_vida() - pepe1.luchar());
                        bw.write("---" + pepe1.getNombre() + " inflige un total de " + pepe1.luchar() + " puntos de ataque---");
                        bw.newLine();
                        bw.write(pepe1.getNombre() + " golpea a " + pepe2.getNombre() + " con precisión, pero " + pepe2.getNombre() + " responde con un fuerte golpe.");
                        bw.newLine();
                        pepe1.setPuntos_vida(pepe1.getPuntos_vida() - pepe2.luchar());
                        bw.write("---" + pepe2.getNombre() + " inflige un total de " + pepe2.luchar() + " puntos de ataque---");
                        bw.newLine();

                    } else {
                        bw.write("\n" + pepe2.getNombre() + " es más rápido y ataca primero!");
                        bw.newLine();
                        pepe1.setPuntos_vida(pepe1.getPuntos_vida() - pepe2.luchar());
                        bw.write("---" + pepe2.getNombre() + " inflige un total de " + pepe2.luchar() + " puntos de ataque---");
                        bw.newLine();
                        bw.write(pepe2.getNombre() + " ataca sin dudarlo, pero " + pepe1.getNombre() + " contraataca con furia.");
                        bw.newLine();
                        pepe2.setPuntos_vida(pepe2.getPuntos_vida() - pepe1.luchar());
                        bw.write("---" + pepe1.getNombre() + " inflige un total de " + pepe1.luchar() + " puntos de ataque---");
                        bw.newLine();
                    }
                    bw.write("\nVida de " + pepe1.getNombre() + ": " + pepe1.getPuntos_vida());
                    bw.newLine();
                    bw.write("Vida de " + pepe2.getNombre() + ": " + pepe2.getPuntos_vida() + "\n");

                } while (pepe1.getPuntos_vida() > 0 && pepe2.getPuntos_vida() > 0);

                if (pepe1.getPuntos_vida() > 0) {
                    bw.newLine();
                    bw.write("El ganador es " + pepe1.getNombre() + ", ha derrotado a " + pepe2.getNombre());
                    bw.newLine();
                } else {
                    bw.newLine();
                    bw.write("El ganador es " + pepe2.getNombre() + ", ha derrotado a " + pepe1.getNombre());
                    bw.newLine();
                }
                bw.newLine();
                bw.write("El combate ha terminado. Solo el más fuerte queda en pie.");
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Sube de nivel al personaje que haya ganado combates según los registros,
     * buscando en los archivos de registro de combate especificado para determinar
     * el ganador.
     *
     * @param personajes array de Personaje, los personajes que podrían subir de nivel.
     * @param path de tipo String, la ruta al fichero de registro del combate.
     */
    public static void ganadorCombate(Personaje[] personajes, String path){
        try {
            for (int i = 0; i < personajes.length; i++) {
                File lectura = new File(path);
                if (lectura.canRead()) {
                    FileReader fr = new FileReader(lectura);
                    BufferedReader br = new BufferedReader(fr);
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        if (linea.startsWith("El ganador es " + personajes[i].getNombre())) personajes[i].subirNivel();
                    }
                    br.close();
                    fr.close();
                }
            }
        } catch (IOException ioe){
            throw new RuntimeException(ioe);
        }
    }


    /**
     * Ordena alfabéticamente dos personajes consecutivos en un array.
     * Método auxiliar utilizado cuando hay empate en velocidad al ordenar en
     * el metodo party.
     *
     * @param lista array de Personaje, la lista de personajes a ordenar.
     * @param indice de tipo int, la posición del primer personaje a comparar.
     */
    private static void ordenarAlfabeticamente(Personaje[] lista, int indice){
        if(lista[indice].getNombre().compareToIgnoreCase(lista[indice+1].getNombre()) > 0){
            Personaje aux = lista[indice];
            lista[indice] = lista[indice+1];
            lista[indice+1] = aux;
        }
    }

    /**
     * Asigna los atributos leídos de un fichero a un personaje.
     * Método auxiliar que actualiza todas las estadísticas del
     * personaje según los valores del fichero.
     *
     * @param atributos array de String, los valores de los atributos leídos del fichero.
     * @param pj de tipo Personaje, el personaje cuyos atributos serán actualizados.
     * @param path de tipo String, la ruta al fichero (utilizada para casos especiales como Cazador).
     */
    private static void asignarAtributos(String[] atributos, Personaje pj, String path){
        if(!atributos[0].equals(pj.getNombre()) && atributos[0] != null) pj.setNombre(atributos[0]);
        if(atributos[1] != null && atributos[10] != null) atributosEspeciales(atributos, pj, path);
        if(!atributos[2].equals(pj.getRaza()) && atributos[2] != null) pj.setRaza(atributos[2]);
        if(Integer.parseInt(atributos[3]) != pj.getNivel() && atributos[3] != null) pj.setNivel(Integer.parseInt(atributos[3]));
        if(Integer.parseInt(atributos[4]) != pj.getPuntos_vida() && atributos[4] != null) pj.setPuntos_vida(Integer.parseInt(atributos[4]));
        if(Integer.parseInt(atributos[5]) != pj.getPuntos_ataque() && atributos[5] != null) pj.setPuntos_ataque(Integer.parseInt(atributos[5]));
        if(Integer.parseInt(atributos[6]) != pj.getPuntos_velocidad() && atributos[6] != null) pj.setPuntos_velocidad(Integer.parseInt(atributos[6]));
        if(Integer.parseInt(atributos[7]) != pj.getPuntos_armadura() && atributos[7] != null) pj.setPuntos_armadura(Integer.parseInt(atributos[7]));
        if(Integer.parseInt(atributos[8]) != pj.getResistencia_magica() && atributos[8] != null) pj.setResistencia_magica(Integer.parseInt(atributos[8]));
        if(atributos[9].equals("vivo")) pj.setEstado(true);
        else if (atributos[9].equals("muerto")) pj.setEstado(false);
    }

    /**
     * Metodo auxiliar utilizado en el metodo asignarAtributos, que permite actualizar
     * el atributo unico para las clases Guerrero, Mago, Creyente, Clerigo y Paladin.
     * En caso de Cazador se llama a un metodo auxiliar para inicializar el compañero
     * animal.
     *
     * @param atributos un array de String, contiene los datos necesarios para inicializar el atributo unico.
     * @param pj objeto de tipo Personaje, es el objeto que se actualizara.
     * @param path de tipo String, el path contiene el archivo con el cual se actualizara el objeto.
     */
    private static void atributosEspeciales(String[] atributos, Personaje pj, String path){
        switch (atributos[1]){
            case "Guerrero":
                Guerrero guerrero = (Guerrero) pj;
                if(atributos[10].equals("Inactiva")) guerrero.setFuria(false);
                else if(atributos[10].equals("Activa")) guerrero.setFuria(true);
                break;

            case "Mago":
                Mago mago = (Mago) pj;
                mago.setPuntos_magia(Integer.parseInt(atributos[10]));
                break;

            case "Creyente":
                Creyente creyente = (Creyente) pj;
                creyente.setFe(Integer.parseInt(atributos[10]));
                break;

            case "Clerigo":
                Clerigo clerigo = (Clerigo) pj;
                clerigo.setFe(Integer.parseInt(atributos[10]));
                break;

            case "Paladin":
                Paladin paladin = (Paladin) pj;
                paladin.setFe(Integer.parseInt(atributos[10]));
                break;

            case "Cazador":
                Cazador cazador = (Cazador) pj;
                actualizarCompanieroAnimal(path, cazador);
                break;
        }
    }

    /**
     * Metodo auxiliar para actualizar los atributos del compañero animal del
     * Cazador. Este metodo recorre un path y va guardando cada valor de los
     * atributos del compañero animal para luego asignarselos.
     *
     * @param path de tipo String, el path contiene el archivo con el cual se actualizara el compañero animal.
     * @param cazador de tipo Cazador, nos permite llamar a la instancia actual del compañero animal para actualizar sus atributos.
     */
    private static void actualizarCompanieroAnimal(String path, Cazador cazador) {
        try {
            File fichaLectura = new File(path);
            if (fichaLectura.canRead()) {
                FileReader fr = new FileReader(fichaLectura);
                BufferedReader br = new BufferedReader(fr);
                String[] atributos = new String[9];
                int indice = 0;
                String linea;
                for (int i = 0; i < 14; i++) br.readLine();
                while ((linea = br.readLine()) != null && indice < 9) {
                    String[] aux = linea.split(": ");
                    if (aux.length > 1 && !linea.startsWith("Clase")) {
                        String valor_atributo = aux[1].replace(".", "");
                        atributos[indice] = valor_atributo;
                        indice++;
                    }
                }
                Cazador.CompanieroAnimal compa = cazador.getCompanieroAnimal();
                compa.setNombre(atributos[0]);
                compa.setRaza(atributos[1]);
                compa.setNivel(Integer.parseInt(atributos[2]));
                compa.setPuntos_vida(Integer.parseInt(atributos[3]));
                compa.setPuntos_ataque(Integer.parseInt(atributos[4]));
                compa.setPuntos_velocidad(Integer.parseInt(atributos[5]));
                compa.setPuntos_armadura(Integer.parseInt(atributos[6]));
                compa.setResistencia_magica(Integer.parseInt(atributos[7]));
                if (atributos[8].contains("vivo")) compa.setEstado(true);
                else if (atributos[8].contains("muerto")) compa.setEstado(false);
                br.close();
                fr.close();
            }
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
}