package beans.figur;

import beans.ZugTyp;

import javax.swing.*;
import java.awt.*;

public abstract class Figur {

  private int zugweite;
  private Point pos;
  private Icon bild;
  private ZugTyp zugtyp;

  public Figur(int zugweite, ZugTyp zugtyp, int x, int y) {
    this(zugweite, zugtyp, new Point(x, y));
  }

  public Figur(int zugweite, ZugTyp zugtyp, Point pos) {
    this.pos = pos;
    this.zugweite = zugweite;
    this.zugtyp = zugtyp;
  }

  public Point getPos() {
    return pos;
  }

  public void setPos(Point pos) {
    this.pos = pos;
  }

  public Icon getBild() {
    return bild;
  }

  public void setBild(Icon bild) {
    this.bild = bild;
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
    return "Figur{" + "zugweite=" + zugweite + ", zugtyp=" + zugtyp + '}';
  }

  public void getClassFromChar(char c, int x, int y)
  {

  }
}
