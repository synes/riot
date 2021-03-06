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
package org.riotfamily.common.hibernate;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Abstract base class for {@link ActiveRecord}s with a generated 
 * <code>java.lang.Long</code> identifier and field access. 
 *   
 * @author Felix Gnass [fgnass at neteye dot de]
 * @since 8.0
 */
@MappedSuperclass
public abstract class ActiveRecordFieldSupport extends ActiveRecord 
		implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * Returns the identifier of this persistent instance.
	 * 
	 * @return this instance's identifier 
	 */
	public Long getId() {
		return id;
	}

}
