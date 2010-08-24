/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Tester.java
 *
 * Created on 05.11.2009, 22:14:50
 */
package de.cismet.tools.gui.breadcrumb;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author thorsten
 */
public class Tester extends javax.swing.JFrame {
    private final static String ICON="ICON";  //NOI18N
    ImageIcon a=new javax.swing.ImageIcon(getClass().getResource("/de/cismet/tools/gui/documents/documenttypeicons/avi.png"));  //NOI18N
    ImageIcon b=new javax.swing.ImageIcon(getClass().getResource("/de/cismet/tools/gui/documents/documenttypeicons/cdr.png"));  //NOI18N
    ImageIcon c=new javax.swing.ImageIcon(getClass().getResource("/de/cismet/tools/gui/documents/documenttypeicons/pdf.png"));  //NOI18N
    ImageIcon d=new javax.swing.ImageIcon(getClass().getResource("/de/cismet/tools/gui/documents/documenttypeicons/image.png")); //NOI18N
    HashMap<JPanel,ImageIcon> icons=new HashMap<JPanel, ImageIcon>();
    DefaultBreadCrumbModel model=new DefaultBreadCrumbModel();
    /** Creates new form Tester */
    public Tester() {
        initComponents();
        icons.put(panA, a);
        icons.put(panB, b);
        icons.put(panC, c);
        icons.put(panD, d);
        getContentPane().add(new LinkStyleBreadCrumbGui(model),BorderLayout.NORTH);
        getContentPane().add(new SimplestBreadCrumbGui(model),BorderLayout.SOUTH);
        setActivePanel(panA);



    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panA = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        panB = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        panC = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        panD = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        panActive = new javax.swing.JPanel();

        panA.setName("A"); // NOI18N

        jButton2.setText(org.openide.util.NbBundle.getMessage(Tester.class, "Tester.jButton2.text")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText(org.openide.util.NbBundle.getMessage(Tester.class, "Tester.jLabel1.text")); // NOI18N

        javax.swing.GroupLayout panALayout = new javax.swing.GroupLayout(panA);
        panA.setLayout(panALayout);
        panALayout.setHorizontalGroup(
            panALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
            .addGroup(panALayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addContainerGap())
        );
        panALayout.setVerticalGroup(
            panALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panALayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        panB.setName("B"); // NOI18N

        jLabel2.setText(org.openide.util.NbBundle.getMessage(Tester.class, "Tester.jLabel2.text")); // NOI18N

        jButton1.setText(org.openide.util.NbBundle.getMessage(Tester.class, "Tester.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText(org.openide.util.NbBundle.getMessage(Tester.class, "Tester.jButton3.text")); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panBLayout = new javax.swing.GroupLayout(panB);
        panB.setLayout(panBLayout);
        panBLayout.setHorizontalGroup(
            panBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                .addContainerGap())
        );
        panBLayout.setVerticalGroup(
            panBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3))
        );

        panC.setName("C"); // NOI18N

        jLabel3.setText(org.openide.util.NbBundle.getMessage(Tester.class, "Tester.jLabel3.text")); // NOI18N

        jButton4.setText(org.openide.util.NbBundle.getMessage(Tester.class, "Tester.jButton4.text")); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panCLayout = new javax.swing.GroupLayout(panC);
        panC.setLayout(panCLayout);
        panCLayout.setHorizontalGroup(
            panCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                .addContainerGap())
        );
        panCLayout.setVerticalGroup(
            panCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addContainerGap())
        );

        panD.setName("D"); // NOI18N

        jLabel4.setText(org.openide.util.NbBundle.getMessage(Tester.class, "Tester.jLabel4.text")); // NOI18N

        jButton5.setText(org.openide.util.NbBundle.getMessage(Tester.class, "Tester.jButton5.text")); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panDLayout = new javax.swing.GroupLayout(panD);
        panD.setLayout(panDLayout);
        panDLayout.setHorizontalGroup(
            panDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                .addContainerGap())
        );
        panDLayout.setVerticalGroup(
            panDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panActive.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panActive.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(265, Short.MAX_VALUE)
                .addComponent(panActive, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(253, 253, 253))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(panActive, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(148, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setActivePanel(panB);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setActivePanel(panC);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        setActivePanel(panD);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        setActivePanel(panD);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        setActivePanel(panA);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Tester().setVisible(true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panA;
    private javax.swing.JPanel panActive;
    private javax.swing.JPanel panB;
    private javax.swing.JPanel panC;
    private javax.swing.JPanel panD;
    // End of variables declaration//GEN-END:variables

    private void setActivePanel(final JPanel p) {
        panActive.removeAll();
        panActive.add(p, BorderLayout.CENTER);
        panActive.revalidate();
        this.repaint();

        BreadCrumb bc=new BreadCrumb(org.openide.util.NbBundle.getMessage(Tester.class, "Tester.setActivePanel(JPanel).bc.name", p.getName()),icons.get(p)) {  //NOI18N

            @Override
            public void crumbActionPerformed(ActionEvent e) {
                setActivePanel(p);
            }

        };
        model.appendCrumb(bc);
    }
}
