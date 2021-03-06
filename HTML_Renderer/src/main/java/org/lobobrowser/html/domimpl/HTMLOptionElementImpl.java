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

import org.lobobrowser.html.HtmlAttributeProperties;
import org.lobobrowser.html.w3c.HTMLFormElement;
import org.lobobrowser.html.w3c.HTMLOptionElement;
import org.lobobrowser.html.w3c.HTMLSelectElement;

/**
 * The Class HTMLOptionElementImpl.
 */
public class HTMLOptionElementImpl extends HTMLElementImpl implements
HTMLOptionElement {

    /**
     * Instantiates a new HTML option element impl.
     *
     * @param name
     *            the name
     */
    public HTMLOptionElementImpl(String name) {
        super(name, true);
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLOptionElement#getDefaultSelected()
     */
    @Override
    public boolean getDefaultSelected() {
        return this.getAttributeAsBoolean(HtmlAttributeProperties.SELECTED);
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.domimpl.DOMElementImpl#getDisabled()
     */
    @Override
    public boolean getDisabled() {
        return false;
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLOptionElement#getForm()
     */
    @Override
    public HTMLFormElement getForm() {
        return this.getForm();
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLOptionElement#getIndex()
     */
    @Override
    public int getIndex() {
        Object parent = this.getParentNode();
        if (parent instanceof HTMLSelectElement) {
            HTMLOptionsCollectionImpl options = (HTMLOptionsCollectionImpl) ((HTMLSelectElement) parent)
                    .getOptions();
            return options.indexOf(this);
        } else {
            return -1;
        }
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.domimpl.HTMLElementImpl#getLabel()
     */
    @Override
    public String getLabel() {
        return this.getAttribute(HtmlAttributeProperties.LABEL);
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLOptionElement#getSelected()
     */
    @Override
    public boolean getSelected() {
        return this.selected;
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLOptionElement#getText()
     */
    @Override
    public String getText() {
        return this.getRawInnerText(false);
    }

    /**
     * Sets the text.
     *
     * @param value
     *            the new text
     */
    public void setText(String value) {
        this.setTextContent(value);
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLOptionElement#getValue()
     */
    @Override
    public String getValue() {
        return this.getAttribute(HtmlAttributeProperties.VALUE);
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLOptionElement#setDefaultSelected(boolean)
     */
    @Override
    public void setDefaultSelected(boolean defaultSelected) {
        this.setAttribute(HtmlAttributeProperties.SELECTED,
                defaultSelected ? HtmlAttributeProperties.SELECTED : null);
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLOptionElement#setDisabled(boolean)
     */
    @Override
    public void setDisabled(boolean disabled) {
        // TODO Unsupported
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLOptionElement#setLabel(java.lang.String)
     */
    @Override
    public void setLabel(String label) {
        this.setAttribute(HtmlAttributeProperties.LABEL, label);
    }

    /** The selected. */
    private boolean selected;

    /**
     * Sets the selected impl.
     *
     * @param selected
     *            the new selected impl
     */
    void setSelectedImpl(boolean selected) {
        this.selected = selected;
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLOptionElement#setSelected(boolean)
     */
    @Override
    public void setSelected(boolean selected) {
        boolean changed = selected != this.selected;
        this.selected = selected;
        // Changing the option state changes the selected index.
        Object parent = this.getParentNode();
        if (parent instanceof HTMLSelectElementImpl) {
            HTMLSelectElementImpl parentSelect = ((HTMLSelectElementImpl) parent);
            if (changed || (parentSelect.getSelectedIndex() == -1)) {
                if (selected) {
                    parentSelect.setSelectedIndexImpl(this.getIndex());
                } else {
                    int currentIndex = parentSelect.getSelectedIndex();
                    if ((currentIndex != -1)
                            && (currentIndex == this.getIndex())) {
                        parentSelect.setSelectedIndexImpl(-1);
                    }
                }
            }
        }
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.w3c.HTMLOptionElement#setValue(java.lang.String)
     */
    @Override
    public void setValue(String value) {
        this.setAttribute(HtmlAttributeProperties.VALUE, value);
    }

    /*
     * (non-Javadoc)
     * @see org.lobobrowser.html.domimpl.HTMLElementImpl#toString()
     */
    @Override
    public String toString() {
        return "HTMLOptionElementImpl[text=" + this.getText() + ",selected="
                + this.getSelected() + "]";
    }
}
