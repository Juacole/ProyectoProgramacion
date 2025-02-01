import java.util.Random;

public class Guerrero extends Personaje{
    private boolean furia;

    public Guerrero(){
        super();
        this.furia = false;
    }

    public Guerrero(String nombre, String raza) {
        super(nombre, raza);
        this.furia = false;
    }

    public boolean getFuria() {
        return furia;
    }

    public void setFuria(boolean furia) {
        this.furia = furia;
    }

    public void subirNivel(){
        this.setNivel(getNivel() +1);
        Random random = new Random();

        if(random.nextDouble() < 0.8){
            this.setPuntos_ataque(getPuntos_ataque() + (getNivel()*2));
        }
        if(random.nextDouble() < 0.75){
            this.setPuntos_armadura(getPuntos_armadura() + getNivel());
        }
        if(random.nextDouble() < 0.5){
            this.setPuntos_velocidad(getPuntos_velocidad() + getNivel());
        }
        if(random.nextDouble() < 0.75){
            this.setPuntos_vida((int) (getPuntos_vida() + (getPuntos_vida() * 1.1)));
        }
        if(random.nextDouble() < 0.5){
            this.setResistencia_magica(getResistencia_magica() + getNivel());
        }
    }

    public double Luchar(){
        if(!this.furia){
            return getPuntos_ataque() *2;
        }
        return getPuntos_ataque();
    }

    public void defender(int tipoAtaque, String objetivo){
        switch (tipoAtaque){
            case 1:
                if(furia == true){
                    setPuntos_vida(getPuntos_vida() - (getPuntos_armadura() - luchar()));
                } else{
                    setPuntos_vida(getPuntos_vida() - (getPuntos_armadura() - luchar()));
                }
                break;
            case 2:
                if(furia == true){
                    setResistencia_magica(getPuntos_vida() - (getResistencia_magica() - luchar()));
                } else{
                    setResistencia_magica(getPuntos_vida() - (getResistencia_magica() - luchar()));
                }
                break;
            default:
                System.out.println("Asegure de elegir entre los siguientes tipos de ataque: \n- 1 para el daño fisico. \n- 2 para el dano magino.");
                break;
        }
    }

    public String toString() {
        return super.toString() + "\nEstado de la furia: " + getFuria();
    }
}
