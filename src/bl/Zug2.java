package bl;

import GUI.Main;
import GUI.Main2;
import beans.figur.Figur;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Zug2 {
  private Main2 main;

  public Zug2(Main2 main) {
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
    Point[] moveRichtung;
    Point[] attackRichtung;
    moveRichtung = f.getMoveDir();
    if (f.isYourSide()) {
      attackRichtung = f.getAttackDir();
    } else {
      attackRichtung = f.getEnemyAttackDir();
    }
    List<Point> spruenge = new LinkedList<>();
    for (Point p : moveRichtung) {
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
    for (Point p : attackRichtung) {
      for (int i = 1; i <= (f.getZugweite() < 0 ? 8 : f.getZugweite()); i++) {
        Point sprung = new Point(f.getPos().x + p.x * i, f.getPos().y + p.y * i);
        if (sprung.x > 8 || sprung.x < 1 || sprung.y > 8 || sprung.y < 1) {
          continue;
        }
        if (isFigur(sprung)) {
          if (!isYourFigur(sprung, f)) {
            spruenge.add(sprung);
          }
          break;
        }
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

  public boolean isYourFigur(Point pos, Figur your) {
    for (Figur f : main.getAllFigures()) {
      if (f.getPos().equals(pos))
        return !f.isYourSide();
    }
    return false;
  }
}
