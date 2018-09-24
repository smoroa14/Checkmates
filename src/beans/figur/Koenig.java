package beans.figur;

import beans.ZugTyp;
import bl.Loader;

import java.awt.*;

public class Koenig extends Figur {
  public Koenig(int x, int y) {
    super(1, ZugTyp.GERADE, x, y);
    this.setBild(Loader.loadImage("koenig.png"), "koenig.png");
  }

  public Koenig(int x, int y, boolean yours) {
    this(x, y);
    this.setYourSide(yours);
  }

  @Override
  public Point[] getMoveDir() {
    return new Point[]{NORTH_EAST, SOUTH_EAST, SOUTH_WEST, NORTH_WEST,NORTH, EAST, SOUTH, WEST
    };
  }
}
