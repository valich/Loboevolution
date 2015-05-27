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
package org.lobobrowser.html.domimpl;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import org.lobobrowser.html.HtmlJsAttributeProperties;
import org.lobobrowser.html.UserAgentContext;
import org.lobobrowser.html.dombl.UINode;
import org.lobobrowser.html.js.Executor;
import org.lobobrowser.js.JavaScript;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.EcmaError;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Scriptable;
import org.w3c.dom.Document;

/**
 * The Class HTMLAbstractUIElement.
 */
public class HTMLAbstractUIElement extends HTMLElementImpl {

    /** The onfocus. */
    private Function onfocus;

    /** The onblur. */
    private Function onblur;

    /** The onclick. */
    private Function onclick;

    /** The ondblclick. */
    private Function ondblclick;

    /** The onmousedown. */
    private Function onmousedown;

    /** The onmouseup. */
    private Function onmouseup;

    /** The onmouseover. */
    private Function onmouseover;

    /** The onmousemove. */
    private Function onmousemove;

    /** The onmouseout. */
    private Function onmouseout;

    /** The onkeypress. */
    private Function onkeypress;

    /** The onkeydown. */
    private Function onkeydown;

    /** The onkeyup. */
    private Function onkeyup;

    /** The oncontextmenu. */
    private Function oncontextmenu;

    /** The onabort. */
    private Function onabort;

    /** The onplay. */
    private Function onplay;

    /** The onplaying. */
    private Function onplaying;

    /** The onprogress. */
    private Function onprogress;

    /** The onreadystatechange. */
    private Function onreadystatechange;

    /** The onscroll. */
    private Function onscroll;

    /** The onseeked. */
    private Function onseeked;

    /** The onseeking. */
    private Function onseeking;

    /** The onselect. */
    private Function onselect;

    /** The onshow. */
    private Function onshow;

    /** The onstalled. */
    private Function onstalled;

    /** The onsubmit. */
    private Function onsubmit;

    /** The onsuspend. */
    private Function onsuspend;

    /** The ontimeupdate. */
    private Function ontimeupdate;

    /** The onwaiting. */
    private Function onwaiting;

    /** The onvolumechange. */
    private Function onvolumechange;

    /** The onfinish. */
    private Function onfinish;

    /** The onstart. */
    private Function onstart;

    /** The onbounce. */
    private Function onbounce;

    /** The onload. */
    private Function onload;

    /** The onafterprint. */
    private Function onafterprint;

    /** The onbeforeprint. */
    private Function onbeforeprint;

    /** The onbeforeunload. */
    private Function onbeforeunload;

    /** The onerror. */
    private Function onerror;

    /** The onhashchange. */
    private Function onhashchange;

    /** The onmessage. */
    private Function onmessage;

    /** The onoffline. */
    private Function onoffline;

    /** The ononline. */
    private Function ononline;

    /** The onpopstate. */
    private Function onpopstate;

    /** The onpagehide. */
    private Function onpagehide;

    /** The onpageshow. */
    private Function onpageshow;

    /** The onredo. */
    private Function onredo;

    /** The onresize. */
    private Function onresize;

    /** The onstorage. */
    private Function onstorage;

    /** The onundo. */
    private Function onundo;

    /** The onunload. */
    private Function onunload;
    
    /** The function by attribute. */
    private Map<String, Function> functionByAttribute = null;

    /**
     * Gets the onafterprint.
     *
     * @return the onafterprint
     */
    public Function getOnafterprint() {
        return this.getEventFunction(onafterprint,
                HtmlJsAttributeProperties.ONAFTERPRINT);
    }

    /**
     * Sets the onafterprint.
     *
     * @param onafterprint
     *            the new onafterprint
     */
    public void setOnafterprint(Function onafterprint) {
        this.onafterprint = onafterprint;
    }

    /**
     * Gets the onbeforeprint.
     *
     * @return the onbeforeprint
     */
    public Function getOnbeforeprint() {
        return this.getEventFunction(onbeforeprint,
                HtmlJsAttributeProperties.ONBEFOREPRINT);
    }

    /**
     * Sets the onbeforeprint.
     *
     * @param onbeforeprint
     *            the new onbeforeprint
     */
    public void setOnbeforeprint(Function onbeforeprint) {
        this.onbeforeprint = onbeforeprint;
    }

