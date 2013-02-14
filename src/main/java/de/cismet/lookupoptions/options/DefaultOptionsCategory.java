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
 * Represents the default category which is used in {@link de.cismet.lookupoptions.gui.OptionsDialog} when no category
 * is assigned to the option panel.
 *
 * @author   jruiz
 * @version  $Revision$, $Date$
 */
@ServiceProvider(service = OptionsCategory.class)
public class DefaultOptionsCategory extends AbstractOptionsCategory {

    //~ Methods ----------------------------------------------------------------

    /**
     * Returns the name of this category used in the list on the top side of the
     * {@link de.cismet.lookupoptions.gui.OptionsDialog}.
     *
     * @return  name
     */
    @Override
    public String getName() {
        return org.openide.util.NbBundle.getMessage(DefaultOptionsCategory.class, "DefaultOptionsCategory.name"); // NOI18N
    }

    /**
     * Returns the 32x32 icon used in list on the top of {@link de.cismet.lookupoptions.gui.OptionsDialog}.
     *
     * @return  32x32 Icon
     */
    @Override
    public Icon getIcon() {
        final Image image = ImageUtilities.loadImage("de/cismet/lookupoptions/options/nocat.png"); // NOI18N
        if (image != null) {
            return new ImageIcon(image);
        } else {
            return null;
        }
    }

    /**
     * Returns the text for the tooltip describing this category.
     *
     * @return  toolstip text
     */
    @Override
    public String getTooltip() {
        return org.openide.util.NbBundle.getMessage(DefaultOptionsCategory.class, "DefaultOptionsCategory.tooltip"); // NOI18N
    }
}
