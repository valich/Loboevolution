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
/*
 * Copyright (c) 2003 World Wide Web Consortium, (Massachusetts Institute of
 * Technology, Institut National de Recherche en Informatique et en Automatique,
 * Keio University). All Rights Reserved. This program is distributed under the
 * W3C's Software Intellectual Property License. This program is distributed in
 * the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the
 * implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See
 * W3C License http://www.w3.org/Consortium/Legal/ for more details.
 */

package org.lobobrowser.html.w3c;

import org.w3c.dom.Document;

/**
 * Generic embedded object.In principle, all properties on the object element
 * are read-write but in some environments some properties may be read-only once
 * the underlying object is instantiated. See the OBJECT element definition in
 * [<a href='http://www.w3.org/TR/1999/REC-html401-19991224'>HTML 4.01</a>].
 * <p>
 * See also the Object Model (DOM) Level 2 HTML Specification
 * </p>
 * .
 */
public interface HTMLObjectElement extends HTMLElement {

    /**
     * Returns the <code>FORM</code> element containing this control. Returns
     * <code>null</code> if this control is not within the context of a form.
     *
     * @return the form
     */
    HTMLFormElement getForm();

    /**
     * Applet class file. See the <code>code</code> attribute for
     * HTMLAppletElement.
     *
     * @return the code
     */
    String getCode();

    /**
     * Applet class file. See the <code>code</code> attribute for
     * HTMLAppletElement.
     *
     * @param code
     *            the new code
     */
    void setCode(String code);

    /**
     * Aligns this object (vertically or horizontally) with respect to its
     * surrounding text. See the align attribute definition in HTML 4.01. This
     * attribute is deprecated in HTML 4.01.
     *
     * @return the align
     */
    String getAlign();

    /**
     * Aligns this object (vertically or horizontally) with respect to its
     * surrounding text. See the align attribute definition in HTML 4.01. This
     * attribute is deprecated in HTML 4.01.
     *
     * @param align
     *            the new align
     */
    void setAlign(String align);

    /**
     * Space-separated list of archives. See the archive attribute definition in
     * HTML 4.01.
     *
     * @return the archive
     */
    String getArchive();

    /**
     * Space-separated list of archives. See the archive attribute definition in
     * HTML 4.01.
     *
     * @param archive
     *            the new archive
     */
    void setArchive(String archive);

    /**
     * Width of border around the object. See the border attribute definition in
     * HTML 4.01. This attribute is deprecated in HTML 4.01.
     *
     * @return the border
     */
    String getBorder();

    /**
     * Width of border around the object. See the border attribute definition in
     * HTML 4.01. This attribute is deprecated in HTML 4.01.
     *
     * @param border
     *            the new border
     */
    void setBorder(String border);

    /**
     * Base URI [<a href='http://www.ietf.org/rfc/rfc2396.txt'>IETF RFC
     * 2396</a>] for <code>classid</code>, <code>data</code>, and
     * <code>archive</code> attributes. See the codebase attribute definition in
     * HTML 4.01.
     *
     * @return the code base
     */
    String getCodeBase();

    /**
     * Base URI [<a href='http://www.ietf.org/rfc/rfc2396.txt'>IETF RFC
     * 2396</a>] for <code>classid</code>, <code>data</code>, and
     * <code>archive</code> attributes. See the codebase attribute definition in
     * HTML 4.01.
     *
     * @param codeBase
     *            the new code base
     */
    void setCodeBase(String codeBase);

    /**
     * Content type for data downloaded via <code>classid</code> attribute. See
     * the codetype attribute definition in HTML 4.01.
     *
     * @return the code type
     */
    String getCodeType();

    /**
     * Content type for data downloaded via <code>classid</code> attribute. See
     * the codetype attribute definition in HTML 4.01.
     *
     * @param codeType
     *            the new code type
     */
    void setCodeType(String codeType);

    /**
     * A URI [<a href='http://www.ietf.org/rfc/rfc2396.txt'>IETF RFC 2396</a>]
     * specifying the location of the object's data. See the data attribute
     * definition in HTML 4.01.
     *
     * @return the data
     */
    String getData();

