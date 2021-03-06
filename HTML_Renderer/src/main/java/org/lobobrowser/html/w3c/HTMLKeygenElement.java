/*
    GNU GENERAL LICENSE
    Copyright (C) 2006 The Lobo Project. Copyright (C) 2014 - 2015 Lobo Evolution

    This program is free software; you can redistribute it and/or
    modify it under the terms of the GNU General Public
    License as published by the Free Software Foundation; either
    verion 2 of the License, or (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
    General License for more details.

    You should have received a copy of the GNU General Public
    License along with this library; if not, write to the Free Software
    Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA

    Contact info: lobochief@users.sourceforge.net; ivan.difrancesco@yahoo.it
 */
package org.lobobrowser.html.w3c;

import org.w3c.dom.NodeList;

/**
 * The public interface HTMLKeygenElement.
 */
public interface HTMLKeygenElement extends HTMLElement {
    // HTMLKeygenElement
    /**
     * Gets the autofocus.
     *
     * @return the autofocus
     */
    boolean getAutofocus();

    /**
     * Sets the autofocus.
     *
     * @param autofocus
     *            the new autofocus
     */
    void setAutofocus(boolean autofocus);

    /**
     * Gets the challenge.
     *
     * @return the challenge
     */
    String getChallenge();

    /**
     * Sets the challenge.
     *
     * @param challenge
     *            the new challenge
     */
    void setChallenge(String challenge);

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLElement#getDisabled()
     */
    @Override
    boolean getDisabled();

    /**
     * Sets the disabled.
     *
     * @param disabled
     *            the new disabled
     */
    void setDisabled(boolean disabled);

    /**
     * Gets the form.
     *
     * @return the form
     */
    HTMLFormElement getForm();

    /**
     * Gets the keytype.
     *
     * @return the keytype
     */
    String getKeytype();

    /**
     * Sets the keytype.
     *
     * @param keytype
     *            the new keytype
     */
    void setKeytype(String keytype);

    /**
     * Gets the name.
     *
     * @return the name
     */
    String getName();

    /**
     * Sets the name.
     *
     * @param name
     *            the new name
     */
    void setName(String name);

    /**
     * Gets the type.
     *
     * @return the type
     */
    String getType();

    /**
     * Gets the will validate.
     *
     * @return the will validate
     */
    boolean getWillValidate();

    /**
     * Gets the validity.
     *
     * @return the validity
     */
    ValidityState getValidity();

    /**
     * Gets the validation message.
     *
     * @return the validation message
     */
    String getValidationMessage();

    /**
     * Check validity.
     *
     * @return true, if successful
     */
    boolean checkValidity();

    /**
     * Sets the custom validity.
     *
     * @param error
     *            the new custom validity
     */
    void setCustomValidity(String error);

    /**
     * Gets the labels.
     *
     * @return the labels
     */
    NodeList getLabels();
}
