package com.cg.bus;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

 

@Entity
@Table(name="feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="feedbackid")
    private int feedBackId;
    @Column(name="driverrating")
    private int driverRating;
    @Column(name="servicerating")
    private int serviceRating;
    @Column(name="overallrating")
    private int overallRating;
    @Column(name="comments")
    private String comments;
    @Column(name="feedbackdate")
    private String feedbackdate;
    @OneToOne
    private Users users;
    @ManyToOne
    private Bus bus;
    public int getFeedBackId() {
        return feedBackId;
    }
    public void setFeedBackId(int feedBackId) {
        this.feedBackId = feedBackId;
    }
    public int getDriverRating() {
        return driverRating;
    }
    public void setDriverRating(int driverRating) {
        this.driverRating = driverRating;
    }
    public int getServiceRating() {
        return serviceRating;
    }
    public void setServiceRating(int serviceRating) {
        this.serviceRating = serviceRating;
    }
    public int getOverallRating() {
        return overallRating;
    }
    public void setOverallRating(int overallRating) {
        this.overallRating = overallRating;
    }
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
    public String getFeedbackdate() {
        return feedbackdate;
    }
    public void setFeedbackdate(String feedbackdate) {
        this.feedbackdate = feedbackdate;
    }
    public Users getUsers() {
        return users;
    }
    public void setUsers(Users users) {
        this.users = users;
    }
    public Bus getBus() {
        return bus;
    }
    public void setBus(Bus bus) {
        this.bus = bus;
    }
    
    public Feedback() { }
    public Feedback(int feedBackId, int driverRating, int serviceRating, int overallRating, String comments,
            String feedbackdate, Users users, Bus bus) 
    {
        this.feedBackId = feedBackId;
        this.driverRating = driverRating;
        this.serviceRating = serviceRating;
        this.overallRating = overallRating;
        this.comments = comments;
        this.feedbackdate = feedbackdate;
        this.users = users;
        this.bus = bus;
    }
}
 