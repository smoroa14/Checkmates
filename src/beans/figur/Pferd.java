package beans.figur;

import beans.ZugTyp;
import bl.Loader;

import java.awt.*;

public class Pferd extends Figur {
  public Pferd(int x, int y) {
    super(1, ZugTyp.GERADE, x, y);
    this.setBild(Loader.loadImage("pferd.png"));
  }

  @Override
  public Point[] getMoveDir() {
    return new Point[]{
            new Point(1,2),
            new Point(2,1),
            new Point(1,-2),
            new Point(2,-1),
            new Point(-1,2),
            new Point(-2,1),
            new Point(-1,-2),
            new Point(-2,-1)
    };
  }
}
