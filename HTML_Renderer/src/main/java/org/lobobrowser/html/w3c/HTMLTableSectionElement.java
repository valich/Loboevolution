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

import org.w3c.dom.DOMException;

/**
 * The <code>THEAD</code>, <code>TFOOT</code>, and <code>TBODY</code> elements.
 * <p>
 * See also the Object Model (DOM) Level 2 HTML Specification
 * </p>
 * .
 */
public interface HTMLTableSectionElement extends HTMLElement {

    /**
     * Horizontal alignment of data in cells. See the <code>align</code>
     * attribute for HTMLTheadElement for details.
     *
     * @return the align
     */
    String getAlign();

    /**
     * Horizontal alignment of data in cells. See the <code>align</code>
     * attribute for HTMLTheadElement for details.
     *
     * @param align
     *            the new align
     */
    void setAlign(String align);

    /**
     * Alignment character for cells in a column. See the char attribute
     * definition in HTML 4.01.
     *
     * @return the ch
     */
    String getCh();

    /**
     * Alignment character for cells in a column. See the char attribute
     * definition in HTML 4.01.
     *
     * @param ch
     *            the new ch
     */
    void setCh(String ch);

    /**
     * Offset of alignment character. See the charoff attribute definition in
     * HTML 4.01.
     *
     * @return the ch off
     */
    String getChOff();

    /**
     * Offset of alignment character. See the charoff attribute definition in
     * HTML 4.01.
     *
     * @param chOff
     *            the new ch off
     */
    void setChOff(String chOff);

    /**
     * Vertical alignment of data in cells. See the <code>valign</code>
     * attribute for HTMLTheadElement for details.
     *
     * @return the v align
     */
    String getVAlign();

    /**
     * Vertical alignment of data in cells. See the <code>valign</code>
     * attribute for HTMLTheadElement for details.
     *
     * @param vAlign
     *            the new v align
     */
    void setVAlign(String vAlign);

    /**
     * The collection of rows in this table section.
     *
     * @return the rows
     */
    HTMLCollection getRows();

    /**
     * Insert a row into this section. The new row is inserted immediately
     * before the current <code>index</code>th row in this section. If
     * <code>index</code> is -1 or equal to the number of rows in this section,
     * the new row is appended.
     *
     * @version DOM Level 2
     * @param index
     *            The row number where to insert a new row. This index starts
     *            from 0 and is relative only to the rows contained inside this
     *            section, not all the rows in the table.
     * @return The newly created row.
     * @exception DOMException
     *                INDEX_SIZE_ERR: Raised if the specified index is greater
     *                than the number of rows of if the index is a negative
     *                number other than -1.
     */
    HTMLElement insertRow(int index) throws DOMException;

    /**
     * Delete a row from this section.
     *
     * @version DOM Level 2
     * @param index
     *            The index of the row to be deleted, or -1 to delete the last
     *            row. This index starts from 0 and is relative only to the rows
     *            contained inside this section, not all the rows in the table.
     * @exception DOMException
     *                INDEX_SIZE_ERR: Raised if the specified index is greater
     *                than or equal to the number of rows or if the index is a
     *                negative number other than -1.
     */
    void deleteRow(int index) throws DOMException;

    /**
     * Insert row.
     *
     * @return the HTML element
     */
    HTMLElement insertRow();
}
