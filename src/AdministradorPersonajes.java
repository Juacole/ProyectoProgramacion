import java.util.HashMap;

public class AdministradorPersonajes {
    private HashMap<String, Personaje> personajes = new HashMap<>();

    public void agregarPersonaje(Personaje personaje) {
        personajes.put(personaje.getNombre(), personaje);
    }

    public Personaje buscarPersonaje(String nombre) {
        return personajes.get(nombre);
    }

    public boolean existePersonaje(String nombre){
        return personajes.containsKey(nombre);
    }

    public void mostrarPersonajes() {
        for (String nombre : personajes.keySet()) {
            System.out.println(nombre);
        }
    }
}