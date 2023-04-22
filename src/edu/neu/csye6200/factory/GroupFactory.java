/**
 * 
 */
package edu.neu.csye6200.factory;

import edu.neu.csye6200.model.Group;

/**
 * @author pnakave
 *
 */
public class GroupFactory {

	private static GroupFactory instance;
	private GroupFactory() {
		instance = null;
	}
	public static GroupFactory getInstance() {
		if(instance == null) {
			instance = new GroupFactory();
		}
		
		return instance;
	}
	
	public Group getObject() {
		return new Group();
	}
}
