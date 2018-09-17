package beans;

import bl.Loader;

public class Bauer extends Figur{
  public Bauer(int x, int y) {
    super(1, ZugTyp.GERADE, x, y);
    this.setBild(Loader.loadImage("bauer.png"));
  }
}
