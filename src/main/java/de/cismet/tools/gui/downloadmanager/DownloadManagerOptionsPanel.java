/***************************************************
*
* cismet GmbH, Saarbruecken, Germany
*
*              ... and it just works.
*
****************************************************/
/*
 * DownloadManagerOptionsPanel.java
 *
 * Created on 09.08.2011, 15:10:48
 */
package de.cismet.tools.gui.downloadmanager;

import org.apache.log4j.Logger;

import org.jdom.Element;

import org.openide.util.NbBundle;
import org.openide.util.lookup.ServiceProvider;

import java.io.File;

import javax.swing.JFileChooser;

import de.cismet.lookupoptions.AbstractOptionsPanel;
import de.cismet.lookupoptions.OptionsPanelController;

import de.cismet.tools.BrowserLauncher;

import de.cismet.tools.configuration.NoWriteError;

/**
 * DOCUMENT ME!
 *
 * @author   jweintraut
 * @version  $Revision$, $Date$
 */
@ServiceProvider(service = OptionsPanelController.class)
public class DownloadManagerOptionsPanel extends AbstractOptionsPanel implements OptionsPanelController {

    //~ Static fields/initializers ---------------------------------------------

    private static final Logger LOG = Logger.getLogger(DownloadManagerOptionsPanel.class);

    private static final String OPTION_NAME = NbBundle.getMessage(
            DownloadManagerOptionsPanel.class,
            "DownloadManagerOptionsPanel.OPTION_NAME");

    //~ Instance fields --------------------------------------------------------

    private File downloadDestination;
    private boolean downloadDestinationChanged = false;
    private String jobname = "";
    private boolean askForJobtitle = true;
    private boolean openAutomatically = true;
    private boolean closeAutomatically = true;
    private int parallelDownloads = 2;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangeDownloadDestination;
    private javax.swing.JCheckBox chkAskForJobname;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private org.jdesktop.swingx.JXHyperlink jhlDownloadDestination;
    private javax.swing.JLabel lblCloseAutomatically;
    private javax.swing.JLabel lblDestinationDirectory;
    private javax.swing.JLabel lblJobname;
    private javax.swing.JLabel lblOpenAutomatically;
    private javax.swing.JLabel lblParallelDownloads;
    private javax.swing.JPanel pnlCloseAutomatically;
    private javax.swing.JPanel pnlOpenAutomatically;
    private javax.swing.JRadioButton rdoCloseAutomatically;
    private javax.swing.JRadioButton rdoDontCloseAutomatically;
    private javax.swing.JRadioButton rdoDontOpenAutomatically;
    private javax.swing.JRadioButton rdoOpenAutomatically;
    private javax.swing.ButtonGroup rgrCloseAutomatically;
    private javax.swing.ButtonGroup rgrOpenAutomatically;
    private javax.swing.JSpinner spnParallelDownloads;
    private javax.swing.JTextField txtJobname;
    // End of variables declaration//GEN-END:variables

    //~ Constructors -----------------------------------------------------------

    /**
     * Creates new form DownloadManagerOptionsPanel.
     */
    public DownloadManagerOptionsPanel() {
        super(OPTION_NAME, DownloadManagerOptionsCategory.class);

        initComponents();
    }

