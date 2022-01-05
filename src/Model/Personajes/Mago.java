package Model.Personajes;

import Model.Habilidad;

import java.util.Arrays;

public class Mago extends Personaje{
    private int vidaextra;
    private int armaduraExtra;
    private int resmagExtra;
    private int podhabExtra;

    public Mago(String nombre, int vida, int armadura, int resmag, int ataque, int poderhab, int mana, Habilidad[] habilidades, int vidaextra, int armaduraExtra, int resmagExtra, int podhabExtra){
        super(nombre, vida, armadura, resmag, ataque, poderhab, mana, habilidades);
        this.vidaextra=vidaextra;
        this.armaduraExtra=armaduraExtra;
        this.resmagExtra=resmagExtra;
        this.podhabExtra=podhabExtra;
    }

    public int getVidaextra() {
        return vidaextra;
    }

    public void setVidaextra(int vidaextra) {
        this.vidaextra = vidaextra;
    }

    public int getArmaduraExtra() {
        return armaduraExtra;
    }

    public void setArmaduraExtra(int armaduraExtra) {
        this.armaduraExtra = armaduraExtra;
    }

    public int getResmagExtra() {
        return resmagExtra;
    }

    public void setResmagExtra(int resmagExtra) {
        this.resmagExtra = resmagExtra;
    }

    public int getAtaqueExtra() {
        return podhabExtra;
    }

    public void setAtaqueExtra(int poderhabExtra) {
        this.podhabExtra = poderhabExtra;
    }

    public void sumarStats(){
        this.vida+=vidaextra;
        this.armadura+=armaduraExtra;
        this.resmag+=resmagExtra;
        this.poderhab+=podhabExtra;
    }

    @Override
    public String toString() {
        return  nombre + " es Mago,"+" tiene " + vida + " de vida, "+ armadura + " de armadura y "+ resmag+ " de resistencia magica, " +  ataque + " de ataque y " + poderhab + " de poder de habilidad, además de " + mana + " de mana.";
    }
}