    /**
     * Gets the onbeforeunload.
     *
     * @return the onbeforeunload
     */
    public Function getOnbeforeunload() {
        return this.getEventFunction(onbeforeunload,
                HtmlJsAttributeProperties.ONBEFOREUNLOAD);
    }

    /**
     * Sets the onbeforeunload.
     *
     * @param onbeforeunload
     *            the new onbeforeunload
     */
    public void setOnbeforeunload(Function onbeforeunload) {
        this.onbeforeunload = onbeforeunload;
    }

    /**
     * Gets the onerror.
     *
     * @return the onerror
     */
    public Function getOnerror() {
        return this
                .getEventFunction(onerror, HtmlJsAttributeProperties.ONERROR);
    }

    /**
     * Sets the onerror.
     *
     * @param onerror
     *            the new onerror
     */
    public void setOnerror(Function onerror) {
        this.onerror = onerror;
    }

    /**
     * Gets the onhashchange.
     *
     * @return the onhashchange
     */
    public Function getOnhashchange() {
        return this.getEventFunction(onhashchange,
                HtmlJsAttributeProperties.ONHASHCHANGE);
    }

    /**
     * Sets the onhashchange.
     *
     * @param onhashchange
     *            the new onhashchange
     */
    public void setOnhashchange(Function onhashchange) {
        this.onhashchange = onhashchange;
    }

    /**
     * Gets the onmessage.
     *
     * @return the onmessage
     */
    public Function getOnmessage() {
        return this.getEventFunction(onmessage,
                HtmlJsAttributeProperties.ONMESSAGE);
    }

    /**
     * Sets the onmessage.
     *
     * @param onmessage
     *            the new onmessage
     */
    public void setOnmessage(Function onmessage) {
        this.onmessage = onmessage;
    }

    /**
     * Gets the onoffline.
     *
     * @return the onoffline
     */
    public Function getOnoffline() {
        return this.getEventFunction(onoffline,
                HtmlJsAttributeProperties.ONOFFLINE);
    }

    /**
     * Sets the onoffline.
     *
     * @param onoffline
     *            the new onoffline
     */
    public void setOnoffline(Function onoffline) {
        this.onoffline = onoffline;
    }

    /**
     * Gets the ononline.
     *
     * @return the ononline
     */
    public Function getOnonline() {
        return this.getEventFunction(ononline,
                HtmlJsAttributeProperties.ONONLINE);
    }

    /**
     * Sets the ononline.
     *
     * @param ononline
     *            the new ononline
     */
    public void setOnonline(Function ononline) {
        this.ononline = ononline;
    }

    /**
     * Gets the onpopstate.
     *
     * @return the onpopstate
     */
    public Function getOnpopstate() {
        return this.getEventFunction(onpopstate,
                HtmlJsAttributeProperties.ONPOPSTATE);
    }

    /**
     * Sets the onpopstate.
     *
     * @param onpopstate
     *            the new onpopstate
     */
    public void setOnpopstate(Function onpopstate) {
        this.onpopstate = onpopstate;
    }

    /**
     * Gets the onpagehide.
     *
     * @return the onpagehide
     */
    public Function getOnpagehide() {
        return this.getEventFunction(onpagehide,
                HtmlJsAttributeProperties.ONPAGEHIDE);
    }

    /**
     * Sets the onpagehide.
     *
     * @param onpagehide
     *            the new onpagehide
     */
    public void setOnpagehide(Function onpagehide) {
        this.onpagehide = onpagehide;
    }

    /**
     * Gets the onpageshow.
     *
     * @return the onpageshow
     */
    public Function getOnpageshow() {
        return this.getEventFunction(onpageshow,
                HtmlJsAttributeProperties.ONPAGESHOW);
    }

    /**
     * Sets the onpageshow.
     *
     * @param onpageshow
     *            the new onpageshow
     */
    public void setOnpageshow(Function onpageshow) {
        this.onpageshow = onpageshow;
    }

    /**
     * Gets the onredo.
     *
     * @return the onredo
     */
    public Function getOnredo() {
        return this.getEventFunction(onredo, HtmlJsAttributeProperties.ONREDO);
    }

    /**
     * Sets the onredo.
     *
     * @param onredo
     *            the new onredo
     */
    public void setOnredo(Function onredo) {
        this.onredo = onredo;
    }

    /**
     * Gets the onresize.
     *
     * @return the onresize
     */
    public Function getOnresize() {
        return this.getEventFunction(onresize,
                HtmlJsAttributeProperties.ONRESIZE);
    }

