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
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;

import javax.swing.Icon;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * Creates icons with vertical text.
 *
 * @version  $Revision$, $Date$
 */
public class VerticalTextIcon implements Icon, SwingConstants {

    //~ Instance fields --------------------------------------------------------

    private Font font = UIManager.getFont("Label.font"); // NOI18N
    private FontMetrics fm = Toolkit.getDefaultToolkit().getFontMetrics(font);

    private String text;
    private int width;
    private int height;
    private boolean clockwize;
    private Color color;

    //~ Constructors -----------------------------------------------------------

    /**
     * Creates a new VerticalTextIcon object.
     *
     * @param  text       text
     * @param  clockwize  If <code>true</code> the text is written from top to bottom. Otherwise from bottom to top.
     */
    public VerticalTextIcon(final String text, final boolean clockwize) {
        this(text, clockwize, Color.black);
    }
    /**
     * Creates a new VerticalTextIcon object.
     *
     * @param  text       text
     * @param  clockwize  If <code>true</code> the text is written from top to bottom. Otherwise from bottom to top.
     * @param  color      color of the text
     */
    public VerticalTextIcon(final String text, final boolean clockwize, final Color color) {
        this.text = text;
        width = SwingUtilities.computeStringWidth(fm, text) + 2;
        height = fm.getHeight();
        this.clockwize = clockwize;
        this.color = color;
    }

    //~ Methods ----------------------------------------------------------------

    /**
     * Paints the icon with vertical text.
     *
     * @param  c  component
     * @param  g  graphics
     * @param  x  X coordinate
     * @param  y  Y coordinate
     */
    @Override
    public void paintIcon(final Component c, final Graphics g, final int x, final int y) {
        final Graphics2D g2 = (Graphics2D)g;
        final Font oldFont = g.getFont();
        final Color oldColor = g.getColor();
        final AffineTransform oldTransform = g2.getTransform();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g.setFont(font);
        g.setColor(color);
        if (clockwize) {
            g2.translate(x + getIconWidth(), y);
            g2.rotate(Math.PI / 2);
        } else {
            g2.translate(x, y + getIconHeight());
            g2.rotate(-Math.PI / 2);
        }
        g.drawString(text, 0, fm.getLeading() + fm.getAscent());

        g.setFont(oldFont);
        g.setColor(oldColor);
        g2.setTransform(oldTransform);
    }

    /**
     * Returns the icon height.
     *
     * @return  icon height
     */
    @Override
    public int getIconWidth() {
        return height;
    }

    /**
     * Returns the icon width.
     *
     * @return  icon width
     */
    @Override
    public int getIconHeight() {
        return width;
    }
}
