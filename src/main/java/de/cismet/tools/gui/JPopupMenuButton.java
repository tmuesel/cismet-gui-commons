/***************************************************
*
* cismet GmbH, Saarbruecken, Germany
*
*              ... and it just works.
*
****************************************************/
package de.cismet.tools.gui;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.*;

/**
 * An implementation of a "popup menu button".
 *
 * <p>Very easy to use:<br>
 * - Create the Button<br>
 * - Add an icon<br>
 * - Add an popup menu<br>
 * - Add an action event listener for the main action<br>
 * - Add an action event listener for the menu items<br>
 * - Ready<br>
 * </p>
 * <br>
 * <br>
 *
 * <p>License: <a href="http://www.gnu.org/copyleft/lesser.html#TOC1">GNU LESSER GENERAL PUBLIC LICENSE</a><br>
 * <img src="http://opensource.org/trademarks/osi-certified/web/osi-certified-60x50.gif"> <img
 * src="http://opensource.org/trademarks/opensource/web/opensource-55x48.gif"></p>
 *
 * @author   thorsten.hell@cismet.de
 * @version  $Revision$, $Date$
 */
public class JPopupMenuButton extends JButton implements MouseListener, MouseMotionListener {

    //~ Instance fields --------------------------------------------------------

    JPopupMenu popupMenu = null;

    boolean mouseInPopupArea = false;
    Icon downArrow = new javax.swing.ImageIcon(getClass().getResource("/de/cismet/tools/gui/res/down.png"));   // NOI18N
    Icon downArrow2 = new javax.swing.ImageIcon(getClass().getResource("/de/cismet/tools/gui/res/down2.png")); // NOI18N
    Icon userDefinedIcon = null;
    Icon userDefinedSelectedIcon = null;

    private int arrowXOffset = 0;
    private int arrowSelectedXOffset = 0;

    //~ Constructors -----------------------------------------------------------

    /**
     * Creates a new instance of JPopupMenuButton.
     */
    public JPopupMenuButton() {
        setIcon(null);
        setVerticalTextPosition(SwingConstants.CENTER);
        setHorizontalTextPosition(SwingConstants.LEFT);
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        this.setFocusPainted(false);
    }

    //~ Methods ----------------------------------------------------------------

    /**
     * Checks whether the given point x,y is in the popup area or not. It only tests the X-Coordinate of the point!
     *
     * @param   x  X-Coordinate
     * @param   y  Y-Coordinate
     *
     * @return  <code>True</code>, if the point's X-Coordinate is inside the popup width. Otherwise returns <code>
     *          false</code>
     */
    private boolean isOverMenuPopupArea(final int x, final int y) {
        return (x >= (getWidth() - getIcon().getIconWidth() + arrowXOffset - getInsets().right))
                    && (x <= (getWidth() - 1));
    }

    /**
     * Invoked when the mouse cursor has been moved onto a component but no buttons have been pushed.
     *
     * @param  e  mouse event
     */
    @Override
    public void mouseMoved(final java.awt.event.MouseEvent e) {
        final boolean oldValue = mouseInPopupArea;
        mouseInPopupArea = isOverMenuPopupArea((int)e.getPoint().getX(), (int)e.getPoint().getY());
        if (oldValue != mouseInPopupArea) {
            evaluateIcon(isSelected());
        }
    }

