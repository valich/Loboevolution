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

import java.awt.Component;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.lobobrowser.clientlet.ComponentContent;

/**
 * Represents a navigator frame. In many ways this interface parallels the
 * JavaScript "Window" object.
 */
public interface NavigatorFrame {

    /**
     * Opens a URL in a separate window.
     *
     * @param urlOrPath
     *            The absolute URL or file path to open.
     * @return the navigator frame
     * @throws MalformedURLException
     *             the malformed url exception
     */
    NavigatorFrame open(String urlOrPath) throws MalformedURLException;

    /**
     * Opens a URL in a separate window.
     *
     * @param url
     *            The URL to open.
     * @return the navigator frame
     */
    NavigatorFrame open(URL url);

    /**
     * Opens a URL in a separate window using the properties provided.
     *
     * @param url
     *            The URL to open.
     * @param windowProperties
     *            Window properties, following Javascript Window.open()
     *            conventions.
     * @return the navigator frame
     * @throws MalformedURLException
     *             the malformed url exception
     */
    NavigatorFrame open(URL url, Properties windowProperties)
            throws MalformedURLException;

    /**
     * Opens a URL in a separate window.
     *
     * @param url
     *            The URL to open.
     * @param method
     *            The request method, e.g. GET.
     * @param pinfo
     *            The URL parameter information.
     * @param windowId
     *            the window id
     * @param windowProperties
     *            Window properties, following Javascript Window.open()
     *            conventions.
     * @return the navigator frame
     */
    NavigatorFrame open(URL url, String method, ParameterInfo pinfo,
            String windowId, Properties windowProperties);

    /**
     * Opens a URL in a separate window.
     *
     * @param url
     *            The URL to open.
     * @param method
     *            The request method, e.g. GET.
     * @param pinfo
     *            The URL parameter information.
     * @return the navigator frame
     */
    NavigatorFrame open(URL url, String method, ParameterInfo pinfo);

    /**
     * Navigates to a URL in the current frame.
     *
     * @param urlOrPath
     *            An <i>absolute</i> URL or file path.
     * @throws MalformedURLException
     *             the malformed url exception
     */
    void navigate(String urlOrPath) throws MalformedURLException;

    /**
     * Navigates to a URL in the current frame.
     *
     * @param urlOrPath
     *            An <i>absolute</i> URL or file path.
     * @param requestType
     *            The request type.
     * @throws MalformedURLException
     *             the malformed url exception
     */
    void navigate(String urlOrPath, RequestType requestType)
            throws MalformedURLException;

    /**
     * Navigates to a URL in the current frame.
     *
     * @param url
     *            An absolute URL.
     */
    void navigate(URL url);

    /**
     * Navigates to a URL in the current frame.
     *
     * @param url
     *            An absolute URL.
     * @param requestType
     *            The request type.
     */
    void navigate(URL url, RequestType requestType);

    /**
     * Navigates to a URL in the current frame.
     *
     * @param url
     *            An absolute or relative URL.
     * @param method
     *            The request method.
     * @param paramInfo
     *            The request parameters.
     * @param targetType
     *            The frame target type.
     * @param requestType
     *            The request type.
     */
    void navigate(URL url, String method, ParameterInfo paramInfo,
            TargetType targetType, RequestType requestType);

    /**
     * Navigates to a URL in the current frame. This method should be used when
     * the originating frame of the request differs from the target frame.
     *
     * @param url
     *            An absolute or relative URL.
     * @param method
     *            The request method.
     * @param paramInfo
     *            The request parameters.
     * @param targetType
     *            The frame target type.
     * @param requestType
     *            The request type.
     * @param originatingFrame
     *            The frame where the request originated.
     */
    void navigate(URL url, String method, ParameterInfo paramInfo,
            TargetType targetType, RequestType requestType,
            NavigatorFrame originatingFrame);

    /**
     * Similar to
     * {@link #navigate(URL, String, ParameterInfo, TargetType, RequestType)} ,
     * except this method should be called when navigation is triggered by a
     * user click.
     *
     * @param url
     *            An absolute or relative URL.
     * @param targetType
     *            The frame target type.
     * @param linkObject
     *            An implementation-dependent object representing what was
     *            clicked. For example, in HTML documents the
     *            <code>linkObject</code> might be of type
     *            <code>org.w3c.dom.html2.HTMLElement</code>.
     */
    void linkClicked(URL url, TargetType targetType, Object linkObject);

    /**
     * Closes the current window, if allowed.
     */
    void closeWindow();

    /**
     * Executes a task later in the event dispatch thread.
     *
     * @param runnable
     *            the runnable
     */
    void invokeLater(Runnable runnable);

    /**
     * Sends the window of this clientlet context to the back and may cause it
     * to lose focus.
     */
    void windowToBack();

    /**
     * Sends the window of this clientlet context to the front and may cause it
     * to request focus.
     */
    void windowToFront();

    /**
     * Opens a Yes/No confirmation dialog.
     *
     * @param message
     *            The question text.
     * @return True only if Yes is selected.
     */
    boolean confirm(String message);

    /**
     * Opens a prompt dialog.
     *
     * @param message
     *            The question text.
     * @param inputDefault
     *            The default prompt value.
     * @return The text entered by the user.
     */
    String prompt(String message, String inputDefault);

    /**
     * Gets a component for the current frame which could be serve as the parent
     * of pop-up dialogs. This is <i>not</i> the rendered component.
     *
     * @return the component
     * @see #getComponentContent()
     */
    Component getComponent();

