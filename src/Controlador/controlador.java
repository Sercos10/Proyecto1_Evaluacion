package Controlador;

import Model.*;
import Model.Personajes.Luchador;
import Model.Personajes.Mago;
import Model.Personajes.Personaje;
import Model.Personajes.Tirador;
import Utils.pedir;
import Vista.imprimir;

public class controlador {
    public static void iniciarPartida(){
        boolean terminado=false;
        int contador=0;
        String escoger="";
        Partida p1=new Partida(4);
        Habilidad h1=new Habilidad("Juicio Final",45,50,0,0,0);
        Habilidad h2=new Habilidad("Justicia Demaciana",150,80,0,0,0);
        Habilidad h3=new Habilidad("Persistencia Ancestral",30,0,0,50,50);
        Habilidad h4=new Habilidad("Explosion Astral",45,0,60,0,0);
        Habilidad h5=new Habilidad("Agarre Infernal",150,0,90,0,0);
        Habilidad h6=new Habilidad("Pulso Arcano",30,0,40,0,0);
        Habilidad h7=new Habilidad("Gatillo Infernal",45,50,0,0,0);
        Habilidad h8=new Habilidad("As bajo la mira",150,90,0,0,0);
        Habilidad h9=new Habilidad("LLuvia de plomo",30,30,0,0,0);
        Habilidad h10=new Habilidad("Cataclismo",45,50,0,0,0);
        Habilidad h11=new Habilidad("Furia del Dragon",150,80,0,0,0);
        Habilidad h12=new Habilidad("Ruptura volcanica",30,30,0,0,0);
        Habilidad[] luchador1= new Habilidad[3];
        Habilidad[] luchador2= new Habilidad[3];
        Habilidad[] mago= new Habilidad[3];
        Habilidad[] tirador= new Habilidad[3];
        luchador1[0]=h1;
        luchador1[1]=h2;
        luchador1[2]=h3;
        luchador2[0]=h10;
        luchador2[1]=h11;
        luchador2[2]=h12;
        mago[0]=h4;
        mago[1]=h5;
        mago[2]=h6;
        tirador[0]=h7;
        tirador[1]=h8;
        tirador[2]=h9;
        Luchador l1=new Luchador("Garen",350,20, 20,45,0,450,luchador1,250,20, 20,25);
        Luchador l2= new Luchador("Ornn",400,25,25,40,0,500,luchador2,250,25,25,20);
        Mago m1= new Mago("Xerath",320,20, 20,0,55,750,mago,100,5, 5,20);
        Tirador t1= new Tirador("Jinx",320,20,20,60,0,650,tirador,80,0,0,35);
        l1.sumarStats();
        l2.sumarStats();
        m1.sumarStats();
        t1.sumarStats();
        p1.addPersonaje(l1);
        p1.addPersonaje(m1);
        p1.addPersonaje(t1);
        p1.addPersonaje(l2);
        Personaje[] personajes=p1.getPersonajes();
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        System.out.println("                                                PERSONAJES                                                              ");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        imprimir.muestraLuchadores(personajes);
        escoger=pedir.leeRespuesta("Introduce el nombre del personaje que quieras escoger (Es sensible a mayusculas)");
        Personaje seleccionado= new Personaje();
        seleccionado=p1.escogePersonaje(personajes,escoger);
        p1.eliminaSeleccionado(personajes,seleccionado);
        for (;!terminado;){
            double a = Math.random() * 4;
            int n_al1= (int) a;

            if (seleccionado!=null&&personajes[n_al1]!=null){
                imprimir.luchasContra(personajes[n_al1]);
                p1.lucha(seleccionado,personajes[n_al1]);
                if (personajes[n_al1].getVida()>0){
                    imprimir.luchasContra(seleccionado);
                    p1.luchaCPU(personajes[n_al1],seleccionado);
                }

                p1.restaurarVidMana(seleccionado);
                System.out.println();
                imprimir.muestraPersonaje(seleccionado);
                System.out.println();
                imprimir.muestraPersonaje(personajes[n_al1]);
                System.out.println();

                if (seleccionado.getVida()<=0){
                    imprimir.selecMuerto();
                    imprimir.muestraLuchadores(personajes);
                    seleccionado=p1.escogePersonaje(personajes,escoger=pedir.leeRespuesta("Introduce el nombre del persona que quieras escoger (Es sensible a mayusculas)"));
                    p1.eliminaSeleccionado(personajes,seleccionado);
                    contador++;
                }
                if (personajes[n_al1].getVida()<=0){
                    personajes[n_al1]=null;
                    contador++;
                }
            }
            if (contador==3){
                terminado=true;
                imprimir.ganador(seleccionado);
            }
        }
    }
}
