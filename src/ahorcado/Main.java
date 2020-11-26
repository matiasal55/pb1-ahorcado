package ahorcado;

import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        Scanner teclado=new Scanner(System.in);
        String nombre1;
        String nombre2;
        String palabra1;
        String palabra2;

        System.out.println("Bievenido al Ahorcado");
        System.out.println("Ingrese el nombre del jugador 1:");
        nombre1=teclado.next();
        System.out.println("Ingrese el nombre del jugador 2:");
        nombre2=teclado.next();
        System.out.println(nombre1+": Ingrese la palabra que el "+nombre2+" deberá adivinar");
        palabra1=teclado.next();
        System.out.println(nombre2+": Ingrese la palabra que el "+nombre1+" deberá adivinar");
        palabra2=teclado.next();
        Jugador jugador1=new Jugador(nombre1,palabra2);
        Jugador jugador2=new Jugador(nombre2,palabra1);
        Ahorcado nuevo=new Ahorcado();
        Jugador comienza;
        Jugador sigue;
        if(nuevo.comienza()==1) {
            comienza = jugador1;
            sigue=jugador2;
        }
        else {
            comienza = jugador2;
            sigue=jugador1;
        }
        System.out.println("Comienza: "+comienza.getNombre());
        int vidasJugador=comienza.getVidas();

        while(vidasJugador>0 && !nuevo.isJuegoTerminado()){
            int opcion;
            System.out.println(comienza.getNombre()+", ingrese la opción deseada: ");
            System.out.println("1 - Ingresar Letra");
            System.out.println("2 - Arriesgar");
            opcion=teclado.nextInt();
            if(opcion==1){
                System.out.println("Ingrese la letra que crea que es la correcta");
                System.out.println(comienza.getAdivinanza());
                String letra=teclado.next();
                if(nuevo.adivinar(comienza,letra.charAt(0))){
                    System.out.println("La letra elegida es correcta: "+String.valueOf(comienza.getAdivinanza()));
                    if(nuevo.isJuegoTerminado()){
                        System.out.println("Ganador/a: "+comienza.getNombre());
                    }
                }
                else {
                    System.out.println("La letra no se encuentra dentro de la palabra. Le quedan: "+comienza.getVidas()+" vidas.");
                    if(nuevo.isJuegoTerminado()){
                        System.out.println("Ganador/a: "+sigue.getNombre());
                    }
                }
            }
            else {
                System.out.println("Ingrese la palabra que crea que es la correcta");
                String palabra= teclado.next();
                if(nuevo.arriesgar(comienza,palabra)){
                    System.out.println("La palabra es la correcta. Felicitaciones");
                    System.out.println("Respuesta: "+comienza.getPalabraAAdivinar());
                }
                else {
                    System.out.println("La palabra es incorrecta. Perdiste");
                    System.out.println("Respuesta: "+comienza.getPalabraAAdivinar());
                    System.out.println("Ganador/a: "+sigue.getNombre());
                }
            }
            Jugador aux=comienza;
            comienza=sigue;
            sigue=aux;
            vidasJugador=comienza.getVidas();
        }
        
    }
}
