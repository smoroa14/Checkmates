/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

/**
 *
 * @author Nico
 */
public class starterklasse {
    public static void main(String[] args) {
        ChessServer server = new ChessServer();
        
        Client_Frame client1 = new Client_Frame();
        client1.setName("Nico Morningstar");
        client1.setVisible(true);
        
        Client_Frame client2 = new Client_Frame();
        client2.setName("Trafalger Law");
        client2.setVisible(true);
        
        
        server.startServer();

    }
}
