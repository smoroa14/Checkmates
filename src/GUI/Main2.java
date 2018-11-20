package GUI;

import beans.figur.Figur;
import bl.Loader;
import bl.Zug;
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
            
            if (!attacking) {
                attacking = true;
                
                JLabel lb = (JLabel) e.getSource();
                lb.setBorder(borderYello);
                
                String[] arr = lb.getName().split(";");
                selectedField = new Point(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
                selectedLabel = lb;
            } else {
                JLabel lb = (JLabel) e.getSource();

                //Auf ein verfügbares Feld klicken
                if (lb.getBorder().equals(borderBlue)) {
                    lb.setIcon(selectedLabel.getIcon());
                    selectedLabel.setIcon(null);
                    
                    String[] arr = lb.getName().split(";");
                    int x = Integer.parseInt(arr[0]);
                    int y = Integer.parseInt(arr[1]);
                    
                    if (p1turn) {
                        for (Figur friendFigure : friendFigures) {
                            if (friendFigure.getPos().equals(selectedField)) {
                                friendFigure.setPos(new Point(x, y));
                            }
                        }
                    }else{
                        for (Figur friendFigure : friendFigures) {
                            if (friendFigure.getPos().equals(selectedField)) {
                                friendFigure.setPos(new Point(x, y));
                            }
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

//            JLabel lb = (JLabel) e.getSource();
//            String[] arr = lb.getName().split(";");
//            int x = Integer.parseInt(arr[0]);
//            int y = Integer.parseInt(arr[1]);
//
//            for (Figur f : getAllFigures()) {
//                if (f.getPos().equals(new Point(x, y))) {
//
//                    ///////// Unselect
//                    if (selectedFigure != null) {
//                        //if (selectedFigure.equals(f.getPos())) break;
//
//                        if (felder[selectedFigure.x][selectedFigure.y] instanceof ImageLabel) {
//                            ((ImageLabel) felder[selectedFigure.x][selectedFigure.y]).setUnselected();
//                        }
//                        for (Point moegZug : moeglicheZuege) {
//
//                            if (felder[moegZug.x][moegZug.y] instanceof ImageLabel) {
//                                felder[x][y].setBorder(borderBlack);
//                                for (Point p : iconsBefore.keySet()) {
//                                    /*if(p.equals(new Point(moegZug.x, moegZug.y)))
//                  {
//                    ((ImageLabel) felder[moegZug.x][moegZug.y]).setIcon(Loader.loadImage(iconsBefore.get(p)), "null.png");
//                  }*/
//                                }
//                            } else {
//                                felder[x][y].setBorder(borderBlack);
//                            }
//                        }
//                    }
//
//                    ///////// Select Figure
//                    if (f.isYourSide() == p1turn) {
//                        if (lb instanceof ImageLabel) {
//                            ((ImageLabel) lb).setSelected();
//                        }
//                        selectedFigure = f.getPos();
//                        selected = f;
//
//                        moeglicheZuege = zug.getMoeglicheZuege(f);
//                        iconsBefore = new HashMap<>();
//                        for (Point p : moeglicheZuege) {
//
//                            if (felder[p.x][p.y] instanceof ImageLabel) {
//
//                                felder[x][y].setBorder(borderBlue);
//                            } else {
//                                felder[p.x][p.y].setIcon(Loader.loadImage("blau.png"));
//                            }
//                        }
//                    }
//                    for (int i = 1; i < felder.length - 1; i++) {
//                        for (int j = 1; j < felder[i].length - 1; j++) {
//                            System.out.printf("%25s", i + " - " + j);
//                        }
//                        System.out.println();
//                        for (int j = 1; j < felder[i].length - 1; j++) {
//                            System.out.printf("%25s", ((ImageLabel) felder[i][j]).getIcon().toString());
//                        }
//                        System.out.println();
//                    }
//                    return;
//                }
//            }
//
//            ///////// Figur bewegen
//            // Alle Blau gefärbten Felder durchgehen
//            if (selectedFigure != null) {
//                for (Point p : moeglicheZuege) {
//                    // Ob man auf das Blaue Feld geklickt hat
//                    if (p.equals(new Point(x, y))) {
//
//                        // Attack
//                        if (p1turn) {
//
//                        }
//
//                        // Alle blauen Felder entfernen
//                        for (Point p2 : moeglicheZuege) {
//                            if (felder[p2.x][p2.y] instanceof ImageLabel) {
//                                //((ImageLabel) felder[p2.x][p2.y]).setIcon(Loader.loadImage("null.png"), "null.png");
//                                felder[x][y].setBorder(borderBlack);
//                            } else {
//                                felder[x][y].setBorder(borderBlack);
//                            }
//
//                        }
//
//                        // Bild Setzen
//                        if (felder[p.x][p.y] instanceof ImageLabel) {
//                            ((ImageLabel) felder[p.x][p.y]).setIcon(selected.getBild(), selected.getImage_name());
//                        } else {
//                            felder[p.x][p.y].setIcon(selected.getBild());
//                        }
//
//                        // Bild entfernen
//                        if (felder[selected.getPos().x][selected.getPos().y] instanceof ImageLabel) {
//                            felder[x][y].setBorder(borderBlack);
//                            //((ImageLabel) felder[selected.getPos().x][selected.getPos().y]).setOldImage();
//                        } else {
//                            felder[x][y].setBorder(borderBlack);
//                        }
//
//                        selected.setPos(p);
//                        moeglicheZuege.clear();
//                        p1turn = !p1turn;
//                    }
//                }
//            }
//            System.out.println(((ImageLabel) felder[8][7]).getIconName());
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
                            
                            moeglicheZuege = zug.getMoeglicheZuege(f);
                            for (Point p : moeglicheZuege) {
                                if (selectedField == null || !p.equals(selectedField)) {
                                    felder[p.x][p.y].setBorder(borderBlue);
                                }
                            }
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
}
