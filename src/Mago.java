import java.util.Random;

public class Mago extends Personaje{
    private double puntos_magia;

    public Mago() {
        super();
        setPuntos_magia(10);
    }

    public Mago(String nombre, String raza) {
        super(nombre, raza);
        setPuntos_magia(10);
    }

    public double getPuntos_magia() {
        return puntos_magia;
    }

    public void setPuntos_magia(double puntos_magia) {
        this.puntos_magia = puntos_magia;
    }

    public double luchar(int hechizo){
        if(hechizo == 1)
            return this.puntos_magia * 0.7;
        else if(hechizo == 3)
            return this.puntos_magia * 0.3;
        return -1;
    }
    
    public void subirNivel(){
        setNivel(getNivel() +1);

        Random random = new Random();
        if(random.nextDouble() < 0.15){
            setPuntos_ataque(getPuntos_ataque() + (getNivel()/4));
        }
        if(random.nextDouble() < 0.35){
            setPuntos_armadura(getPuntos_armadura() + getNivel()/4);
        }
        if(random.nextDouble() < 0.65){
            setPuntos_velocidad(getPuntos_velocidad() + getNivel());
        }
        if(random.nextDouble() < 0.35){
            setPuntos_vida((getPuntos_vida() + (getPuntos_vida() * 0.5)));
        }
        if(random.nextDouble() < 0.8){
            setResistencia_magica(getResistencia_magica() + getNivel());
        }
        if(random.nextDouble() < 0.9){
            setPuntos_magia(getPuntos_magia() + getNivel());
        }
    }

    public void lanzarConjuro(int tipoHechizo, String objetivo){
        switch (tipoHechizo){
            case 1:
                System.out.println("¡Katon: Gōkakyū no Jutsu!");
                luchar(1);
                break;

            case 2:
                System.out.println("¡Doton: Banri Doryūheki!");
                apoyar(2, objetivo);
                break;

            case 3:
                System.out.println("¡Hirudora!");
                luchar(3);
                break;

            case 4:
                System.out.println("¡Hiraishin no Jutsu!");
                apoyar(4,objetivo);
                break;

            default:
                System.out.println("Solo son validos cualquiera de las siguientes opciones: " +
                        "\n1: Lanzar bola de fuego." +
                        "\n2: Proteger a un aliado." +
                        "\n3: Lanzar un fuerte viento." +
                        "\n4: Agiliza reacciones de un aliado.");
        }
    }

    public void apoyar(int hechizo, String objetivo){
        if(hechizo == 2){
            setPuntos_armadura(getPuntos_magia()*0.5);
            setResistencia_magica(getPuntos_magia()*0.5);
        }
        if(hechizo == 4){
            setPuntos_velocidad(getPuntos_magia()*2);
        }
    }

    public String toString(){
        return super.toString()
                + "\nPuntos de magia: " + getPuntos_magia();
    }
}