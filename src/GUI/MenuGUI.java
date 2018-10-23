/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import beans.Raum;
import java.util.LinkedList;
import threads.SoundPlayer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import pojos.Player;

/**
 *
 * @author Kevin
 */
public class MenuGUI extends javax.swing.JFrame {

    private SoundPlayer player = SoundPlayer.getInstance();
    private String selgame = "Schach"; //Ausgewähltes Spiel
    private Player u;
    DefaultListModel<Raum> dlm = new DefaultListModel<>();
    LinkedList<Raum> raumlist = new LinkedList<>();
    boolean used = false;
    Raum selectedroom;

    //private DB_Access access = DB_Access.getInstance();
    public Player getS() {
        return u;
    }

    public void setS(Player u) {
        this.u = u;
        lbName.setText("Name: " + u.getUsername());
        lbGeld.setText("Elo: " + u.getMmr());
    }

    public MenuGUI() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        initComponents();
        liRaum.setModel(dlm);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfPasswort = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfElo = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        liRaum = new javax.swing.JList<>();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        lbName = new javax.swing.JLabel();
        lbGeld = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton4.setFont(new java.awt.Font("Eras Bold ITC", 0, 48)); // NOI18N
        jButton4.setText("Logout");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onLogout(evt);
            }
        });
        getContentPane().add(jButton4, java.awt.BorderLayout.SOUTH);

        jPanel8.setLayout(new java.awt.BorderLayout());

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jButton3.setText("Refresh");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onRefresh(evt);
            }
        });
        jPanel8.add(jButton3, java.awt.BorderLayout.SOUTH);

        jPanel1.setLayout(new java.awt.GridLayout(1, 2));

        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Raum erstellen");
        jPanel2.add(jLabel2, java.awt.BorderLayout.PAGE_START);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jButton1.setText("Erstellen");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onErstellen(evt);
            }
        });
        jPanel2.add(jButton1, java.awt.BorderLayout.PAGE_END);

        jPanel4.setLayout(new java.awt.GridLayout(3, 2));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel3.setText("Name:");
        jPanel4.add(jLabel3);

        tfName.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jPanel4.add(tfName);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel5.setText("Passwort:");
        jPanel4.add(jLabel5);

        tfPasswort.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jPanel4.add(tfPasswort);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel4.setText("Elo Min.:");
        jPanel4.add(jLabel4);

        tfElo.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jPanel4.add(tfElo);

        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jButton2.setText("Beitreten");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onBeitreten(evt);
            }
        });
        jPanel5.add(jButton2, java.awt.BorderLayout.SOUTH);

        jPanel6.setLayout(new java.awt.BorderLayout());

        liRaum.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        liRaum.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                onSelect(evt);
            }
        });
        jScrollPane1.setViewportView(liRaum);

        jPanel6.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel6, java.awt.BorderLayout.CENTER);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Raum beitreten");
        jPanel5.add(jLabel6, java.awt.BorderLayout.PAGE_START);

        jPanel1.add(jPanel5);

        jPanel8.add(jPanel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jButton5.setText("Deck");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onDeck(evt);
            }
        });
        jPanel3.add(jButton5, java.awt.BorderLayout.EAST);

        jPanel7.setOpaque(false);
        jPanel7.setLayout(new java.awt.GridLayout(2, 1, 10, 10));

        lbName.setFont(new java.awt.Font("Eras Bold ITC", 0, 48)); // NOI18N
        lbName.setText("Name:");
        jPanel7.add(lbName);

        lbGeld.setFont(new java.awt.Font("Eras Bold ITC", 0, 48)); // NOI18N
        lbGeld.setText("Elo:");
        jPanel7.add(lbGeld);

        jPanel3.add(jPanel7, java.awt.BorderLayout.CENTER);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Eras Bold ITC", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Willkommen!");
        jLabel1.setOpaque(true);
        jPanel3.add(jLabel1, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onLogout(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onLogout
        //player.play("effect", "Select.mp3", false);
        //player.close("Poker.mp3");
        try {
            //access.updateUser(u);
            LoginGUI logingui = new LoginGUI();
            logingui.setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(MenuGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_onLogout

    private void onErstellen(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onErstellen
        try {
            String raumname = tfName.getText();
            String raumpasswort = tfPasswort.getText();
            int raumelo = Integer.parseInt(tfElo.getText());
            Raum raum = new Raum(raumname, raumpasswort, raumelo);

            for (Raum raum1 : raumlist) {
                if (raum.getName().equals(raum1.getName())) {
                    used = true;
                }
            }
            if (used == false) {
                raumlist.add(raum);
                dlm.addElement(raum);
            }
            used = false;

        } catch (NumberFormatException e) {
            System.out.println("ein Feld ist leer");
        }

    }//GEN-LAST:event_onErstellen

    private void onBeitreten(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onBeitreten
        String eingabe = "";
        try {
            if (!selectedroom.getPasswort().equals("")) {
                eingabe = JOptionPane.showInputDialog("Raum-Passwort benötigt:");
            } else {
                if (eingabe.equals(selectedroom.getPasswort())) {
                    Main maingui = new Main();
                    maingui.setVisible(true);
                    this.dispose();
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Es ist kein Raum ausgewählt!");
        }

    }//GEN-LAST:event_onBeitreten

    private void onSelect(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_onSelect
        int index = liRaum.getSelectedIndex();
        selectedroom = dlm.get(index);
    }//GEN-LAST:event_onSelect

    private void onRefresh(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onRefresh

    }//GEN-LAST:event_onRefresh

    private void onDeck(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onDeck
        DeckGUI deckgui = new DeckGUI();
        deckgui.setVisible(true);
      
    }//GEN-LAST:event_onDeck

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbGeld;
    private javax.swing.JLabel lbName;
    private javax.swing.JList<Raum> liRaum;
    private javax.swing.JTextField tfElo;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfPasswort;
    // End of variables declaration//GEN-END:variables
}
