/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fameg.gui;

/**
 *
 * @author Allan
 */
public class JanelaUm extends javax.swing.JFrame {

    /**
     * Creates new form JanelaUm
     */
    public JanelaUm() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btCriar = new javax.swing.JButton();
        btAbrir = new javax.swing.JButton();
        lbTitulo = new javax.swing.JLabel();
        lbCriar = new javax.swing.JLabel();
        lbAbrir = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 153), 3, true));

        btCriar.setText("Criar");
        btCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCriarActionPerformed(evt);
            }
        });

        btAbrir.setText("Abrir");
        btAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAbrirActionPerformed(evt);
            }
        });

        lbTitulo.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lbTitulo.setText("Bem Vindos Ao Gram-Cruzada-o-Maker 6000!");

        lbCriar.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lbCriar.setText("Clique em \"Criar\" para criar um novo banco de palavras.");

        lbAbrir.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lbAbrir.setText("Clique em \"Abrir\" para abrir um banco previamente criado.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTitulo)
                    .addComponent(lbCriar)
                    .addComponent(btCriar)
                    .addComponent(lbAbrir)
                    .addComponent(btAbrir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitulo)
                .addGap(52, 52, 52)
                .addComponent(lbCriar)
                .addGap(26, 26, 26)
                .addComponent(btCriar)
                .addGap(26, 26, 26)
                .addComponent(lbAbrir)
                .addGap(33, 33, 33)
                .addComponent(btAbrir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAbrirActionPerformed
        // TODO add your handling code here:
        LeitorDeCruzadinha leitor = new LeitorDeCruzadinha();
        leitor.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btAbrirActionPerformed

    private void btCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCriarActionPerformed
        // TODO add your handling code here:
        CriadorDeBanco criar = new CriadorDeBanco();
        criar.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btCriarActionPerformed

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
            java.util.logging.Logger.getLogger(JanelaUm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaUm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaUm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaUm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaUm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAbrir;
    private javax.swing.JButton btCriar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbAbrir;
    private javax.swing.JLabel lbCriar;
    private javax.swing.JLabel lbTitulo;
    // End of variables declaration//GEN-END:variables
}