    /**
     * Sets the onresize.
     *
     * @param onresize
     *            the new onresize
     */
    public void setOnresize(Function onresize) {
        this.onresize = onresize;
    }

    /**
     * Gets the onstorage.
     *
     * @return the onstorage
     */
    public Function getOnstorage() {
        return this.getEventFunction(onstorage,
                HtmlJsAttributeProperties.ONSTORAGE);
    }

    /**
     * Sets the onstorage.
     *
     * @param onstorage
     *            the new onstorage
     */
    public void setOnstorage(Function onstorage) {
        this.onstorage = onstorage;
    }

    /**
     * Gets the onundo.
     *
     * @return the onundo
     */
    public Function getOnundo() {
        return this.getEventFunction(onundo, HtmlJsAttributeProperties.ONUNDO);
    }

    /**
     * Sets the onundo.
     *
     * @param onundo
     *            the new onundo
     */
    public void setOnundo(Function onundo) {
        this.onundo = onundo;
    }

    /**
     * Gets the onunload.
     *
     * @return the onunload
     */
    public Function getOnunload() {
        return this.getEventFunction(onunload,
                HtmlJsAttributeProperties.ONUNLOAD);
    }

    /**
     * Sets the onunload.
     *
     * @param onunload
     *            the new onunload
     */
    public void setOnunload(Function onunload) {
        this.onunload = onunload;
    }

    /**
     * Instantiates a new HTML abstract ui element.
     *
     * @param name
     *            the name
     */
    public HTMLAbstractUIElement(String name) {
        super(name);
    }

    /**
     * Gets the onfinish.
     *
     * @return the onfinish
     */
    public Function getOnfinish() {
        return this
                .getEventFunction(onfinish, HtmlJsAttributeProperties.FINISH);
    }

    /**
     * Sets the onfinish.
     *
     * @param onfinish
     *            the new onfinish
     */
    public void setOnfinish(Function onfinish) {
        this.onfinish = onfinish;
    }

    /**
     * Gets the onstart.
     *
     * @return the onstart
     */
    public Function getOnstart() {
        return this.getEventFunction(onstart, HtmlJsAttributeProperties.START);
    }

    /**
     * Sets the onstart.
     *
     * @param onstart
     *            the new onstart
     */
    public void setOnstart(Function onstart) {
        this.onstart = onstart;
    }

    /**
     * Gets the onbounce.
     *
     * @return the onbounce
     */
    public Function getOnbounce() {
        return this
                .getEventFunction(onbounce, HtmlJsAttributeProperties.BOUNCE);
    }

    /**
     * Sets the onbounce.
     *
     * @param onbounce
     *            the new onbounce
     */
    public void setOnbounce(Function onbounce) {
        this.onbounce = onbounce;
    }

    /**
     * Gets the onblur.
     *
     * @return the onblur
     */
    public Function getOnblur() {
        return this.getEventFunction(onblur, HtmlJsAttributeProperties.BLUR);
    }

    /**
     * Sets the onblur.
     *
     * @param onblur
     *            the new onblur
     */
    public void setOnblur(Function onblur) {
        this.onblur = onblur;
    }

    /**
     * Gets the onclick.
     *
     * @return the onclick
     */
    public Function getOnclick() {
        return this.getEventFunction(onclick, HtmlJsAttributeProperties.CLICK);
    }

    /**
     * Sets the onclick.
     *
     * @param onclick
     *            the new onclick
     */
    public void setOnclick(Function onclick) {
        this.onclick = onclick;
    }

    /**
     * Gets the ondblclick.
     *
     * @return the ondblclick
     */
    public Function getOndblclick() {
        return this.getEventFunction(ondblclick,
                HtmlJsAttributeProperties.DBLCLICK);
    }

    /**
     * Sets the ondblclick.
     *
     * @param ondblclick
     *            the new ondblclick
     */
    public void setOndblclick(Function ondblclick) {
        this.ondblclick = ondblclick;
    }

    /**
     * Gets the onfocus.
     *
     * @return the onfocus
     */
    public Function getOnfocus() {
        return this.getEventFunction(onfocus, HtmlJsAttributeProperties.FOCUS);
    }

    /**
     * Sets the onfocus.
     *
     * @param onfocus
     *            the new onfocus
     */
    public void setOnfocus(Function onfocus) {
        this.onfocus = onfocus;
    }

