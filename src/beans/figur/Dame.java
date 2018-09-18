package beans.figur;

import beans.ZugTyp;
import bl.Loader;

public class Dame extends Figur {
  public Dame(int x, int y) {
    super(1, ZugTyp.GERADE, x, y);
    this.setBild(Loader.loadImage("dame.png"));
  }
}