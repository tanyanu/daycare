package edu.neu.csye6200.model;

import java.math.BigInteger;


/**
 * @author eraricamehra
 *
 */
public class Parent  extends Person {
	
	private int parentId;
	private String email;
	private BigInteger phone;
	
	public Parent() {
		super();
	}
	
	public Parent(int parentId, String firstName, String lastName,String email, BigInteger phone) {
		super(firstName, lastName);
		this.parentId = parentId;
		this.email = email;
		this.phone = phone;
	}
	

	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public BigInteger getPhone() {
		return phone;
	}
	public void setPhone(BigInteger phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Parent [parentId=" + parentId + ", email=" + email + ", phone=" + phone + "]";
	}

}
