//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Guerrero guerrero = new Guerrero("Thrall", "Orco");
        Mago mago = new Mago("Jaina", "Humano");

        for (int i=0; i<15; i++){
            mago.subirNivel();
        }
        for(int i=0; i<5; i++){
            guerrero.subirNivel();
        }
        Combate.iniciarCombate(guerrero,mago);
    }
}