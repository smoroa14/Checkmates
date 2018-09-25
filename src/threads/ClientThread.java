/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import Server.Client_Frame;
import java.util.Scanner;

/**
 *
 * @author Nico
 */
public class ClientThread implements Runnable {

    private Scanner input;
    private Client_Frame gui;

    @Override
    public void run() {
        while (!Thread.interrupted() && input.hasNextLine()) {

            String line = input.nextLine();
            if (line.equals("&&&&&&")) {
                gui.serverConnectionLost();
            }
            if (line.contains("+!!")) {
                String[] splitted = line.split("!!");
                System.out.println("SO OFT: "+line);

                for (int i = 0; i < splitted.length; i++) {
                    gui.userHinzu(splitted[i]);
                }

            }
            if (line.contains("!!!!!")) {
                System.out.println("--------------------------------drinnnnnnnnnnnnnnnnnnnnnnnnnneeeeeeeeeeeeeeeeeeeeeeeeee");
                //String[] splitted = line.split("\\$\\$");
                //System.out.println(splitted[0] + ": " + splitted[1]);
                gui.writeMsg(line);
            }
        }
        System.out.println("Clientthread finished");
        input.close();
    }

    public ClientThread(Scanner input, Client_Frame gui) {
        this.input = input;
        this.gui = gui;
    }

}
