package Model;

public class Habilidad {
    protected String nombre;
    protected int manacost;
    protected int ataqueExt;
    protected int poderhabExt;
    protected int armaduraExt;
    protected int resmagExt;

    public Habilidad(String nombre, int manacost, int ataqueExt, int poderhabExt, int armaduraExt, int resmagExt) {
        this.nombre = nombre;
        this.manacost = manacost;
        this.ataqueExt = ataqueExt;
        this.poderhabExt = poderhabExt;
        this.armaduraExt = armaduraExt;
        this.resmagExt = resmagExt;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getManacost() {
        return manacost;
    }

    public void setManacost(int manacost) {
        this.manacost = manacost;
    }

    public int getAtaqueExt() {
        return ataqueExt;
    }

    public void setAtaqueExt(int ataqueExt) {
        this.ataqueExt = ataqueExt;
    }

    public int getPoderhabExt() {
        return poderhabExt;
    }

    public void setPoderhabExt(int poderhabExt) {
        this.poderhabExt = poderhabExt;
    }

    public int getArmaduraExt() {
        return armaduraExt;
    }

    public void setArmaduraExt(int armaduraExt) {
        this.armaduraExt = armaduraExt;
    }

    public int getResmagExt() {
        return resmagExt;
    }

    public void setResmagExt(int resmagExt) {
        this.resmagExt = resmagExt;
    }

    @Override
    public String toString() {
        return "\n"+nombre + " cuesta " + manacost + " de mana "+ ", tiene " + ataqueExt + " de ataque"+", tiene " + poderhabExt + " de poder de habilidad" + ", te añade " + armaduraExt + "de armadura extra "+" y " + resmagExt + " de resistencia magica extra";
    }
}
