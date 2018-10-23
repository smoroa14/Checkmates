/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import bl.Loader;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 *
 * @author kevin
 */
public class DeckGUI extends javax.swing.JFrame {

    /**
     * Creates new form DeckGUI
     *
     */
    public DeckGUI() {
//        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        this.setUndecorated(true);
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        cb1 = new javax.swing.JComboBox<>();
        lb1 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        cb2 = new javax.swing.JComboBox<>();
        lb2 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        cb3 = new javax.swing.JComboBox<>();
        lb3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        cb4 = new javax.swing.JComboBox<>();
        lb4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        cb5 = new javax.swing.JComboBox<>();
        lb5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        cb6 = new javax.swing.JComboBox<>();
        lb6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        cb7 = new javax.swing.JComboBox<>();
        lb7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        cb8 = new javax.swing.JComboBox<>();
        lb8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new java.awt.GridLayout(1, 2));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jButton1.setText("Speichern");
        jPanel2.add(jButton1);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jButton2.setText("Abbrechen");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onAbbrechen(evt);
            }
        });
        jPanel2.add(jButton2);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Deck bearbeiten");
        getContentPane().add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0, 8, 0));

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.setLayout(new java.awt.BorderLayout());

        cb1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        cb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bauer", "Läufer", "Dame", "König", "Springer", "Turm", "Agent" }));
        cb1.setName("cb1"); // NOI18N
        cb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onSelect(evt);
            }
        });
        jPanel10.add(cb1, java.awt.BorderLayout.PAGE_END);

        lb1.setBackground(new java.awt.Color(255, 255, 255));
        lb1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BauerAvatar.png"))); // NOI18N
        lb1.setOpaque(true);
        jPanel10.add(lb1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel10);

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel9.setLayout(new java.awt.BorderLayout());

        cb2.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        cb2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bauer", "Läufer", "Dame", "König", "Springer", "Turm", "Agent" }));
        cb2.setName("cb2"); // NOI18N
        cb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onSelect(evt);
            }
        });
        jPanel9.add(cb2, java.awt.BorderLayout.PAGE_END);

        lb2.setBackground(new java.awt.Color(255, 255, 255));
        lb2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BauerAvatar.png"))); // NOI18N
        lb2.setOpaque(true);
        jPanel9.add(lb2, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel9);

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel8.setLayout(new java.awt.BorderLayout());

        cb3.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        cb3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bauer", "Läufer", "Dame", "König", "Springer", "Turm", "Agent" }));
        cb3.setName("cb3"); // NOI18N
        cb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onSelect(evt);
            }
        });
        jPanel8.add(cb3, java.awt.BorderLayout.PAGE_END);

        lb3.setBackground(new java.awt.Color(255, 255, 255));
        lb3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BauerAvatar.png"))); // NOI18N
        lb3.setOpaque(true);
        jPanel8.add(lb3, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel8);

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setLayout(new java.awt.BorderLayout());

        cb4.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        cb4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bauer", "Läufer", "Dame", "König", "Springer", "Turm", "Agent" }));
        cb4.setName("cb4"); // NOI18N
        cb4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onSelect(evt);
            }
        });
        jPanel7.add(cb4, java.awt.BorderLayout.PAGE_END);

        lb4.setBackground(new java.awt.Color(255, 255, 255));
        lb4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BauerAvatar.png"))); // NOI18N
        lb4.setOpaque(true);
        jPanel7.add(lb4, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel7);

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.setLayout(new java.awt.BorderLayout());

        cb5.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        cb5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bauer", "Läufer", "Dame", "König", "Springer", "Turm", "Agent" }));
        cb5.setName("cb5"); // NOI18N
        cb5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onSelect(evt);
            }
        });
        jPanel6.add(cb5, java.awt.BorderLayout.PAGE_END);

        lb5.setBackground(new java.awt.Color(255, 255, 255));
        lb5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BauerAvatar.png"))); // NOI18N
        lb5.setOpaque(true);
        jPanel6.add(lb5, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel6);

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(new java.awt.BorderLayout());

        cb6.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        cb6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bauer", "Läufer", "Dame", "König", "Springer", "Turm", "Agent" }));
        cb6.setName("cb6"); // NOI18N
        cb6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onSelect(evt);
            }
        });
        jPanel5.add(cb6, java.awt.BorderLayout.PAGE_END);

        lb6.setBackground(new java.awt.Color(255, 255, 255));
        lb6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BauerAvatar.png"))); // NOI18N
        lb6.setOpaque(true);
        jPanel5.add(lb6, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel5);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(new java.awt.BorderLayout());

        cb7.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        cb7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bauer", "Läufer", "Dame", "König", "Springer", "Turm", "Agent" }));
        cb7.setName("cb7"); // NOI18N
        cb7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onSelect(evt);
            }
        });
        jPanel4.add(cb7, java.awt.BorderLayout.PAGE_END);

        lb7.setBackground(new java.awt.Color(255, 255, 255));
        lb7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BauerAvatar.png"))); // NOI18N
        lb7.setOpaque(true);
        jPanel4.add(lb7, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel4);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new java.awt.BorderLayout());

        cb8.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        cb8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bauer", "Läufer", "Dame", "König", "Springer", "Turm", "Agent" }));
        cb8.setName("cb8"); // NOI18N
        cb8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onSelect(evt);
            }
        });
        jPanel3.add(cb8, java.awt.BorderLayout.PAGE_END);

        lb8.setBackground(new java.awt.Color(255, 255, 255));
        lb8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BauerAvatar.png"))); // NOI18N
        lb8.setOpaque(true);
        jPanel3.add(lb8, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onSelect(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onSelect
        JComboBox box = (JComboBox) evt.getSource();
        String unit = (String) box.getSelectedItem();
        String name = box.getName();
        String[] parts = name.split("");
        switch (parts[2]) {
            case "1":
                lb1.setIcon(Loader.loadImage(unit.toLowerCase() + "Avatar.png"));
                break;

            case "2":
                lb2.setIcon(Loader.loadImage(unit.toLowerCase() + "Avatar.png"));

                break;

            case "3":
                lb3.setIcon(Loader.loadImage(unit.toLowerCase() + "Avatar.png"));

                break;

            case "4":
                lb4.setIcon(Loader.loadImage(unit.toLowerCase() + "Avatar.png"));

                break;

            case "5":
                lb5.setIcon(Loader.loadImage(unit.toLowerCase() + "Avatar.png"));

                break;

            case "6":
                lb6.setIcon(Loader.loadImage(unit.toLowerCase() + "Avatar.png"));

                break;

            case "7":
                lb7.setIcon(Loader.loadImage(unit.toLowerCase() + "Avatar.png"));

                break;

            case "8":
                lb8.setIcon(Loader.loadImage(unit.toLowerCase() + "Avatar.png"));

                break;

        }
        System.out.println(name);
    }//GEN-LAST:event_onSelect

    private void onAbbrechen(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onAbbrechen
        this.dispose();
    }//GEN-LAST:event_onAbbrechen

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
            java.util.logging.Logger.getLogger(DeckGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeckGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeckGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeckGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeckGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb1;
    private javax.swing.JComboBox<String> cb2;
    private javax.swing.JComboBox<String> cb3;
    private javax.swing.JComboBox<String> cb4;
    private javax.swing.JComboBox<String> cb5;
    private javax.swing.JComboBox<String> cb6;
    private javax.swing.JComboBox<String> cb7;
    private javax.swing.JComboBox<String> cb8;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    private javax.swing.JLabel lb5;
    private javax.swing.JLabel lb6;
    private javax.swing.JLabel lb7;
    private javax.swing.JLabel lb8;
    // End of variables declaration//GEN-END:variables
}
