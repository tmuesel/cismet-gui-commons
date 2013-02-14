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
 * Wrapped component interface.
 *
 * @author   thorsten
 * @version  $Revision$, $Date$
 */
public interface WrappedComponent {

    //~ Methods ----------------------------------------------------------------

    /**
     * Returns the original {@link javax.swing.JComponent component}.
     *
     * @return  original component
     */
    JComponent getOriginalComponent();
}
