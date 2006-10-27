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
package org.riotfamily.forms.element;

import org.riotfamily.forms.Element;
import org.riotfamily.forms.element.support.select.Option;
import org.riotfamily.forms.element.support.select.OptionsModel;

/**
 * Interface to be implemented by elements that provide options the user
 * can choose from.
 */
public interface SelectElement extends Element {
		
	public String getParamName();
	
	public void renderOption(Option option);

	public boolean isSelected(Option option);
	
	public void setOptionsModel(OptionsModel model);
	
	public int getOptionIndex(Option option);

}