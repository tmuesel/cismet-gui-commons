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
 * This Class represents the Cismet Developer Category in the {@link de.cismet.lookupoptions.gui.OptionsDialog}.
 *
 * @author   thorsten
 * @version  $Revision$, $Date$
 */
@ServiceProvider(service = OptionsCategory.class)
public class CismetDeveloperCategory extends AbstractOptionsCategory {

    //~ Methods ----------------------------------------------------------------

    /**
     * Returns name of this category used in the list on the top side of the
     * {@link de.cismet.lookupoptions.gui.OptionsDialog}.
     *
     * @return  name
     */
    @Override
    public String getName() {
        return org.openide.util.NbBundle.getMessage(CismetDeveloperCategory.class, "CismetDeveloperCategory.name"); // NOI18N
    }

    /**
     * Returns the 32x32 icon used in the list on the top of the {@link de.cismet.lookupoptions.gui.OptionsDialog}.
     *
     * @return  32x32 Icon
     */
    @Override
    public Icon getIcon() {
        final Image image = ImageUtilities.loadImage("de/cismet/lookupoptions/options/cismetlogo32.png"); // NOI18N
        if (image != null) {
            return new ImageIcon(image);
        } else {
            return null;
        }
    }

    /**
     * Returns the relative order of this category in the {@link de.cismet.lookupoptions.gui.OptionsDialog}.
     *
     * @return  "99"
     */
    @Override
    public int getOrder() {
        return 99;
    }

    /**
     * Returns the text for the tooltip describing this category.
     *
     * @return  tootip text
     */
    @Override
    public String getTooltip() {
        return org.openide.util.NbBundle.getMessage(CismetDeveloperCategory.class, "CismetDeveloperCategory.tooltip"); // NOI18N
    }
}
