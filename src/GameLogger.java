import java.io.*;

public class GameLogger {

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

    public static void party(Personaje[] lista, String path){
        for(int i = 0; i < lista.length -1; i++){
            for(int j = 0; j < lista.length -i -1; j++){
                if(lista[j].getPuntos_velocidad() < lista[j+1].getPuntos_velocidad()){
                    Personaje aux = lista[j];
                    lista[j] = lista[j+1];
                    lista[j+1] = aux;
                }else if(lista[j].getPuntos_velocidad() == lista[j+1].getPuntos_velocidad()){
                    ordenarAlfabeticamente(lista, j);
                }
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
        if(!noEncontrado){
            System.out.println(nombrePersonaje + " no existe en los registros del juego.");
        }
    }

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
            if(contador > 0){
                System.out.println("La clase " + nombreClass + " aparece " + contador + " veces en los archivos del juego.");
            }else {
                System.out.println("La clase " + nombreClass + " no aparece en los registros del juego.");
            }
        }catch (IOException ioe){
            throw new RuntimeException(ioe);
        }
    }

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

    public static void ganadorCombate(Personaje[] personajes, String path){
        try {
            for (int i = 0; i < personajes.length; i++) {
                File lectura = new File(path);
                if (lectura.canRead()) {
                    FileReader fr = new FileReader(lectura);
                    BufferedReader br = new BufferedReader(fr);
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        if (linea.startsWith("El ganador es " + personajes[i].getNombre())) {
                           personajes[i].subirNivel();
                        }
                    }
                    br.close();
                    fr.close();
                }
            }

        } catch (IOException ioe){
            throw new RuntimeException(ioe);
        }
    }

    private static void ordenarAlfabeticamente(Personaje[] lista, int indice){
        if(lista[indice].getNombre().compareToIgnoreCase(lista[indice+1].getNombre()) > 0){
            Personaje aux = lista[indice];
            lista[indice] = lista[indice+1];
            lista[indice+1] = aux;
        }
    }

    private static void asignarAtributos(String[] atributos,Personaje pj, String path){
        if(!atributos[0].equals(pj.getNombre()) && atributos[0] != null){
            pj.setNombre(atributos[0]);
        }
        if(atributos[1] != null && atributos[10] != null){
            switch (atributos[1]){
                case "Guerrero":
                    Guerrero  guerrero= (Guerrero) pj;
                    if(atributos[10].equals("Inactiva")){
                        guerrero.setFuria(false);
                    }else if(atributos[10].equals("Activa")){
                        guerrero.setFuria(true);
                    }
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
                    Cazador cazador = new Cazador();
                    Cazador.CompanieroAnimal compa = cazador.new CompanieroAnimal(path);
                    break;
            }
        }
        if(!atributos[2].equals(pj.getRaza()) && atributos[2] != null){
            pj.setRaza(atributos[2]);
        }
        if(Integer.parseInt(atributos[3]) != pj.getNivel() && atributos[3] != null){
            pj.setNivel(Integer.parseInt(atributos[3]));
        }
        if(Integer.parseInt(atributos[4]) != pj.getPuntos_vida() && atributos[4] != null){
            pj.setPuntos_vida(Integer.parseInt(atributos[4]));
        }
        if(Integer.parseInt(atributos[5]) != pj.getPuntos_ataque() && atributos[5] != null){
            pj.setPuntos_ataque(Integer.parseInt(atributos[5]));
        }
        if(Integer.parseInt(atributos[6]) != pj.getPuntos_velocidad() && atributos[6] != null){
            pj.setPuntos_velocidad(Integer.parseInt(atributos[6]));
        }
        if(Integer.parseInt(atributos[7]) != pj.getPuntos_armadura() && atributos[7] != null){
            pj.setPuntos_armadura(Integer.parseInt(atributos[7]));
        }
        if(Integer.parseInt(atributos[8]) != pj.getResistencia_magica() && atributos[8] != null){
            pj.setResistencia_magica(Integer.parseInt(atributos[8]));
        }
        if(atributos[9].equals("vivo")){
            pj.setEstado(true);
        } else if (atributos[9].equals("muerto")) {
            pj.setEstado(false);
        }
    }
}

