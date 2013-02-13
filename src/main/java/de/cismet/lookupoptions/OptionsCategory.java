/***************************************************
*
* cismet GmbH, Saarbruecken, Germany
*
*              ... and it just works.
*
****************************************************/
package de.cismet.lookupoptions;

import javax.swing.Icon;

/**
 * This class represents one category in the {@link de.cismet.lookupoptions.gui.OptionsDialog OptionsDialog}.
 *
 * @author   jruiz
 * @version  $Revision$, $Date$
 */
public interface OptionsCategory extends Comparable<OptionsCategory> {

    //~ Methods ----------------------------------------------------------------

    /**
     * Returns 32x32 icon used in list on the top of the {@link de.cismet.lookupoptions.gui.OptionsDialog OptionsDialog}.
     *
     * @return  32x32 icon
     */
    Icon getIcon();

    /**
     * Returns Name of category used in list on the top side of the
     * {@link de.cismet.lookupoptions.gui.OptionsDialog OptionsDialog}.
     *
     * @return  Name of category
     */
    String getName();

    /**
     * Returns the relative order of category in the the {@link de.cismet.lookupoptions.gui.OptionsDialog OptionsDialog}.
     *
     * @return  relative order
     */
    int getOrder();

    /**
     * Returns text for the tooltip describing the category.
     *
     * @return  tooltip text
     */
    String getTooltip();
}
