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
package org.riotfamily.components.controller;

import org.riotfamily.components.config.ComponentRepository;
import org.riotfamily.components.dao.ComponentDao;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author Felix Gnass [fgnass at neteye dot de]
 * @since 6.5
 */
public class ComponentControllerPostProcessor implements BeanPostProcessor {
	
	private ComponentDao componentDao;

	private ComponentRepository repository;

	private PlatformTransactionManager transactionManager;
	

	public void setComponentDao(ComponentDao componentDao) {
		this.componentDao = componentDao;
	}

	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	public void setRepository(ComponentRepository repository) {
		this.repository = repository;
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		
		if (bean instanceof ComponentController) {
			initController((ComponentController) bean);
		}
		return bean;
	}
	
	private void initController(ComponentController controller) {
		controller.setTransactionManager(transactionManager);
		if (controller.getComponentDao() == null) {
			controller.setComponentDao(componentDao);
		}
		if (controller.getComponentRepository() == null) {
			controller.setComponentRepository(repository);
		}
	}
	
	public Object postProcessAfterInitialization(Object bean, String beanName) 
			throws BeansException {
		
		return bean;
	}

}
