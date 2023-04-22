package edu.neu.csye6200.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.neu.csye6200.model.Classroom;
import edu.neu.csye6200.model.Group;

public class ClassGroupDaoImpl {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	private Connection getConnection() throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost/daycare?" + "user=root&password=password");
			return connection;

		} catch (Exception e) {
			throw e;
		}
	}

	public int createGroup(Group group) throws Exception {
		connection = getConnection();
		preparedStatement = connection.prepareStatement(
				"insert into daycare.studentGroup(group_id, group_size, students_enrolled ) values (default, ?,? )",
				Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setInt(1, group.getGroupSize());
		preparedStatement.setInt(2, group.getStudentsEnrolled());
		preparedStatement.executeUpdate();
		resultSet = preparedStatement.getGeneratedKeys();
		int groupId = 0;
		while (resultSet.next()) {
			groupId = resultSet.getInt(1);
		}
		System.out.println("Group created");
		return groupId;
	}

	public int createClassroom(Classroom classroom) throws Exception {
		connection = getConnection();
		preparedStatement = connection.prepareStatement(
				"insert into daycare.classroom(class_id, no_of_groups, groups_enrolled ) values (default, ?,? )",
				Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setInt(1, classroom.getGroupsAllowed());
		preparedStatement.setInt(2, classroom.getGroupsEnrolled());
		preparedStatement.executeUpdate();
		resultSet = preparedStatement.getGeneratedKeys();
		int classId = 0;
		while (resultSet.next()) {
			classId = resultSet.getInt(1);
		}
		System.out.println("Classroom created");
		return classId;
	}

	public List<Classroom> getClassRooms() throws Exception {
		connection = getConnection();
		preparedStatement = connection.prepareStatement("select * from daycare.classroom ");
		resultSet = preparedStatement.executeQuery();
		return writeClassroomResultset(resultSet);
	}



	public void assignClassroom(int studentId, int teacherId, int classId, int groupId) throws Exception {
		connection = getConnection();
		preparedStatement = connection.prepareStatement(
				"insert into daycare.ClassroomGroupMapping(class_group_id, classroom_id, group_id, student_id, teacher_id ) values"
						+ " (default, ?,?, ?,? )");
		preparedStatement.setInt(1, classId);
		preparedStatement.setInt(2, groupId);
		preparedStatement.setInt(3, studentId);
		preparedStatement.setInt(4, teacherId);
		preparedStatement.executeUpdate();
		System.out.println("Assigned Student to ClassRoom");
	}
	
	public List<Group> getGroupInfo() throws Exception {
		connection = getConnection();
		preparedStatement = connection.prepareStatement(" select sg.group_id, cls.class_id,  cm.teacher_id, sg.students_enrolled  from ClassroomGroupMapping cm "
				+ "    join studentgroup sg on sg.group_id = cm.group_id "
				+ "	join classroom cls on cls.class_id = cm.classroom_id "
				+ "    group by sg.group_id, cls.class_id,  cm.teacher_id, sg.students_enrolled ");
		resultSet = preparedStatement.executeQuery();
		return writeGroupsResultset(resultSet);
	}

	private List<Classroom> writeClassroomResultset(ResultSet resultSet) throws SQLException {
		Classroom classroom = null;
		List<Classroom> rooms = new ArrayList<>();
		while (resultSet.next()) {
			classroom = new Classroom(resultSet.getInt("class_id"), resultSet.getInt("no_of_groups"),
					resultSet.getInt("groups_enrolled"));
			rooms.add(classroom);
		}
		return rooms;
	}

	private List<Group> writeGroupsResultset(ResultSet resultSet) throws SQLException {
		List<Group> groups = new ArrayList<>();
		while (resultSet.next()) {
			Group group = new Group();
			group.setGroupId(resultSet.getInt("sg.group_id"));
			group.setClassId(resultSet.getInt("cls.class_id"));
			group.setTeacherId(resultSet.getInt("cm.teacher_id"));
			group.setStudentsEnrolled(resultSet.getInt("sg.students_enrolled"));
			groups.add(group);	
		}
		return groups;
	}


}
