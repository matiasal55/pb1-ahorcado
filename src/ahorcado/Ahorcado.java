package ahorcado;

public class Ahorcado {
    private boolean juegoTerminado;

    public Ahorcado() {
        this.juegoTerminado=false;
    }

    public int comienza(){
        int min=1;
        int max=2;
        int random=(int) (Math.random() * (max - min + 1)) + min;
        return random;
    }

    public boolean adivinar(Jugador jugador, char letra){
        int adivinado=0;
        String palabra=jugador.getPalabraAAdivinar();
        char [] adivinanza=jugador.getAdivinanza();
        for(int i=0;i<palabra.length();i++){
            if(palabra.charAt(i)==letra) {
                adivinanza[i]= letra;
                adivinado++;
            }
        }
        if(adivinado>0) {
            jugador.setAdivinanza(adivinanza);
            if(String.valueOf(adivinanza).equals(palabra))
                this.juegoTerminado=true;
            return true;
        }
        else{
            jugador.setVidas();
            if(jugador.getVidas()==0)
                this.juegoTerminado=true;
            return false;
        }
    }

    public boolean arriesgar(Jugador jugador,String palabra){
        String palabraReal=jugador.getPalabraAAdivinar();
        this.juegoTerminado=true;
        if(palabraReal.equals(palabra)) {
            return true;
        }
        else {
            jugador.vidasCero();
            return false;
        }
    }

    public boolean isJuegoTerminado() {
        return juegoTerminado;
    }
}
