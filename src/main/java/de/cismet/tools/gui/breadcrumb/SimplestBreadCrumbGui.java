/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SimplestBreadCrumbGui.java
 *
 * Created on 07.11.2009, 21:18:58
 */
package de.cismet.tools.gui.breadcrumb;

import java.util.List;
import javax.swing.JButton;

/**
 *
 * @author thorsten
 */
public class SimplestBreadCrumbGui extends javax.swing.JPanel {

    private BreadCrumbModel breadCrumbModel = null;

    /** Creates new form SimplestBreadCrumbGui */
    public SimplestBreadCrumbGui() {
        initComponents();
        setBreadCrumbModel(new DefaultBreadCrumbModel());
    }

    public SimplestBreadCrumbGui(BreadCrumbModel breadCrumbModel) {
        this();
        setBreadCrumbModel(breadCrumbModel);
    }

    
    public void setBreadCrumbModel(BreadCrumbModel breadCrumbModel) {
        this.breadCrumbModel = breadCrumbModel;
        this.breadCrumbModel.addBreadCrumbModelListener(new AbstractBreadCrumbModelListener() {

            @Override
            public void breadCrumbModelChanged(BreadCrumbEvent bce) {
                SimplestBreadCrumbGui.this.removeAll();
                SimplestBreadCrumbGui.this.revalidate();
                BreadCrumbModel m = bce.getSource();
                List<BreadCrumb> l = m.getAllCrumbs();
                for (BreadCrumb bc : l) {
                    JButton bcButton = new JButton(bc);
                    SimplestBreadCrumbGui.this.add(bcButton);
                }

            }

            @Override
            public void breadCrumbAdded(BreadCrumbEvent bce) {
                JButton bcButton = new JButton(bce.getBreadCrumb());
                SimplestBreadCrumbGui.this.add(bcButton);
            }
        });
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(102, 255, 102));
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}