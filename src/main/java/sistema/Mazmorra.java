package main.java.sistema;

import main.java.personajes.monstruos.Monstruo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Mazmorra {
    private String nombre;
    private ArrayList<Monstruo> monstruos;
    private int nivelPromedio;

    public Mazmorra() {
        this.nombre = "";
        this.monstruos = new ArrayList<>();
        this.nivelPromedio = -1;
    }

    public Mazmorra(String rutaArchivo) {
        this.monstruos = new ArrayList<>();
        inicializarDesdeFichero(rutaArchivo);
    }

    public Mazmorra(Mazmorra copia) {
        setNombre(copia.getNombre());
        this.monstruos = new ArrayList<>();
        setMonstruos(copia.getMonstruos());
        setNivelPromedio(copia.getNivelPromedio());
    }

    private void inicializarDesdeFichero(String rutaArchivo){
        try {
            File archivo = new File(rutaArchivo);
            if (archivo.canRead()){
                FileReader fr = new FileReader(archivo);
                BufferedReader br = new BufferedReader(fr);
                String linea;
                String primeraLinea = br.readLine();
                String[] aux = primeraLinea.split(",");
                this.nombre = aux[0].trim();
                this.nivelPromedio = Integer.parseInt(aux[1].trim());
                while((linea = br.readLine()) != null){
                    if(!linea.contains(aux[1])){
                        Monstruo monstruo = crearMonstruoDesdeLinea(linea);
                        if (monstruo != null) {
                            this.monstruos.add(subirNivelPromedio(monstruo));
                        }
                    }
                }
            }
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    public Monstruo subirNivelPromedio(Monstruo monstruo){
        Random rand = new Random();
        int numeroAleatorio = this.nivelPromedio - 3 + rand.nextInt(2 * 3 + 1);
        for(int i = 0; i <= numeroAleatorio; i++){
            monstruo.subirNivel();
        }
        return monstruo;
    }

    private Monstruo crearMonstruoDesdeLinea(String linea) {
        String[] partes = linea.split(",");
        String raza = "";
        String nombre = "";
        if (partes.length < 2) {
            System.out.println("Error: Formato incorrecto para el monstruo: " + linea);
        }else {
            raza = partes[0].trim();
            nombre = partes[1].trim();
        }
        return new Monstruo(nombre, raza);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Monstruo> getMonstruos() {
        return this.monstruos;
    }

    public void setMonstruos(ArrayList<Monstruo> monstruos) {
        this.monstruos = new ArrayList<>(monstruos);
    }

    public int getNivelPromedio() {
        return this.nivelPromedio;
    }

    public void setNivelPromedio(int nivelPromedio) {
        this.nivelPromedio = nivelPromedio;
    }

    public Monstruo combateAleatorio() {
        Random random = new Random();
        int indiceAleatorio = random.nextInt(monstruos.size());

        return this.monstruos.get(indiceAleatorio);
    }

    public String toString(){
        return "Nombre: " + this.nombre + "\n"
                + "Nivel Promedio: " + this.nivelPromedio + "\n"
                + "Monstruos: " + this.monstruos.toString();
    }
}
