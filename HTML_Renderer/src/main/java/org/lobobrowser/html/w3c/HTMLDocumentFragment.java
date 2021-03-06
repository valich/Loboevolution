/*
 * GNU LESSER GENERAL LICENSE Copyright (C) 2006 The XAMJ Project This
 * library is free software; you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version. This library is distributed in the hope that it will be
 * useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser
 * General License for more details. You should have received a copy of
 * the GNU Lesser General License along with this library; if not, write
 * to the Free Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston,
 * MA 02110-1301 USA Contact info: lobochief@users.sourceforge.net
 */
package org.lobobrowser.html.w3c;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * The public interface HTMLDocumentFragment.
 */
public interface HTMLDocumentFragment {

    /**
     * Query selector.
     *
     * @param selectors
     *            the selectors
     * @return the element
     */
    Element querySelector(String selectors);

    /**
     * Query selector all.
     *
     * @param selectors
     *            the selectors
     * @return the node list
     */
    NodeList querySelectorAll(String selectors);
}
