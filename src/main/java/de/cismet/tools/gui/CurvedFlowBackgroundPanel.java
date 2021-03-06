/***************************************************
*
* cismet GmbH, Saarbruecken, Germany
*
*              ... and it just works.
*
****************************************************/
package de.cismet.tools.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * DOCUMENT ME!
 *
 * @version  $Revision$, $Date$
 */
public class CurvedFlowBackgroundPanel extends JPanel {

    //~ Instance fields --------------------------------------------------------

    private int unten = 20;
    private int oben = 20;
    private double untenFraction = -1;
    private double obenFraction = -1;

    private boolean designMode;
    private boolean relativeHeights = false;

    //~ Constructors -----------------------------------------------------------

    /**
     * Creates a new CurvedFlowBackgroundPanel object.
     */
    public CurvedFlowBackgroundPanel() {
        super();
        setOpaque(false);
        addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(final MouseEvent e) {
                    super.mouseClicked(e);
                    if ((e.getClickCount() == 2) && isDesignMode()) {
                        final Frame parentFrame = StaticSwingTools.getParentFrame(CurvedFlowBackgroundPanel.this);
                        final JDialog jd = new JDialog(parentFrame);
                        jd.setTitle(CurvedFlowBackgroundPanel.this.getClass().getName() + " Designer");
                        jd.getContentPane().setLayout(new BorderLayout());
                        jd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                        final JSlider sliOben = new JSlider(0, 100);
                        final JSlider sliUnten = new JSlider(0, 100);
                        final JLabel lblInfo = new JLabel();
                        final JButton cmdRefresh = new JButton("refresh");
                        final JCheckBox chkRelative = new JCheckBox("relativeHeight", isRelativeHeights());
                        chkRelative.addActionListener(new ActionListener() {

                                @Override
                                public void actionPerformed(final ActionEvent e) {
                                    setRelativeHeights(chkRelative.isSelected());
                                }
                            });
                        sliOben.addChangeListener(new ChangeListener() {

                                @Override
                                public void stateChanged(final ChangeEvent e) {
                                    setOben((double)(sliOben.getValue() / 100.0));
                                    lblInfo.setText(getInfoString());
                                }
                            });
                        sliUnten.addChangeListener(new ChangeListener() {

                                @Override
                                public void stateChanged(final ChangeEvent e) {
                                    setUnten((double)(sliUnten.getValue() / 100.0));
                                    lblInfo.setText(getInfoString());
                                }
                            });

                        jd.getContentPane().add(lblInfo, BorderLayout.CENTER);
                        jd.getContentPane().add(sliOben, BorderLayout.NORTH);
                        jd.getContentPane().add(sliUnten, BorderLayout.SOUTH);
                        jd.getContentPane().add(cmdRefresh, BorderLayout.EAST);
                        jd.getContentPane().add(chkRelative, BorderLayout.WEST);

                        lblInfo.setText(getInfoString());
                        cmdRefresh.addActionListener(new ActionListener() {

                                @Override
                                public void actionPerformed(final ActionEvent e) {
                                    lblInfo.setText(getInfoString());
                                }
                            });
                        sliOben.setValue((int)((double)getOben() / (double)getHeight() * 100));
                        sliUnten.setValue((int)((double)getUnten() / (double)getHeight() * 100));

                        jd.pack();
                        StaticSwingTools.showDialog(jd);
                    }
                }
            });
        addComponentListener(new ComponentAdapter() {

                @Override
                public void componentResized(final ComponentEvent e) {
                    super.componentResized(e);
                    if ((untenFraction < 0) || (obenFraction < 0)) {
                        untenFraction = (double)getUnten() / (double)getHeight();
                        obenFraction = (double)getOben() / (double)getHeight();
                    }
                    if (relativeHeights) {
                        setOben(obenFraction);
                        setUnten(untenFraction);
                    }
                }
            });
    }

    /**
     * Creates a new CurvedFlowBackgroundPanel object.
     *
     * @param  OBEN   DOCUMENT ME!
     * @param  UNTEN  DOCUMENT ME!
     */
    public CurvedFlowBackgroundPanel(final int OBEN, final int UNTEN) {
        this();
        oben = OBEN;
        unten = UNTEN;
    }

    //~ Methods ----------------------------------------------------------------

    /**
     * DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    private String getInfoString() {
        return "Info: Size=" + getWidth() + "," + getHeight() + " Oben(abs,rel)=" + getOben() + ","
                    + ((double)getOben() / (double)getHeight()) + " Unten(abs,rel)=" + getUnten() + ","
                    + ((double)getUnten() / (double)getHeight());
    }

    /**
     * DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    public boolean isDesignMode() {
        return designMode;
    }

    /**
     * DOCUMENT ME!
     *
     * @param  designMode  DOCUMENT ME!
     */
    public void setDesignMode(final boolean designMode) {
        this.designMode = designMode;
    }

    /**
     * DOCUMENT ME!
     *
     * @param   WIDTH   DOCUMENT ME!
     * @param   HEIGHT  DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    private java.awt.image.BufferedImage createOben(final int WIDTH, final int HEIGHT) {
        if ((WIDTH <= 0) || (HEIGHT <= 0)) {
            return null;
        }
        final java.awt.GraphicsConfiguration GFX_CONF = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment()
                    .getDefaultScreenDevice()
                    .getDefaultConfiguration();
        final java.awt.image.BufferedImage IMAGE = GFX_CONF.createCompatibleImage(
                WIDTH,
                HEIGHT,
                java.awt.Transparency.TRANSLUCENT);
        final java.awt.Graphics2D G2 = IMAGE.createGraphics();
        G2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
        G2.setRenderingHint(java.awt.RenderingHints.KEY_RENDERING, java.awt.RenderingHints.VALUE_RENDER_QUALITY);
        G2.setRenderingHint(java.awt.RenderingHints.KEY_DITHERING, java.awt.RenderingHints.VALUE_DITHER_ENABLE);
        G2.setRenderingHint(
            java.awt.RenderingHints.KEY_ALPHA_INTERPOLATION,
            java.awt.RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        G2.setRenderingHint(
            java.awt.RenderingHints.KEY_COLOR_RENDERING,
            java.awt.RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        G2.setRenderingHint(java.awt.RenderingHints.KEY_STROKE_CONTROL, java.awt.RenderingHints.VALUE_STROKE_PURE);
        G2.setRenderingHint(
            java.awt.RenderingHints.KEY_TEXT_ANTIALIASING,
            java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        final java.awt.font.FontRenderContext RENDER_CONTEXT = new java.awt.font.FontRenderContext(null, true, true);
        final int IMAGE_WIDTH = IMAGE.getWidth();
        final int IMAGE_HEIGHT = IMAGE.getHeight();
        final java.awt.geom.GeneralPath OBEN1_1 = new java.awt.geom.GeneralPath();
        OBEN1_1.setWindingRule(java.awt.geom.GeneralPath.WIND_EVEN_ODD);
        OBEN1_1.moveTo(IMAGE_WIDTH * 0.0, IMAGE_HEIGHT * 1.0);
        OBEN1_1.lineTo(IMAGE_WIDTH * 0.0, IMAGE_HEIGHT * 0.0);
        OBEN1_1.lineTo(IMAGE_WIDTH * 1.0, IMAGE_HEIGHT * 0.0);
        OBEN1_1.curveTo(IMAGE_WIDTH * 1.0,
            IMAGE_HEIGHT
                    * 0.0,
            IMAGE_WIDTH
                    * 1.0,
            IMAGE_HEIGHT
                    * 0.078125,
            IMAGE_WIDTH
                    * 1.0,
            IMAGE_HEIGHT
                    * 0.078125);
        OBEN1_1.curveTo(IMAGE_WIDTH * 0.337890625,
            IMAGE_HEIGHT
                    * 0.181640625,
            IMAGE_WIDTH
                    * 0.4921875,
            IMAGE_HEIGHT
                    * 0.96484375,
            IMAGE_WIDTH
                    * 0.0,
            IMAGE_HEIGHT
                    * 1.0);
        OBEN1_1.curveTo(IMAGE_WIDTH * 0.0,
            IMAGE_HEIGHT
                    * 1.0,
            IMAGE_WIDTH
                    * 0.0,
            IMAGE_HEIGHT
                    * 1.0,
            IMAGE_WIDTH
                    * 0.0,
            IMAGE_HEIGHT
                    * 1.0);
        OBEN1_1.closePath();
        OBEN1_1.moveTo(IMAGE_WIDTH * 0.0, IMAGE_HEIGHT * 1.0);
        OBEN1_1.lineTo(IMAGE_WIDTH * 0.0, IMAGE_HEIGHT * 1.0);
        OBEN1_1.closePath();
//        final java.awt.Color FILL_COLOR_PATH1_1 = new java.awt.Color(13421772);
        final java.awt.Color FILL_COLOR_PATH1_1 = new java.awt.Color(0, 0, 0, 0);
        G2.setColor(FILL_COLOR_PATH1_1);
        G2.fill(OBEN1_1);
        final java.awt.geom.GeneralPath OBEN2_1 = new java.awt.geom.GeneralPath();
        OBEN2_1.setWindingRule(java.awt.geom.GeneralPath.WIND_EVEN_ODD);
        OBEN2_1.moveTo(IMAGE_WIDTH * 0.0, IMAGE_HEIGHT * 1.0);
        OBEN2_1.lineTo(IMAGE_WIDTH * 0.0, IMAGE_HEIGHT * 0.0);
        OBEN2_1.lineTo(IMAGE_WIDTH * 1.0, IMAGE_HEIGHT * 0.0);
        OBEN2_1.curveTo(IMAGE_WIDTH * 1.0,
            IMAGE_HEIGHT
                    * 0.0,
            IMAGE_WIDTH
                    * 1.0,
            IMAGE_HEIGHT
                    * 0.078125,
            IMAGE_WIDTH
                    * 1.0,
            IMAGE_HEIGHT
                    * 0.078125);
        OBEN2_1.curveTo(IMAGE_WIDTH * 0.337890625,
            IMAGE_HEIGHT
                    * 0.181640625,
            IMAGE_WIDTH
                    * 0.4921875,
            IMAGE_HEIGHT
                    * 0.96484375,
            IMAGE_WIDTH
                    * 0.0,
            IMAGE_HEIGHT
                    * 1.0);
        OBEN2_1.curveTo(IMAGE_WIDTH * 0.0,
            IMAGE_HEIGHT
                    * 1.0,
            IMAGE_WIDTH
                    * 0.0,
            IMAGE_HEIGHT
                    * 1.0,
            IMAGE_WIDTH
                    * 0.0,
            IMAGE_HEIGHT
                    * 1.0);
        OBEN2_1.closePath();
        OBEN2_1.moveTo(IMAGE_WIDTH * 0.0, IMAGE_HEIGHT * 1.0);
        OBEN2_1.lineTo(IMAGE_WIDTH * 0.0, IMAGE_HEIGHT * 1.0);
        OBEN2_1.closePath();
        final java.awt.Color FILL_COLOR_PATH2_1 = new java.awt.Color(13421772);
        G2.setColor(FILL_COLOR_PATH2_1);
        G2.fill(OBEN2_1);
        G2.dispose();
        return IMAGE;
    }
    /**
     * G2.drawImage(createUnten_EBENE_1_0_Image(100, 100), 0, 0, null);
     *
     * @param   WIDTH   DOCUMENT ME!
     * @param   HEIGHT  DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    private java.awt.image.BufferedImage createUnten(final int WIDTH, final int HEIGHT) {
        if ((WIDTH <= 0) || (HEIGHT <= 0)) {
            return null;
        }
        final java.awt.GraphicsConfiguration GFX_CONF = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment()
                    .getDefaultScreenDevice()
                    .getDefaultConfiguration();
        final java.awt.image.BufferedImage IMAGE = GFX_CONF.createCompatibleImage(
                WIDTH,
                HEIGHT,
                java.awt.Transparency.TRANSLUCENT);
        final java.awt.Graphics2D G2 = IMAGE.createGraphics();
        G2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
        G2.setRenderingHint(java.awt.RenderingHints.KEY_RENDERING, java.awt.RenderingHints.VALUE_RENDER_QUALITY);
        G2.setRenderingHint(java.awt.RenderingHints.KEY_DITHERING, java.awt.RenderingHints.VALUE_DITHER_ENABLE);
        G2.setRenderingHint(
            java.awt.RenderingHints.KEY_ALPHA_INTERPOLATION,
            java.awt.RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        G2.setRenderingHint(
            java.awt.RenderingHints.KEY_COLOR_RENDERING,
            java.awt.RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        G2.setRenderingHint(java.awt.RenderingHints.KEY_STROKE_CONTROL, java.awt.RenderingHints.VALUE_STROKE_PURE);
        G2.setRenderingHint(
            java.awt.RenderingHints.KEY_TEXT_ANTIALIASING,
            java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        final java.awt.font.FontRenderContext RENDER_CONTEXT = new java.awt.font.FontRenderContext(null, true, true);
        final int IMAGE_WIDTH = IMAGE.getWidth();
        final int IMAGE_HEIGHT = IMAGE.getHeight();
        final java.awt.geom.GeneralPath UNTEN1_1 = new java.awt.geom.GeneralPath();
        UNTEN1_1.setWindingRule(java.awt.geom.GeneralPath.WIND_EVEN_ODD);
        UNTEN1_1.moveTo(IMAGE_WIDTH * 1.0, IMAGE_HEIGHT * 0.0);
        UNTEN1_1.lineTo(IMAGE_WIDTH * 1.0, IMAGE_HEIGHT * 1.0);
        UNTEN1_1.lineTo(IMAGE_WIDTH * 0.0, IMAGE_HEIGHT * 1.0);
        UNTEN1_1.curveTo(IMAGE_WIDTH * 0.0,
            IMAGE_HEIGHT
                    * 1.0,
            IMAGE_WIDTH
                    * 0.0,
            IMAGE_HEIGHT
                    * 0.921875,
            IMAGE_WIDTH
                    * 0.0,
            IMAGE_HEIGHT
                    * 0.921875);
        UNTEN1_1.curveTo(IMAGE_WIDTH * 0.662109375,
            IMAGE_HEIGHT
                    * 0.818359375,
            IMAGE_WIDTH
                    * 0.5078125,
            IMAGE_HEIGHT
                    * 0.03515625,
            IMAGE_WIDTH
                    * 1.0,
            IMAGE_HEIGHT
                    * 0.0);
        UNTEN1_1.curveTo(IMAGE_WIDTH * 1.0,
            IMAGE_HEIGHT
                    * 0.0,
            IMAGE_WIDTH
                    * 1.0,
            IMAGE_HEIGHT
                    * 0.0,
            IMAGE_WIDTH
                    * 1.0,
            IMAGE_HEIGHT
                    * 0.0);
        UNTEN1_1.closePath();
        UNTEN1_1.moveTo(IMAGE_WIDTH * 1.0, IMAGE_HEIGHT * 0.0);
        UNTEN1_1.lineTo(IMAGE_WIDTH * 1.0, IMAGE_HEIGHT * 0.0);
        UNTEN1_1.closePath();
        final java.awt.Color FILL_COLOR_PATH1_1 = new java.awt.Color(13421772);
        G2.setColor(FILL_COLOR_PATH1_1);
        G2.fill(UNTEN1_1);
        final java.awt.geom.GeneralPath UNTEN2_1 = new java.awt.geom.GeneralPath();
        UNTEN2_1.setWindingRule(java.awt.geom.GeneralPath.WIND_EVEN_ODD);
        UNTEN2_1.moveTo(IMAGE_WIDTH * 1.0, IMAGE_HEIGHT * 0.0);
        UNTEN2_1.lineTo(IMAGE_WIDTH * 1.0, IMAGE_HEIGHT * 1.0);
        UNTEN2_1.lineTo(IMAGE_WIDTH * 0.0, IMAGE_HEIGHT * 1.0);
        UNTEN2_1.curveTo(IMAGE_WIDTH * 0.0,
            IMAGE_HEIGHT
                    * 1.0,
            IMAGE_WIDTH
                    * 0.0,
            IMAGE_HEIGHT
                    * 0.921875,
            IMAGE_WIDTH
                    * 0.0,
            IMAGE_HEIGHT
                    * 0.921875);
        UNTEN2_1.curveTo(IMAGE_WIDTH * 0.662109375,
            IMAGE_HEIGHT
                    * 0.818359375,
            IMAGE_WIDTH
                    * 0.5078125,
            IMAGE_HEIGHT
                    * 0.03515625,
            IMAGE_WIDTH
                    * 1.0,
            IMAGE_HEIGHT
                    * 0.0);
        UNTEN2_1.curveTo(IMAGE_WIDTH * 1.0,
            IMAGE_HEIGHT
                    * 0.0,
            IMAGE_WIDTH
                    * 1.0,
            IMAGE_HEIGHT
                    * 0.0,
            IMAGE_WIDTH
                    * 1.0,
            IMAGE_HEIGHT
                    * 0.0);
        UNTEN2_1.closePath();
        UNTEN2_1.moveTo(IMAGE_WIDTH * 1.0, IMAGE_HEIGHT * 0.0);
        UNTEN2_1.lineTo(IMAGE_WIDTH * 1.0, IMAGE_HEIGHT * 0.0);
        UNTEN2_1.closePath();
        final java.awt.Color FILL_COLOR_PATH2_1 = new java.awt.Color(13421772);
        G2.setColor(FILL_COLOR_PATH2_1);
        G2.fill(UNTEN2_1);
        G2.dispose();
        return IMAGE;
    }

    /**
     * DOCUMENT ME!
     *
     * @param   WIDTH         DOCUMENT ME!
     * @param   HEIGHT        DOCUMENT ME!
     * @param   HEIGHT_OBEN   DOCUMENT ME!
     * @param   HEIGHT_UNTEN  DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    private java.awt.image.BufferedImage createFlow(final int WIDTH,
            final int HEIGHT,
            final int HEIGHT_OBEN,
            final int HEIGHT_UNTEN) {
        if ((WIDTH <= 0) || (HEIGHT <= 0)) {
            return null;
        }
        final java.awt.GraphicsConfiguration GFX_CONF = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment()
                    .getDefaultScreenDevice()
                    .getDefaultConfiguration();
        final java.awt.image.BufferedImage IMAGE = GFX_CONF.createCompatibleImage(
                WIDTH,
                HEIGHT,
                java.awt.Transparency.TRANSLUCENT);
        final java.awt.Graphics2D G2 = IMAGE.createGraphics();
        G2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
        G2.setRenderingHint(java.awt.RenderingHints.KEY_RENDERING, java.awt.RenderingHints.VALUE_RENDER_QUALITY);
        G2.setRenderingHint(java.awt.RenderingHints.KEY_DITHERING, java.awt.RenderingHints.VALUE_DITHER_ENABLE);
        G2.setRenderingHint(
            java.awt.RenderingHints.KEY_ALPHA_INTERPOLATION,
            java.awt.RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        G2.setRenderingHint(
            java.awt.RenderingHints.KEY_COLOR_RENDERING,
            java.awt.RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        G2.setRenderingHint(java.awt.RenderingHints.KEY_STROKE_CONTROL, java.awt.RenderingHints.VALUE_STROKE_PURE);
        G2.setRenderingHint(
            java.awt.RenderingHints.KEY_TEXT_ANTIALIASING,
            java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        final java.awt.font.FontRenderContext RENDER_CONTEXT = new java.awt.font.FontRenderContext(null, true, true);
        final int IMAGE_WIDTH = IMAGE.getWidth();
        int IMAGE_HEIGHT = HEIGHT_OBEN;

        G2.setPaint(getBackground());
        G2.fillRect(0, 0, WIDTH, HEIGHT);

        G2.setComposite(AlphaComposite.Clear);

        final java.awt.geom.GeneralPath OBEN1_1 = new java.awt.geom.GeneralPath();
        OBEN1_1.setWindingRule(java.awt.geom.GeneralPath.WIND_EVEN_ODD);
        OBEN1_1.moveTo(IMAGE_WIDTH * 0.0, IMAGE_HEIGHT * 1.0);
        OBEN1_1.lineTo(IMAGE_WIDTH * 0.0, IMAGE_HEIGHT * 0.0);
        OBEN1_1.lineTo(IMAGE_WIDTH * 1.0, IMAGE_HEIGHT * 0.0);
        OBEN1_1.curveTo(IMAGE_WIDTH * 1.0,
            IMAGE_HEIGHT
                    * 0.0,
            IMAGE_WIDTH
                    * 1.0,
            IMAGE_HEIGHT
                    * 0.078125,
            IMAGE_WIDTH
                    * 1.0,
            IMAGE_HEIGHT
                    * 0.078125);
        OBEN1_1.curveTo(IMAGE_WIDTH * 0.337890625,
            IMAGE_HEIGHT
                    * 0.181640625,
            IMAGE_WIDTH
                    * 0.4921875,
            IMAGE_HEIGHT
                    * 0.96484375,
            IMAGE_WIDTH
                    * 0.0,
            IMAGE_HEIGHT
                    * 1.0);
        OBEN1_1.curveTo(IMAGE_WIDTH * 0.0,
            IMAGE_HEIGHT
                    * 1.0,
            IMAGE_WIDTH
                    * 0.0,
            IMAGE_HEIGHT
                    * 1.0,
            IMAGE_WIDTH
                    * 0.0,
            IMAGE_HEIGHT
                    * 1.0);
        OBEN1_1.closePath();
        OBEN1_1.moveTo(IMAGE_WIDTH * 0.0, IMAGE_HEIGHT * 1.0);
        OBEN1_1.lineTo(IMAGE_WIDTH * 0.0, IMAGE_HEIGHT * 1.0);
        OBEN1_1.closePath();
//        final java.awt.Color FILL_COLOR_PATH1_1 = new java.awt.Color(13421772);
//        final java.awt.Color FILL_COLOR_PATH1_1 = new java.awt.Color(0,0,0,0);
//        G2.setColor(FILL_COLOR_PATH1_1);
        G2.fill(OBEN1_1);
        final java.awt.geom.GeneralPath OBEN2_1 = new java.awt.geom.GeneralPath();
        OBEN2_1.setWindingRule(java.awt.geom.GeneralPath.WIND_EVEN_ODD);
        OBEN2_1.moveTo(IMAGE_WIDTH * 0.0, IMAGE_HEIGHT * 1.0);
        OBEN2_1.lineTo(IMAGE_WIDTH * 0.0, IMAGE_HEIGHT * 0.0);
        OBEN2_1.lineTo(IMAGE_WIDTH * 1.0, IMAGE_HEIGHT * 0.0);
        OBEN2_1.curveTo(IMAGE_WIDTH * 1.0,
            IMAGE_HEIGHT
                    * 0.0,
            IMAGE_WIDTH
                    * 1.0,
            IMAGE_HEIGHT
                    * 0.078125,
            IMAGE_WIDTH
                    * 1.0,
            IMAGE_HEIGHT
                    * 0.078125);
        OBEN2_1.curveTo(IMAGE_WIDTH * 0.337890625,
            IMAGE_HEIGHT
                    * 0.181640625,
            IMAGE_WIDTH
                    * 0.4921875,
            IMAGE_HEIGHT
                    * 0.96484375,
            IMAGE_WIDTH
                    * 0.0,
            IMAGE_HEIGHT
                    * 1.0);
        OBEN2_1.curveTo(IMAGE_WIDTH * 0.0,
            IMAGE_HEIGHT
                    * 1.0,
            IMAGE_WIDTH
                    * 0.0,
            IMAGE_HEIGHT
                    * 1.0,
            IMAGE_WIDTH
                    * 0.0,
            IMAGE_HEIGHT
                    * 1.0);
        OBEN2_1.closePath();
        OBEN2_1.moveTo(IMAGE_WIDTH * 0.0, IMAGE_HEIGHT * 1.0);
        OBEN2_1.lineTo(IMAGE_WIDTH * 0.0, IMAGE_HEIGHT * 1.0);
        OBEN2_1.closePath();
//        final java.awt.Color FILL_COLOR_PATH2_1 = new java.awt.Color(13421772);
//        G2.setColor(FILL_COLOR_PATH2_1);
        G2.fill(OBEN2_1);

        G2.translate(0, HEIGHT - HEIGHT_UNTEN);

        IMAGE_HEIGHT = HEIGHT_UNTEN;

        final java.awt.geom.GeneralPath UNTEN1_1 = new java.awt.geom.GeneralPath();
        UNTEN1_1.setWindingRule(java.awt.geom.GeneralPath.WIND_EVEN_ODD);
        UNTEN1_1.moveTo(IMAGE_WIDTH * 1.0, IMAGE_HEIGHT * 0.0);
        UNTEN1_1.lineTo(IMAGE_WIDTH * 1.0, IMAGE_HEIGHT * 1.0);
        UNTEN1_1.lineTo(IMAGE_WIDTH * 0.0, IMAGE_HEIGHT * 1.0);
        UNTEN1_1.curveTo(IMAGE_WIDTH * 0.0,
            IMAGE_HEIGHT
                    * 1.0,
            IMAGE_WIDTH
                    * 0.0,
            IMAGE_HEIGHT
                    * 0.921875,
            IMAGE_WIDTH
                    * 0.0,
            IMAGE_HEIGHT
                    * 0.921875);
        UNTEN1_1.curveTo(IMAGE_WIDTH * 0.662109375,
            IMAGE_HEIGHT
                    * 0.818359375,
            IMAGE_WIDTH
                    * 0.5078125,
            IMAGE_HEIGHT
                    * 0.03515625,
            IMAGE_WIDTH
                    * 1.0,
            IMAGE_HEIGHT
                    * 0.0);
        UNTEN1_1.curveTo(IMAGE_WIDTH * 1.0,
            IMAGE_HEIGHT
                    * 0.0,
            IMAGE_WIDTH
                    * 1.0,
            IMAGE_HEIGHT
                    * 0.0,
            IMAGE_WIDTH
                    * 1.0,
            IMAGE_HEIGHT
                    * 0.0);
        UNTEN1_1.closePath();
        UNTEN1_1.moveTo(IMAGE_WIDTH * 1.0, IMAGE_HEIGHT * 0.0);
        UNTEN1_1.lineTo(IMAGE_WIDTH * 1.0, IMAGE_HEIGHT * 0.0);
        UNTEN1_1.closePath();
        final java.awt.Color FILL_COLOR_PATH1_1 = new java.awt.Color(13421772);
        G2.setColor(FILL_COLOR_PATH1_1);
        G2.fill(UNTEN1_1);
        final java.awt.geom.GeneralPath UNTEN2_1 = new java.awt.geom.GeneralPath();
        UNTEN2_1.setWindingRule(java.awt.geom.GeneralPath.WIND_EVEN_ODD);
        UNTEN2_1.moveTo(IMAGE_WIDTH * 1.0, IMAGE_HEIGHT * 0.0);
        UNTEN2_1.lineTo(IMAGE_WIDTH * 1.0, IMAGE_HEIGHT * 1.0);
        UNTEN2_1.lineTo(IMAGE_WIDTH * 0.0, IMAGE_HEIGHT * 1.0);
        UNTEN2_1.curveTo(IMAGE_WIDTH * 0.0,
            IMAGE_HEIGHT
                    * 1.0,
            IMAGE_WIDTH
                    * 0.0,
            IMAGE_HEIGHT
                    * 0.921875,
            IMAGE_WIDTH
                    * 0.0,
            IMAGE_HEIGHT
                    * 0.921875);
        UNTEN2_1.curveTo(IMAGE_WIDTH * 0.662109375,
            IMAGE_HEIGHT
                    * 0.818359375,
            IMAGE_WIDTH
                    * 0.5078125,
            IMAGE_HEIGHT
                    * 0.03515625,
            IMAGE_WIDTH
                    * 1.0,
            IMAGE_HEIGHT
                    * 0.0);
        UNTEN2_1.curveTo(IMAGE_WIDTH * 1.0,
            IMAGE_HEIGHT
                    * 0.0,
            IMAGE_WIDTH
                    * 1.0,
            IMAGE_HEIGHT
                    * 0.0,
            IMAGE_WIDTH
                    * 1.0,
            IMAGE_HEIGHT
                    * 0.0);
        UNTEN2_1.closePath();
        UNTEN2_1.moveTo(IMAGE_WIDTH * 1.0, IMAGE_HEIGHT * 0.0);
        UNTEN2_1.lineTo(IMAGE_WIDTH * 1.0, IMAGE_HEIGHT * 0.0);
        UNTEN2_1.closePath();
        G2.fill(UNTEN2_1);

        G2.dispose();

        return IMAGE;
    }

    @Override
    public void paint(final Graphics g) {
        super.paint(g);
        ((Graphics2D)g).drawImage(createFlow(getWidth(), getHeight(), oben, unten), 0, 0, null);
    }

    /**
     * DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    public int getOben() {
        return oben;
    }

    /**
     * DOCUMENT ME!
     *
     * @param  oben  DOCUMENT ME!
     */
    public void setOben(final int oben) {
        this.oben = oben;
        if (!relativeHeights) {
            obenFraction = (double)getOben() / (double)getHeight();
        }
        repaint();
    }

    /**
     * DOCUMENT ME!
     *
     * @param  fractionOben  DOCUMENT ME!
     */
    public void setOben(final double fractionOben) {
        obenFraction = fractionOben;
        final int o = (int)(((double)getHeight()) * fractionOben);
        setOben(o);
    }

    /**
     * DOCUMENT ME!
     *
     * @param  fractionUnten  DOCUMENT ME!
     */
    public void setUnten(final double fractionUnten) {
        untenFraction = fractionUnten;
        final int u = (int)(((double)getHeight()) * fractionUnten);
        setUnten(u);
    }

    /**
     * DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    public int getUnten() {
        return unten;
    }

    /**
     * DOCUMENT ME!
     *
     * @param  unten  DOCUMENT ME!
     */
    public void setUnten(final int unten) {
        this.unten = unten;
        if (!relativeHeights) {
            untenFraction = (double)getUnten() / (double)getHeight();
        }
        repaint();
    }

    /**
     * DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    public boolean isRelativeHeights() {
        return relativeHeights;
    }

    /**
     * DOCUMENT ME!
     *
     * @param  relativeHeights  DOCUMENT ME!
     */
    public void setRelativeHeights(final boolean relativeHeights) {
        this.relativeHeights = relativeHeights;
    }
}
