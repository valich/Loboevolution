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

package org.lobobrowser.primary.ext;

import java.awt.event.ActionEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.AbstractAction;
import javax.swing.Action;

import org.lobobrowser.primary.action.BackAction;
import org.lobobrowser.primary.action.BackMoreAction;
import org.lobobrowser.primary.action.BookmarkNavigateAction;
import org.lobobrowser.primary.action.EnableableAction;
import org.lobobrowser.primary.action.ForwardAction;
import org.lobobrowser.primary.action.ForwardMoreAction;
import org.lobobrowser.primary.action.GoToAction;
import org.lobobrowser.primary.action.NavigateAction;
import org.lobobrowser.primary.action.RecentHostsAction;
import org.lobobrowser.primary.action.ReloadAction;
import org.lobobrowser.primary.action.SourceAction;
import org.lobobrowser.primary.action.UrlPrefixNavigateAction;
import org.lobobrowser.ua.NavigationEntry;
import org.lobobrowser.ua.NavigatorWindow;

/**
 * The Class ActionPool.
 */
public class ActionPool extends AbstractAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The Constant logger. */
    private static final Logger logger = Logger.getLogger(ActionPool.class
            .getName());

    /** The component source. */
    private final ComponentSource componentSource;

    /** The window. */
    private final NavigatorWindow window;

    /** The enableable actions. */
    private final Collection<EnableableAction> enableableActions;

    /**
     * Instantiates a new action pool.
     *
     * @param componentSource
     *            the component source
     * @param window
     *            the window
     */
    public ActionPool(final ComponentSource componentSource,
            final NavigatorWindow window) {
        super();
        this.componentSource = componentSource;
        this.window = window;
        Collection<EnableableAction> actions = new LinkedList<EnableableAction>();
        this.enableableActions = actions;
        actions.add(new BackAction(componentSource, window, this));
        actions.add(new ForwardAction(componentSource, window, this));
        actions.add(new ReloadAction(componentSource, window, this));
        actions.add(new BackMoreAction(componentSource, window, this));
        actions.add(new ForwardMoreAction(componentSource, window, this));
        actions.add(new RecentHostsAction(componentSource, window, this));
        actions.add(new SourceAction(componentSource, window, this));
    }

    /**
     * Update enabling.
     */
    public void updateEnabling() {
        for (EnableableAction action : this.enableableActions) {
            action.updateEnabling();
        }
    }

    /**
     * Creates the navigate action.
     *
     * @param fullURL
     *            the full url
     * @return the action
     */
    public Action createNavigateAction(String fullURL) {
        URL url;
        try {
            url = new URL(fullURL);
        } catch (MalformedURLException mfu) {
            logger.log(Level.WARNING, "createNavigateAction()", mfu);
            url = null;
        }
        NavigateAction nav = new NavigateAction(componentSource, window);
        nav.setUrl(url);
        return nav;
    }

    /**
     * Creates the navigate action.
     *
     * @param url
     *            the url
     * @return the action
     */
    public Action createNavigateAction(URL url) {
        NavigateAction nav = new NavigateAction(componentSource, window);
        nav.setUrl(url);
        return nav;
    }

    /**
     * Creates the bookmark navigate action.
     *
     * @param url
     *            the url
     * @return the action
     */
    public Action createBookmarkNavigateAction(URL url) {
        BookmarkNavigateAction bookNav = new BookmarkNavigateAction(
                componentSource, window);
        bookNav.setUrl(url);
        return bookNav;
    }

    /**
     * Creates the go to action.
     *
     * @param entry
     *            the entry
     * @return the action
     */
    public Action createGoToAction(NavigationEntry entry) {
        GoToAction go = new GoToAction(componentSource, window);
        go.setEntry(entry);
        return go;
    }

    /**
     * Adds the url prefix navigate action.
     *
     * @param urlPrefix
     *            the url prefix
     * @param urlEncode
     *            the url encode
     * @return the action
     */
    public Action addUrlPrefixNavigateAction(String urlPrefix, boolean urlEncode) {
        UrlPrefixNavigateAction urlPrefixNav = new UrlPrefixNavigateAction(
                componentSource, window, this);
        urlPrefixNav.setUrlPrefix(urlPrefix);
        urlPrefixNav.setUrlEncode(urlEncode);
        this.enableableActions.add(urlPrefixNav);
        return urlPrefixNav;
    }

    /*
     * (non-Javadoc)
     * @see
     * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent arg0) {
    }
}
