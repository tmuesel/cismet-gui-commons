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
 * Provides footer components.
 *
 * @author   thorsten
 * @version  $Revision$, $Date$
 */
public interface FooterComponentProvider {

    //~ Methods ----------------------------------------------------------------

    /**
     * Returns the footer component.
     *
     * @return  footer component
     */
    JComponent getFooterComponent();
}
