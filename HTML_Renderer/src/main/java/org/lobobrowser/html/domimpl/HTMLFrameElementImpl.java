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
 * Created on Jan 28, 2006
 */
package org.lobobrowser.html.domimpl;

import org.lobobrowser.html.BrowserFrame;
import org.lobobrowser.html.HtmlAttributeProperties;
import org.lobobrowser.html.dombl.FrameNode;
import org.lobobrowser.html.js.Window;
import org.lobobrowser.html.w3c.HTMLFrameElement;
import org.w3c.dom.Document;

/**
 * The Class HTMLFrameElementImpl.
 */
public class HTMLFrameElementImpl extends HTMLElementImpl implements
HTMLFrameElement, FrameNode {

    /** The browser frame. */
    private volatile BrowserFrame browserFrame;

    /**
     * Instantiates a new HTML frame element impl.
     *
     * @param name
     *            the name
     * @param noStyleSheet
     *            the no style sheet
     */
    public HTMLFrameElementImpl(String name, boolean noStyleSheet) {
        super(name, noStyleSheet);
    }

    /**
     * Instantiates a new HTML frame element impl.
     *
     * @param name
     *            the name
     */
    public HTMLFrameElementImpl(String name) {
        super(name);
    }

    /*
     * (non-Javadoc)
     * @see
     * org.lobobrowser.html.dombl.FrameNode#setBrowserFrame(org.lobobrowser.html
     * .BrowserFrame)
     */
    @Override
    public void setBrowserFrame(BrowserFrame frame) {
        this.browserFrame = frame;
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.dombl.FrameNode#getBrowserFrame()
     */
    @Override
    public BrowserFrame getBrowserFrame() {
        return this.browserFrame;
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLFrameElement#getFrameBorder()
     */
    @Override
    public String getFrameBorder() {
        return this.getAttribute(HtmlAttributeProperties.FRAMEBORDER);
    }

    /*
     * (non-Javadoc)
     * @see
     * org.lobobrowser.html.w3c.HTMLFrameElement#setFrameBorder(java.lang.String)
     */
    @Override
    public void setFrameBorder(String frameBorder) {
        this.setAttribute(HtmlAttributeProperties.FRAMEBORDER, frameBorder);
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLFrameElement#getLongDesc()
     */
    @Override
    public String getLongDesc() {
        return this.getAttribute(HtmlAttributeProperties.LONGDESC);
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLFrameElement#setLongDesc(java.lang.String)
     */
    @Override
    public void setLongDesc(String longDesc) {
        this.setAttribute(HtmlAttributeProperties.LONGDESC, longDesc);
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLFrameElement#getMarginHeight()
     */
    @Override
    public String getMarginHeight() {
        return this.getAttribute(HtmlAttributeProperties.MARGINHEIGHT);
    }

    /*
     * (non-Javadoc)
     * @see
     * org.lobobrowser.html.w3c.HTMLFrameElement#setMarginHeight(java.lang.String)
     */
    @Override
    public void setMarginHeight(String marginHeight) {
        this.setAttribute(HtmlAttributeProperties.MARGINHEIGHT, marginHeight);
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLFrameElement#getMarginWidth()
     */
    @Override
    public String getMarginWidth() {
        return this.getAttribute(HtmlAttributeProperties.MARGINWIDTH);
    }

    /*
     * (non-Javadoc)
     * @see
     * org.lobobrowser.html.w3c.HTMLFrameElement#setMarginWidth(java.lang.String)
     */
    @Override
    public void setMarginWidth(String marginWidth) {
        this.setAttribute(HtmlAttributeProperties.MARGINWIDTH, marginWidth);
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLFrameElement#getName()
     */
    @Override
    public String getName() {
        return this.getAttribute(HtmlAttributeProperties.NAME);
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLFrameElement#setName(java.lang.String)
     */
    @Override
    public void setName(String name) {
        this.setAttribute(HtmlAttributeProperties.NAME, name);
    }

    /** The no resize. */
    private boolean noResize;

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLFrameElement#getNoResize()
     */
    @Override
    public boolean getNoResize() {
        return this.noResize;
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLFrameElement#setNoResize(boolean)
     */
    @Override
    public void setNoResize(boolean noResize) {
        this.noResize = noResize;
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLFrameElement#getScrolling()
     */
    @Override
    public String getScrolling() {
        return this.getAttribute(HtmlAttributeProperties.SCROLLING);
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLFrameElement#setScrolling(java.lang.String)
     */
    @Override
    public void setScrolling(String scrolling) {
        this.setAttribute(HtmlAttributeProperties.SCROLLING, scrolling);
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLFrameElement#getSrc()
     */
    @Override
    public String getSrc() {
        return this.getAttribute(HtmlAttributeProperties.SRC);
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLFrameElement#setSrc(java.lang.String)
     */
    @Override
    public void setSrc(String src) {
        this.setAttribute(HtmlAttributeProperties.SRC, src);
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLFrameElement#getContentDocument()
     */
    @Override
    public Document getContentDocument() {
        BrowserFrame frame = this.browserFrame;
        if (frame == null) {
            // Not loaded yet
            return null;
        }
        return frame.getContentDocument();
    }

    /**
     * Gets the content window.
     *
     * @return the content window
     */
    public Window getContentWindow() {
        BrowserFrame frame = this.browserFrame;
        if (frame == null) {
            // Not loaded yet
            return null;
        }
        return Window.getWindow(frame.getHtmlRendererContext());
    }

}
