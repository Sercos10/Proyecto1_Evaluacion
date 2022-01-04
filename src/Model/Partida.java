package Model;

import Model.Personajes.Luchador;
import Model.Personajes.Mago;
import Model.Personajes.Personaje;
import Model.Personajes.Tirador;
import Vista.imprimir;
import Utils.pedir;

import java.util.Arrays;

public class Partida {
    private Personaje[] personajes;


    public Partida(int n) {
        this.personajes = new Personaje[n];
    }

    public Personaje[] getPersonajes() {
        return personajes;
    }

    public void addPersonaje(Personaje p1) {
        for (int i = 0; i < personajes.length; i++) {
            if (personajes[i] == null) {
                personajes[i] = p1;
                i = personajes.length;
            }
        }
    }

    public void lucha(Personaje p1, Personaje p2) {

        int dano_realizado = -1;
        double random =10+ Math.random() * p1.getAtaque();
        int dano= (int) random;
        boolean realizado=false;

        if (p2.getVida() >= 0) {
            do {
                if (p1.getClass() == Luchador.class || p1.getClass() == Tirador.class) {
                    imprimir.atacar();
                    int n = pedir.escogeAtaque("Introduce el numero del ataque que quieres realizar");
                    if (n == 1) {
                        realizado=true;
                        dano_realizado = dano - p2.getArmadura();
                        if (dano_realizado > 0) {
                            p2.setVida(p2.getVida() - dano_realizado);
                            imprimir.realizado(dano_realizado,p2);
                        }
                    } else if (n == 2) {
                        realizado=true;
                        Habilidad habilidad;
                        p1.muestraHabilidades();
                            n = pedir.escogeHabilidad("Introduce el numero de la habilidad que quieres realizar");
                            habilidad = p1.utilizaHabilidad(n - 1, p1.getMana());
                            double a = 10+ Math.random() * habilidad.getAtaqueExt();
                            int hab= (int) a;
                            dano_realizado = (dano+hab) - p2.getArmadura();
                            if (dano_realizado > 0) {
                                p2.setVida(p2.getVida() - dano_realizado);
                                imprimir.realizado_mana(dano_realizado,p2,p1.getMana());
                                p1.resetStats(p1);
                            }


                    }else{
                        System.out.println("Has introducido una opción no valida, escoge una opcion correcta");
                        realizado=false;
                    }


                } else if (p1.getClass() == Mago.class) {
                    imprimir.atacar();
                    int n = pedir.escogeAtaque("Introduce el numero del ataque que quieres realizar");
                    if (n == 1) {
                        double a =10+ Math.random() * p1.getPoderhab();
                        int dano2= (int) a;
                        realizado=true;
                        dano_realizado = dano2 - p2.getResmag();
                        if (dano_realizado > 0) {
                            p2.setVida(p2.getVida() - dano_realizado);
                            imprimir.realizado(dano_realizado,p2);
                        }
                    } else if (n == 2) {
                        realizado=true;
                        Habilidad habilidad;
                        p1.muestraHabilidades();
                            n = pedir.escogeHabilidad("Introduce el numero de la habilidad que quieres realizar");
                            habilidad = p1.utilizaHabilidad(n - 1, p1.getMana());
                        double a =10+ Math.random() * p1.getPoderhab();
                        int dano2= (int) a;
                        double b = 10+ Math.random() * habilidad.getPoderhabExt();
                        int hab= (int) b;
                        dano_realizado = (dano2+hab) - p2.getResmag();//pongo el +10 de resistencia magica cuando ataca el mago porque como el mago tiene mucho mana y tiene ventaja, entonces voy a sumar siempre 10 puntos de resmag
                            if (dano_realizado > 0) {
                                p2.setVida(p2.getVida() - dano_realizado);
                                imprimir.realizado_mana(dano_realizado,p2,p1.getMana());
                                p1.resetStats(p1);
                            }
                    }else{
                        System.out.println("Has introducido una opción no valida, escoge una opcion correcta");
                        realizado=false;
                    }
                }
            }while(!realizado);
        }
    }

    public void luchaCPU(Personaje p1, Personaje p2) {
        int dano_realizado = -1;
        double a =1 + Math.random() * 2;
        int n_al1= (int) a;
        if (p2.getVida() >= 0) {
            if (p1.getClass() == Luchador.class || p1.getClass() == Tirador.class) {
                if (n_al1 == 1) {
                    dano_realizado = p1.getAtaque() - p2.getArmadura();
                    if (dano_realizado > 0) {
                        p2.setVida(p2.getVida() - dano_realizado);
                        imprimir.realizadoCPU(dano_realizado,p2);
                    }
                } else if (n_al1 == 2) {
                    Habilidad habilidad;
                    a =1 + Math.random() * 2;
                    n_al1= (int) a;
                    habilidad = p1.utilizaHabilidad(n_al1 - 1, p1.getMana());
                    p1.sumarStats(habilidad);
                    dano_realizado = p1.getAtaque() - p2.getArmadura();
                    if (dano_realizado > 0) {
                        p2.setVida(p2.getVida() - dano_realizado);
                        imprimir.habilidadCPU(habilidad,p1);
                        imprimir.realizado_manaCPU(dano_realizado,p1,p1.getMana());
                        p1.resetStats(p1);
                    }
                }


            } else if (p1.getClass() == Mago.class) {
                a =1 + Math.random() * 2;
                n_al1= (int) a;
                if (n_al1 == 1) {
                    dano_realizado = p1.getPoderhab() - p2.getResmag();
                    if (dano_realizado > 0) {
                        p2.setVida(p2.getVida() - dano_realizado);
                        imprimir.realizadoCPU(dano_realizado,p2);
                    }
                } else if (n_al1 == 2) {
                    Habilidad habilidad;
                    a =1 + Math.random() * 2;
                    n_al1= (int) a;
                    habilidad = p1.utilizaHabilidad(n_al1 - 1, p1.getMana());
                    p1.sumarStats(habilidad);
                    dano_realizado = p1.getPoderhab() - (p2.getResmag() + 10);//pongo el +10 de resistencia magica cuando ataca el mago porque como el mago tiene mucho mana y tiene ventaja, entonces voy a sumar siempre 10 puntos de resmag
                    if (dano_realizado > 0) {
                        p2.setVida(p2.getVida() - dano_realizado);
                        imprimir.habilidadCPU(habilidad,p1);
                        imprimir.realizado_manaCPU(dano_realizado,p1,p1.getMana());
                        p1.resetStats(p1);
                    }
                }
            }
        }
    }

    public Personaje escogePersonaje(Personaje[] personajes, String nombre){
        boolean escogido=false;
        do {

            for (int i = 0; i < personajes.length; i++) {
                if (personajes[i].getNombre().equals(nombre)){
                    escogido=true;
                    return personajes[i];
                }
            }
            if (escogido==false){
                nombre=pedir.leeRespuesta("Introduce bien el nombre del personaje");
            }
        }while(!escogido);

        return null;
    }

    public void eliminaSeleccionado(Personaje[] personajes, Personaje seleccionado){
        for (int i = 0; i < personajes.length; i++) {
            if (seleccionado==personajes[i])
                personajes[i]=null;
        }
    }

    public void restaurarVidMana(Personaje p1){
        double a = Math.random() * 101;
        double b = Math.random() * 101;
        int resvida= (int) a;
        int resmana=(int) b;
        p1.setVida(p1.getVida()+resvida);
        p1.setMana(p1.getMana()+resmana);
        imprimir.restaurar(p1,resmana,resvida);
    }

    @Override
    public String toString() {
        return "personajes=" + Arrays.toString(personajes);
    }
}
