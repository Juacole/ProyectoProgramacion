public class Main {
    public static void main(String[] args) {
        Guerrero guerrero = new Guerrero("Thrall", "Orco");
        Mago mago = new Mago("Jaina", "Humano");
        Cazador cazador = new Cazador("Cazador","Orco","rapaz");
        /*for(int i = 0; i < 2; i++){
            guerrero.subirNivel();
        }
        for(int i = 0; i < 10; i++){
            mago.subirNivel();
        }*/
        //Combate.iniciarCombate(guerrero,mago);
        //System.out.println(cazador.toString());
        System.out.println(guerrero.toString());
    }
}