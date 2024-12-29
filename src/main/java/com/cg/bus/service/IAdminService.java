package com.cg.bus.service;

import com.cg.bus.Bus;
import com.cg.bus.Feedback;
import com.cg.bus.Route;

public interface IAdminService {

	public String addBus(Bus bus);
	public String deleteBus(int busid);
	public String addRoute(Route route);
	public String deleteRoute(int routeid);
	public String updateRoute(Route route);
	public String deleteFeedback(int feedbackid);
	public Feedback viewFeedback(int feedbackid);
	public String deleteUser(int userid);
}
