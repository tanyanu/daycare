/**
 * 
 */
package edu.neu.csye6200.model;

import java.time.LocalDate;

import edu.neu.csye6200.util.ConversionUtil;

/**
 * @author pnakave
 *
 */
public class Teacher extends Person {

	private int employeeId;
	private String emailID;
	private LocalDate joiningDate;
	private LocalDate annualReviewDate;

	public Teacher() {
		super();
	}

	public Teacher(int employeeId, String firstName, String lastName, String emailID, LocalDate joiningDate) {
		super(firstName, lastName);
		this.employeeId = employeeId;
		this.joiningDate = joiningDate;
		this.annualReviewDate  = joiningDate.plusYears(1);
		this.emailID = emailID;
	}

	public Teacher(String csvData) {
		super();
		String[] field = csvData.split(",");
		this.employeeId = Integer.parseInt(field[0]);
		this.firstName = field[1];
		this.lastName = field[2];
		this.joiningDate =ConversionUtil.StringToLocalDate(field[3]);
		this.emailID = field[4];
		this.annualReviewDate  = joiningDate.plusYears(1);
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public LocalDate getAnnualReviewDate() {
		return annualReviewDate;
	}

	public void setAnnualReviewDate(LocalDate annualReviewDate) {
		this.annualReviewDate = annualReviewDate;
	}

	@Override
	public String toString() {
		return this.firstName + " " + this.lastName;
	}
}
