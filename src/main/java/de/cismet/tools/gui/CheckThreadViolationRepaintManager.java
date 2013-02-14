/***************************************************
*
* cismet GmbH, Saarbruecken, Germany
*
*              ... and it just works.
*
****************************************************/
/*
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package de.cismet.tools.gui;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;

import javax.swing.*;

/**
 * <p>This class is used to detect Event Dispatch Thread rule violations<br>
 * See <a href="http://java.sun.com/docs/books/tutorial/uiswing/misc/threads.html">How to Use Threads</a> for more
 * info</p>
 *
 * <p>This is a modification of original idea of Scott Delap<br>
 * Initial version of ThreadCheckingRepaintManager can be found here<br>
 * <a href="http://www.clientjava.com/blog/2004/08/20/1093059428000.html">Easily Find Swing Threading Mistakes</a></p>
 *
 * @author   Scott Delap
 * @author   Alexander Potochkin
 *
 *           <p>https://swinghelper.dev.java.net/</p>
 * @version  $Revision$, $Date$
 */
public class CheckThreadViolationRepaintManager extends RepaintManager {

    //~ Static fields/initializers ---------------------------------------------

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(
            EventDispatchThreadHangMonitor.class);

    private static JButton test;

    //~ Instance fields --------------------------------------------------------

    // it is recommended to pass the complete check
    private boolean completeCheck = true;
    private WeakReference<JComponent> lastComponent;

    //~ Constructors -----------------------------------------------------------

    /**
     * Creates a new CheckThreadViolationRepaintManager object.
     */
    public CheckThreadViolationRepaintManager() {
        this(true);
    }

    /**
     * Creates a new CheckThreadViolationRepaintManager object.
     *
     * @param  completeCheck  indicates whether the complete check should be passed or not.
     */
    public CheckThreadViolationRepaintManager(final boolean completeCheck) {
        this.completeCheck = completeCheck;
    }

    //~ Methods ----------------------------------------------------------------

    /**
     * Checks whether the complete check should be passed or not.
     *
     * @return  <code>True</code>, if the complete check should be passed, otherwise return <code>false</code>.
     */
    public boolean isCompleteCheck() {
        return completeCheck;
    }

    /**
     * Sets {@link #completeCheck} to the given status.
     *
     * @param  completeCheck  status
     */
    public void setCompleteCheck(final boolean completeCheck) {
        this.completeCheck = completeCheck;
    }

    /**
     * Mark the component as in need of layout and queue a runnable for the event dispatching thread that will validate
     * the components first {@link JComponent#isValidateRoot()} ancestor.
     *
     * @param  component  Component to add to the list of invalid components.
     */
    @Override
    public synchronized void addInvalidComponent(final JComponent component) {
        checkThreadViolations(component);
        super.addInvalidComponent(component);
    }

    /**
     * Adds a compontent in the list of components that should be refreshed. If c already has a dirty region, the
     * rectangle (x,y,w,h) will be unioned with the region that should be redrawn. Before adding the compontent, the
     * method {@link #checkThreadViolations(javax.swing.JComponent) checks thread violations}.
     *
     * @param  component  Component to repaint, null results in nothing happening.
     * @param  x          coordinate of the region to repaint
     * @param  y          Y coordinate of the region to repaint
     * @param  w          Width of the region to repaint
     * @param  h          Height of the region to repaint
     */
    @Override
    public void addDirtyRegion(final JComponent component, final int x, final int y, final int w, final int h) {
        checkThreadViolations(component);
        super.addDirtyRegion(component, x, y, w, h);
    }

