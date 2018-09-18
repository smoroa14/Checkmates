
package GUI;

import beans.figur.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
  private Container cont;

  public Main() {
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.setSize(300,300);
    cont = this.getContentPane();
    cont.setLayout(new GridLayout(10, 10, 0, 0));

    createFelder();
  }

    public void createFelder() {
        felder = new JLabel[10][10];
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                felder[x][y] = new JLabel();
                felder[x][y].isOpaque();

                felder[x][y].addMouseListener(new myMouseListener());
                felder[x][y].setHorizontalAlignment(SwingConstants.CENTER);
                cont.add(felder[x][y]);
            }
        }


    //Ausenränder
    for (int x = 1; x < 9; x++) {
      felder[x][0].setText(Character.toString((char)('A' + x - 1)));
      felder[x][9].setText(Character.toString((char)('A' + x - 1)));
    }
    for (int y = 1; y < 9; y++) {
      felder[0][y].setText(y+"");
      felder[9][y].setText(y+"");
    }

    //Figur
    friendFigures = new LinkedList<>();
    enemyFigures = new LinkedList<>();

    for (int x = 1; x < 9; x++) {
      int y = 2;
      Bauer b = new Bauer(x, y);
      friendFigures.add(b);
      felder[x][y].setIcon(b.getBild());
      y = 7;
      b = new Bauer(x, y);
      enemyFigures.add(b);
      felder[x][y].setIcon(b.getBild());
    }
    Figur t = new Turm(1, 1);
    friendFigures.add(t);
    felder[1][1].setIcon(t.getBild());
    t = new Turm(8, 1);
    friendFigures.add(t);
    felder[1][8].setIcon(t.getBild());
    t = new Turm(1, 8);
    friendFigures.add(t);
    felder[8][1].setIcon(t.getBild());
    t = new Turm(8, 8);
    friendFigures.add(t);
    felder[8][8].setIcon(t.getBild());
    t = new Pferd(2, 1);
    friendFigures.add(t);
    felder[2][1].setIcon(t.getBild());
    t = new Pferd(2, 8);
    friendFigures.add(t);
    felder[2][8].setIcon(t.getBild());
    t = new Pferd(7, 1);
    friendFigures.add(t);
    felder[7][1].setIcon(t.getBild());
    t = new Pferd(7, 8);
    friendFigures.add(t);
    felder[7][8].setIcon(t.getBild());
    t = new Laeufer(3, 1);
    friendFigures.add(t);
    felder[3][1].setIcon(t.getBild());
    t = new Laeufer(3, 8);
    friendFigures.add(t);
    felder[3][8].setIcon(t.getBild());
    t = new Laeufer(6, 1);
    friendFigures.add(t);
    felder[6][1].setIcon(t.getBild());
    t = new Laeufer(6, 8);
    friendFigures.add(t);
    felder[6][8].setIcon(t.getBild());
    t = new Koenig(4, 1);
    friendFigures.add(t);
    felder[4][1].setIcon(t.getBild());
    t = new Koenig(4, 8);
    friendFigures.add(t);
    felder[4][8].setIcon(t.getBild());
    t = new Dame(5, 1);
    friendFigures.add(t);
    felder[5][1].setIcon(t.getBild());
    t = new Dame(5, 8);
    friendFigures.add(t);
    felder[5][8].setIcon(t.getBild());
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);

  }

    public static void main(String[] args) {
        new Main().setVisible(true);
    }

    private class myMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            JLabel lb = (JLabel) e.getSource();
            System.out.println(lb.getName());
            lb.setBackground(Color.BLACK);

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
