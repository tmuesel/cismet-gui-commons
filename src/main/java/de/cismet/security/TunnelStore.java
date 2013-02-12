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
 * Storage for Tunnel
 *
 * @author   thorsten
 * @version  $Revision$, $Date$
 */
public interface TunnelStore {

    //~ Methods ----------------------------------------------------------------

    /**
     * Sets the Tunnel to the given Tunnel
     *
     * @param  tunnel  new Tunnel
     */
    void setTunnel(Tunnel tunnel);
    /**
     * Returns the Tunnel
     *
     * @return  Tunnel
     */
    Tunnel getTunnel();
}
