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
        if (p2.getVida() >= 0) {
            if (p1.getClass() == Luchador.class || p1.getClass() == Tirador.class) {
                imprimir.atacar();
                int n = pedir.leeEntero("Introduce el numero del ataque que quieres realizar");
                if (n == 1) {
                    dano_realizado = p1.getAtaque() - p2.getArmadura();
                    if (dano_realizado > 0) {
                        p2.setVida(p2.getVida() - dano_realizado);
                        imprimir.realizado(dano_realizado,p2);
                    }
                } else if (n == 2) {
                    Habilidad habilidad;
                    p1.muestraHabilidades();
                    n = pedir.leeEntero("Introduce el numero de la habilidad que quieres realizar");
                    habilidad = p1.utilizaHabilidad(n - 1, p1.getMana());
                    p1.sumarStats(habilidad);
                    dano_realizado = p1.getAtaque() - p2.getArmadura();
                    if (dano_realizado > 0) {
                        p2.setVida(p2.getVida() - dano_realizado);
                        imprimir.realizado_mana(dano_realizado,p2,p1.getMana());
                        p1.resetStats(p1);
                    }
                }


            } else if (p1.getClass() == Mago.class) {
                imprimir.atacar();
                int n = pedir.leeEntero("Introduce el numero del ataque que quieres realizar");
                if (n == 1) {
                    dano_realizado = p1.getPoderhab() - p2.getResmag();
                    if (dano_realizado > 0) {
                        p2.setVida(p2.getVida() - dano_realizado);
                        imprimir.realizado(dano_realizado,p2);
                    }
                } else if (n == 2) {
                    Habilidad habilidad;
                    p1.muestraHabilidades();
                    n = pedir.leeEntero("Introduce el numero de la habilidad que quieres realizar");
                    habilidad = p1.utilizaHabilidad(n - 1, p1.getMana());
                    p1.sumarStats(habilidad);
                    dano_realizado = p1.getPoderhab() - (p2.getResmag() + 10);//pongo el +10 de resistencia magica cuando ataca el mago porque como el mago tiene mucho mana y tiene ventaja, entonces voy a sumar siempre 10 puntos de resmag
                    if (dano_realizado > 0) {
                        p2.setVida(p2.getVida() - dano_realizado);
                        imprimir.realizado_mana(dano_realizado,p2,p1.getMana());
                        p1.resetStats(p1);
                    }
                }
            }
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
                        imprimir.realizado(dano_realizado,p2);
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
                        imprimir.realizado_mana(dano_realizado,p2,p1.getMana());
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
                        imprimir.realizado(dano_realizado,p2);
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
                        imprimir.realizado_mana(dano_realizado,p2,p1.getMana());
                        p1.resetStats(p1);
                    }
                }
            }
        }
    }

    public Personaje escogePersonaje(Personaje[] personajes, String nombre){
        for (int i = 0; i < personajes.length; i++) {
            if (personajes[i].getNombre().equals(nombre)){
                return personajes[i];
            }
        }
        return null;
    }

    public void eliminaSeleccionado(Personaje[] personajes, Personaje seleccionado){
        for (int i = 0; i < personajes.length; i++) {
            if (seleccionado==personajes[i])
                personajes[i]=null;
        }
    }

    @Override
    public String toString() {
        return "personajes=" + Arrays.toString(personajes);
    }
}
