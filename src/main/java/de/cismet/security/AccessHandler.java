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

import java.io.InputStream;
import java.io.Reader;

import java.net.URL;

import java.util.HashMap;

/**
 * Acceshandler Interface.
 *
 * @author   spuhl
 * @version  $Revision$, $Date$
 */
public interface AccessHandler {

    //~ Enums ------------------------------------------------------------------

    /**
     * Acces Methods Enumaration.
     *
     * @version  $Revision$, $Date$
     */
    public static enum ACCESS_METHODS {

        //~ Enum constants -----------------------------------------------------

        POST_REQUEST, GET_REQUEST, POST_REQUEST_NO_TUNNEL, GET_REQUEST_NO_TUNNEL
    }
    /**
     * Acces Handler Types Enumaration todo ein handler könnte mehr als einen Typ verarbeiten.
     *
     * @version  $Revision$, $Date$
     */
    public enum ACCESS_HANDLER_TYPES {

        //~ Enum constants -----------------------------------------------------

        WSS, HTTP, SOAP, SANY
    }

    //~ Methods ----------------------------------------------------------------

    /**
     * Checks whether the given Access_Method is supported or not.
     *
     * @param   method  Access Method
     *
     * @return  <code>True</code>, if it is supported; <code>false</code>, if not
     */
    boolean isAccessMethodSupported(ACCESS_METHODS method);
    /**
     * Returns the Handler Type.
     *
     * @return  Type
     */
    ACCESS_HANDLER_TYPES getHandlerType();
    /**
     * Sends a Access Request to the given url. todo idee default dorequest ohne accessMethod jeder handler entscheided
     * selbst wie der default fall aussieht.
     *
     * @param   url               The URL, where the Request is send to
     * @param   requestParameter  The payload
     * @param   method            DOCUMENT ME!
     * @param   options           The options to add to the Request
     *
     * @return  The response
     *
     * @throws  Exception  throws Exception, if Request failed.
     */
    InputStream doRequest(URL url,
            Reader requestParameter,
            AccessHandler.ACCESS_METHODS method,
            HashMap<String, String> options) throws Exception;

    /**
     * Send binary data in a POST request.
     *
     * @param   url               The URL where the data is sent to.
     * @param   requestParameter  The payload.
     * @param   options           The headers to add to the POST request.
     *
     * @return  The response.
     *
     * @throws  Exception  throws Exception, if Request failed.
     */
    InputStream doRequest(URL url,
            InputStream requestParameter, HashMap<String, String> options) throws Exception;
}
