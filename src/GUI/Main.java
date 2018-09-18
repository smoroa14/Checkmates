
package GUI;

import beans.figur.*;
import bl.Loader;

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
    this.setSize(300, 300);
    cont = this.getContentPane();
    cont.setLayout(new GridLayout(10, 10, 0, 0));

    createFelder();
  }

  public void createFelder() {
    felder = new JLabel[10][10];
    for (int y = 0; y < 10; y++) {
      for (int x = 0; x < 10; x++) {
        if(x == 0 || x == 9 || y == 0 || y == 9)
        {
          felder[x][y] = new JLabel();
        }else{
          felder[x][y] = new ImageLabel();
        }
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
      felder[f.getPos().x][f.getPos().y].setIcon(f.getBild());
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
