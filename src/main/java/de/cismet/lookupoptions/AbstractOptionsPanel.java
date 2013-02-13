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
 * The base-class for Options Panels. This class provides a skeletal implementation of the
 * {@link de.cismet.lookupoptions.OptionspanelController} interface to minimize the effort required to implement this
 * interface.
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
     * Constructor with category set to {@link de.cismet.lookupoptions.options.DefaultOptionsCategory}.
     *
     * @param  name  name of the Option Panel
     */
    public AbstractOptionsPanel(final String name) {
        this(name, DefaultOptionsCategory.class);
    }

    /**
     * Constructor. If the category is null, then it is set to
     * {@link de.cismet.lookupoptions.options.DefaultOptionsCategory}.
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
     * Returns the category of this options panel.
     *
     * @return  category
     */
    @Override
    public Class<? extends OptionsCategory> getCategoryClass() {
        return categoryClass;
    }

    /**
     * Returns the name of the lookup panel.
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
     * Returns this panel.
     *
     * @return  panel
     */
    @Override
    public JPanel getPanel() {
        return this;
    }

    /**
     * Compares the specified {@link de.cismet.lookupoptions.OptionsPanelController Panel} with this <code>Panel</code>.
     * Compares the <code>order</code> values. If they are equal compares the <code>name</code> values.
     *
     * @param   o  Panel to be compared with
     *
     * @return  Zero, if equal; Otherwise negative or positive values.
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
     * Should return true if any option value has been changed. <code>False</code> by default.
     *
     * @return  <code>True</code>, if any option value has been changed
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
     * DOCUMENT ME!
     *
     * @param  parent  DOCUMENT ME!
     */
    @Override
    public void configure(final Element parent) {
    }

    /**
     * DOCUMENT ME!
     *
     * @return  null by default
     *
     * @throws  NoWriteError  DOCUMENT ME!
     */
    @Override
    public Element getConfiguration() throws NoWriteError {
        return null;
    }

    /**
     * DOCUMENT ME!
     *
     * @param  parent  DOCUMENT ME!
     */
    @Override
    public void masterConfigure(final Element parent) {
    }
}
