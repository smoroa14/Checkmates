package bl;

import GUI.Main;
import beans.figur.Figur;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Zug {
  private Main main;

  public Zug(Main main) {
    this.main = main;
  }

  public List<Point> getMoeglicheZuege(Point pos) {
    List<Figur> all = main.getAllFigures();

    for (Figur f : all) {
      if (f.getPos().equals(pos)) {
        return getMoeglicheZuege(f);
      }
    }
    return null;
  }

  public List<Point> getMoeglicheZuege(Figur f) {
    Point[] richtungen;
    if (f.isYourSide()) {
      richtungen = f.getMoveDir();
    } else {
      richtungen = f.getEnemyMoveDir();
    }
    List<Point> spruenge = new LinkedList<>();
    for (Point p : richtungen) {
      for (int i = 1; i <= (f.getZugweite() < 0 ? 8 : f.getZugweite()); i++) {
        Point sprung = new Point(f.getPos().x + p.x * i, f.getPos().y + p.y * i);
        if (sprung.x > 8 || sprung.x < 1 || sprung.y > 8 || sprung.y < 1) {
          continue;
        }
        if (isFigur(sprung)) {
          break;
        }
        spruenge.add(sprung);
      }
    }
    return spruenge;
  }

  public boolean isFigur(Point pos) {
    for (Figur f : main.getAllFigures()) {
      if (f.getPos().equals(pos))
        return true;
    }
    return false;
  }
}
