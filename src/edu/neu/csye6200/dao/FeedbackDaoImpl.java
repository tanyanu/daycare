package edu.neu.csye6200.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import edu.neu.csye6200.model.Feedback;

/**
 * @author eraricamehra
 *
 */

public class FeedbackDaoImpl {
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
	
	public void addFeedback(Feedback feedback) throws Exception {
		connection = getConnection();
		preparedStatement = connection.prepareStatement(" insert into daycare.Feedback(feedback_id, employee_id, rating, review, last_feedback_date, next_feedback_date) values "
				+ " (default, ?, ?, ?, ?, ?)");
		preparedStatement.setInt(1, feedback.getEmployeeId());
		preparedStatement.setDouble(2, feedback.getRating());
		preparedStatement.setString(3, feedback.getReview());
		preparedStatement.setDate(4, Date.valueOf(feedback.getLastFeedBackDate()));
		preparedStatement.setDate(5, Date.valueOf(feedback.getNextFeedbackDate()));
		preparedStatement.executeUpdate();
		System.out.println("Feedback Given");
		
	}
	
	public List<Feedback> getAllReviewsOfTeacher(int teacherId) throws Exception {
		connection = getConnection();
		preparedStatement = connection.prepareStatement(" select * from daycare.Feedback where employee_id = ?");
		preparedStatement.setInt(1, teacherId);
		resultSet = preparedStatement.executeQuery();
		return writeResultSet(resultSet);
	}
	
	public List<Feedback> getAllReviews() throws Exception {
		connection = getConnection();
		preparedStatement = connection.prepareStatement(" select * from daycare.Feedback ");
		resultSet = preparedStatement.executeQuery();
		return writeResultSet(resultSet);
	}
	
	public LocalDate trackNextReviewdate(int teacherId) throws Exception {
		connection = getConnection();
		preparedStatement = connection.prepareStatement(
				" select * from daycare.feedback where employee_id = ? order by last_feedback_date desc limit 1");
		preparedStatement.setInt(1, teacherId);
		resultSet = preparedStatement.executeQuery();
		Feedback feedback = writeResultSet(resultSet).get(0);
		return feedback.getNextFeedbackDate();
	}
	
	private List<Feedback> writeResultSet(ResultSet resultSet) throws SQLException {
		Feedback feedback = null;
		List<Feedback> feedbackList = new ArrayList<>();
		while (resultSet.next()) {
			Date lastFeedbackdate = resultSet.getDate("last_feedback_date");
			Date nextFeedbackdate = resultSet.getDate("next_feedback_date");
			feedback = new Feedback(resultSet.getInt("employee_id"), resultSet.getString("review"),
					resultSet.getDouble("rating"), lastFeedbackdate.toLocalDate(), nextFeedbackdate.toLocalDate());
			feedbackList.add(feedback);
		}
		return feedbackList;
	}
	

}
