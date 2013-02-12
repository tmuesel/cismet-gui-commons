/***************************************************
*
* cismet GmbH, Saarbruecken, Germany
*
*              ... and it just works.
*
****************************************************/
package de.cismet.lookupoptions;

import org.jdom.Element;

import javax.swing.JPanel;

import de.cismet.lookupoptions.options.DefaultOptionsCategory;

import de.cismet.tools.configuration.NoWriteError;

/**
 * The base-class for Options Panels.
 *
 * @author   jruiz
 * @version  $Revision$, $Date$
 */
public abstract class AbstractOptionsPanel extends JPanel implements OptionsPanelController {

    //~ Instance fields --------------------------------------------------------

    private Class<? extends AbstractOptionsCategory> categoryClass;
    private String name;

    //~ Constructors -----------------------------------------------------------

    /**
     * Constructor with category set to CATEGRY_GENERAL.
     *
     * @param  name  name of the Option Panel
     */
    public AbstractOptionsPanel(final String name) {
        this(name, DefaultOptionsCategory.class);
    }

    /**
     * Constructor. If the category is null, then it is set to CATEGORY_GENERAL.
     *
     * @param  name           name of the Option Panel
     * @param  categoryClass  category
     */
    public AbstractOptionsPanel(final String name, final Class<? extends AbstractOptionsCategory> categoryClass) {
        if (name == null) {
            this.name = "";
        } else {
            this.name = name;
        }
        this.categoryClass = categoryClass;
    }

    //~ Methods ----------------------------------------------------------------

    /**
     * Returns the category of this options panel
     *
     * @return  category
     */
    @Override
    public Class<? extends OptionsCategory> getCategoryClass() {
        return categoryClass;
    }

    /**
     * Returns the name of the lookup panel
     *
     * @return  name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Returns the order-value of this options panel. Returns {@link Integer#MAX_VALUE} by Default.
     *
     * @return  order
     */
    @Override
    public int getOrder() {
        return Integer.MAX_VALUE;
    }

    /**
     * Returns the tooltip for this options panel. Returns <code>null</code> by Default.
     *
     * @return  tooltip text
     */
    @Override
    public String getTooltip() {
        return null;
    }

    /**
     * Returns the help page (string containing html) for this options panel. Returns <code>null</code> by Default.
     *
     * @return  help page
     */
    @Override
    public String getHelp() {
        return null;
    }

    /**
     * Returns the panel
     *
     * @return  panel
     */
    @Override
    public JPanel getPanel() {
        return this;
    }

    /**
     * Compares the specified Panel with this Panel. Returns negative or postive values, if the Panels' order are not equal or zero, if the order and the name are equal.
     *
     * @param   o  Panel to be compared with
     *
     * @return  zero, if equal; negative Integer, if it is smaller; postive Integer, if bigger.
     */
    @Override
    public int compareTo(final OptionsPanelController o) {
        final int orderCompare = new Integer(getOrder()).compareTo(o.getOrder());
        if (orderCompare == 0) {
            return getName().compareTo(o.getName());
        } else {
            return orderCompare;
        }
    }

    /**
     * Should return true if some option value has been changed. Unchanged by default.
     * 
     * @return false by default
     */
    @Override
    public boolean isChanged() {
        return false;
    }

    /**
     * This method is called when Options Dialog "Cancel" button is pressed. Invokes {@link #update()} by default.
     */
    @Override
    public void cancel() {
        update();
    }

    /**
     * This method is called when Options Dialog "OK" button is pressed.
     */
    @Override
    public void applyChanges() {
    }

    /**
     * Component should load its data here.
     */
    @Override
    public void update() {
    }

    /**
     * 
     * @param parent 
     */
    @Override
    public void configure(final Element parent) {
    }

    /**
     * 
     * @return null by default
     * @throws NoWriteError 
     */
    @Override
    public Element getConfiguration() throws NoWriteError {
        return null;
    }

    /**
     * 
     * @param parent 
     */
    @Override
    public void masterConfigure(final Element parent) {
    }
}
