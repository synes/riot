/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.riotfamily.common.beans.namespace;

import java.util.Properties;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.xml.BeanDefinitionDecorator;
import org.springframework.beans.factory.xml.BeanDefinitionParserDelegate;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * BeanDefinitionDecorator that calls 
 * {@link BeanDefinitionParserDelegate#parsePropsElement(Element)
 * delegate.parsePropsElement()} and sets the result as property. 
 * 
 * @author Felix Gnass [fgnass at neteye dot de]
 * @since 6.5
 */
public class PropsDecorator implements BeanDefinitionDecorator {

	private String propertyName;

	public PropsDecorator(String propertyName) {
		this.propertyName = propertyName;
	}

	public BeanDefinitionHolder decorate(Node node,
			BeanDefinitionHolder definition, ParserContext parserContext) {

		BeanDefinition bd = definition.getBeanDefinition();
		Properties props = parserContext.getDelegate().parsePropsElement((Element) node);
		bd.getPropertyValues().addPropertyValue(propertyName, props);
		return definition;
	}
}
