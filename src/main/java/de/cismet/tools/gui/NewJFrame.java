/*
 * NewJFrame.java
 * Copyright (C) 2005 by:
 *
 *----------------------------
 * cismet GmbH
 * Goebenstrasse 40
 * 66117 Saarbruecken
 * http://www.cismet.de
 *----------------------------
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 *----------------------------
 * Author:
 * thorsten.hell@cismet.de
 *----------------------------
 *
 * Created on 7. November 2005, 12:06
 *
 */

package de.cismet.tools.gui;

import java.util.Properties;

/**
 *
 * @author  thorsten.hell@cismet.de
 */
public class NewJFrame extends javax.swing.JFrame {
    private final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(this.getClass());
    
    /** Creates new form NewJFrame */
    public NewJFrame() {
        initComponents();
        configLog4J();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        buttonGroup1 = new javax.swing.ButtonGroup();
        cmdDebug = new javax.swing.JButton();
        cmdError = new javax.swing.JButton();
        cbxDebug = new javax.swing.JRadioButton();
        cbxError = new javax.swing.JRadioButton();
        cbxFatal = new javax.swing.JRadioButton();

        getContentPane().setLayout(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        cmdDebug.setText("Debug");
        cmdDebug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDebugActionPerformed(evt);
            }
        });

        getContentPane().add(cmdDebug);
        cmdDebug.setBounds(90, 160, 80, 23);

        cmdError.setText("Error");
        cmdError.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdErrorActionPerformed(evt);
            }
        });

        getContentPane().add(cmdError);
        cmdError.setBounds(180, 160, 80, 23);

        cbxDebug.setSelected(true);
        cbxDebug.setText("Debug");
        cbxDebug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDebugActionPerformed(evt);
            }
        });

        getContentPane().add(cbxDebug);
        cbxDebug.setBounds(140, 70, 180, 23);

        cbxError.setText("Error");
        cbxError.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxErrorActionPerformed(evt);
            }
        });

        getContentPane().add(cbxError);
        cbxError.setBounds(140, 90, 160, 23);

        cbxFatal.setText("Fatal");
        cbxFatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFatalActionPerformed(evt);
            }
        });

        getContentPane().add(cbxFatal);
        cbxFatal.setBounds(140, 110, 140, 23);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-408)/2, (screenSize.height-235)/2, 408, 235);
    }
    // </editor-fold>//GEN-END:initComponents

    private void cmdErrorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdErrorActionPerformed
        log.error("Error");
    }//GEN-LAST:event_cmdErrorActionPerformed

    private void cbxFatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFatalActionPerformed
        cbxDebug.setSelected(false);
        cbxError.setSelected(false);
        cbxFatal.setSelected(true);
        configLog4J();
    }//GEN-LAST:event_cbxFatalActionPerformed

    private void cbxErrorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxErrorActionPerformed
        cbxDebug.setSelected(false);
        cbxError.setSelected(true);
        cbxFatal.setSelected(false);
        configLog4J();
    }//GEN-LAST:event_cbxErrorActionPerformed

    private void cbxDebugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDebugActionPerformed
        cbxDebug.setSelected(true);
        cbxError.setSelected(false);
        cbxFatal.setSelected(false);
        configLog4J();
    }//GEN-LAST:event_cbxDebugActionPerformed

    private void cmdDebugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDebugActionPerformed
        log.debug("Debug");
    }//GEN-LAST:event_cmdDebugActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton cbxDebug;
    private javax.swing.JRadioButton cbxError;
    private javax.swing.JRadioButton cbxFatal;
    private javax.swing.JButton cmdDebug;
    private javax.swing.JButton cmdError;
    // End of variables declaration//GEN-END:variables
    
    private void configLog4J() {
        Properties p=new Properties();
        p.put("log4j.appender.Remote", "org.apache.log4j.net.SocketAppender");
        p.put("log4j.appender.Remote.remoteHost", "localhost");
        p.put("log4j.appender.Remote.port", "4445");
        p.put("log4j.appender.Remote.locationInfo", "true");

        if (cbxDebug.isSelected()) {
            p.put("log4j.rootLogger", "DEBUG,Remote");       
        }
        else if(cbxError.isSelected()) {
            p.put("log4j.rootLogger", "ERROR,Remote");       
        }
        else {
            p.put("log4j.rootLogger", "DEBUG,Remote");       
            p.put("log4j.rootLogger", "FATAL,Remote");       
        }
        org.apache.log4j.PropertyConfigurator.configure(p);
        
                        
    }
    
    
    
}