/*
 * Copyright 1994-2006 The Lobo Project. Copyright 2014 Lobo Evolution. All
 * rights reserved. Redistribution and use in source and binary forms, with or
 * without modification, are permitted provided that the following conditions
 * are met: Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer. Redistributions
 * in binary form must reproduce the above copyright notice, this list of
 * conditions and the following disclaimer in the documentation and/or other
 * materials provided with the distribution. THIS SOFTWARE IS PROVIDED BY THE
 * LOBO PROJECT ``AS IS'' AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT
 * NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE FREEBSD PROJECT OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.lobobrowser.ua;

import org.lobobrowser.clientlet.ClientletResponse;

/**
 * An event containing information about navigation.
 */
public class NavigatorWindowEvent extends NavigatorResponseEvent {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /** The message. */
    private final String message;

    /**
     * Instantiates a new navigator window event.
     *
     * @param source
     *            the source
     * @param eventType
     *            the event type
     * @param clientletFrame
     *            the clientlet frame
     * @param response
     *            the response
     */
    public NavigatorWindowEvent(Object source, NavigatorEventType eventType,
            NavigatorFrame clientletFrame, ClientletResponse response) {
        super(source, eventType, clientletFrame, response, response
                .getRequestType());
        this.message = null;
    }

    /**
     * Instantiates a new navigator window event.
     *
     * @param source
     *            the source
     * @param eventType
     *            the event type
     * @param clientletFrame
     *            the clientlet frame
     * @param message
     *            the message
     * @param requestType
     *            the request type
     */
    public NavigatorWindowEvent(Object source, NavigatorEventType eventType,
            NavigatorFrame clientletFrame, String message,
            RequestType requestType) {
        super(source, eventType, clientletFrame, null, requestType);
        this.message = message;
    }

    /**
     * Gets the message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }
}
