import java.util.Random;

public abstract class Personaje {
    private String nombre;
    private String raza;
    private double nivel;
    private double puntos_vida;
    private double puntos_ataque;
    private double puntos_velocidad;
    private double puntos_armadura;
    private double resistencia_magica;
    private boolean estado;

    public Personaje(){
        this.nombre="";
        this.raza="";
        this.nivel=1;
        this.puntos_vida=100;
        this.puntos_ataque=10;
        this.puntos_velocidad=10;
        this.puntos_armadura=10;
        this.resistencia_magica=10;
        this.estado=true;
    }

    public Personaje(String nombre, String raza){
        setNombre(nombre);
        razaElegida(raza);
        this.nivel=1;
        this.puntos_vida=100;
        this.puntos_ataque=10;
        this.puntos_velocidad=10;
        this.puntos_armadura=10;
        this.resistencia_magica=10;
        this.estado=true;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRaza() {
        return raza;
    }

    public double getNivel() {
        return nivel;
    }

    public double getPuntos_vida() {
        return puntos_vida;
    }

    public double getPuntos_ataque() {
        return puntos_ataque;
    }

    public double getPuntos_velocidad() {
        return puntos_velocidad;
    }

    public double getPuntos_armadura() {
        return puntos_armadura;
    }

    public double getResistencia_magica() {
        return resistencia_magica;
    }

    public boolean isEstado() {
        if (this.estado == false){
            return false;
        }
        return true;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setNivel(double nivel) {
        this.nivel = nivel;
    }

    public void setPuntos_vida(double puntos_vida) {
        this.puntos_vida = puntos_vida;
    }

    public void setPuntos_ataque(double puntos_ataque) {
        this.puntos_ataque = puntos_ataque;
    }

    public void setPuntos_velocidad(double puntos_velocidad) {
        this.puntos_velocidad = puntos_velocidad;
    }

    public void setResistencia_magica(double resistencia_magica) {
        this.resistencia_magica = resistencia_magica;
    }

    public void setPuntos_armadura(double puntos_armadura) {
        this.puntos_armadura = puntos_armadura;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setNombre(String nombre){
        if(nombre.length() < 4){
            System.err.println("El nombre no puede contener menos de 4 caracteres.");
            this.nombre = "";
        } else if(nombre.contains(" ")){
            this.nombre = nombre.replace(" ", "");;
        } else{
            this.nombre = nombre;
        }
    }

    public void razaElegida(String raza){
        if(raza.equals("angel") || raza.equals("demonio")){
            System.out.println("La raza del personaje no puede ser ángel ni demonio, asegurese de elegir otra raza.");
            this.raza="";
        } else{
            this.raza=raza;
        }
    }

    public void subirNivel(){
        this.nivel++;
        this.puntos_vida += this.puntos_vida * 1.1;
        Random random = new Random();
        if(random.nextDouble() > 0.5) {
            this.puntos_ataque += this.nivel;
        }
        if(random.nextDouble() > 0.5){
            this.resistencia_magica += this.nivel;
        }
        if(random.nextDouble() > 0.5){
            this.puntos_armadura += this.nivel;
        }
        if(random.nextDouble() > 0.5){
            this.puntos_velocidad += this.nivel;
        }
    }

    public double luchar(){
        return getPuntos_ataque();
    }

    public void defender(int tipoDefensa, String personaje) {
        switch (tipoDefensa) {
            case 1:
                this.puntos_vida -= (this.puntos_armadura - tipoDefensa);
                break;

            case 2:
                this.puntos_vida -= (this.resistencia_magica - tipoDefensa);
                break;

            default:
                System.out.println("Asegure de elegir entre los siguientes tipos de ataque: \n-fisico \n-magico");
                break;
        }
    }

    public String toString(){
        return "A continuacion se muestra un resumen del personaje actual."
                + "\nNombre: " + getNombre()
                + "\nRaza: " + getRaza()
                + "\nNivel: " + getNivel()
                + "\nPuntos de vida: " + getPuntos_vida()
                + "\nPuntos de ataque: " + getPuntos_ataque()
                + "\nPuntos de armadura: " + getPuntos_armadura()
                + "\nPuntos de velocidad: " + getPuntos_velocidad()
                + "\nResistencia magica: " + getResistencia_magica();
    }
}
