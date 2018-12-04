package beans.figur;

import beans.ZugTyp;

import javax.swing.*;
import java.awt.*;

public abstract class Figur {

  //Movement Vectors
  public final static Point NORTH = new Point(0, -1);
  public final static Point EAST = new Point(1, 0);
  public final static Point SOUTH = new Point(0, 1);
  public final static Point WEST = new Point(-1, 0);
  public final static Point NORTH_EAST = new Point(1, -1);
  public final static Point SOUTH_EAST = new Point(1, 1);
  public final static Point SOUTH_WEST = new Point(-1, 1);
  public final static Point NORTH_WEST = new Point(-1, -1);

  private int zugweite;
  private Point pos;
  private Icon bild;
  private ZugTyp zugtyp;
  private boolean yourSide;
  private String image_name;
  private int wertung;

  public Figur(int zugweite, ZugTyp zugtyp, int x, int y) {
    this(zugweite, zugtyp, new Point(x, y));
  }

  public Figur(int zugweite, ZugTyp zugtyp, int x, int y, boolean yours) {
    this(zugweite, zugtyp, new Point(x, y));
    this.setYourSide(yours);
  }

  public Figur(int zugweite, ZugTyp zugtyp, Point pos) {
    this.pos = pos;
    this.zugweite = zugweite;
    this.zugtyp = zugtyp;
  }

  public boolean isYourSide() {
    return yourSide;
  }

  public void setYourSide(boolean yourSide) {
    this.yourSide = yourSide;
    System.out.println("side: " + yourSide);
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

  public void setBild(Icon bild, String name) {
    this.bild = bild;
    image_name = name;
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

  public static Figur getClassFromChar(char c, int x, int y, boolean yours) {
    switch (c) {
      case 't':
        return new Turm(x, y, yours);
      case 'p':
        return new Pferd(x, y, yours);
      case 'l':
        return new Laeufer(x, y, yours);
      case 'd':
        return new Dame(x, y, yours);
      case 'k':
        return new Koenig(x, y, yours);
      case 'b':
        return new Bauer(x, y, yours);
      default:
        return null;
    }
  }


  public abstract Point[] getMoveDir();

  public Point[] getEnemyMoveDir() {
    return getMoveDir();
  }

  public Point[] getAttackDir() {
    return getMoveDir();
  }

  public Point[] getEnemyAttackDir() {
    return getEnemyMoveDir();
  }

  public boolean equalsPos(Point pos) {
    return pos.getX() == this.pos.getX() && pos.getY() == this.pos.getY();
  }

  public String getImage_name() {
    return image_name;
  }

  public void setImage_name(String image_name) {
    this.image_name = image_name;
  }
}
