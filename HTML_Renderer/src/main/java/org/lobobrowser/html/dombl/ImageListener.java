/*
 * GNU LESSER GENERAL LICENSE Copyright (C) 2006 The Lobo Project.
 * Copyright (C) 2014 - 2015 Lobo Evolution This library is free software; you
 * can redistribute it and/or modify it under the terms of the GNU Lesser
 * General License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version. This
 * library is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU Lesser General License for more
 * details. You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA
 * Contact info: lobochief@users.sourceforge.net; ivan.difrancesco@yahoo.it
 */
package org.lobobrowser.html.dombl;

/**
 * The listener interface for receiving image events. The class that is
 * interested in processing a image event implements this interface, and the
 * object created with that class is registered with a component using the
 * component's <code>addImageListener</code> method. When the image event
 * occurs, that object's appropriate method is invoked.
 *
 * @see ImageEvent
 */
public interface ImageListener extends java.util.EventListener {

    /** The Constant EMPTY_ARRAY. */
    ImageListener[] EMPTY_ARRAY = new ImageListener[0];

    /**
     * Image loaded.
     *
     * @param event
     *            the event
     */
    void imageLoaded(ImageEvent event);
}
