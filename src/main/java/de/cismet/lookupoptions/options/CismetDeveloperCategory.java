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
 * This Class represents the Cismet Developer Category in the options Dialog
 *
 * @author   thorsten
 * @version  $Revision$, $Date$
 */
@ServiceProvider(service = OptionsCategory.class)
public class CismetDeveloperCategory extends AbstractOptionsCategory {

    //~ Methods ----------------------------------------------------------------

    /**
     * Returns name of category used in list on the top side of Options Dialog.
     * 
     * @return "Developer Tools"
     */
    @Override
    public String getName() {
        return org.openide.util.NbBundle.getMessage(CismetDeveloperCategory.class, "CismetDeveloperCategory.name"); // NOI18N
    }

    /**
     * Returns 32x32 icon used in list on the top of Options Dialog.
     * 
     * @return 32x32 Icon
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
     * Returns the relative order of category in the Options Dialog.
     * 
     * @return "99"
     */
    @Override
    public int getOrder() {
        return 99;
    }

    /**
     * Returns text for tooltip describing the category.
     * 
     * @return "Developer Tools"
     */
    @Override
    public String getTooltip() {
        return org.openide.util.NbBundle.getMessage(CismetDeveloperCategory.class, "CismetDeveloperCategory.tooltip"); // NOI18N
    }
}
