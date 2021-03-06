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

package org.lobobrowser.html.style;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.lobobrowser.html.HttpRequest;
import org.lobobrowser.html.UserAgentContext;
import org.lobobrowser.html.domimpl.HTMLDocumentImpl;
import org.lobobrowser.util.Strings;
import org.lobobrowser.util.Urls;
import org.w3c.css.sac.InputSource;
import org.w3c.dom.css.CSSStyleSheet;
import org.w3c.dom.stylesheets.MediaList;

import com.steadystate.css.dom.CSSStyleSheetImpl;
import com.steadystate.css.parser.CSSOMParser;

/**
 * The Class CSSUtilities.
 */
public class CSSUtilities {

    /** The Constant logger. */
    private static final Logger logger = Logger.getLogger(CSSUtilities.class
            .getName());

    /**
     * Instantiates a new CSS utilities.
     */
    private CSSUtilities() {
    }

    /**
     * Pre process css.
     *
     * @param text
     *            the text
     * @return the string
     */
    public static String preProcessCss(String text) {
        try {
            BufferedReader reader = new BufferedReader(new StringReader(text));
            String line;
            StringBuffer sb = new StringBuffer();
            String pendingLine = null;
            // Only last line should be trimmed.
            while ((line = reader.readLine()) != null) {
                String tline = line.trim();
                if (tline.length() != 0) {
                    if (pendingLine != null) {
                        sb.append(pendingLine);
                        sb.append("\r\n");
                        pendingLine = null;
                    }
                    if (tline.startsWith("//")) {
                        pendingLine = line;
                        continue;
                    }
                    sb.append(line);
                    sb.append("\r\n");
                }
            }
            return sb.toString();
        } catch (IOException ioe) {
            // not possible
            throw new IllegalStateException(ioe.getMessage());
        }
    }

    /**
     * Gets the css input source for style sheet.
     *
     * @param text
     *            the text
     * @param scriptURI
     *            the script uri
     * @return the css input source for style sheet
     */
    public static InputSource getCssInputSourceForStyleSheet(String text,
            String scriptURI) {
        java.io.Reader reader = new StringReader(text);
        InputSource is = new InputSource(reader);
        is.setURI(scriptURI);
        return is;
    }

