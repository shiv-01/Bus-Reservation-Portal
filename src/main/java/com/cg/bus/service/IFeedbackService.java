package com.cg.bus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.bus.Feedback;

@Service
public interface IFeedbackService {

	public String addFeedBack(Feedback feedback);
    public String updateFeedBack(Feedback feedback);
    public Feedback viewFeedback(int feedBackId);
    public String deleteFeedback(int feedbackid);
    public List<Feedback> viewAllFeedBack();
}
