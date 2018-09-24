
package GUI;

import beans.figur.*;
import bl.Loader;
import bl.Zug;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

/**
 * @author rober
 */
public class Main extends JFrame {
  //             x y
  private JLabel[][] felder;
  private List<Figur> friendFigures;
  private List<Figur> enemyFigures;
  private List<Point> moeglicheZuege;
  private Container cont;
  private Point selectedFigure;
  private Figur selected;
  private Zug zug;

  public Main() {
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.setSize(500, 500);
    cont = this.getContentPane();
    cont.setLayout(new GridLayout(10, 10, 0, 0));
    zug = new Zug(this);
    createFelder();
  }

  public void createFelder() {
    felder = new JLabel[10][10];
    for (int y = 0; y < 10; y++) {
      for (int x = 0; x < 10; x++) {
        if (x == 0 || x == 9 || y == 0 || y == 9) {
          felder[x][y] = new JLabel();
          //felder[x][y].setIcon(Loader.loadImage("null.png"));
        } else {
          felder[x][y] = new ImageLabel();
          ((ImageLabel) felder[x][y]).setIcon(Loader.loadImage("null.png"), "null.png");
        }
        felder[x][y].setName(x + ";" + y);
        felder[x][y].isOpaque();

        felder[x][y].addMouseListener(new myMouseListener());
        felder[x][y].setHorizontalAlignment(SwingConstants.CENTER);
        cont.add(felder[x][y]);
      }
    }


    //Ausenränder
    for (int x = 1; x < 9; x++) {
      felder[x][0].setText(Character.toString((char) ('A' + x - 1)));
      felder[x][9].setText(Character.toString((char) ('A' + x - 1)));
    }
    for (int y = 1; y < 9; y++) {
      felder[0][y].setText(y + "");
      felder[9][y].setText(y + "");
    }

    //Figur
    friendFigures = new LinkedList<>();
    enemyFigures = new LinkedList<>();

    Loader.loadSpielfeld();
    enemyFigures = Loader.enemyFigures;
    friendFigures = Loader.friendFigures;
    List<Figur> all = new LinkedList<>();
    all.addAll(enemyFigures);
    all.addAll(friendFigures);
    for (Figur f : all) {
      if (felder[f.getPos().x][f.getPos().y] instanceof ImageLabel) {
        ((ImageLabel) felder[f.getPos().x][f.getPos().y]).setIcon(f.getBild(), f.getImage_name());
      } else {
        felder[f.getPos().x][f.getPos().y].setIcon(f.getBild());
      }
    }
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    /*List<Figur> all = new LinkedList<>();
    all.addAll(friendFigures);
    all.addAll(enemyFigures);
    System.out.println("scale");
    for (Figur f : all) {
      Point pos = f.getPos();
      ImageLabel icon = (ImageLabel) f.getBild();
      Image scaledImage = icon.getImage().getScaledInstance(felder[pos.x][pos.y].getWidth()+100, felder[pos.x][pos.y].getHeight()+100, Image.SCALE_SMOOTH);
      icon = new ImageLabel(scaledImage);
      f.setBild(icon);
    }*/
  }

  public List<Figur> getAllFigures() {
    List<Figur> all = new LinkedList<>();
    all.addAll(friendFigures);
    all.addAll(enemyFigures);
    return all;
  }

  public static void main(String[] args) {
    new Main().setVisible(true);
  }

  private class myMouseListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
      JLabel lb = (JLabel) e.getSource();
      String[] arr = lb.getName().split(";");
      int x = Integer.parseInt(arr[0]);
      int y = Integer.parseInt(arr[1]);

      List<Figur> all = new LinkedList<>();
      all.addAll(friendFigures);
      all.addAll(enemyFigures);
      for (Figur f : all) {
        if (f.getPos().equals(new Point(x, y))) {
          if (selectedFigure != null) {
            if (selectedFigure.equals(f.getPos())) break;

            if(felder[selectedFigure.x][selectedFigure.y] instanceof ImageLabel)((ImageLabel)felder[selectedFigure.x][selectedFigure.y]).setUnselected();
            for (Point p : moeglicheZuege) {

              if (felder[p.x][p.y] instanceof ImageLabel) {
                ((ImageLabel) felder[p.x][p.y]).setIcon(Loader.loadImage("null.png"), "null.png");
              } else {
                felder[p.x][p.y].setIcon(Loader.loadImage("null.png"));
              }
            }
          }
          if(lb instanceof ImageLabel)((ImageLabel)lb).setSelected();
          System.out.println(lb.getIcon());
          selectedFigure = f.getPos();
          selected = f;

          moeglicheZuege = zug.getMoeglicheZuege(f);

          for (Point p : moeglicheZuege) {
            if (felder[p.x][p.y] instanceof ImageLabel) {
              ((ImageLabel) felder[p.x][p.y]).setIcon(Loader.loadImage("blau.png"), "blau.png");
            } else {
              felder[p.x][p.y].setIcon(Loader.loadImage("blau.png"));
            }
          }

          return;
        }
      }

      // Alle Blau gefärbten Felder durchgehen
      for (Point p : moeglicheZuege) {
        // Ob man auf das Blaue Feld geklickt hat
        if (p.equals(new Point(x, y))) {

          // Alle blauen Felder entfernen
          for (Point p2 : moeglicheZuege) {
            if (felder[p2.x][p2.y] instanceof ImageLabel) {
              ((ImageLabel) felder[p2.x][p2.y]).setIcon(Loader.loadImage("null.png"), "null.png");
            } else {
              felder[p2.x][p2.y].setIcon(Loader.loadImage("null.png"));
            }

          }

          // Bild Setzen
          if (felder[p.x][p.y] instanceof ImageLabel) {
            ((ImageLabel) felder[p.x][p.y]).setIcon(selected.getBild(), selected.getImage_name());
          } else {
            felder[p.x][p.y].setIcon(selected.getBild());
          }

          // Bild entfernen
          if (felder[selected.getPos().x][selected.getPos().y] instanceof ImageLabel) {
            ((ImageLabel) felder[selected.getPos().x][selected.getPos().y]).setIcon(Loader.loadImage("null.png"), "null.png");
          } else {
            felder[selected.getPos().x][selected.getPos().y].setIcon(Loader.loadImage("null.png"));
          }

          selected.setPos(p);
          moeglicheZuege.clear();
        }
      }

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

  }
}
