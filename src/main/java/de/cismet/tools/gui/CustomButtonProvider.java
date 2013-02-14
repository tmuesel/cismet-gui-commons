/***************************************************
*
* cismet GmbH, Saarbruecken, Germany
*
*              ... and it just works.
*
****************************************************/
package de.cismet.tools.gui;

import java.util.Collection;

import javax.swing.JComponent;

/**
 * Custom button provider interface
 *
 * @author   thorsten
 * @version  $Revision$, $Date$
 */
public interface CustomButtonProvider {

    //~ Methods ----------------------------------------------------------------

    /**
     * Returns the custom button
     *
     * @return  custom button
     */
    Collection<JComponent> getCustomButtons();
}
