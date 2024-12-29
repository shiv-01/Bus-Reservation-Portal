package com.cg.bus.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bus.Bus;
import com.cg.bus.Feedback;
import com.cg.bus.Route;
import com.cg.bus.Users;
import com.cg.bus.exception.BusAlreadyExistException;
import com.cg.bus.exception.FeedbackNotFoundException;
import com.cg.bus.exception.RouteAlreadyExistException;
import com.cg.bus.exception.RouteNotFoundException;
import com.cg.bus.exception.UserNotFoundException;
import com.cg.bus.repository.IBusRepository;
import com.cg.bus.repository.IFeedbackRepository;
import com.cg.bus.repository.IRouteRepository;
import com.cg.bus.repository.IUserRepository;
@Service
public class AdminService implements IAdminService {
	
	@Autowired IBusRepository busrep;
	@Autowired IRouteRepository routerep;
	@Autowired IFeedbackRepository feedrepo;
	@Autowired IUserRepository userrepo;
	
	@Override
	public String addBus(Bus bus) {
		Optional<Bus> b = busrep.findById(bus.getBusId());
		if(b.isPresent()) {
			throw new BusAlreadyExistException("Bus with this "+bus.getBusId()+" is already exist");
		}
		else {
			busrep.save(bus);
			return "Bus added by admin successfully";
		}
	}

	@Override
	public String deleteBus(int busid) {
		Optional<Bus> b = busrep.findById(busid);
		if(b.isPresent()) {
			busrep.deleteById(busid);
			return "Bus with "+busid+" bus id deleted by admin";
		}
		else {
			throw new BusAlreadyExistException("Bus with this "+busid+" is not exist");
		}
	}

	@Override
	public String addRoute(Route route) {
		Optional<Route> rout = routerep.findById(route.getRouteId());
		if(rout.isPresent()) {
			throw new RouteAlreadyExistException("The route with "+route.getRouteId()+" route id is already exist");
		}
		routerep.save(route);
		return "Route Added by admin Successfully";
	}

	@Override
	public String deleteRoute(int routeid) {
		Optional<Route> rout = routerep.findById(routeid);
		if(rout.isPresent()) {
			routerep.deleteById(routeid);
			return "Route of "+routeid+" route id deleted by admin successfully";
		}
		else {
			throw new RouteNotFoundException("The route with "+routeid+" route id is not exist");
		}
	}

	@Override
	public String updateRoute(Route route) {
		Optional<Route> rout = routerep.findById(route.getRouteId());
		if(rout.isPresent()) {
			routerep.save(route);
			return "Route Updated Successfully";
		}
		else {
			throw new RouteNotFoundException("The route with "+route.getRouteId()+" route id is not exist");
		}
	}

	public Route viewRoute(int routeid) {
		Optional<Route> route = routerep.findById(routeid);
		if(route.isPresent()) {
			return routerep.findById(routeid).get();
		}
		else {
			throw new RouteNotFoundException("Route for this id " + routeid + " not found");
		}	
		
	}
	
	@Override
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

	@Override
	public Feedback viewFeedback(int feedbackid) {
		Optional<Feedback> feedback = feedrepo.findById(feedbackid);
		if (feedback.isPresent()) {
			return feedrepo.findById(feedbackid).get();
		} else {
			throw new FeedbackNotFoundException("Feedback Id not found , Please enter correct Id .");
		}
	}

	@Override
	public String deleteUser(int userid) {
		Optional<Users> user = userrepo.findById(userid);
		if(user.isPresent()) {
			user.get().setReservation(null);
			userrepo.deleteById(userid);
			return "User with "+userid+" user id is deleted";
		}
		else {
			throw new UserNotFoundException("User with this "+userid+" is not found.");
		}
	}
}
