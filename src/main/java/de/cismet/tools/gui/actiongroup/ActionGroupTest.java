/***************************************************
*
* cismet GmbH, Saarbruecken, Germany
*
*              ... and it just works.
*
****************************************************/
package de.cismet.tools.gui.actiongroup;

import java.awt.event.ActionEvent;

import javax.swing.*;

/**
 * Test class for action group.
 *
 * @version  $Revision$, $Date$
 */
public class ActionGroupTest {

    //~ Methods ----------------------------------------------------------------

    /**
     * main method.
     *
     * @param  args  line of arguments
     */
    public static void main(final String[] args) {
        final Action a = new TestActionA("Test A"); // NOI18N
        final Action b = new TestActionB("Test B"); // NOI18N
        final Action c = new TestActionC("Test C"); // NOI18N
        final ActionGroup group = new ActionGroup();
        group.add(a);
        group.add(b);
        group.add(c);

        final JFrame frame = new JFrame();
        final JMenuBar menubar = new JMenuBar();
        final JMenu menu = new JMenu("Test"); // NOI18N
        menu.add(ComponentFactory.getRadioMenuItem(a));
        menu.add(ComponentFactory.getRadioMenuItem(b));
        menu.add(ComponentFactory.getRadioMenuItem(c));
        menubar.add(menu);
        frame.setJMenuBar(menubar);

        final JToolBar toolbar = new JToolBar();
        toolbar.add(ComponentFactory.getToggleButton(a));
        toolbar.add(ComponentFactory.getToggleButton(b));
        toolbar.add(ComponentFactory.getToggleButton(c));
        frame.getContentPane().add(toolbar);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    //~ Inner Classes ----------------------------------------------------------

    /**
     * Nested test class.
     *
     * @version  $Revision$, $Date$
     */
    private static class TestActionA extends AbstractAction {

        //~ Constructors -------------------------------------------------------

        /**
         * Creates a new TestActionA object.
         *
         * @param  name  name
         */
        public TestActionA(final String name) {
            super(name);
        }

        //~ Methods ------------------------------------------------------------

        /**
         * Overrides action listener for testing.
         *
         * @param  arg0  Action event
         */
        @Override
        public void actionPerformed(final ActionEvent arg0) {
            System.out.println("Test Action A was just turned on."); // NOI18N
        }
    }

    /**
     * Nested test class.
     *
     * @version  $Revision$, $Date$
     */
    private static class TestActionB extends AbstractAction {

        //~ Constructors -------------------------------------------------------

        /**
         * Creates a new TestActionB object.
         *
         * @param  name  name
         */
        public TestActionB(final String name) {
            super(name);
        }

        //~ Methods ------------------------------------------------------------

        /**
         * Overrides action listener for testing.
         *
         * @param  arg0  Action event
         */
        @Override
        public void actionPerformed(final ActionEvent arg0) {
            System.out.println("Test Action B was just turned on."); // NOI18N
        }
    }
    /**
     * Nested test class.
     *
     * @version  $Revision$, $Date$
     */
    private static class TestActionC extends AbstractAction {

        //~ Constructors -------------------------------------------------------

        /**
         * Creates a new TestActionC object.
         *
         * @param  name  name
         */
        public TestActionC(final String name) {
            super(name);
        }

        //~ Methods ------------------------------------------------------------

        /**
         * Overrides action listener for testing.
         *
         * @param  arg0  Action event
         */
        @Override
        public void actionPerformed(final ActionEvent arg0) {
            System.out.println("Test Action C was just turned on."); // NOI18N
        }
    }
}
