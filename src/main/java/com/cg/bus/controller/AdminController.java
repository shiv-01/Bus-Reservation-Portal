package com.cg.bus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bus.Bus;
import com.cg.bus.Feedback;
import com.cg.bus.Route;
import com.cg.bus.exception.RouteNotFoundException;
import com.cg.bus.service.AdminService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class AdminController {

	@Autowired AdminService adminservice;
	
	@RequestMapping(value = "/addbusbyadmin", method=RequestMethod.POST)
	 public String addBusbyAdmin(@RequestBody Bus bus) {
		 return adminservice.addBus(bus);
	 }
	
	@RequestMapping(value = "/delbusbyadmin/{busid}", method = RequestMethod.DELETE)
	 public String deleteBus(@PathVariable("busid") int busid) {
		 return adminservice.deleteBus(busid); 	 
	 }
	
	@RequestMapping(value = "/addroutebyadmin", method = RequestMethod.POST)
	public String addRouteByAdmin(@RequestBody Route route) {
		return adminservice.addRoute(route);
	}
	
	@RequestMapping(value = "/delroutebyadmin/{routeid}", method = RequestMethod.DELETE)
	public String deleteRouteByAdmin(@PathVariable("routeid") int routeid) {
		Route route  = adminservice.viewRoute(routeid);
		route.setBus(null);
		adminservice.updateRoute(route);
		return adminservice.deleteRoute(routeid);
	}
	
	@RequestMapping(value = "/updroutebyadmin", method = RequestMethod.PUT)
	public String updateRouteByAdmin(@RequestBody Route route) {
		Route rout = adminservice.viewRoute(route.getRouteId());
		if(rout == null) {
			throw new RouteNotFoundException("This route does not exist");
		}
		return adminservice.updateRoute(route);
	}
	
	@RequestMapping(value = "/viewfeedbackwithidbyadmin/{feedbackid}",method=RequestMethod.GET)
    public Feedback getfeedback(@PathVariable("feedbackid")int feedbackid) 
   {
        return adminservice.viewFeedback(feedbackid);
   }
	
	 @RequestMapping(value = "/delfeedbackbyadmin/{feedbackid}", method = RequestMethod.DELETE)
	 public String deleteFeedbackByAdmin(@PathVariable("feedbackid") int feedbackid) {
		 return adminservice.deleteFeedback(feedbackid);
	 }
	 
	 @RequestMapping(value = "/deleteuser/{userid}", method = RequestMethod.DELETE)
	 public String deleteUser(@PathVariable("userid") int userid) {
		 return adminservice.deleteUser(userid);
	 }
	 
	 

	 
}
