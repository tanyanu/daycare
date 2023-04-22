package edu.neu.csye6200.controller;

import java.time.LocalDate;
import java.util.List;

import edu.neu.csye6200.dao.FeedbackDaoImpl;
import edu.neu.csye6200.model.Feedback;
import edu.neu.csye6200.model.Teacher;

/**
 * @author eraricamehra
 *
 */
public class FeedbackService {

	public void addFeedback(Feedback feedback) throws Exception {
		FeedbackDaoImpl feedbackDao = new FeedbackDaoImpl();
		feedbackDao.addFeedback(feedback);
	}

	public List<Feedback> getAllReviewsOfTeacher(Teacher teacher) throws Exception {
		FeedbackDaoImpl feedbackDao = new FeedbackDaoImpl();
		return feedbackDao.getAllReviewsOfTeacher(teacher.getEmployeeId());
	}

	public List<Feedback> getAllTeacherReviews() throws Exception {
		FeedbackDaoImpl feedbackDao = new FeedbackDaoImpl();
		return feedbackDao.getAllReviews();
	}

	public LocalDate trackNextReviewdate(Teacher teacher) throws Exception {
		FeedbackDaoImpl feedbackDao = new FeedbackDaoImpl();
		return feedbackDao.trackNextReviewdate(teacher.getEmployeeId());
	}

}
