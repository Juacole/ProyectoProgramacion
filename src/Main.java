public class Main {
    public static void main(String[] args) {

        final String ruta = "C:\\Users\\Hp\\Desktop\\DAM\\PROGRAMACION\\PRACTICAS\\PRACTICA-TEMA5-6\\Ficheros\\";
        final String path1 = "C:\\Users\\Hp\\Desktop\\DAM\\PROGRAMACION\\PRACTICAS\\PRACTICA-TEMA5-6\\Ficheros\\Anakin.txt";
        final String path2 = "C:\\Users\\Hp\\Desktop\\DAM\\PROGRAMACION\\PRACTICAS\\PRACTICA-TEMA5-6\\Ficheros\\Aldebaran.txt";
        final String path3 = "C:\\Users\\Hp\\Desktop\\DAM\\PROGRAMACION\\PRACTICAS\\PRACTICA-TEMA5-6\\Ficheros\\Benito.txt";
        final String path4 = "C:\\Users\\Hp\\Desktop\\DAM\\PROGRAMACION\\PRACTICAS\\PRACTICA-TEMA5-6\\Ficheros\\Cristorata.txt";
        final String path5 = "C:\\Users\\Hp\\Desktop\\DAM\\PROGRAMACION\\PRACTICAS\\PRACTICA-TEMA5-6\\Ficheros\\Jaina.txt";

        Guerrero guerrero = new Guerrero("Manolo", "Tauren");
        Mago mago = new Mago("Jaina", "Humano");
        Cazador cazador = new Cazador("Juanceto", "Orco", "Ricardito", "rapaz");
        Paladin paladin = new Paladin("Pedro", "Venezolano");
        Ladron ladron = new Ladron("Cristorata", "Chileno");
        Monstruo monstruo = new Monstruo("Benito", "Bestia");
        Clerigo clerigo = new Clerigo("Juanito", "Goblin");

        for(int i = 0; i < 10; i++){
            clerigo.subirNivel();
            monstruo.subirNivel();
        }

        System.out.println("El nivel del " + clerigo.getClass().getSimpleName() + " es: " + clerigo.getNivel());
        System.out.println("El nivel del " + monstruo.getClass().getSimpleName() + " es: " + monstruo.getNivel());

        //System.out.println(guerrero.toString() + "\n\n");

        Personaje[] vengadores = {guerrero,mago,cazador,paladin,ladron,monstruo,clerigo};
        String[] paths = {path1,path2,path3,path4,path5};

        //Combate.iniciarCombate(guerrero,cazador);

        //GameLogger.party(vengadores, ruta + "Avengers.txt");

        //GameLogger.estadoPersonaje(guerrero,ruta + "Anakin.txt");

        //GameLogger.existePersonaje(paths, ladron.getNombre());

        //GameLogger.numClases(paths, clerigo.getClass().getSimpleName());

        //GameLogger.registroCombate(ruta, clerigo, monstruo);

        //GameLogger.ganadorCombate(vengadores, ruta + "Juanito vs Benito" + ".txt");

        System.out.println("\nEl nivel del " + clerigo.getClass().getSimpleName() + " es: " + clerigo.getNivel());
        System.out.println("El nivel del " + monstruo.getClass().getSimpleName() + " es: " + monstruo.getNivel());
    }
}