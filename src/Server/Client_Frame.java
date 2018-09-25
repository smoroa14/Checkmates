/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.util.HashMap;
import java.util.Random;
import javax.swing.JColorChooser;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import threads.UserClient;

/**
 *
 * @author Nico
 */
public class Client_Frame extends javax.swing.JFrame {

    /**
     * Creates new form Client_Frame
     */
    public Client_Frame() {
        initComponents();
        this.setSize(600, 400);
        tfEIngabe.addActionListener(ac);
        HTMLEditorKit kit = new HTMLEditorKit();
        taAusgabe.setEditorKit(kit);
    }

    private UserClient user;
    private String name;
    private String username = "";
    private List<String> leute = new LinkedList<>();
    private Client_Frame doHier = this;
    private boolean gast = false;
    private int randomGuestNumber = 1337;
    private String userName;
    private Color userColor = Color.black;

    public String getUserUser() {
        return "Client user eins zwo michl krenn";
    }

    /*public void setUser(String name) {
        this.user = name;
        this.setTitle("Logged in as " + user);
    }*/
    public void setGast(boolean isGast) {
        this.gast = isGast;
        Random rand = new Random();
        randomGuestNumber = rand.nextInt(99999 - 1001) + 1000;
        userName = "Guest" + randomGuestNumber;
        this.setTitle("Logged in as " + userName);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tfEIngabe = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        liLeute = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        taAusgabe = new javax.swing.JEditorPane();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btconnect = new javax.swing.JMenuItem();
        btdisconnect = new javax.swing.JMenuItem();
        btExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                FensterZuMachen(evt);
            }
        });

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));
        getContentPane().add(jPanel1, java.awt.BorderLayout.WEST);
        getContentPane().add(tfEIngabe, java.awt.BorderLayout.PAGE_END);

        jScrollPane3.setViewportView(liLeute);

        getContentPane().add(jScrollPane3, java.awt.BorderLayout.LINE_END);

        taAusgabe.setEditable(false);
        taAusgabe.setContentType("HTML/plain"); // NOI18N
        jScrollPane2.setViewportView(taAusgabe);

        getContentPane().add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jButton1.setText("Do Send MSG");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, java.awt.BorderLayout.PAGE_START);

        jMenu1.setText("Options");

        btconnect.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        btconnect.setText("Connect");
        btconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btconnectActionPerformed(evt);
            }
        });
        jMenu1.add(btconnect);

        btdisconnect.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        btdisconnect.setText("Disconnect");
        btdisconnect.setEnabled(false);
        btdisconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btdisconnectActionPerformed(evt);
            }
        });
        jMenu1.add(btdisconnect);

        btExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        btExit.setText("Exit");
        btExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExitActionPerformed(evt);
            }
        });
        jMenu1.add(btExit);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExitActionPerformed
        disonnectUser();
    }//GEN-LAST:event_btExitActionPerformed

    private void btconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btconnectActionPerformed
//        username = JOptionPane.showInputDialog(this, "Please enter your name:");
//        if (username.equalsIgnoreCase("your name")) {
//            JOptionPane.showMessageDialog(this, "AHAHA FUNNIER THAN AF BOI");
//        }

        try {

            user = new UserClient(this);
            user.sendRequests(name + " ", '+');
            // System.out.println(name);

        } catch (Exception ex) {

        }
        liLeute.setSelectedIndex(0);

        liLeute.updateUI();


    }//GEN-LAST:event_btconnectActionPerformed

    private void FensterZuMachen(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_FensterZuMachen
        try {
            System.out.println(name + " hat fenster zugemacht");
        } catch (Exception ex) {
            disonnectUser();
        }
        this.dispose();
    }//GEN-LAST:event_FensterZuMachen

    private void btdisconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdisconnectActionPerformed
        disonnectUser();
    }//GEN-LAST:event_btdisconnectActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.out.println("ajjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj "+name);
        try {
            user.sendRequests(name + "", 'u');
        } catch (IOException ex) {
            Logger.getLogger(Client_Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    ActionListener ac = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JTextField tf = (JTextField) e.getSource();
            String eingabe = tf.getText();
            System.out.println(eingabe);
            try {
                user.sendRequests(eingabe, '§');
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(doHier, "Please connect first [Strg + Alt + C]");
            }
            tf.setText("");
        }
    };

    public void disonnectUser() {

        btconnect.setEnabled(true);
        btdisconnect.setEnabled(false);
        try {
            if (gast) {
                user.sendRequests(userName, '-');
            } else {
                user.sendRequests(userName, '-');
            }
        } catch (Exception ex) {

        }
    }

    public void writeMsg(String msg) {
//        taAusgabe.(msg + "\n");
        Document doc = taAusgabe.getDocument();
        try {
            doc.insertString(doc.getLength(), msg + "\n", null);
        } catch (BadLocationException ex) {
            Logger.getLogger(Client_Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void userHinzu(String user) {
        System.out.println(user + " wurde hinzugefügt");
    }

    public void serverConnectionLost() {
        disonnectUser();
        JOptionPane.showMessageDialog(this, "Connection to server Lost :(, you were disconnected");
    }

    public void setName(String name) {
        this.name = name;
    }

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
            java.util.logging.Logger.getLogger(Client_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client_Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btExit;
    private javax.swing.JMenuItem btconnect;
    private javax.swing.JMenuItem btdisconnect;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> liLeute;
    private javax.swing.JEditorPane taAusgabe;
    private javax.swing.JTextField tfEIngabe;
    // End of variables declaration//GEN-END:variables
}