    /**
     * Gets the onkeydown.
     *
     * @return the onkeydown
     */
    public Function getOnkeydown() {
        return this.getEventFunction(onkeydown,
                HtmlJsAttributeProperties.KEYDOWN);
    }

    /**
     * Sets the onkeydown.
     *
     * @param onkeydown
     *            the new onkeydown
     */
    public void setOnkeydown(Function onkeydown) {
        this.onkeydown = onkeydown;
    }

    /**
     * Gets the onkeypress.
     *
     * @return the onkeypress
     */
    public Function getOnkeypress() {
        return this.getEventFunction(onkeypress,
                HtmlJsAttributeProperties.KEYPRESS);
    }

    /**
     * Sets the onkeypress.
     *
     * @param onkeypress
     *            the new onkeypress
     */
    public void setOnkeypress(Function onkeypress) {
        this.onkeypress = onkeypress;
    }

    /**
     * Gets the onkeyup.
     *
     * @return the onkeyup
     */
    public Function getOnkeyup() {
        return this.getEventFunction(onkeyup, HtmlJsAttributeProperties.KEYUP);
    }

    /**
     * Sets the onkeyup.
     *
     * @param onkeyup
     *            the new onkeyup
     */
    public void setOnkeyup(Function onkeyup) {
        this.onkeyup = onkeyup;
    }

    /**
     * Gets the onmousedown.
     *
     * @return the onmousedown
     */
    public Function getOnmousedown() {
        return this.getEventFunction(onmousedown,
                HtmlJsAttributeProperties.MOUSEDOWN);
    }

    /**
     * Sets the onmousedown.
     *
     * @param onmousedown
     *            the new onmousedown
     */
    public void setOnmousedown(Function onmousedown) {
        this.onmousedown = onmousedown;
    }

    /**
     * Gets the onmousemove.
     *
     * @return the onmousemove
     */
    public Function getOnmousemove() {
        return this.getEventFunction(onmousemove,
                HtmlJsAttributeProperties.MOUSEMOVE);
    }

    /**
     * Sets the onmousemove.
     *
     * @param onmousemove
     *            the new onmousemove
     */
    public void setOnmousemove(Function onmousemove) {
        this.onmousemove = onmousemove;
    }

    /**
     * Gets the onmouseout.
     *
     * @return the onmouseout
     */
    public Function getOnmouseout() {
        return this.getEventFunction(onmouseout,
                HtmlJsAttributeProperties.MOUSEOUT);
    }

    /**
     * Sets the onmouseout.
     *
     * @param onmouseout
     *            the new onmouseout
     */
    public void setOnmouseout(Function onmouseout) {
        this.onmouseout = onmouseout;
    }

    /**
     * Gets the onmouseover.
     *
     * @return the onmouseover
     */
    public Function getOnmouseover() {
        return this.getEventFunction(onmouseover,
                HtmlJsAttributeProperties.MOUSEOVER);
    }

    /**
     * Sets the onmouseover.
     *
     * @param onmouseover
     *            the new onmouseover
     */
    public void setOnmouseover(Function onmouseover) {
        this.onmouseover = onmouseover;
    }

    /**
     * Gets the onmouseup.
     *
     * @return the onmouseup
     */
    public Function getOnmouseup() {
        return this.getEventFunction(onmouseup,
                HtmlJsAttributeProperties.MOUSEUP);
    }

    /**
     * Sets the onmouseup.
     *
     * @param onmouseup
     *            the new onmouseup
     */
    public void setOnmouseup(Function onmouseup) {
        this.onmouseup = onmouseup;
    }

    /**
     * Gets the oncontextmenu.
     *
     * @return the oncontextmenu
     */
    public Function getOncontextmenu() {
        return this.getEventFunction(oncontextmenu,
                HtmlJsAttributeProperties.CTEXTMENU);
    }

    /**
     * Sets the oncontextmenu.
     *
     * @param oncontextmenu
     *            the new oncontextmenu
     */
    public void setOncontextmenu(Function oncontextmenu) {
        this.oncontextmenu = oncontextmenu;
    }

    /**
     * Gets the onabort.
     *
     * @return the onabort
     */
    public Function getOnabort() {
        return this.getEventFunction(onabort, HtmlJsAttributeProperties.ABORT);
    }

    /**
     * Sets the onabort.
     *
     * @param onabort
     *            the new onabort
     */
    public void setOnabort(Function onabort) {
        this.onabort = onabort;
    }

