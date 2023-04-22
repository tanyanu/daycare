package edu.neu.csye6200.controller;

import java.util.List;

import edu.neu.csye6200.dao.TeacherDaoImpl;
import edu.neu.csye6200.model.DayCare;
import edu.neu.csye6200.model.Teacher;
import edu.neu.csye6200.util.FileUtil;
/**
 * @author eraricamehra
 *
 */
public class TeacherService {
	
	public int registerTeacher(Teacher teacher) throws Exception {
		TeacherDaoImpl impl = new TeacherDaoImpl();
		DayCare.getTeachersList().add(teacher);
		return impl.addTeacher(teacher);
	}
	
	public void registerTeacherFromCSV() throws Exception {
		List<String> teacherCSVData = FileUtil.readTextFile("resources/teachers.txt");
		Teacher teacher = null;
		TeacherDaoImpl impl = new TeacherDaoImpl();
		for (String csvString : teacherCSVData) {
			teacher = new Teacher(csvString);
			DayCare.getTeachersList().add(teacher);
			impl.addTeacher(teacher);
		}
	}
	
	public void deleteTeacher(int teacherId) throws Exception {
		TeacherDaoImpl impl = new TeacherDaoImpl();
		impl.deleteTeacher(teacherId);
	}
	
	public void updateTeacher(Teacher teacher) throws Exception {
		TeacherDaoImpl impl = new TeacherDaoImpl();
		impl.updateTeacher(teacher);
	}
	
	public List<Teacher> getAllTeachers() throws Exception {
		TeacherDaoImpl impl = new TeacherDaoImpl();
		return impl.getAllTeachers();
	}

}
