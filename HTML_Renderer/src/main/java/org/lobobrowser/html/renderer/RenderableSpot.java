/*
 * GNU LESSER GENERAL PUBLIC LICENSE Copyright (C) 2006 The Lobo Project.
 * Copyright (C) 2014 - 2015 Lobo Evolution This library is free software; you
 * can redistribute it and/or modify it under the terms of the GNU Lesser
 * General Public License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version. This
 * library is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details. You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA
 * Contact info: lobochief@users.sourceforge.net; ivan.difrancesco@yahoo.it
 */

package org.lobobrowser.html.renderer;

import java.awt.Point;

/**
 * Contains a renderer node and a position in that node.
 */
public class RenderableSpot {

    /** The renderable. */
    public final BoundableRenderable renderable;

    /** The x. */
    public final int x;

    /** The y. */
    public final int y;

    /**
     * Instantiates a new renderable spot.
     *
     * @param renderable
     *            the renderable
     * @param x
     *            the x
     * @param y
     *            the y
     */
    public RenderableSpot(BoundableRenderable renderable, int x, int y) {
        super();
        this.renderable = renderable;
        this.x = x;
        this.y = y;
    }

    /**
     * Gets the point.
     *
     * @return the point
     */
    public Point getPoint() {
        return new Point(this.x, this.y);
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof RenderableSpot)) {
            return false;
        }
        RenderableSpot otherRp = (RenderableSpot) other;
        return (otherRp.renderable == this.renderable) && (otherRp.x == this.x)
                && (otherRp.y == this.y);
    }
}
