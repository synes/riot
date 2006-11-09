/* ***** BEGIN LICENSE BLOCK *****
 * Version: MPL 1.1
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 * 
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 * 
 * The Original Code is Riot.
 * 
 * The Initial Developer of the Original Code is
 * Neteye GmbH.
 * Portions created by the Initial Developer are Copyright (C) 2006
 * the Initial Developer. All Rights Reserved.
 * 
 * Contributor(s):
 *   Felix Gnass <fgnass@neteye.de>
 * 
 * ***** END LICENSE BLOCK ***** */
package org.riotfamily.pages.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.riotfamily.common.web.util.OncePerRequestInterceptor;
import org.riotfamily.riot.security.AccessController;

/**
 * Sets cache control headers to prevent client side caching if a Riot user 
 * is logged in. This is especially useful if the user modifies a page via
 * AJAX, leaves the page and hits the back button.
 * 
 * @author Felix Gnass <fgnass@neteye.de>
 */
public class NoCacheHeaderInterceptor extends OncePerRequestInterceptor {

	private static final String HEADER_PRAGMA = "Pragma";

	private static final String HEADER_EXPIRES = "Expires";

	private static final String HEADER_CACHE_CONTROL = "Cache-Control";
	
	protected boolean preHandleOnce(HttpServletRequest request, 
			HttpServletResponse response, Object handler) throws Exception {

		if (AccessController.isAuthenticatedUser()) {
			response.setHeader(HEADER_PRAGMA, "No-cache");
			response.setDateHeader(HEADER_EXPIRES, 1L);
			response.setHeader(HEADER_CACHE_CONTROL, "no-cache");
			response.addHeader(HEADER_CACHE_CONTROL, "no-store");
		}
		return true;
	}
}
