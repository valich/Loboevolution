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
 * Created on Jan 15, 2006
 */
package org.lobobrowser.html.domimpl;

import org.lobobrowser.html.FormInput;
import org.lobobrowser.html.HtmlAttributeProperties;
import org.lobobrowser.html.HtmlProperties;
import org.lobobrowser.html.dombl.InputContext;
import org.lobobrowser.html.w3c.HTMLTextAreaElement;
import org.lobobrowser.html.w3c.ValidityState;
import org.w3c.dom.NodeList;

/**
 * The Class HTMLTextAreaElementImpl.
 */
public class HTMLTextAreaElementImpl extends HTMLBaseInputElement implements
HTMLTextAreaElement {

    /**
     * Instantiates a new HTML text area element impl.
     *
     * @param name
     *            the name
     */
    public HTMLTextAreaElementImpl(String name) {
        super(name);
    }

    /**
     * Instantiates a new HTML text area element impl.
     */
    public HTMLTextAreaElementImpl() {
        super(HtmlProperties.TEXTAREA);
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.domimpl.HTMLElementImpl#getFormInputs()
     */
    @Override
    protected FormInput[] getFormInputs() {
        String name = this.getName();
        if (name == null) {
            return null;
        }
        return new FormInput[] {new FormInput(name, this.getValue())};
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLTextAreaElement#getCols()
     */
    @Override
    public int getCols() {
        InputContext ic = this.inputContext;
        return ic == null ? 0 : ic.getCols();
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLTextAreaElement#getRows()
     */
    @Override
    public int getRows() {
        InputContext ic = this.inputContext;
        return ic == null ? 0 : ic.getRows();
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLTextAreaElement#getType()
     */
    @Override
    public String getType() {
        return "textarea";
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLTextAreaElement#setCols(int)
     */
    @Override
    public void setCols(int cols) {
        InputContext ic = this.inputContext;
        if (ic != null) {
            ic.setCols(cols);
        }
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLTextAreaElement#setRows(int)
     */
    @Override
    public void setRows(int rows) {
        InputContext ic = this.inputContext;
        if (ic != null) {
            ic.setRows(rows);
        }
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLTextAreaElement#getAutofocus()
     */
    @Override
    public boolean getAutofocus() {
        String autofocus = this.getAttribute(HtmlAttributeProperties.AUTOFOCUS);
        return HtmlAttributeProperties.AUTOFOCUS.equalsIgnoreCase(autofocus);
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLTextAreaElement#setAutofocus(boolean)
     */
    @Override
    public void setAutofocus(boolean autofocus) {
        this.setAttribute(HtmlAttributeProperties.AUTOFOCUS,
                autofocus ? HtmlAttributeProperties.AUTOFOCUS : null);

    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLTextAreaElement#getMaxLength()
     */
    @Override
    public int getMaxLength() {
        try {
            return Integer.parseInt(this
                    .getAttribute(HtmlAttributeProperties.MAXLENGTH));
        } catch (Exception thrown) {
            this.warn("getMaxLength(): Unable to parse size attribute in "
                    + this + ".", thrown);
            return 0;
        }
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLTextAreaElement#setMaxLength(int)
     */
    @Override
    public void setMaxLength(int maxLength) {
        this.setAttribute(HtmlAttributeProperties.MAXLENGTH,
                String.valueOf(maxLength));

    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLTextAreaElement#getRequired()
     */
    @Override
    public boolean getRequired() {
        String required = this.getAttribute(HtmlAttributeProperties.REQUIRED);
        return HtmlAttributeProperties.REQUIRED.equalsIgnoreCase(required);
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLTextAreaElement#setRequired(boolean)
     */
    @Override
    public void setRequired(boolean required) {
        this.setAttribute(HtmlAttributeProperties.REQUIRED,
                required ? HtmlAttributeProperties.REQUIRED : null);

    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLTextAreaElement#getWrap()
     */
    @Override
    public String getWrap() {
        return this.getAttribute(HtmlAttributeProperties.WRAP);
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLTextAreaElement#setWrap(java.lang.String)
     */
    @Override
    public void setWrap(String wrap) {
        this.setAttribute(HtmlAttributeProperties.WRAP, wrap);

    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLTextAreaElement#getTextLength()
     */
    @Override
    public int getTextLength() {
        return this.getValue().length();
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLTextAreaElement#getWillValidate()
     */
    @Override
    public boolean getWillValidate() {
        // TODO Auto-generated method stub
        return false;
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLTextAreaElement#getValidity()
     */
    @Override
    public ValidityState getValidity() {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLTextAreaElement#getValidationMessage()
     */
    @Override
    public String getValidationMessage() {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLTextAreaElement#checkValidity()
     */
    @Override
    public boolean checkValidity() {
        // TODO Auto-generated method stub
        return false;
    }

    /*
     * (non-Javadoc)
     * @see
     * org.lobobrowser.html.w3c.HTMLTextAreaElement#setCustomValidity(java.lang.
     * String)
     */
    @Override
    public void setCustomValidity(String error) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLTextAreaElement#getLabels()
     */
    @Override
    public NodeList getLabels() {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLTextAreaElement#getSelectionStart()
     */
    @Override
    public int getSelectionStart() {
        // TODO Auto-generated method stub
        return 0;
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLTextAreaElement#setSelectionStart(int)
     */
    @Override
    public void setSelectionStart(int selectionStart) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLTextAreaElement#getSelectionEnd()
     */
    @Override
    public int getSelectionEnd() {
        // TODO Auto-generated method stub
        return 0;
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLTextAreaElement#setSelectionEnd(int)
     */
    @Override
    public void setSelectionEnd(int selectionEnd) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLTextAreaElement#setSelectionRange(int, int)
     */
    @Override
    public void setSelectionRange(int start, int end) {
        // TODO Auto-generated method stub

    }
}
