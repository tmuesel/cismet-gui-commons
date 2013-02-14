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

import javax.swing.border.Border;

/**
 * Interface which provides the basic structure for borders.
 *
 * @author   srichter
 * @version  $Revision$, $Date$
 */
public interface BorderProvider {

    //~ Methods ----------------------------------------------------------------

    /**
     * Returns the title border.
     *
     * @return  title border
     */
    Border getTitleBorder();
    /**
     * Returns the footer border.
     *
     * @return  footer border
     */
    Border getFooterBorder();
    /**
     * Returns the centerborder.
     *
     * @return  center border
     */
    Border getCenterrBorder();
}
