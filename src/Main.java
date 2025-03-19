public class Main {
    public static void main(String[] args) {
        Guerrero guerrero = new Guerrero("Thrall", "Orco");
        Mago mago = new Mago("Jaina", "Humano");
        Cazador cazador = new Cazador("Cazador","Orco","rapaz");
        Paladin paladin = new Paladin("Pedro", "Venezolano");
        Ladron ladron = new Ladron("Cristorata", "Chileno");
        Monstruo monstruo = new Monstruo("Benito", "Bestia");
        for(int i = 0; i < 20; i++){
            guerrero.subirNivel();
            mago.subirNivel();
            cazador.subirNivel();
            paladin.subirNivel();
            ladron.subirNivel();
            monstruo.subirNivel();
        }
        Personaje[] personajes = {mago,guerrero,cazador,paladin,ladron,monstruo};
        GameLogger.party(personajes);
    }
}