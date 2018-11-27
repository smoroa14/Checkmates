/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import GUI.MenuGUI;
import beans.Raum;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Nico
 */
public class UserClient {

    private InetAddress addr;
    private Socket socket;
    private String username = "";
    private MenuGUI clientFrame;

    private Scanner scan;
    private PrintWriter pw;

    private Thread t;

    private List<Raum> roomList = new LinkedList<>();

    public UserClient() throws UnknownHostException, IOException {
        addr = InetAddress.getLocalHost();
        socket = new Socket(addr, 1337);

    }

    public void sendRequests(String eingabe, char operator) throws IOException {
//        InputStream is = socket.getInputStream();
//        Scanner scan = new Scanner(is);
//
//        OutputStream os = socket.getOutputStream();
//        PrintWriter pw = new PrintWriter(os);

//        Start Clientthread
        if (operator == '+') {
            username = eingabe;
            pw.println("+!#!" + eingabe);
            pw.flush();
        }
        if (operator == '-') {
            pw.println("-!#!" + eingabe);
            pw.flush();
        }
        if (operator == 'u') {
            System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm " + eingabe);
            pw.println("Zug123321" + eingabe);
            pw.flush();
        }
        if (operator == '§') {
            pw.println(username + "!§!" + eingabe);
            pw.flush();
        }

//        Beim Disconect dann
//        pw.close();
//        socket.close();
    }

    public String getUsers() throws IOException {
        OutputStream os = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(os);

        InputStream is = socket.getInputStream();
        Scanner scan = new Scanner(is);

        System.out.println("drinne");
        pw.println("UserInfo");
        pw.flush();

        String leuteString = "";

        System.out.println(scan.hasNextLine() + "Next line ???");
        if (scan.hasNextLine()) {
            leuteString = scan.nextLine();
            System.out.println("typies: " + leuteString);
        }
        return leuteString;
    }

    public void addRoom(Raum room) throws IOException {
        if (!roomList.contains(room)) {
            roomList.add(room);

            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);

            InputStream is = socket.getInputStream();
            Scanner scan = new Scanner(is);
            
            pw.println("###Raum");
            pw.flush();
            
            if (scan.hasNextLine()) {
            //List<Raum> roomList = scan.nextLine();
                System.out.println(scan.nextLine());
        }
        }
    }

    public UserClient(MenuGUI clientFrame) throws IOException {
        this.clientFrame = clientFrame;
        addr = InetAddress.getLocalHost();
        socket = new Socket(addr, 1337);
        System.out.println("adjskfklasdljksdakdfslk   " + socket);

        InputStream is = socket.getInputStream();
        scan = new Scanner(is);

        OutputStream os = socket.getOutputStream();
        pw = new PrintWriter(os);

        ClientThread ct = new ClientThread(scan, clientFrame);
        Thread t = new Thread(ct);
        t.start();
    }

}
