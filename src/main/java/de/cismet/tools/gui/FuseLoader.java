/***************************************************
*
* cismet GmbH, Saarbruecken, Germany
*
*              ... and it just works.
*
****************************************************/
package de.cismet.tools.gui;

import org.jdesktop.fuse.ResourceInjector;

import java.util.Properties;

/**
 * Fuseloader adds the swing module to the ResourceInjector and loads style properties.
 *
 * @author   nhaffke
 * @version  $Revision$, $Date$
 */
public final class FuseLoader {

    //~ Static fields/initializers ---------------------------------------------

    private static FuseLoader instance;

    //~ Instance fields --------------------------------------------------------

    private Properties properties;

    //~ Constructors -----------------------------------------------------------

    /**
     * Creates a new FuseLoader object. Adds the swing module to the ResourceInjector and loads style properties. Saves
     * this Object as <code>instance</code>.
     */
    private FuseLoader() {
        instance = this;
        ResourceInjector.addModule("org.jdesktop.fuse.swing.SwingModule");                                     // NOI18N
        try {
            ResourceInjector.get("coolpanel.style")
                    .load(getClass().getResource("/coolobjectrenderer/style.properties"));                     // NOI18N
        } catch (Exception e) {
        }
        try {
            ResourceInjector.get("purecoolpanel.style")
                    .load(getClass().getResource("/de/cismet/tools/gui/purecoolpanelstyle.properties"));       // NOI18N
        } catch (Exception e) {
        }
        try {
            ResourceInjector.get("blurredmapobjectrenderer.style")
                    .load(getClass().getResource("/de/cismet/tools/gui/blurredmapobjectrenderer.properties")); // NOI18N
        } catch (Exception e) {
            System.out.println("");
        }
    }

    //~ Methods ----------------------------------------------------------------

    /**
     * If Fuseloader has no instance create new FuseLoader and save it as instance.
     */
    public static void load() {
        if (instance == null) {
            instance = new FuseLoader();
        }
    }
}