    /**
     * Gets the onplay.
     *
     * @return the onplay
     */
    public Function getOnplay() {
        return this.getEventFunction(onplay, HtmlJsAttributeProperties.PLAY);
    }

    /**
     * Sets the onplay.
     *
     * @param onplay
     *            the new onplay
     */
    public void setOnplay(Function onplay) {
        this.onplay = onplay;
    }

    /**
     * Gets the onplaying.
     *
     * @return the onplaying
     */
    public Function getOnplaying() {
        return this.getEventFunction(onplaying,
                HtmlJsAttributeProperties.PLAYING);
    }

    /**
     * Sets the onplaying.
     *
     * @param onplaying
     *            the new onplaying
     */
    public void setOnplaying(Function onplaying) {
        this.onplaying = onplaying;
    }

    /**
     * Gets the onprogress.
     *
     * @return the onprogress
     */
    public Function getOnprogress() {
        return this.getEventFunction(onprogress,
                HtmlJsAttributeProperties.PROGRESS);
    }

    /**
     * Sets the onprogress.
     *
     * @param onprogress
     *            the new onprogress
     */
    public void setOnprogress(Function onprogress) {
        this.onprogress = onprogress;
    }

    /**
     * Gets the onratechange.
     *
     * @return the onratechange
     */
    public Function getOnratechange() {
        return this.getEventFunction(onprogress,
                HtmlJsAttributeProperties.PROGRESS);
    }

    /**
     * Sets the onratechange.
     *
     * @param onratechange
     *            the new onratechange
     */
    public void setOnratechange(Function onratechange) {
    }

    /**
     * Gets the onreadystatechange.
     *
     * @return the onreadystatechange
     */
    public Function getOnreadystatechange() {
        return this.getEventFunction(onreadystatechange,
                HtmlJsAttributeProperties.READYSTATECHANGE);
    }

    /**
     * Sets the onreadystatechange.
     *
     * @param onreadystatechange
     *            the new onreadystatechange
     */
    public void setOnreadystatechange(Function onreadystatechange) {
        this.onreadystatechange = onreadystatechange;
    }

    /**
     * Gets the onscroll.
     *
     * @return the onscroll
     */
    public Function getOnscroll() {
        return this
                .getEventFunction(onscroll, HtmlJsAttributeProperties.SCROLL);
    }

    /**
     * Sets the onscroll.
     *
     * @param onscroll
     *            the new onscroll
     */
    public void setOnscroll(Function onscroll) {
        this.onscroll = onscroll;
    }

    /**
     * Gets the onseeked.
     *
     * @return the onseeked
     */
    public Function getOnseeked() {
        return this
                .getEventFunction(onseeked, HtmlJsAttributeProperties.SEEKED);
    }

    /**
     * Sets the onseeked.
     *
     * @param onseeked
     *            the new onseeked
     */
    public void setOnseeked(Function onseeked) {
        this.onseeked = onseeked;
    }

    /**
     * Gets the onseeking.
     *
     * @return the onseeking
     */
    public Function getOnseeking() {
        return this.getEventFunction(onseeking,
                HtmlJsAttributeProperties.SEEKING);
    }

    /**
     * Sets the onseeking.
     *
     * @param onseeking
     *            the new onseeking
     */
    public void setOnseeking(Function onseeking) {
        this.onseeking = onseeking;
    }

    /**
     * Gets the onselect.
     *
     * @return the onselect
     */
    public Function getOnselect() {
        return this
                .getEventFunction(onselect, HtmlJsAttributeProperties.SELECT);
    }

    /**
     * Sets the onselect.
     *
     * @param onselect
     *            the new onselect
     */
    public void setOnselect(Function onselect) {
        this.onselect = onselect;
    }

    /**
     * Gets the onshow.
     *
     * @return the onshow
     */
    public Function getOnshow() {
        return this.getEventFunction(onshow, HtmlJsAttributeProperties.SHOW);
    }

    /**
     * Sets the onshow.
     *
     * @param onshow
     *            the new onshow
     */
    public void setOnshow(Function onshow) {
        this.onshow = onshow;
    }

    /**
     * Gets the onstalled.
     *
     * @return the onstalled
     */
    public Function getOnstalled() {
        return this.getEventFunction(onstalled,
                HtmlJsAttributeProperties.STALLED);
    }

