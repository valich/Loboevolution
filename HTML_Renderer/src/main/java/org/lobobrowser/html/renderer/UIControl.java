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
 * Created on Nov 5, 2005
 */
package org.lobobrowser.html.renderer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;

import org.lobobrowser.html.control.RUIControl;

/**
 * The Interface UIControl.
 */
public abstract interface UIControl {

    /**
     * Sets the RUI control.
     *
     * @param ruicontrol
     *            the new RUI control
     */
    void setRUIControl(RUIControl ruicontrol);

    /**
     * Called as the control is layed out, either the first time HTML layout
     * occurs or when the DOM changes. This method should reset its state
     * assuming the element has changed, and change its preferred size if
     * appropriate.
     *
     * @param availWidth
     *            the avail width
     * @param availHeight
     *            the avail height
     */
    void reset(int availWidth, int availHeight);

    /**
     * Gets the preferred size.
     *
     * @return the preferred size
     */
    Dimension getPreferredSize();

    /**
     * Gets the v align.
     *
     * @return the v align
     */
    int getVAlign();

    /**
     * Sets the bounds.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @param width
     *            the width
     * @param height
     *            the height
     */
    void setBounds(int x, int y, int width, int height);

    /**
     * Invalidate.
     */
    void invalidate();

    /**
     * Gets the background color.
     *
     * @return the background color
     */
    Color getBackgroundColor();

    // boolean paintSelection(Graphics g, boolean inSelection,
    // RenderableSpot startPoint, RenderableSpot endPoint);
    /**
     * Paint.
     *
     * @param g
     *            the g
     */
    void paint(Graphics g);

    /**
     * Gets the component.
     *
     * @return the component
     */
    Component getComponent();
}
