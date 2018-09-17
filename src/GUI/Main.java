/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import beans.Figur;
import beans.Figur;
import beans.ZugTyp;

import javax.swing.*;
import java.awt.*;
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
        cont = this.getContentPane();
        cont.setLayout(new GridLayout(10, 10, 0, 0));

        createFelder();
    }

    public void createFelder() {
        felder = new JLabel[10][10];
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                felder[x][y] = new JLabel();
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
            friendFigures.add(new Figur("Test", WIDTH, ZugTyp.GERADE));
            enemyFigures.add(new Figur("Test", WIDTH, ZugTyp.GERADE));
        }
    }

    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}
