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
 * MA 02110-1301 USA Contact info: lobochief@users.sourceforge.net
 */
package org.lobobrowser.html.domimpl;

import org.lobobrowser.html.HtmlAttributeProperties;
import org.lobobrowser.html.w3c.HTMLFormElement;
import org.lobobrowser.html.w3c.HTMLProgressElement;
import org.w3c.dom.NodeList;

/**
 * The Class HTMLProgressElementImpl.
 */
public class HTMLProgressElementImpl extends HTMLElementImpl implements
HTMLProgressElement {

    /**
     * Instantiates a new HTML progress element impl.
     *
     * @param name
     *            the name
     */
    public HTMLProgressElementImpl(String name) {
        super(name);
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLProgressElement#getValue()
     */
    @Override
    public float getValue() {
        try {
            return Integer.parseInt(this
                    .getAttribute(HtmlAttributeProperties.VALUE));
        } catch (Exception thrown) {
            this.warn("getSize(): Unable to parse size attribute in " + this
                    + ".", thrown);
            return 0;
        }
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLProgressElement#setValue(float)
     */
    @Override
    public void setValue(float value) {
        this.setAttribute(HtmlAttributeProperties.VALUE, String.valueOf(value));

    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLProgressElement#getMax()
     */
    @Override
    public float getMax() {
        try {
            return Integer.parseInt(this
                    .getAttribute(HtmlAttributeProperties.MAX));
        } catch (Exception thrown) {
            this.warn("getSize(): Unable to parse size attribute in " + this
                    + ".", thrown);
            return 0;
        }
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLProgressElement#setMax(float)
     */
    @Override
    public void setMax(float max) {
        this.setAttribute(HtmlAttributeProperties.VALUE, String.valueOf(max));
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLProgressElement#getPosition()
     */
    @Override
    public float getPosition() {
        // TODO Auto-generated method stub
        return 0;
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLProgressElement#getForm()
     */
    @Override
    public HTMLFormElement getForm() {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLProgressElement#getLabels()
     */
    @Override
    public NodeList getLabels() {
        // TODO Auto-generated method stub
        return null;
    }

}
