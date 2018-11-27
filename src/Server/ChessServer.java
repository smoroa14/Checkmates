/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import beans.Raum;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import static java.lang.Thread.interrupted;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Nico
 */
public class ChessServer {

    private ServerSocket server;
    private final int PORT = 1337;
    private ServerThread st;
    private List<String> usernames = new LinkedList<>();
    private List<Raum> rooms = new LinkedList<Raum>();
    private Map<String, PrintWriter> broadcast = new HashMap();

    public void startServer() {
        if (server == null) {
            try {
                st = new ServerThread();
                st.start();
            } catch (IOException ex) {
                //Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
                //System.out.println(ChessServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            log("Server allready up");
        }
    }

    public void stopServer() throws IOException {
        if (server != null) {
            st.interrupt();
            server.close();
            server = null;

        }
    }

    public void manageUser(char operator, String user) {
        if (operator == '+') {
            usernames.add(user);
            broadcast.put(user, pw);
        } else {
            usernames.remove(user);
            broadcast.remove(user);
        }
    }

    public void manageRooms(char operator, Raum room) {
        if (operator == '+') {
            rooms.add(room);
        } else {
            rooms.remove(room);
        }
    }

    public String getUsers() {
        String guys = ";";
        int help = 0;
        for (String username : usernames) {
            if (help++ != usernames.size() - 1) {
                guys += username + ";";
            } else {
                guys += username;
            }
        }
        System.out.println("Leute zurückgeben");
        return guys;
    }

    private void log(String message) {
        System.out.println(message);
    }

    class ServerThread extends Thread {

        public ServerThread() throws IOException {
            server = new ServerSocket(PORT);
            server.setSoTimeout(500);
            log("Server started on port " + PORT);
        }

        @Override
        public void run() {
            Socket socket;
            while (!interrupted()) {
                try {
                    socket = server.accept();
                    log("Connected to " + socket.getRemoteSocketAddress());
                    ClientCommunicationThread cct = new ClientCommunicationThread(socket);
                    cct.start();

                } catch (IOException ex) {
//                    log(ex.toString());
                }

            }
            log("User Disconnected");
        }

    }

    private Scanner scan;
    private PrintWriter pw;

    class ClientCommunicationThread extends Thread {

        private Socket socket;

        public ClientCommunicationThread(Socket socket) throws IOException {
            this.socket = socket;

//            InputStream is = socket.getInputStream();
//            scan = new Scanner(is);
//
//            OutputStream os = socket.getOutputStream();
//            pw = new PrintWriter(os);
        }

        @Override
        public void run() {
            try {
                InputStream is = socket.getInputStream();
                Scanner scan = new Scanner(is);

                OutputStream os = socket.getOutputStream();
                pw = new PrintWriter(os);

                String line = "";
                do {
                    line = scan.nextLine();
                    System.out.println("LINE: " + line);

                    //User hinzufügen
                    if (line.contains("!#!")) {
                        String[] splitted = line.split("!#!");
                        if (splitted[0].toCharArray()[0] == '+') {
                            manageUser('+', splitted[1]);
                            //serverFrame.writeLog("User " + splitted[1] + " has been added");

                            System.out.println("Usersize... :" + broadcast.size());
                            for (String username : usernames) {
                                PrintWriter pwr = broadcast.get(username);

                                pwr.println("+!!" + getUsers());
                                pwr.flush();
                            }

                            //System.out.println("Hinzufügen ---------" + getUsers());
                        } else {
                            manageUser('-', splitted[1]);
                            //serverFrame.writeLog("User " + splitted[1] + " has been removed");

                            for (String username : usernames) {
                                PrintWriter pwr = broadcast.get(username);
                                pwr.println("-!!" + splitted[1]);
                                pwr.flush();
                            }
                            // System.out.println("Löschen  ----------" + getUsers());
                        }
                    }
                    
                    if(line.contains("###Raum")){
                        for (String username : usernames) {
                                PrintWriter pwr = broadcast.get(username);

                                pwr.println("TESTTEST AUSGABE AUSGABE TEST TEST");
                                pwr.flush();
                            }
                    }

                    System.out.println(line);
                    if (line.contains("Zug123321")) {
                        for (String username : usernames) {
                            PrintWriter pwr = broadcast.get(username);
                            String[] splitted = line.split("Zug123321");
                            System.out.println("drrrrrrrrrrrrreeeeeeeeeeeeeeeeeeeeeeeeecccccccccccccccccckkkkkkkkkkkkkkkk");
                            if (line.contains("!!!!!")) {
                                System.out.println("hilllllllllllllllllllllllllllfffffffffffffffffffeeeeeeeeeeeeeeeeeeeeeeeeeee");
                            }
                            pwr.println("!!!!!Zug von : " + splitted[1]);
                            pwr.flush();
                        }

                    }

                    //Texte bekommen
                    if (line.contains("!§!")) {

                    }

                } while (scan.hasNextLine() && !interrupted());

                pw.close();
                scan.close();
                socket.close();
            } catch (Exception ex) {
            }
            log("communication with " + socket.getRemoteSocketAddress() + " finished");
        }

    }

    public void DisconnectAll() {
        for (String username : usernames) {
            PrintWriter pw = broadcast.get(username);
            pw.println("&&&&&&");
            pw.flush();
        }
    }
}
