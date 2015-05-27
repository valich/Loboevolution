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
package org.lobobrowser.html.domimpl;

import java.awt.Color;
import java.awt.Cursor;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import org.lobobrowser.html.HtmlAttributeProperties;
import org.lobobrowser.html.HtmlRendererContext;
import org.lobobrowser.html.renderstate.ColorRenderState;
import org.lobobrowser.html.renderstate.CursorRenderState;
import org.lobobrowser.html.renderstate.RenderState;
import org.lobobrowser.html.renderstate.TextDecorationRenderState;
import org.lobobrowser.html.w3c.DOMTokenList;
import org.lobobrowser.html.w3c.HTMLAnchorElement;
import org.lobobrowser.html.w3c.HTMLBodyElement;
import org.lobobrowser.html.w3c.HTMLDocument;
import org.lobobrowser.util.Urls;
import org.lobobrowser.util.gui.ColorFactory;

/**
 * The Class HTMLAnchorElementImpl.
 */
public class HTMLAnchorElementImpl extends HTMLAbstractUIElement implements HTMLAnchorElement {

    /** The Constant logger. */
    private static final Logger logger = Logger
            .getLogger(HTMLAnchorElementImpl.class.getName());

    /**
     * Instantiates a new HTML link element impl.
     *
     * @param name
     *            the name
     */
    public HTMLAnchorElementImpl(String name) {
        super(name);
    }

    @Override
    public String getHref() {
        String href = this.getAttribute(HtmlAttributeProperties.HREF);
        return href == null ? "" : Urls.removeControlCharacters(href);
    }

    @Override
    public void setHref(String href) {
        this.setAttribute(HtmlAttributeProperties.HREF, href);
    }

    @Override
    public String getHreflang() {
        return this.getAttribute(HtmlAttributeProperties.HREFLANG);
    }

    @Override
    public void setHreflang(String hreflang) {
        this.setAttribute(HtmlAttributeProperties.HREFLANG, hreflang);
    }

    @Override
    public String getMedia() {
        return this.getAttribute(HtmlAttributeProperties.MEDIA);
    }

    @Override
    public void setMedia(String media) {
        this.setAttribute(HtmlAttributeProperties.MEDIA, media);
    }

    @Override
    public String getRel() {
        return this.getAttribute(HtmlAttributeProperties.REL);
    }

    @Override
    public void setRel(String rel) {
        this.setAttribute(HtmlAttributeProperties.REL, rel);
    }

    @Override
    public String getRev() {
        return this.getAttribute(HtmlAttributeProperties.REV);
    }

    @Override
    public void setRev(String rev) {
        this.setAttribute(HtmlAttributeProperties.REV, rev);
    }

    @Override
    public String getTarget() {
        String target = this.getAttribute(HtmlAttributeProperties.TARGET);
        if (target != null) {
            return target;
        }
        HTMLDocumentImpl doc = (HTMLDocumentImpl) this.document;
        return doc == null ? null : doc.getDefaultTarget();
    }

    @Override
    public void setTarget(String target) {
        this.setAttribute(HtmlAttributeProperties.TARGET, target);
    }

    @Override
    public String getType() {
        return this.getAttribute(HtmlAttributeProperties.TYPE);
    }

    @Override
    public void setType(String type) {
        this.setAttribute(HtmlAttributeProperties.TYPE, type);
    }

   /**
     * Gets the absolute href.
     *
     * @return the absolute href
     */
    public String getAbsoluteHref() {
        HtmlRendererContext rcontext = this.getHtmlRendererContext();
        if (rcontext != null) {
            String href = this.getHref();
            if ((href != null) && (href.length() > 0)) {
                try {
                    URL url = this.getFullURL(href);
                    return url == null ? null : url.toExternalForm();
                } catch (MalformedURLException mfu) {
                    this.warn("Malformed URI: [" + href + "].", mfu);
                }
            }
        }
        return null;
    }

    /**
     * Navigate.
     */
    public void navigate() {

        HtmlRendererContext rcontext = this.getHtmlRendererContext();
        if (rcontext != null) {
            String href = this.getHref();
            if ((href != null) && (href.length() > 0)) {
                String target = this.getTarget();
                try {
                    URL url = this.getFullURL(href);
                    if (url != null) {
                        rcontext.linkClicked(this, url, target);
                    }
                } catch (MalformedURLException mfu) {
                    this.warn("Malformed URI: [" + href + "].", mfu);
                }
            }
        }
    }

    /**
     * Gets the link color.
     *
     * @return the link color
     */
    private Color getLinkColor() {
        HTMLDocument doc = (HTMLDocument) this.document;
        if (doc != null) {
            HTMLBodyElement body = (HTMLBodyElement) doc.getBody();
            if (body != null) {
                String vlink = body.getVLink();
                String link = body.getLink();
                if ((vlink != null) || (link != null)) {
                    HtmlRendererContext rcontext = this
                            .getHtmlRendererContext();
                    if (rcontext != null) {
                        boolean visited = rcontext.isVisitedLink(this);
                        String colorText = visited ? vlink : link;
                        if (colorText != null) {
                            return ColorFactory.getInstance().getColor(
                                    colorText);
                        }
                    }
                }
            }
        }
        return Color.BLUE;
    }

    @Override
    protected RenderState createRenderState(RenderState prevRenderState) {
        if (this.hasAttribute(HtmlAttributeProperties.HREF)) {
            prevRenderState = new TextDecorationRenderState(prevRenderState,
                    RenderState.MASK_TEXTDECORATION_UNDERLINE);
            prevRenderState = new ColorRenderState(prevRenderState,
                    this.getLinkColor());
            prevRenderState = new CursorRenderState(prevRenderState,
                    Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        return super.createRenderState(prevRenderState);
    }

    @Override
    public String toString() {
        return this.getHref();
    }

    @Override
    public DOMTokenList getRelList() {
        // TODO Auto-generated method stub
        return null;
    }
    
	@Override
	public String getCoords() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCoords(String coords) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getShape() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setShape(String shape) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPing(String ping) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setText(String text) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getProtocol() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProtocol(String protocol) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getHost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setHost(String host) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getHostname() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setHostname(String hostname) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getPort() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPort(String port) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getPathname() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPathname(String pathname) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getSearch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSearch(String search) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getHash() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setHash(String hash) {
		// TODO Auto-generated method stub
		
	}
}
