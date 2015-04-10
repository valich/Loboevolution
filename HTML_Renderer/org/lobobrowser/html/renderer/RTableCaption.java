/*
    GNU LESSER GENERAL PUBLIC LICENSE
    Copyright (C) 2006 The XAMJ Project. Copyright (C) 2014 - 2015 Lobo Evolution

    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU Lesser General Public
    License as published by the Free Software Foundation; either
    version 2.1 of the License, or (at your option) any later version.

    This library is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
    Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public
    License along with this library; if not, write to the Free Software
    Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA

    Contact info: lobochief@users.sourceforge.net; ivan.difrancesco@yahoo.it
 */
package org.lobobrowser.html.renderer;

import org.lobobrowser.html.HtmlRendererContext;
import org.lobobrowser.html.UserAgentContext;
import org.lobobrowser.html.domimpl.HTMLTableCaptionElementImpl;


/**
 * The Class RTableCaption.
 */
public class RTableCaption extends RBlock {
	
	/**
	 * Instantiates a new r table caption.
	 *
	 * @param element the element
	 * @param pcontext the pcontext
	 * @param rcontext the rcontext
	 * @param frameContext the frame context
	 * @param tableAsContainer the table as container
	 */
	public RTableCaption(HTMLTableCaptionElementImpl element,
			UserAgentContext pcontext, HtmlRendererContext rcontext,
			FrameContext frameContext, RenderableContainer tableAsContainer) {
		super(element, 0, pcontext, rcontext, frameContext, tableAsContainer);
	}
}