/***************************************************
*
* cismet GmbH, Saarbruecken, Germany
*
*              ... and it just works.
*
****************************************************/
/*
Copyright 2006 Jerry Huxtable

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package com.jhlabs.image;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;

/**
 * A filter which crops an image to a given rectangle.
 *
 * @version  $Revision$, $Date$
 */
public class CropFilter extends AbstractBufferedImageOp {

    //~ Instance fields --------------------------------------------------------

    private int x;
    private int y;
    private int width;
    private int height;

    //~ Constructors -----------------------------------------------------------

    /**
     * Construct a CropFilter.
     */
    public CropFilter() {
        this(0, 0, 32, 32);
    }

    /**
     * Construct a CropFilter.
     *
     * @param  x       the left edge of the crop rectangle
     * @param  y       the top edge of the crop rectangle
     * @param  width   the width of the crop rectangle
     * @param  height  the height of the crop rectangle
     */
    public CropFilter(final int x, final int y, final int width, final int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    //~ Methods ----------------------------------------------------------------

    /**
     * Set the left edge of the crop rectangle.
     *
     * @param  x  the left edge of the crop rectangle
     *
     * @see    #getX
     */
    public void setX(final int x) {
        this.x = x;
    }

    /**
     * Get the left edge of the crop rectangle.
     *
     * @return  the left edge of the crop rectangle
     *
     * @see     #setX
     */
    public int getX() {
        return x;
    }

    /**
     * Set the top edge of the crop rectangle.
     *
     * @param  y  the top edge of the crop rectangle
     *
     * @see    #getY
     */
    public void setY(final int y) {
        this.y = y;
    }

    /**
     * Get the top edge of the crop rectangle.
     *
     * @return  the top edge of the crop rectangle
     *
     * @see     #setY
     */
    public int getY() {
        return y;
    }

    /**
     * Set the width of the crop rectangle.
     *
     * @param  width  the width of the crop rectangle
     *
     * @see    #getWidth
     */
    public void setWidth(final int width) {
        this.width = width;
    }

    /**
     * Get the width of the crop rectangle.
     *
     * @return  the width of the crop rectangle
     *
     * @see     #setWidth
     */
    public int getWidth() {
        return width;
    }

    /**
     * Set the height of the crop rectangle.
     *
     * @param  height  the height of the crop rectangle
     *
     * @see    #getHeight
     */
    public void setHeight(final int height) {
        this.height = height;
    }

    /**
     * Get the height of the crop rectangle.
     *
     * @return  the height of the crop rectangle
     *
     * @see     #setHeight
     */
    public int getHeight() {
        return height;
    }

    @Override
    public BufferedImage filter(final BufferedImage src, BufferedImage dst) {
        final int w = src.getWidth();
        final int h = src.getHeight();

        if (dst == null) {
            final ColorModel dstCM = src.getColorModel();
            dst = new BufferedImage(
                    dstCM,
                    dstCM.createCompatibleWritableRaster(width, height),
                    dstCM.isAlphaPremultiplied(),
                    null);
        }

        final Graphics2D g = dst.createGraphics();
        g.drawRenderedImage(src, AffineTransform.getTranslateInstance(-x, -y));
        g.dispose();

        return dst;
    }

    @Override
    public String toString() {
        return "Distort/Crop"; // NOI18N
    }
}
