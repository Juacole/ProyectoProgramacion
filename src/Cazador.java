import java.util.Random;

public class Cazador extends Personaje{

    Mascota mascota;

    public Cazador(){
        super();
        this.mascota = new Mascota("canido");
        mascota.setRaza();
    }

    public Cazador(String nombre, String raza, String razaAnimal){
        super(nombre,raza);
        this.mascota = new Mascota(razaAnimal);
    }

    public void subirNivel(){
        setNivel(getNivel() +1);
        setPuntos_vida(getPuntos_vida()*1.1);

        Random random = new Random();
        if(random.nextDouble() <= 0.5){
            setPuntos_ataque(getPuntos_ataque() + getNivel());
        }
        if(random.nextDouble() <= 0.5){
            setPuntos_armadura(getPuntos_armadura() + getNivel());
        }
        if(random.nextDouble() <= 0.7){
            setPuntos_velocidad(getPuntos_velocidad() + getNivel());
        }
        if(random.nextDouble() <= 0.5){
            setResistencia_magica(getResistencia_magica() + getNivel());
        }
        mascota.setRaza();
    }

    public double luchar(){
        return getPuntos_ataque() + mascota.getPuntos_ataque();
    }

    public String toString(){
        return super.toString() + mascota.toString();
    }

    public class Mascota extends Personaje{

        public Mascota(){
            super();
        }

        public Mascota(String raza){
            super("Compañero animal", raza);
        }

        public void setRaza(){
             switch (getRaza().toLowerCase()){
                 case "canido":
                     Canido();
                     break;

                 case "felino":
                     Felino();
                     break;

                 case "rapaz":
                     Rapaz();
                     break;

                 default:
                     System.err.println("Tu compañero animal solo puede ser uno de los siguientes tipos: " +
                             "\n-canido" +
                             "\n-felino" +
                             "\n-rapaz" +
                             "\nSe le asiganara por defecto la raza de canido a tu compañero animal.");
                     Canido();
             }
        }

        private void Canido(){
             setNivel(getNivel()+1);
             setPuntos_vida(Cazador.this.getPuntos_vida()*1.1);
             setPuntos_ataque(Cazador.this.getPuntos_ataque()*0.2);
             setPuntos_armadura(Cazador.this.getPuntos_armadura()*0.2);
             setPuntos_velocidad(Cazador.this.getPuntos_velocidad()*0.2);
             setResistencia_magica(Cazador.this.getResistencia_magica()*0.2);
        }

        private void Felino(){
            setNivel(getNivel()+1);
            setPuntos_vida(Cazador.this.getPuntos_vida()*1.1);
            setPuntos_ataque(Cazador.this.getPuntos_ataque()*0.3);
            setPuntos_armadura(Cazador.this.getPuntos_armadura()*0.15);
            setPuntos_velocidad(Cazador.this.getPuntos_velocidad()*0.3);
            setResistencia_magica(Cazador.this.getResistencia_magica()*0.15);
        }

        private void Rapaz(){
            setNivel(getNivel()+1);
            setPuntos_vida(Cazador.this.getPuntos_vida()*0.5);
            setPuntos_ataque(Cazador.this.getPuntos_ataque()*0.15);
            setPuntos_armadura(Cazador.this.getPuntos_armadura()*0.5);
            setPuntos_velocidad(Cazador.this.getPuntos_velocidad()*0.35);
            setResistencia_magica(Cazador.this.getResistencia_magica()*0.25);
        }

        public String toString(){
            return super.toString() + "\nLa raza del compañero animal es: " + getRaza();
        }
    }
}