    //~ Methods ----------------------------------------------------------------

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        rgrOpenAutomatically = new javax.swing.ButtonGroup();
        fileChooser = new javax.swing.JFileChooser();
        rgrCloseAutomatically = new javax.swing.ButtonGroup();
        lblDestinationDirectory = new javax.swing.JLabel();
        jhlDownloadDestination = new org.jdesktop.swingx.JXHyperlink();
        btnChangeDownloadDestination = new javax.swing.JButton();
        lblJobname = new javax.swing.JLabel();
        txtJobname = new javax.swing.JTextField();
        chkAskForJobname = new javax.swing.JCheckBox();
        lblOpenAutomatically = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0),
                new java.awt.Dimension(0, 0),
                new java.awt.Dimension(32767, 32767));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0),
                new java.awt.Dimension(0, 0),
                new java.awt.Dimension(32767, 32767));
        pnlOpenAutomatically = new javax.swing.JPanel();
        rdoDontOpenAutomatically = new javax.swing.JRadioButton();
        rdoOpenAutomatically = new javax.swing.JRadioButton();
        lblCloseAutomatically = new javax.swing.JLabel();
        lblParallelDownloads = new javax.swing.JLabel();
        spnParallelDownloads = new javax.swing.JSpinner();
        pnlCloseAutomatically = new javax.swing.JPanel();
        rdoDontCloseAutomatically = new javax.swing.JRadioButton();
        rdoCloseAutomatically = new javax.swing.JRadioButton();

        fileChooser.setDialogTitle(org.openide.util.NbBundle.getMessage(
                DownloadManagerOptionsPanel.class,
                "DownloadManagerOptionsPanel.fileChooser.dialogTitle")); // NOI18N
        fileChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        setLayout(new java.awt.GridBagLayout());

        lblDestinationDirectory.setText(org.openide.util.NbBundle.getMessage(
                DownloadManagerOptionsPanel.class,
                "DownloadManagerOptionsPanel.lblDestinationDirectory.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(8, 3, 8, 10);
        add(lblDestinationDirectory, gridBagConstraints);

        jhlDownloadDestination.setText(org.openide.util.NbBundle.getMessage(
                DownloadManagerOptionsPanel.class,
                "DownloadManagerOptionsPanel.jhlDownloadDestination.text")); // NOI18N
        jhlDownloadDestination.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(final java.awt.event.ActionEvent evt) {
                    jhlDownloadDestinationActionPerformed(evt);
                }
            });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(8, 4, 8, 3);
        add(jhlDownloadDestination, gridBagConstraints);

        btnChangeDownloadDestination.setText(org.openide.util.NbBundle.getMessage(
                DownloadManagerOptionsPanel.class,
                "DownloadManagerOptionsPanel.btnChangeDownloadDestination.text")); // NOI18N
        btnChangeDownloadDestination.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(final java.awt.event.ActionEvent evt) {
                    btnChangeDownloadDestinationActionPerformed(evt);
                }
            });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        add(btnChangeDownloadDestination, gridBagConstraints);

        lblJobname.setText(org.openide.util.NbBundle.getMessage(
                DownloadManagerOptionsPanel.class,
                "DownloadManagerOptionsPanel.lblJobname.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(8, 3, 8, 10);
        add(lblJobname, gridBagConstraints);

        txtJobname.setText(org.openide.util.NbBundle.getMessage(
                DownloadManagerOptionsPanel.class,
                "DownloadManagerOptionsPanel.txtJobname.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(8, 4, 3, 3);
        add(txtJobname, gridBagConstraints);

        chkAskForJobname.setSelected(true);
        chkAskForJobname.setText(org.openide.util.NbBundle.getMessage(
                DownloadManagerOptionsPanel.class,
                "DownloadManagerOptionsPanel.chkAskForJobname.text")); // NOI18N
        chkAskForJobname.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 8, 3);
        add(chkAskForJobname, gridBagConstraints);

        lblOpenAutomatically.setText(org.openide.util.NbBundle.getMessage(
                DownloadManagerOptionsPanel.class,
                "DownloadManagerOptionsPanel.lblOpenAutomatically.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(8, 3, 8, 10);
        add(lblOpenAutomatically, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 1.0;
        add(filler1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(filler2, gridBagConstraints);

        pnlOpenAutomatically.setLayout(new java.awt.GridBagLayout());

        rgrOpenAutomatically.add(rdoDontOpenAutomatically);
        rdoDontOpenAutomatically.setText(org.openide.util.NbBundle.getMessage(
                DownloadManagerOptionsPanel.class,
                "DownloadManagerOptionsPanel.rdoDontOpenAutomatically.text")); // NOI18N
        rdoDontOpenAutomatically.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 0);
        pnlOpenAutomatically.add(rdoDontOpenAutomatically, gridBagConstraints);

        rgrOpenAutomatically.add(rdoOpenAutomatically);
        rdoOpenAutomatically.setSelected(true);
        rdoOpenAutomatically.setText(org.openide.util.NbBundle.getMessage(
                DownloadManagerOptionsPanel.class,
                "DownloadManagerOptionsPanel.rdoOpenAutomatically.text")); // NOI18N
        rdoOpenAutomatically.setFocusPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 3);
        pnlOpenAutomatically.add(rdoOpenAutomatically, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 8, 3);
        add(pnlOpenAutomatically, gridBagConstraints);

        lblCloseAutomatically.setText(org.openide.util.NbBundle.getMessage(
                DownloadManagerOptionsPanel.class,
                "DownloadManagerOptionsPanel.lblCloseAutomatically.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(8, 3, 8, 10);
        add(lblCloseAutomatically, gridBagConstraints);

        lblParallelDownloads.setText(org.openide.util.NbBundle.getMessage(
                DownloadManagerOptionsPanel.class,
                "DownloadManagerOptionsPanel.lblParallelDownloads.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(8, 3, 8, 10);
        add(lblParallelDownloads, gridBagConstraints);

        spnParallelDownloads.setModel(new javax.swing.SpinnerNumberModel(2, 1, 50, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(8, 4, 3, 3);
        add(spnParallelDownloads, gridBagConstraints);

        pnlCloseAutomatically.setLayout(new java.awt.GridBagLayout());

        rgrCloseAutomatically.add(rdoDontCloseAutomatically);
        rdoDontCloseAutomatically.setText(org.openide.util.NbBundle.getMessage(
                DownloadManagerOptionsPanel.class,
                "DownloadManagerOptionsPanel.rdoDontCloseAutomatically.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 0);
        pnlCloseAutomatically.add(rdoDontCloseAutomatically, gridBagConstraints);

        rgrCloseAutomatically.add(rdoCloseAutomatically);
        rdoCloseAutomatically.setSelected(true);
        rdoCloseAutomatically.setText(org.openide.util.NbBundle.getMessage(
                DownloadManagerOptionsPanel.class,
                "DownloadManagerOptionsPanel.rdoCloseAutomatically.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 3);
        pnlCloseAutomatically.add(rdoCloseAutomatically, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 8, 3);
        add(pnlCloseAutomatically, gridBagConstraints);
    } // </editor-fold>//GEN-END:initComponents

    /**
     * An event handler.
     *
     * @param  evt  The event.
     */
    private void btnChangeDownloadDestinationActionPerformed(final java.awt.event.ActionEvent evt) { //GEN-FIRST:event_btnChangeDownloadDestinationActionPerformed
        final int returnValue = fileChooser.showOpenDialog(this);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            downloadDestination = fileChooser.getSelectedFile();
            downloadDestinationChanged = true;
            jhlDownloadDestination.setText(downloadDestination.getAbsolutePath());
        }
    } //GEN-LAST:event_btnChangeDownloadDestinationActionPerformed

    /**
     * An event handler.
     *
     * @param  evt  The event.
     */
    private void jhlDownloadDestinationActionPerformed(final java.awt.event.ActionEvent evt) { //GEN-FIRST:event_jhlDownloadDestinationActionPerformed
        BrowserLauncher.openURLorFile(jhlDownloadDestination.getText());
    }                                                                                          //GEN-LAST:event_jhlDownloadDestinationActionPerformed

    @Override
    public void update() {
        downloadDestination = DownloadManager.instance().getDestinationDirectory();
        downloadDestinationChanged = false;
        jobname = DownloadManagerDialog.getJobname();
        askForJobtitle = DownloadManagerDialog.isAskForJobname();
        openAutomatically = DownloadManagerDialog.isOpenAutomatically();
        closeAutomatically = DownloadManagerDialog.isCloseAutomatically();
        parallelDownloads = DownloadManager.instance().getParallelDownloads();

        jhlDownloadDestination.setText(downloadDestination.getAbsolutePath());
        txtJobname.setText(jobname);
        chkAskForJobname.setSelected(askForJobtitle);
        rdoOpenAutomatically.setSelected(openAutomatically);
        rdoCloseAutomatically.setSelected(closeAutomatically);
        rdoDontOpenAutomatically.setSelected(!openAutomatically);
        spnParallelDownloads.setValue(parallelDownloads);
    }

    @Override
    public void applyChanges() {
        downloadDestinationChanged = false;
        jobname = txtJobname.getText();
        askForJobtitle = chkAskForJobname.isSelected();
        openAutomatically = rdoOpenAutomatically.isSelected();
        closeAutomatically = rdoCloseAutomatically.isSelected();
        parallelDownloads = (Integer)spnParallelDownloads.getValue();

        DownloadManager.instance().setDestinationDirectory(downloadDestination);
        DownloadManagerDialog.setJobname(jobname);
        DownloadManagerDialog.setAskForJobname(askForJobtitle);
        DownloadManagerDialog.setOpenAutomatically(openAutomatically);
        DownloadManagerDialog.setCloseAutomatically(closeAutomatically);
        DownloadManager.instance().setParallelDownloads(parallelDownloads);
    }

    @Override
    public boolean isChanged() {
        boolean result = false;

        if (jobname != null) {
            result = downloadDestinationChanged
                        || (!jobname.equals(txtJobname.getText()))
                        || (!askForJobtitle == chkAskForJobname.isSelected())
                        || (!openAutomatically == rdoOpenAutomatically.isSelected())
                        || (!closeAutomatically == rdoCloseAutomatically.isSelected())
                        || (parallelDownloads != ((Integer)spnParallelDownloads.getValue()).intValue());
        }

        return result;
    }

    @Override
    public String getTooltip() {
        return "";
    }

    @Override
    public Element getConfiguration() throws NoWriteError {
        return DownloadManager.instance().getConfiguration();
    }

    @Override
    public void configure(final Element parent) {
        DownloadManager.instance().configure(parent);
    }

    @Override
    public void masterConfigure(final Element parent) {
        DownloadManager.instance().masterConfigure(parent);
    }
}