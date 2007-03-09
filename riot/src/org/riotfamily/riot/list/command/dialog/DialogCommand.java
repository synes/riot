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
 * Portions created by the Initial Developer are Copyright (C) 2007
 * the Initial Developer. All Rights Reserved.
 * 
 * Contributor(s):
 *   Felix Gnass [fgnass at neteye dot de]
 * 
 * ***** END LICENSE BLOCK ***** */
package org.riotfamily.riot.list.command.dialog;

import org.riotfamily.forms.Form;
import org.riotfamily.riot.list.command.CommandContext;
import org.riotfamily.riot.list.command.CommandResult;
import org.riotfamily.riot.list.command.dialog.ui.DialogFormController;
import org.riotfamily.riot.list.command.result.GotoUrlResult;
import org.riotfamily.riot.list.command.support.AbstractCommand;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Felix Gnass [fgnass at neteye dot de]
 * @since 6.4
 */
public abstract class DialogCommand extends AbstractCommand 
		implements ApplicationContextAware {

	private DialogFormController dialogFormController;
	
	public final void setApplicationContext(ApplicationContext context) {
		dialogFormController = (DialogFormController) BeanFactoryUtils
				.beanOfType(context, DialogFormController.class);
	}

	public final CommandResult execute(CommandContext context) {
		context.getRequest().getSession().setAttribute(
				getFormSessionAttribute(), createForm(context.getBean()));
		
		String url = dialogFormController.getUrl(
				context.getListDefinition().getId(),
				context.getObjectId(), getId());
		
		return new GotoUrlResult(context, url);
	}
	
	public String getFormSessionAttribute() {
		return getClass().getName() + ".form";
	}
	
	public abstract Form createForm(Object bean);
	
	public abstract ModelAndView handleInput(Object input);
	
}
