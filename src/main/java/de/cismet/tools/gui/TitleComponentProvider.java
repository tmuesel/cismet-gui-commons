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

import javax.swing.JComponent;

/**
 * Provides title components.
 *
 * @author   thorsten
 * @version  $Revision$, $Date$
 */
public interface TitleComponentProvider {

    //~ Methods ----------------------------------------------------------------

    /**
     * Returns the title component.
     *
     * @return  title component
     */
    JComponent getTitleComponent();
}
