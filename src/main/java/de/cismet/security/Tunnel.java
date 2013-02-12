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
package de.cismet.security;

/**
 * Access through Tunnel
 *
 * @author   thorsten
 * @version  $Revision$, $Date$
 */
public interface Tunnel extends AccessHandler {

    //~ Methods ----------------------------------------------------------------

    /**
     * Checks whether the given URL is Responsible with the given method.
     *
     * @param   method  access Method
     * @param   url     URL as String
     *
     * @return  <code>True</code>, if the URL is responsible, otherwise <code>false</code>
     */
    boolean isResponsible(AccessHandler.ACCESS_METHODS method, String url);
}