    /**
     * Sets the onstalled.
     *
     * @param onstalled
     *            the new onstalled
     */
    public void setOnstalled(Function onstalled) {
        this.onstalled = onstalled;
    }

    /**
     * Gets the onsubmit.
     *
     * @return the onsubmit
     */
    public Function getOnsubmit() {
        return this
                .getEventFunction(onsubmit, HtmlJsAttributeProperties.SUBMIT);
    }

    /**
     * Sets the onsubmit.
     *
     * @param onsubmit
     *            the new onsubmit
     */
    public void setOnsubmit(Function onsubmit) {
        this.onsubmit = onsubmit;
    }

    /**
     * Gets the onsuspend.
     *
     * @return the onsuspend
     */
    public Function getOnsuspend() {
        return this.getEventFunction(onsuspend,
                HtmlJsAttributeProperties.SUSPEND);
    }

    /**
     * Sets the onsuspend.
     *
     * @param onsuspend
     *            the new onsuspend
     */
    public void setOnsuspend(Function onsuspend) {
        this.onsuspend = onsuspend;
    }

    /**
     * Gets the ontimeupdate.
     *
     * @return the ontimeupdate
     */
    public Function getOntimeupdate() {
        return this.getEventFunction(ontimeupdate,
                HtmlJsAttributeProperties.TIMEUPDATE);
    }

    /**
     * Sets the ontimeupdate.
     *
     * @param ontimeupdate
     *            the new ontimeupdate
     */
    public void setOntimeupdate(Function ontimeupdate) {
        this.ontimeupdate = ontimeupdate;
    }

    /**
     * Gets the onvolumechange.
     *
     * @return the onvolumechange
     */
    public Function getOnvolumechange() {
        return this.getEventFunction(onvolumechange,
                HtmlJsAttributeProperties.VOLUMECHANGE);
    }

    /**
     * Sets the onvolumechange.
     *
     * @param onvolumechange
     *            the new onvolumechange
     */
    public void setOnvolumechange(Function onvolumechange) {
        this.onvolumechange = onvolumechange;
    }

    /**
     * Gets the onwaiting.
     *
     * @return the onwaiting
     */
    public Function getOnwaiting() {
        return this.getEventFunction(onwaiting,
                HtmlJsAttributeProperties.WAITING);
    }

    /**
     * Sets the onwaiting.
     *
     * @param onwaiting
     *            the new onwaiting
     */
    public void setOnwaiting(Function onwaiting) {
        this.onwaiting = onwaiting;
    }

    /**
     * Gets the onload.
     *
     * @return the onload
     */
    public Function getOnload() {
        return this.getEventFunction(onload, HtmlJsAttributeProperties.LOAD);
    }

    /**
     * Sets the onload.
     *
     * @param onload
     *            the new onload
     */
    public void setOnload(Function onload) {
        this.onload = onload;
    }

    @Override
    public void focus() {
        UINode node = this.getUINode();
        if (node != null) {
            node.focus();
        }
    }

    @Override
    public void blur() {
        UINode node = this.getUINode();
        if (node != null) {
            node.blur();
        }
    }

    /**
     * Adds the event listener.
     *
     * @param script the script
     * @param function the function
     * @param bool the bool
     */
    public void addEventListener(String script, Function function, boolean bool) {
        addEventListener(script, function);
    }
    
    /**
     * Removes the event listener.
     *
     * @param script the script
     * @param function the function
     * @param bool the bool
     */
    public void removeEventListener(String script, Function function, boolean bool) {
        removeEventListener(script, function);
    }
    
    /**
     * Adds the event listener.
     *
     * @param script the script
     * @param function the function
     */
    public void addEventListener(String script, Function function) {

        String key = script.toLowerCase();

        if (key.equals(HtmlJsAttributeProperties.CLICK)) {
            setOnclick(function);

        } else if (key.equals(HtmlJsAttributeProperties.DBLCLICK)) {
            setOndblclick(function);

        } else if (key.equals(HtmlJsAttributeProperties.MOUSEUP)) {
            setOnmouseup(function);

        } else if (key.equals(HtmlJsAttributeProperties.MOUSEDOWN)) {
            setOnmousedown(function);

        } else if (key.equals(HtmlJsAttributeProperties.KEYPRESS)) {
            setOnkeypress(function);

        } else if (key.equals(HtmlJsAttributeProperties.KEYUP)) {
            setOnkeyup(function);

        } else if (key.equals(HtmlJsAttributeProperties.KEYDOWN)) {
            setOnkeydown(function);

        } else if (key.equals(HtmlJsAttributeProperties.LOAD)) {
            setOnload(function);

        } else {
        }

    }

