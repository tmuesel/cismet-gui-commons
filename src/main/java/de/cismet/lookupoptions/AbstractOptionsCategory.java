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
 * This class provides a skeletal implementation of the OptionsCategory interface to minimize the effort required to
 * implement this interface.
 *
 * @author   jruiz
 * @version  $Revision$, $Date$
 */
public abstract class AbstractOptionsCategory implements OptionsCategory {

    //~ Methods ----------------------------------------------------------------

    /**
     * Returns 32x32 icon used in list on the top of Options Dialog. Returns <code>null</code> by Default.
     * 
     * @return 32x32 icon
     */
    @Override
    public Icon getIcon() {
        return null;
    }

    /**
     * Returns name of category used in list on the top side of Options Dialog.
     * 
     * @return name of category
     */
    @Override
    public abstract String getName();

    /**
     * Returns the relative order of category in the Options Dialog. Returns {@link Integer#MAX_VALUE} by Default.
     * 
     * @return relative order
     */
    @Override
    public int getOrder() {
        return Integer.MAX_VALUE;
    }

    /**
     * DOCUMENT ME!
     *
     * @param   o  DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    @Override
    public int compareTo(final OptionsCategory o) {
        final int orderCompare = new Integer(getOrder()).compareTo(o.getOrder());
        if (orderCompare == 0) {
            return getName().compareTo(o.getName());
        } else {
            return orderCompare;
        }
    }

    /**
     * Returns text for tooltip describing the category. Returns <code>null</code> by Default.
     * 
     * @return tooltip text
     */
    @Override
    public String getTooltip() {
        return null;
    }
}
