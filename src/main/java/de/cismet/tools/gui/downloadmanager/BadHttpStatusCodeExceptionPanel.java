/***************************************************
*
* cismet GmbH, Saarbruecken, Germany
*
*              ... and it just works.
*
****************************************************/
package de.cismet.tools.gui.downloadmanager;

import org.apache.log4j.Logger;

import org.openide.util.NbBundle;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import java.text.MessageFormat;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import de.cismet.security.exceptions.BadHttpStatusCodeException;

import de.cismet.tools.gui.StaticSwingTools;

/**
 * DOCUMENT ME!
 *
 * @author   jweintraut
 * @version  $Revision$, $Date$
 */
public class BadHttpStatusCodeExceptionPanel extends javax.swing.JPanel {

    //~ Static fields/initializers ---------------------------------------------

    private static final Logger LOG = Logger.getLogger(BadHttpStatusCodeExceptionPanel.class);

    //~ Instance fields --------------------------------------------------------

    private final BadHttpStatusCodeException exception;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCopyRequestedURIToClipboard;
    private javax.swing.JButton btnSaveResponse;
    private javax.swing.Box.Filler gluMain;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblHeaderReponse;
    private javax.swing.JLabel lblHeaderRequestedURI;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblMessage2;
    private javax.swing.JPanel pnlRequestedURI;
    private javax.swing.JPanel pnlServerResponse;
    private javax.swing.JScrollPane scpRequestedURI;
    private javax.swing.JToggleButton togDetails;
    private javax.swing.JTextArea txaRequestedURI;
    // End of variables declaration//GEN-END:variables

    //~ Constructors -----------------------------------------------------------

