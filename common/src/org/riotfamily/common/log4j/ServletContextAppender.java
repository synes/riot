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
package org.riotfamily.common.log4j;

import javax.servlet.ServletContext;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

/**
 * Log4J Appender implementation that logs messages by calling 
 * {@link javax.servlet.ServletContext#log(java.lang.String)
 * ServletContext.log()}. 
 * 
 * NOTE: Since the appender needs a reference to the ServletContext you must 
 * either add the 
 * @link org.riotfamily.common.log4j.ServletContextAppenderListener
 * to your web.xml or put the 
 * @link org.riotfamily.common.log4j.ServletContextAppenderConfigurer
 * into your ApplicationContext.
 */
public class ServletContextAppender extends AppenderSkeleton {

    protected static ServletContext servletContext;

    public static void setContext(ServletContext context) {
        servletContext = context;
    }

    protected void append(final LoggingEvent event) {
    	String msg = layout.format(event);
        if (servletContext == null) {
            System.out.println(msg);
        }
        else {
        	servletContext.log(msg);
        }
    }

    public boolean requiresLayout() {
        return true;
    }

    public void close() {
    }
}