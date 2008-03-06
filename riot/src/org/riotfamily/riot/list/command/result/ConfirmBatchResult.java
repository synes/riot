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
 *   flx
 * 
 * ***** END LICENSE BLOCK ***** */
package org.riotfamily.riot.list.command.result;

import org.riotfamily.riot.list.command.CommandResult;
import org.riotfamily.riot.list.command.CommandState;

/**
 * @author Felix Gnass [fgnass at neteye dot de]
 * @since 6.4
 */
public class ConfirmBatchResult implements CommandResult {

	public static final String ACTION = "confirmBatch";
	
	private CommandState command;
	
	private String message;

	
	public ConfirmBatchResult(CommandState command, String message) {
		this.command = command;
		this.message = message;
	}

	public String getAction() {
		return ACTION;
	}
	
	public CommandState getCommand() {
		return this.command;
	}

	public String getMessage() {
		return this.message;
	}
	
}