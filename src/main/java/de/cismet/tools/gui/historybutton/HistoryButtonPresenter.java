/*
 * HistoryButtonPresenter.java
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
 * Created on 20. Juli 2005, 14:02
 *
 */
package de.cismet.tools.gui.historybutton;

import java.io.IOException;
import java.net.URL;
import javax.swing.UIManager;

/**
 *
 * @author  thorsten.hell@cismet.de
 */
public class HistoryButtonPresenter extends javax.swing.JApplet {
    DefaultHistoryModel hm=new DefaultHistoryModel();
    JHistoryButton hbBack=null;
    JHistoryButton hbForward=null;
    
    /** Initializes the applet HistoryButtonPresenter */
    public void init() {
        try {
            java.awt.EventQueue.invokeAndWait(new Runnable() {
                public void run() {
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()) ;
                    } catch (Exception e) {

                    }
                    initComponents();

                    hbBack=JHistoryButton.getDefaultJHistoryButton(JHistoryButton.DIRECTION_BACKWARD, JHistoryButton.ICON_SIZE_16, hm);
                    hbForward=JHistoryButton.getDefaultJHistoryButton(JHistoryButton.DIRECTION_FORWARD, JHistoryButton.ICON_SIZE_16, hm);
                    toolBar.add(hbBack,0);
                    toolBar.add(hbForward,1);
                    hm.addHistoryModelListener(new HistoryModelListener(){
                        public void historyChanged() {
                            txtUrl.setText(hm.getCurrentElement().toString());
                        }

                        public void forwardStatusChanged() {
                        }

                        public void backStatusChanged() {
                        }
                        
                        public void historyActionPerformed() {}
                    });        
                    hm.addToHistory("http://www.google.de/");
                    
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    /** This method is called from within the init() method to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        toolBar = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        txtUrl = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        jLabel1.setText("Url: ");
        toolBar.add(jLabel1);

        txtUrl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUrlActionPerformed(evt);
            }
        });

        toolBar.add(txtUrl);

        getContentPane().add(toolBar, java.awt.BorderLayout.NORTH);

        jLabel2.setBackground(javax.swing.UIManager.getDefaults().getColor("ComboBox.selectionBackground"));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("<HTML>\n\n<center>\n\nNo, it's not a webbrowser in a webbrowser. <br><br>\n\nJust a demo for the history framework. <br>\n\nType in whatever you want, hit [ENTER] and watch the history. <br>\n\n<br>\n</center>\n<p>Have Fun<br><br></p>\n<center>\nThorsten\n</center>\n</HTML>");
        getContentPane().add(jLabel2, java.awt.BorderLayout.CENTER);

    }
    // </editor-fold>//GEN-END:initComponents

    private void txtUrlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUrlActionPerformed
        hm.addToHistory(txtUrl.getText());

    }//GEN-LAST:event_txtUrlActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JToolBar toolBar;
    private javax.swing.JTextField txtUrl;
    // End of variables declaration//GEN-END:variables
    
}