package Vista;

import Model.Personajes.Personaje;

public class imprimir {

    public static void muestraLuchadores(Personaje[] personajes) {
        for (int i = 0; i < personajes.length; i++) {
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println(personajes[i]);
            System.out.println("----------------------------------------------------------------------------------------");
        }
    }

    public static void luchasContra(Personaje p){
        System.out.println("Luchas contra: "+p.getNombre());
    }

    public static void selecMuerto(){
        System.out.println("Tu personaje a muerto, selecciona otro");
    }

    public static void atacar(){
        System.out.println("Pulsa 1 si quieres atacar con un ataque basico\nPulsa 2 para utilizar alguna habilidad");
    }

    public static void realizado(int dano, Personaje p1){
        System.out.println("Has realizado: "+dano+" daño");
        System.out.println("Ha "+p1.getNombre()+" le queda: "+p1.getVida()+" de vida");
    }

    public static void realizado_mana(int dano, Personaje p1, int mana){
        System.out.println("Has realizado: "+dano+" daño");
        System.out.println("Ha "+p1.getNombre()+" le queda: "+p1.getVida()+" de vida");
        System.out.println("Te queda: " + p1.getMana()+" de mana");
    }

    public static void ganador(Personaje p1){
        System.out.println("-----------------------------------------------------------");
        System.out.println(p1.getNombre()+" ha ganado la batalla a muerte, Felicidades-");
        System.out.println("-----------------------------------------------------------");
    }
}
