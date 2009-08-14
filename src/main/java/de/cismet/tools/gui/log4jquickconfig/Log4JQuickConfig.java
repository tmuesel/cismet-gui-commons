/*
 * Log4JQuickConfig.java
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
 * Created on 7. November 2005, 14:19
 *
 */

package de.cismet.tools.gui.log4jquickconfig;

import java.awt.Color;
import java.util.Properties;

/**
 *
 * @author  thorsten.hell@cismet.de
 */
public class Log4JQuickConfig extends javax.swing.JFrame {
    
    /** Creates new form Log4JQuickConfig */
    public Log4JQuickConfig() {
        initComponents();
        gpnTitle.setLeftColor(new Color(49,66,122));
        gpnTitle.setRightColor(Color.white);
        this.getRootPane().setDefaultButton(cmdConfig);
        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        bgrWhat = new javax.swing.ButtonGroup();
        panConfig = new javax.swing.JPanel();
        panWhat = new javax.swing.JPanel();
        rdbDebug = new javax.swing.JRadioButton();
        rdbInfo = new javax.swing.JRadioButton();
        rdbWarn = new javax.swing.JRadioButton();
        rdbError = new javax.swing.JRadioButton();
        rdbFatal = new javax.swing.JRadioButton();
        rdbDisable = new javax.swing.JRadioButton();
        panWhere = new javax.swing.JPanel();
        chkSockets = new javax.swing.JCheckBox();
        lblHost = new javax.swing.JLabel();
        txtHost = new javax.swing.JTextField();
        lblPort = new javax.swing.JLabel();
        txtPort = new javax.swing.JTextField();
        chkFile = new javax.swing.JCheckBox();
        lblFile = new javax.swing.JLabel();
        txtFile = new javax.swing.JTextField();
        cmdFile = new javax.swing.JButton();
        chkConsole = new javax.swing.JCheckBox();
        panTitle = new javax.swing.JPanel();
        gpnTitle = new de.cismet.tools.gui.GradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        panButtons = new javax.swing.JPanel();
        cmdCancel = new javax.swing.JButton();
        cmdConfig = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        panConfig.setLayout(new java.awt.GridBagLayout());

        panConfig.setBorder(new javax.swing.border.EmptyBorder(new java.awt.Insets(3, 3, 3, 3)));
        panWhat.setLayout(new java.awt.GridBagLayout());

        panWhat.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.EmptyBorder(new java.awt.Insets(3, 3, 3, 3)), new javax.swing.border.TitledBorder("What")));
        bgrWhat.add(rdbDebug);
        rdbDebug.setSelected(true);
        rdbDebug.setText("Debug");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        panWhat.add(rdbDebug, gridBagConstraints);

        bgrWhat.add(rdbInfo);
        rdbInfo.setText("Info");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        panWhat.add(rdbInfo, gridBagConstraints);

        bgrWhat.add(rdbWarn);
        rdbWarn.setText("Warn");
        rdbWarn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbWarnActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        panWhat.add(rdbWarn, gridBagConstraints);

        bgrWhat.add(rdbError);
        rdbError.setText("Error");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        panWhat.add(rdbError, gridBagConstraints);

        bgrWhat.add(rdbFatal);
        rdbFatal.setText("Fatal");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        panWhat.add(rdbFatal, gridBagConstraints);

        bgrWhat.add(rdbDisable);
        rdbDisable.setText("Disable");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        panWhat.add(rdbDisable, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 1.0;
        panConfig.add(panWhat, gridBagConstraints);

        panWhere.setLayout(new java.awt.GridBagLayout());

        panWhere.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.EmptyBorder(new java.awt.Insets(3, 3, 3, 3)), new javax.swing.border.TitledBorder("Where")));
        chkSockets.setSelected(true);
        chkSockets.setText("Lumbermill");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 2, 0);
        panWhere.add(chkSockets, gridBagConstraints);

        lblHost.setText("Host:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 2, 0);
        panWhere.add(lblHost, gridBagConstraints);

        txtHost.setText("localhost");
        txtHost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHostActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 2, 9);
        panWhere.add(txtHost, gridBagConstraints);

        lblPort.setText("Port:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 2, 0);
        panWhere.add(lblPort, gridBagConstraints);

        txtPort.setText("4445");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 2, 9);
        panWhere.add(txtPort, gridBagConstraints);

        chkFile.setText("HTML - File");
        chkFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkFileActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 2, 0);
        panWhere.add(chkFile, gridBagConstraints);

        lblFile.setText("File:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 2, 0);
        panWhere.add(lblFile, gridBagConstraints);

        txtFile.setEnabled(false);
        txtFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFileActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 2, 9);
        panWhere.add(txtFile, gridBagConstraints);

        cmdFile.setText("...");
        cmdFile.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 3);
        panWhere.add(cmdFile, gridBagConstraints);

        chkConsole.setText("Console");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 2, 0);
        panWhere.add(chkConsole, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        panConfig.add(panWhere, gridBagConstraints);

        getContentPane().add(panConfig, java.awt.BorderLayout.CENTER);

        panTitle.setLayout(new java.awt.GridBagLayout());

        gpnTitle.setLayout(new java.awt.GridBagLayout());

        gpnTitle.setForeground(new java.awt.Color(236, 233, 216));
        gpnTitle.setLeftColor(new java.awt.Color(49, 66, 122));
        gpnTitle.setRightColor(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Courier", 1, 24));
        jLabel1.setForeground(new java.awt.Color(236, 233, 216));
        jLabel1.setText(" Log4J QuickConfig");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gpnTitle.add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 75.0;
        panTitle.add(gpnTitle, gridBagConstraints);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/cismet/tools/gui/log4jquickconfig/res/log4j.png")));
        jPanel3.add(jLabel2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        panTitle.add(jPanel3, gridBagConstraints);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.weighty = 1.0;
        panTitle.add(jPanel4, gridBagConstraints);

        getContentPane().add(panTitle, java.awt.BorderLayout.NORTH);

        panButtons.setLayout(new java.awt.GridBagLayout());

        cmdCancel.setText("Cancel");
        cmdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 4);
        panButtons.add(cmdCancel, gridBagConstraints);

        cmdConfig.setText("Config");
        cmdConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdConfigActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 7);
        panButtons.add(cmdConfig, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panButtons.add(jPanel1, gridBagConstraints);

        getContentPane().add(panButtons, java.awt.BorderLayout.SOUTH);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-532)/2, (screenSize.height-335)/2, 532, 335);
    }
    // </editor-fold>//GEN-END:initComponents

    private void chkFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkFileActionPerformed
           txtFile.setEnabled(chkFile.isSelected());
    }//GEN-LAST:event_chkFileActionPerformed

    private void cmdConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdConfigActionPerformed
        Properties p=new Properties();
        p.put("log4j.appender.Remote", "org.apache.log4j.net.SocketAppender");
        p.put("log4j.appender.Remote.remoteHost", txtHost.getText());
        p.put("log4j.appender.Remote.port", txtPort.getText());
        p.put("log4j.appender.Remote.locationInfo", "true");
        
        p.put("log4j.appender.File", "org.apache.log4j.FileAppender");
        p.put("log4j.appender.File.file", txtFile.getText());
        p.put("log4j.appender.File.layout", "org.apache.log4j.HTMLLayout");
        p.put("log4j.appender.File.append", "true");
        
        p.put("log4j.appender.cismetConsole", "org.apache.log4j.ConsoleAppender");
        p.put("log4j.appender.cismetConsole.layout", "org.apache.log4j.PatternLayout");
        p.put("log4j.appender.cismetConsole.layout.ConversionPattern", "%-5p [%t] - %m%n");
        
        String level="DEBUG";
        String target="";
        if (chkSockets.isSelected()) {
            target+="Remote,";
        }
        if (chkFile.isSelected()) {
            target+="File,";
        }
        if (chkConsole.isSelected()) {
            target+="cismetConsole,";
        }
        target=target.substring(0, target.length()-1);
        
        
        if (rdbInfo.isSelected()) {
            level="INFO";
        }
        else if (rdbWarn.isSelected()) {
            level="WARN";
        }
        else if (rdbError.isSelected()) {
            level="ERROR";
        }
        else if (rdbFatal.isSelected()) {
            level="FATAL";
        }
        else if (rdbDisable.isSelected()) {
            level="DISABLED";
        }
        
        p.put("log4j.rootLogger", level+","+target);
        org.apache.log4j.PropertyConfigurator.configure(p);
        this.hide();
    }//GEN-LAST:event_cmdConfigActionPerformed

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        this.hide();
    }//GEN-LAST:event_cmdCancelActionPerformed

    private void txtFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFileActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_txtFileActionPerformed

    private void txtHostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHostActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_txtHostActionPerformed

    private void rdbWarnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbWarnActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_rdbWarnActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Log4JQuickConfig.getSingletonInstance().setVisible(true);
            }
        });
    }
    
    private static Log4JQuickConfig log4jConfigurator=null;
    public static Log4JQuickConfig getSingletonInstance() {
        if (log4jConfigurator==null) {
            log4jConfigurator=new Log4JQuickConfig();
        }
        return log4jConfigurator;
    }
    
    public static void configure4LumbermillOnLocalhost() {
        Properties p=new Properties();
        p.put("log4j.appender.Remote", "org.apache.log4j.net.SocketAppender");
        p.put("log4j.appender.Remote.remoteHost","localhost");
        p.put("log4j.appender.Remote.port", "4445");
        p.put("log4j.appender.Remote.locationInfo", "true");
        p.put("log4j.rootLogger", "DEBUG,Remote");
        org.apache.log4j.PropertyConfigurator.configure(p);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgrWhat;
    private javax.swing.JCheckBox chkConsole;
    private javax.swing.JCheckBox chkFile;
    private javax.swing.JCheckBox chkSockets;
    private javax.swing.JButton cmdCancel;
    private javax.swing.JButton cmdConfig;
    private javax.swing.JButton cmdFile;
    private de.cismet.tools.gui.GradientPanel gpnTitle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblFile;
    private javax.swing.JLabel lblHost;
    private javax.swing.JLabel lblPort;
    private javax.swing.JPanel panButtons;
    private javax.swing.JPanel panConfig;
    private javax.swing.JPanel panTitle;
    private javax.swing.JPanel panWhat;
    private javax.swing.JPanel panWhere;
    private javax.swing.JRadioButton rdbDebug;
    private javax.swing.JRadioButton rdbDisable;
    private javax.swing.JRadioButton rdbError;
    private javax.swing.JRadioButton rdbFatal;
    private javax.swing.JRadioButton rdbInfo;
    private javax.swing.JRadioButton rdbWarn;
    private javax.swing.JTextField txtFile;
    private javax.swing.JTextField txtHost;
    private javax.swing.JTextField txtPort;
    // End of variables declaration//GEN-END:variables
    
}
