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
 * This class provides a skeletal implementation of the {@link de.cismet.lookupoptions.OptionsCategory} interface to
 * minimize the effort required to implement this interface.
 *
 * @author   jruiz
 * @version  $Revision$, $Date$
 */
public abstract class AbstractOptionsCategory implements OptionsCategory {

    //~ Methods ----------------------------------------------------------------

    /**
     * Returns 32x32 icon used in list on the top of {@link de.cismet.lookupoptions.gui.OptionsDialog OptionsDialog}.
     * Returns <code>null</code> by default.
     *
     * @return  32x32 icon
     */
    @Override
    public Icon getIcon() {
        return null;
    }

    /**
     * Returns name of category used in list on the top side of the
     * {@link de.cismet.lookupoptions.gui.OptionsDialog OptionsDialog}.
     *
     * @return  name of category
     */
    @Override
    public abstract String getName();

    /**
     * Returns the relative order of category in the {@link de.cismet.lookupoptions.gui.OptionsDialog OptionsDialog}.
     * Returns {@link Integer#MAX_VALUE} by default.
     *
     * @return  relative order
     */
    @Override
    public int getOrder() {
        return Integer.MAX_VALUE;
    }

    /**
     * Compares the given {@link de.cismet.lookupoptions.OptionsCategory} with this <code>OptionCategory</code>. First
     * compares the <code>order</code> values of the <code>OptionCategories</code>. If they are equal compares the
     * <code>name</code> values.
     *
     * @param   o  <code>OptionCategory</code> to compare to
     *
     * @return  Zero, if they are equal. Otherwise negative or positive values.
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
     * Returns text for tooltip describing the category. Returns <code>null</code> by default.
     *
     * @return  tooltip text
     */
    @Override
    public String getTooltip() {
        return null;
    }
}
