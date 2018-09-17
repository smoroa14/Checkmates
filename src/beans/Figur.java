/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Kevin
 */
public class Figur {
    private String name;
    private int zugweite;
    private ZugTyp zugtyp;

    public Figur(String name, int zugweite, ZugTyp zugtyp) {
        this.name = name;
        this.zugweite = zugweite;
        this.zugtyp = zugtyp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getZugweite() {
        return zugweite;
    }

    public void setZugweite(int zugweite) {
        this.zugweite = zugweite;
    }

    public ZugTyp getZugtyp() {
        return zugtyp;
    }

    public void setZugtyp(ZugTyp zugtyp) {
        this.zugtyp = zugtyp;
    }

    @Override
    public String toString() {
        return "Figur{" + "name=" + name + ", zugweite=" + zugweite + ", zugtyp=" + zugtyp + '}';
    }
    
    
}
