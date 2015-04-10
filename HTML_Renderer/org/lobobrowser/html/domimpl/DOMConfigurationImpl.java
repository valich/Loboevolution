/*
    GNU LESSER GENERAL PUBLIC LICENSE
    Copyright (C) 2006 The Lobo Project. Copyright (C) 2014 - 2015 Lobo Evolution

    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU Lesser General Public
    License as published by the Free Software Foundation; either
    version 2.1 of the License, or (at your option) any later version.

    This library is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
    Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public
    License along with this library; if not, write to the Free Software
    Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA

    Contact info: lobochief@users.sourceforge.net; ivan.difrancesco@yahoo.it
 */
/*
 * Created on Oct 9, 2005
 */
package org.lobobrowser.html.domimpl;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMStringList;


/**
 * The Class DOMConfigurationImpl.
 */
public class DOMConfigurationImpl implements DOMConfiguration {
	
	/** The parameters. */
	private final Map<String, Object> parameters = new HashMap<String, Object>();

	/**
	 * Instantiates a new DOM configuration impl.
	 */
	public DOMConfigurationImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see org.w3c.dom.DOMConfiguration#setParameter(java.lang.String, java.lang.Object)
	 */
	public void setParameter(String name, Object value) throws DOMException {
		synchronized (this) {
			this.parameters.put(name, value);
		}
	}

	/* (non-Javadoc)
	 * @see org.w3c.dom.DOMConfiguration#getParameter(java.lang.String)
	 */
	public Object getParameter(String name) throws DOMException {
		synchronized (this) {
			return this.parameters.get(name);
		}
	}

	/* (non-Javadoc)
	 * @see org.w3c.dom.DOMConfiguration#canSetParameter(java.lang.String, java.lang.Object)
	 */
	public boolean canSetParameter(String name, Object value) {
		// TODO
		return true;
	}

	/* (non-Javadoc)
	 * @see org.w3c.dom.DOMConfiguration#getParameterNames()
	 */
	public DOMStringList getParameterNames() {
		synchronized (this) {
			return new DOMStringListImpl(parameters.keySet());
		}
	}
}