    /**
     * Invoked when a mouse button is pressed on a component and then dragged. <code>MOUSE_DRAGGED</code> events will
     * continue to be delivered to the component where the drag originated until the mouse button is released
     * (regardless of whether the mouse position is within the bounds of the component).
     *
     * <p>Due to platform-dependent Drag&Drop implementations, <code>MOUSE_DRAGGED</code> events may not be delivered
     * during a native Drag&Drop operation.</p>
     *
     * @param  e  mouse event
     */
    @Override
    public void mouseDragged(final java.awt.event.MouseEvent e) {
    }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param  e  mouse event
     */
    @Override
    public void mouseReleased(final java.awt.event.MouseEvent e) {
    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     *
     * @param  e  mouse event
     */
    @Override
    public void mousePressed(final java.awt.event.MouseEvent e) {
    }

    /**
     * Invoked when the mouse exits a component.
     *
     * @param  e  mouse event
     */
    @Override
    public void mouseExited(final java.awt.event.MouseEvent e) {
        mouseInPopupArea = false;
        evaluateIcon(isSelected());
    }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param  e  mouse event
     */
    @Override
    public void mouseEntered(final java.awt.event.MouseEvent e) {
    }

    /**
     * Invoked when the mouse button has been clicked (pressed and released) on a component.
     *
     * @param  e  mouse event
     */
    @Override
    public void mouseClicked(final java.awt.event.MouseEvent e) {
        if (this.isEnabled()) {
            if (((popupMenu == null) || (popupMenu.getComponentCount() == 0)) && mouseInPopupArea) {
                actionPerformed(new ActionEvent(this, 0, "")); // NOI18N
            } else if (mouseInPopupArea || e.isPopupTrigger()) {
                popupMenu.show(this, 0, getHeight());
                popupMenu.setVisible(true);
            }
        }
    }

    /**
     * Invoked when an action occurs.
     *
     * @param  e  action event
     */
    public void actionPerformed(final java.awt.event.ActionEvent e) {
        final ActionEvent thisEvent = new ActionEvent(this, 0, "ACTION"); // NOI18N
        fireActionPerformed(thisEvent);
    }

    /**
     * Sets the button's default icon. This icon is also used as the "pressed" and "disabled" icon if there is no
     * explicitly set pressed icon.
     *
     * @param  defaultIcon  the icon used as the default image
     *
     * @see    #getIcon
     * @see    #setPressedIcon
     *
     * @beaninfo
     *     attribute: visualUpdate true
     *         bound: true
     *   description: The button's default icon
     */
    @Override
    public void setIcon(final javax.swing.Icon defaultIcon) {
        userDefinedIcon = defaultIcon;
        evaluateIcon(false);
    }

    /**
     * Sets the selected icon for the button. Invokes {@link #evaluateIcon(boolean)} with <code>isselected</code> set to
     * <code>true</code>.
     *
     * @param  defaultSelectedIcon  the icon used as the "selected" image
     */
    @Override
    public void setSelectedIcon(final javax.swing.Icon defaultSelectedIcon) {
        userDefinedSelectedIcon = defaultSelectedIcon;
        evaluateIcon(true);
    }

    /**
     * Sets the right down arrow icon.
     *
     * @param  isSelected  <code>true</code>, if the button is selected. Otherwise <code>false</code>.
     */
    private void evaluateIcon(final boolean isSelected) {
        if (mouseInPopupArea && isEnabled()) {
            evaluateIcon(downArrow2, isSelected);
        } else {
            evaluateIcon(downArrow, isSelected);
        }
    }

    /**
     * Sets the given Icon as down arrow.
     *
     * @param  arrow       the icon used as the arrow
     * @param  isSelected  <code>true</code>, if the button is selected. Otherwise <code>false</code>
     */
    private void evaluateIcon(final Icon arrow, final boolean isSelected) {
        final Icon icon = ((userDefinedSelectedIcon != null) && isSelected) ? userDefinedSelectedIcon : userDefinedIcon;

        if (icon != null) {
            final int newWidth = icon.getIconWidth() + arrow.getIconWidth();
            int newHeight = icon.getIconHeight();
            int arrowYOffset = (icon.getIconHeight() - arrow.getIconHeight()) / 2;
            arrowXOffset = icon.getIconWidth();
            int iconYOffset = 0;
            if (arrow.getIconHeight() > newHeight) {
                newHeight = arrow.getIconHeight();
                arrowYOffset = 0;
                iconYOffset = (arrow.getIconHeight() - icon.getIconHeight()) / 2;
            }
            final BufferedImage tmp = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
            icon.paintIcon(this, tmp.getGraphics(), 0, iconYOffset);
            arrow.paintIcon(this, tmp.getGraphics(), icon.getIconWidth(), arrowYOffset);
            if (isSelected) {
                super.setSelectedIcon(new ImageIcon(tmp));
            } else {
                super.setIcon(new ImageIcon(tmp));
            }
        } else {
            if (isSelected) {
                super.setSelectedIcon(arrow);
            } else {
                super.setIcon(arrow);
            }
        }
    }

    /**
     * Sets the popupmenu.
     *
     * @param  pop  the popup menu
     */
    public void setPopupMenu(final JPopupMenu pop) {
        popupMenu = pop;
    }

    /**
     * Notifies all listeners that have registered interest for notification on this event type. The event instance is
     * lazily created using the <code>event</code> parameter.
     *
     * @param  event  the <code>ActionEvent</code> object
     *
     * @see    javax.swing.event.EventListenerList
     */
    @Override
    protected void fireActionPerformed(final ActionEvent event) {
        if ((popupMenu == null) || (mouseInPopupArea == false)) {
            super.fireActionPerformed(event);
        }
    }
}
