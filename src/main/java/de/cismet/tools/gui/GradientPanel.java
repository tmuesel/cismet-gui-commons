/***************************************************
*
* cismet GmbH, Saarbruecken, Germany
*
*              ... and it just works.
*
****************************************************/
/*
 * GradientPanel.java
 *
 * Created on 16. Dezember 2004, 13:31
 */
package de.cismet.tools.gui;
import java.awt.*;
import java.awt.Color;
/**
 * JPanel with gradient background. The gradient effect goes from left to right.
 *
 * @author   hell
 * @version  $Revision$, $Date$
 */
public class GradientPanel extends javax.swing.JPanel {

    //~ Instance fields --------------------------------------------------------

    private Color leftColor = Color.GRAY;
    private Color rightColor = Color.WHITE;

    //~ Constructors -----------------------------------------------------------

    /**
     * Creates a new instance of GradientPanel with the left color set to the background color of this panel and with
     * the right color set to the foreground color of this panel.
     */
    public GradientPanel() {
        setLeftColor(this.getBackground());
        setRightColor(this.getForeground());
    }

    /**
     * Creates a new instance of GradientPanel with the colors set to the given colors.
     *
     * @param  leftColor   Left Farbe
     * @param  rightColor  Right Farbe
     */
    public GradientPanel(final Color leftColor, final Color rightColor) {
        this.setLeftColor(leftColor);
        this.setRightColor(rightColor);
    }

    //~ Methods ----------------------------------------------------------------

    /**
     * Paint the gradient panel background.
     *
     * @param  g  graphics
     */
    @Override
    protected void paintComponent(final java.awt.Graphics g) {
        final int w = getWidth();
        final int h = getHeight();
        final Graphics2D g2d = (Graphics2D)g;
        g2d.setPaint(new GradientPaint(0, 0, getLeftColor(), w, 0, getRightColor()));
        g2d.fillRect(0, 0, w, h);
    }

    /**
     * Returns the right color.
     *
     * @return  right color
     */
    public Color getRightColor() {
        return rightColor;
    }

    /**
     * Sets the right color.
     *
     * @param  rightColor  right color
     */
    public void setRightColor(final Color rightColor) {
        this.rightColor = rightColor;
    }

    /**
     * Returns the left color.
     *
     * @return  left color
     */
    public Color getLeftColor() {
        return leftColor;
    }

    /**
     * Sets the left color.
     *
     * @param  leftColor  left color
     */
    public void setLeftColor(final Color leftColor) {
        this.leftColor = leftColor;
    }
}
