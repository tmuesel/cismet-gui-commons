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
import java.awt.image.*;

/**
 * A filter for changing the gamma of an image.
 *
 * @version  $Revision$, $Date$
 */
public class GammaFilter extends TransferFilter {

    //~ Instance fields --------------------------------------------------------

    private float rGamma;
    private float gGamma;
    private float bGamma;

    //~ Constructors -----------------------------------------------------------

    /**
     * Construct a GammaFilter.
     */
    public GammaFilter() {
        this(1.0f);
    }

    /**
     * Construct a GammaFilter.
     *
     * @param  gamma  the gamma level for all RGB channels
     */
    public GammaFilter(final float gamma) {
        this(gamma, gamma, gamma);
    }

    /**
     * Construct a GammaFilter.
     *
     * @param  rGamma  the gamma level for the red channel
     * @param  gGamma  the gamma level for the blue channel
     * @param  bGamma  the gamma level for the green channel
     */
    public GammaFilter(final float rGamma, final float gGamma, final float bGamma) {
        setGamma(rGamma, gGamma, bGamma);
    }

    //~ Methods ----------------------------------------------------------------

    /**
     * Set the gamma levels.
     *
     * @param  rGamma  the gamma level for the red channel
     * @param  gGamma  the gamma level for the blue channel
     * @param  bGamma  the gamma level for the green channel
     *
     * @see    #getGamma
     */
    public void setGamma(final float rGamma, final float gGamma, final float bGamma) {
        this.rGamma = rGamma;
        this.gGamma = gGamma;
        this.bGamma = bGamma;
        initialized = false;
    }

    /**
     * Set the gamma level.
     *
     * @param  gamma  the gamma level for all RGB channels
     *
     * @see    #getGamma
     */
    public void setGamma(final float gamma) {
        setGamma(gamma, gamma, gamma);
    }

    /**
     * Get the gamma level.
     *
     * @return  the gamma level for all RGB channels
     *
     * @see     #setGamma
     */
    public float getGamma() {
        return rGamma;
    }

    @Override
    protected void initialize() {
        rTable = makeTable(rGamma);

        if (gGamma == rGamma) {
            gTable = rTable;
        } else {
            gTable = makeTable(gGamma);
        }

        if (bGamma == rGamma) {
            bTable = rTable;
        } else if (bGamma == gGamma) {
            bTable = gTable;
        } else {
            bTable = makeTable(bGamma);
        }
    }

    /**
     * DOCUMENT ME!
     *
     * @param   gamma  DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    private int[] makeTable(final float gamma) {
        final int[] table = new int[256];
        for (int i = 0; i < 256; i++) {
            int v = (int)((255.0 * Math.pow(i / 255.0, 1.0 / gamma)) + 0.5);
            if (v > 255) {
                v = 255;
            }
            table[i] = v;
        }
        return table;
    }

    @Override
    public String toString() {
        return "Colors/Gamma..."; // NOI18N
    }
}
