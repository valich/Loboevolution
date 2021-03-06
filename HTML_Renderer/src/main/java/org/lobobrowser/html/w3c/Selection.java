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

import org.w3c.dom.Node;
import org.w3c.dom.ranges.Range;

/**
 * The public interface Selection.
 */
public interface Selection {
    // Selection
    /**
     * Gets the anchor node.
     *
     * @return the anchor node
     */
    Node getAnchorNode();

    /**
     * Gets the anchor offset.
     *
     * @return the anchor offset
     */
    int getAnchorOffset();

    /**
     * Gets the focus node.
     *
     * @return the focus node
     */
    Node getFocusNode();

    /**
     * Gets the focus offset.
     *
     * @return the focus offset
     */
    int getFocusOffset();

    /**
     * Gets the checks if is collapsed.
     *
     * @return the checks if is collapsed
     */
    boolean getIsCollapsed();

    /**
     * Collapse.
     *
     * @param parentNode
     *            the parent node
     * @param offset
     *            the offset
     */
    void collapse(Node parentNode, int offset);

    /**
     * Collapse to start.
     */
    void collapseToStart();

    /**
     * Collapse to end.
     */
    void collapseToEnd();

    /**
     * Select all children.
     *
     * @param parentNode
     *            the parent node
     */
    void selectAllChildren(Node parentNode);

    /**
     * Delete from document.
     */
    void deleteFromDocument();

    /**
     * Gets the range count.
     *
     * @return the range count
     */
    int getRangeCount();

    /**
     * Gets the range at.
     *
     * @param index
     *            the index
     * @return the range at
     */
    Range getRangeAt(int index);

    /**
     * Adds the range.
     *
     * @param range
     *            the range
     */
    void addRange(Range range);

    /**
     * Removes the range.
     *
     * @param range
     *            the range
     */
    void removeRange(Range range);

    /**
     * Removes the all ranges.
     */
    void removeAllRanges();

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    String toString();
}
