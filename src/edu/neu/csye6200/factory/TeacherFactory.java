/**
 * 
 */
package edu.neu.csye6200.factory;

import edu.neu.csye6200.model.Teacher;

/**
 * @author pnakave
 *
 */
public class TeacherFactory extends AbstractPersonFactory {

	private static TeacherFactory instance;
	private TeacherFactory() {
		instance = null;
	}
	public static TeacherFactory getInstance() {
		if(instance == null) {
			instance = new TeacherFactory();
		}
		
		return instance;
	}
	
	@Override
	public Teacher getObject(String csvData) {
		// TODO Auto-generated method stub
		return new Teacher(csvData);
	}

	@Override
	public Teacher getObject() {
		// TODO Auto-generated method stub
		return new Teacher();
	}

}
