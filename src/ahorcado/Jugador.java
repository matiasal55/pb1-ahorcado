package ahorcado;

public class Jugador {
    private String nombre;
    private String palabraAAdivinar;
    private char [] adivinanza;
    private int vidas;

    public Jugador(String nombre, String palabraAAdivinar) {
        this.nombre = nombre;
        this.palabraAAdivinar = palabraAAdivinar;
        adivinanza=new char[palabraAAdivinar.length()];
        this.vidas =6;
        for(int i=0;i<this.palabraAAdivinar.length();i++)
            this.adivinanza[i]='_';
    }

    public String getNombre() {
        return nombre;
    }

    public String getPalabraAAdivinar() {
        return palabraAAdivinar;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas() {
        this.vidas--;
    }

    public void vidasCero(){
        this.vidas =0;
    }

    public char[] getAdivinanza() {
        return adivinanza;
    }

    public void setAdivinanza(char[] adivinanza) {
        this.adivinanza = adivinanza;
    }
}
