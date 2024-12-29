package com.cg.bus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.bus.Feedback;
import com.cg.bus.Users;
import com.cg.bus.exception.FeedbackAlreadyExist;
import com.cg.bus.exception.FeedbackNotFoundException;
import com.cg.bus.repository.IFeedbackRepository;

@Service
public class FeedbackService {

	@Autowired
	IFeedbackRepository feedrepo;

	public String addFeedBack(Feedback feedback) {
		Optional<Feedback> feed = feedrepo.findById(feedback.getFeedBackId());
		if (feed.isPresent()) {
			throw new FeedbackAlreadyExist("This feedback Id already exist .");
		} else {
			feedrepo.save(feedback);
			return "feedback record added successfully";
		}
	}

	public boolean deleteFeedbackByUser(Users user) {
		Optional<Feedback> use = feedrepo.findById(user.getUserLoginId());
		if(use.isPresent()) {
			use.get().setUsers(null);
			return true;
		}else {
			return false;
		}
	}
	public String updateFeedBack(Feedback feedback) {
		Optional<Feedback> feed = feedrepo.findById(feedback.getFeedBackId());
		if (feed.isPresent()) {
			feedrepo.save(feedback);
			return "Record updated successfully ";
		} else {
			throw new FeedbackNotFoundException("Connot update feedback because this feedback doesnot exists . ");
		}
	}

	public Feedback viewFeedback(int feedBackId) {
		Optional<Feedback> feedback = feedrepo.findById(feedBackId);
		if (feedback.isPresent()) {
			return feedrepo.findById(feedBackId).get();
		} else {
			throw new FeedbackNotFoundException("Feedback Id not found , Please enter correct Id .");
		}
	}

	public String deleteFeedback(int feedbackid) {
		Optional<Feedback> feed = feedrepo.findById(feedbackid);
		if(feed.isPresent()) {
			feed.get().setUsers(null);
			feedrepo.deleteById(feedbackid);
			
			return "Feedback with "+feedbackid+" feedback id is deleted";
		}
		else {
			throw new FeedbackNotFoundException("Feedback with this "+feedbackid+" is not found.");
		}
	}
	public List<Feedback> viewAllFeedBack() {
		return feedrepo.findAll();
	}

}