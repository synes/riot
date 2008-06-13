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
 *   flx
 *
 * ***** END LICENSE BLOCK ***** */
package org.riotfamily.components.riot.dao;

import java.util.Collection;

import org.riotfamily.components.dao.ComponentDao;
import org.riotfamily.components.model.ComponentList;
import org.riotfamily.riot.dao.ListParams;
import org.riotfamily.riot.dao.support.RiotDaoAdapter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.dao.DataAccessException;
import org.springframework.util.Assert;

/**
 * @author flx
 * @since 6.4
 */
public class DirtyComponentListDao extends RiotDaoAdapter
		implements InitializingBean {

	private ComponentDao componentDao;

	public DirtyComponentListDao() {
	}

	public void setComponentDao(ComponentDao componentDao) {
		this.componentDao = componentDao;
	}

	public void afterPropertiesSet() throws Exception {
		Assert.notNull(componentDao, "A ComponentDao must be set");
	}

	public Collection list(Object parent, ListParams params)
			throws DataAccessException {

		return componentDao.findDirtyComponentLists();
	}

	public String getObjectId(Object entity) {
		return ((ComponentList) entity).getId().toString();
	}

	public Object load(String id) throws DataAccessException {
		return componentDao.loadComponentList(new Long(id));
	}
}