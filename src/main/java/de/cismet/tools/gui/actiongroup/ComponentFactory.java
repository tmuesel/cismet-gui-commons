/***************************************************
*
* cismet GmbH, Saarbruecken, Germany
*
*              ... and it just works.
*
****************************************************/
package de.cismet.tools.gui.actiongroup;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JToggleButton;
/**
 * A factory that returns components associated with actions within the action group.
 *
 * @version  $Revision$, $Date$
 */
public final class ComponentFactory {

    //~ Constructors -----------------------------------------------------------

    /**
     * Creates a new ComponentFactory object.
     */
    private ComponentFactory() {
    }

    //~ Methods ----------------------------------------------------------------

    /**
     * Returns {@link javax.swing.JRadioButton} connected with the given action.
     *
     * @param   action  Action
     *
     * @return  <code>JRadioButton</code>
     */
    public static AbstractButton getRadioButton(final Action action) {
        final JRadioButton button = new JRadioButton(action);
        connectActionAndButton(action, button);
        return button;
    }

    /**
     * Returns a {@link javax.swing.JToggleButton} connected with the given action.
     *
     * @param   action  Action
     *
     * @return  <code>JToggleButton</code>
     */
    public static AbstractButton getToggleButton(final Action action) {
        final JToggleButton button = new JToggleButton(action);
        connectActionAndButton(action, button);
        return button;
    }

    /**
     * Returns a {@link javax.swing.JRadioButtonMenuItem} connected with the given action.
     *
     * @param   action  Action
     *
     * @return  <code>JRadioButtonMenuItem</code>
     */
    public static JMenuItem getRadioMenuItem(final Action action) {
        final JRadioButtonMenuItem menu = new JRadioButtonMenuItem(action);
        connectActionAndButton(action, menu);
        return menu;
    }

    /**
     * Connects the given action with the given button.
     *
     * @param  action  Action
     * @param  button  Button
     */
    private static void connectActionAndButton(final Action action, final AbstractButton button) {
        final SelectionStateAdapter adapter = new SelectionStateAdapter(action, button);
        adapter.configure();
    }

    //~ Inner Classes ----------------------------------------------------------

    /**
     * Class that connects the selection state of the action to the selection state of the button.
     *
     * @author   R.J. Lorimer
     * @version  $Revision$, $Date$
     */
    private static class SelectionStateAdapter implements PropertyChangeListener, ItemListener {

        //~ Instance fields ----------------------------------------------------

        private Action action;
        private AbstractButton button;

        //~ Constructors -------------------------------------------------------

        /**
         * Creates a new SelectionStateAdapter object.
         *
         * @param  theAction  Action
         * @param  theButton  Button
         */
        public SelectionStateAdapter(final Action theAction, final AbstractButton theButton) {
            action = theAction;
            button = theButton;
        }

        //~ Methods ------------------------------------------------------------

        /**
         * Configures the connection of the state of the action and the state of the button.
         */
        protected void configure() {
            action.addPropertyChangeListener(this);
            button.addItemListener(this);
        }
        /**
         * Change the selected state. invokes if the selected status of the item changes.
         *
         * @param  e  item event
         */
        @Override
        public void itemStateChanged(final ItemEvent e) {
            final boolean value = e.getStateChange() == ItemEvent.SELECTED;
            final Boolean valueObj = Boolean.valueOf(value);
            action.putValue(ActionConstants.SELECTED_KEY, valueObj);
        }

        /**
         * This method gets called when a bound property is changed.
         *
         * @param  evt  A PropertyChangeEvent object describing the event source and the property that has changed.
         */
        @Override
        public void propertyChange(final PropertyChangeEvent evt) {
            if (evt.getPropertyName().equals(ActionConstants.SELECTED_KEY)) {
                final Boolean newSelectedState = (Boolean)evt.getNewValue();
                button.setSelected(newSelectedState.booleanValue());
            }
        }
    }
}
