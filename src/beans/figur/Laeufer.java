package beans.figur;

import beans.ZugTyp;
import bl.Loader;

import java.awt.*;

public class Laeufer extends Figur {
  public Laeufer(int x, int y) {
    super(-1, ZugTyp.GERADE, x, y);
    this.setBild(Loader.loadImage("laeufer.png"));
  }

  @Override
  public Point[] getMoveDir() {
    return new Point[]{NORTH_EAST, SOUTH_EAST, SOUTH_WEST, NORD_WEST};
  }
}
