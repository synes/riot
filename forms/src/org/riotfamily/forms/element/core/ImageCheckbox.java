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
package org.riotfamily.forms.element.core;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.riotfamily.forms.element.DHTMLElement;
import org.riotfamily.forms.resource.ResourceElement;
import org.riotfamily.forms.resource.Resources;
import org.riotfamily.forms.resource.ScriptResource;
import org.riotfamily.forms.resource.ScriptSequence;

public class ImageCheckbox extends Checkbox 
		implements DHTMLElement, ResourceElement  {
	
	private static final List RESOURCES = Collections.singletonList(
			new ScriptSequence(new ScriptResource[] {
				Resources.PROTOTYPE, Resources.RIOT_IMAGE_CHECKBOX 
			}));
	
	private static final String STYLE_CLASS = "hidden";
	
	public ImageCheckbox() {
		setStyleClass(STYLE_CLASS);
	}
	
	public Collection getResources() {
		return RESOURCES;
	}
	
	public String getPrecondition() {		
		return "ImageCheckbox";
	}
	
	public String getInitScript() {
		StringBuffer sb = new StringBuffer();
		sb.append("new ImageCheckbox('");
		sb.append(getId());
		sb.append("', '");
		sb.append(getEditorBinding().getProperty());
		sb.append("');");
		return sb.toString();
	}

}
