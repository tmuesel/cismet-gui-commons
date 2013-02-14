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

import de.cismet.lookupoptions.AbstractOptionsCategory;
import de.cismet.lookupoptions.OptionsCategory;

/**
 * Example Category.
 *
 * @author   jruiz
 * @version  $Revision$, $Date$
 */
@ServiceProvider(service = OptionsCategory.class)
public class NetworkOptionsCategory extends AbstractOptionsCategory {

    //~ Methods ----------------------------------------------------------------

    /**
     * Returns the name of this category used in the list on the top side of the
     * {@link de.cismet.lookupoptions.gui.OptionsDialog}.
     *
     * @return  name
     */
    @Override
    public String getName() {
        return org.openide.util.NbBundle.getMessage(NetworkOptionsCategory.class, "NetworkOptionsCategory.name"); // NOI18N
    }

    /**
     * Returns a 32x32 icon used in the list on the top of the {@link de.cismet.lookupoptions.gui.OptionsDialog}.
     *
     * @return  32x32 Icon
     */
    @Override
    public Icon getIcon() {
        final Image image = ImageUtilities.loadImage("de/cismet/lookupoptions/options/network.png"); // NOI18N
        if (image != null) {
            return new ImageIcon(image);
        } else {
            return null;
        }
    }

    /**
     * Returns the relative order of this category in the {@link de.cismet.lookupoptions.gui.OptionsDialog}.
     *
     * @return  "1"
     */
    @Override
    public int getOrder() {
        return 1;
    }

    /**
     * Returns the text for the tooltip describing this category.
     *
     * @return  toolstip text
     */
    @Override
    public String getTooltip() {
        return org.openide.util.NbBundle.getMessage(NetworkOptionsCategory.class, "NetworkOptionsCategory.tooltip"); // NOI18N
    }
}
