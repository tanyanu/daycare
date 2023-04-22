package edu.neu.csye6200.model;

/**
 * 
 */

import java.util.ArrayList;
import java.util.List;

import edu.neu.csye6200.controller.GroupHelper;


/**
 * @author pratiknakave
 *
 */
public class DayCare {

	private static List<Classroom> classList = new ArrayList<>();
	private static List<Student> studentsList = new ArrayList<>();
	private static List<Teacher> teachersList = new ArrayList<>();


	public static List<Student> getStudentsList() {
		return studentsList;
	}

	public static void setStudentsList(List<Student> studentsList) {
		DayCare.studentsList = studentsList;
	}

	public static List<Teacher> getTeachersList() {
		return teachersList;
	}

	public static void setTeachersList(List<Teacher> teachersList) {
		DayCare.teachersList = teachersList;
	}

	public static void addClassroom(Classroom c) {
		classList.add(c);
	}

	public static List<Classroom> getClassList() {
		return classList;
	}

	public static void setClassList(List<Classroom> classList) {
		DayCare.classList = classList;
	}

	public static void show() {
		classList.forEach(c -> {
			System.out.println();
			System.out.println(c);
		});
	}

	public static List<Classroom> getClassroom() {
		return classList;
	}

	public static void demo() throws Exception {

		
	}
}

