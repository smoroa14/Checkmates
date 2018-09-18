package beans.figur;

import beans.ZugTyp;
import bl.Loader;

public class Turm extends Figur {
  public Turm(int x, int y) {
    super(1, ZugTyp.GERADE, x, y);
    this.setBild(Loader.loadImage("turm.png"));
  }
}