    /**
     * Opens an alert dialog.
     *
     * @param message
     *            The message shown in the alert dialog.
     */
    void alert(String message);

    /**
     * Requests the frame to update its progress state.
     *
     * @param event
     *            The progress event object.
     * @see #getProgressEvent()
     */
    void setProgressEvent(NavigatorProgressEvent event);

    /**
     * Gets the most recent progress event.
     *
     * @return the progress event
     * @see #setProgressEvent(NavigatorProgressEvent)
     */
    NavigatorProgressEvent getProgressEvent();

    /**
     * Gets the frame that contains the current one, if any. Returns
     * <code>null</code> for the top frame.
     *
     * @return the parent frame
     */
    NavigatorFrame getParentFrame();

    /**
     * Gets the top-most frame in the window. Returns the current frame if its
     * parent is <code>null</code>.
     *
     * @return the top frame
     */
    NavigatorFrame getTopFrame();

    // (commenting out - gives opportunity to retain objects)
    // void setItem(String name, Object value);
    // Object getItem(String name);

    /**
     * Back.
     *
     * @return true, if successful
     */
    boolean back();

    /**
     * Forward.
     *
     * @return true, if successful
     */
    boolean forward();

    /**
     * Can forward.
     *
     * @return true, if successful
     */
    boolean canForward();

    /**
     * Can back.
     *
     * @return true, if successful
     */
    boolean canBack();

    /**
     * Creates the frame.
     *
     * @return the navigator frame
     */
    NavigatorFrame createFrame();

    /**
     * Gets the default status.
     *
     * @return the default status
     */
    String getDefaultStatus();

    /**
     * Sets the default status.
     *
     * @param value
     *            the new default status
     */
    void setDefaultStatus(String value);

    /**
     * Gets the window id.
     *
     * @return the window id
     */
    String getWindowId();

    /**
     * Gets the opener frame.
     *
     * @return the opener frame
     */
    NavigatorFrame getOpenerFrame();

    /**
     * Gets the status.
     *
     * @return the status
     */
    String getStatus();

    /**
     * Checks if is window closed.
     *
     * @return true, if is window closed
     */
    boolean isWindowClosed();

    /**
     * Sets the status.
     *
     * @param status
     *            the new status
     */
    void setStatus(String status);

    /**
     * Reload.
     */
    void reload();

    /**
     * Replaces the content of the frame. Thrown when the caller does not have
     * permission to replace the content of the frame.
     *
     * @param response
     *            the response
     * @param component
     *            the component
     * @see org.lobobrowser.clientlet.ClientletContext#setResultingContent(Component)
     */
    void replaceContent(
            org.lobobrowser.clientlet.ClientletResponse response,
            org.lobobrowser.clientlet.ComponentContent component);

    /**
     * A simple alternative to
     * {@link #replaceContent(org.lobobrowser.clientlet.ClientletResponse, org.lobobrowser.clientlet.ComponentContent)}
     * provided for convenience.
     *
     * @param component
     *            A AWT or Swing component.
     */
    void replaceContent(Component component);

    /**
     * Gets source code for content currently showing, if any. Thrown when the
     * caller does not have permission to get the source code.
     *
     * @return the source code
     */
    String getSourceCode();

    /**
     * Creates a {@link NetworkRequest} object that can be used to load data
     * over HTTP and other network protocols.
     *
     * @return the network request
     */
    NetworkRequest createNetworkRequest();

    /**
     * Gets the component content currently set in the frame.
     *
     * @return the component content
     */
    ComponentContent getComponentContent();

    /**
     * Resizes the browser window.
     *
     * @param width
     *            The new window width.
     * @param height
     *            The new window height.
     */
    void resizeWindowTo(int width, int height);

    /**
     * Resizes the browser window.
     *
     * @param byWidth
     *            The number of pixels to expand the width by.
     * @param byHeight
     *            The number of pixels to expand the height by.
     */
    void resizeWindowBy(int byWidth, int byHeight);

    /**
     * Gets an object that represents the current navigation entry in the
     * frame's history.
     *
     * @return the current navigation entry
     */
    NavigationEntry getCurrentNavigationEntry();

    /**
     * Gets the previous navigation entry.
     *
     * @return the previous navigation entry
     */
    NavigationEntry getPreviousNavigationEntry();

    /**
     * Gets the next navigation entry.
     *
     * @return the next navigation entry
     */
    NavigationEntry getNextNavigationEntry();

    /**
     * Switches to a new navigation entry in the frame's history, according to
     * the given offset.
     *
     * @param offset
     *            A positive or negative number, where -1 is equivalent to
     *            {@link #back()} and +1 is equivalent to {@link #forward()}.
     */
    void moveInHistory(int offset);

    /**
     * Navigates to a URL that exists in the frame's history.
     *
     * @param absoluteURL
     *            The target URL.
     */
    void navigateInHistory(String absoluteURL);

    /**
     * Gets the length for the frame's history.
     *
     * @return the history length
     */
    int getHistoryLength();

    /**
     * Sets an implementation-dependent property of the underlying component
     * currently rendered. For example, a Cobra-based HTML component accepts
     * properties such as <code>defaultMarginInsets</code> (java.awt.Inset),
     * <code>defaultOverflowX</code> and <code>defaultOverflowY</code>.
     *
     * @param name
     *            The name of the property.
     * @param value
     *            The value of the property. The type of the value depends on
     *            the property and the underlying implementation.
     */
    void setProperty(String name, Object value);
}
