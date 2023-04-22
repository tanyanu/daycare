package edu.neu.csye6200.model;

import java.time.LocalDate;

/**
 * @author eraricamehra
 *
 */
public class Feedback {

	private int employeeId;
	private String review;
	private double rating;
	private LocalDate lastFeedBackDate;
	private LocalDate nextFeedbackDate;

	public Feedback(int employeeId, String review, double rating, LocalDate lastFeedBackDate,
			LocalDate nextFeedbackDate) {
		super();
		this.employeeId = employeeId;
		this.review = review;
		this.rating = rating;
		this.lastFeedBackDate = lastFeedBackDate;
		this.nextFeedbackDate = nextFeedbackDate;
	}

	public Feedback() {
		super();
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public LocalDate getLastFeedBackDate() {
		return lastFeedBackDate;
	}

	public void setLastFeedBackDate(LocalDate lastFeedBackDate) {
		this.lastFeedBackDate = lastFeedBackDate;
	}

	public LocalDate getNextFeedbackDate() {
		return nextFeedbackDate;
	}

	public void setNextFeedbackDate(LocalDate nextFeedbackDate) {
		this.nextFeedbackDate = nextFeedbackDate;
	}

	@Override
	public String toString() {
		return "Feedback [employeeId=" + employeeId + ", review=" + review + ", rating=" + rating
				+ ", lastFeedBackDate=" + lastFeedBackDate + ", nextFeedbackDate=" + nextFeedbackDate + "]";
	}

}
