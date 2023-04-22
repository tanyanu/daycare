/**
 * 
 */
package edu.neu.csye6200.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pnakave
 *
 */
public class Classroom {

	private int classId;
	private int groupsAllowed;
	private int groupsEnrolled;
	List<Group> groups = new ArrayList<>();
	static int id = 0;
	private int idC = 0;
	
	public Classroom() {
		id++;
		idC = id;
	}
	
	public Classroom(int classId, List<Group> groups, int groupsAllowed, int groupsEnrolled, int idC) {
		super();
		this.classId = classId;
		this.groups = groups;
		this.groupsAllowed = groupsAllowed;
		this.groupsEnrolled = groupsEnrolled;
	}
	
	public Classroom(int classId, int groupsAllowed, int groupsEnrolled) {
		super();
		this.classId = classId;
		this.groupsAllowed = groupsAllowed;
		this.groupsEnrolled = groupsEnrolled;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public int getGroupsAllowed() {
		return groupsAllowed;
	}

	public void setGroupsAllowed(int groupsAllowed) {
		this.groupsAllowed = groupsAllowed;
	}

	public int getGroupsEnrolled() {
		return groupsEnrolled;
	}

	public void setGroupsEnrolled(int groupsEnrolled) {
		this.groupsEnrolled = groupsEnrolled;
	}

	public int getIdC() {
		return idC;
	}

	public void setIdC(int idC) {
		this.idC = idC;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public static void setId(int id) {
		Classroom.id = id;
	}

	public Classroom(List<Group> groups, int idC) {
		super();
		this.groups = groups;
		this.idC = idC;
	}
	
	public int getId() {
		return idC;
	}
	public void setGroups(Group g) {
		groups.add(g);
	}
	public List<Group> getGroups() {
		return this.groups;
	}
	
	@Override
	public String toString() {
		return "Classroom [classId=" + classId + ", groups=" + groups +"]";
	}
}
