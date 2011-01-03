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

import com.jhlabs.math.*;

import java.awt.image.*;

import java.util.*;

/**
 * DOCUMENT ME!
 *
 * @version  $Revision$, $Date$
 */
public class MarbleTexFilter extends PointFilter {

    //~ Instance fields --------------------------------------------------------

    private float scale = 32;
    private float stretch = 1.0f;
    private float angle = 0.0f;
    private float turbulence = 1;
    private float turbulenceFactor = 0.5f;
    private Colormap colormap;
    private float m00 = 1.0f;
    private float m01 = 0.0f;
    private float m10 = 0.0f;
    private float m11 = 1.0f;

    //~ Constructors -----------------------------------------------------------

    /**
     * Creates a new MarbleTexFilter object.
     */
    public MarbleTexFilter() {
    }

    //~ Methods ----------------------------------------------------------------

    /**
     * DOCUMENT ME!
     *
     * @param  scale  DOCUMENT ME!
     */
    public void setScale(final float scale) {
        this.scale = scale;
    }

    /**
     * DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    public float getScale() {
        return scale;
    }

    /**
     * DOCUMENT ME!
     *
     * @param  stretch  DOCUMENT ME!
     */
    public void setStretch(final float stretch) {
        this.stretch = stretch;
    }

    /**
     * DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    public float getStretch() {
        return stretch;
    }

    /**
     * DOCUMENT ME!
     *
     * @param  angle  DOCUMENT ME!
     */
    public void setAngle(final float angle) {
        this.angle = angle;
        final float cos = (float)Math.cos(angle);
        final float sin = (float)Math.sin(angle);
        m00 = cos;
        m01 = sin;
        m10 = -sin;
        m11 = cos;
    }

    /**
     * DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    public float getAngle() {
        return angle;
    }

    /**
     * DOCUMENT ME!
     *
     * @param  turbulence  DOCUMENT ME!
     */
    public void setTurbulence(final float turbulence) {
        this.turbulence = turbulence;
    }

    /**
     * DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    public float getTurbulence() {
        return turbulence;
    }

    /**
     * DOCUMENT ME!
     *
     * @param  turbulenceFactor  DOCUMENT ME!
     */
    public void setTurbulenceFactor(final float turbulenceFactor) {
        this.turbulenceFactor = turbulenceFactor;
    }

    /**
     * DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    public float getTurbulenceFactor() {
        return turbulenceFactor;
    }

    /**
     * DOCUMENT ME!
     *
     * @param  colormap  DOCUMENT ME!
     */
    public void setColormap(final Colormap colormap) {
        this.colormap = colormap;
    }

    /**
     * DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    public Colormap getColormap() {
        return colormap;
    }

    @Override
    public int filterRGB(final int x, final int y, final int rgb) {
        float nx = (m00 * x) + (m01 * y);
        float ny = (m10 * x) + (m11 * y);
        nx /= scale * stretch;
        ny /= scale;

        final int a = rgb & 0xff000000;
        if (colormap != null) {
//                      float f = Noise.turbulence2(nx, ny, turbulence);
//                      f = 3*turbulenceFactor*f+ny;
//                      f = Math.sin(f*Math.PI);
            final float chaos = turbulenceFactor * Noise.turbulence2(nx, ny, turbulence);
//                      float f = Math.sin(Math.sin(8.*chaos + 7*nx +3.*ny));
            float f = (3 * turbulenceFactor * chaos) + ny;
            f = (float)Math.sin(f * Math.PI);
            final float perturb = (float)Math.sin(40. * chaos);
            f += .2 * perturb;
            return colormap.getColor(f);
        } else {
            final float red;
            float grn;
            final float blu;
            final float chaos;
            float brownLayer;
            float greenLayer;
            float perturb;
            final float brownPerturb;
            final float greenPerturb;
            final float grnPerturb;
            final float t;

            chaos = turbulenceFactor * Noise.turbulence2(nx, ny, turbulence);
            t = (float)Math.sin(Math.sin((8. * chaos) + (7 * nx) + (3. * ny)));

            greenLayer = brownLayer = Math.abs(t);

            perturb = (float)Math.sin(40. * chaos);
            perturb = (float)Math.abs(perturb);

            brownPerturb = (.6f * perturb) + 0.3f;
            greenPerturb = (.2f * perturb) + 0.8f;
            grnPerturb = (.15f * perturb) + 0.85f;
            grn = 0.5f * (float)Math.pow(Math.abs(brownLayer), 0.3);
            brownLayer = (float)Math.pow(0.5 * (brownLayer + 1.0), 0.6) * brownPerturb;
            greenLayer = (float)Math.pow(0.5 * (greenLayer + 1.0), 0.6) * greenPerturb;

            red = ((0.5f * brownLayer) + (0.35f * greenLayer)) * 2.0f * grn;
            blu = ((0.25f * brownLayer) + (0.35f * greenLayer)) * 2.0f * grn;
            grn *= Math.max(brownLayer, greenLayer) * grnPerturb;
            int r = (rgb >> 16) & 0xff;
            int g = (rgb >> 8) & 0xff;
            int b = rgb & 0xff;
            r = PixelUtils.clamp((int)(r * red));
            g = PixelUtils.clamp((int)(g * grn));
            b = PixelUtils.clamp((int)(b * blu));
            return (rgb & 0xff000000) | (r << 16) | (g << 8) | b;
        }
    }

    @Override
    public String toString() {
        return "Texture/Marble Texture...";
    }
}
