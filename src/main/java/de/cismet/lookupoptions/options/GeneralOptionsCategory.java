/***************************************************
*
* cismet GmbH, Saarbruecken, Germany
*
*              ... and it just works.
*
****************************************************/
package de.cismet.lookupoptions.options;

import org.openide.util.ImageUtilities;
import org.openide.util.lookup.ServiceProvider;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import de.cismet.lookupoptions.*;

/**
 * Represents the general category in the {@link de.cismet.lookupoptions.gui.OptionsDialog}.
 *
 * @author   jruiz
 * @version  $Revision$, $Date$
 */
@ServiceProvider(service = OptionsCategory.class)
public class GeneralOptionsCategory extends AbstractOptionsCategory {

    //~ Methods ----------------------------------------------------------------

    /**
     * Returns the name of this category used in list on the top side of the
     * {@link de.cismet.lookupoptions.gui.OptionsDialog}.
     *
     * @return  name
     */
    @Override
    public String getName() {
        return org.openide.util.NbBundle.getMessage(GeneralOptionsCategory.class, "GeneralOptionsCategory.name"); // NOI18N
    }

    /**
     * Returns a 32x32 icon used in the list on the top of the {@link de.cismet.lookupoptions.gui.OptionsDialog}.
     *
     * @return  32x32 Icon
     */
    @Override
    public Icon getIcon() {
        final Image image = ImageUtilities.loadImage("de/cismet/lookupoptions/options/general.png"); // NOI18N
        if (image != null) {
            return new ImageIcon(image);
        } else {
            return null;
        }
    }

    /**
     * Returns the relative order of this category in the {@link de.cismet.lookupoptions.gui.OptionsDialog}.
     *
     * @return  "0"
     */
    @Override
    public int getOrder() {
        return 0;
    }

    /**
     * Returns the text for the tooltip describing this category.
     *
     * @return  tooltip text
     */
    @Override
    public String getTooltip() {
        return org.openide.util.NbBundle.getMessage(GeneralOptionsCategory.class, "GeneralOptionsCategory.tooltip"); // NOI18N
    }
}
