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
/*
 * Created on May 31, 2005
 */
package org.lobobrowser.security;

/**
 * The Class LocalSecurityManager.
 */
public class LocalSecurityManager extends SecurityManager {

    /** The Constant threadGroupTL. */
    private static final ThreadLocal threadGroupTL = new ThreadLocal<ThreadGroup>();

    /**
     * Instantiates a new local security manager.
     */
    public LocalSecurityManager() {
        super();
    }

    /*
     * (non-Javadoc)
     * @see java.lang.SecurityManager#getThreadGroup()
     */
    @Override
    public ThreadGroup getThreadGroup() {
        ThreadGroup tg = getCurrentThreadGroup();
        if (tg == null) {
            return super.getThreadGroup();
        } else {
            return tg;
        }
    }

    /**
     * Sets the current thread group.
     *
     * @param tg
     *            the new current thread group
     */
    public static void setCurrentThreadGroup(ThreadGroup tg) {
        // TODO: Thread group needs to be thought through. It's retained in
        // memory, and we need to return the right one in the GUI thread as
        // well.
        threadGroupTL.set(tg);
    }

    /**
     * Gets the current thread group.
     *
     * @return the current thread group
     */
    public static ThreadGroup getCurrentThreadGroup() {
        return (ThreadGroup) threadGroupTL.get();
    }
}
