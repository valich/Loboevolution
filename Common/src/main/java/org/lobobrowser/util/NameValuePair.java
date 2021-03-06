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
/*
 * Created on Jun 12, 2005
 */
package org.lobobrowser.util;

/**
 * The Class NameValuePair.
 *
 * @author J. H. S.
 */
public class NameValuePair extends AbstractBean implements Cloneable {
    /** The name. */
    public String name;
    /** The value. */
    public String value;

    /**
     * Instantiates a new name value pair.
     */
    public NameValuePair() {
    }

    /**
     * Instantiates a new name value pair.
     *
     * @param name
     *            the name
     * @param value
     *            the value
     */
    public NameValuePair(String name, String value) {
        this.name = name;
        this.value = value;
    }

    /**
     * Sets the name.
     *
     * @param name
     *            the new name
     */
    public void setName(String name) {
        String old = getName();
        this.name = name;
        firePropertyChange("name", old, name);
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * Sets the value.
     *
     * @param value
     *            the new value
     */
    public void setValue(String value) {
        String old = getValue();
        this.value = value;
        firePropertyChange("value", old, value);
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public final String getValue() {
        return value;
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.util.AbstractBean#clone()
     */
    @Override
    public NameValuePair clone() {
        return new NameValuePair(name, value);
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return name + "=" + value;
    }
}
