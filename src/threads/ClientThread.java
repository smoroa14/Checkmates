/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import GUI.MenuGUI;
import java.util.Scanner;
import javax.swing.JFrame;

/**
 *
 * @author Nico
 */
public class ClientThread implements Runnable {

    private Scanner input;
    private MenuGUI gui;

    @Override
    public void run() {
        while (!Thread.interrupted() && input.hasNextLine()) {

            String line = input.nextLine();
            gui.dohier("dohier!!!!!!!!!!!!!!!!!!!!!!!!!!ggggggggggggggggggggggggggggggggggggggggggggg!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            if (line.equals("&&&&&&")) {
                
            }
            if (line.contains("+!!")) {
                String[] splitted = line.split("!!");
                System.out.println("SO OFT: "+line);

                for (int i = 0; i < splitted.length; i++) {
            //        gui.userHinzu(splitted[i]);
                }

            }
            if (line.contains("!!!!!")) {
                System.out.println("--------------------------------drinnnnnnnnnnnnnnnnnnnnnnnnnneeeeeeeeeeeeeeeeeeeeeeeeee");
                //String[] splitted = line.split("\\$\\$");
                //System.out.println(splitted[0] + ": " + splitted[1]);
            //    gui.writeMsg(line);
            }
        }
        System.out.println("Clientthread finished");
        input.close();
    }

    public ClientThread(Scanner input, JFrame gui) {
        this.input = input;
        this.gui = (MenuGUI) gui;
    }

}
