package beans.figur;

import beans.ZugTyp;
import bl.Loader;

import java.awt.*;

public class Bauer extends Figur {
  public Bauer(int x, int y) {
    super(1, ZugTyp.BAUER, x, y);
    this.setBild(Loader.loadImage("bauer.png"), "bauer.png");
  }

  public Bauer(int x, int y, boolean yours) {
    this(x, y);
    this.setYourSide(yours);
  }

  @Override
  public Point[] getMoveDir() {
    return new Point[]{NORTH};
  }

  @Override
  public Point[] getEnemyMoveDir() {
    return new Point[]{SOUTH};
  }

  @Override
  public Point[] getAttackDir() {
    return new Point[]{NORTH_EAST, NORTH_WEST};
  }

  @Override
  public Point[] getEnemyAttackDir() {
    return new Point[]{SOUTH_EAST, SOUTH_WEST};
  }

}
