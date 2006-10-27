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

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

import org.riotfamily.common.markup.Html;
import org.riotfamily.common.markup.TagWriter;
import org.riotfamily.forms.bind.Editor;
import org.riotfamily.forms.element.support.AbstractEditorBase;


/**
 * A Checkbox widget.
 */
public class Checkbox extends AbstractEditorBase implements Editor {

	private static final String TYPE_CHECKBOX = "checkbox";

	private boolean checked;

	private Object checkedValue = Boolean.TRUE;
	
	private Object uncheckedValue = Boolean.FALSE;

	
	public Checkbox() {
		setStyleClass(TYPE_CHECKBOX);
	}

	/**
	 * Sets the value representing the element's checked state. Defaults to 
	 * <code>Boolean.TRUE</code>
	 */
	public void setCheckedValue(Object checkedValue) {
		this.checkedValue = checkedValue;
	}
	
	/**
	 * Sets the value representing the element's unchecked state. Defaults to 
	 * <code>Boolean.FALSE</code>
	 */
	public void setUncheckedValue(Object uncheckedValue) {
		this.uncheckedValue = uncheckedValue;
	}
	
	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public boolean isChecked() {
		return checked;
	}

	public void renderInternal(PrintWriter writer) {
		TagWriter inputTag = new TagWriter(writer);
		inputTag.startEmpty(Html.INPUT)
				.attribute(Html.INPUT_TYPE, TYPE_CHECKBOX)
				.attribute(Html.INPUT_NAME, getParamName())
				.attribute(Html.COMMON_ID, getId())
				.attribute(Html.COMMON_CLASS, getStyleClass())
				.attribute(Html.INPUT_CHECKED, checked)
				.end();
	}

	/**
	 * @see Editor#setValue(Object)
	 */
	public void setValue(Object value) {
		this.checked = checkedValue.equals(value);
	}

	/**
	 * Returns the checked or unchecked value depending on the element's state.
	 * 
	 * @see org.riotfamily.forms.bind.Editor#getValue()
	 * @see #setCheckedValue(Object)
	 * @see #setUncheckedValue(Object)
	 * @see #isChecked()
	 */
	public Object getValue() {
		return checked ? checkedValue : uncheckedValue;
	}
	
	public void processRequest(HttpServletRequest request) {
		Object newValue = request.getParameter(getParamName());
		checked = newValue != null;
	}

}