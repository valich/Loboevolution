/*
 * GNU GENERAL PUBLIC LICENSE Copyright (C) 2006 The Lobo Project. Copyright (C)
 * 2014 - 2015 Lobo Evolution This program is free software; you can
 * redistribute it and/or modify it under the terms of the GNU General Public
 * License as published by the Free Software Foundation; either verion 2 of the
 * License, or (at your option) any later version. This program is distributed
 * in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even
 * the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details. You should have received
 * a copy of the GNU General Public License along with this library; if not,
 * write to the Free Software Foundation, Inc., 51 Franklin St, Fifth Floor,
 * Boston, MA 02110-1301 USA Contact info: lobochief@users.sourceforge.net;
 * ivan.difrancesco@yahoo.it
 */
package org.lobobrowser.primary.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import org.lobobrowser.primary.ext.ActionPool;
import org.lobobrowser.primary.ext.ComponentSource;
import org.lobobrowser.ua.NavigatorWindow;

/**
 * The Class SourceAction.
 */
public class SourceAction extends AbstractAction implements EnableableAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The window. */
    private NavigatorWindow window;

    /** The component source. */
    private ComponentSource componentSource;

    /** The action. */
    private ActionPool action;

    /**
     * Instantiates a new source action.
     *
     * @param componentSource
     *            the component source
     * @param window
     *            the window
     * @param action
     *            the action
     */
    public SourceAction(ComponentSource componentSource,
            NavigatorWindow window, ActionPool action) {
        this.action = action;
        this.window = window;
        this.componentSource = componentSource;
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.primary.action.EnableableAction#updateEnabling()
     */
    @Override
    public void updateEnabling() {
        action.setEnabled(window.hasSource());
    }

    /*
     * (non-Javadoc)
     * @see
     * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        componentSource.showSource();
    }

}
