/***************************************************
*
* cismet GmbH, Saarbruecken, Germany
*
*              ... and it just works.
*
****************************************************/
/*
 * GroovierConsole.java
 *
 * Created on 11. November 2006, 11:08
 */
package de.cismet.tools.groovysupport;

import groovy.inspect.swingui.ObjectBrowser;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;

import groovy.ui.Console;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;

import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JEditorPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;

import de.cismet.tools.gui.javakit.JavaContext;
import de.cismet.tools.gui.javakit.JavaEditorKit;
import de.cismet.tools.gui.javakit.Token;

/**
 * DOCUMENT ME!
 *
 * @author   thorsten.hell@cismet.de
 * @version  $Revision$, $Date$
 */
public class GroovierConsole extends javax.swing.JPanel {

    //~ Instance fields --------------------------------------------------------

    private Binding binding;
    private GroovyShell shell;
    private ObjectBrowser objectBrowser;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkEmptyBeforeRun;
    private javax.swing.JCheckBox chkStackTrace;
    private javax.swing.JEditorPane editor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextPane output;
    private javax.swing.JPanel panBottom;
    private javax.swing.JPanel panTop;
    private javax.swing.JScrollPane scpEditor;
    private javax.swing.JScrollPane scpOutput;
    // End of variables declaration//GEN-END:variables

    //~ Constructors -----------------------------------------------------------

    /**
     * Creates new form GroovierConsole.
     */
    public GroovierConsole() {
        initComponents();
        final JavaEditorKit kit = new JavaEditorKit();
        // GroovyKit gk=new GroovyKit();

        editor.setEditorKitForContentType("text/java", kit); // NOI18N
        editor.setContentType("text/java");                  // NOI18N
        // PENDING(prinz) This should have a customizer and
        // be serialized.  This is a bogus initialization.
        final JavaContext styles = kit.getStylePreferences();
        Style s;
        s = styles.getStyleForScanValue(Token.COMMENT.getScanValue());
        StyleConstants.setForeground(s, new Color(102, 153, 153));
        s = styles.getStyleForScanValue(Token.STRINGVAL.getScanValue());
        StyleConstants.setForeground(s, new Color(102, 153, 102));
        final Color keyword = new Color(102, 102, 255);
        for (int code = 70; code <= 130; code++) {
            s = styles.getStyleForScanValue(code);
            if (s != null) {
                StyleConstants.setForeground(s, keyword);
            }
        }
        objectBrowser = new ObjectBrowser();
        // panObjectBrowser.add(objectBrowser.get,BorderLayout.CENTER);
        binding = new Binding();

        final SimpleAttributeSet errorAttributeSet = new SimpleAttributeSet();
        StyleConstants.setForeground(errorAttributeSet, Color.red);
        final GuiStream gsErr = new GuiStream(System.err, output, errorAttributeSet, false);
        final GuiStream gsOut = new GuiStream(System.out, output, new SimpleAttributeSet(), false);
        System.setOut(gsOut);
        System.setErr(gsErr);
        shell = new GroovyShell(binding);
//        StaticSwingTools.setNiftyScrollBars(scpOutput);
//        StaticSwingTools.setNiftyScrollBars(scpEditor);
    }

    //~ Methods ----------------------------------------------------------------

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        jSplitPane1 = new javax.swing.JSplitPane();
        panTop = new javax.swing.JPanel();
        scpEditor = new javax.swing.JScrollPane();
        editor = new javax.swing.JEditorPane();
        panBottom = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        chkEmptyBeforeRun = new javax.swing.JCheckBox();
        chkStackTrace = new javax.swing.JCheckBox();
        scpOutput = new javax.swing.JScrollPane();
        output = new javax.swing.JTextPane();

        jSplitPane1.setDividerLocation(300);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        panTop.setLayout(new java.awt.BorderLayout());

        editor.addKeyListener(new java.awt.event.KeyAdapter() {

                @Override
                public void keyTyped(final java.awt.event.KeyEvent evt) {
                    editorKeyTyped(evt);
                }
            });
        scpEditor.setViewportView(editor);

        panTop.add(scpEditor, java.awt.BorderLayout.CENTER);

        jSplitPane1.setTopComponent(panTop);

        panBottom.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        chkEmptyBeforeRun.setSelected(true);
        chkEmptyBeforeRun.setText(org.openide.util.NbBundle.getMessage(
                GroovierConsole.class,
                "GroovierConsole.chkEmptyBeforeRun.text")); // NOI18N
        chkEmptyBeforeRun.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jPanel1.add(chkEmptyBeforeRun);

        chkStackTrace.setText(org.openide.util.NbBundle.getMessage(
                GroovierConsole.class,
                "GroovierConsole.chkStackTrace.text")); // NOI18N
        chkStackTrace.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jPanel1.add(chkStackTrace);

        panBottom.add(jPanel1, java.awt.BorderLayout.NORTH);

        output.setBackground(java.awt.SystemColor.control);
        output.setEditable(false);
        output.setPreferredSize(new java.awt.Dimension(800, 6));
        scpOutput.setViewportView(output);

        panBottom.add(scpOutput, java.awt.BorderLayout.CENTER);

        jSplitPane1.setRightComponent(panBottom);

