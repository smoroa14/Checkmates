package beans.figur;

import beans.ZugTyp;
import bl.Loader;

public class Pferd extends Figur {
  public Pferd(int x, int y) {
    super(1, ZugTyp.GERADE, x, y);
    this.setBild(Loader.loadImage("pferd.png"));
  }
}
