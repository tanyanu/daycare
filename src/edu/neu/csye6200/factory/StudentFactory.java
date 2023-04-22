/**
 * 
 */
package edu.neu.csye6200.factory;

import edu.neu.csye6200.model.Student;

/**
 * @author pnakave
 *
 */
public class StudentFactory extends AbstractPersonFactory {
	
	private static StudentFactory instance;
	private StudentFactory() {
		instance = null;
	}
	public static StudentFactory getInstance() {
		if(instance == null) {
			instance = new StudentFactory();
		}
		
		return instance;
	}

	@Override
	public Student getObject(String csvData) {
		// TODO Auto-generated method stub
		return new Student(csvData);
	}

	@Override
	public Student getObject() {
		// TODO Auto-generated method stub
		return new Student();
	}

}