    /**
     * Creates new form BadHttpStatusCodeExceptionPanel.
     *
     * @param  exception  DOCUMENT ME!
     */
    public BadHttpStatusCodeExceptionPanel(final BadHttpStatusCodeException exception) {
        this.exception = exception;

        initComponents();

        pnlServerResponse.setVisible(false);
        pnlRequestedURI.setVisible(false);

        if (this.exception != null) {
            txaRequestedURI.setText(exception.getRequestedURI());
            lblMessage2.setText(MessageFormat.format(
                    lblMessage2.getText(),
                    exception.getStatuscode(),
                    exception.getMessage()));
        }
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

        togDetails = new javax.swing.JToggleButton();
        pnlServerResponse = new javax.swing.JPanel();
        btnSaveResponse = new javax.swing.JButton();
        lblHeaderReponse = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        pnlRequestedURI = new javax.swing.JPanel();
        lblHeaderRequestedURI = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnCopyRequestedURIToClipboard = new javax.swing.JButton();
        lblMessage = new javax.swing.JLabel();
        scpRequestedURI = new javax.swing.JScrollPane();
        txaRequestedURI = new javax.swing.JTextArea();
        lblMessage2 = new javax.swing.JLabel();
        gluMain = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0),
                new java.awt.Dimension(0, 0),
                new java.awt.Dimension(0, 32767));

        setLayout(new java.awt.GridBagLayout());

        togDetails.setText(org.openide.util.NbBundle.getMessage(
                BadHttpStatusCodeExceptionPanel.class,
                "BadHttpStatusCodeExceptionPanel.togDetails.text")); // NOI18N
        togDetails.setFocusPainted(false);
        togDetails.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(final java.awt.event.ActionEvent evt) {
                    togDetailsActionPerformed(evt);
                }
            });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(togDetails, gridBagConstraints);

        pnlServerResponse.setLayout(new java.awt.GridBagLayout());

        btnSaveResponse.setText(org.openide.util.NbBundle.getMessage(
                BadHttpStatusCodeExceptionPanel.class,
                "BadHttpStatusCodeExceptionPanel.btnSaveResponse.text")); // NOI18N
        btnSaveResponse.setFocusPainted(false);
        btnSaveResponse.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(final java.awt.event.ActionEvent evt) {
                    btnSaveResponseActionPerformed(evt);
                }
            });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlServerResponse.add(btnSaveResponse, gridBagConstraints);

        lblHeaderReponse.setText(org.openide.util.NbBundle.getMessage(
                BadHttpStatusCodeExceptionPanel.class,
                "BadHttpStatusCodeExceptionPanel.lblHeaderReponse.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlServerResponse.add(lblHeaderReponse, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        pnlServerResponse.add(jSeparator1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(pnlServerResponse, gridBagConstraints);

        pnlRequestedURI.setLayout(new java.awt.GridBagLayout());

        lblHeaderRequestedURI.setText(org.openide.util.NbBundle.getMessage(
                BadHttpStatusCodeExceptionPanel.class,
                "BadHttpStatusCodeExceptionPanel.lblHeaderRequestedURI.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlRequestedURI.add(lblHeaderRequestedURI, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        pnlRequestedURI.add(jSeparator2, gridBagConstraints);

        btnCopyRequestedURIToClipboard.setText(org.openide.util.NbBundle.getMessage(
                BadHttpStatusCodeExceptionPanel.class,
                "BadHttpStatusCodeExceptionPanel.btnCopyRequestedURIToClipboard.text")); // NOI18N
        btnCopyRequestedURIToClipboard.setFocusPainted(false);
        btnCopyRequestedURIToClipboard.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(final java.awt.event.ActionEvent evt) {
                    btnCopyRequestedURIToClipboardActionPerformed(evt);
                }
            });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlRequestedURI.add(btnCopyRequestedURIToClipboard, gridBagConstraints);

        lblMessage.setText(org.openide.util.NbBundle.getMessage(
                BadHttpStatusCodeExceptionPanel.class,
                "BadHttpStatusCodeExceptionPanel.lblMessage.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlRequestedURI.add(lblMessage, gridBagConstraints);

        scpRequestedURI.setBorder(null);

        txaRequestedURI.setBackground(javax.swing.UIManager.getDefaults().getColor("Panel.background"));
        txaRequestedURI.setColumns(20);
        txaRequestedURI.setEditable(false);
        txaRequestedURI.setLineWrap(true);
        txaRequestedURI.setRows(5);
        scpRequestedURI.setViewportView(txaRequestedURI);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlRequestedURI.add(scpRequestedURI, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(pnlRequestedURI, gridBagConstraints);

        lblMessage2.setText(org.openide.util.NbBundle.getMessage(
                BadHttpStatusCodeExceptionPanel.class,
                "BadHttpStatusCodeExceptionPanel.lblMessage2.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(lblMessage2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.1;
        add(gluMain, gridBagConstraints);
    }                                                                 // </editor-fold>//GEN-END:initComponents

    /**
     * DOCUMENT ME!
     *
     * @param  evt  DOCUMENT ME!
     */
    private void btnSaveResponseActionPerformed(final java.awt.event.ActionEvent evt) { //GEN-FIRST:event_btnSaveResponseActionPerformed
        final JFileChooser fileChooser = new JFileChooser();
        fileChooser.setSelectedFile(new File(System.getProperty("user.home"), "response.html"));

        final int returnVal = fileChooser.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            final File file = fileChooser.getSelectedFile();

            Writer writer = null;
            try {
                writer = new FileWriter(file);
                writer.write(exception.getResponse());
            } catch (final IOException ex) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Couldn't save following reponse to file '"
                                + ((file != null) ? file.getAbsolutePath() : "null") + "': '" + exception.getResponse()
                                + "'.",
                        ex);
                }
                JOptionPane.showMessageDialog(
                    StaticSwingTools.getParentFrameIfNotNull(this),
                    NbBundle.getMessage(
                        BadHttpStatusCodeExceptionPanel.class,
                        "BadHttpStatusCodeExceptionPanel.btnSaveResponseActionPerformed.JOptionPane.errorWhileSaving.message",
                        ex.getMessage()),
                    NbBundle.getMessage(
                        BadHttpStatusCodeExceptionPanel.class,
                        "BadHttpStatusCodeExceptionPanel.btnSaveResponseActionPerformed.JOptionPane.errorWhileSaving.title"),
                    JOptionPane.ERROR_MESSAGE);
            } finally {
                if (writer != null) {
                    try {
                        writer.close();
                    } catch (IOException ex) {
                    }
                }
            }
        }
    } //GEN-LAST:event_btnSaveResponseActionPerformed

    /**
     * DOCUMENT ME!
     *
     * @param  evt  DOCUMENT ME!
     */
    private void togDetailsActionPerformed(final java.awt.event.ActionEvent evt) { //GEN-FIRST:event_togDetailsActionPerformed
        pnlServerResponse.setVisible(togDetails.isSelected() && (exception != null) && (exception.getResponse() != null)
                    && !exception.getResponse().isEmpty());
        pnlRequestedURI.setVisible(togDetails.isSelected() && (exception != null)
                    && (exception.getRequestedURI() != null) && !exception.getRequestedURI().isEmpty());

//        lblRequestedURI.setMaximumSize(new Dimension(getWidth(), Integer.MAX_VALUE));

        StaticSwingTools.tryPackingMyParentDialog(this);
    } //GEN-LAST:event_togDetailsActionPerformed

    /**
     * DOCUMENT ME!
     *
     * @param  evt  DOCUMENT ME!
     */
    private void btnCopyRequestedURIToClipboardActionPerformed(final java.awt.event.ActionEvent evt) { //GEN-FIRST:event_btnCopyRequestedURIToClipboardActionPerformed
        Toolkit.getDefaultToolkit()
                .getSystemClipboard()
                .setContents(new StringSelection(exception.getRequestedURI()), null);
    }                                                                                                  //GEN-LAST:event_btnCopyRequestedURIToClipboardActionPerformed

    /**
     * DOCUMENT ME!
     *
     * @param  args  DOCUMENT ME!
     */
    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {

                @Override
                public void run() {
                    final JDialog dialog = new JDialog();
                    dialog.setContentPane(
                        new BadHttpStatusCodeExceptionPanel(
                            new BadHttpStatusCodeException(
                                "http://s102x283:8080/ASWeb/ASA_AAAWeb/ALKISBuchNachweis?nmless=5061756C612030352E31322E32303035204A75737475732032352E30372E323030382054616E6A612030362E31302E31393734&product=LB.GDBNRW.A.FNW.1&id=053001-001-00003/0002&user=3awup&password=3awup&service=Wuppertal",
                                404,
                                "Not Found",
                                "")));
                    dialog.setVisible(true);
                }
            });
    }
}
