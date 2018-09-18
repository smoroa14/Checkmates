
package GUI;

import beans.Bauer;
import beans.Figur;

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
                felder[x][y] = new JLabel();
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
