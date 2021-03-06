/*
    GNU GENERAL PUBLIC LICENSE
    Copyright (C) 2006 The Lobo Project. Copyright (C) 2014 - 2015 Lobo Evolution

    This program is free software; you can redistribute it and/or
    modify it under the terms of the GNU General Public
    License as published by the Free Software Foundation; either
    verion 2 of the License, or (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
    General Public License for more details.

    You should have received a copy of the GNU General Public
    License along with this library; if not, write to the Free Software
    Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA

    Contact info: lobochief@users.sourceforge.net; ivan.difrancesco@yahoo.it
 */
package org.lobobrowser.html.domimpl;

import java.net.MalformedURLException;

import org.lobobrowser.html.BrowserFrame;
import org.lobobrowser.html.HtmlAttributeProperties;
import org.lobobrowser.html.dombl.FrameNode;
import org.lobobrowser.html.js.Window;
import org.lobobrowser.html.renderstate.IFrameRenderState;
import org.lobobrowser.html.renderstate.RenderState;
import org.lobobrowser.html.w3c.HTMLIFrameElement;
import org.w3c.dom.Document;

/**
 * The Class HTMLIFrameElementImpl.
 */
public class HTMLIFrameElementImpl extends HTMLAbstractUIElement implements
HTMLIFrameElement, FrameNode {

    /** The browser frame. */
    private volatile BrowserFrame browserFrame;

    /**
     * Instantiates a new HTMLI frame element impl.
     *
     * @param name
     *            the name
     */
    public HTMLIFrameElementImpl(String name) {
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
        if (frame != null) {
            String src = this.getAttribute(HtmlAttributeProperties.SRC);
            if (src != null) {
                try {
                    frame.loadURL(this.getFullURL(src));
                } catch (MalformedURLException mfu) {
                    this.warn("setBrowserFrame(): Unable to navigate to src.",
                            mfu);
                }
            }
        }
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
     * @see org.lobobrowser.html.w3c.HTMLIFrameElement#getAlign()
     */
    @Override
    public String getAlign() {
        return this.getAttribute(HtmlAttributeProperties.ALIGN);
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLIFrameElement#getContentDocument()
     */
    @Override
    public Document getContentDocument() {
        // TODO: Domain-based security
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

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLIFrameElement#getFrameBorder()
     */
    @Override
    public String getFrameBorder() {
        return this.getAttribute(HtmlAttributeProperties.FRAMEBORDER);
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLIFrameElement#getHeight()
     */
    @Override
    public String getHeight() {
        return this.getAttribute(HtmlAttributeProperties.HEIGHT);
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLIFrameElement#getLongDesc()
     */
    @Override
    public String getLongDesc() {
        return this.getAttribute(HtmlAttributeProperties.LONGDESC);
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLIFrameElement#getMarginHeight()
     */
    @Override
    public String getMarginHeight() {
        return this.getAttribute(HtmlAttributeProperties.FRAMEBORDER);
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLIFrameElement#getMarginWidth()
     */
    @Override
    public String getMarginWidth() {
        return this.getAttribute(HtmlAttributeProperties.MARGINWIDTH);
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLIFrameElement#getName()
     */
    @Override
    public String getName() {
        return this.getAttribute(HtmlAttributeProperties.NAME);
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLIFrameElement#getScrolling()
     */
    @Override
    public String getScrolling() {
        return this.getAttribute(HtmlAttributeProperties.SCROLLING);
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLIFrameElement#getSrc()
     */
    @Override
    public String getSrc() {
        return this.getAttribute(HtmlAttributeProperties.SRC);
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLIFrameElement#getWidth()
     */
    @Override
    public String getWidth() {
        return this.getAttribute(HtmlAttributeProperties.WIDTH);
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLIFrameElement#setAlign(java.lang.String)
     */
    @Override
    public void setAlign(String align) {
        this.setAttribute(HtmlAttributeProperties.ALIGN, align);
    }

    /*
     * (non-Javadoc)
     * @see
     * org.lobobrowser.html.w3c.HTMLIFrameElement#setFrameBorder(java.lang.String)
     */
    @Override
    public void setFrameBorder(String frameBorder) {
        this.setAttribute(HtmlAttributeProperties.FRAMEBORDER, frameBorder);
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLIFrameElement#setHeight(java.lang.String)
     */
    @Override
    public void setHeight(String height) {
        this.setAttribute(HtmlAttributeProperties.HEIGHT, height);
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLIFrameElement#setLongDesc(java.lang.String)
     */
    @Override
    public void setLongDesc(String longDesc) {
        this.setAttribute(HtmlAttributeProperties.LONGDESC, longDesc);
    }

    /*
     * (non-Javadoc)
     * @see
     * org.lobobrowser.html.w3c.HTMLIFrameElement#setMarginHeight(java.lang.String)
     */
    @Override
    public void setMarginHeight(String marginHeight) {
        this.setAttribute(HtmlAttributeProperties.FRAMEBORDER, marginHeight);
    }

    /*
     * (non-Javadoc)
     * @see
     * org.lobobrowser.html.w3c.HTMLIFrameElement#setMarginWidth(java.lang.String)
     */
    @Override
    public void setMarginWidth(String marginWidth) {
        this.setAttribute(HtmlAttributeProperties.MARGINWIDTH, marginWidth);
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLIFrameElement#setName(java.lang.String)
     */
    @Override
    public void setName(String name) {
        this.setAttribute(HtmlAttributeProperties.NAME, name);
    }

    /*
     * (non-Javadoc)
     * @see
     * org.lobobrowser.html.w3c.HTMLIFrameElement#setScrolling(java.lang.String)
     */
    @Override
    public void setScrolling(String scrolling) {
        this.setAttribute(HtmlAttributeProperties.SCROLLING, scrolling);
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLIFrameElement#setSrc(java.lang.String)
     */
    @Override
    public void setSrc(String src) {
        this.setAttribute(HtmlAttributeProperties.SRC, src);
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLIFrameElement#setWidth(java.lang.String)
     */
    @Override
    public void setWidth(String width) {
        this.setAttribute(HtmlAttributeProperties.WIDTH, width);
    }

    /*
     * (non-Javadoc)
     * @see
     * org.lobobrowser.html.domimpl.HTMLAbstractUIElement#assignAttributeField(java
     * .lang.String, java.lang.String)
     */
    @Override
    protected void assignAttributeField(String normalName, String value) {
        if (HtmlAttributeProperties.SRC.equals(normalName)) {
            BrowserFrame frame = this.browserFrame;
            if (frame != null) {
                try {
                    frame.loadURL(this.getFullURL(value));
                } catch (MalformedURLException mfu) {
                    this.warn(
                            "assignAttributeField(): Unable to navigate to src.",
                            mfu);
                }
            }
        } else {
            super.assignAttributeField(normalName, value);
        }
    }

    /*
     * (non-Javadoc)
     * @see
     * org.lobobrowser.html.domimpl.HTMLElementImpl#createRenderState(org.lobobrowser
     * .html.renderstate.RenderState)
     */
    @Override
    protected RenderState createRenderState(RenderState prevRenderState) {
        return new IFrameRenderState(prevRenderState, this);
    }
}
