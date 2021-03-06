/*
 * GNU LESSER GENERAL PUBLIC LICENSE Copyright (C) 2006 The XAMJ Project This
 * library is free software; you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version. This library is distributed in the hope that it will be
 * useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser
 * General Public License for more details. You should have received a copy of
 * the GNU Lesser General Public License along with this library; if not, write
 * to the Free Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston,
 * MA 02110-1301 USA Contact info: ivan.difrancesco@yahoo.it
 */
package org.lobobrowser.html.domimpl;

import org.lobobrowser.html.renderstate.NavRenderState;
import org.lobobrowser.html.renderstate.RenderState;
import org.lobobrowser.html.w3c.HTMLNavElement;

/**
 * The Class HTMLNavElementImpl.
 */
public class HTMLNavElementImpl extends HTMLAbstractUIElement implements
HTMLNavElement {

    /**
     * Instantiates a new HTML nav element impl.
     *
     * @param name
     *            the name
     */
    public HTMLNavElementImpl(String name) {
        super(name);
    }

    /*
     * (non-Javadoc)
     * @see
     * org.lobobrowser.html.domimpl.HTMLElementImpl#createRenderState(org.lobobrowser
     * .html.renderstate.RenderState)
     */
    @Override
    protected RenderState createRenderState(RenderState prevRenderState) {
        return new NavRenderState(prevRenderState, this);
    }

}
