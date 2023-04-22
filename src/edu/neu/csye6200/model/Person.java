/**
 * 
 */
package edu.neu.csye6200.model;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author pnakave
 *
 */
public abstract class Person {
	public static int id;
	public String firstName;
	public String lastName;
	
	public Person() {
		
	}
	
	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
}