    /**
     * A URI [<a href='http://www.ietf.org/rfc/rfc2396.txt'>IETF RFC 2396</a>]
     * specifying the location of the object's data. See the data attribute
     * definition in HTML 4.01.
     *
     * @param data
     *            the new data
     */
    void setData(String data);

    /**
     * Declare (for future reference), but do not instantiate, this object. See
     * the declare attribute definition in HTML 4.01.
     *
     * @return the declare
     */
    boolean getDeclare();

    /**
     * Declare (for future reference), but do not instantiate, this object. See
     * the declare attribute definition in HTML 4.01.
     *
     * @param declare
     *            the new declare
     */
    void setDeclare(boolean declare);

    /**
     * Override height. See the height attribute definition in HTML 4.01.
     *
     * @return the height
     */
    String getHeight();

    /**
     * Override height. See the height attribute definition in HTML 4.01.
     *
     * @param height
     *            the new height
     */
    void setHeight(String height);

    /**
     * Horizontal space, in pixels, to the left and right of this image, applet,
     * or object. See the hspace attribute definition in HTML 4.01. This
     * attribute is deprecated in HTML 4.01.
     *
     * @return the hspace
     */
    int getHspace();

    /**
     * Horizontal space, in pixels, to the left and right of this image, applet,
     * or object. See the hspace attribute definition in HTML 4.01. This
     * attribute is deprecated in HTML 4.01.
     *
     * @param hspace
     *            the new hspace
     */
    void setHspace(int hspace);

    /**
     * Form control or object name when submitted with a form. See the name
     * attribute definition in HTML 4.01.
     *
     * @return the name
     */
    String getName();

    /**
     * Form control or object name when submitted with a form. See the name
     * attribute definition in HTML 4.01.
     *
     * @param name
     *            the new name
     */
    void setName(String name);

    /**
     * Message to render while loading the object. See the standby attribute
     * definition in HTML 4.01.
     *
     * @return the standby
     */
    String getStandby();

    /**
     * Message to render while loading the object. See the standby attribute
     * definition in HTML 4.01.
     *
     * @param standby
     *            the new standby
     */
    void setStandby(String standby);

    /**
     * Index that represents the element's position in the tabbing order. See
     * the tabindex attribute definition in HTML 4.01.
     *
     * @return the tab index
     */
    @Override
    int getTabIndex();

    /**
     * Index that represents the element's position in the tabbing order. See
     * the tabindex attribute definition in HTML 4.01.
     *
     * @param tabIndex
     *            the new tab index
     */
    @Override
    void setTabIndex(int tabIndex);

    /**
     * Content type for data downloaded via <code>data</code> attribute. See the
     * type attribute definition in HTML 4.01.
     *
     * @return the type
     */
    String getType();

    /**
     * Content type for data downloaded via <code>data</code> attribute. See the
     * type attribute definition in HTML 4.01.
     *
     * @param type
     *            the new type
     */
    void setType(String type);

    /**
     * Use client-side image map. See the usemap attribute definition in HTML
     * 4.01.
     *
     * @return the use map
     */
    String getUseMap();

    /**
     * Use client-side image map. See the usemap attribute definition in HTML
     * 4.01.
     *
     * @param useMap
     *            the new use map
     */
    void setUseMap(String useMap);

    /**
     * Vertical space, in pixels, above and below this image, applet, or object.
     * See the vspace attribute definition in HTML 4.01. This attribute is
     * deprecated in HTML 4.01.
     *
     * @return the vspace
     */
    int getVspace();

    /**
     * Vertical space, in pixels, above and below this image, applet, or object.
     * See the vspace attribute definition in HTML 4.01. This attribute is
     * deprecated in HTML 4.01.
     *
     * @param vspace
     *            the new vspace
     */
    void setVspace(int vspace);

    /**
     * Override width. See the width attribute definition in HTML 4.01.
     *
     * @return the width
     */
    String getWidth();

    /**
     * Override width. See the width attribute definition in HTML 4.01.
     *
     * @param width
     *            the new width
     */
    void setWidth(String width);

    /**
     * The document this object contains, if there is any and it is available,
     * or <code>null</code> otherwise.
     *
     * @return the content document
     * @since DOM Level 2
     */
    Document getContentDocument();

    // Window getContentWindow();

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

}
