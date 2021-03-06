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

import org.mozilla.javascript.Function;

/**
 * The public interface ApplicationCache.
 */
public interface ApplicationCache {
    // ApplicationCache
    /** The Constant UNCACHED. */
    short UNCACHED = 0;

    /** The Constant IDLE. */
    short IDLE = 1;

    /** The Constant CHECKING. */
    short CHECKING = 2;

    /** The Constant DOWNLOADING. */
    short DOWNLOADING = 3;

    /** The Constant UPDATEREADY. */
    short UPDATEREADY = 4;

    /** The Constant OBSOLETE. */
    short OBSOLETE = 5;

    /**
     * Gets the status.
     *
     * @return the status
     */
    short getStatus();

    /**
     * Update.
     */
    void update();

    /**
     * Swap cache.
     */
    void swapCache();

    /**
     * Gets the onchecking.
     *
     * @return the onchecking
     */
    Function getOnchecking();

    /**
     * Sets the onchecking.
     *
     * @param onchecking
     *            the new onchecking
     */
    void setOnchecking(Function onchecking);

    /**
     * Gets the onerror.
     *
     * @return the onerror
     */
    Function getOnerror();

    /**
     * Sets the onerror.
     *
     * @param onerror
     *            the new onerror
     */
    void setOnerror(Function onerror);

    /**
     * Gets the onnoupdate.
     *
     * @return the onnoupdate
     */
    Function getOnnoupdate();

    /**
     * Sets the onnoupdate.
     *
     * @param onnoupdate
     *            the new onnoupdate
     */
    void setOnnoupdate(Function onnoupdate);

    /**
     * Gets the ondownloading.
     *
     * @return the ondownloading
     */
    Function getOndownloading();

    /**
     * Sets the ondownloading.
     *
     * @param ondownloading
     *            the new ondownloading
     */
    void setOndownloading(Function ondownloading);

    /**
     * Gets the onprogress.
     *
     * @return the onprogress
     */
    Function getOnprogress();

    /**
     * Sets the onprogress.
     *
     * @param onprogress
     *            the new onprogress
     */
    void setOnprogress(Function onprogress);

    /**
     * Gets the onupdateready.
     *
     * @return the onupdateready
     */
    Function getOnupdateready();

    /**
     * Sets the onupdateready.
     *
     * @param onupdateready
     *            the new onupdateready
     */
    void setOnupdateready(Function onupdateready);

    /**
     * Gets the oncached.
     *
     * @return the oncached
     */
    Function getOncached();

    /**
     * Sets the oncached.
     *
     * @param oncached
     *            the new oncached
     */
    void setOncached(Function oncached);

    /**
     * Gets the onobsolete.
     *
     * @return the onobsolete
     */
    Function getOnobsolete();

    /**
     * Sets the onobsolete.
     *
     * @param onobsolete
     *            the new onobsolete
     */
    void setOnobsolete(Function onobsolete);
}