    /**
     * Parses the.
     *
     * @param ownerNode
     *            the owner node
     * @param href
     *            the href
     * @param text
     *            the text
     * @param baseUri
     *            the base uri
     * @param considerDoubleSlashComments
     *            the consider double slash comments
     * @return the CSS style sheet
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public static CSSStyleSheet parse(org.w3c.dom.Node ownerNode, String href,
            String text, String baseUri, boolean considerDoubleSlashComments)
                    throws IOException {

        URL baseURL = new URL(baseUri);
        URL scriptURL = Urls.createURL(baseURL, href);
        final String scriptURI = scriptURL == null ? href : scriptURL
                .toExternalForm();

        if ((text != null) && !"".equals(text)) {
            String processedText = considerDoubleSlashComments ? preProcessCss(text)
                    : text;
            CSSOMParser parser = new CSSOMParser();
            InputSource is = getCssInputSourceForStyleSheet(processedText,
                    scriptURI);
            is.setURI(scriptURI);

            CSSStyleSheetImpl sheet = (CSSStyleSheetImpl) parser
                    .parseStyleSheet(is, null, null);
            sheet.setHref(scriptURI);
            sheet.setOwnerNode(ownerNode);
            return sheet;

        } else {
            return null;
        }
    }

    /**
     * Parses the.
     *
     * @param ownerNode
     *            the owner node
     * @param text
     *            the text
     * @param baseUri
     *            the base uri
     * @param considerDoubleSlashComments
     *            the consider double slash comments
     * @return the CSS style sheet
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public static CSSStyleSheet parse(org.w3c.dom.Node ownerNode, String text,
            String baseUri, boolean considerDoubleSlashComments)
                    throws IOException {

        if ((text != null) && !"".equals(text)) {
            String processedText = considerDoubleSlashComments ? preProcessCss(text)
                    : text;
            CSSOMParser parser = new CSSOMParser();
            InputSource is = getCssInputSourceForStyleSheet(processedText,
                    baseUri);
            is.setURI(baseUri);

            CSSStyleSheetImpl sheet = (CSSStyleSheetImpl) parser
                    .parseStyleSheet(is, null, null);
            sheet.setHref(baseUri);
            sheet.setOwnerNode(ownerNode);
            return sheet;

        } else {
            return null;
        }
    }

    /**
     * Matches media.
     *
     * @param mediaValues
     *            the media values
     * @param rcontext
     *            the rcontext
     * @return true, if successful
     */
    public static boolean matchesMedia(String mediaValues,
            UserAgentContext rcontext) {
        if ((mediaValues == null) || (mediaValues.length() == 0)) {
            return true;
        }
        if (rcontext == null) {
            return false;
        }
        StringTokenizer tok = new StringTokenizer(mediaValues, ",");
        while (tok.hasMoreTokens()) {
            String token = tok.nextToken().trim();
            String mediaName = Strings.trimForAlphaNumDash(token);
            if (rcontext.isMedia(mediaName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Matches media.
     *
     * @param mediaList
     *            the media list
     * @param rcontext
     *            the rcontext
     * @return true, if successful
     */
    public static boolean matchesMedia(MediaList mediaList,
            UserAgentContext rcontext) {
        if (mediaList == null) {
            return true;
        }
        int length = mediaList.getLength();
        if (length == 0) {
            return true;
        }
        if (rcontext == null) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            String mediaName = mediaList.item(i);
            if (rcontext.isMedia(mediaName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Css text.
     *
     * @param href
     *            the href
     * @param doc
     *            the doc
     * @param baseUri
     *            the base uri
     * @return the array list
     * @throws MalformedURLException
     *             the malformed url exception
     * @throws UnsupportedEncodingException 
     */
	public static ArrayList<String> cssText(String href, HTMLDocumentImpl doc,
			String baseUri) throws MalformedURLException,
			UnsupportedEncodingException {

		UserAgentContext bcontext = doc.getUserAgentContext();
		final HttpRequest request = bcontext.createHttpRequest();
		URL baseURL = new URL(baseUri);
		URL scriptURL = Urls.createURL(baseURL, href);
		String responseText = "";

		String script = scriptURL == null ? href : scriptURL.toExternalForm();

		if ((script != null)
				&& (script.contains(".com") || script.contains(".it"))) {
			script = script.replace("file://", "http://");
		}

		final String scriptURI = script;

		// Perform a synchronous request
		SecurityManager sm = System.getSecurityManager();
		if (sm == null) {
			try {
					request.open("GET", scriptURI, false);
					request.send(null);
				} catch (IOException thrown) {
					logger.log(Level.WARNING, "processScript()", thrown);
				}

		} else {
			// Code might have restrictions on loading items from elsewhere.
			AccessController.doPrivileged(new PrivilegedAction<Object>() {
				@Override
				public Object run() {
					try {
						request.open("GET", scriptURI, false);
						request.send(null);
					} catch (IOException thrown) {
						logger.log(Level.WARNING, "parse()", thrown);
					}
					return null;
				}
			});
		}

		int status = request.getStatus();
		if ((status != 200) && (status != 0)) {
			responseText = httpURLConnection(scriptURI);
		} else {
			responseText = request.getResponseText();
		}
		return cssText(responseText);
	}

	/**
	 * Http url connection.
	 *
	 * @param url the url
	 * @return the string
	 */
	private static String httpURLConnection(String url) {

		URL obj;
		StringBuffer response = new StringBuffer();
		int responseCode = -1;
		try {
			obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			responseCode = con.getResponseCode();

			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

		} catch (Exception e) {
			logger.warning("Unable to parse CSS. URI=[" + url
					+ "]. Response status was " + responseCode + ".");
			return "";
		}
		return response.toString();
	}

    /**
     * Css text.
     *
     * @param text
     *            the text
     * @return the array list
     * @throws MalformedURLException
     *             the malformed url exception
     */
    public static ArrayList<String> cssText(String text)
            throws MalformedURLException {

        ArrayList<String> listText = new ArrayList<String>();

        text = text.replaceAll("\n", "").replaceAll("\r", "")
                .replaceAll("}", "}\n");

        String[] splitString = text.split("\n");

        for (int i = 0; i < splitString.length; i++) {

            String str = splitString[i];

            if ((str != null) && (str.length() > 0)) {

                str = str.trim();

                if ((str.length() > 1) && str.endsWith("}")) {
                    if (str.contains("media")) {
                        listText.add(fixMediaQueryString(str + "}"));
                    } else {
                        listText.add(fixString(str));
                    }
                }
            }
        }

        return listText;
    }

    /**
     * Fix media query string.
     *
     * @param css
     *            the css
     * @return the string
     */
    private static String fixMediaQueryString(String css) {

        String stringFixed = "";
        int app = 0;

        String[] b = css.split("\\ ");

        for (int i = 0; i < b.length; i++) {

            String split = b[i];

            if (!split.startsWith("filter:") && !split.startsWith("-ms")
                    && !split.startsWith("-moz") && !split.startsWith("*") 
                    && !split.startsWith("-webkit") && (app == 0)) {
                app = 0;
                stringFixed += " " + b[i];
            } else if (app == 1) {
                app = 0;
            } else {
                app = 1;
            }
        }

        int counter = countChar(stringFixed, "{");
        int counter1 = countChar(stringFixed, "}");

        if (counter < counter1) {
            stringFixed = stringFixed.replace("}}", "}");
        }

        return stringFixed.trim();
    }

    /**
     * Fix string.
     *
     * @param css
     *            the css
     * @return the string
     */
	private static String fixString(String css) {

		String stringFixed = "";
		String result = "";

		String[] b = css.split("\\{");

		if (b.length != 1) {

			String str = b[1];

			String[] strSpli = str.split(";");

			for (int i = 0; i < strSpli.length; i++) {

				String split = strSpli[i];

				if (!split.startsWith("filter:") && !split.startsWith("-ms")
						&& !split.startsWith("-moz") && !split.startsWith("*") 
						&& !split.startsWith("-webkit")) {
					if (split.contains("url(")) {
						stringFixed += split.replace("\\", "").trim();
					} else {
						stringFixed += split.replace("\\", "").replace("/", "")
								.trim();
					}

					if (!stringFixed.endsWith("}")) {
						stringFixed += ";";
					}
				} else if (split.endsWith("}")) {
					stringFixed += "}";
				}

			}
			result = b[0] + "{" + stringFixed.trim();
		}

		return result;
	}

    /**
     * Count char.
     *
     * @param str
     *            the str
     * @param str1
     *            the str1
     * @return the int
     */
    private static int countChar(String str, String str1) {

        int occurrences = 0;
        for (char c : str.toCharArray()) {
            if (c == str1.charAt(0)) {
                occurrences++;
            }
        }
        return occurrences;
    }
}
