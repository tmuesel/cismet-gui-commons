/***************************************************
 *
 * cismet GmbH, Saarbruecken, Germany
 *
 *              ... and it just works.
 *
 ****************************************************/
/*
 *  Copyright (C) 2011 thorsten
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.cismet.tools.gui.startup;

import com.jhlabs.image.BoxBlurFilter;
import de.cismet.tools.gui.Static2DTools;

import org.jdesktop.swingx.JXBusyLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Transparency;
import java.awt.image.BufferedImage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import org.jdesktop.swingx.JXPanel;
import org.jdesktop.swingx.painter.CompoundPainter;
import org.jdesktop.swingx.painter.GlossPainter;
import org.jdesktop.swingx.painter.ImagePainter;

/**
 * DOCUMENT ME!
 *
 * @author   thorsten
 * @version  $Revision$, $Date$
 */
public class StaticStartupTools {

    //~ Static fields/initializers ---------------------------------------------
    private static final transient org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(
            StaticStartupTools.class);

    //~ Methods ----------------------------------------------------------------
    /**
     * DOCUMENT ME!
     *
     * @param   frame  DOCUMENT ME!
     * @param   file    DOCUMENT ME!
     *
     * @throws  Exception  DOCUMENT ME!
     */
    public static void saveScreenshotOfFrame(final JFrame frame, final String file) throws Exception {
        try {
            if (!EventQueue.isDispatchThread()) {
                log.fatal("not in EDT");
            }
            GraphicsConfiguration configuration = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();

            //Create a buffered image which is the right (translucent) format for the current graphics device, this
            //should ensure the fastest possible performance. Adding on some extra height to make room for the reflection

            final BufferedImage bi = configuration.createCompatibleImage(frame.getWidth(), frame.getHeight(), Transparency.TRANSLUCENT);
            final Graphics g = bi.getGraphics();
            //((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .4f));
            frame.paintAll(g);
            g.dispose();
            final BoxBlurFilter blurFilter = new BoxBlurFilter();
            blurFilter.setRadius(1);
            blurFilter.filter(bi, bi);
            ImageIO.write(bi, "png", new File(file + ".png"));
            final File boundsFile = new File(file + ".bounds");
            boundsFile.createNewFile();
            final BufferedWriter writer = new BufferedWriter(new FileWriter(boundsFile));
            writer.write(Integer.toString(new Double(frame.getBounds().getX()).intValue()) + "\n");
            writer.write(Integer.toString(new Double(frame.getBounds().getY()).intValue()) + "\n");
            writer.write(Integer.toString(new Double(frame.getBounds().getWidth()).intValue()) + "\n");
            writer.write(Integer.toString(new Double(frame.getBounds().getHeight()).intValue()) + "\n");
            writer.close();
        } catch (Throwable throwable) {
            log.fatal("BUMM",throwable);
        }
    }

    /**
     * DOCUMENT ME!
     *
     * @param   file   DOCUMENT ME!
     * @param   title  DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     *
     * @throws  Exception  DOCUMENT ME!
     */
    public static JFrame showGhostFrame(final String file, final String title) throws Exception {
        final File boundsFile = new File(file + ".bounds");
        Rectangle rectangle = null;

        final BufferedReader reader = new BufferedReader(new FileReader(boundsFile));
        final String x = reader.readLine();
        final String y = reader.readLine();
        final String width = reader.readLine();
        final String height = reader.readLine();
        reader.close();
        rectangle = new Rectangle();
        rectangle.setBounds(Integer.parseInt(x),
                Integer.parseInt(y),
                Integer.parseInt(width),
                Integer.parseInt(height));
        final ImageIcon i = new ImageIcon(file + ".png");
        final BufferedImage bi = (BufferedImage) (Static2DTools.removeUnusedBorder(i.getImage(), 0, 1));
        final JFrame fake = new JFrame(title);
        JXPanel p = new JXPanel();
        p.setAlpha(.5f);

        p.setLayout(new BorderLayout());
        //p.setImage(ii.getImage());
        fake.getContentPane().add(p, BorderLayout.CENTER);
        if (rectangle != null) {
            fake.setBounds(rectangle);
        }

        JXBusyLabel busy = new JXBusyLabel(new Dimension(100, 100));
        GlossPainter gp = new GlossPainter(new Color(255, 255, 255, 25),
                GlossPainter.GlossPosition.TOP);
        ImagePainter ip = new ImagePainter(bi);


        p.setBackgroundPainter(new CompoundPainter(ip, gp));

        busy.setDelay(100);
        busy.setOpaque(false);
        busy.setBusy(true);
        busy.setHorizontalAlignment(busy.CENTER);

        p.add(busy, BorderLayout.CENTER);
        fake.setVisible(true);
        return fake;
    }

    /**
     * DOCUMENT ME!
     *
     * @param   args  DOCUMENT ME!
     *
     * @throws  Exception  DOCUMENT ME!
     */
    public static void main(final String[] args) throws Exception {
        final JFrame f = showGhostFrame("/Users/thorsten/.verdis/verdis.screen", "xxx");
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
    }
}
