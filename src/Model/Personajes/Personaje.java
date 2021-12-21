package Model.Personajes;

import Model.Habilidad;

public class Personaje {
    protected String nombre;
    protected int vida;
    protected int armadura;
    protected int resmag;
    protected int ataque;
    protected int poderhab;
    protected int mana;
    protected Habilidad[] habilidades;

    public Personaje() {
        this.nombre="";
        this.vida=0;
        this.armadura=0;
        this.resmag=0;
        this.ataque=0;
        this.poderhab=0;
        this.mana=0;
    }

    public Personaje(String nombre, int vida, int armadura, int resmag, int ataque, int poderhab, int mana, Habilidad[] habilidades) {
        this.nombre = nombre;
        this.vida = vida;
        this.armadura = armadura;
        this.resmag=resmag;
        this.ataque = ataque;
        this.poderhab = poderhab;
        this.mana = mana;
        this.habilidades = habilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getArmadura() {
        return armadura;
    }

    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

    public int getResmag() {
        return resmag;
    }

    public void setResmag(int resmag) {
        this.resmag = resmag;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getPoderhab() {
        return poderhab;
    }

    public void setPoderhab(int poderhab) {
        this.poderhab = poderhab;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public Habilidad[] getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(Habilidad[] habilidades) {
        this.habilidades = habilidades;
    }

    public Habilidad utilizaHabilidad (int selec, int mana){
        boolean hab=false;
        do {
            for (int i = 0; i < habilidades.length; i++) {
                if (selec==i && mana>=habilidades[i].getManacost()){
                    hab=true;
                    return habilidades[selec];
                }
            }
            System.out.println("Escoge bien la habilidad");
        }while(!hab);

        return null;
    }

    public void muestraHabilidades(){
        int n=1;
        for (int i = 0; i < habilidades.length ; i++) {
            System.out.println("---------------------------------------");
            System.out.print(n++);
            System.out.print(habilidades[i]);
            System.out.println("---------------------------------------");
        }
    }

    public void sumarStats(Habilidad habilidad){
        this.mana-=habilidad.getManacost();
        this.armadura+=habilidad.getArmaduraExt();
        this.resmag+=habilidad.getResmagExt();
        this.ataque+=habilidad.getAtaqueExt();
        this.poderhab+=habilidad.getPoderhabExt();
    }

    public void resetStats(Personaje p1){
        if (this.getClass()==Luchador.class&&this.getNombre()=="Garen"){
            this.armadura=40;
            this.resmag=40;
            this.ataque=70;
        }else if (this.getClass()==Luchador.class&&this.getNombre()=="Ornn"){
            this.armadura=50;
            this.resmag=50;
            this.ataque=60;
        }else if(this.getClass()==Mago.class){
            this.armadura=25;
            this.resmag=25;
            this.poderhab=75;
        }else if (this.getClass()==Tirador.class){
            this.armadura=20;
            this.resmag=20;
            this.ataque=95;
        }
    }
}
