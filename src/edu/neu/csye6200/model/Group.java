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



public class Group {
	
    private int groupId;
    private int teacherId;
	private int classId;
	private int groupSize;
	private int studentsEnrolled;
	private Teacher teacher;
	private List<Student> students = new ArrayList<>();

    public Group() {
    	
    }
	public Group(int groupSize, int studentsEnrolled) {
		this.groupSize = groupSize;
		this.studentsEnrolled = studentsEnrolled;
	}
	
	public Group(Teacher teacher, List<Student> students, int groupSize) {
		super();
		this.teacher = teacher;
		this.students = students;
		this.groupSize = groupSize;
		this.studentsEnrolled = students.size();
	}
	
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public int getGroupSize() {
		return groupSize;
	}
	public void setGroupSize(int groupSize) {
		this.groupSize = groupSize;
	}
	
	
	public int getStudentsEnrolled() {
		return studentsEnrolled;
	}

	public void setStudentsEnrolled(int studentsEnrolled) {
		this.studentsEnrolled = studentsEnrolled;
	}
	
	public void addStudents(Student s) {
		students.add(s);
	}
	
	public void assignTeacher(Teacher t) {
		teacher = t;
	}
	
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	@Override
	public String toString() {
		return "Group [groupId=" + groupId + ", teacherId=" + teacherId + ", classId=" + classId + ", groupSize="
				+ groupSize + ", studentsEnrolled=" + studentsEnrolled + ", teacher=" + teacher + ", students="
				+ students + "]";
	}
	
}
