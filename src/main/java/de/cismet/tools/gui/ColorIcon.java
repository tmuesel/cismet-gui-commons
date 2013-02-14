/***************************************************
*
* cismet GmbH, Saarbruecken, Germany
*
*              ... and it just works.
*
****************************************************/
package de.cismet.tools.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Icon;

/**
 * An icon implementation which draws a rectangle with the specified color in the specified width and height.
 *
 * @author   jweintraut
 * @version  $Revision$, $Date$
 */
public class ColorIcon implements Icon {

    //~ Instance fields --------------------------------------------------------

    private final Color color;
    private final int height;
    private final int width;

    //~ Constructors -----------------------------------------------------------

    /**
     * Creates a new ColorIcon object.
     *
     * @param  color   The color to draw.
     * @param  height  The height of the icon.
     * @param  width   The width of the icon.
     */
    public ColorIcon(final Color color, final int height, final int width) {
        this.color = color;
        this.height = height;
        this.width = width;
    }

    //~ Methods ----------------------------------------------------------------

    /**
     * Draws the Icon at the specified location.
     *
     * @param  c  <code>null</code>; does not affect
     * @param  g  graphics used
     * @param  x  X-coordinate
     * @param  y  Y-coordinate
     */
    @Override
    public void paintIcon(final Component c, final Graphics g, final int x, final int y) {
        final Graphics2D g2d = (Graphics2D)g.create();

        g2d.setColor(color);
        g2d.fillRect(x, y, width, height);

        g2d.dispose();
    }

    /**
     * Returns the icon's width.
     *
     * @return  icon's wisth
     */
    @Override
    public int getIconWidth() {
        return width;
    }

    /**
     * Returns the icon's height.
     *
     * @return  icon's height.
     */
    @Override
    public int getIconHeight() {
        return height;
    }
}