    /**
     * Removes the event listener.
     *
     * @param script the script
     * @param function the function
     */
    public void removeEventListener(String script, Function function) {
        String key = script.toLowerCase();

        if (key.equals(HtmlJsAttributeProperties.CLICK)) {
            setOnclick(null);

        } else if (key.equals(HtmlJsAttributeProperties.DBLCLICK)) {
            setOndblclick(null);

        } else if (key.equals(HtmlJsAttributeProperties.MOUSEUP)) {
            setOnmouseup(null);

        } else if (key.equals(HtmlJsAttributeProperties.MOUSEDOWN)) {
            setOnmousedown(null);

        } else if (key.equals(HtmlJsAttributeProperties.KEYPRESS)) {
            setOnkeypress(null);

        } else if (key.equals(HtmlJsAttributeProperties.KEYUP)) {
            setOnkeyup(null);

        } else if (key.equals(HtmlJsAttributeProperties.KEYDOWN)) {
            setOnkeydown(null);

        } else if (key.equals(HtmlJsAttributeProperties.LOAD)) {
            setOnload(null);

        } else {
        }
    }

    /**
     * Gets the event function.
     *
     * @param varValue
     *            the var value
     * @param attributeName
     *            the attribute name
     * @return the event function
     */
    public Function getEventFunction(Function varValue, String attributeName) {

        if (varValue != null) {
            return varValue;
        }

        String normalAttributeName = this.normalizeAttributeName(attributeName);
        synchronized (this) {
            Map<String, Function> fba = this.functionByAttribute;
            Function f = fba == null ? null : (Function) fba
                    .get(normalAttributeName);
            if (f != null) {
                return f;
            }
            UserAgentContext uac = this.getUserAgentContext();
            if (uac == null) {
                throw new IllegalStateException("No user agent context.");
            }
            if (uac.isScriptingEnabled()) {
                String attributeValue = this.getAttribute(attributeName);
                if ((attributeValue == null) || (attributeValue.length() == 0)) {
                    f = null;
                } else {
                    String functionCode = "function " + normalAttributeName
                            + "_" + System.identityHashCode(this) + "() {"
                            + attributeValue + "}";
                    Document doc = this.document;
                    if (doc == null) {
                        throw new IllegalStateException(
                                "Element does not belong to a document.");
                    }
                    Context ctx = Executor.createContext(this.getDocumentURL(),
                            uac);
                    try {
                        Scriptable scope = (Scriptable) doc
                                .getUserData(Executor.SCOPE_KEY);
                        if (scope == null) {
                            throw new IllegalStateException(
                                    "Scriptable (scope) instance was expected to be keyed as UserData to document using "
                                            + Executor.SCOPE_KEY);
                        }
                        Scriptable thisScope = (Scriptable) JavaScript
                                .getInstance().getJavascriptObject(this, scope);
                        try {
                            // TODO: Get right line number for script. //TODO:
                            // Optimize this in case it's called multiple times?
                            // Is that done?
                            f = ctx.compileFunction(thisScope, functionCode,
                                    this.getTagName() + "[" + this.getId()
                                            + "]." + attributeName, 1, null);
                        } catch (EcmaError ecmaError) {
                            logger.log(
                                    Level.WARNING,
                                    "Javascript error at "
                                            + ecmaError.sourceName() + ":"
                                            + ecmaError.lineNumber() + ": "
                                            + ecmaError.getMessage(), ecmaError);
                            f = null;
                        } catch (Throwable err) {
                            logger.log(Level.WARNING,
                                    "Unable to evaluate Javascript code", err);
                            f = null;
                        }
                    } finally {
                        Context.exit();
                    }
                }
                if (fba == null) {
                    fba = new HashMap<String, Function>(1);
                    this.functionByAttribute = fba;
                }
                fba.put(normalAttributeName, f);
            }
            return f;
        }
    }

    @Override
    protected void assignAttributeField(String normalName, String value) {
        super.assignAttributeField(normalName, value);
        if (normalName.startsWith("on")) {
            synchronized (this) {
                Map<String, Function> fba = this.functionByAttribute;
                if (fba != null) {
                    fba.remove(normalName);
                }
            }
        }
    }
}
