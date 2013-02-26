/***************************************************
*
* cismet GmbH, Saarbruecken, Germany
*
*              ... and it just works.
*
****************************************************/
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cismet.tools.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

/**
 * Creates a point symbol as image.
 *
 * @author   haffkeatcismet
 * @version  $Revision$, $Date$
 */
public class PointSymbolCreator {

    //~ Methods ----------------------------------------------------------------

    /**
     * Creates a point symbol as image with the specified coords.
     *
     * @param   drawLine    If <code>true</code> draws the outline of the circle. Otherwise not.
     * @param   drawFill    If <code>true</code> draws the content of the circle.
     * @param   symbolSize  The size of the circle.
     * @param   lineWidth   The thickness of the outline of the circle.
     * @param   fillColor   The color of the content of the circle.
     * @param   lineColor   The color of the outline of the circle.
     *
     * @return  a point symbol
     */
    public static BufferedImage createPointSymbol(final boolean drawLine,
            final boolean drawFill,
            final int symbolSize,
            final int lineWidth,
            final Color fillColor,
            final Color lineColor) {
        final BufferedImage symbol = new BufferedImage((2 * lineWidth) + symbolSize,
                (2 * lineWidth)
                        + symbolSize,
                BufferedImage.TYPE_INT_ARGB);
        final Graphics2D g = (Graphics2D)symbol.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        final int x = (symbol.getWidth() / 2) - (symbolSize / 2);
        final int y = (symbol.getHeight() / 2) - (symbolSize / 2);
        if (drawFill) {
            g.setColor(fillColor);
            g.fillOval(x, y, symbolSize, symbolSize);
        }
        if (drawLine) {
            g.setColor(lineColor);
            g.setStroke(new BasicStroke(lineWidth));
            g.drawOval(x, y, symbolSize, symbolSize);
        }
        g.dispose();

        return symbol;
    }
}
