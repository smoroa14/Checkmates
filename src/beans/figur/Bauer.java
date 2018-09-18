package beans.figur;

import beans.ZugTyp;
import bl.Loader;

import java.awt.*;

public class Bauer extends Figur {
  public Bauer(int x, int y) {
    super(1, ZugTyp.BAUER, x, y);
    this.setBild(Loader.loadImage("bauer.png"));
  }

  @Override
  public Point[] getMoveDir() {
    return new Point[]{NORTH};
  }
}
