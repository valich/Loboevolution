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
package org.lobobrowser.js;

import java.lang.reflect.Method;

/**
 * The Class PropertyInfo.
 */
public class PropertyInfo {

    /** The name. */
    private final String name;

    /** The property type. */
    private final Class propertyType;

    /** The setter. */
    private Method getter, setter;

    /**
     * Instantiates a new property info.
     *
     * @param name
     *            the name
     * @param propType
     *            the prop type
     */
    public PropertyInfo(String name, Class propType) {
        super();
        this.name = name;
        this.propertyType = propType;
    }

    /**
     * Gets the getter.
     *
     * @return the getter
     */
    public Method getGetter() {
        return getter;
    }

    /**
     * Sets the getter.
     *
     * @param getter
     *            the new getter
     */
    public void setGetter(Method getter) {
        this.getter = getter;
    }

    /**
     * Gets the setter.
     *
     * @return the setter
     */
    public Method getSetter() {
        return setter;
    }

    /**
     * Sets the setter.
     *
     * @param setter
     *            the new setter
     */
    public void setSetter(Method setter) {
        this.setter = setter;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the property type.
     *
     * @return the property type
     */
    public Class getPropertyType() {
        return propertyType;
    }
}