        final org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING).add(
                jSplitPane1,
                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                542,
                Short.MAX_VALUE));
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING).add(
                jSplitPane1,
                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                422,
                Short.MAX_VALUE));
    } // </editor-fold>//GEN-END:initComponents

    /**
     * DOCUMENT ME!
     *
     * @param  evt  DOCUMENT ME!
     */
    private void editorKeyTyped(final java.awt.event.KeyEvent evt) { //GEN-FIRST:event_editorKeyTyped
        if ((evt.getKeyChar() == (KeyEvent.VK_ENTER)) && (evt.getModifiers() == KeyEvent.CTRL_MASK)) {
            if (chkEmptyBeforeRun.isSelected()) {
                output.setText("");                                  // NOI18N
            }
            try {
                shell.parse(editor.getText());
                final Object result = shell.evaluate(editor.getText());
                // objectBrowser.inspect(result);

                if (!chkEmptyBeforeRun.isSelected()) {
                    System.out.println("\n--"); // NOI18N
                }
            } catch (Throwable t) {
                if (chkStackTrace.isSelected()) {
                    t.printStackTrace();
                } else {
                    System.err.println(t);
                }
            }
        }
    }                                           //GEN-LAST:event_editorKeyTyped

    /**
     * DOCUMENT ME!
     *
     * @param  key       DOCUMENT ME!
     * @param  variable  DOCUMENT ME!
     */
    public void setVariable(final String key, final Object variable) {
        binding.setVariable(key, variable);
    }

    /**
     * DOCUMENT ME!
     *
     * @param  args  DOCUMENT ME!
     */
    public static void main(final String[] args) {
        try {
            final Console console = new Console();
            console.setVariable("var1", 99);
            console.setVariable("var2", "Hühnersuppe");
            console.run();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    //~ Inner Classes ----------------------------------------------------------

    /**
     * DOCUMENT ME!
     *
     * @version  $Revision$, $Date$
     */
    class GuiStream extends PrintStream {

        //~ Instance fields ----------------------------------------------------

        protected JEditorPane theGuiComponent;
        SimpleAttributeSet set = null;
        boolean logLastInput = false;
        long lastInput = -1;

        //~ Constructors -------------------------------------------------------

        /**
         * Creates a new GuiStream object.
         *
         * @param  out           DOCUMENT ME!
         * @param  component     DOCUMENT ME!
         * @param  set           DOCUMENT ME!
         * @param  logLastInput  DOCUMENT ME!
         */
        public GuiStream(final OutputStream out,
                final JEditorPane component,
                final SimpleAttributeSet set,
                final boolean logLastInput) {
            super(out);
            this.logLastInput = logLastInput;
            this.set = set;
            theGuiComponent = component;
        }

        //~ Methods ------------------------------------------------------------

        /**
         * DOCUMENT ME!
         *
         * @param  s  DOCUMENT ME!
         */
        @Override
        public void println(final String s) {
            if (logLastInput) {
                lastInput = System.currentTimeMillis();
            }
            final Runnable update = new Runnable() {

                    @Override
                    public void run() {
                        try {
                            theGuiComponent.getDocument()
                                    .insertString(theGuiComponent.getDocument().getLength(), s + "\n", set); // NOI18N
                        } catch (javax.swing.text.BadLocationException ble) {
                            // no printstacktrace possible else chain reaction
                        }
                        // theGuiComponent.setText(theGuiComponent.getText() + "\n<p>" + s+"<p>");
                    }
                };
            EventQueue.invokeLater(update);
        }

        /**
         * DOCUMENT ME!
         *
         * @return  DOCUMENT ME!
         */
        public long getLastInputTime() {
            return lastInput;
        }

        /**
         * DOCUMENT ME!
         *
         * @param  o  DOCUMENT ME!
         */
        @Override
        public void println(final Object o) {
            if (o == null) {
                println("null"); // NOI18N
            } else {
                println(o.toString());
            }
        }

        /**
         * DOCUMENT ME!
         *
         * @param  s  DOCUMENT ME!
         */
        @Override
        public void print(final String s) {
            if (logLastInput) {
                lastInput = System.currentTimeMillis();
            }
            final Runnable update = new Runnable() {

                    @Override
                    public void run() {
                        try {
                            theGuiComponent.getDocument()
                                    .insertString(theGuiComponent.getDocument().getLength(), s, set);
                        } catch (javax.swing.text.BadLocationException ble) {
                            // no printstacktrace possible else chain reaction
                        }
                        // theGuiComponent.setText(theGuiComponent.getText() + "\n<p>" + s+"<p>");
                    }
                };
            EventQueue.invokeLater(update);
        }

        /**
         * DOCUMENT ME!
         *
         * @param  d  DOCUMENT ME!
         */
        @Override
        public void print(final double d) {
            print(d + ""); // NOI18N
        }

        /**
         * DOCUMENT ME!
         *
         * @param  s  DOCUMENT ME!
         */
        @Override
        public void print(final char[] s) {
            print(new String(s));
        }

        /**
         * DOCUMENT ME!
         *
         * @param  c  DOCUMENT ME!
         */
        @Override
        public void print(final char c) {
            print(c + ""); // NOI18N
        }

        /**
         * DOCUMENT ME!
         *
         * @param  obj  DOCUMENT ME!
         */
        @Override
        public void print(final Object obj) {
            print(obj.toString());
        }

        /**
         * DOCUMENT ME!
         *
         * @param  f  DOCUMENT ME!
         */
        @Override
        public void print(final float f) {
            print(f + ""); // NOI18N
        }

        /**
         * DOCUMENT ME!
         *
         * @param  i  DOCUMENT ME!
         */
        @Override
        public void print(final int i) {
            print(i + ""); // NOI18N
        }

        /**
         * DOCUMENT ME!
         *
         * @param  b  DOCUMENT ME!
         */
        @Override
        public void print(final boolean b) {
            print(b + ""); // NOI18N
        }

        /**
         * DOCUMENT ME!
         *
         * @param  l  DOCUMENT ME!
         */
        @Override
        public void print(final long l) {
            print(l + ""); // NOI18N
        }
    }
}
