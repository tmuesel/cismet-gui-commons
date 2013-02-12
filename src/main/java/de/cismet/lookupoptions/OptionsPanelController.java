/***************************************************
*
* cismet GmbH, Saarbruecken, Germany
*
*              ... and it just works.
*
****************************************************/
package de.cismet.lookupoptions;

import javax.swing.JPanel;

import de.cismet.tools.configuration.Configurable;

/**
 * This class represents one panel in Options Dialog.
 *
 * @author   jruiz
 * @version  $Revision$, $Date$
 */
public interface OptionsPanelController extends Comparable<OptionsPanelController>, Configurable {

    //~ Methods ----------------------------------------------------------------

    /**
     * Returns the category of this options panel
     *
     * @return  category
     */
    Class<? extends OptionsCategory> getCategoryClass();

    /**
     * Returns the name of this options panel
     *
     * @return  name
     */
    String getName();

    /**
     * Returns the order-value of this options panel
     *
     * @return  order-value
     */
    int getOrder();

    /**
     * Returns the tooltip for this options panel
     *
     * @return  tooltip
     */
    String getTooltip();

    /**
     * Returns the help page (string containing html) for this options panel.
     *
     * @return  help page
     */
    String getHelp();

    /**
     * Returns the panel representing this Options
     *
     * @return  panel
     */
    JPanel getPanel();

    /**
     * This method is called when Options Dialog "OK" button is pressed.
     */
    void applyChanges();

    /**
     * Component should load its data here.
     */
    void update();

    /**
     * This method is called when Options Dialog "Cancel" button is pressed.
     */
    void cancel();

    /**
     * Should return true if some option value has been changed.
     *
     * @return  true if some option value has been changed
     */
    boolean isChanged();
}
