package GUI;

import beans.figur.Figur;
import bl.Loader;
import bl.Zug2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.swing.border.Border;

/**
 * @author rober
 */
public class Main2 extends JFrame {
    //             x y

    private JLabel[][] felder;
    private List<Figur> friendFigures;
    private List<Figur> enemyFigures;
    private Map<Point, String> iconsBefore;
    private Container cont;
    private Zug2 zug;

    private List<Point> moeglicheZuege;
    private Point selectedField;
    private JLabel selectedLabel;

    private Border borderBlack = BorderFactory.createLineBorder(Color.black, 4);
    private Border borderYello = BorderFactory.createLineBorder(Color.yellow, 4);
    private Border borderBlue = BorderFactory.createLineBorder(Color.blue, 4);

    private boolean p1turn = true;
    private boolean attacking = false;

    public Main2() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        cont = this.getContentPane();
        cont.setLayout(new GridLayout(10, 10, 0, 0));
        zug = new Zug2(this);
        createFelder();
    }

    public void createFelder() {
        felder = new JLabel[10][10];
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                if (x == 0 || x == 9 || y == 0 || y == 9) {
                    felder[x][y] = new BorderLabel();
                    felder[x][y].setForeground(Color.LIGHT_GRAY.brighter());
                    //felder[x][y].setIcon(Loader.loadImage("null.png"));
                } else {
                    felder[x][y] = new JLabel();
                    if ((x + y - 2) % 2 == 0) {
                        //((ImageLabel) felder[x][y]).setColor(new Color(101, 62, 29).brighter());
                    }

                    felder[x][y].setBorder(borderBlack);
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
        new Main2().setVisible(true);
    }

    private class myMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            JLabel lb = (JLabel) e.getSource();
            String[] arr = lb.getName().split(";");
            int x = Integer.parseInt(arr[0]);
            int y = Integer.parseInt(arr[1]);
            Point point = new Point(x, y);
            Figur fig = getPointFigure(point);

            if (!attacking && fig != null && fig.isYourSide() == p1turn) {
                attacking = true;

                lb.setBorder(borderYello);

                selectedField = new Point(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
                selectedLabel = lb;

                if (moeglicheZuege == null) {
                    paintMoeglicheZuege(fig);
                }

            } else if (lb == selectedLabel) {
                //Border Clearen
                for (Point p : moeglicheZuege) {
                    felder[p.x][p.y].setBorder(borderBlack);
                }
                selectedLabel.setBorder(borderBlack);

                selectedLabel = null;
                selectedField = null;
                attacking = false;
                moeglicheZuege = null;
            } else {
                //Auf ein verfügbares Feld klicken
                if (lb.getBorder().equals(borderBlue)) {
                    lb.setIcon(selectedLabel.getIcon());
                    selectedLabel.setIcon(null);

                    List<Figur> li = p1turn ? friendFigures : enemyFigures;
                    for (Figur f : li) {
                        if (f.getPos().equals(selectedField)) {
                            f.setPos(new Point(x, y));
                        }
                    }

                    //Border Clearen
                    for (Point p : moeglicheZuege) {
                        felder[p.x][p.y].setBorder(borderBlack);
                    }
                    selectedLabel.setBorder(borderBlack);

                    selectedLabel = null;
                    selectedField = null;
                    attacking = false;
                    p1turn = !p1turn;
                    moeglicheZuege = null;
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

            if (!attacking) {
                JLabel lb = (JLabel) e.getSource();
                String[] arr = lb.getName().split(";");
                int x = Integer.parseInt(arr[0]);
                int y = Integer.parseInt(arr[1]);

                List<Figur> all = new LinkedList<>();
                all.addAll(friendFigures);
                all.addAll(enemyFigures);
                for (Figur f : all) {

                    if (f.getPos().equals(new Point(x, y))) {

                        ///////// Select Figure
                        if (f.isYourSide() == p1turn) {
                            paintMoeglicheZuege(f);
                        }
                    }
                }
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!attacking) {
                if (moeglicheZuege != null) {
                    for (Point p : moeglicheZuege) {
                        if (selectedField == null || !p.equals(selectedField.getLocation())) {
                            felder[p.x][p.y].setBorder(borderBlack);
                        }
                    }
                }
            }

        }

    }

    private void paintMoeglicheZuege(Figur f) {
        moeglicheZuege = zug.getMoeglicheZuege(f);
        for (Point p : moeglicheZuege) {
            if (selectedField == null || !p.equals(selectedField)) {
                felder[p.x][p.y].setBorder(borderBlue);
            }
        }
    }

    private Figur getPointFigure(Point p) {
        for (Figur allFigure : getAllFigures()) {
            if (allFigure.getPos().equals(p)) {
                return allFigure;
            }
        }
        return null;
    }
}
