/***************************************************
*
* cismet GmbH, Saarbruecken, Germany
*
*              ... and it just works.
*
****************************************************/
/*
 *  Copyright (C) 2010 thorsten
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public
 * License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with this program.  If not, see
 * <http://www.gnu.org/licenses/>.
 */
package de.cismet.tools.gui;

import javax.swing.Icon;
import javax.swing.JComponent;

/**
 * Interface which provides the Structure for BasicGuiCompontents.
 *
 * @author   thorsten
 * @version  $Revision$, $Date$
 */
public interface BasicGuiComponentProvider {

    //~ Enums ------------------------------------------------------------------

    /**
     * Enumeration for the various GUI types.
     *
     * @version  $Revision$, $Date$
     */
    public static enum GuiType {

        //~ Enum constants -----------------------------------------------------

        TOOLBARCOMPONENT, GUICOMPONENT, DUMMY
    }

    //~ Methods ----------------------------------------------------------------

    /**
     * Returns the ID of the component.
     *
     * @return  ID
     */
    String getId();

    /**
     * Returns the name of the component.
     *
     * @return  name
     */
    String getName();

    /**
     * Returns the description for the component.
     *
     * @return  description
     */
    String getDescription();

    /**
     * Returns the icon for the component.
     *
     * @return  icon
     */
    Icon getIcon();

    /**
     * Returns the instance of the the component.
     *
     * @return  instance
     */
    JComponent getComponent();

    /**
     * Returns the type of the component.
     *
     * @return  type
     */
    GuiType getType();

    /**
     * Returns the position hint for the component.
     *
     * @return  position hint
     */
    Object getPositionHint();

    /**
     * DOCUMENT ME!
     *
     * @param  link  DOCUMENT ME!
     */
    void setLinkObject(Object link);
}
