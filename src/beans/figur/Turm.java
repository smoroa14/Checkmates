package beans.figur;

import beans.ZugTyp;
import bl.Loader;

import java.awt.*;

public class Turm extends Figur {
  public Turm(int x, int y) {
    super(-1, ZugTyp.GERADE, x, y);
    this.setBild(Loader.loadImage("turm.png"));
  }

  public Turm(int x, int y, boolean yours) {
    this(x, y);
    this.setYourSide(yours);
  }

  @Override
  public Point[] getMoveDir() {
    return new Point[]{NORTH, EAST, SOUTH, WEST};
  }
}