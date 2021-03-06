/*
 * GNU LESSER GENERAL PUBLIC LICENSE Copyright (C) 2006 The XAMJ Project.
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

/**
 * The Class ExportableFloat.
 */
public class ExportableFloat {

    /** The Constant EMPTY_ARRAY. */
    public static final ExportableFloat[] EMPTY_ARRAY = new ExportableFloat[0];

    /** The element. */
    public final BoundableRenderable element;

    /** The left float. */
    public final boolean leftFloat;

    /** The orig x. */
    public final int origX;

    /** The orig y. */
    public final int origY;

    /**
     * Instantiates a new exportable float.
     *
     * @param element
     *            the element
     * @param leftFloat
     *            the left float
     * @param origX
     *            the orig x
     * @param origY
     *            the orig y
     */
    public ExportableFloat(BoundableRenderable element, boolean leftFloat,
            int origX, int origY) {
        super();
        this.element = element;
        this.leftFloat = leftFloat;
        this.origX = origX;
        this.origY = origY;
    }
}
