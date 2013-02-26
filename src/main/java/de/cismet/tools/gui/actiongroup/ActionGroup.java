/***************************************************
*
* cismet GmbH, Saarbruecken, Germany
*
*              ... and it just works.
*
****************************************************/
package de.cismet.tools.gui.actiongroup;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Action;

/**
 * DOCUMENT ME!
 *
 * @author   thorsten.hell@cismet.de
 * @version  $Revision$, $Date$
 */
public class ActionGroup {

    //~ Instance fields --------------------------------------------------------

    private List actions;
    private boolean notifyLock;
    private PropertyChangeListener selectedListener;

    //~ Constructors -----------------------------------------------------------

    /**
     * Creates a new ActionGroup object.
     */
    public ActionGroup() {
        actions = new ArrayList();
        selectedListener = new SelectedListener();
    }

    //~ Methods ----------------------------------------------------------------

    /**
     * Adds the given action to the action group and the property change listener.
     *
     * @param  action  action to be added
     */
    public void add(final Action action) {
        actions.add(action);
        action.addPropertyChangeListener(selectedListener);
    }

    /**
     * Removes the given action from the action group and the property change listener.
     *
     * @param  action  DOCUMENT ME!
     */
    public void remove(final Action action) {
        actions.remove(action);
        action.removePropertyChangeListener(selectedListener);
    }
    /**
     * Returns a array list of all actions inside this group.
     *
     * @return  array list of all actions
     */
    public List getActions() {
        return new ArrayList(actions);
    }

    //~ Inner Classes ----------------------------------------------------------

    /**
     * Property change listener.
     *
     * @version  $Revision$, $Date$
     */
    private class SelectedListener implements PropertyChangeListener {

        //~ Methods ------------------------------------------------------------

        /**
         * This method gets called when a bound property is changed.
         *
         * @param  evt  A PropertyChangeEvent object describing the event source and the property that has changed.
         */
        @Override
        public void propertyChange(final PropertyChangeEvent evt) {
            // prevent any poorly implemented components from
            // causing us to get stuck in a feedback loop.
            if (notifyLock) {
                return;
            }

            // If it isn't a selected key change, or
            // someone set it to false we just avoid doing anything.
            if (evt.getPropertyName().equals(ActionConstants.SELECTED_KEY) && evt.getNewValue().equals(Boolean.TRUE)) {
                try {
                    notifyLock = true;
                    for (int i = 0; i < actions.size(); i++) {
                        final Action action = (Action)actions.get(i);
                        if (!action.equals(evt.getSource())) {
                            action.putValue(ActionConstants.SELECTED_KEY, Boolean.FALSE);
                        }
                    }
                } finally {
                    notifyLock = false;
                }
            }
        }
    }
}
