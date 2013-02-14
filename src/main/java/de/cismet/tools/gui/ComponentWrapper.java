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
 * Component Wrapper Interface.
 *
 * @author   thorsten
 * @version  $Revision$, $Date$
 */
public interface ComponentWrapper {

    //~ Methods ----------------------------------------------------------------

    /**
     * wraps the given component.
     *
     * @param   component  component
     *
     * @return  Wrapped component
     */
    WrappedComponent wrapComponent(JComponent component);
}
