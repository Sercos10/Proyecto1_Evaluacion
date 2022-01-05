package Model.Personajes;

import Model.Habilidad;

import java.util.Arrays;

public class Tirador extends Personaje{
    private int vidaextra;
    private int armaduraExtra;
    private int resmagExtra;
    private int ataqueExtra;

    public Tirador(String nombre, int vida, int armadura, int resmag, int ataque, int poderhab, int mana, Habilidad[] habilidades, int vidaextra, int armaduraExtra, int resmagExtra, int ataqueExtra){
        super(nombre, vida, armadura, resmag, ataque, poderhab, mana, habilidades);
        this.vidaextra=vidaextra;
        this.armaduraExtra=armaduraExtra;
        this.resmagExtra=resmagExtra;
        this.ataqueExtra=ataqueExtra;
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
        return ataqueExtra;
    }

    public void setAtaqueExtra(int ataqueExtra) {
        this.ataqueExtra = ataqueExtra;
    }

    public void sumarStats(){
        this.vida+=vidaextra;
        this.armadura+=armaduraExtra;
        this.resmag+=resmagExtra;
        this.ataque+=ataqueExtra;
    }

    @Override
    public String toString() {
        return  nombre + " es Tirador,"+" tiene " + vida + " de vida, "+ armadura + " de armadura y "+ resmag+ " de resistencia magica, " +  ataque + " de ataque y " + poderhab + " de poder de habilidad, además de " + mana + " de mana.";
    }
}
