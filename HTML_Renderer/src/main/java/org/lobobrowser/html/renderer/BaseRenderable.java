/*
    GNU GENERAL PUBLIC LICENSE
    Copyright (C) 2006 The Lobo Project. Copyright (C) 2014 - 2015 Lobo Evolution

    This program is free software; you can redistribute it and/or
    modify it under the terms of the GNU General Public
    License as published by the Free Software Foundation; either
    verion 2 of the License, or (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
    General Public License for more details.

    You should have received a copy of the GNU General Public
    License along with this library; if not, write to the Free Software
    Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA

    Contact info: lobochief@users.sourceforge.net; ivan.difrancesco@yahoo.it
 */
package org.lobobrowser.html.renderer;

/**
 * The Class BaseRenderable.
 */
abstract class BaseRenderable implements Renderable {

    /** The ordinal. */
    private int ordinal = 0;

    /**
     * Gets the ordinal.
     *
     * @return the ordinal
     */
    public int getOrdinal() {
        return this.ordinal;
    }

    /**
     * Gets the z index.
     *
     * @return the z index
     */
    public int getZIndex() {
        return 0;
    }

    /**
     * Sets the ordinal.
     *
     * @param ordinal
     *            the new ordinal
     */
    public void setOrdinal(int ordinal) {
        this.ordinal = ordinal;
    }
}
