package com.cg.bus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bus.Feedback;
import com.cg.bus.service.FeedbackService;
@RestController
public class FeedbackController {

	@Autowired FeedbackService feedser;
    
    @RequestMapping(value = "/addfeedback", method=RequestMethod.POST)
     public String addFeedBack(@RequestBody Feedback feedback) 
    {
         return feedser.addFeedBack(feedback);
    }
    
    @RequestMapping(value = "/updfeedback", method=RequestMethod.PUT)
     public String updateFeedBack(@RequestBody Feedback feedback) 
    {
         return feedser.updateFeedBack(feedback);
    }
    
    @RequestMapping(value = "/getfeedbackbyid/{feedbackid}",method=RequestMethod.GET)
     public Feedback getfeedback(@PathVariable("feedbackid")int feedbackid) 
    {
         return feedser.viewFeedback(feedbackid);
    }
    
    @RequestMapping(value="/getallfeedback",method=RequestMethod.GET)
    public java.util.List<Feedback> getAllFeedBack()
    {
        return feedser.viewAllFeedBack();



    }
}