    /**
     * Checks whether the repaint is done within the Event Dispatch Thread, or not.
     *
     * @param  c  component to be checked
     *
     * @see    #violationFound(javax.swing.JComponent, java.lang.StackTraceElement[])
     */
    private void checkThreadViolations(final JComponent c) {
        if (!SwingUtilities.isEventDispatchThread() && (completeCheck || c.isShowing())) {
            boolean repaint = false;
            boolean fromSwing = false;
            boolean imageUpdate = false;
            final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            for (final StackTraceElement st : stackTrace) {
                if (repaint && st.getClassName().startsWith("javax.swing.")) { // NOI18N
                    fromSwing = true;
                }
                if (repaint && "imageUpdate".equals(st.getMethodName())) {     // NOI18N
                    imageUpdate = true;
                }
                if ("repaint".equals(st.getMethodName())) {                    // NOI18N
                    repaint = true;
                    fromSwing = false;
                }
            }
            if (imageUpdate) {
                // assuming it is java.awt.image.ImageObserver.imageUpdate(...)
                // image was asynchronously updated, that's ok
                return;
            }
            if (repaint && !fromSwing) {
                // no problems here, since repaint() is thread safe
                return;
            }
            // ignore the last processed component
            if ((lastComponent != null) && (c == lastComponent.get())) {
                return;
            }
            lastComponent = new WeakReference<JComponent>(c);
            violationFound(c, stackTrace);
        }
    }

    /**
     * If an Event Dispatch Thread Violation was found with {@link #checkThreadViolations(javax.swing.JComponent)}, logs
     * a fatal error to the logger.
     *
     * @param  c           Component, where the Event Dispatch Thread Violation was found
     * @param  stackTrace  Stacktrace to the Error[s]
     */
    protected void violationFound(final JComponent c, final StackTraceElement[] stackTrace) {
//        System.out.println();
//        System.out.println("EDT violation detected");
//        System.out.println(c);
//        for (StackTraceElement st : stackTrace) {
//            System.out.println("\tat " + st);
//        }

        final Throwable customThrowable = new Throwable() {

                @Override
                public StackTraceElement[] getStackTrace() {
                    return stackTrace;
                }
            };

        log.fatal("EDT violation detected for Component:" + c, customThrowable); // NOI18N
    }

    /**
     * main method for tests. Logger should get fatal message and stack trace while trying to invoke {#link #test()} the
     * second time.
     *
     * @param   args  command argument line
     *
     * @throws  Exception  throws Exception, if
     *                     {@link javax.swing.SwingUtilities#invokeAndWait(java.lang.Runnable) invoke and wait} fails.
     */
    public static void main(final String[] args) throws Exception {
        // set CheckThreadViolationRepaintManager
        RepaintManager.setCurrentManager(new CheckThreadViolationRepaintManager());
        // Valid code
        SwingUtilities.invokeAndWait(new Runnable() {

                @Override
                public void run() {
                    test();
                }
            });
        if (log.isDebugEnabled()) {
            log.debug("Valid code passed...");        // NOI18N
        }
        repaintTest();
        if (log.isDebugEnabled()) {
            log.debug("Repaint test - correct code"); // NOI18N
        }

        // Invalide code (stack trace expected)
        test();
    }

    /**
     * Test method.
     */
    static void test() {
        final JFrame frame = new JFrame("Am I on EDT?"); // NOI18N
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JButton("JButton"));               // NOI18N
        frame.pack();
        frame.setVisible(true);
        frame.dispose();
    }
    /**
     * this test must pass.
     */
    static void imageUpdateTest() {
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JEditorPane editor = new JEditorPane();
        frame.setContentPane(editor);
        editor.setContentType("text/html"); // NOI18N
        // it works with no valid image as well
        editor.setText("<html><img src=\"file:\\lala.png\"></html>"); // NOI18N
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
    /**
     * Test repaint method.
     */
    static void repaintTest() {
        try {
            SwingUtilities.invokeAndWait(new Runnable() {

                    @Override
                    public void run() {
                        test = new JButton();
                        test.setSize(100, 100);
                    }
                });
        } catch (Exception e) {
            e.printStackTrace();
        }
        // repaint(Rectangle) should be ok
        test.repaint(test.getBounds());
        test.repaint(0, 0, 100, 100);
        test.repaint();
    }
}
