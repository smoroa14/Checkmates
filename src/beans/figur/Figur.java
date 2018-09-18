package beans.figur;

import beans.ZugTyp;

import javax.swing.*;
import java.awt.*;

public abstract class Figur {

  public final static Point NORTH = new Point(0,1);
  public final static Point SOUTH = new Point(0,-1);
  public final static Point WEST = new Point(-1,0);
  public final static Point EAST = new Point(1,0);
  public final static Point NORTH_EAST = new Point(1,1);
  public final static Point SOUTH_EAST = new Point(1,-1);
  public final static Point SOUTH_WEST = new Point(-1,-1);
  public final static Point NORD_WEST = new Point(-1,1);

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

  public static Figur getClassFromChar(char c, int x, int y)
  {
    switch (c)
    {
      case 't':return new Turm(x, y);
      case 'p':return new Pferd(x, y);
      case 'l':return new Laeufer(x, y);
      case 'd':return new Dame(x, y);
      case 'k':return new Koenig(x, y);
      default :return new Bauer(x, y);
    }
  }


  public abstract Point[] getMoveDir();

  public boolean equalsPos(Point pos) {
    return pos.getX() == this.pos.getX() && pos.getY() == this.pos.getY();
  }
}
