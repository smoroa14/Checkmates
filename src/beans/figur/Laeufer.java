package beans.figur;

import beans.ZugTyp;
import bl.Loader;

public class Laeufer extends Figur {
  public Laeufer(int x, int y) {
    super(1, ZugTyp.GERADE, x, y);
    this.setBild(Loader.loadImage("laeufer.png"));
  }
}
