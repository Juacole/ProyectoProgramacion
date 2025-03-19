import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class GameLogger {
    private static final String ruta = "C:\\Users\\Hp\\Desktop\\DAM\\PROGRAMACION\\FICHEROS\\";

    public static void fichaPersonaje(Personaje personaje){
        try{
            FileWriter fw = new FileWriter(ruta + personaje.getNombre() + ".txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(personaje.toString());
            bw.close();
            fw.close();
        }catch (IOException ioe){
            throw new RuntimeException(ioe);
        }
    }

    public static void party(Personaje[] lista){
        Arrays.sort(lista, (p1, p2) -> Integer.compare(p1.getPuntos_velocidad(), p2.getPuntos_velocidad()));
        for (Personaje j : lista) {
            System.out.println(j.getNombre() + " " + j.getPuntos_velocidad());
        }

    }


    /*private static void ordenacion(Personaje[] lista) {
        Personaje[] aux = new Personaje[lista.length];
        for (int i = 0; i < lista.length; i++) {
            for (int j = i +1; j < lista.length -i -1; j++) {
                for (int w = 0; w < aux.length; w++){
                    if (lista[j].getPuntos_velocidad() > lista[j+1].getPuntos_velocidad()) {
                        aux[w]=lista[j];
                    }else {
                        aux[w]=lista[j+1];
                    }
                }
            }
        }
        for (Personaje print: aux){
            System.out.println(print.getNombre() + " " + print.getPuntos_velocidad());
        }
    }*/

    public static void main(String[] args) {
        Guerrero guerrero = new Guerrero("Thrall", "Orco");
        Mago mago = new Mago("Jaina", "Humano");
        Cazador cazador = new Cazador("Cazador","Orco","rapaz");
        Paladin paladin = new Paladin("Pedro", "Venezolano");
        Ladron ladron = new Ladron("Cristorata", "Chileno");
        Monstruo monstruo = new Monstruo("Benito", "Bestia");
        for(int i = 0; i < 30; i++){
            guerrero.subirNivel();
            mago.subirNivel();
            cazador.subirNivel();
            paladin.subirNivel();
            ladron.subirNivel();
            monstruo.subirNivel();
        }
        Personaje[] personajes = {mago, guerrero, cazador, paladin, ladron, monstruo};
        //ordenacion(personajes);
        party(personajes);
    }
}
