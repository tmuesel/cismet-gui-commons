/***************************************************
*
* cismet GmbH, Saarbruecken, Germany
*
*              ... and it just works.
*
****************************************************/
package de.cismet.tools.gui;

import java.awt.Color;

import javax.swing.JRadioButtonMenuItem;

/**
 * Extended {@link javax.swing.JRadioButtonMenuItem}, which is highlighted if it is selected.
 *
 * @author   jweintraut
 * @version  $Revision$, $Date$
 */
public class HighlightingRadioButtonMenuItem extends JRadioButtonMenuItem {

    //~ Static fields/initializers ---------------------------------------------

    private static JRadioButtonMenuItem bsp = new JRadioButtonMenuItem("white");

    //~ Instance fields --------------------------------------------------------

    private Color selectedBackgroundColor;
    private Color selectedForegroundColor;
    private Color normalBackgroundColor;
    private Color normalForegroundColor;

    //~ Constructors -----------------------------------------------------------

    /**
     * Creates a new HighlightingRadioButtonMenuItem object with given highlighting colors.
     *
     * @param  selectedBackgroundColor  highlighted background color
     * @param  selectedForegroundColor  highlighted foreground color
     */
    public HighlightingRadioButtonMenuItem(
            final Color selectedBackgroundColor,
            final Color selectedForegroundColor) {
        this.selectedBackgroundColor = selectedBackgroundColor;
        this.selectedForegroundColor = selectedForegroundColor;
        normalBackgroundColor = bsp.getBackground();
        normalForegroundColor = bsp.getForeground();
    }

    //~ Methods ----------------------------------------------------------------

    /**
     * Checks whether the radiobutton is selected, or not, and returns the highlighted background color, if it is
     * selected. Otherwise it returns the normal background color.
     *
     * @return  highlighted background color, if the checkbox is selected. Otherwise the normal background color.
     */
    @Override
    public Color getBackground() {
        if (isSelected()) {
            return selectedBackgroundColor;
        } else {
            return normalBackgroundColor;
        }
    }

    /**
     * Checks whether the radiobutton is selected, or not, and returns the highlighted foreground color, if it is
     * selected. Otherwise it returns the normal foreground color.
     *
     * @return  highlighted foreground color, if the checkbox is selected. Otherwise the normal foreground color.
     */
    @Override
    public Color getForeground() {
        if (isSelected()) {
            return selectedForegroundColor;
        } else {
            return normalForegroundColor;
        }
    }

    /**
     * Returns the highlighted background color.
     *
     * @return  highlighted background color
     */
    public Color getSelectedBackgroundColor() {
        return selectedBackgroundColor;
    }

    /**
     * Sets the highlighted background color.
     *
     * @param  selectedBackgroundColor  highlighted background color
     */
    public void setSelectedBackgroundColor(final Color selectedBackgroundColor) {
        this.selectedBackgroundColor = selectedBackgroundColor;
    }

    /**
     * Returns the highlighted foreground color.
     *
     * @return  highlighted foreground color
     */
    public Color getSelectedForegroundColor() {
        return selectedForegroundColor;
    }

    /**
     * Sets the highlighted foreground color.
     *
     * @param  selectedForegroundColor  highlighted foreground color
     */
    public void setSelectedForegroundColor(final Color selectedForegroundColor) {
        this.selectedForegroundColor = selectedForegroundColor;
    }
}
