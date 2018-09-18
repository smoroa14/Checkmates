package beans.figur;

import beans.ZugTyp;
import bl.Loader;

public class Koenig extends Figur {
  public Koenig(int x, int y) {
    super(1, ZugTyp.GERADE, x, y);
    this.setBild(Loader.loadImage("koenig.png"));
  }
}
